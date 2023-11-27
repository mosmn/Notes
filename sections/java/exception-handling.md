## Exceptions and Assertions

### Definition

An exception represents an error condition that can occur during the normal course of program execution. When an exception occurs, or is thrown, the normal sequence of flow is terminated. The exception-handling routine is then executed; we say the thrown exception is caught.

### Not Catching Exceptions

```java
Scanner scanner = new Scanner(System.in);

System.out.println("Enter integer:");

int number = scanner.nextInt();

/* Exception in thread "main" java.lang.InputMismatchException
   at java.util.Scanner.throwFor(Scanner.java:819)
   at java.util.Scanner.next(Scanner.java:1431)
   at java.util.Scanner.nextInt(Scanner.java:2040)
   at java.util.Scanner.nextInt(Scanner.java:2000)
   at Ch8Sample1.main(Ch8Sample1.java:35)
   Error message for invalid input */
```

```java
// AgeInputVer1.java

Output:
How old are you? 20
Already had your birthday this year? (Y or N) n

You are born in 1997

// Ch8AgeInputMain.java

20

// age
2000

// bornYr
2020

// thisYear
n

// answer
2018 - 20
2020 – 20 – 1 = 1999
```

### Catching an Exception

```java
System.out.print(prompt);

try {
    age = scanner.nextInt();
} catch (InputMismatchException e){
    System.out.println("Invalid Entry. " + "Please enter digits only");
}
```

```java
// AgeInputVer2.java

Let’s modify the getAge method in AgeInputVer1 so that it will loop until a valid input is entered (int value).

Output:
How old are you? 12a
Invalid Entry. Please enter digits only.
How old are you? 12
Already had your birthday this year? (Y or N)Y
You are born in 2008
```

### Getting Information

There are two methods we can call to get information about the thrown exception:

- `getMessage`
- `printStackTrace`

```java
try {
    // ...
} catch (InputMismatchException e){
    scanner.next(); // remove the leftover garbage char
    System.out.println(e.getMessage());
    e.printStackTrace();
}
```

## Quick Check

What will be displayed on the console window when the following code is executed, and the user enters `abc123` and `14`?

```java
Scanner scanner = new Scanner(System.in);

try {
    int num1 = scanner.nextInt();
    System.out.println("Input 1 accepted");
    int num2 = scanner.nextInt();
    System.out.println("Input 2 accepted");
} catch (InputMismatchException e) {
    System.out.println("Invalid Entry");
}
```

If the user enters `abc123` and `14` as input, the code will catch the `InputMismatchException` for the first input attempt (`abc123`). The catch block will be executed, and "Invalid Entry" will be displayed on the console. The program will not proceed to the second input.

So, the expected output on the console will be:

```
Invalid Entry
```

## Multiple catch Blocks

A single try-catch statement can include multiple catch blocks, one for each type of exception.

```java
while (true) {
    System.out.print(prompt);
    try {
        age = scanner.nextInt();
        if (age < 0) {
            throw new Exception("Negative age is invalid");
        }
        return age; // input okay so return the value & exit
    } catch (InputMismatchException e) {
        scanner.next();
        System.out.println("Input is invalid.\n" + "Please enter digits only");
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
```

### Exception Types

All types of thrown errors are instances of the `Throwable` class or its subclasses. Serious errors are represented by instances of the `Error` class or its subclasses, while exceptional cases that common applications should handle are represented by instances of the `Exception` class or its subclasses.

### Throwable Hierarchy

There are over 60 classes in the `Throwable` hierarchy.

```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int num = scanner.nextInt();

            if (num != 0) {
                throw new Exception("Not zero");
            }

            System.out.println("I'm happy with the input.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid Entry");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

#### Output Analysis:

- For input -1: "Error: Not zero" (due to the exception thrown for `num != 0`)
- For input 0: "I'm happy with the input."
- For input "12XY": "Invalid Entry" (due to `InputMismatchException`)

### Multiple Catch Blocks

- Only one catch block is executed at a time.
- Must be ordered from most specific to most general.

```java
try {
    // ...
} catch (Exception e) {
    // ...
} catch (InputMismatchException e) {
    // ...
}
```

### Importance of Order

If catch blocks are reversed, the second catch block will never be executed because any exception object that is an instance of `Exception` or its subclasses will match the first catch block.

## The Finally Block

### Purpose

In situations where certain actions must be taken regardless of whether an exception is thrown or not, use the `finally` block.

### Example

```java
try {
    // ...
} catch (InputMismatchException e) {
    // ...
} catch (Exception e) {
    // ...
} finally {
    System.out.println("DONE");
}
```

## Throwing Exceptions

### `throw` and `throws` Clause

- `throw`: Create a new instance of an exception or its subclasses.
- `throws`: Explicitly specify the exceptions that a method might throw.

```java
public class ExceptionThrowingExample {
    public static void main(String[] args) {
        try {
            doWork(5);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void doWork(int num) throws Exception {
        if (num != 5)
            throw new Exception("Invalid value");
        else
            System.out.println("Work done successfully!");
    }
}
```

## Exception Types and Hierarchy

### Throwable Class Hierarchy

- Over 60 classes in the hierarchy.
- All types of thrown errors are instances of `Throwable` or its subclasses.

### List of Checked and Unchecked Exceptions

| Checked Exceptions               | Unchecked Exceptions                 |
| ---------------------------------| -------------------------------------|
| IOException                      | ArithmeticException                  |
| SQLException                      | NullPointerException               |
| ClassNotFoundException            | ArrayIndexOutOfBoundsException     |
| IllegalAccessException            | IllegalArgumentException            |
| ... (and more)                    | ... (and more)                       |

## Handling Exceptions - Best Practices

- Use try-catch blocks for checked exceptions.
- Propagate exceptions if not handled locally.
- Handle runtime exceptions selectively.

## Programmer-Defined Exceptions

### Example 1

```java
class MyException extends Exception {
    private int ex;

    MyException(int a) {
        ex = a;
    }

    public String toString() {
        return "MyException[" + ex + "] is less than zero";
    }
}

class Test {
    static void sum(int a, int b) throws MyException {
        if (a < 0)
            throw new MyException(a);
        else
            System.out.println(a + b);
    }

    public static void main(String[] args) {
        try {
            sum(-10, 10);
        } catch (MyException me) {
            System.out.println(me);
        }
    }
}

/* Output:
MyException[-10] is less than zero
*/
```

## Assertions

### Sample Use #1

```java
public double deposit(double amount) {
    double oldBalance = balance;
    balance += amount ;
    assert balance > oldBalance;
}

public double withdraw(double amount) {
    double oldBalance = balance;
    balance -= amount;
    assert balance < oldBalance;
}
```

### Sample Use #2

```java
public double deposit(double amount) {
    double oldBalance = balance;
    balance += amount;
    assert balance > oldBalance : "Serious Error – balance did not increase after deposit";
}
```

## Different Uses of Assertions

### Precondition Assertions

```java
public class Try {
    public static void main(String[] args) {
        int gender = 4;
        double parkingFee = 10.00;
        double tuition = 50.00;
        double totalFee;
        double roomAndBoard = 0.0;
        assert (gender == 1 || gender == 2) : "Invalid";
        switch (gender) {
            case 1:
                totalFee = tuition + parkingFee;
                System.out.println(totalFee);
                break;
            case 2:
                totalFee = tuition + roomAndBoard;
                System.out.println(totalFee);
                break;
        }
    }
}
```

## Handling Checked Exceptions

When calling a method that can throw checked exceptions:

- Use the try-catch statement and place the call in the try block (i.e., the calling method is catcher), or
- Modify the method header to include the appropriate throws clause (i.e., the calling method is propagator).

## Handling Runtime Exceptions

When calling a method that can throw runtime exceptions, it is optional to use the try-catch statement or modify the method header to include a throws clause.

## Throwing Exceptions – throw and throws clause

We can write a method that throws an exception directly using the `throw` reserved word to create a new instance of the `Exception` or its subclasses. The method header includes the reserved word `throws` to explicitly specify the exceptions that the method might throw.

```java
public void doWork(int num) throws Exception {
    if (num != val)
        throw new Exception("Invalid val");
}
```

## Running Programs with Assertions

To run the program with assertions enabled, use `java –ea <main class>`. If the `-ea` option is not provided, the program is executed without checking assertions.

### How to Enable Assertions in NetBeans

1. Right-click on your project name and select Properties.
2. Click Run in the left side panel.
3. At VM Options, type `-ea`.

## Assertions (Continued)

### Second Form of Assertions

The assert statement may also take the form:

```java
assert <boolean expression>: <expression>;
```

where `<expression>` represents the value passed as an argument to the constructor of the `AssertionError`. The value serves as the detailed message of a thrown exception (customized error message).

### Sample Use #2

```java
public double deposit(double amount) {
    double oldBalance = balance;
    balance += amount;
    assert balance > oldBalance : "Serious Error – balance did not increase after deposit";
}
```

### Different Uses of Assertions (Control Flow Invariant)

This statement documents the fact that the default case should never be executed when the program is running correctly.

```java
assert false : "This should never happen";
```

## Exception Types

- **Checked Exceptions:** Checked exceptions are checked or detected at compile time. Example: `IOException`, `SQLException`.

- **Unchecked Exceptions (Runtime Exceptions):** These are detected only at runtime and include programming bugs such as logic errors or improper use of an API. Example: `ArithmeticException`, `NullPointerException`.

## Throwable Hierarchy

There are over 60 classes in the `Throwable` hierarchy.

## Programmer-Defined Exceptions

### Example 1

```java
class MyException extends Exception {
    private int ex;

    MyException(int a) {
        ex = a;
    }

    public String toString() {
        return "MyException[" + ex + "] is less than zero";
    }
}

class Test {
    static void sum(int a, int b) throws MyException {
        if (a < 0)
            throw new MyException(a);
        else
            System.out.println(a + b);
    }

    public static void main(String[] args) {
        try {
            sum(-10, 10);
        } catch (MyException me) {
            System.out.println(me);
        }
    }
}

/* Output:
MyException[-10] is less than zero
*/
```

## Assertions

### Sample Use #1

```java
public double deposit(double amount) {
    double oldBalance = balance;
    balance += amount ;
    assert balance > oldBalance;
}

public double withdraw(double amount) {
    double oldBalance = balance;
    balance -= amount;
    assert balance < oldBalance;
}
```

### Sample Use #2

```java
public double deposit(double amount) {
    double oldBalance = balance;
    balance += amount;
    assert balance > oldBalance : "Serious Error – balance did not increase after deposit";
}
```

### Different Uses of Assertions

#### Precondition Assertions

```java
public class Try {
    public static void main(String[] args) {
        int gender = 4;
        double parkingFee = 10.00;
        double tuition = 50.00;
        double totalFee;
        double roomAndBoard = 0.0;
        assert (gender == 1 || gender == 2) : "Invalid";
        switch (gender) {
            case 1:
                totalFee = tuition + parkingFee;
                System.out.println(totalFee);
                break;
            case 2:
                totalFee = tuition + roomAndBoard;
                System.out.println(totalFee);
                break;
        }
    }
}
```

## Handling Checked Exceptions

When calling a method that can throw checked exceptions:

- Use the try-catch statement and place the call in the try block (i.e., the calling method is catcher), or
- Modify the method header to include the appropriate throws clause (i.e., the calling method is propagator).

## Handling Runtime Exceptions

When calling a method that can throw runtime exceptions, it is optional to use the try-catch statement or modify the method header to include a throws clause.

## Throwing Exceptions – throw and throws clause

We can write a method that throws an exception directly using the `throw` reserved word to create a new instance of the `Exception` or its subclasses. The method header includes the reserved word `throws` to explicitly specify the exceptions that the method might throw.

```java
public void doWork(int num) throws Exception {
    if (num != val)
        throw new Exception("Invalid val");
}
```

## Running Programs with Assertions

To run the program with assertions enabled, use `java –ea <main class>`. If the `-ea` option is not provided, the program is executed without checking assertions.

### How to Enable Assertions in NetBeans

1. Right-click on your project name and select Properties.
2. Click Run in the left side panel.
3. At VM Options, type `-ea`.

## Assertions (Continued)

### Second Form of Assertions

The assert statement may also take the form:

```java
assert <boolean expression>: <expression>;
```

where `<expression>` represents the value passed as an argument to the constructor of the `AssertionError`. The value serves as the detailed message of a thrown exception (customized error message).

### Sample Use #2

```java
public double deposit(double amount) {
    double oldBalance = balance;
    balance += amount;
    assert balance > oldBalance : "Serious Error – balance did not increase after deposit";
}
```

### Different Uses of Assertions (Control Flow Invariant)

This statement documents the fact that the default case should never be executed when the program is running correctly.

```java
assert false : "This should never happen";
```

## Exception Types

- **Checked Exceptions:** Checked exceptions are checked or detected at compile time. Example: `IOException`, `SQLException`.

- **Unchecked Exceptions (Runtime Exceptions):** These are detected only at runtime and include programming bugs such as logic errors or improper use of an API. Example: `ArithmeticException`, `NullPointerException`.

## Throwable Hierarchy

There are over 60 classes in the `Throwable` hierarchy.

## Programmer-Defined Exceptions

### Example 1

```java
class MyException extends Exception {
    private int ex;

    MyException(int a) {
        ex = a;
    }

    public String toString() {
        return "MyException[" + ex + "] is less than zero";
    }
}

class Test {
    static void sum(int a, int b) throws MyException {
        if (a < 0)
            throw new MyException(a);
        else
            System.out.println(a + b);
    }

    public static void main(String[] args) {
        try {
            sum(-10, 10);
        } catch (MyException me) {
            System.out.println(me);
        }
    }
}

/* Output:
MyException[-10] is less than zero
*/
```

## Assertions

### Sample Use #1

```java
public double deposit(double amount) {
    double oldBalance = balance;
    balance += amount ;
    assert balance > oldBalance;
}

public double withdraw(double amount) {
    double oldBalance = balance;
    balance -= amount;
    assert balance < oldBalance;
}
```

### Sample Use #2

```java
public double deposit(double amount) {
    double oldBalance = balance;
    balance += amount;
    assert balance > oldBalance : "Serious Error – balance did not increase after deposit";
}
```

### Different Uses of Assertions

#### Precondition Assertions

```java
public class Try {
    public static void main(String[] args) {
        int gender = 4;
        double parkingFee = 10.

00;
        double tuition = 50.00;
        double totalFee;
        double roomAndBoard = 0.0;
        assert (gender == 1 || gender == 2) : "Invalid";
        switch (gender) {
            case 1:
                totalFee = tuition + parkingFee;
                System.out.println(totalFee);
                break;
            case 2:
                totalFee = tuition + roomAndBoard;
                System.out.println(totalFee);
                break;
        }
    }
}
```

## Handling Checked Exceptions

When calling a method that can throw checked exceptions:

- Use the try-catch statement and place the call in the try block (i.e., the calling method is catcher), or
- Modify the method header to include the appropriate throws clause (i.e., the calling method is propagator).

## Handling Runtime Exceptions

When calling a method that can throw runtime exceptions, it is optional to use the try-catch statement or modify the method header to include a throws clause.

## Throwing Exceptions – throw and throws clause

We can write a method that throws an exception directly using the `throw` reserved word to create a new instance of the `Exception` or its subclasses. The method header includes the reserved word `throws` to explicitly specify the exceptions that the method might throw.

```java
public void doWork(int num) throws Exception {
    if (num != val)
        throw new Exception("Invalid val");
}
```

## Running Programs with Assertions

To run the program with assertions enabled, use `java –ea <main class>`. If the `-ea` option is not provided, the program is executed without checking assertions.

### How to Enable Assertions in NetBeans

1. Right-click on your project name and select Properties.
2. Click Run in the left side panel.
3. At VM Options, type `-ea`.