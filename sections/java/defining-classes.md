# Programmer-Defined Classes

The following Java code demonstrates the use of programmer-defined classes:

```java
class BicycleRegistration {
    public static void main(String[] args) {
        Bicycle bike1, bike2;
        String owner1, owner2;

        bike1 = new Bicycle( ); // Create and assign values to bike1
        bike1.setOwnerName("Adam Smith");

        bike2 = new Bicycle( ); // Create and assign values to bike2
        bike2.setOwnerName("Ben Jones");

        owner1 = bike1.getOwnerName( ); // Output the information
        owner2 = bike2.getOwnerName( );
        
        System.out.println(owner1 + " owns a bicycle.");
        System.out.println(owner2 + " also owns a bicycle.");
    }
}
```

## The Definition of the Bicycle Class

```java
class Bicycle {
    // Data Member
    private String ownerName;
    
    // Constructor: Initializes the data member
    public Bicycle( ) {
        ownerName = "Unknown";
    }
    
    // Returns the name of this bicycle's owner
    public String getOwnerName( ) {
        return ownerName;
    }
    
    // Assigns the name of this bicycle's owner
    public void setOwnerName(String name) {
        ownerName = name;
    }
}
```

## Multiple Instances

Once the Bicycle class is defined, we can create multiple instances:

```java
Bicycle bike1, bike2;

bike1 = new Bicycle( );
bike1.setOwnerName("Adam Smith");
bike2 = new Bicycle( );
bike2.setOwnerName("Ben Jones");
```

This code demonstrates creating instances of the `Bicycle` class, setting owner names, and displaying ownership information.

main class ( ): 
```java
bike1.setOwnerName("Adam Smith");
```
Bicycle class ( ):
```java
public void setOwnerName(String name)
{
 ownerName = name;
}
```

## Data Member Declaration

To declare a data member in Java, you use the following syntax:
```java
<modifiers> <data type> <name>;
```

## Method Declaration

To declare a method in Java, you use the following syntax:
```java
<modifier> <return type> <method name>(<parameters>) {
    <statements>
}
```

- `void`: A method that does not return a value.
- Example:
  ```java
  public void setOwnerName(String name) {
      ownerName = name;
  }

  public String getOwnerName( ) {
      return ownerName;
  }
  ```

- A value-returning method: Returns a value to the caller when called. The return statement should match the declared return type.
- Example:
  ```java
  public String getOwnerName( ) {
      return ownerName;
  }
  ```

- Accessors: Methods that return information about an object. Commonly referred to as "get methods."
- Mutators: Methods that set a property of an object. Commonly referred to as "set methods."

## Constructor

A constructor is a special method executed when a new instance of the class is created. The constructor has the following syntax:
```java
public <class name>(<parameters>) {
    <statements>
}
```

- `<class name>` is the name of the class to which the constructor belongs.
- Constructors are used to initialize data members and perform any other necessary initialization tasks when a new instance is created.

For example, in the context of a `Bicycle` class:
```java
public Bicycle( ) {
    ownerName = "Unknown";
}
```

The `Bicycle` constructor initializes the `ownerName` data member to a default value when a new `Bicycle` instance is created.

## The Program Structure and Source Files

In Java, each class definition is typically stored in a separate source file. For example, if you have two classes, `Bicycle` and `Account`, each class will be defined in its own source file.

## Defining and Using Multiple Classes

In Java, you can define and use multiple classes within a program. Below is an example program that uses both the `Bicycle` and `Account` classes:

```java
class SecondMain {
    // This sample program uses both the Bicycle and Account classes
    public static void main(String[] args) {
        Bicycle bike;
        Account acct;
        
        String myName = "Jon Java";
        
        bike = new Bicycle( );
        bike.setOwnerName(myName);
        
        acct = new Account( );
        acct.setOwnerName(myName);
        acct.setInitialBalance(250.00);
        
        acct.add(25.00);
        acct.deduct(50);
        
        // Output some information
        System.out.println(bike.getOwnerName() + " owns a bicycle and");
        System.out.println("has $" + acct.getCurrentBalance() + " left in the bank");
    }
}
```

The program defines a `SecondMain` class and uses both the `Bicycle` and `Account` classes to demonstrate their functionality.

## Account Class

```java
class Account {
    private String ownerName;
    private double balance;
    
    public Account( ) {
        ownerName = "Unassigned";
        balance = 0.0;
    }
    
    public void add(double amt) {
        balance = balance + amt;
    }
    
    public void deduct(double amt) {
        balance = balance - amt;
    }
    
    public double getCurrentBalance( ) {
        return balance;
    }
    
    public String getOwnerName( ) {
        return ownerName;
    }
    
    public void setInitialBalance(double bal) {
        balance = bal;
    }
    
    public void setOwnerName(String name) {
        ownerName = name;
    }
}
```

The `Account` class has methods for managing an account's balance, owner's name, and related operations. The example demonstrates creating an `Account` instance and performing various operations on it.

This allows you to see how Java programs can use multiple classes to organize and manage different aspects of your application.

## Changing Any Class to a Main Class

In Java, you can define the `main` method in any class to make that class the entry point for a program. Here are examples of classes that have the `main` method defined within them:

### CombineBicycle.java

This class defines the `Bicycle` class and includes a `main` method for demonstrating the use of the `Bicycle` class:

```java
class Bicycle {
    private String ownerName;

    public String getOwnerName( ) {
        return ownerName;
    }

    public void setOwnerName(String name) {
        ownerName = name;
    }

    public static void main(String[] args) {
        Bicycle myBike;
        myBike = new Bicycle( );
        myBike.setOwnerName("Jon Java");
        System.out.println(myBike.getOwnerName() + " owns a bicycle");
    }
}
```

### Computer and Laptop Classes

This example demonstrates two classes, `Computer` and `Laptop`, where the `main` method is defined within the `Computer` class:

```java
class Laptop {
    Laptop() {
        System.out.println("Constructor of Laptop class.");
    }

    void laptop_method() {
        System.out.println("99% Battery available.");
    }
}

class Computer {
    Computer() {
        System.out.println("Constructor of Computer class.");
    }

    void computer_method() {
        System.out.println("Power gone! Shut down your PC soon...");
    }

    public static void main(String[] args) {
        Computer my = new Computer();
        Laptop your = new Laptop();
        my.computer_method();
        your.laptop_method();
    }
}
```

In the `Computer` class, the `main` method demonstrates the interaction between the `Computer` and `Laptop` classes.

By defining the `main` method within any class, you can make that class the starting point for running a Java program.

## Arguments and Parameters

An argument is a value we pass to a method, as demonstrated in the following code:

```java
class Account {
    // ...
    public void add(double amt) {
        balance = balance + amt;
    }
    // ...
}

class Sample {
    public static void main(String[] args) {
        Account acct = new Account();
        // ...

        acct.add(400);
        // ...
    }
    // ...
}
```

- An **argument** is a value passed to a method.

- A **parameter** is a placeholder in the called method that holds the value of the passed argument.

- The number of arguments and parameters must be the same.

- Arguments and parameters are paired from left to right.

- The matched pair must be assignment-compatible (e.g., you cannot pass a double argument to an int parameter).

```java
public class DemoMain {
    public static void main(String[] args) {
        Demo demo = new Demo();
        int i = 5;
        int k = 14;
        demo.compute(i, k, 20);
        //demo.compute(i, k, 20.00);
    }
}

public class Demo {
    //public void compute(int i, int j, double x) {
    public void compute(int i, int j, int x) {
        System.out.println(i);
        System.println(j);
        System.println(x);
    }
}
```

## Memory Allocation

When it comes to memory allocation:

- Separate memory space is allocated for the receiving method.

- Values of arguments are passed into the memory allocated for parameters.

# Java toString Method

The `toString` method in Java is utilized to obtain a string representation of an object. Here's an example using a `LibraryCard` class:

```java
class LibraryCard {
    // Data Members
    // Student owner of this card
    private Student owner;
    // Number of books borrowed
    private int borrowCnt;
    // Returns the string representation of this card
    public String toString() {
        return "Owner Name: " + owner.getName() + "\n" +
               " Email: " + owner.getEmail() + "\n" +
               "Books Borrowed: " + borrowCnt;
    }

    public static void main(String[] args) {
        LibraryCard card = new LibraryCard();
        System.out.println(card);
    }
}
```

- The `toString()` method is used to get a string representation of an object.

- It is defined in the Object class.

- By overriding the `toString()` method of the Object class, we can return values of the object, reducing the need to write extensive code.

### The Importance of the `toString()` Method

- An object in Java can have a nested structure, where data members point to instances of other classes, forming a complex hierarchy.
- To make it convenient for users of a class to obtain printable information about an instance, the `toString()` method is used.
- Without a `toString()` method, programmers would need to write code to fetch the values of data members individually, which can be tedious.
- The `toString()` method allows for the display of information about an instance by calling just one method, simplifying the process.

### Example: Implementation of `toString()` Method

Here's an example of the implementation of the `toString()` method within a `LibraryCard` class:

```java
class LibraryCard {
    // Data Members
    // Student owner of this card
    private Student owner;
    // Number of books borrowed
    private int borrowCnt;

    // Constructor
    public LibraryCard(){
        owner = null;
        borrowCnt = 0;
    }

    // Number of books checked out
    public void checkOut(int numOfBooks) {
        borrowCnt = borrowCnt + numOfBooks;
    }

    // Get the number of books borrowed
    public int getNumberOfBooks(){
        return borrowCnt;
    }

    // Get the name of the owner of this card
    public String getOwnerName(){
        return owner.getName( );
    }

    // Set the owner of this card to a student
    public void setOwner(Student student) {
        owner = student;
    }

    // Returns the string representation of this card
    public String toString(){
        return "Owner Name: " + owner.getName() + "\n" +
               " Email: " + owner.getEmail() + "\n" +
               "Books Borrowed: " + borrowCnt;
    }
}
```

### Example Usage:

In the `Librarian` class:

```java
public class Librarian {
    public static void main(String[] args) {
        Student student;
        LibraryCard card1, card2;
        student = new Student( );
        student.setName("Jon Java");
        student.setEmail("jj@javauniv.edu");
        card1 = new LibraryCard( );
        card1.setOwner(student);
        card1.checkOut(3);
        card2 = new LibraryCard( );
        card2.setOwner(student); // the same student is the owner of the second card, too
        System.out.println("Card1 Info:");
        System.out.println(card1.toString() + "\n");
        System.out.println("Card2 Info:");
        System.out.println(card2.toString() + "\n");
    }
}
```

- The `toString()` method simplifies the display of information about instances.

### The `this` Keyword

The `this` keyword is used to:

1. Refer to the current class's instance variable.
2. Refer to the current class's constructor.
3. Refer to current class methods.

Example:

```java
public class Circle {
    double radius; // instance variable called "radius"
    
    public Circle(double radius) { // Method's argument also called "radius"
        this.radius = radius; // "this.radius" refers to this instance's member variable
        // "this.radius" refers to the member variable, while "radius" resolves to the method's argument.
    }
    // ...
}
```

- The `this` keyword is used to resolve naming conflicts between instance variables and method arguments.

- The `this()` constructor call can be used to invoke the current class constructor, enabling constructor chaining.

- `this` has various other usages in Java beyond the ones mentioned.

# Constructors in Java

- Constructors are used to initialize the data members of a class fully, ensuring that an instance is created in a valid state.

- The primary purpose of a constructor is to set the initial state of an object.

- Constructors play a vital role in ensuring that objects are created with the necessary initial values.

### Handling Initial Balance

Consider the following code:

```java
Account acct;
acct = new Account( );
acct.setInitialBalance(500);
acct.setInitialBalance(300);
```

- This code sets the initial balance multiple times, which is logically inconsistent.

- There's no built-in constraint in Java that limits the number of times a method like `setInitialBalance` can be called.

- The existence of the `setInitialBalance` method can be problematic and can be eliminated.

### Improved Constructor

An improved constructor can solve these problems:

```java
public Account(double startingBalance) {
    ownerName = "Unassigned";
    balance = startingBalance;
}
```

- This new constructor takes an argument, `startingBalance`, which sets the initial balance of the account.

- The `ownerName` is initialized to "Unassigned."

- The old constructor can be replaced by this new constructor.

- Instances are created by passing an argument when calling the `new` operator, like this:

```java
Account acct;
acct = new Account(25.00);
```

- Creating an instance without an initial balance argument is no longer possible because there is no matching constructor without parameters.

### Constructor Purpose

- The main purpose of a constructor is to ensure that instances are created in a valid state by initializing the data members of a class.

- In the context of an account, it could involve setting the balance to meet minimum requirements, ensuring the account is valid from the start.

# Information Hiding and Visibility Modifiers
• The modifiers public and private designate the
accessibility of data members and methods.
• If a class component (data member or method) is
declared private, client classes cannot access it.
• If a class component is declared public, client
classes can access it.
• Internal details of a class are declared private and
hidden from the clients. This is information hiding.