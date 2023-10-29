# Parallel Algorithm

## Introduction to Parallel Algorithm
A parallel algorithm is a method for solving a problem using multiple processors. It involves dividing a computation into smaller tasks and assigning them to different processors for parallel execution. The design and development of parallel algorithms typically follow a series of steps:

### Terms & Definitions
- Decomposition: The process of dividing a computation into smaller parts (tasks) for parallel execution.
- Task Dependency Graph: A directed graph representing task dependencies, indicating the order in which tasks must be executed.
- Task Interaction Graph: A graph illustrating the interactions and data exchange between tasks.
- Granularity: The size of tasks in a decomposition.
- Degree of Concurrency: The number of tasks that can be executed in parallel during program execution.

### 1. Understand the Problem and the Program
- The first step is to thoroughly understand the problem you intend to solve in parallel. This includes understanding the existing serial code if you're starting from one.
- Assess whether the problem can be parallelized. Some problems are naturally suited for parallel processing, while others may have limited parallelism.

### 2. Identify Potential Areas to Parallel
- Identify the hotspots in the program, where most of the computational work occurs. Profilers and performance analysis tools can assist in this.
- Focus on parallelizing these hotspots and disregard sections with minimal CPU usage.
- Recognize and address bottlenecks in the program, such as I/O operations or other slow areas.
- Consider inhibitors to parallelism, like data dependence, and explore alternative algorithms.
- Utilize optimized third-party parallel software and highly optimized math libraries when available.

### 3. Decomposing Problems to Tasks
- Decomposition is the process of dividing the computation into smaller tasks that can be executed concurrently.
- Tasks may vary in size and can be independent or have non-trivial order dependencies.
- Task decomposition can be visualized as a directed graph, with nodes representing tasks and edges indicating dependencies between tasks.

### 4. Granularity of Task Decompositions
- Granularity refers to the size of tasks in a decomposition.
- Fine-grain decomposition involves a large number of small tasks, while coarse-grain decomposition features a small number of larger tasks.
- The granularity can be adjusted depending on the specific problem and requirements. For instance, matrix-vector multiplication can be fine-grain (element-wise) or coarser-grain (computing multiple elements).

### 5. Degree of Concurrency
- The degree of concurrency indicates how many tasks can be executed in parallel.
- It can vary during program execution, with the maximum degree of concurrency being the most tasks that can be executed simultaneously at any point.
- The average degree of concurrency is the average number of tasks that can be processed in parallel over the program's execution.
- Task granularity and degree of concurrency have an inverse relationship; finer granularity leads to higher concurrency.

### Critical Path Length

- A directed path in the task dependency graph represents a sequence of tasks that must be processed one after the other.
- The longest such path determines the shortest time in which the program can be executed in parallel.
- The length of the longest path in a task dependency graph is called the critical path length. 

#### Critical Path

- Start nodes: nodes with no incoming edges
- Finish nodes: nodes with no outgoing edges
- Critical path: the longest directed path between any pair of start and finish nodes
- Critical path length: sum of the weights of the nodes on a critical path

## Limits on Parallel Performance
- The parallel time can be minimized by refining the granularity of decomposition.
- There is an intrinsic limit to how fine the granularity of computation can be.
- For instance, in dense matrix-vector multiplication, there can be no more than (n^2) concurrent tasks.
- Concurrent tasks might need to exchange data, introducing communication overhead.
- Performance is determined by the tradeoff between granularity and overhead.
- Amdahl’s law highlights the fraction of unparallelizable work, further limiting parallel performance.

## Task Interaction Graphs
- Tasks often exchange data.
- Consider the example of dense matrix-vector multiplication.
- The graph representing tasks and data exchange is a task interaction graph.
- These graphs depict data dependencies, unlike task dependency graphs, which show control dependencies.
- In a task interaction graph:
  - Node = task
  - Edge = interaction or data exchange

### Example
**Sparse Matrix-Vector Multiplication**
- Each result element's computation is an independent task.
- Only non-zero elements of the sparse matrix A participate.
- Task interaction graph structure = graph of matrix A (adjacency structure).

- Finer granularity leads to increased communication overhead.
- Consider the sparse matrix-vector product example:
  - If each node is a task, useful computation is 1 unit, and communication is 3 units.
  - If nodes 0, 4, and 5 are considered one task, useful computation is 3 units, and communication is 4 units (more favorable).

### Interaction Graphs, Granularity, & Communication
- Finer task granularity results in higher communication overhead.
- Example: sparse matrix-vector product interaction graph.
- Assumptions:
  - Each node takes 1 unit time to process.
  - Each interaction (edge) causes an overhead of 1 unit time.
- If node 0 is a task:
  - Communication = 3
  - Computation = 4
- If nodes 0, 4, and 5 are a task:
  - Communication = 5
  - Computation = 15
- Coarser-grain decomposition leads to smaller communication/computation.

Here are your notes organized using markdown:

# Decomposition Techniques
There are several decomposition techniques in parallel computing:

### Recursive Decomposition
- Suitable for problems that can be solved using divide-and-conquer.
- Steps:
  1. Decompose a problem into sub-problems.
  2. Recursively decompose each sub-problem.
  3. Stop decomposition when the desired granularity is reached.
- An example of a problem that can be divided recursively is Quicksort.

### Data Decomposition
- Steps:
  1. Identify the data on which computations are performed.
  2. Partition the data across various tasks.
- Data can be partitioned based on input data, output data, or both, depending on the problem's nature.
- Examples include finding the minimum in a set or sorting a vector.

### Exploratory Decomposition
- Used for problems involving a search of a space for solutions.
- The decomposition reflects the shape of the execution.
- Examples include discrete optimization, theorem proving, and game playing.

### Speculative Decomposition
- Applicable when dependencies between tasks are unknown.
- Two approaches:
  1. Conservative: Identify independent tasks only when dependencies are guaranteed.
  2. Optimistic: Schedule tasks even when dependencies are potential, requiring a rollback mechanism in case of errors.
- Discrete event simulation is a classic example of speculative decomposition.

### Hybrid Decompositions
- Often, a mix of decomposition techniques is necessary.
- For example, quicksort benefits from a combination of data and recursive decompositions.
- Discrete event simulation may require both speculative and data decompositions.
- Finding a minimum of numbers can also be improved using a mix of data and recursive decompositions.

# Process and Mapping

- The number of tasks in a decomposition usually exceeds the available processing elements, making mapping tasks to processes crucial.
- Appropriate mapping is determined by task dependency and task interaction graphs.
- A good mapping minimizes parallel execution time by assigning independent tasks to different processes, placing tasks on the critical path as they become available, and minimizing interaction between processes.
- These criteria can sometimes conflict with each other, and finding a balance is crucial for optimizing parallel performance.

## Mapping Techniques

- Mapping tasks onto processes plays a significant role in the efficiency of a parallel algorithm.
- The mapping determines how much of the concurrency obtained through decomposition is actually utilized.
- Mapping techniques aim to minimize communication and idling overhead, even though these objectives often conflict.

### Mapping Techniques for Minimum Idling

- Balancing load alone does not minimize idling.
- Minimizing one overhead might increase the other.
- Strategies for static mapping are used to address this issue.

### Schemes for Static Mapping

- Static mapping techniques include data partitioning, task graph partitioning, and hybrid strategies.
- Data partitioning and owner-computes rule are used for partitioning computation.
- Examples include 1-D block distribution schemes for dense matrices.

# Parallel Algorithm Design Models

- Algorithm models provide a structured approach to parallel algorithm design, involving decomposition and mapping techniques to optimize interactions.
- Various models are available:

### Data Parallel Model

- Tasks are mapped to processes, each performing similar operations on different data.
- Typically, tasks are statically or semi-statically mapped to processes.

### Task Graph Model

- Utilizes task dependency graphs to promote locality and reduce interaction costs.

### Master-Slave Model

- One or more processes generate work and allocate it to worker processes, with allocation being static or dynamic.

### Pipeline / Producer-Consumer Model

- A stream of data passes through successive processes, with each process performing specific tasks on the data.

### Hybrid Models

- Hierarchical or sequential application of multiple models to different phases of a parallel algorithm.