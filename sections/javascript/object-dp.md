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

