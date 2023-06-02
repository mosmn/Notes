# npm and where it was commonly used before being adopted on the frontend.

## npm

The node package manager is a command-line tool that gives you access to a gigantic repository of plugins, libraries and tools.

npm consists of three distinct components:
- the website
- the Command Line Interface (CLI)
- the registry (a registry is a central repository where JavaScript packages can be stored and shared. The registry is used by the npm CLI to install, update, and remove packages. It is also used by the npm website to allow users to browse and search for packages.)

npm was originally a package manager made specifically for node.js, a JavaScript runtime designed to run on the server, not the frontend. So that makes it a pretty weird choice for a frontend JavaScript package manager for libraries meant to run in a browser.

## Use npm to

- Adapt packages of code for your apps, or incorporate packages as they are.
- Download standalone tools you can use right away.
- Run packages without downloading using npx.
- Share code with any npm user, anywhere.
- Restrict code to specific developers.
- Create organizations to coordinate package maintenance, coding, and developers.
- Form virtual teams by using organizations.
- Manage multiple versions of code and code dependencies.
- Update applications easily when underlying code is updated.
- Discover multiple ways to solve the same puzzle.
- Find other developers who are working on similar problems and projects.

# Describe what npm init does and what package.json is.

`npm init` This will prompt you with several questions and generate a new file named `package.json`. This is a configuration file that npm uses to save all project information. With the defaults the contents of `package.json` should look something like:
```json
{  
  "name": "your-project-name",  
  "version": "1.0.0",  
  "description": "",  
  "main": "index.js",  
  "scripts": {  
    "test": "echo \"Error: no test specified\" && exit 1"  
  },  
  "author": "",  
  "license": "ISC"  
}
```

## package.jsons

A package.json file:
- lists the packages your project depends on
- specifies versions of a package that your project can use using semantic versioning rules
- makes your build reproducible, and therefore easier to share with other developers

[REFER HERE](https://docs.npmjs.com/creating-a-package-json-file)

# how to install packages using npm.

To install the moment.js JavaScript package, we can now follow the npm instructions from their home page by entering the following command in the command line:
```bash
$ npm install moment --save
```
This command does two things — first, it downloads all the code from the moment.js package into a folder called `node_modules`. Second, it automatically modifies the package.json file to keep track of moment.js as a project dependency.
```json
{  
  "name": "modern-javascript-example",  
  "version": "1.0.0",  
  "description": "",  
  "main": "index.js",  
  "scripts": {  
    "test": "echo \"Error: no test specified\" && exit 1"  
  },  
  "author": "",  
  "license": "ISC",  
  "dependencies": {
    "moment": "^2.22.2"  
  } 
}
```

## Installing an unscoped package

Unscoped packages are always public, which means they can be searched for, downloaded, and installed by anyone. To install a public package, on the command line, run
```
npm install <package_name>
```
This will create the node_modules directory in your current directory (if one doesn't exist yet) and will download the package to that directory.

Note: If there is no package.json file in the local directory, the latest version of the package is installed.

If there is a package.json file, npm installs the latest version that satisfies the semver rule declared in package.json.

## Installing a scoped public package

Scoped public packages can be downloaded and installed by anyone, as long as the scope name is referenced during installation:
```
npm install @scope/package-name
```

## Installing a private package

Private packages can only be downloaded and installed by those who have been granted read access to the package. Since private packages are always scoped, you must reference the scope name during installation:
```
npm install @scope/private-package-name
```

## Testing package installation

To confirm that npm install worked correctly, in your module directory, check that a node_modules directory exists and that it contains a directory for the package(s) you installed:
```
ls node_modules
```

## Installed package version

If there is a `package.json` file in the directory in which `npm install` is run, npm installs the latest version of the package that satisfies the semantic versioning rule declared in `package.json`.

If there is no `package.json` file, the latest version of the package is installed.

## Installing a package with dist-tags

Like `npm publish`, `npm install <package_name>` will use the latest tag by default.

To override this behavior, use` npm install <package_name>@<tag>`. For example, to install the example-package at the version tagged with beta, you would run the following command:
```
npm install example-package@beta
```

# Describe what a JavaScript module bundler like webpack is.

Most programming languages provide a way to import code from one file into another. JavaScript wasn’t originally designed with this feature, because JavaScript was designed to only run in the browser, with no access to the file system of the client’s computer (for security reasons). So for the longest time, organizing JavaScript code in multiple files required you to load each file with variables shared globally.
```html
<!-- index.html -->  
<!DOCTYPE html>  
<html lang="en">  
<head>  
  <meta charset="UTF-8">  
  <title>JavaScript Example</title> 
  <!--  -->
  <script src="node_modules/moment/min/moment.min.js"></script>
  <!--  -->
  <script src="index.js"></script>  
</head>  
<body>  
  <h1>Hello from HTML!</h1>  
</body>  
</html>
```
This is actually what we’re doing with the above moment.js example — the entire moment.min.js file is loaded in the HTML, which defines a global variable moment, which is then available to any file loaded after moment.min.js (regardless of whether or not it needs access to it).

In 2009, a project named CommonJS was started with the goal of specifying an ecosystem for JavaScript outside the browser. A big part of CommonJS was its specification for modules, which would finally allow JavaScript to import and export code across files like most programming languages, without resorting to global variables. The most well-known of implementation of CommonJS modules is node.js.

As mentioned earlier, node.js is a JavaScript runtime designed to run on the server. Here’s what the earlier example would look like using node.js modules. Instead of loading all of moment.min.js with an HTML script tag, you can load it directly in the JavaScript file as follows:
```js
// index.js  
var moment = require('moment');
console.log("Hello from JavaScript!");  
console.log(moment().startOf('day').fromNow());
```
Again, this is how module loading works in node.js, which works great since node.js is a server side language with access to the computer’s file system. Node.js also knows the location of each npm module path, so instead of having to write require('./node_modules/moment/min/moment.min.js), you can simply write require('moment') — pretty sweet.

This is all great for node.js, but if you tried to use the above code in the browser, you’d get an error saying require is not defined. The browser doesn’t have access to the file system, which means loading modules in this way is very tricky — loading files has to be done dynamically, either synchronously (which slows down execution) or asynchronously (which can have timing issues).

__This is where a module bundler comes in. A JavaScript module bundler is a tool that gets around the problem with a build step (which has access to the file system) to create a final output that is browser compatible (which doesn’t need access to the file system). In this case, we need a module bundler to find all require statements (which is invalid browser JavaScript syntax) and replace them with the actual contents of each required file. The final result is a single bundled JavaScript file (with no require statements)!__

## Webpack

Webpack is simply a tool for bundling modules.

At its core, webpack is a static module bundler for modern JavaScript applications. When webpack processes your application, it internally builds a dependency graph from one or more entry points and then combines every module your project needs into one or more bundles, which are static assets to serve your content from.

### Explain what the concepts “entry” and “output” mean as relates to webpack.

# Briefly explain what a development dependency is.

Development dependencies, or `devDependencies` are packages that are consumed by requiring them in files or run as binaries, during the development phase. These are packages that are only necessary during development and not necessary for the production build. Some examples of packages that would only be required during development are babel plugins and presets, test runners and linter packages.

Alternatively, there is a dependency that is necessary in both production and development. In this case, it can be added to `dependencies`, since `dependencies` are available in both production and development.

to install a package as a devDependency, use the `--save-dev` flag:
```
npm install <package_name> --save-dev
```

to install a package as a dependency, use the `--save` flag:
```
npm install <package_name> --save
```

# Transpiling code and how it relates to front-end development.

Transpiling code means converting the code in one language to code in another similar language. 

This is an important part of frontend development — since browsers are slow to add new features, new languages were created with experimental features that transpile to browser compatible languages.

For CSS, there’s Sass, Less, and Stylus, to name a few. For JavaScript, the most popular transpiler for a while was CoffeeScript (released around 2010), whereas nowadays most people use babel or TypeScript.

Typescript is a language that is essentially identical to next generation JavaScript, but also adds optional static typing. 

# Briefly describe what a task runner is and how it’s used in front-end development.

A tool that automates different parts of the build process. For frontend development, tasks include minifying code, optimizing images, running tests, etc.

# Describe how to write an npm automation script.

# Explain one of the main benefits of writing code in modules.

# Explain “named” exports and “default” exports.