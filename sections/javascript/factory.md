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

Scope is the term that refers to where things like variables and functions can be used in your code.  

In the following example, do you know what will be logged on the last line?
```js
let a = 17;

const func = x => {
  let a = x;
};

func(99);

console.log(a); // ???????
```
Is it 17 or 99? Do you know why? Can you edit the code so that it prints the other value?

The answer is 17, and the reason it’s not 99 is that on line 4, the outer variable a is not redefined, rather a new a is created inside the scope of that function. In the end, figuring out scope in most contexts is not all that complicated, but it is crucial to understanding some of the more advanced concepts that are coming up soon, so take your time to understand what’s going on in the following resources.


