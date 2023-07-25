# Functions in User-defined Header Files

## WORKING WITH FUNCTIONS IN PROGRAMMER-DEFINED HEADER FILES

Writing styles:
- Function prototype -> function call -> function definition
- Function definition -> function call (if a call is not made to the function before its actual definition, declaring the function prototype is not compulsory.)
- Function call in cpp file, function definition in the header file

### Creating a header file

1. Create a folder
2. Create a header file with the extension .h
3. Create a cpp file
4. Include the header file in the cpp file using the `#include "header.h"` directive
5. Write the function definition in the header file
6. Write the function call in the cpp file

# Advanced Function Calls

## References and reference parameters

### Call by value or Pass by value

- method of passing argumants to a function that copies the actual value of an argument into the formal parameter of the function
- changes made to the perameter inside the function have no effect on the argument
- By default, C++ uses call by value to pass arguments. in general, this means that code within a function cannot alter the arguments used to call the function.
```cpp
#include <iostream>
using namespace std;

void swap(int x, int y) {
    int temp;
    temp = x; /* save the value of x */
    x = y;    /* put y into x */
    y = temp; /* put temp into y */

    return;
}

int main () {
    int a = 100;
    int b = 200;

    cout << "Before swap, value of a :" << a << endl;
    cout << "Before swap, value of b :" << b << endl;

    /* calling a function to swap the values */
    swap(a, b);

    cout << "After swap, value of a :" << a << endl;
    cout << "After swap, value of b :" << b << endl;

    return 0;
}
```
- Output:
```bash
Before swap, value of a :100
Before swap, value of b :200
After swap, value of a :100
After swap, value of b :200
```
No change in the values of a and b, but the values of x and y are swapped inside the function scope.

### Call by reference or Pass by reference


- method of passing arguments to a function that copies the reference of an argument into the formal parameter.
- inside the function, the reference is used to access the actual argument used in the call. This means that changes made to the parameter affect the argument.
- to pass the value by reference, argument reference is passed to the functions just like any other value.
- the reference is created using the `&` operator.
```cpp
#include <iostream>
using namespace std;

void swap(int &x, int &y) {
    int temp;
    temp = x; /* save the value at address x */
    x = y;    /* put y into x */
    y = temp; /* put temp into y */

    return;
}

int main () {
    int a = 100;
    int b = 200;

    cout << "Before swap, value of a :" << a << endl;
    cout << "Before swap, value of b :" << b << endl;

    /* calling a function to swap the values using variable reference.*/
    swap(a, b);

    cout << "After swap, value of a :" << a << endl;
    cout << "After swap, value of b :" << b << endl;

    return 0;
}
```
- Output:
```bash
Before swap, value of a :100
Before swap, value of b :200
After swap, value of a :200
After swap, value of b :100
```
The values of a and b are swapped. x and y are aliases of a and b respectively, so INSIDE the function a becomes x and b becomes y.

### Call by address or Pass by pointer

- method of passing arguments to the function that copies the address of an argument into the formal parameter.
- inside the function, the address is used to access the actual argument used in the call. This means that changes made to the parameter affect the argument.
- to pass the value by pointer, argument pointers are passed to the functions just like any other value.
- the pointer is created using the `*` operator.
```cpp
#include <iostream>
using namespace std;

void swap(int *x, int *y) {
    int temp;
    temp = *x; /* save the value at address x */
    *x = *y;    /* put y into x */
    *y = temp; /* put temp into y */

    return;
}

int main () {
    int a = 100;
    int b = 200;

    cout << "Before swap, value of a :" << a << endl;
    cout << "Before swap, value of b :" << b << endl;

    /* calling a function to swap the values using variable reference.*/
    swap(&a, &b);

    cout << "After swap, value of a :" << a << endl;
    cout << "After swap, value of b :" << b << endl;

    return 0;
}
```
- Output:
```bash
Before swap, value of a :100
Before swap, value of b :200
After swap, value of a :200
After swap, value of b :100
```
Pointers store the address of normal variables. in this case, *x stores the address of a and *y stores the address of b.


### Default arguments and empty perameter lists

If a function with default arguments is called without passing arguments, then the default parameters are used.
```cpp
#include <iostream>
using namespace std;

int sum(int a = 20, int b = 30) {
    int result;
    result = a + b;

    return result;
}

int main () {
    // local variable declaration:
    int a = 100;
    int b = 200;
    int result;

    // calling a function to add the values.
    result = sum(a, b);
    cout << "Total value is :" << result << endl;

    // calling a function again as follows.
    result = sum(a);
    cout << "Total value is :" << result << endl;

    // calling a function again as follows.
    result = sum();
    cout << "Total value is :" << result << endl;

    return 0;
}
```
- Output:
```bash
Total value is :300
Total value is :130
Total value is :50
```

Another way, with prototype:

```cpp
#include <iostream>
using namespace std;

void display(char = '*', int = 3);

int main () {
    int count = 5;

    cout << "no arguments passed:" << endl;
    // * , 3 will be used as default arguments
    display();

    cout << "one argument passed:" << endl;
    // # , 3 will be used
    display('#');

    cout << "two arguments passed:" << endl;
    // # , 5 will be used
    display('#', count);

    return 0;
}

void display(char c, int count) {
    for (int i = 0; i < count; i++) {
        cout << c;
    }
    cout << endl;
}
```

Things to remember:

- Once we provide a default value for a parameter, all subsequent parameters must also have default values. Example:
```cpp
void func(int a = 10, int b); // error "missing default argument on parameter b"
```

- If we are defining the default arguments in the function definition, then the function must be defined before the function call.

# Advanced Function Capabilities

## Inline Functions

Normal function | Inline function
--- | ---
When a function is called, control is transferred to the called function. causes an additional overheadleading to inefficiency | When a function is called, the code of the function is copied at the point of call. so there is no control transfer.
The function call is a normal function call. | The function call uses the keyword `inline` to make the function inline.

- inlining is only a request to the compiler, not a command. Compiler can ignore the request for inlining.
- Compiler may not perform inliningin below scenarios:
1. Function contains a LOOP. (for, while, do-while)
2. Function contains STATIC variables.
3. Function is RECURSIVE. (function calls itself inside the function body)
4. Function return type is other than void, and the return statement doesn’t exist in function body.
5. Function contains switchor goto statement.

### Pros and cons of inlining

Pros | Cons
--- | ---
No function call overhead – obtain enhanced program SPEED. | Consumes additional registers.
Save overheadof return call from a function. | If used too many -the size of the binary executable file will be large.
Save overheadof variables push/pop on the stack. | If used too many -reduce your instruction cache hit rate.
Increases the locality of reference - utilisation of the instruction cache. | Might cause thrashing – decrease computer performance.
Less code -useful for the small embedded systems. | Increase compile time overheadif someone changes the code.

```cpp
#include <iostream>
using namespace std;

inline int Max(int x, int y) {
    return (x > y) ? x : y;
}

int main () {
    cout << "Max (20,10): " << Max(20,10) << endl;
    cout << "Max (0,200): " << Max(0,200) << endl;
    cout << "Max (100,1010): " << Max(100,1010) << endl;

    return 0;
}
```
- Output:
```bash
Max (20,10): 20
Max (0,200): 200
Max (100,1010): 1010
```

## Function Overloading

- is a feature in c++ where two or more functions can have the same name but different parameters.
- can be considered as an example of polymorphism feature in c++.

An overloaded function must have:
- different type of parameters.
- different number of parameters.
- different sequence of parameters.
```cpp
#include <iostream>
using namespace std;

// function declaration
int func(int);
double func(double);

int main () {
    int i = 5;
    double d = 11.7;

    cout << func(i) << endl; // calls int version
    cout << func(d) << endl; // calls double version

    return 0;
}

// function definition
int func(int x) {
    return (x * 2);
}

double func(double x) {
    return (x * 3);
}
```
- Output:
```bash
10
35.1
```

Overloading is called FUNCTION POLYMORPHISM in OOP
- Allows programmer to write functions to do conceptually the same thing on different types of data without changing the name.
- Allows consistency in notation -good both for reading and for writing code. 

Things to remember:
- YES - Overloaded functions may or may not have different return type.
- NO - Overloaded functions have same argument(s).

Caution:
1) Do not overload unrelated tasks.
2) Sometime default arguments maybe used instead of overloading -reduce function definitions.
3) Overloading are extensively used for handling class OBJECTS.
4) Overloading AMBIGUITY-if the compiler can not choose a function amongst two or more overloaded functions.

## Function Templates

- A template is a blueprint or formula for creating a generic class or function.
- template are foundation for generic programming, which means writing code in a way that is independent of any particular type.
- this allows us to create a function tempalte whose functionality can be adapted to more than one type or class without repeating the entire code for each type.
- by passing data type as a parameter.
- function overloading for program with identical logic and operations.

Example, with one data type:
```cpp
#include <iostream>
using namespace std;

// function template
template <typename T>
T add(T num1, T num2) {
    return num1 + num2;
}

int main () {
    cout << add<int>(10, 20) << endl;
    cout << add<double>(10.5, 20.5) << endl;

    return 0;
}
```
- Output:
```bash
30
31
```
Based on the arguments type in calls to function, C++ generates FUNCTION TEMPLATE SPECIALIZATION to handle each call.

Example, with two data types:
```cpp
#include <iostream>
using namespace std;

// function template
template <typename T, typename U>
U add(T num1, U num2) {
    return num1 + num2;
}

int main () {
    cout << add<int, int>(10, 20) << endl;
    cout << add<int, double>(10, 20.5) << endl;
    cout << add<double, double>(10.5, 20.5) << endl;

    return 0;
}
```
- Output:
```bash
30
31
30.5
```