# The if Statement

The `if` statement in Java is used for conditional execution of code based on a boolean expression. It allows you to perform different actions depending on whether the condition is true or false.

## Syntax for the `if` Statement

```java
if (<boolean expression>) {
    // then block
} else {
    // else block
}
```

- `<boolean expression>` is the condition that is evaluated to `true` or `false`.
- The code in the `then block` is executed if the condition is `true`.
- The code in the `else block` is executed if the condition is `false`.

## Sample Program

```java
int testScore;

// Get test score input

if (testScore < 70) {
    System.out.println("You did not pass");
} else {
    System.out.println("You did pass");
}
```

This program checks whether the `testScore` is less than 70 and prints a message accordingly.

## Control Flow

The `if` statement controls the flow of your program by executing different code based on whether the condition is true or false.

- If the condition is `true`, the code in the `then block` is executed.
- If the condition is `false`, the code in the `else block` is executed.

## Relational Operators

In Java, you can use various relational operators to form boolean expressions. Some common operators include:

- `<` (less than)
- `<=` (less than or equal to)
- `==` (equal to)
- `!=` (not equal to)
- `>` (greater than)
- `>=` (greater than or equal to)

## Compound Statements

When the `then block` or `else block` contains multiple statements, it's recommended to use braces to create a compound statement. This ensures that all the enclosed statements are part of the block.

```java
if (<boolean expression>) {
    // Multiple statements in the then block
} else {
    // Multiple statements in the else block
}
```

## Style Guide

There are two common styles for formatting `if` statements in Java. Both styles are acceptable, but it's essential to be consistent within your codebase.

Style 1:
```java
if (<boolean expression>) {
    // ...
} else {
    // ...
}
```

Style 2:
```java
if (<boolean expression>)
{
    // ...
}
else
{
    // ...
}
```

## The if-then Statement

The `if-then` statement is a simplified form of the `if` statement, used when you only want to execute code when the condition is true. It doesn't have an `else` block.

```java
if (<boolean expression>) {
    // then block
}
```

## Control Flow of if-then

The `if-then` statement checks the condition and executes the code in the `then block` if the condition is `true`. If the condition is `false`, no further action is taken.

This information should help you understand and use the `if` statement effectively in Java.

## The Nested-if Statement

In Java, the `if` statement can contain other `if` statements within its then and else blocks, creating a nested-if statement.

### Example of a Nested-if Statement

```java
if (testScore >= 70) {
    if (studentAge < 10) {
        System.out.println("You did a great job");
    } else {
        System.out.println("You did pass"); // test score >= 70 and age >= 10
    }
} else { // test score < 70
    System.out.println("You did not pass");
}
```

In this example, the outer `if` statement checks the `testScore`, and the inner `if` statement checks the `studentAge`.

### Control Flow of Nested-if Statement

The control flow of a nested-if statement depends on the conditions within the inner and outer `if` statements. Here's how it works:

- If the outer `if` condition is false, the program prints "You did not pass."
- If the outer `if` condition is true and the inner `if` condition is true, the program prints "You did a great job."
- If the outer `if` condition is true and the inner `if` condition is false, the program prints "You did pass."

### Writing a Proper `if` Control

In nested-if statements, it's essential to use proper indentation and formatting for readability and to avoid mistakes. Here are two ways to rewrite the code to make it clearer:

#### Style 1: Indentation

```java
if (num1 < 0)
    if (num2 < 0)
        if (num3 < 0)
            negativeCount = 3;
        else
            negativeCount = 2;
    else
        if (num3 < 0)
            negativeCount = 2;
        else
            negativeCount = 1;
else
    if (num2 < 0)
        if (num3 < 0)
            negativeCount = 2;
        else
            negativeCount = 1;
    else
        if (num3 < 0)
            negativeCount = 1;
        else
            negativeCount = 0;
```

#### Style 2: Using Increment

```java
negativeCount = 0;
if (num1 < 0)
    negativeCount++;
if (num2 < 0)
    negativeCount++;
if (num3 < 0)
    negativeCount++;
```

The second style is more straightforward and avoids the confusion of nested `if` statements.

### Matching `else`

When dealing with nested `if` statements, it's important to ensure that `else` statements are matched correctly. The indentation and braces should be used to make the code's intent clear.

```java
if (x < y) {
    if (x < z) {
        System.out.print("Hello");
    } else {
        System.out.print("Good bye");
    }
}
```

This style ensures that `else` belongs to the correct `if`.

### Dangling `else` Problem

The dangling `else` problem can be avoided by using braces and proper indentation. It's recommended to use compound statements in the then and else blocks, especially for nested `if` statements, to ensure the code's clarity and correctness.

# Boolean Operators

Boolean operators are used to manipulate boolean values in Java. There are three main boolean operators:

1. **Logical AND (`&&`):** Returns `true` if both operands are `true`.

2. **Logical OR (`||`):** Returns `true` if at least one operand is `true`.

3. **Logical NOT (`!`):** Returns the opposite of the operand's boolean value.

## Example Using Boolean Operators

```java
if (temperature >= 65 && distanceToDestination < 2) {
    System.out.println("Let's walk");
} else {
    System.println("Let's drive");
}
```

In this example, the code checks if the temperature is greater than or equal to 65 and the distance to the destination is less than 2 to decide whether to walk or drive.

## Semantics of Boolean Operators

The following table shows the semantics of boolean operators:

| P       | Q       | P && Q  | P || Q  | !P    |
| ------- | ------- | ------- | ------- | ----- |
| false   | false   | false   | false   | true  |
| false   | true    | false   | true    | true  |
| true    | false   | false   | true    | false |
| true    | true    | true    | true    | false |

These tables show the results of using `&&`, `||`, and `!` with boolean values.

## Short-Circuit Evaluation

Java uses short-circuit evaluation for boolean operators. This means that, for `&&`, if the left operand is `false`, the right operand is not evaluated because the overall result will be `false`. Similarly, for `||`, if the left operand is `true`, the right operand is not evaluated because the overall result will be `true`.

## Using Boolean Variables

In mathematics, when specifying the range of values for a variable, you often use inequalities to express those bounds. For example, to specify that a variable `x` falls within the range from 80 to 90 (inclusive), you would write it as:

\[80 \leq x \leq 90\]

However, in Java, when you want to test whether the value of a variable `x` is within the specified lower and upper bounds, you need to use the `&&` (logical AND) operator to connect two separate comparisons. So, to check that `x` is within the range from 80 to 90 (inclusive), you express it as two separate conditions:

```java
80 <= x && x < 90
```

In this expression, the first part (`80 <= x`) checks if `x` is greater than or equal to 80, and the second part (`x < 90`) checks if `x` is less than 90. Using the `&&` operator ensures that both conditions must be true for the entire expression to be true.

You cannot specify it as `80 <= x < 90` in Java because it wouldn't have the desired effect. This expression would be interpreted as `(80 <= x) < 90`, which is not what you intend. It would first check if `80` is less than or equal to `x` (resulting in a boolean), and then it would compare that boolean to `90`, which is not a valid operation in Java. Hence, it's essential to use the `&&` operator to combine the two separate conditions properly.

In Java, you can declare boolean variables to store boolean values. For example:

```java
boolean pass, done;
pass = 70 < x;
done = true;
```

You can then use these boolean variables in your code, such as in `if` statements.

## Boolean Methods

You can create methods that return boolean values. For example:

```java
private boolean isValid(int value) {
    if (value < MAX_ALLOWED) {
        return true;
    } else {
        return false;
    }
}
```

You can use this method to check the validity of a value, like this:

```java
if (isValid(30)) {
    // ...
} else {
    // ...
}
```

This allows you to encapsulate and reuse logic that checks certain conditions.

```java
class Ch5AccountVer2 {
    // Data Members
    private String ownerName;
    private double balance;
    private boolean active;

    // Constructor
    public Ch5AccountVer2(String name, double startingBalance) {
        ownerName = name;
        balance = startingBalance;
        setActive(true);
    }

    // Adds the passed amount to the balance
    public void add(double amt) {
        // Add if amt is positive; do nothing otherwise
        if (isActive() && amt > 0) {
            balance = balance + amt;
        }
    }

    // Closes the account; sets 'active' to false
    public void close() {
        setActive(false);
    }

    // Deducts the passed amount from the balance
    public void deduct(double amt) {
        // Deduct if amt is positive; do nothing otherwise
        if (isActive() && amt > 0) {
            double newbalance = balance - amt;
            if (newbalance >= 0) {
                // Don't let the balance become negative
                balance = newbalance;
            }
        }
    }

    // Returns the current balance of this account
    public double getCurrentBalance() {
        return balance;
    }

    // Returns the name of this account's owner
    public String getOwnerName() {
        return ownerName;
    }

    // Checks if the account is active
    public boolean isActive() {
        return active;
    }

    // Assigns the name of this account's owner
    public void setOwnerName(String name) {
        ownerName = name;
    }

    // Sets the 'active' status to true or false
    private void setActive(boolean state) {
        active = state;
    }
}
```

- It maintains an owner's name, current balance, and an 'active' status.
- The constructor initializes the account with an owner's name and a starting balance, setting 'active' to true by default.
- Methods like `add` and `deduct` allow deposits and withdrawals from the account, but they only operate if the account is active and the amount is positive.
- The `close` method sets the account to inactive.
- Getter methods like `getCurrentBalance` and `getOwnerName` provide access to the account's information.
- The `isActive` method checks if the account is currently active.
- The `setOwnerName` method allows you to change the owner's name.
- The `setActive` method is private and used internally to set the 'active' status.

## Accessing a Class in a Different Package

In Java, you can access a class in a different package by using the `import` statement. For example:

```java
package myworks;

import lab.pkg2.chap5.*;

class TestAccount {
    public static void main(String[] args) {
        Ch5AccountVer2 acct;
        acct = new Ch5AccountVer2("John Smith", 500.00);
        // acct.close(); // Uncomment this line to test the isActive() method.
        acct.add(25.00);
        System.out.println("Bal : " + acct.getCurrentBalance());
    }
}
```

```java
package lab.pkg2.chap5;

public class Ch5AccountVer2 {
    // ...
}
```

In this example, the `TestAccount` class is in the `myworks` package, and the `Ch5AccountVer2` class is in the `lab.pkg2.chap5` package. The `import` statement allows the `TestAccount` class to access the `Ch5AccountVer2` class.


Here's an organized version of the information about comparing objects, using `==` with objects, and the semantics of `==`:

## Comparing Objects

When working with objects (reference data types) in Java, there are two primary ways to compare them:

1. You can test whether two variables point to the same object using the `==` operator.
2. You can test whether two distinct objects have the same contents using methods like `equals()` or `equalsIgnoreCase()`.

## Using `==` With Objects

### Sample 1

```java
String str1 = new String("Java");
String str2 = new String("Java");

if (str1 == str2) {
    System.out.println("They are not equal");
} else {
    System.out.println("They are not equal because str1 and str2 point to different String objects.");
}
```

In this example, `str1` and `str2` are different objects, even though their content is the same.

### Sample 2

```java
String str1 = new String("Java");
String str2 = str1;

if (str1 == str2) {
    System.out.println("They are equal");
} else {
    System.out.println("They are equal because str1 and str2 point to the same object.");
}
```

In this example, `str1` and `str2` reference the same object, and they are considered equal when using `==`.

## The Semantics of `==`

- `==` checks whether two variables point to the same object.
- To check whether two distinct objects have the same contents, you should use the `equals()` method or other appropriate comparison methods provided by the classes.

## Using `equals()` with String

```java
String str1 = new String("Java");
String str2 = new String("Java");

if (str1.equals(str2)) {
    System.out.println("They are equal");
} else {
    System.out.println("They are equal because str1 and str2 have the same sequence of characters.");
}
```

In this case, `equals()` is used to compare the content of the two `String` objects.

## Exception to the Rule for Comparing Objects

- When dealing with the `String` class, you do not have to use the `new` operator to create an instance. For example, instead of `String str = new String("Java");`, you can write `String str = "Java";`.

- If the same literal String constants are used in a program, there will be exactly one `String` object, regardless of whether the `new` operator is used or not.

- This means you can use the `==` operator to compare `String` objects when no `new` operators are used. However, it's always safe to use the `equals()` and other comparison methods for consistency and reliability.

## Example

```java
String str1, str2;
str1 = "Hello";
str2 = "Hi";

if (str1 == str2) {
    System.out.println("They are not equal");
} else {
    System.out.println("They are not equal");
}
```

In this example, `str1` and `str2` are not equal, as they are distinct `String` objects.

## The `switch` Statement

In Java, the `switch` statement is used to perform different actions based on the value of an expression. It provides a more structured way to handle multiple cases compared to a series of `if` statements.

## Syntax for the `switch` Statement

```java
switch (expression) {
    case value1:
        // Code to execute if expression matches value1
        break;
    case value2:
        // Code to execute if expression matches value2
        break;
    // More cases...
    default:
        // Code to execute if no cases match the expression
}
```

- `expression` is evaluated, and its value is compared to each `case` label.
- If a match is found, the code associated with that `case` is executed.
- The `break` statement is used to exit the `switch` statement after executing the corresponding code.

## Example of Using `switch`

```java
Scanner scanner = new Scanner(System.in);
System.out.println("Grade (Frosh-1, Soph-2, ...):");
int gradeLevel = scanner.nextInt();

switch (gradeLevel) {
    case 1:
        System.out.print("Go to the Gymnasium");
        break;
    case 2:
        System.out.print("Go to the Science Auditorium");
        break;
    case 3:
        System.out.print("Go to Harris Hall Rm A3");
        break;
    case 4:
        System.out.print("Go to Bolt Hall Rm 101");
        break;
}
```

In this example, the `switch` statement checks the value of `gradeLevel` and executes the appropriate code based on the matching case.

## String with `switch`

You can also use the `switch` statement with `String` values. This allows you to compare strings and perform actions accordingly.

## `switch` Without `break` Statement

The `break` statement is used to exit the `switch` statement once a matching case is found. If a `break` statement is omitted, the code will continue to execute the subsequent cases until a `break` statement is encountered.

## Default Case

You may include a `default` case in the `switch` statement. The `default` case will be executed if no matching `case` is found.

# REPETITION STATEMENTS

Repetition statements control a block of code to be executed for a fixed number of times or until a certain condition is met. There are two types of loops: Count-controlled repetitions and Sentinel-controlled repetitions.

## The `while` Statement

The `while` statement is a control structure in Java that allows you to repeatedly execute a block of code as long as a specified condition is true.

### Syntax of the `while` Statement

```java
while (condition) {
    // Code to execute while the condition is true
}
```

The loop body will continue to execute as long as the `condition` remains true.

## Examples of Using the `while` Statement

1. Keeps adding the numbers 1, 2, 3, ... until the sum becomes larger than 1,000,000.

```java
int sum = 0, number = 1;

while (sum <= 1,000,000) {
    sum = sum + number;
    number = number + 1;
}
```

2. Computes the product of the first 20 odd integers.

```java
int product = 1, number = 1, count = 20, lastNumber;
lastNumber = 2 * count - 1;

while (number <= lastNumber) {
    product = product * number;
    number = number + 2;
}
```

## Count-controlled & Sentinel-controlled Loop

- Count-controlled loop: The loop body is executed for a fixed number of times.
- Sentinel-controlled loop: The loop body is executed repeatedly until a sentinel value is encountered.

## Sentinel Control

Example of a sentinel-controlled loop:

```java
import javax.swing.JOptionPane;

public class WhileLoopSentinel {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter number [-1 to quit]:");
        int num = Integer.parseInt(input);
        int sum = 0;
        
        while (num != -1) {
            sum += num;
            input = JOptionPane.showInputDialog("Enter number [-1 to quit]:");
            num = Integer.parseInt(input);
        }
        
        JOptionPane.showMessageDialog(null, "The sum of the numbers you entered is: " + sum);
    }
}
```

This program allows the user to enter numbers until `-1` is entered, and then it calculates the sum of the entered numbers.

## Loop Pitfalls

1. **Infinite Loop:** Ensure the loop body contains a statement that will eventually cause the loop to terminate.

2. **Overflow Error:** Be cautious of assigning a value larger than the maximum value the variable can hold, which can result in an overflow error.

3. **Imprecise Loop Counter:** Be aware of potential precision issues in loop counters, as computers might not handle decimal values exactly.

4. **Off-by-1 Error:** Pay attention to loop initialization and conditions to ensure the loop repeats the correct number of times.

## The `do-while` Statement

The `do-while` statement is a control structure in Java that allows you to repeatedly execute a block of code, at least once, as long as a specified condition remains true. It is similar to the `while` statement, but it ensures that the code block is executed at least once.

## Syntax of the `do-while` Statement

```java
do {
    // Code to execute at least once
} while (condition);
```

The code block will execute at least once, and then the condition is checked. If the condition is true, the loop continues to execute. If the condition is false, the loop terminates.

## Loop-and-a-Half Control

- Loop-and-a-half repetition control can be used to test a loop's terminating condition in the middle of the loop body.
- Infinite loops can occur unintentionally if you are not careful with the conditions of a while loop.
- In these cases, the infinite loop can cause the program to crash.

## Breaking Out of a Loop

To stop a loop before it reaches its natural termination, you can use the `break` statement. When the loop encounters a `break` statement, it quits running the loop and program flow continues.

## Example: Loop-and-a-Half Control

```java
import java.util.*;

public class LoopAndHalf {
    public static void main(String[] args) {
        int cnt = 0;
        double avg, score, sum = 0.0;
        Scanner scanner = new Scanner(System.in;

        while (true) {
            System.out.println("Enter score:");
            score = scanner.nextDouble();
            if (score < 0) break;
            sum += score;
            cnt++;
        }

        if (cnt > 0) {
            avg = sum / cnt;
            System.out.println(avg);
        } else {
            // error: no input
        }
    }
}
```

This program calculates the average of scores entered by the user, allowing the user to keep entering scores until a negative value is encountered.

## Why Use a Loop-and-a-Half?

The loop-and-a-half structure is efficient and effective, as it avoids repeating code outside and inside the loop. It is often easier to reason through the logic behind a loop-and-a-half, making it a preferred choice for certain scenarios.

## Pitfalls for Loop-and-a-Half Control

- Be cautious of the danger of creating an infinite loop if the boolean expression of the `while` statement is always true.
- Multiple exit points, achieved through the use of `break` statements, can complicate control flow and make code harder to understand. It's a good practice to follow one-entry one-exit control flow.

## The `for` Statement

The `for` statement is a powerful loop control structure in Java. It allows you to define and control a loop in a compact manner, specifying initialization, condition, and iteration in a single line.

## Syntax of the `for` Statement

```java
for (initialization; condition; iteration) {
    // Loop body
}
```

- Initialization: This part is executed once at the beginning of the loop.
- Condition: It is evaluated before each iteration. If the condition is true, the loop continues; otherwise, it terminates.
- Iteration: It is executed after each iteration of the loop body.

## Example of Using the `for` Statement

```java
int sum = 0;
for (int i = 0; i < 20; i++) {
    int number = scanner.nextInt();
    sum += number;
}
```

This loop will execute for 20 times, with `i` starting at 0 and incrementing by 1 in each iteration.

## More `for` Loop Examples

The `for` statement is versatile and can be used in various ways, such as:

1. `for (int i = 0; i < 100; i += 5)` - `i` increases by 5 in each iteration.
2. `for (int j = 2; j < 40; j *= 2)` - `j` doubles in each iteration.
3. `for (int k = 100; k > 0; k--)` - `k` counts down from 100 to 1.

## The Nested `for` Statement

Nesting a `for` statement inside another `for` statement is a common technique in programming. It's useful for generating tables and working with multi-dimensional data.

```java
int price;

for (int width = 11; width <= 20; width++) {
    for (int length = 5; length <= 25; length += 5) {
        price = width * length * 19; // $19 per sq. ft.
        System.out.print(" " + price);
    }
    // Finished one row; move on to the next row
    System.out.println("");
}
```

In this example, two `for` loops are nested to generate a table of prices.

## Formatting Output

The `Formatter` class or the `format` method of `PrintStream` (e.g., `System.out`) can be used to format the output. You can specify field widths, decimal places, and more. For example, `%6d` formats an integer with a field width of 6, `%5.2f` formats a floating-point number with 5 total characters, and 2 decimal places.

```java
int num = 467;
System.out.format("%6d", num);
```

This will output the value with a field width of 6.

For more formatting options and data types, you can consult the Java API for the Formatter class.

## References

- [Java `for` Statement - Oracle Documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
- [Java Formatter Class - Oracle Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html)
- [Java `PrintStream` Class - Oracle Documentation](https://docs.oracle.com/javase/8/docs/api/java/io/PrintStream.html)


