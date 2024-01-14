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

Using factories is a powerful way to organize and contain the code you’re writing. For example, if we’re writing any sort of game, we’re probably going to want objects to describe our players and encapsulate all of the things our players can do (functions!).

```js
const Player = (name, level) => {
  let health = level * 2;
  const getLevel = () => level;
  const getName  = () => name;
  const die = () => {
    // uh oh
  };
  const damage = x => {
    health -= x;
    if (health <= 0) {
      die();
    }
  };
  const attack = enemy => {
    if (level < enemy.getLevel()) {
      damage(1);
      console.log(`${enemy.getName()} has damaged ${name}`);
    }
    if (level >= enemy.getLevel()) {
      enemy.damage(1);
      console.log(`${name} has damaged ${enemy.getName()}`);
    }
  };
  return {attack, damage, getLevel, getName}; // only the returned variables and functions are public, and the rest are private(health, die).
};

const jimmie = Player('jim', 10);
const badGuy = Player('jeff', 5);
jimmie.attack(badGuy);
```

## Inheritance with factories

```js
const Person = (name) => {
  const sayName = () => console.log(`my name is ${name}`);
  return {sayName};
}

const Nerd = (name) => {
  // simply create a person and pull out the sayName function with destructuring assignment syntax!
  const {sayName} = Person(name);
  const doSomethingNerdy = () => console.log('nerd stuff');
  return {sayName, doSomethingNerdy};
}

const jeff = Nerd('jeff');

jeff.sayName(); // my name is jeff
jeff.doSomethingNerdy(); // nerd stuff
```
This pattern is great because it allows you to pick and choose which functions you want to include in your new object. 

If you want to go ahead and lump ALL of another object in, you can certainly do that as well with `Object.assign`
```js
const Nerd = (name) => {
  const prototype = Person(name);
  const doSomethingNerdy = () => console.log('nerd stuff');
  return Object.assign({}, prototype, {doSomethingNerdy});
}
```
The `Object.assign()` static method copies all enumerable own properties from one or more source objects to a target object. It returns the modified target object.
- syntax: `Object.assign(target, ...sources)`
- Parameters
  - target: The target object — what to apply the sources' properties to, which is returned after it is modified.
  - sources: The source object(s) — objects containing the properties you want to apply.
```js
const target = { a: 1, b: 2 };
const source = { b: 4, c: 5 };

const returnedTarget = Object.assign(target, source);

console.log(target);
// Expected output: Object { a: 1, b: 4, c: 5 }

console.log(returnedTarget === target);
// Expected output: true
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

# The Module Pattern

Without using the module pattern, its going to look like this:
```js
const calculator = () => {
  const add = (a, b) => a + b;
  const sub = (a, b) => a - b;
  const mul = (a, b) => a * b;
  const div = (a, b) => a / b;
  return {
    add,
    sub,
    mul,
    div,
  };
};

const calc = calculator();

calc.add(3,5); // 8
calc.sub(6,2); // 4
calc.mul(14,5534); // 77476
```

Modules are actually very similar to factory functions. The main difference is how they’re created.

Meet a module:
```js
const calculator = (() => {
  const add = (a, b) => a + b;
  const sub = (a, b) => a - b;
  const mul = (a, b) => a * b;
  const div = (a, b) => a / b;
  return {
    add,
    sub,
    mul,
    div,
  };
})();

calculator.add(3,5); // 8
calculator.sub(6,2); // 4
calculator.mul(14,5534); // 77476
```
The concepts are exactly the same as the factory function. However, instead of creating a factory that we can use over and over again to create multiple objects, the module pattern wraps the factory in an IIFE (Immediately Invoked Function Expression).

The concept is simple: write a function, wrap it in parentheses, and then immediately call the function by adding () to the end of it.

## Namespacing

A useful side-effect of encapsulating the inner workings of our programs into objects is namespacing. 
- Namespacing is a technique that is used to avoid naming collisions in our programs. 
  - For example, it’s easy to imagine scenarios where you could write multiple functions with the same name. In our calculator example, what if we had a function that added things to our HTML display, and a function that added numbers and operators to our stack as the users input them? It is conceivable that we would want to call all three of these functions add which, of course, would cause trouble in our program. 
- If all of them were nicely encapsulated inside of an object, then we would have no trouble: `calculator.add()`, `displayController.add()`, `operatorStack.add()`.