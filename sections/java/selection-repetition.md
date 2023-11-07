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

©T he McGraw-Hill Companies, Inc. P ermission


## REVISION TOPICS

©T he McGraw-Hill Companies, Inc. P ermission


©T he McGraw-Hill Companies, Inc. P ermission

## Definition

- Repetition statements control a block of code to be

#### executed for a fixed number of times or until a

#### certain condition is met.

- There are two types of loop; Count-controlled

#### repetitions and Sentinel-controlled repetitions


©T he McGraw-Hill Companies, Inc. P ermission

## The while Statement


©T he McGraw-Hill Companies, Inc. P ermission

## More Examples

```
Keeps adding the
numbers 1, 2, 3, ... until
the sum becomes larger
than 1,000,000.
```
```
Computes the product of
the first 20 odd integers.
```
```
int sum = 0, number = 1;
```
```
while ( sum <= 1 000 000 ) {
sum = sum + number;
number = number + 1;
}
```
#### 1

```
int product = 1, number = 1,
count = 20, lastNumber;
```
```
lastNumber = 2 * count - 1;
```
```
while (number <= lastNumber) {
product = product * number;
number = number + 2;
}
```
#### 2


## Count-controlled &

## sentinel-controlled loop

- Count-controlled loop: The loop body is executed

### for a fixed number of times (as if we were counting)

- Sentinel-controlled loop: The loop body is executed

### repeatedly until any one of the designated values,

### called a sentinel, is encountered.

©T he McGraw-Hill Companies, Inc. P ermission

###### int sum = 0, number = 1;

###### while (number <= 100) {

###### sum = sum + number;

###### number = number + 1;

###### }


## Sentinel Control

###### import javax.swing.JOptionPane;

###### public class WhileLoopSentinel {

###### public static void main(String[] args) {

###### String input = JOptionPane.showInputDialog("Enter number [-1 to quit]:");

###### int num = num = Integer.parseInt(input);;

###### int sum = 0;

###### while (num != -1) {

###### sum += num;

###### input = JOptionPane.showInputDialog("Enter number [-1 to quit]:");

###### num = Integer.parseInt(input);

###### }

###### JOptionPane.showMessageDialog(null, "The sum of the numbers you

###### entered is : " + sum);

###### }

###### }

©T he McGraw-Hill Companies, Inc. P ermission

##### WhileLoopSentinel.java


## Improving User Interface with a Loop

- To create a user-friendly program, you can either

### print out an error message or to set a default value

### if the user enters an invalid value.

- Instead of quitting the program after displaying an

### error message or continuing the program with a

### default value, it would be better in general to allow

### the user to reenter the value until the correct value

### is entered.

©T he McGraw-Hill Companies, Inc. P ermission


## Improving User Interface with a Loop

©T he McGraw-Hill Companies, Inc. P ermission

##### Your Age (between 0 and 130): 140

##### An invalid age was entered. Please try again.

##### Your Age (between 0 and 130): - 1

##### An invalid age was entered. Please try again.

##### Your Age (between 0 and 130): 120

#### Sentinel-controlled loop


## DEMO

©T he McGraw-Hill Companies, Inc. P ermission


©T he McGraw-Hill Companies, Inc. P ermission

## Finding GCD

##### Direct Approach More Efficient Approach


## GCD

©T he McGraw-Hill Companies, Inc. P ermission

#### X 4

#### X 4

#### X 5

#### X 5

#### X 1

#### X 1


## Finding GCD

##### public int gcd(int n, int m) {

##### int r = n % m;

##### while (r !=0) {

##### n = m;

##### m = r;

##### r = n % m;

##### }

##### return m;

##### }

©T he McGraw-Hill Companies, Inc. P ermission

#### Ch6GCD.java


©T he McGraw-Hill Companies, Inc. P ermission

## Useful Shorthand Operators

##### sum = sum + number; is equivalent to sum += number;

#### Operator Usage Meaning

#### += a += b; a = a + b;

- = a -= b; a = a – b;

#### *= a *= b; a = a * b;

#### /= a /= b; a = a / b;

#### %= a %= b; a = a % b;


©T he McGraw-Hill Companies, Inc. P ermission

## Watch Out for Pitfalls

#### 1. Make sure the loop body contains a statement that

#### will eventually cause the loop to terminate.

#### 2. Make sure the loop repeats exactly the correct

#### number of times.

#### 3. There are 4 issues with regards to pitfalls in writing

#### repetition statements:

##### 1. Infinite loop

##### 2. Overflow error

##### 3. Imprecise loop counter

##### 4. Off-by-1 error

```
Pitfall means
unsuspected
danger
```

## Loop Pitfall 1: Infinite loop

###### Infinite Loops

```
Both loops will not
terminate because the
boolean expressions will
int count = 1; never become false.
```
```
while ( count != 10 ) {
count = count + 2;
```
}

#### 2

int product = 0;

```
while ( product < 500 000 ) {
product = product * 5;
}
```
(^1) product = 0

#### all the times

#### count =

#### 3,5,7,9,11,13, ....

#### TestLoop.java


©T he McGraw-Hill Companies, Inc. P ermission

### Loop Pitfall 2: Overflow error

- An infinite loop often results in an overflow error.
- An overflow error occurs when you attempt to

### assign a value larger than the maximum value the

### variable can hold.


## Loop Pitfall 3: Imprecise loop counter

- We know in mathematics that
- is equal to 1. However, in a computer, an

### expression such as

- may or may not get evaluated to 1.0, depending

### on how precise the approximation is.

©T he McGraw-Hill Companies, Inc. P ermission


## Loop Pitfall 3: Imprecise loop counter

- Consider the following example:

#### double count = 0.0;

#### while (count != 1.0) {

#### count = count + 0.10;

#### }

- This repetition statement looks simple enough. We initialize

#### count to 0.0 and repeatedly add 0.10 to it, so after 10

#### repetitions, the loop should terminate. Wrong.

- The counter variable count never becomes equal to 1.0. The

### closest it gets is 0.9999999999999999.

©T he McGraw-Hill Companies, Inc. P ermission


## Output

##### 0.1

##### 0.2

##### 0.30000000000000004

##### 0.4

##### 0.5

##### 0.6

##### 0.7

##### 0.7999999999999999

##### 0.8999999999999999

##### 0.9999999999999999

##### 1.0999999999999999

##### 1.2

##### .................................

©T he McGraw-Hill Companies, Inc. P ermission

#### TestLoop.java


```
©T he McGraw-Hill Companies, Inc. P ermission
```
## Loop Pitfall 4: Off-by-1 error

- Goal: Execute the loop body 10 times.

```
count = 1;
while ( count < 10 ){
```
...
count++;
}

#### 1

```
count = 0;
while ( count <= 10 ){
```
...
count++;
}

#### 3

```
count = 1;
while ( count <= 10 ){
```
...
count++;
}

#### 2

```
count = 0;
while ( count < 10 ){
```
...
count++;
}

#### 4

#### 1 and 3 exhibit off-by-one error.

#### 9 times

#### 11 times


## Quick Check (Q & A)

- Write a while statement to add numbers 11

### through 20. Is this a count-controlled or sentinel-

### controlled loop?

- Answer:

##### int sum = 0, i = 11;

##### while ( i <= 20 ) { //this is a

##### sum += i; //count-controlled

##### i++;

##### }

©T he McGraw-Hill Companies, Inc. P ermission


## REVISION TOPICS

©T he McGraw-Hill Companies, Inc. P ermission


©T he McGraw-Hill Companies, Inc. P ermission

## The do-while Statement

##### int sum = 0, number = 1;

##### do {

##### sum += number;

##### number++;

##### } while ( sum <= 1000000 );

```
These statements are
executed as long as sum
is less than or equal to
1,000,000.
```

©T he McGraw-Hill Companies, Inc. P ermission

###### do {

###### sum += number;

###### number++;

###### } while ( sum <= 1000000 );

### Syntax for the do-while Statement

##### do

##### <statement>

##### while ( <boolean expression> ) ;

###### Statement

###### (loop body)

###### Boolean Expression


## DEMO

©T he McGraw-Hill Companies, Inc. P ermission


©T he McGraw-Hill Companies, Inc. P ermission

### Loop-and-a-Half Repetition Control

- Loop-and-a-half repetition control can be used to test a

#### loop’s terminating condition in the middle of the loop body.

- Infinite loops can occur unintentionally if you are not careful

#### with the conditions of a while loop.

- In these cases, the infinite loop can cause the program to

#### crash.

- However, infinite loops can be a very useful tool in

#### programming.

- If your program needs to repeat a block of code an

#### indefinite number of times, an infinite loop may be the

#### correct approach.


©T he McGraw-Hill Companies, Inc. P ermission

### Loop-and-a-Half: Breaking out of a Loop

- Repeating code is nice, but it's just as important to be able

#### to stop the loop so that the rest of the program can

#### continue executing.

- Loops can be stopped using the break statement.
- When the loop encounters a break statement, it quits

#### running the loop and program flow continues.


©T he McGraw-Hill Companies, Inc. P ermission

### Example: Loop-and-a-Half Control

```
package myworks;
import java.util.*;
```
```
public class LoopAndHalf {
public static void main(String[] args) {
```
```
int cnt=0;
double avg, score, sum= 0.0;
Scanner scanner = new Scanner(System.in);
```
```
while(true){
System.out.println ("Enter score:");
score= scanner.nextDouble();
if (score <0) break;
sum +=score;
cnt++;
}
if (cnt >0){
avg= sum/cnt;
System.out.println (avg);
}
else {
// error: no input
}
}
}
```

#### Same as before but with colors

©T he McGraw-Hill Companies, Inc. P ermission

#### Enter score:

- 1

```
Enter score:
2
Enter score:
2
Enter score:
2
Enter score:
2
Enter score:
2
Enter score:
```
- 1
2.0


©T he McGraw-Hill Companies, Inc. P ermission

### Loop-and-a-Half: Stopping with the

### Sentinels

- Notice how in the previous example, the break statement

#### occurs when a certain condition is true.

- Checking for a condition like this is a useful way to have

#### the while loop repeat as many times as needed.

- This is especially true when getting input from the user.
- For example, you may want to print out numbers from the

#### user until the program encounters the value -1.

- Such a program may look like this:


### Loop-and-a-Half: Stopping with the

### Sentinels

©T he McGraw-Hill Companies, Inc. P ermission

```
import java.util.*;
```
```
class StoppingWithSentinels{
public static void main(String[] args) {
```
```
int SENTINEL = -1;
```
```
while(true)
{
```
```
Scanner scanner = new Scanner(System.in);
int num;
```
```
System.out.print("Enter your input(s): ");
num = scanner.nextInt();
```
```
if (num == SENTINEL)
{
break;
}
System.out.println(num);
}
}
}
```

## Loop-and-a-Half: Stopping with the

## Sentinels

©T he McGraw-Hill Companies, Inc. P ermission

#### Enter your input(s): 3

#### 3

#### Enter your input(s): 4

#### 4

#### Enter your input(s): 5

#### 5

#### Enter your input(s): - 1


## Why Use a Loop-and-a-Half?

- It may seem dangerous or time-consuming to use

### an infinite loop, but when used appropriately, the

### loop-and-a-half structure is efficient and effective.

- The loop-and-a-half structure is preferred because

### it avoids repeating code outside and inside the

### loop.

- Furthermore, it is often easier to reason through

### the logic behind a loop-and-a-half.

- For example, with a simple program that prints

### numbers to the screen:

©T he McGraw-Hill Companies, Inc. P ermission


## Why Use a

## Loop-and-

## a-Half?

©T he McGraw-Hill Companies, Inc. P ermission

Refer to StoppingWithSentinels.java


## Why Use a

## Loop-and-

## a-Half?

©T he McGraw-Hill Companies, Inc. P ermission

Refer to StoppingWithSentinels.java


©T he McGraw-Hill Companies, Inc. P ermission

### Pitfalls for Loop-and-a-Half Control

- Be aware of two concerns when using the loop-

### and-a-half control:

- The danger of an infinite loop.The boolean expression of the

##### while statement is true, which will always evaluate to true. If we

##### forget to include an if statement to break out of the loop, it will

##### result in an infinite loop.

- Multiple exit points.It is possible, although complex, to write a

##### correct control loop with multiple exit points (break). It is good

##### practice to enforce the one-entry one-exit controlflow.


©T he McGraw-Hill Companies, Inc. P ermission

### Pitfalls for Loop-and-a-Half Control

- One-entry one-exit control (good approach)

### flow: standard while and do–while with no

### break statements inside the loop

- Multiple exit points (bad approach) as below:


## Multiple exit points

- The main reason multiple exit points are bad is

### that they complicate control flow.

- The more complicated the control flow is, the

### harder the code is to understand.

©T he McGraw-Hill Companies, Inc. P ermission


## REVISION TOPICS

©T he McGraw-Hill Companies, Inc. P ermission


## The for statement

©T he McGraw-Hill Companies, Inc. P ermission

## The for Statement


©T he McGraw-Hill Companies, Inc. P ermission

## The for Statement

##### int i, sum = 0, number;

##### for (i = 0; i < 20; i++) {

##### number = scanner.nextInt( );

##### sum += number;

##### }

```
These statements are
executed for 20 times
( i = 0, 1, 2, ... , 19).
```

©T he McGraw-Hill Companies, Inc. P ermission

## More for Loop Examples

#### 1 for (int i = 0; i < 100; i += 5)

###### i = 0, 5, 10, ... , 95

#### 2 for (int j = 2; j < 40; j *= 2)

###### j = 2, 4, 8,16, 32

#### 3 for (int k = 100; k > 0; k--) )

###### k = 100, 99, 98, 97, ..., 1


©T he McGraw-Hill Companies, Inc. P ermission

## The Nested-for Statement

- Nesting a for statement inside another for

### statement is commonly used technique in

### programming.

- Let’s generate the following table using nested-

### for statement.


©T he McGraw-Hill Companies, Inc. P ermission

## Generating the Table

###### int price;

###### for (int width = 11; width <=20, width++){

###### for (int length = 5, length <=25, length+=5){

###### price = width * length * 19; //$19 per sq. ft.

###### System.out.print (" " + price);

###### }

###### //finished one row; move on to next row

###### System.out.println("");

###### }

```
INNER
OUTER
```

#### The Nested-for Statement: Generating the Table

©T he McGraw-Hill Companies, Inc. P ermission


©T he McGraw-Hill Companies, Inc. P ermission

### Formatting Output

- We call the space occupied by an output value the field.

#### The number of characters allocated to a field is the field

#### width. The diagram shows the field width of 6.

- From Java 5.0, we can use the Formatter class.

#### System.out (PrintStream) also includes the format method.


©T he McGraw-Hill Companies, Inc. P ermission

### The Formatter Class

- We use the Formatter class to format the output.
- First we create an instance of the class

##### Formatter formatter = new Formatter(System.out);

- Then we call its format method

##### int num = 467;

##### formatter.format("%6d", num);

- This will output the value with the field width of 6.


©T he McGraw-Hill Companies, Inc. P ermission

## The format Method of Formatter

- The general syntax is

###### format(<control string>, <expr1>, <expr2>,... )

#### Example:

```
int num1 = 34, num2 = 9;
int num3 = num1 + num2;
formatter.format("%3d + %3d = %5d", num1, num2, num3);
```

©T he McGraw-Hill Companies, Inc. P ermission

## The format Method of PrintStream

- Instead of using the Formatter class directly, we can

#### achieve the same result by using the format method of

#### PrintStream (System.out)

###### Formatter formatter = new Formatter(System.out);

###### formatter.format("%6d", 498);

#### is equivalent to

###### System.out.format("%6d", 498);


©T he McGraw-Hill Companies, Inc. P ermission

## Formatting Output

- Integers

###### % <field width> d

- Real Numbers

###### % <field width>. <decimal places> f

- Strings

###### % s

- For other data types and more formatting options, please

#### consult the Java API for the Formatter class.


©T he McGraw-Hill Companies, Inc. P ermission

## Formatting Output


## More examples on formatting

##### System.out.format("%4d", 234);

##### System.out.format("%5d", 234);

##### System.out.format("%s", "\n");

##### System.out.format("$%6.2f", 23.456);

###### NOTE: Blank space is denoted by an underscore. Underscores are not a part of

###### real output.

##### _234_ _234

##### $_23.46

©T he McGraw-Hill Companies, Inc. P ermission


## References

- https://codehs.gitbooks.io/apjava/content/Basic-

### Java/loop-and-a-half.html

©T he McGraw-Hill Companies, Inc. P ermission


