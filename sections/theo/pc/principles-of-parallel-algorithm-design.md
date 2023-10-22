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
• A directed path in the task dependency graph represents a sequence
of tasks that must be processed one after the other.
• The longest such path determines the shortest time in which the
program can be executed in parallel.
• The length of the longest path in a task dependency graph is called
the critical path length. 

#### Critical Path
• Start nodes: nodes with no incoming edges
• Finish nodes: nodes with no outgoing edges
• Critical path: the longest directed path between any pair of start and
finish nodes
• Critical path length: sum of the weights of the nodes on a critical path
• Average degree of concurrency = total amount of work
critical path length