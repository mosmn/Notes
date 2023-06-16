Asynchronous code can become difficult to follow when it has a lot of things going on. async and await are two keywords that can help make asynchronous read more like synchronous code.

For example, the two code blocks below do the exact same thing. They both get information from a server, process it, and return a promise.
```js
function getPersonsInfo(name) {
  return server.getPeople().then(people => {
    return people.find(person => { return person.name === name });
  });
}
```
```js
async function getPersonsInfo(name) {
  const people = await server.getPeople();
  const person = people.find(person => { return person.name === name });
  return person; // if does indeed return a promise, that means it will return a resolved promise with the 'person' object found.
}
```

# Async

The `async` keyword is what lets the JavaScript engine know that you are declaring an asynchronous function. __This is required to use `await` inside any function.__ 

When a function is declared with `async`, it automatically returns a promise; returning in an async function is the same as resolving a promise. Likewise, throwing an error will reject the promise.

__An important thing to understand is `async` functions are just syntactical sugar for `promises`.__

The async keyword can also be used with any of the ways a function can be created.
```js
  const yourAsyncFunction = async () => {
    // do something asynchronously and return a promise
    return result;
  }
```
```js
 anArray.forEach(async item => {
   // do something asynchronously for each item in 'anArray'
   // one could also use .map here to return an array of promises to use with 'Promise.all()' e.g.:
   const promises = anArray.map(async item => {
     // do something asynchronously for each item in 'anArray'
     return result;
   });
    const results = await Promise.all(promises);

    // print results
    console.log(results);
 });
```
```js
server.getPeople().then(async people => {
  people.forEach(person => {
    // do something asynchronously for each person
  });
});
```

# Await

`await` is pretty simple: it tells JavaScript to wait for an asynchronous action to finish before continuing the function. It’s like a ‘pause until done’ keyword. The `await` keyword is used to get a value from a function where you would normally use `.then()`. Instead of calling `.then()` after the asynchronous function, you would simply assign a variable to the result using `await`. Then you can use the result in your code as you would in your synchronous code.

# Error Handling

Handling errors in `async` functions is very easy. Promises have the `.catch()` method for handling rejected promises, and since async functions just return a promise, you can simply call the function, and append a `.catch()` method to the end.
```js
asyncFunctionCall().catch(err => {
  console.error(err)
});
```
But there is another way: the mighty `try/catch` block! If you want to handle the error directly inside the `async` function, you can use `try/catch` just like you would inside synchronous code.
```js
async function getPersonsInfo(name) {
  try {
    const people = await server.getPeople();
    const person = people.find(person => { return person.name === name });
    return person;
  } catch (error) {
    // Handle the error any way you'd like

  }
}
```

- [Solid introduction to async/await](https://javascript.info/async-await)
- [Good examples](https://codeburst.io/javascript-es-2017-learn-async-await-by-example-48acc58bad65)
- [Video](https://www.youtube.com/watch?v=9YkUCxvaLEk)