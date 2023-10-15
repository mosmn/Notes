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