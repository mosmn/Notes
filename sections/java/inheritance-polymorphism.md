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


## Polymorphism

- Polymorphism allows a single variable to refer

### to objects from different subclasses in the same

### inheritance hierarchy

- For example, if Cat and Dog are subclasses of

### Pet, then the following statements are valid:

```
Pet myPet;
```
```
myPet = new Dog();
```
...
myPet = **new** Cat();


### Creating the roster Array

- We can maintain our class roster using an array,

### combining objects from the Student,

### UndergraduateStudent, and GraduateStudent

### classes.

```
Student roster = new Student[ 40 ];
```
...
roster[ 0 ] = new GraduateStudent();
roster[ 1 ] = new UndergraduateStudent();
roster[ 2 ] = new UndergraduateStudent();
...


### State of the roster Array

- The roster array with elements referring to

### instances of GraduateStudent or

### UndergraduateStudent classes.


## Sample Polymorphic Message

- To compute the course grade using the roster array, we

#### execute

```
for (int i = 0; i < numberOfStudents; i++) {
roster[i].computeCourseGrade();
}
```
- If roster[i] refers to a GraduateStudent, then the

#### computeCourseGrade method of the GraduateStudent

#### class is executed.

- If roster[i] refers to an UndergraduateStudent, then the

#### computeCourseGrade method of the

#### UndergraduateStudent class is executed.


## Methods Overriding

- Subclass has the same method as declared in the

### super class.

- Method overriding is used to provide the specific

### implementation of a method which is already

### provided by its super class.

- Method overriding is used for runtime

### polymorphism.

- Rules:
    - The method must have the same name as in the super class.
    - The method must have the same parameter as in the super class.


## Methods Overriding

class Vehicle{

```
void run(){
System.out.println("Vehicle is running");
}
```
}

class Bike extends Vehicle{

```
public static void main(String args[]){
//creating an instance of child class
Bike obj = new Bike();
//calling the method with child class instance
obj.run();
}
```
}

```
Without overriding, this
calls run() of super –we
didn’t get ‘customized’ run
operation of Bike
```
```
Output:
Vehicle is running
```

## Methods Overriding

class Vehicle{
void run(){
System.out.println("Vehicle is running");
}
}
class Bike2 extends Vehicle{
//defining the same method as in the parent class
**void run(){
System.out.println("Bike is running safely");
}**
public static void main(String args[]){
//creating an instance of child class
Bike obj = new Bike();
//calling the method with child class instance
obj.run();
}
©The McGrawrequired for reproduction or display.} -Hill Companies, Inc. Permission Chapter 13- 22

```
Method overriding
```
- specific
implementation of
run() in subclass

```
Output:
Bike is running safely
```
```
Calls run() of sub
```

## The instanceof Operator

- The instanceof operator can help us learn the

### class of an object.

- The following code counts the number of

### undergraduate students.

```
int undergradCount = 0;
for (int i = 0; i < numberOfStudents; i++) {
if ( roster[i] instanceof UndergraduateStudent ) {
undergradCount++;
}
}
```

## Inheritance and Member Accessibility

- We use the following visual representation of

### inheritance to illustrate data member accessibility.

Class Hierarchy

```
This shows the inherited
components of the
superclass are part of
the subclass instance
```
Instances


## Accessibility from the Client Method

```
package one
```
```
package two
```
###### Refer to Client.java


## Accessibility of Super from Sub

- Everything except the private members of the Super class

#### is visible from a method of the Sub class.


## Inheritance and Constructors

- When object of subclass is created, constructor for

### the superclass and constructor for the subclass

### are both executed.

- Superclass constructor must execute first and then

### the subclass constructor executes.


class ClassA {
public ClassA() {
System.out.println("In superclass constructor");
}
}
class **ClassB** extends ClassA{
public ClassB( ) {
System.out.println("In subclass constructor");
}
}
Clas Demo{
public static void main(String[] args) {
ClassB child = new ClassB();
}
}
Output:
In superclass constructor
In subclass constructor

## Inheritance and Constructors


### Inheritance and Constructors

- Unlike members of a superclass, constructors of a

### superclass are not inherited by its subclasses.

- You must define a constructor for a class or use

### the default constructor added by the compiler.

- The statement

###### super();

### is written in subclass’s constructor to call the

### superclass’s constructor.

- Subclass’s constructor can choose which

### superclass’s constructor (from the available

### constructors) to execute.


### Inheritance and Constructors

- Subclass’s constructor can choose which

### superclass’s constructor (from the available

### constructors) to execute.

- Eg.

###### //calls to superclass’s constructor with no-arg

###### super();

###### //calls to superclass’s constructor with arg

###### super(10, 20);

- super(); statement must be written as the first

### statement in subclass’s constructor.


### Inheritance and Constructors

public class Vehicle {
private int numWheels;
private double milesPerGallon;

```
public Vehicle() {
this(0, 0.0);
System.out.println("Default object, values not set.");
}
```
```
public Vehicle(int numWheels, double milesPerGallon) {
this.numWheels = numWheels;
this.milesPerGallon = milesPerGallon;
}
```
public String toString(){
return "Number of wheels " + numWheels + ". Average number of miles
per gallon " + milesPerGallon + ".\n";
}
}


### Inheritance and Constructors

public class Car extends Vehicle {

public Car() {
super();
}
public Car(double milesPerGallon) {
super(4, milesPerGallon);
}
}

public class Motorcycle extends Vehicle{

public Motorcycle(double milesPerGallon) {
super(2, milesPerGallon);
}
}


### Inheritance and Constructors

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
Default object, values not set.
Number of wheels 0. Average number of miles per gallon 0.0.
Number of wheels 4. Average number of miles per gallon 10.0.
Number of wheels 2. Average number of miles per gallon 25.0.
```

### Keyword super

- Keyword super also can be used to access superclass

#### members such as the overridden methods.

```
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
```
Output:
Printed in Superclass.
Printed in Subclass.
```

### Abstract Superclasses and Abstract Methods

- When we define a superclass, we often do not

### need to create any instances of the superclass.

- Depending on whether we need to create

### instances of the superclass, we must define the

### class differently.

- We will study examples based on the Student

### superclass defined earlier.


## Definition: Abstract Class

- An abstract class is a class
    - defined with the modifier abstract OR
       **abstract** class Student{
       ...
       }
    - that contains an abstract method OR
    - that does not provide an implementation of an inherited

#### abstract method

- No instances can be created from an abstract class.


## Definition: Abstract Class

- An abstract method is a method with the keyword

#### abstract, and it ends with a semicolon instead of a method

#### body.

- private methods and static methods may not be declared abstract.
- Eg.

abstract public void computeCourseGrade();


## Case 1

- Student Must Be Undergraduate or Graduate
    - If a student must be either an undergraduate or a

#### graduate student, we only need instances of

#### UndergraduateStudent or GraduateStudent.

- Therefore, we must define the Student class as

#### abstract so that no instances may be created of it.


## Case 2

- Student Does Not Have to Be Undergraduate or

### Graduate.

- In this case, we may design the Student class in

### one of two ways.

- We can make the Student class instantiable.
- We can leave the Student class abstract and add a third

#### subclass, OtherStudent, to handle a student who does

#### not fall into the UndergraduateStudent or

#### GraduateStudent categories.


### Which Approach to Use

- The best approach depends on the particular

### situation.

- When considering design options, we can ask

### ourselves which approach allows easier

### modification and extension.


### Interface

- An interface is a reference type, similar to a class, that

#### can contain only constants, method signatures, and

#### nested types.

- A Java interface defines only the behavior (methods)

#### of objects

- It includes only public methods
- There are no method bodies
- It does not include any data members except public constants
- Interfaces cannot be instantiated—they can only be

#### implemented by classes or extended by other

#### interfaces.


### Interface

- Defining an interface is similar to creating a new class:

```
public interface OperateCar {
// constant declarations, if any
```
```
// method signatures
int turn(Direction direction, // An enum with values RIGHT, LEFT
double radius, double startSpeed, double endSpeed);
int changeLanes(Direction direction, double startSpeed, double endSpeed);
int signalTurn(Direction direction, boolean signalOn);
int getRadarFront(double distanceToCar, double speedOfCar);
int getRadarRear(double distanceToCar, double speedOfCar);
......
// more method signatures
}
```
- Note that the method signatures have no braces (method body)

###### and are terminated with a semicolon.


### Interface

- To use an interface, you write a class that implements

#### the interface.

- When an instantiable class implements an interface, it

#### provides a method body for each of the methods

#### declared in the interface. For example,

```
public class OperateBMW760iimplementsOperateCar {
// the OperateCar method signatures, with implementation --
// for example:
int signalTurn(Direction direction, boolean signalOn) {
//code to turn BMW's LEFT turn indicator lights on
//code to turn BMW's LEFT turn indicator lights off
//code to turn BMW's RIGHT turn indicator lights on
//code to turn BMW's RIGHT turn indicator lights off
}
}
```

- A class that implements an interface must implement all of the interface's
    methods.
- It is possible, however, to define a class that does not implement all of the
    interface's methods, provided that the class is declared to be abstract. For
    example,

```
abstract class X implements Y {
// implements all but one method of Y
}
```
```
class XX extends X {
// implements the remaining method in Y
}
```

## Inheritance vs. Interface

- The Java interface is used to share common behavior

#### (only method headers) among the instances of

#### different classes.

- Inheritance is used to share common code (including

#### both data members and methods) among the instances

#### of related classes.

- In your program designs, remember to use the Java

#### interface to share common behavior. Use inheritance to

#### share common code.

- If an entity A is a specialized form of another entity B,

#### then model them by using inheritance. Declare A as a

#### subclass of B.


## Abstract Class vs. Interface

- Consider using abstract classes if any of these statements apply to

###### your situation:

- You want to share code among several closely related classes.
- You expect that classes that extend your abstract class have many common
    methods or fields, or require access modifiers other than public (such as protected
    and private).
- You want to declare non-static or non-final fields. This enables you to define
    methods that can access and modify the state of the object to which they belong.
- Consider using interfaces if any of these statements apply to your

###### situation:

- You expect that unrelated classes would implement your interface. For example, the
    interfaces Comparable and Cloneable are implemented by many unrelated classes.
- You want to specify the behaviorof a particular data type, but not concerned about
    who implements its behavior.
- You want to take advantage of multiple inheritance of type.

```
Ref: https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
```

