# **What is Graph?**
- **Graph Data Structure:**
  - Non-linear structure with vertices (or nodes) and edges.
  - Vertices connected by edges in unordered pairs {u, v}.

- **Graph Properties:**
  - Order of graph (number of vertices) denoted by |V|.
  - Size of graph (number of edges) denoted by |E|.

### **Graph Application**
- Used in real-life problems:
  - Networks, social networks, biology, computer science, physics, chemistry, etc.

### **Types of Graph**
1. **Finite Graph:**
   - Finite vertices and edges.

2. **Infinite Graph:**
   - Infinite vertices and edges.

3. **Trivial Graph:**
   - One vertex, no edge.

4. **Null Graph:**
   - Order (n) vertices, no edges.

5. **Simple Graph:**
   - No more than one edge between vertices.

6. **Directed Graph (Digraph):**
   - Edges map onto ordered pairs of vertices.

7. **Undirected Graph:**
   - No direction in edges.

8. **Weighted Graph:**
   - Edges have associated costs.

9. **Multi Graph:**
   - May contain parallel edges, no self-loop.

10. **Pseudo Graph:**
    - Contains self-loop and multiple edges.

### **Graph Representation**
- **Adjacency List:**
  - List of vertices, each with a list of adjacent vertices.
  - Can represent weighted graphs.

- **Adjacency Matrix:**
  - 2D array of size V x V.
  - Matrix[i][j] = 1 if there is an edge between vertex i and j.

### **Shortest Path Algorithm: Dijkstra's Algorithm**
- Finds shortest distance in a weighted graph.
- Only applicable when all weights are positive.

### **Spanning Tree**
- Subset of connected graph with no cycles.
- Minimum Spanning Tree (MST): Spanning tree with the minimum total edge weights.

### **Kruskal's Algorithm**
1. Sort edges in non-decreasing order.
2. Pick smallest edge; include if no cycle formed.
3. Repeat until (V-1) edges in spanning tree.

### **Examples and Exercises:**
- Examples and exercises applying Dijkstra's Algorithm and Kruskal's Algorithm.

### **Graph Application Exercise (Pos Laju Malaysia):**
- Type of graph analysis.
- Dijkstra's Algorithm application.
- Kruskal's Algorithm application.

### **Conclusion:**
- Overview of graph concepts, types, representation, and algorithms.