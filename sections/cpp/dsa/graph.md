# **What is Graph?**
- **Graph Data Structure:**
  - Non-linear structure with vertices (or nodes) and edges.
  - Vertices connected by edges in unordered pairs {u, v}.

- **Graph Properties:**
  - Order of graph (number of vertices) denoted by |V|.
  - Size of graph (number of edges) denoted by |E|.

### **Graph Application**

Graphs find applications in various real-life problems across different domains:

#### **Math:**
- **Discrete Structure:**
  - Utilized for modeling discrete mathematical structures.
- **Geometry:**
  - Applied in geometric problems and representations.
- **Etc:**
  - Further applications in diverse mathematical scenarios.

#### **Social Sciences:**
- **Social Media:**
  - Used for modeling and analyzing social media structures.
- **Rumors Analysis:**
  - Analyzing the spread of rumors within a network.
- **Social Network Analysis:**
  - Studying the relationships and structures in social networks.
- **Crime Investigation:**
  - Mapping connections in crime networks for investigative purposes.

#### **Biology:**
- **Species Tracking:**
  - Tracking and analyzing the movements of different species.
- **Breeding Pattern:**
  - Modeling and understanding breeding patterns in populations.
- **Cell Cluster (Virus):**
  - Analyzing the clustering of cells, especially in virus structures.

#### **Computer Science:**
- **Web Pages:**
  - Modeling the structure and connectivity of web pages.
- **Network Connection:**
  - Analyzing and optimizing network connections.
- **Algorithm Analysis:**
  - Graphs are fundamental in algorithmic analysis.

#### **Physics & Chemistry:**
- **Atom Topology:**
  - Modeling the topology of atoms in molecular structures.
- **Molecular Structure:**
  - Representing and analyzing the structures of molecules.
- **Cell Connection:**
  - Modeling connections between cells in biological systems.

#### **Other:**
- **Road Network (GPS):**
  - Used for navigation and optimization in road networks.
- **Organization Hierarchy:**
  - Representing and analyzing hierarchical structures in organizations.
- **Financial:**
  - Modeling and analyzing financial networks and transactions.

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