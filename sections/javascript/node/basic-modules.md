# Get Started

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

# env

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

In Node.js, you can make HTTP requests using various methods and libraries. Here, we'll explore how to perform GET, POST, PUT, and DELETE requests, starting with GET and POST.

## GET Request

### Using Axios Library

To make a GET request using Axios, follow these steps:

1. Install Axios using npm:
   ```markdown
   $ npm install axios
   ```

2. Import Axios in your script:
   ```javascript
   const axios = require('axios');
   ```

3. Make the GET request:
   ```javascript
   axios
     .get('https://example.com/todos')
     .then(res => {
       console.log(`statusCode: ${res.status}`);
       console.log(res.data);
     })
     .catch(error => {
       console.error(error);
     });
   ```

### Using Node.js Standard Modules

You can also perform a GET request using Node.js standard modules. While it's more verbose, it doesn't require a third-party library:

```javascript
const https = require('https');

const options = {
  hostname: 'example.com',
  port: 443,
  path: '/todos',
  method: 'GET',
};

const req = https.request(options, res => {
  console.log(`statusCode: ${res.statusCode}`);

  res.on('data', d => {
    process.stdout.write(d);
  });
});

req.on('error', error => {
  console.error(error);
});

req.end();
```

## POST Request

### Using Axios Library

To make a POST request using Axios:

```javascript
const axios = require('axios');

const data = {
  todo: 'Buy the milk',
};

axios
  .post('https://whatever.com/todos', data)
  .then(res => {
    console.log(`statusCode: ${res.status}`);
    console.log(res.data);
  })
  .catch(error => {
    console.error(error);
  });
```

### Using Node.js Standard Modules

For a POST request with Node.js standard modules:

```javascript
const https = require('https');

const data = JSON.stringify({
  todo: 'Buy the milk',
});

const options = {
  hostname: 'whatever.com',
  port: 443,
  path: '/todos',
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'Content-Length': data.length,
  },
};

const req = https.request(options, res => {
  console.log(`statusCode: ${res.statusCode}`);

  res.on('data', d => {
    process.stdout.write(d);
  });
});

req.on('error', error => {
  console.error(error);
});

req.write(data);
req.end();
```

## PUT and DELETE Requests

PUT and DELETE requests follow a similar pattern to POST requests. To perform these requests, adjust the `options.method` value accordingly.

# File System

The `fs` module in Node.js provides a comprehensive set of functionalities to interact with the file system. It is a core module of Node.js and does not require any additional installation.

To use the `fs` module, you can simply require it like this:

```javascript
const fs = require('fs');
```

Once you've required it, you gain access to a wide range of methods for various file system operations. Here's an overview of some of the most commonly used methods:

## Common `fs` Methods

1. `fs.access()`: Checks if a file exists and if Node.js can access it with the specified permissions.

2. `fs.appendFile()`: Appends data to a file. If the file does not exist, it will be created.

3. `fs.chmod()`: Changes the permissions of a file specified by the filename passed. Also related methods: `fs.lchmod()`, `fs.fchmod()`.

4. `fs.chown()`: Changes the owner and group of a file specified by the filename passed. Also related methods: `fs.fchown()`, `fs.lchown()`.

5. `fs.close()`: Closes a file descriptor.

6. `fs.copyFile()`: Copies a file.

7. `fs.createReadStream()`: Creates a readable file stream.

8. `fs.createWriteStream()`: Creates a writable file stream.

9. `fs.link()`: Creates a new hard link to a file.

10. `fs.mkdir()`: Creates a new folder.

11. `fs.mkdtemp()`: Creates a temporary directory.

12. `fs.open()`: Opens a file and returns a file descriptor for file manipulation.

13. `fs.readdir()`: Reads the contents of a directory.

14. `fs.readFile()`: Reads the content of a file. Related method: `fs.read()`.

15. `fs.readlink()`: Reads the value of a symbolic link.

16. `fs.realpath()`: Resolves relative file path pointers (e.g., `.` and `..`) to the full path.

17. `fs.rename()`: Renames a file or folder.

18. `fs.rmdir()`: Removes a folder.

19. `fs.stat()`: Returns the status of the file identified by the filename passed. Related methods: `fs.fstat()`, `fs.lstat()`.

20. `fs.symlink()`: Creates a new symbolic link to a file.

21. `fs.truncate()`: Truncates a file to the specified length. Related method: `fs.ftruncate()`.

22. `fs.unlink()`: Removes a file or a symbolic link.

23. `fs.unwatchFile()`: Stops watching for changes on a file.

24. `fs.utimes()`: Changes the timestamp of the file identified by the filename passed. Related method: `fs.futimes()`.

25. `fs.watchFile()`: Starts watching for changes on a file. Related method: `fs.watch()`.

26. `fs.writeFile()`: Writes data to a file. Related method: `fs.write()`.

## Asynchronous and Synchronous Methods

One notable aspect of the `fs` module is that all its methods are asynchronous by default. However, they can also work synchronously by appending `Sync` to the method name.

For example, asynchronous and synchronous versions of `fs.rename()` and `fs.write()` exist:

- Asynchronous: `fs.rename()`, `fs.write()`
- Synchronous: `fs.renameSync()`, `fs.writeSync()`

Using synchronous methods can block the execution of your script until the file operation is completed.

## Promise-based API (Node.js 10+)

Starting from Node.js 10, there is experimental support for a promise-based API in the `fs/promises` module. This can help avoid callback hell when dealing with nested asynchronous operations. Here's an example of using the promise-based API:

```javascript
const fs = require('fs/promises');

async function example() {
  const fileName = '/Users/joe/test.txt';
  try {
    const data = await fs.readFile(fileName, 'utf8');
    console.log(data);
    const content = 'Some content!';
    await fs.writeFile(fileName, content);
    console.log('Wrote some content!');
    const newData = await fs.readFile(fileName, 'utf8');
    console.log(newData);
  } catch (err) {
    console.log(err);
  }
}

example();
```

By using the promise-based API, you can write more readable and maintainable code, especially when dealing with complex file system operations.

## File Writing in Node.js

File manipulation is a common task in Node.js, and it can be achieved using various methods. Here, we'll explore different approaches to write to files in Node.js, along with additional details to help you understand the process better.

## Using `fs.writeFile()`

The simplest way to write to a file in Node.js is to use the `fs.writeFile()` method. This method asynchronously writes data to a file. If the file already exists, it will be overwritten.

```javascript
const fs = require('fs');
const content = 'Some content!';

fs.writeFile('/Users/joe/test.txt', content, err => {
  if (err) {
    console.error(err);
  } else {
    // File written successfully
  }
});
```

## Using `fs.writeFileSync()`

If you prefer a synchronous approach, you can use `fs.writeFileSync()`. This method writes data to a file synchronously, blocking the execution until the write operation is complete. It is important to handle potential errors.

```javascript
const fs = require('fs');
const content = 'Some content!';

try {
  fs.writeFileSync('/Users/joe/test.txt', content);
  // File written successfully
} catch (err) {
  console.error(err);
}
```

## Using `fsPromises.writeFile()`

For a more modern and asynchronous approach with Promises, you can use `fsPromises.writeFile()`, available in the `fs/promises` module.

```javascript
const fs = require('fs/promises');

async function example() {
  try {
    const content = 'Some content!';
    await fs.writeFile('/Users/joe/test.txt', content);
    // File written successfully
  } catch (err) {
    console.log(err);
  }
}
example();
```

## Modifying Write Behavior

You can modify the default behavior of file writing by specifying a flag when using `fs.writeFile()` or `fsPromises.writeFile()`. Common flags include:

- `r+`: Open the file for reading and writing.
- `w+`: Open the file for reading and writing, positioning the stream at the beginning of the file. The file is created if it does not exist.
- `a`: Open the file for writing, positioning the stream at the end of the file. The file is created if it does not exist.
- `a+`: Open the file for reading and writing, positioning the stream at the end of the file. The file is created if it does not exist.

Example:

```javascript
fs.writeFile('/Users/joe/test.txt', content, { flag: 'a+' }, err => {});
```

You can find more flags in the [Node.js documentation](https://nodejs.org/api/fs.html#fs_file_system_flags).

## Appending to a File

To append content to the end of a file, you can use `fs.appendFile()` (asynchronous) or `fs.appendFileSync()` (synchronous).

Example using `fs.appendFile()`:

```javascript
const fs = require('fs');
const content = 'Some content!';

fs.appendFile('file.log', content, err => {
  if (err) {
    console.error(err);
  } else {
    // Append operation completed successfully
  }
});
```

Example using `fsPromises.appendFile()`:

```javascript
const fs = require('fs/promises');

async function example() {
  try {
    const content = 'Some content!';
    await fs.appendFile('/Users/joe/test.txt', content);
    // Append operation completed successfully
  } catch (err) {
    console.log(err);
  }
}
example();
```

### Using Streams

While the methods mentioned above write the entire content to the file at once, a more efficient option for larger files is to use streams. Streams allow you to write data in smaller chunks, reducing memory usage and improving performance. Stream-based file writing is especially useful for handling large files.

## Reading Files in Node.js

In Node.js, you can read files using different methods depending on your needs. Here are three common ways to read a file, along with some additional details to help you understand the process better:

### Using `fs.readFile()`

The simplest way to read a file is by using the `fs.readFile()` method. This asynchronous method reads the entire file into memory and requires a callback function to handle the data and any potential errors.

```javascript
const fs = require('fs');

fs.readFile('/Users/joe/test.txt', 'utf8', (err, data) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(data);
});
```

- `fs.readFile()` is asynchronous, meaning it won't block the execution of other code while reading the file.
- The `'utf8'` encoding specifies that the file should be read as a UTF-8 encoded text file.

### Using `fs.readFileSync()`

If you prefer a synchronous approach, you can use `fs.readFileSync()`. This method reads the entire file synchronously and throws an error if any issues occur.

```javascript
const fs = require('fs');

try {
  const data = fs.readFileSync('/Users/joe/test.txt', 'utf8');
  console.log(data);
} catch (err) {
  console.error(err);
}
```

- `fs.readFileSync()` blocks the execution of the program until the file is read completely.
- It's important to handle potential errors using a `try...catch` block.

### Using `fsPromises.readFile()`

Node.js also offers a promise-based way to read files using `fsPromises.readFile()` from the `fs/promises` module. This approach allows you to work with promises and async/await.

```javascript
const fs = require('fs/promises');

async function example() {
  try {
    const data = await fs.readFile('/Users/joe/test.txt', { encoding: 'utf8' });
    console.log(data);
  } catch (err) {
    console.error(err);
  }
}

example();
```

- `fsPromises.readFile()` provides a more modern and cleaner syntax for handling asynchronous operations using `async/await`.
- The `{ encoding: 'utf8' }` option specifies the file's encoding.

### Memory Considerations

It's essential to be mindful of memory consumption and execution speed, especially when dealing with large files. All three methods mentioned above read the entire file into memory, which can impact performance and memory usage. 

For better efficiency when working with large files, consider using **file streams**, a mechanism that reads and processes files in smaller chunks, reducing memory consumption and improving performance. Streams are especially useful when dealing with large files or when you need to process data incrementally.

In summary, choose the appropriate file reading method based on your application's requirements and consider using file streams for better performance and memory management when handling large files.

# URL Class

The Browser-compatible URL class is implemented following the WHATWG URL Standard. This class is used for parsing URLs in accordance with browser conventions. It is also available on the global object.

- All properties of URL objects are implemented as getters and setters on the class prototype, not as data properties on the object itself. Therefore, using the `delete` keyword on any properties of URL objects has no effect but will still return `true`.

### `new URL(input[, base])`

- `input` `<string>`: The absolute or relative input URL to parse. If `input` is relative, `base` is required. If `input` is absolute, `base` is ignored. If `input` is not a string, it is converted to a string first.
- `base` `<string>`: The base URL to resolve against if `input` is not absolute. If `base` is not a string, it is converted to a string first.

Creates a new URL object by parsing the `input` relative to the `base`. If `base` is passed as a string, it will be parsed equivalently to `new URL(base)`.

Example:

```javascript
const myURL = new URL('/foo', 'https://example.org/');
// Result: https://example.org/foo
```

- The URL constructor is accessible as a property on the global object and can also be imported from the built-in `url` module (in Node.js).

```javascript
console.log(URL === require('node:url').URL); // Prints 'true'.
```

- A `TypeError` will be thrown if the `input` or `base` are not valid URLs. Efforts are made to coerce the given values into strings.

Example:

```javascript
const myURL = new URL({ toString: () => 'https://example.org/' });
// Result: https://example.org/
```

- Unicode characters within the host name of `input` will be automatically converted to ASCII using the Punycode algorithm.

Example:

```javascript
const myURL = new URL('https://測試');
// Result: https://xn--g6w251d/
```

- When it is not known in advance if `input` is an absolute URL and a `base` is provided, it is advised to validate that the origin of the URL object is as expected.

Examples:

```javascript
let myURL = new URL('http://Example.com/', 'https://example.org/');
// Result: http://example.com/

myURL = new URL('https://Example.com/', 'https://example.org/');
// Result: https://example.com/

myURL = new URL('foo://Example.com/', 'https://example.org/');
// Result: foo://Example.com/

myURL = new URL('http:Example.com/', 'https://example.org/');
// Result: http://example.com/

myURL = new URL('https:Example.com/', 'https://example.org/');
// Result: https://example.org/Example.com/

myURL = new URL('foo:Example.com/', 'https://example.org/');
// Result: foo:Example.com/
```

All the properties a re avaliable in the [Node.js documentation](https://nodejs.org/api/url.html#class-url).

# NPM

[npm](https://www.npmjs.com/) is the standard package manager for Node.js. As of September 2022, it boasts over 2.1 million packages in its registry, making it the largest single-language code repository globally. With npm, you can find a package for almost any purpose, making it an invaluable tool for Node.js development. While its initial purpose was to manage dependencies for Node.js packages, it has since become a vital tool in frontend JavaScript development as well.

## npm Alternatives

- [Yarn](https://yarnpkg.com/): A package manager that focuses on speed and reliability, often used as an alternative to npm.
- [pnpm](https://pnpm.io/): A fast and disk-space-efficient package manager compatible with npm, designed to save disk space and speed up installations.

## Managing Downloads

npm excels at managing the downloads of project dependencies.

### Installing All Dependencies

To install all dependencies listed in a project's `package.json` file, simply run the following command:

```shell
npm install
```

This command will create a `node_modules` folder if it doesn't exist and install all the required packages.

### Installing a Single Package

For installing a specific package, use the following command:

```shell
npm install <package-name>
```

Starting from npm version 5, the `<package-name>` is automatically added to the `dependencies` section of the `package.json` file. In earlier versions, you needed to add the `--save` flag. Additional flags can be used to modify this behavior:

- `--save-dev`: Installs the package and adds it to the `devDependencies` section of `package.json`.
- `--no-save`: Installs the package but doesn't add it to `package.json`.
- `--save-optional`: Installs the package and adds it to `optionalDependencies` in `package.json`.
- `--no-optional`: Prevents the installation of optional dependencies.

Shorthand versions of these flags are also available:

- `-S`: Equivalent to `--save`
- `-D`: Equivalent to `--save-dev`
- `-O`: Equivalent to `--save-optional`

**Note:** The distinction between `devDependencies` and `dependencies` is that the former includes development tools, such as testing libraries, while the latter is bundled with the application in production. Optional dependencies do not block installation if they fail to build, but handling their absence is the responsibility of your program.

### Updating Packages

Updating packages is straightforward with npm. To check for newer versions of packages that meet your versioning constraints, use:

```shell
npm update
```

To update a specific package, use:

```shell
npm update <package-name>
```

## Versioning

npm not only manages package downloads but also handles versioning. You can specify precise versions or define version ranges to ensure compatibility with your project.

Sometimes, you may find that a library is only compatible with a specific major release of another library, or a bug in the latest release of a library remains unfixed. Specifying explicit versions helps maintain consistency within your team until you update the `package.json` file.

npm follows the [semantic versioning (semver)](https://semver.org/) standard, which helps in version management.

To install a specific version of a package, use the following command:

```shell
npm install <package-name>@<version>
```

## Running Tasks

The `package.json` file supports defining command-line tasks that can be executed using `npm run <task-name>`.

For example, you can define tasks like this:

```json
{
  "scripts": {
    "start-dev": "node lib/server-development",
    "start": "node lib/server-production"
  }
}
```

This feature is commonly used to run tools like Webpack:

```json
{
  "scripts": {
    "watch": "webpack --watch --progress --colors --config webpack.conf.js",
    "dev": "webpack --progress --colors --config webpack.conf.js",
    "prod": "NODE_ENV=production webpack -p --config webpack.conf.js"
  }
}
```

Instead of typing long and potentially error-prone commands, you can use these defined tasks:

```shell
$ npm run watch
$ npm run dev
$ npm run prod
```

These tasks simplify the execution of complex commands in your development workflow.

## package.json

[package.json](https://github.com/nodejs/nodejs.dev/blob/aa4239e87a5adc992fdb709c20aebb5f6da77f86/content/learn/node-js-package-manager/package-json.en.md) has detailed documentation of its properties.

## Local and Global Packages

When working with Node.js and npm (Node Package Manager), it's essential to distinguish between local and global packages. The primary difference lies in how and where these packages are installed and accessed within your development environment.

## Local Packages

Local packages are installed in the directory where you execute the command `npm install <package-name>`. Here are some key points to remember:

- **Installation Location:** They are placed within the `node_modules` directory under the specific project directory where the `npm install` command was run.
- **Access in Code:** To use local packages in your code, you typically require them using `require('package-name')`.

### When to Install Packages Locally

In general, the best practice is to install packages locally for the following reasons:

1. **Isolation:** Each project maintains its own set of local packages, ensuring that different projects can use different versions of the same package without conflicts. This isolation is crucial to avoid compatibility issues and ensure project stability.

2. **Version Control:** Including local packages in your project's version control system (e.g., Git) allows you to track and share the specific package versions used in your project, enhancing collaboration and reproducibility.

## Global Packages

Global packages, on the other hand, are stored in a single location on your system, regardless of where you execute the `npm install -g <package-name>` command. Here are additional details:

- **Installation Location:** Global packages are installed in a system-wide directory, the exact location of which depends on your system's configuration.
- **Access in Code:** You cannot directly require global packages in your code as you would with local packages. Instead, global packages typically provide executable commands that you can run from the command line (CLI).

### When to Install Packages Globally

Install packages globally when they provide executable commands that you need to access from the shell (CLI), and you intend to use these commands across multiple projects. Some common examples of global packages include:

- npm
- vue-cli
- grunt-cli
- mocha
- react-native-cli
- gatsby-cli
- forever
- nodemon

You can check your system for globally installed packages by running the following command in your terminal:

```bash
npm list -g --depth 0
```

This command will list all global packages installed on your system, helping you identify packages with global CLI functionality.


# Events