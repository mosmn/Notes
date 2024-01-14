# Manipulating Numbers

In Java, to add two numbers x and y, we write `x + y`. But before the actual addition of the two numbers takes place, we must declare their data type. If x and y are integers, we write:

```java
int x, y;
```
or

```java
int x;
int y;
```

## Variables

- When the declaration is made, memory space is allocated to store the values of x and y.
- x and y are called variables. A variable has three properties:
  - A memory location to store the value,
  - The type of data stored in the memory location, and
  - The name used to refer to the memory location.
- Sample variable declarations:
  ```java
  int x;
  int v, w, y;
  ```

## Numerical Data Types

There are six numerical data types: `byte`, `short`, `int`, `long`, `float`, and `double`.

Sample variable declarations:

```java
int i, j, k;
float numberOne, numberTwo;
long bigInteger;
double bigNumber;
```

At the time a variable is declared, it can also be initialized. For example, we may initialize the integer variables `count` and `height` to 10 and 34 as:

```java
int count = 10, height = 34;
```

## Data Type Precisions

The six data types differ in the precision of values they can store in memory.

### Higher precision

- A data type with a larger range of values is said to have a higher precision.
- For example, the data type `double` has a higher precision than the data type `float`.
- The tradeoff for higher precision is memory space; to store a number with higher precision, you need more space.
- A variable of type `short` requires 2 bytes, and a variable of type `int` requires 4 bytes, for example.
- The difference in memory usage is very small and not a deciding factor in the program design.
- The storage difference becomes significant only when your program uses thousands of integers.
- Therefore, we will almost always use the data type `int` for integers.
- We use `long` when we need to process very large integers that are outside the range of values `int` can represent.
- For real numbers, it is more common to use `double`.
- Although it requires more memory space than `float`, we prefer `double` because of its higher precision in representing real numbers.

## Assignment Statements

- We assign a value to a variable using an assignment statement.
- The syntax is `<variable> = <expression>;`
- Examples:
  - `sum = firstNumber + secondNumber;`
  - `avg = (one + two + three) / 3.0;`
- Be careful not to confuse mathematical equality and assignment. For example, the following are not valid Java code:
  - `4 + 5 = x;`
  - `x + y = y + x;`

## Having Two References to a Single Object

- Variables `clemens` and `twain` are declared.
- `clemens = new Customer();`
- `twain = clemens;`
- This creates two references (`clemens` and `twain`) pointing to the same object.

## Invalid Declarations

- Why are the following declarations all invalid?
  - `int a, b, a;` - The variable `a` is declared twice.
  - `float x, int;` - Reserved word `int` cannot be used as an identifier.
  - `float w, int x;` - Need a semicolon after `w` instead of a comma or remove the reserved word `int`.
  - `bigNumber double;` - The order of data type and identifier is reversed.

## Arithmetic Operators

The following table summarizes the arithmetic operators available in Java:

| Operation    | Operator | Example  | Value (x = 10, y = 7, z = 2.5) |
|--------------|----------|----------|------------------------------|
| Addition     | +        | `x + y`  | 17                           |
| Subtraction  | -        | `x - y`  | 3                            |
| Multiplication | *      | `x * y`  | 70                           |
| Division     | /        | `x / y`  | 1                            |
| Modulus      | %        | `x % y`  | 3                            |

## Arithmetic Expression

- When either or both numbers are float or double, the result is a real number.
- The modulo operator returns the remainder of a division. Although real numbers can be used with the modulo operator, the most common use of the modulo operator involves only integers.
- How does the expression `x + 3 * y` get evaluated? Answer: `x` is added to `3*y`.
- We determine the order of evaluation by following the precedence rules.
- A higher precedence operator is evaluated before the lower one. If two operators are the same precedence, then they are evaluated left to right for most operators.

Here are the remaining notes organized using Markdown:

# Precedence Rules

| Order | Group | Operators | Rule |
|-------|-------|-----------|------|
| 1     | Subexpression | ( ) | Evaluate expressions within parentheses first. |
| 2     | Unary | + - ++ -- ! | Evaluate unary operators next. |
| 3     | Multiplicative | * / % | Evaluate multiplicative operators next. |
| 4     | Additive | + - | Evaluate additive operators next.

## Type Casting

- If `x` is a float and `y` is an int, what will be the data type of the following expression?
  `x * y`
  The answer is float.
- The above expression is called a mixed expression.
- The data types of the operands in mixed expressions are converted based on the promotion rules. The promotion rules ensure that the data type of the expression will be the same as the data type of an operand whose type has the highest precision.

## Explicit Type Casting

- Instead of relying on the promotion rules, we can make an explicit type cast by prefixing the operand with the data type using the following syntax: `( <data type> ) <expression>`
- Example: `(float) x / 3` (Type cast `x` to float and then divide it by 3), `(int) (x / y * 3.0)` (Type cast the result of the expression `x / y * 3.0` to int).

## Implicit Type Casting

- Consider the following expression: `double x = 3 + 5;`
- The result of `3 + 5` is of type int. However, since the variable `x` is double, the value 8 (type int) is promoted to 8.0 (type double) before being assigned to `x`.
- Notice that it is a promotion. Demotion is not allowed. `int x = 3.5;` A higher precision value cannot be assigned to a lower precision variable.

## Constants

- We can change the value of a variable. If we want the value to remain the same, we use a constant.
- Example:
  ```java
  final double PI = 3.14159;
  final int MONTH_IN_YEAR = 12;
  final short FARADAY_CONSTANT = 23060;
  ```
  These are constants, also called named constants.

# Displaying Numerical Values

```java
int num = 15;
System.out.print(num); //print a variable
System.out.print(" "); //print a string
System.out.print(10); //print a constant
```
Output:
```
15 10
```

## Overloaded Operator +

- The plus operator + can mean two different operations, depending on the context.
- `<val1> + <val2>` is an addition if both are numbers. If either one of them is a String, then it is a concatenation.
- Evaluation goes from left to right.
- Examples:
  - `"test" + 1 + 2;`
  - `1 + 2 + "test";`
- Sample:
  ```java
  int x, y;
  x = 1;
  y = 2;
  System.out.println("The output is " + x + y);
  System.out.println("The output is " + (x + y) );
  ```
  Output:
  ```
  The output is 12
  The output is 3
  ```

## The DecimalFormat Class

- Use a DecimalFormat object to format the numerical output.
- Example:
  ```java
  double num = 123.45789345;
  DecimalFormat df = new DecimalFormat("0.000"); // three decimal places
  System.out.print(num);
  System.out.print(df.format(num));
  ```
  Output:
  ```
  123.45789345
  123.458
  ```

## Getting Numerical Input

- We can use the Scanner class to input numerical values.
- Example:
  ```java
  Scanner scanner = new Scanner(System.in);
  int age;
  System.out.print("Enter your age: ");
  age = scanner.nextInt();
  ```

### Methods

| Method | Example |
|--------|---------|
| `nextByte()` | `byte b = scanner.nextByte();` |
| `nextDouble()` | `double d = scanner.nextDouble();` |
| `nextFloat()` | `float f = scanner.nextFloat();` |
| `nextInt()` | `int i = scanner.nextInt();` |
| `nextLong()` | `long l = scanner.nextLong();` |
| `nextShort()` | `short s = scanner.nextShort();` |
| `nextLine()` | `String str = scanner.nextLine();` |

## Sample Program

```java
import java.util.*;
import java.text.*;

class Ch3Circle4 {
  public static void main(String[] args) {
    final double PI = 3.14159;
    final String TAB = "\t";
    final String NEWLINE = "\n";
    double radius, area, circumference;
    Scanner scanner = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.000");
    
    // Get input
    System.out.print("Enter radius: ");
    radius = scanner.nextDouble();
    
    // Compute area and circumference
    area = PI * radius * radius;
    circumference = 2.0 * PI * radius;
    
    // Display the results
    System.out.println(
      "Given Radius: " + TAB + df.format(radius) + NEWLINE +
      "Area: " + TAB + df.format(area) + NEWLINE +
      "Circumference: " + TAB + df.format(circumference)
    );
  }
}
```

Output (when user enters `12` as the radius):
```
Enter radius: 12
Given Radius: 12.000
Area: 452.389
Circumference: 75.398
```
# The Math class

The `Math` class in the `java.lang` package contains class methods for commonly used mathematical functions.

- Example: `(1.0 / 2.0) * Math.sin(x - Math.PI / Math.sqrt(y))`

## Some Math Class Methods

| Method   | Description                        |
|----------|------------------------------------|
| `exp(a)` | Natural number e raised to the power of `a`.  |
| `log(a)` | Natural logarithm (base e) of `a`. |
| `floor(a)` | The largest whole number less than or equal to `a`. |
| `max(a,b)` | The larger of `a` and `b`. |
| `pow(a,b)` | The number `a` raised to the power of `b`. |
| `sqrt(a)` | The square root of `a`. |
| `sin(a)` | The sine of `a`. (Note: all trigonometric functions are computed in radians) |

Table 3.7 on page 113 in the textbook contains a list of class methods defined in the `Math` class.

## Computing the Height of a Pole

```java
alphaRad = Math.toRadians(alpha);
betaRad = Math.toRadians(beta);
height = (distance * Math.sin(alphaRad) * Math.sin(betaRad)) /
         Math.sqrt(Math.sin(alphaRad + betaRad) * Math.sin(alphaRad - betaRad));
```

# Random Number Generation

- In many computer applications, especially in simulation and games, we need to generate random numbers.
- To generate random integers, we use the `nextInt` method of the `Random` class. Here’s an example:

```java
import java.util.*;
...
Random random = new Random( );
int num = random.nextInt( );
```

- The `nextInt` method returns an `int` value, that can be any value between -2147483648 and 2147483647.
- To restrict the range of possible values, we can use the second form of the `nextInt` method, in which we pass an argument that specifies the upper bound of the range.

```java
int num = random.nextInt(11); // Generates a random integer between 0 and 10
```

- To generate a random integer between 1 and 6, you can use:

```java
int num = random.nextInt(6) + 1;
```

- For the general case, to generate a random integer in the range of `[min, max]` where `0 <= min < max`, you can use:

```java
int num = random.nextInt(max - min + 1) + min;
```

# The GregorianCalendar Class

- Use a `GregorianCalendar` object to manipulate calendar information.
- Example:

```java
GregorianCalendar today, independenceDay;
today = new GregorianCalendar();
independenceDay = new GregorianCalendar(1776, 6, 4); // month 6 means July; 0 means January
```

## Retrieving Calendar Information

- Use class constants for retrieving different pieces of calendar information from a `GregorianCalendar` object.

| Constant      | Description                                |
|--------------|--------------------------------------------|
| `YEAR`       | the year portion of the date              |
| `MONTH`      | the month portion of the date             |
| `DATE`       | the day of the month                       |
| `DAY_OF_MONTH` | the day of the month                      |
| `DAY_OF_WEEK` | the day of the week                        |
| `DAY_OF_YEAR` | the day of the year                        |
| `HOUR`       | the hour portion of the time              |
| `MINUTE`     | the minute portion of the time            |
| `SECOND`     | the second portion of the time            |
| `MILLISECOND` | the millisecond portion of the time      |

## Sample Calendar Retrieval

```java
GregorianCalendar cal = new GregorianCalendar();
// Assume today is Dec 18, 2008
System.out.print("Today is " +
  (cal.get(Calendar.MONTH) + 1) + "/" +
  cal.get(Calendar.DATE) + "/" +
  cal.get(Calendar.YEAR));
```

Output:

```
Today is 12/18/2008
```