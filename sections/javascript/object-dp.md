# Objects as a Design Pattern

grouping things into objects

insted of this:
    
```js
const personOneName = 'John';
const personOneAge = 30;
const personTwoName = 'Jane';
const personTwoAge = 25;
```

we can do this:
    
```js
const personOne = {
    name: 'John',
    age: 30
};
const personTwo = {
    name: 'Jane',
    age: 25
};
```
that way we can group things together and access them easily

but what if we are dealing with something more complicated like a shopping site with large inventory, manually creating objects for each item is not a good idea, so we can use a constructor function to create objects for us, this brings us to the next section.......

# Object Constructors

constructor functions are used to create objects, they are like blueprints for creating objects, they are used to create multiple objects with the same properties and methods, they are also used to create objects with different properties and methods, they are also used to create objects with the same properties and methods but with different values.

```js
function Person(name, age) {
    this.name = name;
    this.age = age;
    this.sayHello = () => {
        console.log(`Hello, my name is ${this.name}`);
    };
}
```

call the constructor function with the `new` keyword to create a new object:

```js
const personOne = new Person('John', 30);
console.log(personOne.name); // John
const personTwo = new Person('Jane', 25);
console.log(personTwo.name); // Jane

personOne.sayHello(); // Hello, my name is John
personTwo.sayHello(); // Hello, my name is Jane
```

to create the same constructor using arrow functions:

```js
const Person = (name, age) => {
    return {
        name,
        age,
        sayHello: () => {
            console.log(`Hello, my name is ${name}`);
        }
    };
};
```
note that this will not work with the `new` keyword.

# Prototypes

In simple language, a prototype is a shared object. so instead of reapeting the same methodes(that have nothing unique about them) for each instance of an object, we can use prototypes to share the same methodes for all instances of an object. look at this example:
![image](/imgs/prototype.png)
in this example, objects on the instance level(meaning instances created by the constructor) have their own properties with unique values, but they share the same methodes on the prototype level, so if we change the methodes on the prototype level, all the instances will be affected. this is how it looks like without the prototype:
![image](/imgs/pt2.png)
as you can see, the methodes are repeated for each instance, this is not a good idea, so we can use prototypes to solve this problem.

### how its implemented

```js
function apple(color, weight) {
    this.color = color;
    this.weight = weight;
}

apple.prototype.eat = function () {
    // add code here
};

apple.prototype.throw = function () {
    // add code here
};

// this will create a prototype for the apple object that looks like this:
apple.prototype = {
    eat()
    throw()
}
// which can be accessed by all instances of the apple object
```

### Recommended methode for prototype inheritance

Setting the prototype of an object using the `Object.create()` method.

```js
function banana(color, weight) {
    this.color = color;
    this.weight = weight;
}

banana.prototype.eat = function () {
    // add code here
};

banana.prototype.throw = function () {
    // add code here
};

function apple(color, weight) {
    this.color = color;
    this.weight = weight;
}

apple.prototype = Object.create(banana.prototype);
// this will copy the prototype of the banana object to the apple object

// we can also add new methodes to the apple object
apple.prototype.peel = function () {
    // add code here
};

// this will create a prototype for the apple object that looks like this:
apple.prototype = {
    eat()
    throw()
    peel()
};
```

## Prototype Property & Prototype Attribute

- Prototype property is a property of the constructor function, it is used to access the prototype of the constructor function, it is used to add new methodes to the prototype of the constructor function. it looks like this: `constructorFunction.prototype.whatEver`

- Prototype attribute is an attribute of the object, it is used to access the prototype of the object, it is used to access the methodes of the prototype of the constructor function.

```js
function apple(color, weight) {
    this.color = color;
    this.weight = weight;
}

let apple1 = new apple('red', 100); // apple1 initallized with the apple constructor function and as such its prototype attribute is `apple.prototype`
```

### Why is Prototype Important and When is it Used?

#### Prototype Property: Prototype-based Inheritance

Prototype is important in JavaScript because JavaScript does not have classical inheritance based on Classes (as most object oriented languages do), and therefore all inheritance in JavaScript is made possible through the prototype property. JavaScript has a prototype-based inheritance mechanism.Inheritance is a programming paradigm where objects (or Classes in some languages) can inherit properties and methods from other objects (or Classes). In JavaScript, you implement inheritance with the prototype property. For example, you can create a Fruit function (an object, since all functions in JavaScript are objects) and add properties and methods on the Fruit prototype property, and all instances of the Fruit function will inherit all the Fruit’s properties and methods.

#### Prototype Attribute: Accessing Properties on Objects

Prototype is also important for accessing properties and methods of objects. The prototype attribute (or prototype object) of any object is the “parent” object where the inherited properties were originally defined.This is loosely analogous to the way you might inherit your surname from your father—he is your “prototype parent.” If we wanted to find out where your surname came from, we would first check to see if you created it yourself; if not, the search will move to your prototype parent to see if you inherited it from him. If it was not created by him, the search continues to his father (your father’s prototype parent).

Similarly, if you want to access a property of an object, the search for the property begins directly on the object. If the JS runtime can’t find the property there, it then looks for the property on the object’s prototype—the object it inherited its properties from.
If the property is not found on the object’s prototype, the search for the property then moves to prototype of the object’s prototype (the father of the object’s father—the grandfather). And this continues until there is no more prototype (no more great-grand father; no more lineage to follow). This in essence is the prototype chain: the chain from an object’s prototype to its prototype’s prototype and onwards. And JavaScript uses this prototype chain to look for properties and methods of an object.
If the property does not exist on any of the object’s prototype in its prototype chain, then the property does not exist and undefined is returned.

This prototype chain mechanism is essentially the same concept we have discussed above with the prototype-based inheritance, except we are now focusing specifically on how JavaScript accesses object properties and methods via the prototype object.

# this

Before starting, let's familiarize with a couple of terms:

- Invocation of a function is executing the code that makes the body of a function, or simply calling the function. For example parseInt function invocation is parseInt('15').
- Context of an invocation is the value of this within function body.
- Scope of a function is the set of variables and functions accessible within a function body.

`this` depends on the context of the invocation. there are 4 types of function invocations in JavaScript:

- [Function Invocation](#function-invocation)
- [Method Invocation](#method-invocation)
- [Constructor Invocation](#constructor-invocation)
- [indirect Invocation](#indirect-invocation)

## Function Invocation

Function invocation is basically when you call a function without any object or method. for example:

```js
function sayHello(name) {
    console.log(`Hello ${name}`);
}

sayHello('John'); // this is a function invocation
```
dont confuse this with something like `obj.sayHello('John')`, this is a method invocation, not a function invocation.

### this in function invocation

in function invocation, `this` is the global object, which is `window` in the browser.

```js
function sum(a, b) {
  console.log(this === window); // => true
  this.myNumber = 20; // add 'myNumber' property to global object
  return a + b;
}
// sum() is invoked as a function
// this in sum() is a global object (window)
sum(15, 16);     // => 31
window.myNumber; // => 20, since we gave the global object(aka window) a property called 'myNumber' using `this`
```
At the time sum(15, 16) is called, JavaScript automatically sets this as the global object (window in a browser).

if we use `this` in the global scope, it will be the global object, which is `window` in the browser. same as using it inside a function scope.

```js
console.log(this === window); // => true
this.myNumber = 20; // add 'myNumber' property to global object
```

### strict mode function invocation

if we use strict mode, `this` will be `undefined` in function invocation.

Strict mode provides more security and helps to avoid some common errors. Strict mode is declared by adding the string "use strict" to the beginning of a script or a function. once we use strict mode, `this` will be `undefined` in function invocation.

```js
function multiply(a, b) {
  'use strict'; // enable the strict mode
  console.log(this === undefined); // => true
  return a * b;
}
// multiply() function invocation with strict mode enabled
// this in multiply() is undefined
multiply(2, 5); // => 10
```

### Pitfalls

A Common Mistake is thinking that `this` is the same in inner and outer functions. This is not the case. `this` is determined by the context of the invocation(aka call), not the context of the function definition.

```js
const numbers = {
  numberA: 5,
  numberB: 10,
  sum: function() {
    console.log(this === numbers); // => true
    function calculate() {
      // this is window or undefined in strict mode
      console.log(this === numbers); // => false
      return this.numberA + this.numberB;
    }
    return calculate();
  }
};
numbers.sum(); // => NaN or throws TypeError in strict mode
```
`calculate()` is a function invocation (but not method invocation), thus here this is the global object window or undefined in strict mode. Even if the outer function `numbers.sum()` has the context as `numbers` object, it doesn't have influence here. there are 2 ways to solve this problem using `calculate.call(this)` to invoke calculate, or the better alternative is to use arrow function.

```js
const numbers = {
  numberA: 5,
  numberB: 10,
  sum: function() {
    console.log(this === numbers); // => true
    const calculate = () => {
      // this is numbers object
      console.log(this === numbers); // => true
      return this.numberA + this.numberB;
    }
    return calculate();
  }
};
numbers.sum(); // => 15
``` 

## Method Invocation

A method is a function stored in a property of an object. For example:

```js
const myObject = {
  // helloMethod is a method
  helloMethod: function() {
    return 'Hello World!';
  }
};
const message = myObject.helloMethod();
console.log(message); // => 'Hello World!'
```

### this in method invocation

`this` is the object that owns the method in a method invocation

```js
const calc = {
  num: 0,
  increment() {
    console.log(this === calc); // => true
    this.num += 1;
    return this.num;
  }
};
// method invocation. this is calc
calc.increment(); // => 1
calc.increment(); // => 2
```
straightforward, When invoking a method on an object, `this` is the object that owns the method.

it works the same when an object inherits a method from its prototype.

```js
const myDog = {
  name: 'Fido';
};

const myDOG = Object.create({
    sayName() {
        console.log(this.name);
    }
});

myDOG.name = 'Fido';
myDOG.sayName(); // => Fido
```
### Pitfalls

A common mistake happens when separating the method from the object. `const alone = myObj.myMethode` when the metode is called `alone()`, detatched from the object, you might think that this is the object myObject on which the method was defined. WRONG! since the methode is called without an object, `this` is the global object (function invocation).

```js
function Pet(type, legs) {
  this.type = type;
  this.legs = legs;
  this.logInfo = function() {
    console.log(this === myCat); // => false
    console.log(`The ${this.type} has ${this.legs} legs`);
  }
}
const myCat = new Pet('Cat', 4);

// logs "The undefined has undefined legs"
// or throws a TypeError in strict mode
setTimeout(myCat.logInfo, 1000);
```
you might think here that `setTimeout(myCat.logInfo, 1000)` will call `myCat.logInfo()` but unfortunately this is not the case. when a methode is passed as a parameter its seperated from its object.

to fixe this we can use `bind()` to bind the methode to its object. but we can also use arrow function to fixe this problem.

```js
function Pet(type, legs) {
  this.type = type;
  this.legs = legs;
  this.logInfo = function() {
    console.log(this === myCat); // => true
    console.log(`The ${this.type} has ${this.legs} legs`);
  }
}
const myCat = new Pet('Cat', 4);

// logs "The Cat has 4 legs"
setTimeout(myCat.logInfo.bind(myCat), 1000);
```
`myCat.logInfo.bind(myCat)` returns a new function that executes exactly like logInfo, but has this as myCat, even in a function invocation.

## Constructor Invocation

its preformed when `new` keyword is used to create a new object. as we saw in [Object constructor](#object-constructors) section.

```js
function Country(name, traveled) {
  this.name = name ? name : 'United Kingdom';
  this.traveled = Boolean(traveled); // transform to a boolean
}
Country.prototype.travel = function() {
  this.traveled = true;
};
// Constructor invocation
const france = new Country('France', false);
// Constructor invocation
const unitedKingdom = new Country;
france.travel(); // Travel to France
```

### this in constructor invocation

`this` is the newly created object in a constructor invocation. lets check the context in the following example.

```js
function Foo () {
  // this is fooInstance
  this.property = 'Default Value';
}
// Constructor invocation
const fooInstance = new Foo();
fooInstance.property; // => 'Default Value'
```
`new Foo()` is a constructor invocation where the context of `this` is the newly created object `fooInstance`.

### Pitfalls

A common mistake is to forget the `new` keyword when invoking a constructor. when you forget the `new` keyword, `this` is the global object (function invocation).

```js
function Vehicle(type, wheelsCount) {
  this.type = type;
  this.wheelsCount = wheelsCount;
  return this;
}
// Function invocation
const car = Vehicle('Car', 4);
car.type; // => 'Car'
car.wheelsCount // => 4
car === window // => true
```
You might think it works well for creating and initializing new objects.However, `this` is window object in a function invocation (see [Function invocation](#function-invocation)), thus Vehicle('Car', 4) sets properties on the window object. This is a mistake. A new object is not created.

## Indirect Invocation

when a function is called using `call()` or `apply()` methods its indirect invocation. they are from the list of methods that are available on every function object, and they are used to invoke a function with a specific context. `call()` and `apply()` are very similar, the only difference is that `call()` accepts a list of arguments, while `apply()` accepts an array of arguments.

```js
function sum(number1, number2) {
  return number1 + number2;
}
sum.call(undefined, 10, 2);    // => 12
sum.apply(undefined, [10, 2]); // => 12
```

### this in indirect invocation

`this` is the first argument of `.call()` or `.apply()` in an indirect invocation

```js
const rabbit = { name: 'White Rabbit' };
function concatName(string) {
  console.log(this === rabbit); // => true
  return string + this.name;
}
// Indirect invocations
concatName.call(rabbit, 'Hello ');  // => 'Hello White Rabbit'
concatName.apply(rabbit, ['Bye ']); // => 'Bye White Rabbit'
```
The indirect invocation is useful when a function should be executed with a specific context. For example, to solve the context problems with function invocation, where `this` is always `window` or `undefined` in strict mode (see [Function invocation](#strict-mode-function-invocation)). It can be used to simulate a method call on an object (see the previous code sample).

Another practical example is creating hierarchies of classes in ES5 to call the parent constructor:

```js
function Runner(name) {
  console.log(this instanceof Rabbit); // => true
  this.name = name;
}
function Rabbit(name, countLegs) {
  console.log(this instanceof Rabbit); // => true
  // Indirect invocation. Call parent constructor.
  Runner.call(this, name);
  this.countLegs = countLegs;
}
const myRabbit = new Rabbit('White Rabbit', 4);
myRabbit; // { name: 'White Rabbit', countLegs: 4 }
```

## Resource (Arrow function & Bound function)

- [For more stuff in detail](https://dmitripavlutin.com/gentle-explanation-of-this-in-javascript/#3-method-invocation)





