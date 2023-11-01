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

# Singly Linked List

A singly linked list, also known as a linear linked list, is a type of linked list where all nodes are linked together using a single link (pointer) in sequential order, typically forward. Here are the key characteristics:

- The head pointer holds the address of the first node, marking the beginning of the linked list.
- Each node's pointer holds the address of the next node in the sequence.
- The last node in the linked list has its next field set to `NULL` to indicate the end of the list.

Singly linked lists are particularly useful for implementing linear sequences and dynamic data structures.

## Node Creation

To create a singly linked list, you start by creating nodes. Each node is a data structure that contains information and a pointer to the next node.

```cpp
class Node {
public:
    int data; // The data in the node
    Node* next; // Pointer to the next node
};

// Node creation:
Node* newNode = new Node();

// Data Initialization:
newNode->data = 6;
newNode->next = NULL;
```

## Node Insertion

There are several ways to insert nodes into a linked list depending on the list's state.

### Empty Linked List

If the linked list is empty, you can insert the first node as follows:

```cpp
Node* newNode = new Node();
newNode->data = 5;
newNode->next = NULL;

// Insert the first node into an empty linked list:
if (head == NULL)
    head = newNode;
```

With a tail pointer:

```cpp
Node* newNode = new Node();
newNode->data = 5;
newNode->next = NULL;

// Insert the first node into an empty linked list (with a tail pointer):
if (head == NULL)
    head = tail = newNode;
```

This initializes the linked list with a single node when it's empty. Depending on the implementation, you might also set the tail pointer to the new node to keep track of the list's end.

### End of Linked List

To insert a new node at the end of a linked list, you can follow these steps:

**Without Tail Pointer:**

```cpp
Node* newNode = new Node();
newNode->data = 6;
newNode->next = NULL;

Node* current = head;

if (current == NULL) {
    head = newNode; // If the list is empty, make the new node the head
} else {
    while (current->next != NULL) {
        current = current->next;
    }
    current->next = newNode; // Insert the new node at the end
}
```

**With Tail Pointer:**

```cpp
Node* newNode = new Node();
newNode->data = 6;
newNode->next = NULL;

if (head == NULL) {
    head = tail = newNode; // If the list is empty, set both head and tail to the new node
} else {
    tail->next = newNode; // Insert the new node at the end
    tail = newNode; // Update the tail to the new node
}
```

This code inserts a new node at the end of the linked list, and it is equivalent to the `push_back()` operation in both the STL vector and STL list.

### Beginning of Linked List

To insert a new node at the beginning of a linked list, you can follow these steps:

```cpp
// Node creation
Node* newNode = new Node();
newNode->data = 18;
newNode->next = NULL;

// Insert new node at the beginning
newNode->next = head;
head = newNode;
```

### Middle of Linked List

To insert a new node in the middle of a linked list, you can follow these steps:

```cpp
// Node creation
Node* newNode = new Node();
newNode->data = 18;
newNode->next = NULL;

// Create an additional pointer and move it to 1 position before the insertion location
Node* current = head;
int position = 1;

while (position < 3) {
    current = current->next;
    position++;
}

// Link the new node to the node after the node pointed by pointer current
newNode->next = current->next;

// Link the node pointed by pointer current to the new node
current->next = newNode;
```

## Node Deletion

There are three (4) ways to perform node deletion on linked list:​

### Single Node Linked List & Beginning Node Deletion

Create a temporary pointer:​

Node *n = head;​

Move head to the next node:​

head = head->next;​

Delete the targeted node:​

free(n);​

Steps to delete node at the beginning of linked list with tail pointer are illustrated as follows:​

Create a temporary pointer:​

Node *n = head;​

Move head to the next node:​

if(head->Info == 6)​

    head = head->next;​

Delete the targeted node:​

free(n);​


What if the linked list contains only single node?​
Answer:​
Additional steps below are required:​
   if(head == NULL)​
         tail = NULL;​

### Middle Node Deletion

Create a temporary pointer:​

Node *n = head, x;​

Move n to 1 position before targeted node:​

while (n -> next -> Info != 6)​

    n = n -> next;​

​

Place x at the targeted node:​

x = n->next;​

Link node pointed by n to the node after node pointed by x:​

n->next = x->next;​

Delete the targeted node:​

free(x);​

### End of Linked List

Create a temporary pointer:​

Node *n = head, x;​

Move n to 1 position before targeted node:​

while (n -> next -> Info != 7)​

    n = n -> next;​

​

Place x at the targeted node:​

x = n->next;​

Link node pointed by n to the node after node pointed by x:​

n->next = x->next;​

Delete the targeted node:​

free(x);​

Steps to delete node at the end of linked list (user’s input) with tail pointer are illustrated as follows:

Create a temporary pointer:​

Node *n = head, x;​

Move n to 1 position before targeted node:​

while (n -> next -> Info != 7)​

    n = n -> next;​

​

Place x at the targeted node:​

x = n->next;​

Link node pointed by n to the node after node pointed by x:​

n->next = x->next;​

Additional steps:​

if(x == tail)​

   tail = n;​

   Delete the targeted node:​

free(x);​

## Node Traversal​

# Doubly Linked List

A doubly linked list is one in which all nodes are linked together using double links (pointers) for accessing both the successor node and predecessor node from the given node position. Each node contains three fields: data, left link (prev), and right link (next). The `prev` link points to the predecessor node, and the `next` link points to the successor node. The data field stores the required data.

## Node Creation and Data Initialization

To create a doubly linked list, you start with creating a node. You need to allocate sufficient memory for creating a node. The format of a node can be defined as follows:

```cpp
struct Node {
    Data
    Pointer to the Next Node
    Pointer to the Previous Node
};
```

Here's how you can create a node and initialize its data:

```cpp
// Node creation:
Node *n = new Node();

// Data Initialization:
n->data = 5;
n->next = NULL;
n->prev = NULL;
```

## Node Insertion

### Empty Linked List

To insert the first node into an empty linked list, follow these steps:

**Step 1: Node creation and data initialization**
```cpp
Node *n = new Node();
n->data = 5;
n->next = n->prev = NULL;
```

**Step 2: Insert the first node into the linked list**
```cpp
if (head == NULL)
    head = n;
```

### End of Linked List (2nd Node Onwards)

To insert a new node at the end of the linked list (starting from the second node), follow these steps:

**Step 1: Node creation and data initialization**
```cpp
Node *n = new Node();
n->data = 21;
n->next = n->prev = NULL;
```

**Step 2: Insert the new node at the end of the linked list**
```cpp
Node *p = head;
while (p->next != NULL)
    p = p->next;
p->next = n;
n->prev = p;
```

### Beginning of Linked List

To insert a new node at the beginning of the linked list, follow these steps:

**Node creation and data initialization**
```cpp
Node *n = new Node();
n->data = 21;
n->next = n->prev = NULL;
```

**Insert the new node at the beginning of the linked list**
```cpp
n->next = head;
head->prev = n;
head = n;
```

### Middle of Linked List

To insert a new node in the middle of the linked list, follow these steps:

**Step 1: Node creation and data initialization**
```cpp
Node *n = new Node();
n->data = 21;
n->next = n->prev = NULL;
```

**Step 2: Create an additional pointer and move it to the insertion location**
```cpp
Node *p = head;
int i = 1;
while (i < 3) {
    p = p->next;
    i++;
}
```

**Step 3: Link the new node to the node after the node pointed by pointer p**
```cpp
n->next = p->next;
p->next->prev = n;
```

**Step 4: Link the node pointed by pointer p to the new node**
```cpp
p->next = n;
n->prev = p;
```

## Node Deletion

### Beginning of Linked List

To delete a node at the beginning of a linked list, follow these steps:

**Step 1: Create a temporary pointer and initialize it with the address of the first node**
```cpp
Node *n = head;
```

**Step 2: Move `head` to the next node**
```cpp
head = head->next;
```

**Step 3: Delete the targeted node**
```cpp
free(n);
```

**Step 4: Set the value of the first node's `prev` pointer to NULL**
```cpp
head->prev = NULL;
```

### Middle of Linked List - Option 1

To delete a node in the middle of a linked list (Option 1), follow these steps:

**Step 1: Create two temporary pointers and initialize one of them with the address of the first node**
```cpp
Node *n = head, *x;
```

**Step 2: Move `n` to 1 position before the targeted node**
```cpp
while (n->next->Info != 13)
    n = n->next;
```

**Step 3: Place `x` at the targeted node**
```cpp
x = n->next;
```

**Step 4: Link the node pointed by `n` to the node after the node pointed by `x` and vice versa**
```cpp
n->next = x->next;
x->next->prev = n;
```

**Step 5: Delete the targeted node**
```cpp
free(x);
```

### Middle of Linked List - Option 2

To delete a node in the middle of a linked list (Option 2), follow these steps:

**Step 1: Create a temporary pointer and initialize it with the address of the first node**
```cpp
Node *n = head;
```

**Step 2: Move `n` to the targeted node**
```cpp
while (n->Info != 13)
    n = n->next;
```

**Step 3: Link the previous node of the node pointed by `n` to the next node and vice versa**
```cpp
n->prev->next = n->next;
n->next->prev = n->prev;
```

**Step 4: Delete the targeted node**
```cpp
free(n);
```

### End of Linked List - Option 1

To delete a node at the end of a linked list (Option 1), follow these steps:

**Step 1: Create a temporary pointer and initialize it with the address of the first node**
```cpp
Node *n = head;
```

**Step 2: Move `n` to 1 position before the targeted node**
```cpp
while (n->next->next != NULL)
    n = n->next;
```

**Step 3: Delete the targeted node**
```cpp
free(n->next);
```

**Step 4: Set the next address of the last node to NULL**
```cpp
n->next = NULL;
```

### End of Linked List - Option 2

To delete a node at the end of a linked list (Option 2), follow these steps:

**Step 1: Create a temporary pointer and initialize it with the address of the first node**
```cpp
Node *n = head;
```

**Step 2: Move `n` to the targeted node**
```cpp
while (n->next != NULL)
    n = n->next;
```

**Step 3: Set the next address of the second last node to NULL**
```cpp
n->prev->next = NULL;
```

**Step 4: Delete the targeted node**
```cpp
free(n);
```

## Advantages of Doubly Linked List

- A doubly linked list can be traversed in both directions, forward and backward.
- The delete operation in a doubly linked list is more efficient if a pointer to the node to be deleted is given. In a singly linked list, to delete a node, a pointer to the previous node is needed.
- You can quickly insert a new node before a given node, for example, the insertion of a new node before the last node pointed to by the tail pointer.

## Disadvantages of Doubly Linked List

- It requires extra space for a previous pointer.
- All operations require an extra pointer (`prev`) to be maintained.