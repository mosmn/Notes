Since JavaScript is the language of the web, there are some functions that by necessity are going to take a decent amount of time to complete, such as fetching data from a server to display on your site. 
- For this reason, JavaScript includes support for asynchronous functions, or to put it another way, functions that can happen in the background while the rest of your code executes.

The word 'asynchronous', aka 'async' just means 'takes some time' or 'happens in the future, not right now'. Usually callbacks are only used when doing I/O, e.g. downloading things, reading files, talking to databases, etc.

# Callbacks

In the recent past, the way that these were most commonly handled were with callbacks, and even now they are still used quite a lot in certain circumstances.

__A callback function is a function passed into another function as an argument, which is then invoked inside the outer function to complete some kind of routine or action.__
```js
function greeting(name) {
  alert(`Hello, ${name}`);
}

function processUserInput(callback) {
  const name = prompt("Please enter your name.");
  callback(name);
}


processUserInput(greeting);
```
The above example is a __synchronous callback__, as it is executed immediately.

Callbacks are often used to continue code execution after an asynchronous operation has completed — these are called __asynchronous callbacks__. A good example is the callback functions executed inside a `.then()` block chained onto the end of a promise after that promise fulfills or rejects. This structure is used in many modern web APIs, such as `fetch()`.

## Callback Hell

```js
doSomething(function(result) {
  doSomethingElse(result, function(newResult) {
    doThirdThing(newResult, function(finalResult) {
      console.log(`Got the final result: ${finalResult}`);
    }, failureCallback);
  }, failureCallback);
}, failureCallback);
```
The cause of callback hell is when people try to write JavaScript in a way where execution happens visually from top to bottom. Lots of people make this mistake! In other languages like C, Ruby or Python there is the expectation that whatever happens on line 1 will finish before the code on line 2 starts running and so on down the file. As you will learn, JavaScript is different.

### Solution

1. Keep your code shallow
    - Don't nest functions more than 3 levels deep. Break them up into separate functions if you do.
    - Name your functions so that they describe what they do. instead of anonymous functions.

2. Modularize
    - Split your code up into modules that do one thing.
    - Move related functions into the same module.
    - Rules of thumb when creating a module:
        - Start by moving repeatedly used code into a function
        - When your function (or a group of functions related to the same theme) get big enough, move them into another file and expose them using module.exports. You can load this using a relative require
        - If you have some code that can be used across multiple projects give it it's own readme, tests and package.json and publish it to github and npm. There are too many awesome benefits to this specific approach to list here!
        - A good module is small and focuses on one problem
        - Individual files in a module should not be longer than around 150 lines of JavaScript
        - A module shouldn't have more than one level of nested folders full of JavaScript files. If it does, it is probably doing too many things
        - Ask more experienced coders you know to show you examples of good modules until you have a good idea of what they look like. If it takes more than a few minutes to understand what is happening, it probably isn't a very good module.

3. Handle every single error

# Promises

Essentially, a promise is an object that might produce a value at some point in the future.

Lets say `getData()`is a function that fetches some data from a server and returns it as an object that we can use in our code:
```js
const getData = function() {
  // go fetch data from some API...
  const data = fetch('https://api.github.com')
  // clean it up a bit and return it as an object:
  .then(response => response.json())
  return data
}
```

## Basic Promise Usage

```js
var p = new Promise(function(resolve, reject) {
	
	// Do an async task async task and then...

	if(/* good condition */) {
		resolve('Success!');
	}
	else {
		reject('Failure!');
	}
});

p.then(function(result) { 
	/* do something with the result */
}).catch(function() {
	/* error :( */
}).finally(function() {
   /* executes regardless or success for failure */ 
});
```

[SEE MORE](https://davidwalsh.name/promises)