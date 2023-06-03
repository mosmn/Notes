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

[GETTING STARTED](https://webpack.js.org/guides/getting-started/)

### The concepts “entry” and “output” mean as relates to webpack.

There are a couple of key concepts to understanding how webpack works - entry and output. 

We rearranged the files into a `src` and `dist` folder. Technically we could have called those folders anything, but those names are typical. 
- `src` is our source directory. In other words, src is where we write all of the code that webpack is going to bundle up for us. When webpack runs, it goes through all of our files looking for any import statements and then compiles all of the code we need to run our site into a single file inside of the dist folder (short for distribution). 
    - Our entry file, then is the main application file that links (either directly or indirectly) to all of the other modules in our project. In this example, it is `/src/index.js`. 
- The output file is the compiled version - dist/main.js.

[CORE CONCEPTS](https://webpack.js.org/concepts/)

# Development dependencies

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

# Task runner and how it’s used in front-end development.

A tool that automates different parts of the build process. For frontend development, tasks include minifying code, optimizing images, running tests, etc.

In 2013, Grunt was the most popular frontend task runner, with Gulp following shortly after. Both rely on plugins that wrap other command line tools. Nowadays the most popular choice seems to be using the scripting capabilities built into the npm package manager itself, which doesn’t use plugins but instead works with other command line tools directly.

Let’s write some npm scripts to make using webpack easier. This involves simply changing the package.json file as follows:
```json
{  
  "name": "modern-javascript-example",  
  "version": "1.0.0",  
  "description": "",  
  "main": "index.js",  
  "scripts": {  
    "test": "echo \"Error: no test specified\" && exit 1",  
    "build": "webpack --progress --mode=production",  
    "watch": "webpack --progress --watch" 
  },  
  "author": "",  
  "license": "ISC",  
  "dependencies": {  
    "moment": "^2.22.2"  
  },  
  "devDependencies": {  
    "@babel/core": "^7.0.0",  
    "@babel/preset-env": "^7.0.0",  
    "babel-loader": "^8.0.2",  
    "webpack": "^4.17.1",  
    "webpack-cli": "^3.1.0"  
  }  
}
```
Here we’ve added two new scripts, build and watch. To run the build script, you can enter in the command line:
```
$ npm run build
```
This will run webpack (using configuration from the webpack.config.js we made earlier) with the --progress option to show the percent progress and the --mode=production option to minimize the code for production. To run the watch script:
```
$ npm run watch
```
This uses the --watch option instead to automatically re-run webpack each time any JavaScript file changes, which is great for development.

Note that the scripts in package.json can run webpack without having to specify the full path ./node_modules/.bin/webpack, since node.js knows the location of each npm module path. This is pretty sweet! We can make things even sweeter by installing webpack-dev-server, a separate tool which provides a simple web server with live reloading. To install it as a development dependency, enter the command:
```
$ npm install webpack-dev-server --save-dev
```
Then add an npm script to package.json:
```json
{  
  "name": "modern-javascript-example",  
  "version": "1.0.0",  
  "description": "",  
  "main": "index.js",  
  "scripts": {  
    "test": "echo \"Error: no test specified\" && exit 1",  
    "build": "webpack --progress -p",  
    "watch": "webpack --progress --watch",  
    "serve": "webpack-dev-server --open"  
  },  
  "author": "",  
  "license": "ISC",  
  "dependencies": {  
    "moment": "^2.19.1"  
  },  
  "devDependencies": {  
    "@babel/core": "^7.0.0",  
    "@babel/preset-env": "^7.0.0",  
    "babel-loader": "^8.0.2",  
    "webpack": "^3.7.1",  
    "webpack-dev-server": "^3.1.6"  
  }  
}
```
Now you can start your dev server by running the command:
```
$ npm run serve
```
This will automatically open the index.html website in your browser with an address of localhost:8080 (by default). Any time you change your JavaScript in index.js, webpack-dev-server will rebuild its own bundled JavaScript and refresh the browser automatically. This is a surprisingly useful time saver, as it allows you to keep your focus on the code instead of having to continually switch contexts between the code and the browser to see new changes.

## how to write an npm automation script.

Given it's not particularly fun to run a local copy of webpack from the CLI, we can set up a little shortcut. Let's adjust our package.json by adding an npm script:
```json
package.json

 {
   "name": "webpack-demo",
   "version": "1.0.0",
   "description": "",
   "private": true,
   "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    // "build"
    "build": "webpack"
   },
   "keywords": [],
   "author": "",
   "license": "ISC",
   "devDependencies": {
     "webpack": "^5.4.0",
     "webpack-cli": "^4.2.0"
   },
   "dependencies": {
     "lodash": "^4.17.20"
   }
 }
```
Now the `npm run build` command can be used in place of the `npx` command we used earlier. Note that within scripts we can reference locally installed npm packages by name the same way we did with npx. This convention is the standard in most npm-based projects because it allows all contributors to use the same set of common scripts.

# ES6 Modules

There are only 2 components to it - `import` and `export`.
```js
// a file called functionOne.js
const functionOne = () => console.log('FUNCTION ONE!');

export { functionOne };
```
```js
// another JS file
import { functionOne } from './functionOne';

functionOne(); // this should work as expected!
```
When using ES6 modules, only what is exported can be accessed in other modules by importing.

### one of the main benefits of writing code in modules.

Code reuse. If, for instance, you have written some functions that manipulate the DOM in a specific way, putting all of those into their own file as a ‘module’ means that you can copy that file and re-use it very easily!

## Import

The static import declaration is used to import read-only live bindings which are exported by another module. The imported bindings are called live bindings because they are updated by the module that exported the binding, but cannot be re-assigned by the importing module.

syntax:
```js
import defaultExport from "module-name";
import * as name from "module-name";
import { export1 } from "module-name";
import { export1 as alias1 } from "module-name";
import { default as alias } from "module-name";
import { export1, export2 } from "module-name";
import { export1, export2 as alias2, /* … */ } from "module-name";
import { "string name" as alias } from "module-name";
import defaultExport, { export1, /* … */ } from "module-name";
import defaultExport, * as name from "module-name";
import "module-name";
```
- `defaultExport`: Name that will refer to the default export from the module. Must be a valid JavaScript identifier.
- `module-name`: The module to import from. The evaluation of the specifier is host-specified. This is often a relative or absolute URL to the .js file containing the module. In Node, extension-less imports often refer to packages in node_modules. Certain bundlers may permit importing files without extensions; check your environment. Only single quoted and double quoted Strings are allowed.
- `name`: Name of the module object that will be used as a kind of namespace when referring to the imports. Must be a valid JavaScript identifier.
- `exportN`: Name of the exports to be imported. The name can be either an identifier or a string literal, depending on what module-name declares to export. If it is a string literal, it must be aliased to a valid identifier.
- `aliasN`: Names that will refer to the named imports. Must be a valid JavaScript identifier.

`import` declarations can only be present in modules, and only at the top-level (i.e. not inside blocks, functions, etc.).

There are four forms of import declarations:
1. Named import: `import { export1, export2 } from "module-name";`
2. Default import: `import defaultExport from "module-name";`
3. Namespace import: `import * as name from "module-name";`
4. Side effect import: `import "module-name";`

## Export

There are 2 different ways to use exports in your code: named exports and default exports.

### Explain “named” exports and “default” exports.

Which option you use depends on what you’re exporting. As a general rule if you want to export multiple functions use named exports with this pattern:
```js
// a file called myModule.js
const functionOne = () => 'ONE';
const functionTwo = () => 'TWO';

export {
  functionOne,
  functionTwo
};
```
And to import them:
```js
// index.js in /src folder
import {functionOne, functionTwo} from './myModule';
```
Using this pattern gives you the freedom to only import the functions you need in the various files of your program. So it’s perfectly fine to only import functionOne if that’s the only one you need.

