# Express Testing with SuperTest Cheat Sheet

## Setup
1. Install SuperTest: `npm install supertest --save-dev`
2. Import SuperTest: `const request = require("supertest");`
3. Import Express: `const express = require("express");`
4. Create an Express app: `const app = express();`
5. Use the router you want to test: `app.use("/", index);`

## Writing Tests
- Use the `request` function from SuperTest on your Express app.
- Pass the route you want to test.
- Use `.expect()` to assert the responses.

### Example
```javascript
test("index route works", done => {
  request(app)
    .get("/")
    .expect("Content-Type", /json/)
    .expect({ name: "frodo" })
    .expect(200, done);
});
```

## Testing POST Routes
- Use `.post()` instead of `.get()`.
- Use `.type()` to set the content type.
- Use `.send()` to send the request body.
- Use `.then()` to wait for the POST request to finish before making another request.

### Example
```javascript
test("testing route works", done => {
  request(app)
    .post("/test")
    .type("form")
    .send({ item: "hey" })
    .then(() => {
      request(app)
        .get("/test")
        .expect({ array: ["hey"] }, done);
    });
});
```

## Additional Notes
- The `done` parameter is used to signal that the test is complete in the case of asynchronous operations.
- SuperTest allows you to pass `done` into the last `.expect()` and calls it for you.
- SuperTest pulls from another related project called SuperAgent. Any method that you can call in SuperAgent you can also call from SuperTest.
- Read through the [SuperTest docs](https://github.com/visionmedia/supertest) and [SuperAgent docs](https://ladjs.github.io/superagent/) for more details.