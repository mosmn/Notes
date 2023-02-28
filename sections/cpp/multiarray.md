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

• Method 1:
• int A[3][2] = {1, 2, 3, 4, 5, 6};
A
--
1 | 2
3 | 4
5 | 6

• Method 2:
• int B[2][4] = {{1, 2, 3, 4},{5, 6, 7, 8}}; //less confusing
BS SEPT2021
A
1 2
3 4
5 6
B 1 2 3 4
5 6 7 8