# What is a Process?

As we have seen in the [Overview](/sections/theo/os/overview.md) section, a process is the executing entity when the processor begins to execute the program code. Components of a process include the following:
- Program code
- Set of data accociated with that code
- Execution context(aka process state)

### Process Elements

Let us suppose the processor begins to execute this program code, and we refer to this executing entity as a process. At any given point in time, while the program is executing, this process can be uniquely characterized by a number of elements, including the following:
- Identifier: A unique identifier associated with this process, to distinguish it from all other processes.
- State: If the process is currently executing, it is in the running state.
- Priority: Priority level relative to other processes.
- Program counter: The address of the next instruction in the program to be executed.
- Memory pointers: Include pointers to the program code and data associated with this process, plus any memory blocks shared with other processes.
- Context data: These are data that are present in registers in the processor while the process is executing.
- I/O status information: Includes outstanding I/O requests, I/O devices assigned to this process, a list of files in use by the process, and so on.
- Accounting information: May include the amount of processor time and clock time used, time limits, account numbers, and so on.

### Process Control Block

- Contains those process elements
- With it, it is possible to intertupt a running process and later resume it as if it had never been interrupted.
- Created and managed by the operating system
- Key tool that allows support for multiple processes.

# Process States

During program execution, a process is created for that program.

- From the processor POV, it executes instructions in sequence dictated by the changes in the program counter.

Overtime, the program counter may refer to code on different programs that are part of different processes.

- From a process POV, its execution involves a sequence of instructions within a program.

We can characterize the behavior of a process by listing the sequence of instructions that execute for that process. the behavior of the processor can be characterized by showing how the traces of the various processes are interleaved

- Such a list is called a Trace of the process, the listing containing the sequence of instructions that execute for that process.

Dispatcher: small program that switches the processor from one process to another.

## Two-State Process Model

## Five-State Process Model


# Process Description

# Process Control

# Security Issues
