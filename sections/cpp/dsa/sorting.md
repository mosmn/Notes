# Sorting

### Introduction

Sorting refers to arranging data in a particular format to improve efficiency. The importance of sorting lies in optimizing data searching to a high level if data is stored in a sorted manner. The choice of sorting method depends on the application and user’s needs. Once a criterion is chosen, the next step is determining how to apply it to the data. Common measures include the number of comparisons and the number of data movements.

### Introduction (continued)

Since exact values may be difficult to determine, approximations are often used using big-O notation. Considerations for algorithm behavior include the original state of the data set and practical efficiency in various cases.

### Sorting Algorithms

A Sorting Algorithm rearranges an array or list of elements according to a comparison operator. The choice of algorithm complexity depends on the size of the data set.

### Elementary Sorting Algorithms

#### Insertion Sort

- **_Insertion sort_** builds the final sorted list one item at a time.
- The array is virtually split into a sorted and an unsorted part.
- Values from the unsorted part are picked and placed at the correct position in the sorted part.

##### Example:

```plaintext
Original: 34 8 64 51 32 21
After p = 1
After p = 2
After p = 3
After p = 4
After p = 5
```

### Elementary Sorting Algorithms (continued)

#### Selection Sort

- Selection sort finds the minimum element from the unsorted part and puts it at the beginning.
- It maintains two subarrays: sorted and unsorted.

##### Example:

```plaintext
Original: 15 75 25 30 60 31
After p = 1
After p = 2
After p = 3
After p = 4
After p = 5
```

#### Bubble Sort

- **_Bubble sort_** works by repeatedly stepping through the list and swapping adjacent items if they are in the wrong order.

##### Example:

```plaintext
Algorithm:
pair = n – 1;
do {
  last = 1;
  for (i = 1; i <= pair; i++)
    if (x[i] > x[i + 1]){
      swap x[i] with x[i + 1];
      last = i;
    }
  pair = last - 1;
} while (pair != 0);
```

### Efficient Sorting Algorithms (continued)

#### Heap Sort

- Heap sort is based on the Binary Heap data structure.
- It finds the minimum element and places it at the beginning, repeating the process for the remaining elements.

##### Example:

```plaintext
Original Array: 45 23 78 8 32 56
After heap: 78 32 56 8 23 45
After pass 1 and reheap: ^56324582378
After pass 2 and reheap: ^45322385678
After pass 3 and reheap: ^32823455678
After pass 4 and reheap: ^23832455678
After pass 5 and reheap: ^82332455678
```
