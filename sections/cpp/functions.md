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

