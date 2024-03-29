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

# MORE ABOUT POINTERS

## POINTER AND ARRAY

### HOW ARRAYS AND POINTERS ARE RELATED?

We know that arrays are stored in contiguous memory locations.

A pointer can also store the address of elements of an array.
```C++
int *listPtr;
int list[3];

// store the address of the first element of list in listPtr
listPtr = list; // equivalent to listPtr = &list[0]
```

### POINTER VS ARRAY IN C++


Array | Pointer
---|---
The array can be initialized at the time of definition. | Pointers cannot be initializedat definition.
An array can decide the number of elements it can store. | The pointer can store the address of only one variable.
Arrays are allocated at compile time. | Pointers are allocated at run-time.
Memory allocation is in sequence. | Memory allocation is random.
Arrays are static in nature i.e. they cannot be resized according to the user requirements. | Pointers are dynamic in nature i.e. memory allocated can be resized later.
An array is a group of elements. | Pointer is not a group of elements.

### ACCESSING ARRAY ELEMENTS USING POINTER

```C++
int *listPtr;
int list [3]={10,20,30};
listPtr = list; // listPtr is pointing to list [0]
```

- Access array element using index number:
```C++
cout<<<listPtr + 2; // points to the third element &list [2]
cout << ": " << listPtr [2] <<< '\n';
```

- Access array element using dereference operator:
```C++
cout<<< (listPtr + 1); // is equivalent to list [1]
cout<<< *(listPtr + 2); // is equivalent to list [2]
```

### SAMPLES

1. 
```C++
float arr[3];

// declare pointer variable
float *ptr;

cout<<"Displaying address using arrays: << endl";

// use for loop to print addresses of all array elements
for (int i = 0; i < 3; ++i) {
    cout<<"&arr[" << i << "] = " << &arr[i] <<< endl;
}

// ptr = &arr[0]
ptr = arr;

cout<<"\nDisplaying address using pointers: "<<<< endl;

// use for loop to print addresses of all array elements
// using pointer notation
for (int i 0; i < 3; ++i) {
    cout<<"ptr + " << i << " = "<< ptr + i << endl;
}
```
output:
```C++
Displaying address using
arrays:
&arr[0] = 0x7ff7bfeff32c
&arr[1] = 0x7ff7bfeff330
&arr[2] = 0x7ff7bfeff334

Displaying address using
pointers:
ptr + 0 = 0x7ff7bfeff32c
ptr + 1 = 0x7ff7bfeff330
ptr + 2 = 0x7ff7bfeff334
```

2. 
```C++
#include <iostream>
using namespace std;

int main() {
    float quiz[5];

    // Insert data using pointer notation
    cout << "Enter 5 numbers: ";
    for (int i = 0; i < 5; ++i) {
        // store input number in arr[i]
        cin >> *(quiz + i);
    }

    // Display data using pointer notation
    cout << "Displaying data: " << endl;
    for (int i = 0; i < 5; ++i) {
        // display value of arr[i]
        cout << *(quiz + i) << endl;
    }

    return 0;
}
```
output:
```C++
Enter 5 numbers: 10 20 30 40 50
Displaying data:
10
20
30
40
50
```

## POINTER AND FUNCTION

### CALL BY REFERENCE VS CALL BY VALUE

- Call by value: `void calculateBalance(int value);`

- Call by reference:
    - Using address/refernce: `void swap(int &n1, int &n2);`
    - Using pointer: `void swap(int *n1, int *n2);`

### FUNCTION RETURNS A POINTER

1. Place * operator on the left side of the function's name.
2. Return the pointer to the return value.
3. When calling the function, if you want to access its value, make sure you include the asterisk on the left side of the name of the function

```C++
double* GetWeeklyHours (void) {
    double h = 46.50;
    double *hours = &h;
    return hours;
}

double* GetSalary(void) {
    double salary = 26.48;
    double *HourlySalary = &salary;
    return HourlySalary;
}

int main(){
    double hours, salary, WeeklySalary;
    hours = *GetWeeklyHours();
    salary = *GetSalary();
    cout << "Weekly Hours: " << hours << '\n';
    cout<<"Hourly Salary: " << salary << '\n';
    WeeklySalary = hours * salary;
    cout << "Weekly Salary: " << WeeklySalary << '\n';
    return 0;
}
```
output:
```C++
Weekly Hours: 46.5
Hourly Salary: 26.48
Weekly Salary: 1229.84
```

## POINTER TO POINTER

- Also known as double pointer or multiple indirection.
- When we define a pointer to a pointer, the first pointer is used to store the address of the variables, and the second pointer stores the address of the first pointer
```C++
int food = "Pizza";
int *ptr = &food;
int **ptr2 = &ptr;
```

Sample:
```C++
#include <iostream>
using namespace std;

int main() {
    string food = "Pizza", *foodPtr1, **foodPtr2;

    // assign address of food to foodPtr pointer
    foodPtr1 = &food;
    foodPtr2 = &foodPtr1;

    cout << "Value of variable food: " << food << '\n';
    cout << "Value using single pointer: " << *foodPtr1 << '\n';
    cout << "Value using double pointer: " << **foodPtr2 << '\n';

    // Changing **foodPtr2 will affect *foodPtr1 and food
    **foodPtr2 = "Burger";
    cout << "New value of food: " << food << '\n';
    cout << "New value using single pointer: " << *foodPtr1 << '\n';

    return 0;
}
```

## POINTER AND DYNAMIC MEMORY ALLOCATION

### C++ MEMORY MANAGEMENT

- C++ allows us to allocate the memory of a variable or an array in run time(meaning when you execute the program). This is known as dynamic memory allocation.
- In other programming languages such as Java and Python, the compiler automatically manages the memories allocated to variables. But this is not the case in C++.
- In C++, we need to deallocate the dynamically allocated memory manually after we have no use for the variable using operators:`new` and `delete`.

### OPERATORS new AND delete

- The new operator can also be used to allocate memory for an array.
- Once we no longer need to use an array that we have declared dynamically, we can deallocate the memory occupied by the array.
- The delete operator returns the memory to the operating system.
- Known as memory deallocation.
```C++
// declare an int pointer
int* pointPtr;

// dynamically allocate memory
// using the new keyword
pointPtr = new int;

// assign value to allocated memory
*pointPtr = 45;

// print the value stored in memory
cout << *pointPtr; // Output: 45

// deallocate the memory
delete pointPtr;
```

#### SAMPLES

Sample 1:
```C++
#include <iostream>
using namespace std;

int main() {
    // declare an int pointer
    int* pointInt;

    // declare a float pointer
    float* pointFloat;

    // dynamically allocate memory
    // using the new keyword
    pointInt = new int;
    pointFloat = new float;

    // assigning value to the memory
    *pointInt = 45;
    *pointFloat = 45.45f;

    cout << *pointInt << endl;
    cout << *pointFloat << endl;

    // deallocate the memory
    delete pointInt;
    delete pointFloat;

    return 0;
}
```
output:
```C++
45
45.45
```

Sample 2:
```C++
// C++ Program to store GPA of n number of students and display it
// where n is the number of students entered by the user
#include <iostream>
using namespace std;

int main () {
    int num;
    cout << "Enter total number of students: ";
    cin >> num;

    float* studentPtr;

    // memory allocation of num number of floats
    studentPtr = new float[num];

    cout << "Enter GPA of students." << endl;
    for (int i = 0; i < num; ++i) {
        cout << "Student" << i + 1 << ": ";
        cin >> *(studentPtr + i);
    }

    cout << "\nDisplaying GPA of students." << endl;
    for (int i = 0; i < num; ++i) {
        cout << "Student" << i + 1 << ": " << *(studentPtr + i) << endl;
    }

    // ptr memory is released
    delete[] studentPtr;

    return 0;
}
```
output:
```C++
Enter total number of students: 3
Enter GPA of students.
Student1: 3.5
Student2: 3.6
Student3: 3.7
```

- Dynamic memory allocation can make memory management more efficient. Especially for arrays, where a lot of the times we don't know the size of the array until the run time.