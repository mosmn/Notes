# Introduction to Pointers

## What are Pointers?

### BASIC CONCEPTS

- We can get the memory address of a variable by using the & operator
- Example:
```C++
string food = "Pizza"; // A food variable of type string
cout << food; // Outputs the value of food (Pizza)
cout << &food; // Outputs the memory address of food (0x7ff7bfeff2d0)
```

- A pointer is a variable that stores the memory addressas its value is created
with the * operator.

- Example:
```C++
string food = "Pizza"; // A food variable of type string
string* foodPtr;
foodPtr = &food; // A pointer variable foodPtr that stores the address of variable food

// Output the memory address of food with the pointer (0x7ff7bfeff2d0)
cout << foodPtr << "\n";

// Output the value of food with the pointer (Pizza)
cout << *foodPtr << "\n"; // Outputs the value of food (Pizza)
```

### DECLARING POINTERS

- Method 1:
```C++
int* pointPtr; //preferred syntax
```

- Method 2:
```C++
int *pointPtr; //can be used for multiple pointers declaration
```

- Method 3:
```C++
int * pointPtr;
```

- Declaring pointer and normal variable:
```C++
int* pointPtr, value; //pointPtr pointer, value normal variable
int value2, *pointPtr2;
```

### ADDRESS (&) AND DEREFERENCE (*) OPERATORS

1. `&` : address or reference operator obtain the memory address of its operand.(if used in declaration, it creates an alias)
2. `*`: indirection operator / dereference operator
    - When used in declaration (int* listPtr), it creates a pointer variable.
    - When not used in declaration, it act as a dereference operator.
```C++
string food = "Pizza"; // Variable declaration
string* foodPtr = &food; // Pointer declaration

// Reference: Output the memory address of food with the pointer (0x7ff7bfeff2d0)
cout << foodPtr << "\n";

// Dereference: Output the value of food with the pointer (Pizza)
// *foodPtr is an ALIAS for food variable
cout << *foodPtr << "\n";
```

## WORKING WITH POINTERS

### ASSIGNING ADDRESSES & GETTING VALUES USING POINTERS

```C++
#include <iostream>
using namespace std;
int main(){
    string foodPtr, food = "Pizza";
    // assign address of food to foodPtr pointer
    foodPtr = &food;
    // access address of food stored by foodPtr
    cout<< foodPtr <<'\n';
    // access value pointed by foodPtr
    cout<<< *foodPtr <<'\n';
    return 0;
}
```
foodPtr and *foodPtr are completely different!

### CHANGING VALUE POINTED BY POINTER

```C++
#include <iostream>
using namespace std;
int main(){
    string foodPtr, food = "Pizza";
    // assign address of food to foodPtr pointer
    foodPtr = &food;

    cout<<"Address of food stored by food Ptr: " << foodPtr<< '\n';
    cout<<"Value pointed by foodPtr: " <<*foodPtr << '\n';

    cout<<"\nChanging value of *foodPtr to \"Burger\"\n";
    //changing value of *foodPtr to "Burger"
    *foodPtr = "Burger";

    cout << "New value pointed by *foodPtr" = << *foodPtr << '\n';
    cout << "New value of food " << food << '\n';
    return 0;
}
```

### COMMON MISTAKES

```C++
#include <iostream>
using namespace std;
int main(){
    int val, *valPoint;
    // Wrong!
    // valPoint is an address but val is not
    valPoint = val; // ✪ Incompatible integer to pointer conversion assigning to 'int *' from 'int'; take the address with &

    // Correct!
    // valPoint is an address and so is &val
    valPoint = &val;

    // Wrong!
    // &val is an address
    // *valPoint is the value stored in &val
    *valPoint = &val; // ✪ Incompatible pointer to integer conversion assigning to 'int' from 'int **; remove &

    // Correct!
    // both *valPoint and val are values
    *valPoint = val;
    return 0;
}
```

## POINTER ARITHMETIC

### INCREMENTING A POINTER

- A pointer can be incremented/decremented, using ++, --, + and -, unlike the array name.

```C++
const int MAX = 3;

int main() {
    int var[MAX] = {10, 100, 200};
    int *ptr;

    for (int i = 0; i < MAX; i++) {
        cout << "Address of var[" << i << "] = ";
        cout << ptr << endl;
        cout << "Value of var[" << i << "] = ";
        cout << *ptr << endl;
        // let us have array address in pointer.
        ptr = var;
        // point to the next location
        ptr++;
    }
    return 0;
}
```
output:
```C++
Address of var[0] = 0x7ff7bfeff32c
Value of var[0] = 10
Address of var[1] = 0x7ff7bfeff330
Value of var[1] = 100
Address of var[2] = 0x7ff7bfeff334
Value of var[2] = 200
```

### DECREMENTING A POINTER

```C++
const int MAX = 3;

int main() {
    int var[MAX] = {10, 100, 200};
    int *ptr;

    // let us have address of the last element in pointer.
    ptr = &var[MAX - 1];

    for (int i = MAX; i > 0; i--) {
        cout << "Address of var[" << i << "] = ";
        cout << ptr << endl;
        cout << "Value of var[" << i << "] = ";
        cout << *ptr << endl;
        // point to the previous location
        ptr--;
    }
    return 0;
}
```
output:
```C++
Address of var[3] = 0x7ff7bfeff334
Value of var[3] = 200
Address of var[2] = 0x7ff7bfeff330
Value of var[2] = 100
Address of var[1] = 0x7ff7bfeff32c
Value of var[1] = 10
```

### POINTER COMPARISONS

- Pointers may be compared by using relational operators, such as ==, <, and >.

```C++
const int MAX = 3;

int main() {
    int var[MAX] = {10, 100, 200};
    int *ptr;

    // let us have address of the last element in pointer.
    ptr = var;
    int i = 0;
    while (ptr <= &var[MAX - 1]) {
        cout << "Address of var[" << i << "] = ";
        cout << ptr << endl;
        cout << "Value of var[" << i << "] = ";
        cout << *ptr << endl;
        // point to the previous location
        ptr++;
        i++;
    }
    return 0;
}
```
output:
```C++
Address of var[0] = 0x7ff7bfeff32c
Value of var[0] = 10
Address of var[1] = 0x7ff7bfeff330
Value of var[1] = 100
Address of var[2] = 0x7ff7bfeff334
Value of var[2] = 200
```





