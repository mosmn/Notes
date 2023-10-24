## Singly Linked List Implementation

A singly linked list is a type of linked list where all nodes are connected in a linear, forward sequence. It is characterized by the use of a single link or pointer in each node to connect to the next node in the list. The first node, often referred to as the "head," points to the second node, which points to the third, and so on. The last node in the linked list has its next field set to NULL, indicating the end of the list.

## Doubly Linked List Implementation

A doubly linked list, on the other hand, is a linked list in which each node has two pointers: one that points to the next node in the sequence and another that points to the previous node. This bidirectional connection allows for more efficient traversal in both directions, making operations such as inserting and deleting elements more efficient.

# What is a Linked List?

A linked list is a non-sequential collection of independent memory locations (nodes) that store data and links to other nodes. For every data item in a linked list, there is an associated pointer that provides the memory location of the next data item in the linked list. Unlike arrays, the data items in a linked list are not stored in consecutive memory locations; they may be scattered, but accessing these data items is more efficient because each data item contains the address of the next data item.

### Advantages of Linked List

1. **Dynamic Data Structure**: Linked lists are dynamic data structures, and memory is allocated and deallocated as needed.
2. **Efficient Memory Utilization**: Memory is not pre-allocated, saving memory space.
3. **Efficient Insertions and Deletions**: Inserting and deleting data items are easier and more efficient, providing flexibility in managing data.

### Limitations of Linked List

1. **Space Consumption**: Linked lists consume more space due to the requirement of an additional pointer in each node.
2. **Search Complexity**: Searching for a particular element in a linked list is difficult and time-consuming compared to arrays.

## Comparison of Linked Lists with Arrays

| Operation            | Static Array | Linked List     |
|----------------------|--------------|-----------------|
| Linear Access        | Efficient    | Efficient       |
| Random Access        | Efficient    | Inefficient     |
| Insertion/Deletion   | Inefficient  | Efficient       |
| Element Re-arrangement | Inefficient | Efficient       |
| Overhead per Element | None         | 1 or 2 links    |

### Types of Linked Lists

Linked lists can be categorized into four main types:

1. **Singly Linked List**
2. **Doubly Linked List**
3. **Circular Linked List**
4. **Circular Double Linked List**

## Singly Linked List

A singly linked list, also known as a linear linked list, is a type of linked list where all nodes are linked together using a single link (pointer) in sequential order, typically forward. Here are the key characteristics:

- The head pointer holds the address of the first node, marking the beginning of the linked list.
- Each node's pointer holds the address of the next node in the sequence.
- The last node in the linked list has its next field set to `NULL` to indicate the end of the list.

Singly linked lists are particularly useful for implementing linear sequences and dynamic data structures.