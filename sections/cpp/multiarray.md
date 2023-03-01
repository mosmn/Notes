# Overview of Multi-Dimensional Arrays

## What are Multi-Dimensional Arrays?

### MULTI-DIMENSIONAL ARRAYS

- Multi-dimensional array can have 2 dimensions, 3 dimensions, etc.
- You can think, a multi-dimensional array is an array of arrays.
- We can create up to 12-dimensional arrays but arrays above 2D are rarely used.

A two-dimensional array is also known as MATRIX. A matrix can be represented as a table of rows andcolumns

### CONCEPTUAL VIEW OF MULTI-DIMENSIONAL ARRAYS

![w](/imgs/d2d3.png)

## DECLARING MULTI-DIMENSIONAL ARRAYS

### GENERAL FORM OF DECLARATION

`dataType arrayName [size1][size2]...[sizeN];`, this is declaring N-dimensional array. Where N is the number of dimensions, dataType is the data type of the array elements.

### SIZE OF MULTI-DIMENSIONAL ARRAYS

- Total number of elements in a multidimensional array = multiply size of all the dimensions.

- Example:
1. 2D: `int myArray1[10][20]` = 200 elements
2. 3D: `int myArray1[10][20][30]` = 6,000 elements

### DECLARING 2D ARRAY

- The total number of elements in a 2-D array is ROW*COLUMN

![w](/imgs/d2a.png)

### DECLARING AND INITIALIZING 2D ARRAY

Method 1:
`int A[3][2] = {1, 2, 3, 4, 5, 6};` its gona look like this:
```
1 | 2
3 | 4
5 | 6
```


Method 2:
`int B[2][4] = {{1, 2, 3, 4},{5, 6, 7, 8}}; //less confusing` its gona look like this:
```
1 | 2 | 3 | 4
5 | 6 | 7 | 8
```

Method 3:
```C++
int C[3][4];
// Use nested FOR loop to input value
// from user input
for(int i = 0; i < 3; i++){
    for(int j = 0; j < 4; j++){
        cin >> C[i][j];
    }
} // will create a 3 row 4 column matrix
```

### SAMPLE DECLARING AND INITIALIZING 2D ARRAY

```C++
#include <iostream>
#define ROW 4
#define COL 2
using namespace std;
int main(){
    // use constant for row and column sizes
    int myArray[ROW][COL] ={
        {9,8},
        {7,6},
        {2,3},
        {4,5}};
    // use nested FOR loop for initializing
    // same value for all elements
    // example assign value 5 to all elements
    int row, col;
    for (row=0; row <ROW; row++)
        for (col=0; col<COL; col++) myArray[row][col]=5;
    return 0;
}
```

### PRACTISE

1. Determine sizes of below arrays:
a) int tool[5][40]
```C++
int tool[5][40];
// 5 rows, 40 columns
// 5 * 40 = 200 elements
```

b) float students[3][4][7]
```C++
float students[3][4][7];
// 3 rows, 4 columns, 7 elements
// 3 * 4 * 7 = 84 elements
```

2. Is there error in below array declarations?

a) int Quiz1[3][4] = {{1,2,3,4},{5,6,7,8},{9,10,11}};, // missing a element since 3rd row has 3 elements only

b) int Quiz2[4][2]={1,2,3,4}; // missing 2 elements

# Two-Dimensional (2D) Arrays

## ASSESSING 2D ARRAY ELEMENTS

- To access elements, use the row indexes and column indexes.

- Generally, require two FOR loops.
1. One to traverse the rows
2. Another to traverse columns

Example:
```C++
int row, col;
for (row=0; row < 3; row++) {
    for (col=0; col < 4; col++) {
        cout << myArray[row][col] << " ";
    }
    cout << endl;
}
```

### TRAVERSAL OF MATRIX (2D ARRAYS)

![w](/imgs/tom2d.png)

Row wise traversal:

```C++
for (row=0; row < 3; row++) {
    for (col=0; col < 2; col++) {
        cout << myArray[row][col] << " ";
    }
    cout << endl;
}
```

Column wise traversal:

```C++
for (col=0; col < 2; col++) {
    for (row=0; row < 3; row++) {
        cout << myArray[row][col] << " ";
    }
    cout << endl;
}
```

### MANIPULATING ALL ELEMENTS

Row wise traversal:

```C++
for (row=0; row<3; row++) {
    for (col=0; col<2; col++) {
        cout<<myArray[row][col] << " ";
        total += myArray[row][col];
    }
    cout << '\n';
}

cout<<< "Total values= " << total <<<< '\n'; // 21
```

Column wise traversal:

```C++
for (col=0; col<2; col++) {
    for (row=0; row<3; row++) {
        cout<<myArray[row][col] << " ";
        total += myArray[row][col];
    }
    cout << '\n';
}

cout<<< "Total values= " << total <<<< '\n'; // 21
```

### MANIPULATING ROW-BASED ELEMENTS

```C++
#include <iostream>
#define TEAM 4
#define GAME 2
using namespace std;

int main(){
    int myTeam[TEAM] [GAME]={
        {1,2},
        {3,4},
        {5,6},
        {7,8}};

    int row, col, totalTeam [TEAM]={0};
    for (row=0; row <TEAM; row++){
        for (col=0; col<GAME; col++){
            cout<<<myTeam [row][col] <<< " ";
            totalTeam[row] += myTeam [row][col];
        }
        cout << '\n';
        cout << "Total team "<< row+1 <<  " = " <<totalTeam[row]<<< '\n';
    }
    return 0;
}
```
output:
```
1 2
Total team 1 = 3
3 4
Total team 2 = 7
5 6
Total team 3 = 11
7 8
Total team 4 = 15
```

### MANIPULATING COLUMN-BASED ELEMENTS

```C++
#include <iostream>
#define TEAM 4
#define GAME 2
using namespace std;

int main(){
    int myTeam[TEAM] [GAME]={
        {1,2},
        {3,4},
        {5,6},
        {7,8}};

    int row, col, totalGame [GAME]={0};
    for (col=0; col < 2; col++){
        for (row=0; row < 3; row++){
            cout<<<myTeam [row][col] <<< " ";
            totalGame[col] += myTeam [row][col];
        }
        cout << '\n';
        cout << "Total game "<< col+1 <<  " = " <<totalGame[col]<<< '\n';
    }
    return 0;
}
```
output:
```
1 3 5 
Total game 1 = 9
2 4 6
Total game 2 = 12
```

# PASSING 2D ARRAY TO FUNCTIONS

1. Passing Copy of Array

```C++
#include <iostream>
#define TEAM 4
#define GAME 2
using namespace std;

int totalMarks (int myTeam[][GAME]) { //leave the row -size empty
    int row=0, col=0, total=0;
    for (row=0; row<TEAM; row++) {
        for (col=0; col<GAME; col++){
            cout<<< myTeam[row][col] << " ";
            total myTeam[row][col];
        }
        cout << '\n';
    }
    return total;
}

int main(){
    int theTeam[TEAM] [GAME]={
        {1,2},
        {3,4},
        {5,6},
        {7,8}};

    cout << "Total marks" << totalMarks(theTeam) << '\n';

    return 0;
}
```

2. Passing its Reference

```C++
#include <iostream>
#define TEAM 4
#define GAME 2
using namespace std;

int totalMarks (int (&myTeam)[TEAM][GAME]) {
    int row=0, col=0, total=0;
    for (row=0; row<TEAM; row++) {
        for (col=0; col<GAME; col++){
            cout<<< myTeam[row][col] << " ";
            total += myTeam[row][col];
        }
        cout << '\n';
    }
    //change the value of myTeam array
    myTeam[2][1] = 100;
    return total;
}

int main(){
    int theTeam[TEAM] [GAME]={
        {1,2},
        {3,4},
        {5,6},
        {7,8}};

    cout << "Total marks" << totalMarks(theTeam) << '\n';
    cout << "New value of myTeam[2][1] = " << theTeam[2][1] << '\n';

    return 0;
}
```

3. Passing by Pointers*

4. Decaying the Pointer to the Array*
