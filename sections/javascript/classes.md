# Getters and Setters

## Property getters and setters

There are two kinds of object properties.
- data properties
- accessor properties

Accessor properties are represented by “getter” and “setter” methods. In an object literal they are denoted by `get` and `set`:
```js
let obj = {
  get propName() {
    // getter, the code executed on getting obj.propName
  },

  set propName(value) {
    // setter, the code executed on setting obj.propName = value
  }
};
```

For instance, we have a user object with name and surname:
```js
let user = {
  name: "John",
  surname: "Smith"
};
```
Now we want to add a fullName property, that should be "John Smith". Of course, we don’t want to copy-paste existing information, so we can implement it as an accessor:
```js
let user = {
  name: "John",
  surname: "Smith",

  get fullName() {
    return `${this.name} ${this.surname}`;
  }
};

alert(user.fullName); // John Smith
```
setter for user.fullName:
```js
let user = {
  name: "John",
  surname: "Smith",

  get fullName() {
    return `${this.name} ${this.surname}`;
  },

  set fullName(value) {
    [this.name, this.surname] = value.split(" ");
  }
};

// set fullName is executed with the given value.
user.fullName = "Alice Cooper";

alert(user.name); // Alice
alert(user.surname); // Cooper
```
From the outside, an accessor property looks like a regular one. That’s the idea of accessor properties. We don’t call user.fullName as a function, we read it normally: the getter runs behind the scenes.

## Accessor descriptors

A property descriptor is a simple JavaScript object associated with each property of the object that contains information about that property such as its value and other meta-data.

### For data properties

- To access the property descriptor of property: `Object.getOwnPropertyDescriptor(obj, propertyName)`
```js
let myObj = {
    prop1: "Hello",
    prop2: "World"
}

let descriptor = Object.getOwnPropertyDescriptor(myObj, "prop1");
console.log(descriptor);
```
Output:
```js
{
    value: "Hello",
    writable: true,
    enumerable: true,
    configurable: true
}
```
- `value` property of the property descriptor is the current value of the property
- `writable` is whether the user can assign a new value to the property
- `enumerable` is whether this property will show up in enumerations like for in loop or for of loop or Object.keys etc.
- `configurable` property tells whether the user has permission to change property descriptor such as to change the value of writable and enumerable settings.

### For accessor properties

accessor descriptor may have:
- get – a function without arguments, that works when a property is read,
- set – a function with one argument, that is called when the property is set,
- enumerable – same as for data properties,
- configurable – same as for data properties.
For instance, to create an accessor fullName with defineProperty, we can pass a descriptor with get and set:
```js
let user = {
  name: "John",
  surname: "Smith"
};

Object.defineProperty(user, 'fullName', {
  get() {
    return `${this.name} ${this.surname}`;
  },

  set(value) {
    [this.name, this.surname] = value.split(" ");
  }
});

alert(user.fullName); // John Smith

for(let key in user) alert(key); // name, surname
```
Please note that a property can be either an accessor (has get/set methods) or a data property (has a value), not both.

If we try to supply both get and value in the same descriptor, there will be an error:
```js
// Error: Invalid property descriptor.
Object.defineProperty({}, 'prop', {
  get() {
    return 1
  },

  value: 2
});
```

# Class syntax

Classes are a template for creating objects.

> In object-oriented programming, a class is an extensible program-code-template for creating objects, providing initial values for state (member variables) and implementations of behavior (member functions or methods).

The basic syntax is:
```js
class MyClass {
  // class methods
  constructor() { ... }
  method1() { ... }
  method2() { ... }
  method3() { ... }
  ...
}
```
Then use new MyClass() to create a new object with all the listed methods.

The constructor() method is called automatically by new, so we can initialize the object there.

For example:
```js
class User {

  constructor(name) {
    this.name = name;
  }

  sayHi() {
    alert(this.name);
  }

}

// Usage:
let user = new User("John");
user.sayHi();
// proof: User is a function
alert(typeof User); // function
```
What class User {...} construct really does is:
- Creates a function named User, that becomes the result of the class declaration. The function code is taken from the constructor method (assumed empty if we don’t write such method).
- Stores class methods, such as sayHi, in User.prototype.

Sometimes people say that class is a “syntactic sugar” (syntax that is designed to make things easier to read, but doesn’t introduce anything new), because we could actually declare the same thing without using the class keyword at all:
```js
// rewriting class User in pure functions

// 1. Create constructor function
function User(name) {
  this.name = name;
}
// a function prototype has "constructor" property by default,
// so we don't need to create it

// 2. Add the method to prototype
User.prototype.sayHi = function() {
  alert(this.name);
};

// Usage:
let user = new User("John");
user.sayHi();
```
The result of this definition is about the same.

## Class Expression

Just like functions, classes can be defined inside another expression, passed around, returned, assigned, etc.
Here’s an example of a class expression:
```js
let User = class {
  sayHi() {
    alert("Hello");
  }
};
```
Similar to Named Function Expressions, class expressions may have a name.

If a class expression has a name, it’s visible inside the class only:
```js
// "Named Class Expression"
// (no such term in the spec, but that's similar to Named Function Expression)
let User = class MyClass {
  sayHi() {
    alert(MyClass); // MyClass name is visible only inside the class
  }
};

new User().sayHi(); // works, shows MyClass definition

alert(MyClass); // error, MyClass name isn't visible outside of the class
```
We can even make classes dynamically “on-demand”, like this:
```js
function makeClass(phrase) {
  // declare a class and return it
  return class {
    sayHi() {
      alert(phrase);
    }
  };
}

// Create a new class
let User = makeClass("Hello");

new User().sayHi(); // Hello
```

## Getters/setters

Just like literal objects, classes may include getters/setters, computed properties etc.

Here’s an example for user.name implemented using get/set:
```js
class User {

  constructor(name) {
    // invokes the setter
    this.name = name;
  }

  get name() {
    return this._name;
  }

  set name(value) {
    if (value.length < 4) {
      alert("Name is too short.");
      return;
    }
    this._name = value;
  }

}

let user = new User("John");
alert(user.name); // John

user = new User(""); // Name is too short.
```

## Computed names

```js
class User {

  ['say' + 'Hi']() {
    alert("Hello");
  }

}

new User().sayHi();
```

## Making bound methods with class fields

functions in JavaScript have a dynamic this. It depends on the context of the call.

So if an object method is passed around and called in another context, this won’t be a reference to its object any more.

For instance, this code will show undefined:
```js
class Button {
  constructor(value) {
    this.value = value;
  }

  click() {
    alert(this.value);
  }
}

let button = new Button("hello");

setTimeout(button.click, 1000); // undefined
```

The problem is called "losing this", when passing object methods as callbacks.

That’s because setTimeout got the function `button.click`, separately from the object. 

The method setTimeout in-browser is a little special: it sets this=window for the function call (for Node.js, this becomes the timer object, but doesn’t really matter here). So for this.value it tries to get window.value, which does not exist. In other similar cases, usually this just becomes undefined.

There are two approaches to fixing it:
- Pass a wrapper-function, such as setTimeout(() => button.click(), 1000).
- Bind the method to object, e.g. in the constructor.

Class fields provide another, quite elegant syntax:
```js
class Button {
  constructor(value) {
    this.value = value;s
  }
  click = () => {
    alert(this.value);
  }
}

let button = new Button("hello");

setTimeout(button.click, 1000); // hello
```
The class field click = () => {...} is created on a per-object basis, there’s a separate function for each Button object, with this inside it referencing that object. We can pass button.click around anywhere, and the value of this will always be correct.

That’s especially useful in browser environment, for event listeners.

The basic class syntax looks like this:
```js
class MyClass {
  prop = value; // property

  constructor(...) { // constructor
    // ...
  }

  method(...) {} // method

  get something(...) {} // getter method
  set something(...) {} // setter method

  [Symbol.iterator]() {} // method with computed name (symbol here)
  // ...
}
```
`MyClass` is technically a function (the one that we provide as `constructor`), while methods, getters and setters are written to `MyClass.prototype`.

