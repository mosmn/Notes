# Using Shebang in Node.js Scripts

The usual way to run a Node.js program is by executing it using the globally available `node` command. You can pass the name of the file you want to execute as an argument.

```bash
node app.js
```

Here, you explicitly specify the `node` interpreter to run your script. However, you can also embed this information into your JavaScript file with a "shebang" line.

A shebang line is the first line of a file and tells the operating system which interpreter to use for running the script. You can use two different approaches for specifying the shebang line.

## Explicitly specifying the interpreter's path:

```javascript
#!/usr/bin/node
```

In this approach, you explicitly give the absolute path of the `node` interpreter. Note that not all operating systems may have `node` in the `/usr/bin` folder.

## Using 'env' to locate the interpreter:

```javascript
#!/usr/bin/env node
```

Here, you use the `env` command to locate the `node` interpreter. This approach is more portable because it relies on the assumption that the `env` command is available on most operating systems.

To use a shebang, your JavaScript file should have executable permission. You can grant executable permission to a file using the `chmod` command:

```bash
chmod u+x app.js
```

Make sure you are in the same directory as the `app.js` file when running this command.

## Passing a string as an argument to `node`

You can execute a JavaScript string as an argument to the `node` command using the `-e` or `--eval` option:

```bash
node -e "console.log(123)"
```

This is useful for quick one-liners or for evaluating JavaScript code from the command line. Note that the usage of single or double quotes can vary depending on your shell (e.g., `cmd.exe`, PowerShell, or Git Bash on Windows).

## Restarting the application automatically with Nodemon

To automatically restart your Node.js application whenever there is a change, you can use the `nodemon` module. First, install `nodemon` globally:

```bash
npm i -g nodemon
```

You can also install `nodemon` as a development dependency:

```bash
npm i --save-dev nodemon
```

After installation, you can run `nodemon` from an npm script, such as `npm start`, or directly using `npx nodemon`. For example:

```bash
nodemon app.js
```

This will monitor your application's files for changes and automatically restart it when necessary, making development more convenient.

# Node.js Environment Variables and Configuration

Node.js provides a straightforward way to work with environment variables, which are essential for configuring applications. In this guide, we'll explore how to access and manage environment variables in a Node.js project.

## Accessing Environment Variables

Node.js exposes environment variables through the `process.env` object. These variables contain information about the system environment at the time the Node.js process was started.

To set environment variables for a specific Node.js process, you can use the command line as follows:

```bash
USER_ID=239482 USER_KEY=foobar node app.js
```

Here, we set the `USER_ID` to `239482` and `USER_KEY` to `foobar`.

### Accessing Environment Variables in Your Code

Once you've set environment variables, you can easily access them in your Node.js code using `process.env`. For example:

```javascript
const userId = process.env.USER_ID; // "239482"
const userKey = process.env.USER_KEY; // "foobar"
```

You can access any custom environment variables in the same way.

## Using an .env File

Managing multiple environment variables directly in the command line can become cumbersome. To simplify this process, you can use an `.env` file in your project's root directory and the `dotenv` package.

### Installing `dotenv`

First, install the `dotenv` package locally in your project, which is recommended:

```bash
npm install dotenv --save
```

### Creating the .env File

Create a `.env` file in your project's root directory. Here's an example:

```plaintext
USER_ID="239482"
USER_KEY="foobar"
NODE_ENV="development"
```

### Loading Environment Variables

In your JavaScript file, require and configure `dotenv` to load the environment variables from the `.env` file:

```javascript
require('dotenv').config();

const userId = process.env.USER_ID; // "239482"
const userKey = process.env.USER_KEY; // "foobar"
const nodeEnv = process.env.NODE_ENV; // "development"
```

By using `dotenv`, you can manage and load environment variables more efficiently. If you prefer not to import the package in your code, you can run your JavaScript file with the following command:

```bash
node -r dotenv/config index.js
```

This command loads the environment variables from the `.env` file without the need for explicit imports in your code.

# HTTP Module

# File System

# URL Class

# NPM