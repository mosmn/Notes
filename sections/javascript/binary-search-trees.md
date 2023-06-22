# Binary search

Binary search works on sorted arrays. Binary search begins by comparing an element in the middle of the array with the target value. If the target value matches the element, its position in the array is returned. If the target value is less than the element, the search continues in the lower half of the array. If the target value is greater than the element, the search continues in the upper half of the array. By doing this, the algorithm eliminates the half in which the target value cannot lie in each iteration.

![gif](/imgs/Binary-search-work.gif)

- Its a divide and conquer algorithm
- It only works on sorted arrays

### Procedure

Lets say we have an array of numbers `[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]` and we want to find the index of the number `8`
- start point: index = [0]
- end point: index = [9]

1. Calculate the middle of the array by adding the start and end point and dividing by 2
    - `middle = (0 + 9) / 2 = 4.5`
    - `middle = [4]` (round down)
2. Check if the middle is the number we are looking for, if target is met stop.
3. Otherwise, if the target is less than the middle, change the end point to be just to the left of the middle(eliminate the right half of the array)
4. Otherwise, if the target is greater than the middle, change the start point to be just to the right of the middle(eliminate the left half of the array)
    - the element at index [4] is 5, 8 is greater than 5 so we eliminate the left half of the array
    - start point: index = [5]
5. Repeat steps 1 - 4 until the target is found or the array is empty


