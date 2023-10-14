# Parallel Algorithm

• Recipe to solve a problem using multiple processors
• Typical steps for constructing a parallel algorithm
• identify what pieces of work can be performed concurrently
• partition concurrent work onto independent processors
• distribute a program’s input, output, and intermediate data
• coordinate accesses to shared data: avoid conflicts
• ensure proper order of work using synchronization
• Why “typical”? Some of the steps may be omitted.
• if data is in shared memory, distributing it may be unnecessary
• if using message passing, there may not be shared data
• the mapping of work to processors can be done statically by the programmer or
dynamically by the runtime

First step :Understand the Problem and the
Program
• Undoubtedly, the first step in developing parallel software is to first understand the problem that you wish
to solve in parallel. If you are starting with a serial program, this necessitates understanding the existing
code also.
• Before spending time in an attempt to develop a parallel solution for a problem, determine whether or not
the problem is one that can actually be parallelized.
• Example of an easy to parallelize problem:Calculate the potential energy for each of
several thousand independent
conformations of a molecule. When done,
find the minimum energy conformation.
• This problem is able to be solved in parallel. Each of the molecular conformations is independently
determinable. The calculation of the minimum energy conformation is also a parallelizable problem.
• Example of a problem with little-to-no parallelism:Calculation of the Fibonacci series
(0,1,1,2,3,5,8,13,21,...)
by use of the formula:
F(n) = F(n-1) + F(n-2)
• The calculation of the F(n) value uses those of both F(n-1) and F(n-2), which must be computed first.

Identify Potential Areas to Parallel
• Identify the program's hotspots:
• Know where most of the real work is being done. The majority of scientific and technical programs usually
accomplish most of their work in a few places.
• Profilers and performance analysis tools can help here
• Focus on parallelizing the hotspots and ignore those sections of the program that account for little CPU usage.
• Identify bottlenecks in the program:
• Are there areas that are disproportionately slow, or cause parallelizable work to halt or be deferred? For
example, I/O is usually something that slows a program down.
• May be possible to restructure the program or use a different algorithm to reduce or eliminate unnecessary
slow areas
• Identify inhibitors to parallelism
• One common class of inhibitor is data dependence, as demonstrated by the Fibonacci sequence above.
• Investigate other algorithms if possible
• This may be the single most important consideration when designing a parallel application.
• Take advantage of optimized third party parallel software and highly optimized math libraries available from
leading vendors (IBM's ESSL, Intel's MKL, AMD's AMCL, etc.).

Terms & Definitions
• The two key steps in the design of parallel algorithms:
• Dividing a computation into smaller computations and
• assigning them to different processors for parallel execution
• The process of dividing a computation into smaller parts, some or all of
which may potentially be executed in parallel, is called decomposition.
• Tasks are programmer-defined units of computation into which the main
computation is subdivided by means of decomposition.
• Simultaneous execution of multiple tasks is the key to reducing the time
required to solve the entire problem.
• The tasks into which a problem is decomposed may not all be of the same
size.

Decomposing Problems to Tasks
• Divide work into tasks that can be executed concurrently
• Many different decompositions possible for any computation
• Tasks may be same, different, or even indeterminate sizes
• Tasks may be independent or have non-trivial order
• Conceptualize tasks and ordering as task dependency directed graph

Graphs for Task Decomposition
• A decomposition can be illustrated in the form of a directed graph
with nodes corresponding to tasks and edges indicating that the
result of one task is required for processing the next. Such a graph is
called a task dependency graph.
• The graph of tasks (nodes) and their interactions/data exchange
(edges) is referred to as a task interaction graph.
• Note that task interaction graphs represent data dependencies,
whereas task dependency graphs represent control dependencies. 