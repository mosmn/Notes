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
    - start point: `index = [5]`
5. Repeat steps 1 - 4 until the target is found or (sub)array is empty

## Binary search tree

Also called an ordered or sorted binary tree, is a rooted binary tree data structure with the key of each internal node being greater than all the keys in the respective node's left subtree and less than the ones in its right subtree.

![img](https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Binary_search_tree.svg/200px-Binary_search_tree.svg.png)

- [How to Construct a Binary Search Tree?](https://www.youtube.com/watch?v=FvdPo8PBQtc)


### Binary tree traversal

The process of visiting each node in the tree exactly once in some order. Based on the order in which the nodes are visited, there are [two types of tree traversal](https://www.youtube.com/watch?v=9RHO6jU--GU):
- Breadth-first traversal
- Depth-first traversal

1. Breadth-first traversal(level order traversal)
    - Visit all the nodes at the same level(left to right) before going to the next level
    - [Breadth-first traversal](https://www.youtube.com/watch?v=86g8jAQug04) 
![img](https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Breadth-first-tree.svg/200px-Breadth-first-tree.svg.png)

2. Depth-first traversal
    - If we visit a child we must visit all of its descendants before going to the next sibling
    - There are three types of depth-first traversal:
        - Pre-order traversal: `root -> left -> right`
        - In-order traversal: `left -> root -> right`
        - Post-order traversal: `left -> right -> root`
    - [Depth-first traversal](https://www.youtube.com/watch?v=9RHO6jU--GU)
![img](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Depth-First-Search.gif/200px-Depth-First-Search.gif)