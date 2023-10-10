# Java Basics Cheat Sheet

## Class Declaration and Object Creation

```java
import javax.swing.*;

class Ch2Sample1 {
    public static void main(String[] args) {
        JFrame myWindow;
        myWindow = new JFrame();
        myWindow.setSize(300, 200);
        myWindow.setTitle("My First Java Program");
        myWindow.setVisible(true);
    }
}
```

- Declare a name.
- Create an object.
- Use an object.

## Object Declaration

```java
JFrame myWindow;
Account customer;
Student jan, jim, jon;
Vehicle car1, car2;
```

- One object is declared here.
- Class name must be defined before this declaration.

## Object Creation

```java
myWindow = new JFrame();
customer = new Customer();
jon = new Student("John Java");
car1 = new Vehicle();
```

- Name of the object we are creating here.
- An instance of the class is created.
- No arguments are used here.

## Identifiers

- A Java identifier is a sequence of letters, digits, underscores (_), and dollar signs ($) with the first one being a non-digit.
- Valid identifiers: `MyFirstApplication`, `FunTime`, `DEFAULT_VALUE`.
- Invalid identifiers: `45678`, `Sample Program`, `hello,there`.

## Java Standard Naming Convention

```java
Robot robot;
```

- Class name and object name follow the Java naming convention.

## Declaration vs. Creation

```java
Customer customer;
customer = new Customer();
```

1. The identifier `customer` is declared, and space is allocated in memory.
2. A `Customer` object is created, and the identifier `customer` is set to refer to it.

## Sending a Message

```java
myWindow.setVisible(true);
account.deposit(200.0);
student.setName("john");
car1.startEngine();
```

- Name of the object to which we are sending a message.
- Method name, the name of the message we are sending.
- Argument, the argument we are passing with the message.

## Standard Input

```java
import java.util.Scanner;

Scanner scanner;
scanner = new Scanner(System.in);
String input;
System.out.print("Enter your input(s): ");
input = scanner.nextLine();
System.out.println("I entered: " + input);
```

- Using a `Scanner` object to input data from the standard input (`System.in`).
- Reading input using `nextLine()`.

## Standard Output

```java
System.out.print("I Love Java");
System.out.println("How do you do?");
System.out.println("My name is Jon Java.");
```

- Using `print` and `println` methods of `System.out` to display output.

## String

```java
String text = "Espresso";
text.substring(6, 8);
text.length();
text.indexOf("gram");
```

- Using `substring`, `length`, and `indexOf` methods with `String` objects.
- Concatenating strings with `+` operator.

## Date

```java
import java.util.Date;
Date today;
today = new Date();
```

- Using the `Date` class to represent a time instance.

## SimpleDateFormat

```java
import java.text.SimpleDateFormat;

SimpleDateFormat sdf1, sdf2;
sdf1 = new SimpleDateFormat("MM/dd/yy");
sdf2 = new SimpleDateFormat("MMMM dd, yyyy");
sdf1.format(today);
sdf2.format(today);
```

- Using `SimpleDateFormat` to format `Date` objects.
