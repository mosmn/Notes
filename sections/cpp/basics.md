# C++ Introduction

## C++ Overview

- a cross platform language that is used to create high-preformance applications
- created by Bjarne Stroustrup as an extension to the C language
-  C++ is designed to be a compiled language, meaning that it is generally translated into machine language that can be understood directly by the system, making the generated program highly efficient.
- gives programmers a high level of control over system resources and memory.
- an object-oriented language which gives a clear structure to programs and allows code to be reused, lowering development costs.
- Close to C, C# and Java. it makes it easy to switch between them.

Features:
- Modular structured-programming, can be divided into small modules(using functions)
- Object-oriented programming
- Memory management
- Mid-level programming
- Rich library

## Phases and Steps in Programming

Software development methodology(SDM):
1. Problem specification, specifying the problem clearly and unambiguously
2. Analysis, consists of IOFC, IO format, and Variables
3. Design, cosists of Algorithm, Flowchart, Pseudocode, and control structures
4. Implementation, consists of coding, IDE
5. Testing, consists of unit testing + debugging + verification, test cases, execution, comparison
6. Documentation, consists of comments and files

# C++ Get Started

## C++ Fundamentals

### Basic elements

- Reserved words:  These are keywords in the C++ language that have special meaning and cannot be used as identifiers. Examples of reserved words include "if", "else", "for", "while", and "class".

- Character: A character is a single letter, digit, or symbol in the C++ language. Characters are enclosed in single quotes (' '), such as 'a', '1', or '#'.

- Identifier: An identifier is a name given to a variable, function, or other program element in C++. Identifiers must start with a letter or underscore character, and can consist of letters, digits, and underscores.

- Variable, constant: A variable is a named memory location that can hold a value. Variables in C++ must be declared with a data type, such as "int" or "double", before they can be used. A constant is a fixed value that cannot be changed during program execution.

- Literals: A literal is a value that is written directly into a program, such as a number or string. Examples of literals in C++ include 5 (an integer literal), 3.14 (a floating-point literal), and "hello" (a string literal).

- Data types: C++ provides a variety of data types, including integers (such as "int" and "long"), floating-point numbers (such as "float" and "double"), characters (such as "char"), and Boolean values (such as "bool"). Data types determine the range of values that can be stored in a variable and the operations that can be performed on those values.

### Data types

![Data types](/imgs/cppdt.png)

### Peogramming operators

ARITHMETIC Expression:
- to preform arithmetic operations on variables, computes a value of type int, float, or double
- Binary operators(operation on 2 operands): +, -, *, /, %
- Unary operators(operation on 1 operand): ++, --, +, -
- Assignment operators: =, +=, -=, *=, /=, %=

RELATIONAL Expression:
- to preform comparison operations on 2 operands, the result is a boolean value(true or false)
- ==, !=, >, <, >=, <=

LOGICAL Expression:
- to preform complex comparison operations, the result is a boolean value(true or false)
- &&, ||, !

CONDITIONAL Expression:
- Works on 3 operands, used instead of if-else statements
- ?:
- `x = (a > b) ? a : b; // if a > b, x = a, else x = b`

### Precedence and associativity rules

Depend on IDE.
![Precedence and associativity rules](//imgs/paa.png)

### Data type casting

- to cast one data type to another
- to ensure that you do not lose any data from arithmetic operations
- synatx: `(type) expression` e.g:
```cpp
int a = 10;
float b = 3.14;
float c = (float) a + b; // c = 13.14, if used without casting(float), c = 13
```

- Both endl and \n serve the same purpose in C++ – they insert a new line. However, the key difference between them is that endl causes a flushing of the output buffer every time it is called, whereas `\n` does not.   Flushing of buffers is an Operating System task. Each time the buffer is flushed, a request has to be made to the OS and these requests are comparatively expensive. Furthermore, we don’t really need to flush the buffer every time we write something to the stream, since the buffers get flushed automatically when they get full. In the rare cases we do need to perform flushing, we can explicitly specify the operation using either `cout.flush()` or by inserting `std::flush` into the stream.  Writing `\n` characters directly to the stream is more efficient since it doesn’t force a flush like `std::endl`.

## C++ Flow Control

### Control structures

Flow:
- Sequence
- Selection
- Repetition

### Selection/Conditional flow

Single-Alternative:
```cpp
if (condition) {
    // statements
}
```

Double-Alternative:
```cpp
if (condition) {
    // statements
} else {
    // statements
}
```

Multiple-Alternative:
```cpp
if (condition) {
    // statements
} else if (condition) {
    // statements
} else {
    // statements
}
```

### Repetition/Looping design

Counter controlled loop:
- definite looping
- Execute loop body statements for a, pre-determined number of time.
- Loop depends on arithmetic or conditional expression.

Sentinel controlled loop:
- indefinite looping
- Execute loop body statements until the user tells it to stop or a special condition is met.
- Loop depends on sentinel value.

### Repetition/Looping types

Entry-checking loop:
- Condition is checked before the first iteration of the loop.
- The loop body is executed zero or more times.
- while loop and for loop

Exit-checking loop:
- Condition is checked after the body of the loop has been executed once.
- The loop body is executed one or more times.
- do-while loop


## C++ Functions

## C++ Arrays

## C++ Strings
