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

## Radix Sort
Radix sort is a non-comparative sorting algorithm that sorts data with strings of characters and specially formatted floating-point numbers. It dates back as far as 1887 to the work of Herman Hollerith. Radix sort is not limited to integers; it is often used in everyday applications. For example, to sort library cards by author, you can create separate piles for each card based on the first letter of the name, and then further sort them based on subsequent letters.

### Example using Radix Sort
1. Provide 10 buckets, labeled from 0 to 9.
2. Find the largest value and pad all numbers with leading zeros. For example, if the largest value is three digits, pad all numbers with leading zeros.
3. Since all numbers have three digits, the sorting algorithm will require three passes.

### Example Steps
1. **Pass 1:** Sort the numbers using the rightmost digit.
   - Data: ^010060100025050
2. **Pass 2:** Sort the numbers using the second rightmost digit.
   - Data: ^(001015005025)^(010060100)
3. **Pass 3:** Sort the numbers using the leftmost digit.
   - Data: ^(0001005010050015060025050060)
4. Remove the leading zeros.
   - Data: ^(001100550101001515025250505006060100100)
5. All numbers are now sorted in ascending order.

## Counting Sort
Counting sort is an algorithm for sorting a collection of objects according to keys that are small integers. It operates by counting the number of objects that have distinct key values and then uses arithmetic on those counts to determine the positions of each key value in the output sequence. Counting sort has a linear running time, making it suitable for situations where the maximum key value is significantly larger than the number of items. It is often used as a subroutine in another sorting algorithm, such as radix sort.

### Example Steps
1. **Step 1:** Create a count array to store the total count of each number.
2. **Step 2:** Modify the count array by adding the previous counts.
3. **Step 3:** Create another array with the same number of elements as the input array.
4. **Step 4:** Decrease each count by one to get the final sorted array.

### Example using Counting Sort
Data: ^223650869
1. **Step 1:** Create a count array.
   - Count: ^(00110101011)
2. **Step 2:** Modify the count array.
   - Modified Count: ^(00111312234)
3. **Step 3:** Create another array.
   - Modified Count: ^(00111312234)
   - New Array: ^(2233405064708697)
4. **Step 4:** Decrease each count by one.
   - Data: ^(2233405064708697)

## Quicksort

Quicksort is a Divide and Conquer algorithm that efficiently sorts an array by choosing a pivot element and partitioning the other elements into two subarrays. The process is repeated recursively on the subarrays until the entire array is sorted.

### Quicksort Overview
- Initially, the array is divided into two subarrays based on a chosen pivot element.
- The partitioning process separates elements smaller and larger than the pivot.
- This process continues recursively until one-element subarrays are obtained, which are already sorted.
- Quicksort is inherently recursive.

### Quicksort Pseudocode
```plaintext
quicksort(array[])
if length(array) > 1
    choose pivot; // partition array into subarray1 and subarray2
    while elements left in array
        include element either in subarray1 = {el: el ≤ pivot} or in subarray2 = {el: el ≥ pivot};
    quicksort(subarray1);
    quicksort(subarray2);
```

## Quick Sort Procedure
1. If the list has 0 or 1 element, return.
2. Pick an element in the list to use as a pivot.
3. Split the remaining elements into two sublists:
   - Sublist1 = elements < pivot
   - Sublist2 = elements > pivot
4. Return the list rearranged as `Quicksort(Sublist1), pivot, Quicksort(Sublist2)`.

- Once a pivot value is selected, the algorithm exchanges other values until sublist1 has elements less than the pivot, and sublist2 has elements greater than the pivot.
- The algorithm repeats this process on sublist1 and sublist2 recursively until there's only one element in a sublist, at which point the original list is sorted.

### Example

Source: Previous Test 2 Exam Question

Using quick sort technique, sort the following array of integers into ascending order:

```
Index 0 1 2 3 4 5 6 7
Data 15 12 13 11 20 18 22 14
```

# Exercises

## Exercise 1

Source: Previous Final Exam Question

Using quick sort technique, sort the following array of integers into ascending order:

```
Index 0 1 2 3 4 5 6 7 8
Data 10 5 8 9 3 6 15 12 16
```

## Exercise 2

Trace the quick sort as it sorts the following array of integers into ascending order:

```
Index 0 1 2 3 4 5 6 7
Data 8 15 4 7 6 10 3 12
```

## Exercise 3

Using quick sort, state the value(s) for P1 to P3 and A to F.

```
J E H I C F O L P
```

### Exercise 3 (Solution)

```
J E H I C F O L P
J
F E H I C O L P
F
C E I H
O
L P
```
