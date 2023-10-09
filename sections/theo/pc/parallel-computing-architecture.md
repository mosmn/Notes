# Parallel Computing Architecture

Flynn's Classical Taxonomy
• There are different ways to classify parallel computers. One of the
more widely used classifications, in use since 1966, is called Flynn's
Taxonomy.
• Flynn's taxonomy distinguishes multi-processor computer
architectures according to how they can be classified along the two
independent dimensions of Instruction and Data. Each of these
dimensions can have only one of two possible states: Single or
Multiple.

Flynn Taxonomy - Categories:

![categories](https://media.geeksforgeeks.org/wp-content/uploads/cao.png)

Taxonomy of Parallel Processor Architectures:

![2](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5nx8oBKTpXi2BHXvReptbA-hR4WbfjfH4lMt8oaUA5M3mQCZCul8p6yAcP11glkVcpmM&usqp=CAU)

## Single Instruction, Single Data (SISD)

![3](https://upload.wikimedia.org/wikipedia/commons/a/ae/SISD.svg)

• Uniprocessor
• Single processor
• Single instruction
• Single memory

• A serial (non-parallel) computer
• Single instruction: only one instruction
stream is being acted on by the CPU during
any one clock cycle
• Single data: only one data stream is being
used as input during any one clock cycle
• Deterministic execution
• This is the oldest and until recently, the
most prevalent form of computer
• Examples: most PCs, single CPU
workstations and mainframes 

## Single Instruction, Multiple Data (SIMD)

![4](https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/SIMD2.svg/220px-SIMD2.svg.png)

• Single instruction
control simultaneous
execution of
Processing Elements
(PE)
• Different PE different
data
• Vector and array
processor

• A type of parallel computer
• Single instruction: All processing units execute the same instruction at any given clock cycle
• Multiple data: Each processing unit can operate on a different data element
• This type of machine typically has an instruction dispatcher, a very high-bandwidth internal
network, and a very large array of very small-capacity instruction units.
• Best suited for specialized problems characterized by a high degree of regularity, such as
image processing.
• Synchronous (lockstep) and deterministic execution
• Two varieties: Processor Arrays and Vector Pipelines
• Examples:
• Processor Arrays: Connection Machine CM-2, Maspar MP-1, MP-2
• Vector Pipelines: IBM 9000, Cray C90, Fujitsu VP, NEC SX-2, Hitachi S820


