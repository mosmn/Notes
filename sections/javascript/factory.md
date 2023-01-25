# Factory Function

Instead of using `new` to create objects, factory functions return the new object when the function is called. that way the programmer have to worry about forgetting the `new` keyword.

```js
const personFactory = (name, age) => {
  const sayHello = () => console.log('hello!');
  return { name, age, sayHello };
};

const jeff = personFactory('jeff', 27);

console.log(jeff.name); // 'jeff'

jeff.sayHello(); // calls the function and logs 'hello!'
```

# Scope and Closure