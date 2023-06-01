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

> In object-oriented programming, a class is an extensible program-code-template for creating objects, providing initial values for state (member variables) and implementations of behavior (member functions or methods).