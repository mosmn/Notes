# Defining Your Own Classes

- Describe how objects are returned from methods.
- Explain the use of the reserved word `this`.
- Define overloaded methods and constructors.
- Define class methods and variables.
- Describe how arguments are passed to parameters using the pass-by-value scheme.
- Document classes with Javadoc comments.
- Organize classes into a package.

## Returning an Object from a Method

Just as primitive data values can be returned from methods, objects can also be returned. When an object is returned from a method, it's actually the reference (or address) of the object that is being returned, not a copy of the object itself.

## The Fraction class (snippet)

```java
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        // creates 0/1
    }

    public Fraction(int number) {
        // creates number/1
    }

    public Fraction(Fraction frac) {
        // copy constructor
    }

    // Other methods...
}
```

## Sample Object-Returning Method

Here's a sample method that returns an object:

```java
public Fraction simplify() {
    Fraction simp;
    int num = getNumerator();
    int denom = getDenominator();
    int gcd = gcd(num, denom);
    simp = new Fraction(num / gcd, denom / gcd);
    return simp;
}
```

## A Sample Call to `simplify`

```java
Fraction f1 = new Fraction(24, 26);
Fraction f2 = f1.simplify();
```

## Reserved Word `this`

The reserved word `this` is a self-referencing pointer that refers to an object from the object's method. It can be used in three ways, and we'll explore all three uses in this chapter.

### 1. The Use of `this` to Refer to Receiving Object

```java
public Fraction add(Fraction frac) {
    int a, b, c, d;
    Fraction sum;
    a = this.getNumerator(); // get the receiving object's num and denom
    b = this.getDenominator();
    c = frac.getNumerator(); // get frac's num and denom
    d = frac.getDenominator();
    sum = new Fraction(a * d + b * c, b * d);
    return sum;
}
```

### Example of Using `this` to Call a Constructor from Another Constructor

```java
public Fraction(int number) {
    // creates number/1
    this(number, 1);
}

public Fraction(Fraction frac) {
    // copy constructor
    this(frac.getNumerator(), frac.getDenominator());
}
```

## Static Keyword

The `static` keyword is used for memory management and can be applied to variables, methods, blocks, and nested classes.

### Class Variable

Also known as static variables, they store values for the class in a common memory location. All objects of the same class are affected if one object changes the value of a class variable.

```java
public class Test {
    static int numOfObjects = 0;
    int value;

    public Test(int val) {
        value = val;
        numOfObjects++;
    }

    public void display() {
        System.out.println("Object's value is " + value);
        System.out.println("Number of objects created so far = " + numOfObjects);
    }
}
```

## Class Constants

Class constants are shared by all objects of the class. They should be declared using `final static`.

```java
public class Constants {
    final static double PI = 3.142;
}
```

## Class Methods

Class methods, also known as static methods, can be called without creating an instance of the class.

```java
public class MathOperations {
    public static int gcd(int m, int n) {
        // implementation of the Euclidean algorithm
    }

    public static Fraction min(Fraction f1, Fraction f2) {
        // convert to decimals and then compare
    }
}
```

## Call-by-Value Parameter Passing

In Java, method arguments are passed using a call-by-value (pass-by-value) scheme. This means that the value of the argument is passed to the matching parameter, and separate memory space is allocated for this value.

## Organizing Classes into a Package

To reuse programmer-defined classes in different programs, it's practical to organize them into packages. A package is a Java class library. Follow these steps to create a package:

1. Include the statement `package myutil;` as the first statement of the source file.
2. Use the `public` modifier in the class declaration.
3. Create a folder named `myutil` and place the class file inside.
4. Modify the `CLASSPATH` environment variable to include the folder.

## Javadoc

Javadoc is a tool that generates Java code documentation in HTML format from Java source code. It uses a predefined format for documentation comments.

```java
/**
 * Returns the sum of this Fraction and the parameter frac. The sum
 * returned is NOT simplified.
 *
 * @param frac the Fraction to add to this Fraction
 * @return the sum of this and frac
 */
public Fraction add(Fraction frac) {
    // implementation
}
```

These comments can be processed by the `javadoc` tool to generate HTML files for documentation.

For more information on Javadoc, refer to the [official documentation](https://docs.oracle.com/en/java/javase/19/javadoc/javadoc.html).

---

# Passing Objects to a Method (OLD)

- We can pass an object to a method, similar to passing int and double values.
- When passing an object, we're passing the reference (name) of the object.
- No duplicate of the object is created in the called method.

# A LibraryCard Example

## Student Class

```java
class Student {
    // Data Members
    private String name;
    private String email;

    // Constructor
    public Student() {
        name = "Unassigned";
        email = "Unassigned";
    }

    // Returns the email of this student
    public String getEmail() {
        return email;
    }

    // Returns the name of this student
    public String getName() {
        return name;
    }

    // Assigns the email of this student
    public void setEmail(String address) {
        email = address;
    }

    // Assigns the name of this student
    public void setName(String studentName) {
        name = studentName;
    }
}
```

## LibraryCard Class

```java
class LibraryCard {
    // Data Members
    // student owner of this card
    private Student owner;
    // number of books borrowed
    private int borrowCnt;

    // Constructor
    public LibraryCard() {
        owner = null;
        borrowCnt = 0;
    }

    // Number of books checked out
    public void checkOut(int numOfBooks) {
        borrowCnt = borrowCnt + numOfBooks;
    }

    // Returns the number of books borrowed
    public int getNumberOfBooks() {
        return borrowCnt;
    }

    // Returns the name of the owner of this card
    public String getOwnerName() {
        return owner.getName();
    }

    // Sets owner of this card to student
    public void setOwner(Student student) {
        owner = student;
    }

    // Returns the string representation of this card
    public String toString() {
        return "Owner Name: " + owner.getName() + "\n" +
                " Email: " + owner.getEmail() + "\n" +
                "Books Borrowed: " + borrowCnt;
    }
}
```

## Explanation

- The `LibraryCard` object is owned by a `Student`, recording the number of books being checked out.
- In the constructor of the `LibraryCard` class, `owner` is initialized to `null`, indicating that it points to no object.
- The ability to pass an object to a method is useful for multiple objects to share the same object.
- For example, if a single student owns two library cards, we can make the `owner` of two `LibraryCard` objects refer to the same `Student` object.

## Example Program

```java
class Librarian {
    public static void main(String[] args) {
        Student student;
        LibraryCard card1, card2;
      
        student = new Student();
        student.setName("Jon Java");
        student.setEmail("jj@javauniv.edu");
      
        card1 = new LibraryCard();
        card1.setOwner(student);
        card1.checkOut(3);
      
        card2 = new LibraryCard();
        card2.setOwner(student); // the same student is the owner of the second card, too
      
        System.out.println("Card1 Info:");
        System.out.println(card1.toString() + "\n");
      
        System.out.println("Card2 Info:");
        System.out.println(card2.toString() + "\n");
    }
}
```

In this example program, one `Student` object is created, and two `LibraryCard` objects are created. Both `LibraryCard` objects share the same `Student` object as their owner. The program then prints information about each card using the `toString` method.

## Comparison: Passing Objects vs. Primitive Values

### Example with Primitive Value (int)

```java
bike1.setOwnerName("Adam Smith");
// ...
public void setOwnerName(String name) {
    ownerName = name;
}
```

### Example with Object (Student)

```java
card1.setOwner(student);
// ...
public void setOwner(Student student) {
    owner = student;
}
```

### Passing Side and Receiving Side

Passing Objects to a Method

Sharing an Object:

- We pass the same `Student` object to `card1` and `card2`.
- Since we're passing a reference to the same object, the `owner` of both `LibraryCard` objects points to the same `Student` object.

## Returning an Object from a Method

- Like returning a primitive data value, we can return an object from a method.
- Returning an object means returning a reference (or an address) of the object.
- No copy of the object is returned; only the reference to the object.

### Example: Passing Object to Method

```java
public class ObjectPass {
    private int value;
    public static void main(String[] args) {
        ObjectPass p = new ObjectPass();
        p.value = 5;
        System.out.println("Before calling: " + p.value);
        increment(p);
        System.out.println("After calling: " + p.value);
    }
    public static void increment(ObjectPass a){
        a.value++;
    }
}
```

In this example, the `increment` method takes an `ObjectPass` object and increments its `value`.

### Example: Return Object from Method

TestObj Class:

```java
class TestObj {
    int x, y;

    TestObj() {
        x = 1;
    }

    TestObj updateObject() {
        TestObj obj = new TestObj();
        x = 3;
        return obj;
    }
}
```

TestRetObject Class:

```java
public class TestRetObject {
    public static void main(String[] args) {
        TestObj obj = new TestObj();

        System.out.println(obj.x);

        obj.updateObject();
        System.out.println(obj.x);
    }
}
```

### Explanation:

- The `TestObj` class has a method `updateObject` that creates a new `TestObj` object, updates its `x` value to 3, and returns the new object.
- In the `TestRetObject` class, an instance of `TestObj` is created.
- The initial value of `x` is printed, and then the `updateObject` method is called.
- After calling the method, the value of `x` is printed again, showing the changes made in the method.

# Example 1

## Test Class

```java
class Test {
    int x, other;

    public Test(int x) {
        other = x;
    }

    Test updateObject() {
        Test temp = new Test(other + 10);
        return temp;
    }
}

public class Try {
    public static void main(String[] args) {
        Test t = new Test(15);

        System.out.println("a = " + t.other);

        t = t.updateObject();
        System.out.println("b = " + t.other);
    }
}
```

### Output:

```
a = 15
b = 25
```

# Example 2

## TestObj Class

```java
class TestObj {
    int x;

    TestObj() {
        x = 0;
    }

    TestObj updateObject() {
        TestObj obj = new TestObj();
        x = 900;
        return obj;
    }

    int receiveObject(TestObj obj) {
        x = 100;
        return x;
    }

    public String toString() {
        return "Answer=" + x;
    }
}
```

## TestRetObject Class

```java
class TestRetObject {
    public static void main(String[] args) {
        TestObj obj = new TestObj();

        //****Return object from method
        obj.updateObject();
        System.out.println(obj);

        TestObj obj2 = new TestObj();
        //obj2.updateObject();
        //System.out.println(obj2);
        //obj2= obj;
        //System.out.println(obj2);
        //****Pass object to method
        //obj.receiveObject(obj);
        //System.out.println(obj);
    }
}
```

### Explanation:

- The `TestObj` class has methods for returning objects and receiving objects.
- In the `TestRetObject` class, various scenarios are commented out to demonstrate returning and receiving objects.

# Method Overloading

## TestMethodOverloading Class

```java
public class TestMethodOverloading {
    public static int average(int n1, int n2) { // A
        return (n1 + n2) / 2;
    }

    public static double average(double n1, double n2) { // B
        return (n1 + n2) / 2;
    }

    public static int average(int n1, int n2, int n3) { // C
        return (n1 + n2 + n3) / 3;
    }

    public static void main(String[] args) {
        System.out.println(average(1, 2)); // Use A
        System.out.println(average(1.0, 2.0)); // Use B
        System.out.println(average(1, 2, 3)); // Use C
        System.out.println(average(1.0, 2)); // Use B - int 2 implicitly casted to double 2.
        //average(1, 2, 3, 4); // Compilation Error No matching method
    }
}
```

### Output:

```
1
1.5
2
1.5
```

# Constructor Overloading

## Circle Class

```java
class Circle {
    double radius;
    String color;

    public Circle() { // 1st Constructor
        radius = 1.0;
        color = "red";
    }

    public Circle(double r) { // 2nd Constructor
        radius = r;
        color = "red";
    }

    public Circle(double r, String c) { // 3rd Constructor
        radius = r;
        color = c;
    }
}
```

### Explanation:

- The `Circle` class demonstrates constructor overloading with three different constructors.

# Constructor Overloading

## Rectangle Class

```java
class Rectangle {
    int x, y, width, height;

    public Rectangle() {
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }

    public Rectangle(int width, int height) {
        this();
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height) {
        this(width, height);
        this.x = x;
        this.y = y;
    }
}
```

### Explanation:

- The `Rectangle` class demonstrates constructor overloading with three different constructors. Each constructor initializes some or all of the rectangle's member variables.

# Static Keyword

## JavaStaticExample Class

```java
class JavaStaticExample {
    static int i = 10;

    static void method() {
        System.out.println("Inside Static method");
    }

    public static void main(String[] args) {
        // Accessing Static method
        JavaStaticExample.method();
        // Accessing Static Variable
        System.out.println(JavaStaticExample.i);

        // Access the same static variable and static method using Instance references
        JavaStaticExample obj1 = new JavaStaticExample();
        obj1.method();
        System.out.println(obj1.i);
    }
}
```

### Output:

```
Inside Static method
10
Inside Static method
10
```

## StaticTest Class

```java
class StaticTest {
    int multiply(int a, int b) {
        return a * b;
    }

    static int add(int a, int b) {
        return a + b;
    }
}

class StaticRunner {
    public static void main(String[] args) {
        StaticTest st = new StaticTest();

        // calling a non-static member function
        System.out.println(" 2 * 2 = " + st.multiply(2, 2));
        // calling a static member function
        System.out.println(" 2 + 3 = " + StaticTest.add(2, 3));
    }
}
```

## VariableDemo Class

As you can see in the below example that both the objects are sharing a same copy
of static variable that’s why they displayed the same value of count.

```java
class VariableDemo {
    static int count = 0;

    public void increment() {
        count++;
    }

    public static void main(String args[]) {
        VariableDemo obj1 = new VariableDemo();
        VariableDemo obj2 = new VariableDemo();
        obj1.increment();
        obj2.increment();
        System.out.println("

Obj1: count is=" + obj1.count);
        System.out.println("Obj2: count is=" + obj2.count);
    }
}
```

### Output:

```
Obj1: count is=2
Obj2: count is=2
```

## StaticExample Class

```java
class StaticExample {
    static {
        System.out.println("First Static block.");
    }

    static void display(int x) {
        System.out.println("x = " + x);
    }

    static {
        System.out.println("Second Static block.");
    }

    public static void main(String args[]) {
        display(42);
    }
}
```

### Output:

```
First Static block.
Second Static block.
x = 42
```
