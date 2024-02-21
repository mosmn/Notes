# Testing Database Operations Cheat Sheet

## Setup
1. Install `mongodb-memory-server`: `npm install mongodb-memory-server --save-dev`
2. Import `mongodb-memory-server`: `const { MongoMemoryServer } = require("mongodb-memory-server");`
3. Create a function to initialize the in-memory MongoDB server and connect to it using Mongoose.

### Example
```javascript
async function initializeMongoServer() {
  const mongoServer = await MongoMemoryServer.create();
  const mongoUri = mongoServer.getUri();

  mongoose.connect(mongoUri);

  mongoose.connection.on("error", e => {
    if (e.message.code === "ETIMEDOUT") {
      console.log(e);
      mongoose.connect(mongoUri);
    }
    console.log(e);
  });

  mongoose.connection.once("open", () => {
    console.log(`MongoDB successfully connected to ${mongoUri}`);
  });
}

module.exports = initializeMongoServer;
```

## Using the Testing Database
- Call the `initializeMongoServer` function in your testing file.
- Any operations that work on your MongoDB database will use this testing one instead of your real one.

## Additional Notes
- Consider using a `beforeAll` function in your testing suite to add a couple of items to the database before running tests.
- This is not the only way to set up a testing environment. You could also use nconf, command-line arguments, or other methods to set up a `testing` environment that uses `mongodb-memory-server`.
- Always read through the [mongodb-memory-server docs](https://github.com/nodkz/mongodb-memory-server) and [Jest Docs](https://jestjs.io/docs/en/mongodb) for more details.