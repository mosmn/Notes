# The SOLID Design Principles and JavaScript

These principles are as follows:
- The Single Responsibility Principle
- The Open/Closed Principle
- The Liskov Substitution Principle
- The Interface Segregation Principle
- The Dependency Inversion Principle

## Single Responsibility

Single Responsibility Principle: states that a class (or object or module… you get the point) should only have one responsibility(It’s fine to call other functionality, but it shouldn’t be written there.). This doesn’t mean that an object can only do one thing, but it does mean that everything an object does should be part of one responsibility.

Another way to think about the Single Responsibility Principle is that __a given method/class/component should have a single reason to change.__ Otherwise, if an object is trying to have multiple responsibilities, changing one aspect might affect another.

This description can be a little misleading as it would seem to suggest that an object should only do one thing. What is meant by this assertion, however, is that an object should have a cohesive set of behaviors, together comprising a single responsibility that, if changed, would require the modification of the object’s definition.  More simply, an object’s definition should only have to be modified due to changes to a single responsibility within the system.

__When an object encapsulates multiple responsibilities, changes to the object for one of the responsibilities can negatively impact the others.__ by decoupling responsibilities, we can make our code more flexible and resilient to changes.

But how do we identify whether a given set of behaviors constitutes a single responsibility?

### Object Role Stereotypes

Are a set of general, pre-established roles which commonly occur across object-oriented architectures. This helps provide a set of templates for decomposing(breaking down) behavior into cohesive components.

Stereotypes:
- Information holder – an object designed to know certain information and provide that information to other objects.
- Structurer – an object that maintains relationships between objects and information about those relationships.
- Service provider – an object that performs specific work and offers services to others on demand.
- Controller – an object designed to make decisions and control a complex task.
- Coordinator – an object that doesn’t make many decisions but, in a rote or mechanical way, delegates work to other objects.
- Interfacer – an object that transforms information or requests between distinct parts of a system.

While not prescriptive, this set of role stereotypes provides an excellent mental framework for aiding in the software design process.  Once you have an established  set of role stereotypes to work within, you’ll find it easier to group behaviors into cohesive groups of responsibilities related to the object’s intended role.

### Example

```js
class Car {
    constructor(make, model) {
        this.make = make;
        this.model = model;
    }

    start() {
        if (...) { // Logic to determine whether or not the car should start
            this.errorLog(`The car ${this.make} ${this.model} started.`);
            return true;
        }
        this.errorLog(`The car ${this.make} ${this.model} failed to start.`);
        return false;
    }

    errorLog(message) {
        console.log(message);
    } // This method is a violation of the Single Responsibility Principle
}
```
Let’s look at a bad example. In the code below, the Car class has a single method; start. When this method is called the car may or may not start, depending on some logic which isn’t included here as it’s not important. The class will then log some information depending on the outcome. But notice how the logging functionality is implemented as a method of this class. This violates the single responsibility principle, because the logic for logging the information should not be a responsibility of the Car class.
```js
class ErrorLog {
    static log(message) {
        console.log(message);
    }
}

class Car {
    constructor(make, model) {
        this.make = make;
        this.model = model;
    }

    start() {
        if (...) { // Logic to determine whether or not the car should start
            ErrorLog.log(`The car ${this.make} ${this.model} started.`);
            return true;
        }
        ErrorLog.log(`The car ${this.make} ${this.model} failed to start.`);
        return false;
    }
}
```
The logger is stored in a separate class, which means its functionality is separate to the Car class. The Car class can be changed, moved around or even deleted without affecting the logger class. Likewise, if a change is required to the logger class, it only needs to be carried out in a single place.

## Open/Closed Principle

The open-closed principle says that code should be open for extension, but closed for modification. What this means is that if we want to add additional functionality, we should be able to do so simply by extending the original functionality, without the need to modify it.

To explain this, let’s look at an example. Below we have a Vehicle class. When a Vehicle instance is created, we pass in the fuel capacity and fuel efficiency. To get our range, we simply multiply our capacity by our efficiency.
```js
class Vehicle {
    constructor(fuelCapacity, fuelEfficiency) {
        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
    }

    getRange() {
        return this.fuelCapacity * this.fuelEfficiency;
    }
}

const standardVehicle = new Vehicle(10, 15);

console.log(standardVehicle.getRange()); // Outputs '150'
```
But let’s say we add a new type of vehicle; a hybrid vehicle. This vehicle doesn’t just have standard fuel-based range, it also has an electric range which it can use as well. To find out the range now, we need to modify our getRange() method to check if the vehicle is hybrid, and add its electric range if so:
```js
class Vehicle {
    constructor(fuelCapacity, fuelEfficiency) {
        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
    }

    getRange() {
        let range = this.fuelCapacity * this.fuelEfficiency;

        if (this instanceof HybridVehicle) {
            range += this.electricRange;
        }
        return range;
    }
}

class HybridVehicle extends Vehicle {
    constructor(fuelCapacity, fuelEfficiency, electricRange) {
        super(fuelCapacity, fuelEfficiency);
        this.electricRange = electricRange;
    }
}

const standardVehicle = new Vehicle(10, 15);
const hybridVehicle = new HybridVehicle(10, 15, 50);

console.log(standardVehicle.getRange()); // Outputs '150'
console.log(hybridVehicle.getRange()); // Outputs '200'
```
This violates the open-closed principle, because whilst adding our new HybridVehicle class we have had to go back and modify the code of our Vehicle class in order to make it work. Going forward, every time we add a new type of vehicle that might have different parameters for its range, we’ll have to continually modify that existing getRange function.

Instead what we could do, is to override the getRange method in the HybridVehicle class, giving the correct output for both Vehicle types, without every modifying the original code:
```js
class Vehicle {
    constructor(fuelCapacity, fuelEfficiency) {
        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
    }

    getRange() {
        return this.fuelCapacity * this.fuelEfficiency;
    }
}

class HybridVehicle extends Vehicle {
    constructor(fuelCapacity, fuelEfficiency, electricRange) {
        super(fuelCapacity, fuelEfficiency);
        this.electricRange = electricRange;
    }

    getRange() {
        return (this.fuelCapacity * this.fuelEfficiency) + this.electricRange;
    }
}

const standardVehicle = new Vehicle(10, 15);
const hybridVehicle = new HybridVehicle(10, 15, 50);

console.log(standardVehicle.getRange()); // Outputs '150'
console.log(hybridVehicle.getRange()); // Outputs '200'
```

## Liskov Substitution Principle

The Liskov substitution principle states that any class should be substitutable for its parent class without unexpected consequences. In others words, if the classes Cat and Dog extend the class Animal, then we would expect all of the functionality held within the Animal class to behave normally for a Cat and Dog object.

A classic example of a Liskov substitution violation is the “square & rectangle problem”. In this problem, it is posed that a Square class can inherit from a Rectangle class. On the face of it, this makes sense; both shapes have two sides, and both calculate their area by multiplying their sides by each other.

But the problem arises when we try to utilise some Rectangle functionality on a Square object. Let’s look at an example:
```js
class Rectangle {
    constructor(height, width) {
        this.height = height;
        this.width = width;
    }

    setHeight(newHeight) {
        this.height = newHeight;
    }
}

class Square extends Rectangle {}

const rectangle = new Rectangle(4, 5);
const square = new Square(4, 4);

console.log(`Height: ${rectangle.height}, Width: ${rectangle.width}`); // Outputs 'Height: 4, Width: 5' (correct)
console.log(`Height: ${square.height}, Width: ${square.width}`); // Outputs 'Height: 4, Width: 4' (correct)

square.setHeight(5);
console.log(`Height: ${square.height}, Width: ${square.width}`); // Outputs 'Height: 5, Width: 4' (wrong)
```
In this example we initialise a Rectangle and Square, and output their dimensions. We then call the Rectangle.setHeight() on the Square object, and output its dimensions again. What we find is that the square now has a different height than its length, which of course makes for an invalid square.

This can be solved, using polymorphism, an if statement in the Rectangle class, or a variety of other methods. But the real cause of the issue is that Square is not a good child class of Rectangle, and that in reality, perhaps both shapes should inherit from a Shape class instead.

## Interface Segregation Principle

The interface segregation principle states that an entity should never be forced to implement an interface that contains elements which it will never use. For example, a Penguin should never be forced to implement a Bird interface if that Bird interface includes functionality relating to flying, as penguins (spoiler alert) cannot fly.

Now, this functionality is a little more difficult to demonstrate using JavaScript, due to its lack of interfaces. However, we can demonstrate it by using composition.

Composition is a subject all by itself, but I’ll give a very high level introduction: Instead of inheriting an entire class, we can instead add chunks of functionality to a class. Here’s an example that actually addresses the interface segregation principle:
```js
class Penguin {}

class Bird {}

const flyer = {
    fly() {
        console.log(`Flap flap, I'm flying!`);
    },
};

Object.assign(Bird.prototype, flyer);

const bird = new Bird();
bird.fly(); // Outputs 'Flap flap, I'm flying!'

const penguin = new Penguin();
penguin.fly(); // 'Error: penguin.fly is not a function'
```
What this example does is to add the flying functionality (or interface) only to the class(es) that require it. This means that penguins won’t be given the ability to fly, whereas birds will.

This is one method of adhering to the interface segregation principle, but it is a fairly rough example (as, once again, JavaScript doesn’t play well with interfaces).

## Dependency Inversion Principle

The dependency injection principle states that high level code should never depend on low level interfaces, and should instead use abstractions. It’s all about decoupling code.

Not following? I don’t blame you, but it’s surprisingly simple.

Let’s say we have a piece of software that runs an online store, and within that software one of the classes (PurchaseHandler) handles the final purchase. This class is capable of charging the user’s credit card, and does so by using a PayPal API:
```js
class PurchaseHandler {
    processPayment(paymentDetails, amount) {
        // Complicated, PayPal specific logic goes here
        const paymentSuccess = PayPal.requestPayment(paymentDetails, amount);

        if (paymentSuccess) {
            // Do something
            return true;
        }

        // Do something
        return false;
    }
}
```
The problem here is that if we change from PayPal to Square (another payment processor) in 6 months time, this code breaks. We need to go back and swap out our PayPal API calls for Square API calls. But in addition, what if the Square API wants different types of data? Or perhaps it wants us to “stage” a payment first, and then to process it once staging has completed?

That’s bad, and so we need to abstract the functionality out instead.

Rather than directly call the PayPal API from our payment page, we’ll instead create another class called PaymentHandler. The interface for this class will remain the same no matter what underlying payment system we use, even if the two systems are completely different. We’ll still need to make changes to the PaymentHandler interface if we change payment processor, but our higher level interface remains unchanged.
```js
class PurchaseHandler {
    processPayment(paymentDetails, amount) {
        const paymentSuccess = PaymentHandler.requestPayment(
            paymentDetails,
            amount
        );

        if (paymentSuccess) {
            // Do something
            return true;
        }

        // Do something
        return false;
    }
}

class PaymentHandler {
    requestPayment(paymentDetails, amount) {
        // Complicated, PayPal specific logic goes here
        return PayPal.requestPayment(paymentDetails, amount);
    }
}
```
Now you may be looking at this and thinking “but wait, that’s way more code”, and you’d be right. Like many of the SOLID principles (and indeed OO principles in general), the objective is less about writing less code or writing it quicker, and more about writing better code. The above change will save you days or maybe even weeks further down the line, in exchange for spending a few hours on it now.

# Loosely Coupled Objects

Obviously, all of our objects are intended to work together to form our final application. You should take care, however, to make sure that your individual objects can stand alone as much as possible. Tightly coupled objects are objects that rely so heavily on each other that removing or changing one will mean that you have to completely change another one - a real bummer.

This one is related pretty strongly to ‘Single Responsibility’ but takes a different angle. As an example, if we were writing a game and wanted to completely change how the User Interface worked, we should be able to do that without completely reworking the game logic. So we should be able to start off writing our game using primarily console.log()s and then add in a bunch of DOM functions later without touching the game logic.

Some ways to reduce coupling between modules:

## Patterns to Reduce Coupling

These patterns are often a variation of the so-called observer pattern. One such variation is referred to as the Pub/Sub or Publish/Subscribe pattern.

In some cases the observer registers itself with the event emitter directly in order to be notified whenever a certain event occurs. The downside to this approach is that an observer “knows” about the event emitter object and what observables or events to observe through the registration process.

We can do better. There are many versions of the Pub/Sub pattern that involve a mediator object, which helps to further minimize coupling between modules. A mediator object is an object that isolates the publisher from the subscriber.

THINK OF IT LIKE THIS: Airplanes never communicate directly with each other. Airplanes instead only provide information to, and receive information from the tower, and therefore do not “know” about one another without information from the tower.

There are a variety of libraries available to implement Pub/Sub-type patterns.[PubSubJS](https://github.com/mroderick/PubSubJS) is a topic-based JavaScript Pub/Sub library. Topic-based simply means that there are topics that a module can either subscribe to, publish to, or both. A module is also able to unsubscribe from a topic if needed.