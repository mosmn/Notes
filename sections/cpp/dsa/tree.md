# Tree

## What is Tree?

- Tree data structure is a **non-linear** and a **hierarchical** structure.
- Consists of nodes, each storing a value and references to children.
- Central node, structural nodes, and subnodes connected via edges.
- Abstract data type (ADT) simulating a hierarchical tree structure.

## Types of Tree Data Structures

1. **General Tree:**
   - No restriction on the number of nodes.
   - Parent node can have any number of child nodes.

2. **Binary Tree:**
   - Elements have at most 2 children (left and right).
   - Used in searching and sorting algorithms.
   - Binary search tree properties: left node < parent, right node > parent.
  
3. **Expression Tree:**
   - Binary tree where internal nodes correspond to operators and leaves to operands.

## Tree Terminology

- **Root:** Topmost node without any parent.
- **Edge:** Line connecting two nodes.
- **Children:** Immediate successor nodes.
- **Siblings:** Children of the same parent.
- **Leaf node:** Node without children.
- **Internal node:** Node with at least one child.
- **Size of a tree:** Number of nodes in the tree.

### Example:
- **Root:** 1
- **Parent of Node 5:** 2
- **Ancestor of Node 5:** 1, 2
- **Children/Descendant of Node 1:** (2, 3)
- **Siblings:** (4, 5, 6), (7, 8), (9, 10)
- **Leaf nodes:** 4, 9, 10, 6, 11, 8
- **Internal Nodes:** 1, 2, 3, 5, 7

## Tree Terminology (continued)

- **Depth of Node x:** Length of path from root to Node x.
- **Height of Node x:** Number of edges in the longest path from node x to leaf node.
- **Height of tree:** Height of the root.
- **Level of node:** Set of all nodes at a given depth.

# Binary Tree

## What is Binary Tree?

- Node can have a maximum of 2 child nodes (left and right).
- Types: Rooted, Degenerate, Full, Complete.

### Types of Binary Tree

1. **Rooted Binary Tree:**
   - Each node has 0, 1, or 2 child nodes.

2. **Degenerate Binary Tree:**
   - All nodes have only one child, like a linked list.

3. **Full Binary Tree:**
   - Each node has exactly 0 or 2 children.

4. **Complete Binary Tree:**
   - All levels are filled except possibly the last.

## Types of Binary Tree (Examples)

- **Full Binary Tree Example:** 
   - Number of leaf nodes = internal nodes + 1.
   - Max nodes for height 2: 7, Min nodes: 5.
   - Height of tree with max nodes: 2, with min nodes: 2.

- **Complete Binary Tree Example:**
   - Max nodes for height 2: 7, Min nodes: 4.
   - Height of tree with max nodes: 2, with min nodes: 2.

## Types of Binary Tree (Summary)

| Type of Tree          | Minimum Nodes | Maximum Nodes     |
|-----------------------|---------------|-------------------|
| Binary Tree           | h + 1         | 2^(h+1) - 1       |
| Full Binary Tree      | 2^(h+1)        | 2^(h+1) - 1       |
| Complete Binary Tree  | 2^h           | 2^(h+1) - 1       |

Calculation for total number of nodes:

- Binary Tree: [log(n+1)] – 1
- Full Binary Tree: [log(n+1)] – 1
- Complete Binary Tree: [log(n+1)] – 1

Calculation for height of tree where n = total number of nodes:

| Type of Tree          | Minimum Height | Maximum Height    |
|-----------------------|-----------------|-------------------|
| Binary Tree           | [log(n+1)] – 1  | n - 1             |
| Full Binary Tree      | [log(n+1)] – 1  | (n-1)/2           |
| Complete Binary Tree  | [log(n+1)] – 1  | log(n)            |

# Binary Search Tree

## What is Binary Search Tree?

- Enhancement to binary tree.
- Nodes contain keys with comparisons for efficient searching.
- Left child's key < parent's key, right child's key ≥ parent's key.
- Improves search performance with O(log n) complexity.

## BST Operations – Insertion

1. If the tree is empty, create a root node with the new key.
2. Compare the key with the top node.
   - If key = node key, replace the node with the new value.
   - If key > node key, compare key with the right subtree.
      - If subtree is empty, create a leaf node.
      - Else, add key in the right subtree.
   - If key < node key, compare key with the left subtree.
      - If the subtree is empty, create a leaf node.
      - Else, add key to the left subtree.

**Example:**
Insert series: 49, 28, 18, 83, 40, 17, 97, and 73.

## BST Operations – Deletion

1. **Condition 1:** Node is a leaf node.
   - Node is deleted straight from the binary tree.

2. **Condition 2:** Node has a single child.

3. **Condition 3:** Node has two children.

Here is the organized content with appropriate headings and subheadings:

## Expression Tree

### What is Expression Tree?

The expression tree is a binary tree in which each internal node corresponds to the arithmetic operator and each leaf node corresponds to the operand. Example of Expression tree for algebraic expression A * (B+C) is as follows:

```
   *
  / \
 B   C
  \
   A
```

### Let's try to convert this algebraic expression to expression tree:
**(a + b) – (c + d)**

## Exercise 1

**Source: Final Exam previous semester**
Convert the following expression to tree: **a + b – c + d**

*Solution:* [Provide solution here]

## Exercise 2

**Source: Final Exam previous semester**
Convert the following expression to tree: **5 * ( y – 3 ) + 2 / ( x + 7 )**

*Solution:* [Provide solution here]

## Tree Traversal

### Types of Tree Traversal

A Tree is typically traversed in two ways:

1. Breadth First Traversal (or Level Order Traversal)
2. Depth First Traversals:
    - Inorder Traversal (Left-Root-Right)
    - Preorder Traversal (Root-Left-Right)
    - Postorder Traversal (Left-Right-Root)

### Types of Tree Traversal (continued)

1. **Breadth First Traversal (or Level Order Traversal)**
    - BFS uses Queue data structure for finding a shortest path.
    - BFS starts visiting nodes from root, one vertex is selected at a time when it is visited and marked then its adjacent are visited and stored in the queue. It reach a vertex with minimum number of edges from a source vertex.
    - BFS is more suitable for searching vertices which are closer to the given source. Hence, if our problem is to search something that is more likely to be closer to the root, we would prefer BFS.
    - BFS considers all neighbors first and therefore not suitable for decision-making trees used in games or puzzles.

```
   A
  / \
 B   C
/ \   \
D  E   F
   \
    G   
```
   *BFS: A B C D E F G*

### Types of Tree Traversal (continued)

2. **Depth First Traversals**
   - It is an edge-based technique.
   - In DFS, we might traverse through more edges to reach a destination vertex from a source.
   - DFS is more suitable when there are solutions away from the source. Hence, if the target node is close to a leaf, we would prefer DFS.
   - DFS is more suitable for game or puzzle problems. We make a decision, then explore all paths through this decision. And if this decision leads to a win situation, we stop.

```
   A
  / \
 B   C
/ \   \
D  E   F
   \
    G
```
   *DFS (preorder): A B D E C F G*

### Types of Tree Traversal (continued)

2. **Depth First Traversals (continue):**
   - Preorder (VLR) - the node is visited before the left and right subtrees.
   - Inorder (LVR) - the node is visited between the left and right subtrees.
   - Postorder (LRV) - the node is visited after both the left and right subtrees.

```
   A
  / \
 B   C
/ \   \
D  E   F
   \
    G
```
   *Inorder: D B E A F C G*

   ```
   A
  / \
 B   C
/ \   \
D  E   F
   \
    G
   ```
   *Postorder: D E B F G C A*

## Exercise 3

Let's try to evaluate the preorder, inorder, and postorder traversal for this diagram:

```
   A
  / \
 B   C
/ \   \
D  E   F
   \
    G
```

*Solution:*
- *Preorder: A B D E C F G*
- *Inorder: D B E A F C G*
- *Postorder: D E B F G C A*

## Exercise 4

**Source: Test 2 previous semester**
Write the Preorder, Inorder, and Postorder traversal for the figure below:

```
    +
   / \
  D   -
     / \
    B   C
   /
  A
```

*Solution:* [Provide solution here]

## Exercise 5

**Source: Final Exam previous semester**
A prefix expression, **+ * 5 – y 3 / 2 + x 7** can be represented as an expression tree, by representing operators as non-leaf nodes and operands (variables and constants) as leaf nodes. Show how the above expression would be represented as a binary tree following this convention.

*Solution:* [Provide solution here]

## Exercise 6

**Source: Quiz 3 previous semester**
Draw an expression tree for the below postfix algebraic expression: **5 x – y 3 + + 5 x – y / ***

*Solution:* [Provide solution here]

## Linked List Implementation

### Tree Linked List

Creating a tree linked list starts with creating a node. Sufficient memory has to be allocated for creating a node.
**Format of a node:**

```cpp
struct Node {
    Data datatype;
    Node* left;
    Node* right;
};
```

or

```cpp
class Node {
public:
    Data classname;
    Node* left;
    Node* right;
};
```

#### Node Creation and Data Initialization:

```cpp
// Node creation:
Node* n = new Node();
// Data Initialization:
n->no = 6;
n->left = n->right = NULL;
```

### Tree Linked List: Program Sample

#### Node Creation

```cpp
void createNode() {
    Node* n = new Node;
    cout << "Enter a number: ";
    cin >> n->data;
    n->left = n->right = NULL;
    insert(n, root);
}
```

### Tree Linked List: Program Sample

#### Node Insertion

```cpp
void insert(Node* n, Node* parent) {
    if (root == NULL)
        root = n;
    else if (n->data < parent->data) {
        if (parent->left != NULL)
            insert(n, parent->left);
        else
            parent->left = n;
    } else {
        if (parent->right != NULL)
            insert(n, parent->right);
        else
            parent->right = n;
    }
}
```

### Tree Linked List: Program Sample

#### Node Traversal - display()

```cpp
void display() {
    int traversal;
    Node* p = root;
    cout << "Choose type of traversal [1] Inorder [2] Preorder [3] Postorder: ";
    cin >> traversal;
    switch (traversal) {
        case 1: inorder(p); break;
        case 2: preorder(p); break;
        case 3: postorder(p); break;
    }
}
```

### Tree Linked List: Program Sample

#### Node Traversal - inorder()

```

cpp
void inorder(Node* p) {
    if (p != NULL) {
        inorder(p->left);
        cout << p->data << " ";
        inorder(p->right);
    }
}
```

### Tree Linked List: Program Sample

#### Node Traversal - preorder()

```cpp
void preorder(Node* p) {
    if (p != NULL) {
        cout << p->data << " ";
        preorder(p->left);
        preorder(p->right);
    }
}
```

### Tree Linked List: Program Sample

#### Node Traversal - postorder()

```cpp
void postorder(Node* p) {
    if (p != NULL) {
        postorder(p->left);
        postorder(p->right);
        cout << p->data << " ";
    }
}
```

### Tree Linked List: Program Sample

#### Node Traversal - search()

```cpp
void search() {
    int key, flag = 0;
    Node* s = root;
    cout << "Enter a value: ";
    cin >> key;
    if (root == NULL)
        cout << "Tree is empty";
    else {
        while (s != NULL) {
            if (s->data == key) {
                cout << "Data is exist";
                flag = 1;
            }
            if (s->data > key)
                s = s->left;
            else
                s = s->right;
        }
    }
    if (flag == 0)
        cout << "Data is not exist";
}
```

## Exercise 7

Assume that we have a tree linked list, containing n number of nodes, where n > 50. Pointer **root** points to the first node, which acts as the head pointer and value is a data in the node. Find and correct the error(s) in each of the following code segments. This code segment is to display the largest value in a binary search tree.

```cpp
Tree* t = root;
t++;
cout << "Largest value is" << t.value << endl;
```

*Solution:* [Provide solution here]

## Exercise 8

Assume that we have a tree linked list, containing n number of nodes, where n > 50. Pointer **root** points to the first node, which acts as the head pointer and value is a data in the node. Find and correct the error(s) in each of the following code segments. This code segment is to delete a node that has a single leaf node on the left. Assume that **temp** is a pointer that points to this node.

```cpp
free(temp);
```

*Solution:* [Provide solution here]

## Exercise 9

**Source: Quiz 3 Sem 1 2020 / 2021**

*Solution:* [Provide solution here]

## Exercise 10

**Source: Quiz 3 Sem 1 2020 / 2021**

*Solution:* [Provide solution here]

## Exercise 11

**Source: Test 2 Sem 1 2020 / 2021**

*Solution:* [Provide solution here]

## Summary

- One reason to use trees might be because you want to store information that naturally forms a hierarchy. For example, the file system on a computer such as folder structure.
- Searching operation can be performed in moderate time with some ordering such as BST which is faster than Linked List.
- Node insertion and deletion can be performed in moderate time.