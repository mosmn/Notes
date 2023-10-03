# Serial Computing

Traditionally, software has been written for serial computation:

- Run on a single computer
- Instructions are run one after another
- Only one instruction executed at a time

## Von Neumann Architecture

The Von Neumann architecture has been the basis for virtually all computer designs since the first generation.

![Von Neumann Architecture](https://i0.wp.com/semiengineering.com/wp-content/uploads/2018/09/Screen-Shot-2017-04-26-at-1.08.57-PM.png?ssl=1)

- John von Neumann first authored the general requirements for an electronic computer in 1945.
- Data and instructions are stored in memory.
- Control unit fetches instructions/data from memory, decodes the instructions, and then sequentially coordinates operations to accomplish the programmed task.
- Arithmetic Unit performs basic arithmetic operations.
- Input/Output is the interface to the human operator.

### Von Neumann Architecture - Components

- Main Memory
  - Store program instruction and data
  - Program instruction – code to instruct computer
  - Data – information to be used by the program

- I/O Equipment
- Central Processing Unit (CPU)
- Arithmetic Logic Unit
- Control Unit
  - Fetches instruction/data from memory
  - Decode instructions
  - Sequentially coordinated operations to be performed

### Processor Registers

#### User-visible registers

- Minimize main-memory references
- Referenced by assembly language instructions (i.e., not high-level languages)
- Types of registers
  - Data - can be assigned by the programmer
  - Address – used for direct or indirect references to main memory
  - Condition Codes or flags

#### Control and status registers

- Control operation of the processor
- Control execution of programs
- Program Counter (PC): Contains the address of an instruction to be fetched
- Instruction Register (IR): Contains the instruction most recently fetched
- Program Status Word (PSW): condition codes; Interrupt enable/disable; Supervisor/user mode

## Limitations of Serial Computing

- Limitation of single CPU
- Performance
- Cache memory
- Transmission speeds
  - The speed of a serial computer is directly dependent upon how fast data can move through hardware. Absolute limits are the speed of light (30 cm/nanosecond) and the transmission limit of copper wire (9 cm/nanosecond). Increasing speeds necessitate increasing proximity of processing elements.
- Limits to miniaturization
  - Processor technology is allowing an increasing number of transistors to be placed on a chip. However, even with molecular or atomic-level components, a limit will be reached on how small components can be.
- Economic limitations
  - It is increasingly expensive to make a single processor faster. Using a larger number of moderately fast commodity processors to achieve the same (or better) performance is less expensive.

# Parallel Computing

- Simultaneous use of multiple compute sources to solve a single problem
- Use of multiple processors or computers working together on a common task.

![Parallel Computing](https://hpc.llnl.gov/sites/default/files/styles/with_sidebar_1_up/public/parallelProblem.gif?itok=u4OKbOB5)

## Parallel vs. Concurrent

![Parallel vs. Concurrent](https://www.baeldung.com/wp-content/uploads/sites/4/2022/01/vs-1024x462-1.png)

- Concurrency (switch contexts) actually means that multiple tasks can be executed in an overlapping time period. One of the tasks can begin before the preceding one is completed; however, they won't be running at the same time. The CPU will adjust time slices per task and appropriately switch contexts. That's why this concept is quite complicated to implement and especially debug.
- Parallelism (simultaneous) is the ability to execute independent tasks of a program in the same instant of time. Contrary to concurrent tasks, these tasks can run simultaneously on another processor core, another processor, or an entirely different computer that can be a distributed system. As the demand for computing speed from real-world applications increases, parallelism becomes more common and affordable.

## What is Parallel Computing?

In the simplest sense, parallel computing is the simultaneous use of multiple compute resources to solve a computational problem. It can be run using multiple CPUs. A problem is broken into discrete parts that can be solved concurrently, with each part further broken down into a series of instructions. Instructions from each part execute simultaneously on different CPUs.

## Parallel Computing: Resources

The compute resources can include:

- A single computer with multiple processors
- A single computer with (multiple) processor(s) and some specialized computer resources (GPU - graphics processing unit), FPGA - Field-programmable gate array, etc.
- An arbitrary number of computers connected by a network
- A combination of both

## Characteristics of Computational Problem

- Broken apart into discrete pieces of work that can be solved simultaneously
- Execute multiple program instructions at any moment in time
- Solved in less time with multiple compute resources than with a single compute resource

## Importance of Parallel Computing

- Ability to solve larger problems
- Ability to solve the same problem faster than the single CPU
- Provide concurrency (do multiple things at the same time)
- Limits to serial computing
- Taking advantage of non-local resources - using available compute resources on a wide area network or even the Internet when local compute resources are scarce.
- Cost savings - using multiple "cheap" computing resources instead of paying for time on a supercomputer
- Overcoming memory constraints - single computers have very finite memory resources. For large problems, using the memories of multiple computers may overcome this obstacle

## Limitations to Parallelism

- True data dependency
  - A data dependency in computer science is a situation in which a program statement (instruction) refers to the data of a preceding statement.
- Procedural dependency
- Resource conflicts
- Output dependency
- Anti-dependency
  - An anti-dependency, also known as write-after-read (WAR), occurs when an instruction requires a value that is later updated. In the following example, instruction 2 anti-depends on instruction 3 — the ordering of these instructions cannot be changed, nor can they be executed in parallel (possibly changing the instruction ordering), as this would affect the final value of A.

### Data Dependency Problem

The major problem of executing multiple instructions in a scalar program is the handling of data dependencies. If data dependencies are not effectively handled, it is difficult to achieve an execution rate of more than one instruction per clock cycle.