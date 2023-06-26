# Test Driven Development(TDD) 0r Test First Development

Is when you start working on your code by writing automated tests before writing the code that is being tested.

Test-running systems available in JavaScript: [Mocha](https://mochajs.org/), [Jasmine](https://jasmine.github.io/), [Tape](https://github.com/ljharb/tape) and [Jest](https://jestjs.io/) to name a few. the syntax for each one is very similar.

In the end, writing tests is less about the syntax and more about the __TDD philosophy. The most important issues are knowing why we write tests and what we test rather than how.__

How does it work?
1. Create the test and test it with the current code which is ging to fail because the new feature is not yet implemented
2. Create code for that feature…test the code again using the created test
3. After it passes the test we can refactor the code.

![IMG](https://web.archive.org/web/20211123190518if_/http://godswillokwara.com/wp-content/uploads/2016/09/tddSteps.jpg)

Why even do unit testing?
- Because complexitiy grows over time

# Jest

Install jest using npm
```bash
npm install --save-dev jest
```
Generate a basic configuration file
```bash
jest --init
```
By default, the current version of Jest will not recognize ES6 import statements.
To fix this, we need to install the Babel compiler and the preset-env plugin.
```bash
npm install --save-dev babel-jest @babel/core @babel/preset-env
```
Configure Babel to target your current version of Node by creating a `babel.config.js` file in the root of your project:
```js
babel.config.js
module.exports = {
  presets: [['@babel/preset-env', {targets: {node: 'current'}}]],
};
```

