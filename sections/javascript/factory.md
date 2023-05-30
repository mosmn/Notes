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

## Private Variables and Functions

```js
const FactoryFunction = string => {
  const capitalizeString = () => string.toUpperCase();
  const printString = () => console.log(`----${capitalizeString()}----`);
  return { printString };
};

const taco = FactoryFunction('taco');

printString(); // ERROR!!
capitalizeString(); // ERROR!!
taco.capitalizeString(); // ERROR!!
taco.printString(); // this prints "----TACO----"
```
- Because of the concept of scope, neither of the functions created inside of FactoryFunction can be accessed outside of the function itself, which is why lines 9, 10, and 11 fail. 
- The only way to use either of those functions is to `return` them in the object (see line 4), which is why we can call `taco.printString()` but not `taco.capitalizeString()`. 
- The big deal here is that even though we can’t access the `capitalizeString()` function, `printString()` can. That is closure.

The concept of closure is the idea that functions retain their scope even if they are passed around and called outside of that scope. In this case, `printString` has access to everything inside of `FactoryFunction`, even if it gets called outside of that function.
- `capitalizeString` is a private function and `printString` is public.

```js
const counterCreator = () => {
  let count = 0;
  return () => {
    console.log(count);
    count++;
  };
};

const counter = counterCreator();

counter(); // 0
counter(); // 1
counter(); // 2
counter(); // 3
```
- `counterCreator` initializes a local variable (`count`) and then returns a function. To use that function, we have to assign it to a variable (line 9). Then, every time we run the function it logs count to the console and increments it. Keep in mind, `counter()` is calling the return value of counterCreator. 
- As above, the function `counter` is a closure. It has access to the variable count and can both print and increment it, but there is no other way for our program to access that variable.

Making supporting functions inaccessible makes your code easier to refactor, easier to test, and easier to reason about for you and anyone else that wants to use your objects.