# Implementing Authentication

## Setup

1. Create a new MongoDB database and save its URL string.
2. Create a new directory for your project.
3. Initialize the `package.json` file with `npm init`.
4. Install required dependencies:
   - `npm install express express-session mongoose passport passport-local ejs`

## MongoDB Update

- With Mongoose version 7.0.1, callbacks are no longer supported when querying the database. Use async/await or promises instead.

## `app.js` Setup

```javascript
const express = require("express");
const path = require("path");
const session = require("express-session");
const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;
const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const mongoDb = "YOUR MONGO URL HERE";
mongoose.connect(mongoDb, { useUnifiedTopology: true, useNewUrlParser: true });
const db = mongoose.connection;
db.on("error", console.error.bind(console, "mongo connection error"));

const User = mongoose.model(
  "User",
  new Schema({
    username: { type: String, required: true },
    password: { type: String, required: true }
  })
);

const app = express();
app.set("views", __dirname);
app.set("view engine", "ejs");

app.use(session({ secret: "cats", resave: false, saveUninitialized: true }));
app.use(passport.initialize());
app.use(passport.session());
app.use(express.urlencoded({ extended: false }));

app.get("/", (req, res) => res.render("index"));

app.listen(3000, () => console.log("app listening on port 3000!"));
```

## Creating Users

1. Create a sign-up form template (`sign-up-form`) and a route for `/sign-up`.
2. Add a route for the sign-up form submission.

```javascript
app.get("/sign-up", (req, res) => res.render("sign-up-form"));

app.post("/sign-up", async (req, res, next) => {
  try {
    const user = new User({
      username: req.body.username,
      password: req.body.password
    });
    const result = await user.save();
    res.redirect("/");
  } catch(err) {
    return next(err);
  };
});
```

## Authentication

1. Set up Passport.js for authentication.
2. Add functions for Passport.js in `app.js`.
   - Set up the LocalStrategy.
   - Define serialization and deserialization functions for user sessions.

```javascript
passport.use(
  new LocalStrategy(async (username, password, done) => {
    try {
      const user = await User.findOne({ username: username });
      if (!user) {
        return done(null, false, { message: "Incorrect username" });
      };
      if (user.password !== password) {
        return done(null, false, { message: "Incorrect password" });
      };
      return done(null, user);
    } catch(err) {
      return done(err);
    };
  })
);

passport.serializeUser((user, done) => {
  done(null, user.id);
});

passport.deserializeUser(async (id, done) => {
  try {
    const user = await User.findById(id);
    done(null, user);
  } catch(err) {
    done(err);
  };
});
```

3. Create a login form on the index template.
4. Add a route for the login form submission using Passport.js.

```javascript
app.post(
  "/log-in",
  passport.authenticate("local", {
    successRedirect: "/",
    failureRedirect: "/"
  })
);
```

5. Update the root route to pass the user object to the view.

```javascript
app.get("/", (req, res) => {
  res.render("index", { user: req.user });
});
```

6. Modify the index view to display content based on whether a user is logged in.

## Logout

1. Create a route for logging out.
2. Implement the logout functionality.

```javascript
app.get("/log-out", (req, res, next) => {
  req.logout((err) => {
    if (err) {
      return next(err);
    }
    res.redirect("/");
  });
});
```

## Additional Tip

- You can create a custom middleware to simplify access to the current user in views.

```javascript
app.use((req, res, next) => {
  res.locals.currentUser = req.user;
  next();
});
```

## Securing Passwords with bcrypt

1. Install the `bcryptjs` module.
2. Use `bcrypt.hash` to store hashed passwords.

```javascript
bcrypt.hash(req.body.password, 10, async (err, hashedPassword) => {
  // Store the hashedPassword in the DB
});
```

3. Use `bcrypt.compare` to compare hashed passwords during login.

```javascript
const match = await bcrypt.compare(password, user.password);
if (!match) {
  // Passwords do not match!
  return done(null, false, { message: "Incorrect password" });
}
```

Now your existing project has basic user authentication and password security implemented using Passport.js and bcrypt. Remember to handle input validation and sanitation for enhanced security in a real-world application.

# Splitting Up Concerns

**Folder Structure**:

Create a folder structure for your project to keep your code organized. For example:

```
- project-folder/
  - models/
    - user.js
  - routes/
    - auth.js
  - controllers/
    - authController.js
  - config/
    - passport.js
  - views/
    - index.ejs
    - sign-up-form.ejs
  - app.js
```

Now, let's go through the purpose and content of each module:

**`models/user.js`**:

Define the User model for Mongoose, which represents the user data in your MongoDB database.

```javascript
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const User = mongoose.model(
  'User',
  new Schema({
    username: { type: String, required: true },
    password: { type: String, required: true }
  })
);

module.exports = User;
```

**`routes/auth.js`**:

Define your authentication routes in a separate module. This module will handle user registration, login, and logout routes.

```javascript
const express = require('express');
const router = express.Router();
const authController = require('../controllers/authController');

// Define your authentication routes here
router.get('/sign-up', authController.getSignUp);
router.post('/sign-up', authController.postSignUp);
router.post('/log-in', authController.postLogIn);
router.get('/log-out', authController.logOut);

module.exports = router;
```

**`controllers/authController.js`**:

Create a controller module that handles the logic for your authentication routes. This module interacts with the User model and Passport.js for user registration and login.

```javascript
const User = require('../models/user');
const passport = require('../config/passport');

// Define your authentication controller methods here
const getSignUp = (req, res) => {
  // Render the sign-up form
};

const postSignUp = async (req, res, next) => {
  // Handle user registration
};

const postLogIn = passport.authenticate('local', {
  successRedirect: '/',
  failureRedirect: '/'
});

const logOut = (req, res, next) => {
  req.logout((err) => {
    if (err) {
      return next(err);
    }
    res.redirect('/');
  });
};

module.exports = { getSignUp, postSignUp, postLogIn, logOut };
```

**`config/passport.js`**:

Move your Passport.js configuration to a separate module for better organization. This module defines the Passport.js strategies and serialization/deserialization logic.

```javascript
const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const User = require('../models/user');
const bcrypt = require('bcryptjs');

// Define the LocalStrategy and serialization/deserialization logic
passport.use(
  new LocalStrategy(async (username, password, done) => {
    // Authentication logic
  })
);

passport.serializeUser((user, done) => {
  // Serialization logic
});

passport.deserializeUser(async (id, done) => {
  // Deserialization logic
});

module.exports = passport;
```

**`app.js`**:

In your main `app.js` file, require and set up your modules. This keeps your entry file clean and easy to read.

```javascript
const express = require('express');
const session = require('express-session');
const passport = require('./config/passport');
const authRoutes = require('./routes/auth');

const app = express();

// Set up other middleware and configurations
// ...

app.use(session({ secret: 'cats', resave: false, saveUninitialized: true }));
app.use(passport.initialize());
app.use(passport.session());

// Use your authentication routes
app.use('/auth', authRoutes);

// Define other routes and app settings
// ...

app.listen(3000, () => console.log('app listening on port 3000!'));
```
