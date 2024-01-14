# Inheritance and Polymorphism

## Introduction to Inheritance

In Java, inheritance is a mechanism wherein a class (subclass) acquires all the properties and behaviors of a parent (super) class. This allows the creation of new classes built upon existing ones, enabling the reuse of methods and fields from parent classes. Additionally, new methods and fields can be added to the current classes.

## Simple Example

To illustrate inheritance, consider modeling different types of pets such as dogs and cats. The `Pet` class serves as the superclass, while `Dog` and `Cat` classes are subclasses inheriting from `Pet`. The example demonstrates how subclasses can override inherited methods or introduce new ones.

```java
Pet
 |
 |-- Dog
 |
 |-- Cat
```

### The Pet Class

```java
class Pet {
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String petName) {
        name = petName;
    }

    public String speak() {
        return "I’m your cuddly little pet.";
    }
}
```

### Subclasses of The Pet Class

```java
class Cat extends Pet {
    public String speak() {
        return "Don’t give me orders.\nI speak only when I want to.";
    }
}

class Dog extends Pet {
    public String fetch() {
        return "Yes, master. Fetch I will.";
    }
}
```

### Sample Usage of the Subclasses

```java
Dog myDog = new Dog();
System.out.println(myDog.speak());
System.out.println(myDog.fetch());

Cat myCat = new Cat();
System.out.println(myCat.speak()); // This will cause an ERROR as 'fetch' is not defined in the Cat class
```

## Defining Classes with Inheritance

To define a subclass from a superclass, use the `extends` clause. The syntax is:

```java
class Subclass extends Superclass {
    // ...
}
```

### Defining Classes with Inheritance

Classes with an "is-a" relationship can be modeled using inheritance. For example:

```java
class Cat extends Mammal { }

class FulltimeEmployee extends Employee { }
```

Simple rules:
- Define common or generic fields and methods in the superclass.
- Define specific fields and methods in the respective subclass.

## Modeling Two Types of Students

To model undergraduate and graduate students, two approaches can be considered: unrelated classes or an inheritance hierarchy.

### Classes for the Class Roster

For the Class Roster example, three classes are designed:
- Student
- UndergraduateStudent
- GraduateStudent

The `Student` class incorporates behavior and data common to both `UndergraduateStudent` and `GraduateStudent` objects, while the latter two contain specific behaviors and data.

## Inheritance Hierarchy

A visual representation of the hierarchy can help understand the relationships between classes.

### The Protected Modifier

The `protected` modifier allows a data member or method to be accessed within its own class, any class derived from it, and any classes in the same package. This is contrasted with `public` (accessible to any class) and `private` (accessible only within its own class).

## Visibility Modifier

Visibility modifiers include `public`, `protected`, default/package (omitted first modifier), and `private`. Visibility decreases from own class to any classes, own class and subclasses, and own class and any classes in the same package.

```java
Visibility:      public      protected      default      private
                 ------------------------------------------------
Own class             Y              Y            Y             Y
                 ------------------------------------------------
Any classes          Y              Y            Y             N
                 ------------------------------------------------
Own class and
Subclasses           Y              Y            N             N
                 ------------------------------------------------
Any classes in
the same package    Y              Y            N             N
                 ------------------------------------------------
Own class and
Any classes
in the same
package             Y              N            N             N
                 ------------------------------------------------
```

This organization emphasizes the principles of inheritance, showcasing its application in modeling different types of objects and establishing relationships between classes.


# Polymorphism

## Introduction to Polymorphism

Polymorphism allows a single variable to refer to objects from different subclasses within the same inheritance hierarchy. For instance, if `Cat` and `Dog` are subclasses of `Pet`, statements like `Pet myPet; myPet = new Dog();` demonstrate the flexibility of polymorphism.

## Creating the Roster Array

To manage a class roster, an array can be utilized, accommodating objects from the `Student`, `UndergraduateStudent`, and `GraduateStudent` classes.

```java
Student roster = new Student[40];
roster[0] = new GraduateStudent();
roster[1] = new UndergraduateStudent();
roster[2] = new UndergraduateStudent();
// ...
```

## Sample Polymorphic Message

To compute the course grade using the roster array, a loop can be employed to invoke the `computeCourseGrade` method for each student. This demonstrates polymorphic behavior based on the actual type of the object being referred to.

```java
for (int i = 0; i < numberOfStudents; i++) {
    roster[i].computeCourseGrade();
}
```

## Methods Overriding

Method overriding allows a subclass to provide a specific implementation of a method declared in the superclass. Rules include maintaining the same method name and parameters as in the superclass.

### Example:

```java
class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

class Bike extends Vehicle {
    void run() {
        System.out.println("Bike is running safely");
    }

    public static void main(String args[]) {
        Bike obj = new Bike();
        obj.run();
    }
}
```

Output:
```
Bike is running safely
```

## The `instanceof` Operator

The `instanceof` operator helps determine the class of an object. For example, to count the number of undergraduate students in the roster:

```java
int undergradCount = 0;
for (int i = 0; i < numberOfStudents; i++) {
    if (roster[i] instanceof UndergraduateStudent) {
        undergradCount++;
    }
}
```

## Inheritance and Member Accessibility

Visual representation of inheritance illustrates data member accessibility. Everything except private members of the superclass is visible from a method of the subclass.

### Class Hierarchy

```
Class Hierarchy
    |
Superclass
    |
Subclass
    |
Instances
```

## Accessibility from the Client Method

The accessibility of members between packages is demonstrated, emphasizing the visibility of protected, default, and public members.

```java
package one;
```
```java
package two;
// Refer to Client.java
```

## Accessibility of Super from Sub

In a subclass, everything except private members of the superclass is visible from a method of the subclass. This facilitates the utilization of inherited components.


# Inheritance and Constructors

## Introduction to Constructors in Inheritance

When an object of a subclass is created, the constructor for both the superclass and the subclass is executed. The superclass constructor must execute first, followed by the subclass constructor.

```java
class ClassA {
    public ClassA() {
        System.out.println("In superclass constructor");
    }
}

class ClassB extends ClassA {
    public ClassB() {
        System.out.println("In subclass constructor");
    }
}

class Demo {
    public static void main(String[] args) {
        ClassB child = new ClassB();
    }
}
```

Output:
```
In superclass constructor
In subclass constructor
```

## Inheritance and Constructors

- Constructors of a superclass are not inherited by subclasses.
- Superclass constructors must be explicitly invoked using `super()` in the subclass constructor.
- The `super();` statement must be the first statement in the subclass constructor.

### Example:

```java
public class Vehicle {
    private int numWheels;
    private double milesPerGallon;

    public Vehicle() {
        this(0, 0.0);
        System.out.println("Default object, values not set.");
    }

    public Vehicle(int numWheels, double milesPerGallon) {
        this.numWheels = numWheels;
        this.milesPerGallon = milesPerGallon;
    }

    public String toString() {
        return "Number of wheels " + numWheels + ". Average number of miles per gallon " + milesPerGallon + ".\n";
    }
}

public class Car extends Vehicle {
    public Car() {
        super();
    }

    public Car(double milesPerGallon) {
        super(4, milesPerGallon);
    }
}

public class Motorcycle extends Vehicle {
    public Motorcycle(double milesPerGallon) {
        super(2, milesPerGallon);
    }
}

public class VehicleProject {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car(10.0);
        Motorcycle motor = new Motorcycle(25.0);

        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(motor.toString());
    }
}
```

Output:
```
Default object, values not set.
Number of wheels 0. Average number of miles per gallon 0.0.
Number of wheels 4. Average number of miles per gallon 10.0.
Number of wheels 2. Average number of miles per gallon 25.0.
```

## Keyword `super`

- The keyword `super` is used to access superclass members, including overridden methods.
- Example:

```java
public class Superclass {
    public void printMethod() {
        System.out.println("Printed in Superclass.");
    }
}

public class Subclass extends Superclass {
    // overrides printMethod in Superclass
    public void printMethod() {
        super.printMethod();
        System.out.println("Printed in Subclass.");
    }

    public static void main(String[] args) {
        Subclass s = new Subclass();
        s.printMethod();
    }
}
```

Output:
```
Printed in Superclass.
Printed in Subclass.
```

## Abstract Superclasses and Abstract Methods

- An abstract class is defined with the `abstract` modifier and contains either an abstract method or does not provide an implementation for an inherited abstract method.
- No instances can be created from an abstract class.

### Example:

```java
abstract class Student {
    // ...
    abstract public void computeCourseGrade();
}
```

## Definition: Abstract Class

- An abstract class is defined with the modifier `abstract` OR
  ```
  abstract class Student {
      // ...
  }
  ```
- It contains an abstract method OR
- It does not provide an implementation of an inherited abstract method.

## Definition: Abstract Method

- An abstract method is a method with the `abstract` keyword, and it ends with a semicolon instead of a method body.
- Private methods and static methods may not be declared abstract.

Example:

```java
abstract public void computeCourseGrade();
```

## Case 1: Student Must Be Undergraduate or Graduate

- If a student must be either an undergraduate or a graduate student, the `Student` class should be declared as abstract so that no instances may be created.

## Case 2: Student Does Not Have to Be Undergraduate or Graduate

- If a student does not have to be an undergraduate or graduate, we can make the `Student` class instantiable or leave it abstract and add a third subclass, `OtherStudent`, to handle a student who does not fall into the undergraduate or graduate categories.

## Interface

- An interface is a reference type that can contain only constants, method signatures, and nested types.
- It defines only the behavior (methods) of objects and includes only public methods.
- Interfaces cannot be instantiated but can be implemented by classes or extended by other interfaces.

Example:

```java
public interface OperateCar {
    // constant declarations, if any
    // method signatures
    int turn(Direction direction, double radius, double startSpeed, double endSpeed);
    int changeLanes(Direction direction, double startSpeed, double endSpeed);
    int signalTurn(Direction direction, boolean signalOn);
    int getRadarFront(double distanceToCar, double speedOfCar);
    int getRadarRear(double distanceToCar, double speedOfCar);
    // more method signatures
}
```

## Inheritance vs. Interface

- Inheritance is used to share common code, including both data members and methods, among the instances of related classes.
- Interface is used to share common behavior (only method headers) among instances of different classes.

### When to Use Inheritance:

- When entities A and B have a specialized relationship (A is a specialized form of B).

### When to Use Interface:

- When unrelated classes would implement the same behavior.
- When you want to specify the behavior of a particular data type without being concerned about who implements the behavior.
- When you want to take advantage of multiple inheritance of type.

## Abstract Class vs. Interface

- Use abstract classes when:
  - You want to share code among several closely related classes.
  - Classes that extend the abstract class have many common methods or fields.
  - Non-static or non-final fields are required.
- Use interfaces when:
  - Unrelated classes would implement the same behavior.
  - You want to specify the behavior of a particular data type without being concerned about who implements it.
  - You want to take advantage of multiple inheritance of type.

Reference: [Oracle Java Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

