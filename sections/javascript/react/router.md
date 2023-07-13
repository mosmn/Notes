# Client-Side Routing

Client-side routing is internal handling of routes inside the JS file that is rendered to the client (front-end). Client-side routing helps in building single-page applications (SPAs) without refreshing as the user navigates. For example, when a user clicks a navbar element, the URL changes, and the view of the page is modified accordingly within the client.

## React Router

- React Router is the standard routing library for React applications. To install it, use `npm i react-router-dom`.
- It allows specifying which component should be rendered based on the route.
- From version 4 onwards, React Router uses dynamic routes, which means routing takes place as the app is rendering.

[React Router Documentation](https://reactrouter.com/en/main/start/overview)

## Steps to Use React Router

1. Create a new project using `create-react-app`.
2. Remove the boilerplate code in the created project, keeping only the `index.js` and `App.js` files.
3. Create a new file called `Profile.js` inside the `src` directory.

```javascript
// Profile.js
import React from "react";

const Profile = () => {
  return (
    <div>
      <h1>Hello from Profile</h1>
    </div>
  );
};

export default Profile;
```

4. Create a new file called `RouteSwitch.js`.

```javascript
// RouteSwitch.js
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Profile from "./Profile";

const RouteSwitch = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/profile" element={<Profile />} />
      </Routes>
    </BrowserRouter>
  );
};

export default RouteSwitch;
```

5. Install the `react-router-dom` package using `npm i react-router-dom`.
6. Update the `index.js` file to render the `RouteSwitch` component as the first file.

```javascript
// index.js
import React from "react";
import ReactDOM from "react-dom";
import RouteSwitch from "./RouteSwitch";

ReactDOM.render(
  <React.StrictMode>
    <RouteSwitch />
  </React.StrictMode>,
  document.getElementById("root")
);
```

7. Run the application and test the defined routes.