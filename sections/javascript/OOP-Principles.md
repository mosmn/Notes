# The SOLID Design Principles and JavaScript

These principles are as follows:
- The Single Responsibility Principle
- The Open/Closed Principle
- The Liskov Substitution Principle
- The Interface Segregation Principle
- The Dependency Inversion Principle

## Single Responsibility

Single Responsibility Principle: states that a class (or object or module… you get the point) should only have one responsibility. This doesn’t mean that an object can only do one thing, but it does mean that everything an object does should be part of one responsibility.

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
function Product(id, description) {
    this.getId = function() {
        return id;
    };
    this.getDescription = function() {
        return description;
    };
}

function Cart(eventAggregator) {
    var items = [];

    this.addItem = function(item) {
        items.push(item);
    };
}

var products = [
    new Product(1, "Star Wars Lego Ship"),
    new Product(2, "Barbie Doll"),
    new Product(3, "Remote Control Airplane")],
    cart = new Cart();

(function() {
    function addToCart() {
        var productId = $(this).attr('id');
        var product = $.grep(products, function(x) {
            return x.getId() == productId;
        })[0];
        cart.addItem(product);

        var newItem = $('<li></li>')
            .html(product.getDescription())
            .attr('id-cart', product.getId())
            .appendTo("#cart");
    }

    products.forEach(function(product) {
        var newItem = $('<li></li>')
            .html(product.getDescription())
            .attr('id', product.getId())
            .dblclick(addToCart)
            .appendTo("#products");
    });
})();
```
While not overly complex, this example illustrates a number of unrelated responsibilities which are grouped together within a single anonymous function. Let’s consider each responsibility:

First, we have behavior defined to handle populating the Cart model when an item is double-clicked.

Second, we have behavior defined to add items to the cart view when an item is double-clicked.

Third, we have behavior defined to populate the products view with the initial set of products.

Let’s break these three responsibilities out into their own objects:
```js
function Event(name) {
    this._handlers = [];
    this.name = name;
}
Event.prototype.addHandler = function(handler) {
    this._handlers.push(handler);
};
Event.prototype.removeHandler = function(handler) {
    for (var i = 0; i < handlers.length; i++) {
        if (this._handlers[i] == handler) {
            this._handlers.splice(i, 1);
            break;
        }
    }
};
Event.prototype.fire = function(eventArgs) {
    this._handlers.forEach(function(h) {
        h(eventArgs);
    });
};

var eventAggregator = (function() {
    var events = [];

    function getEvent(eventName) {
        return $.grep(events, function(event) {
            return event.name === eventName;
        })[0];
    }

    return {
        publish: function(eventName, eventArgs) {
            var event = getEvent(eventName);

            if (!event) {
                event = new Event(eventName);
                events.push(event);
            }
            event.fire(eventArgs);
        },

        subscribe: function(eventName, handler) {
            var event = getEvent(eventName);

            if (!event) {
                event = new Event(eventName);
                events.push(event);
            }

            event.addHandler(handler);
        }
    };
})();

function Cart() {
    var items = [];

    this.addItem = function(item) {
        items.push(item);
        eventAggregator.publish("itemAdded", item);
    };
}

var cartView = (function() {
    eventAggregator.subscribe("itemAdded", function(eventArgs) {
        var newItem = $('<li></li>')
            .html(eventArgs.getDescription())
            .attr('id-cart', eventArgs.getId())
            .appendTo("#cart");
    });
})();

var cartController = (function(cart) {
    eventAggregator.subscribe("productSelected", function(eventArgs) {
        cart.addItem(eventArgs.product);
    });
})(new Cart());

function Product(id, description) {
    this.getId = function() {
        return id;
    };
    this.getDescription = function() {
        return description;
    };
}

var products = [
    new Product(1, "Star Wars Lego Ship"),
    new Product(2, "Barbie Doll"),
    new Product(3, "Remote Control Airplane")];

var productView = (function() {
    function onProductSelected() {
        var productId = $(this).attr('id');
        var product = $.grep(products, function(x) {
            return x.getId() == productId;
        })[0];
        eventAggregator.publish("productSelected", {
            product: product
        });
    }

    products.forEach(function(product) {
        var newItem = $('<li></li>')
            .html(product.getDescription())
            .attr('id', product.getId())
            .dblclick(onProductSelected)
            .appendTo("#products");
    });
})();
```
In our revised design, we’ve removed our anonymous function and replace it with objects to coordinate each of the separate set of responsibilities.  A cartView was introduced to coordinate the population of the cart display, a cartController was introduced to coordinate the population of the cart model, and a productView was introduced to coordinate the population of the products display.  We also introduced an Event Aggregator to facilitate communication between the objects in a loosely-coupled way.  While this design results in a larger number of objects, each object now focuses on fulfilling a specific role within the overall orchestration with minimal coupling between the objects.

# Loosely Coupled Objects

Obviously, all of our objects are intended to work together to form our final application. You should take care, however, to make sure that your individual objects can stand alone as much as possible. Tightly coupled objects are objects that rely so heavily on each other that removing or changing one will mean that you have to completely change another one - a real bummer.

This one is related pretty strongly to ‘Single Responsibility’ but takes a different angle. As an example, if we were writing a game and wanted to completely change how the User Interface worked, we should be able to do that without completely reworking the game logic. So we should be able to start off writing our game using primarily console.log()s and then add in a bunch of DOM functions later without touching the game logic.