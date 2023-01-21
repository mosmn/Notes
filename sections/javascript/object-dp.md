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









