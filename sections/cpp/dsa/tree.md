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

### Example:
- **Height of node 7:** 1
- **Depth of node 4:** 2

## Exercise 1

**Q1:** How many ancestors of node E?

**Q2:** Are D and I siblings? If no, what is the relationship?

**Q3:** Common ancestors of A and C?

## Exercise 2

**Q1:** Height of node B?

**Q2:** Size of the tree?

**Q3:** Depth of the root node?

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

- **Minimum nodes Maximum nodes**
- **Binary Tree:** h+1 2h+1 – 1
- **Full Binary Tree:** 2h+1 2h+1 – 1
- **Complete Binary Tree:** 2h 2h+1 – 1

- **Calculation for total number of nodes:**
   - Binary Tree: [log(n+1)] – 1
   - Full Binary Tree: [log(n+1)] – 1
   - Complete Binary Tree: [log(n+1)] – 1

- **Calculation for height of tree (n = total nodes):**
   - Binary Tree: [log(n+1)] – 1, n-1
   - Full Binary Tree: [log(n+1)] – 1, (n-1)/2
   - Complete Binary Tree: [log(n+1)] – 1, log(n)

## Exercise 3

**Q:** A ___________ tree is a tree where for each parent node, there is only one associated child node on the right.
- a) Balanced binary tree
- b) Rooted complete binary tree
- c) Complete binary tree
- d) Degenerate tree

## Exercise 4

**Q:** Given a binary tree with 31 nodes, what is the minimum possible depth of the tree?
- a) 3
- b) 4
- c) 5
- d) 6

## Exercise 5

**Q:** What is the minimum number of nodes in a full binary tree with level 3?
- a) 4
- b) 7
- c) 9
- d) 11

## Exercise 6

**Q:** What is the minimum number of nodes in a complete binary tree with level 3?
- a) 4
- b) 8
- c) 11
- d) 15

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

## Exercise 7

**Q:** Draw the final binary search tree for the series: 53, 18, 99, 24, 50, 65, 120.

## BST Operations – Deletion

1. **Condition 1:** Node is a leaf node.
   - Node is deleted straight from the binary tree.

2. **Condition 2:** Node has a single child.

3. **Condition 3:** Node has two children.

