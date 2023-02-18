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

### Process creation and termination

4 reasons for process creation:
Reason | Description
---|---
New batch job | The OS is provided with a batch job control stream, usually on tape or disk. When the OS is prepared to take on new work, it will read the next sequence of job control commands.
Interactive log-on | A user at a terminal logs on to the system.
Created by OS to provide a service | The OS can create a process to perform a function on behalf of a user program, without the user having to wait (e.g., a process to control printing).
Spawned by existing process | For purposes of modularity or to exploit parallelism, a user program can dictate the creation of a number of processes.

Process termination:
There must be a means for a process to indicate its completion
1. A batch job should include a HALT instruction or an explicit OS service call for termination
2. For an interactive application, the action of the user will indicate when the process is completed (e.g. log off, quitting an application)

Reasons for process termination:
- protection error
- time overrun
- i/o failure
- invalid instruction
so on...

## Two-State Process Model

In this model, a process may be in one of the two states: Running or Not Running.

How it works:
- When the OS creates a new process, it creates a process control block for the process and enters that process into the system in the Not Running state. The process exists, is known to the OS, and is waiting for an opportunity to execute. From time to time, the currently running process will be interrupted, and the dispatcher portion of the OS will select some other process to run. The former process moves from the Running state to the Not Running state, and one of the other processes moves to the Running state.

### Queuing Diagram

![Queuing Diagram](//imgs/osqd.png)
Processes that are not running must be kept in some sort of queue, waiting their turn to execute.

There is a single queue in which each entry is a pointer to a particular process.

A process that is interrupted is transferred to the queue of waiting processes. Alternatively, if the process has completed or aborted, it is discarded (exits the system). In either case, the dispatcher takes another process from the queue to execute.

The queue is first in first out (FIFO) list and the processor operates in Round robin.

Leading to Five-State Process Model:

- Single queue suggested will be effective if all processes were always ready to execute.
- But it is inadequate because some process that are in Not Running state either ready to execute or blocked because of waiting for I/O operation complete.
- By using a single queue, the dispatcher has to scan the queue looking for the process that is not blocked and has been waiting in queue the longest.

We can solve this by splitting the "Not Running" state into two states:
- Ready state: ready to execute
- Blocked state: waiting for I/O operation to complete

now instead of two states, we have five states by adding another two states "new" and  "exit" that are useful for process management.

## Five-State Process Model

Process State | Description
---|---
New | a process that has just been created but not yet admitted to the pool of executable processes by the OS. typically, a new process has not yet been loaded into main memory., although its process control block has been created.
Ready | a process is ready to execute when given the opportunity.
Running | the process is currently executing.
Blocked | a process that cannot execute until some event occurs or completes.(events include I/O operations, waiting for OS services)
Exit | a process that has been released from the pool of executable processes by the OS, either because it halted or aborted for some reason.

### Using Two Queues

![Two Queues](///imgs/tqd.png)
As each process is admitted to the system, it is placed in the Ready queue. When it is time for the OS to choose another process to run, it selects one from the Ready queue. 

When a running process is removed from execution, it is eitherterminated or placed in the Ready or Blocked queue, depending onthe circumstances

Finally, when an event occurs, any process in the Blocked queue that has been waiting on that event only is moved to the Ready queue.

## Suspended Processes

When the process need to be executed all the processes components need to be in the main memory.

Processor is faster than I/O operation, all processes could be waiting for I/O.

Thus even with multiprogramming, processor could be idle most of the time.

How to solve it?

- Expanding the size of the main memory
    - Memory can accommodate more processes
    - disadvantage: expensive and results in larger processes not more processes

- Swapping
    - Move processes in and out of main memory to disk to free up memory for other processes

### Swapping

- involves moving part of all of a process from main memory to disk.
- when none of the processes in main memory is in the Ready state, the OS swaps one of the blocked processes out on to disk into a suspend queue.

Characteristics of a Suspended Process:
- The process is not immediately available for execution, Other process is occupying the processor
- The process may or may not be waiting on an event .Other process output Resource availability
- The process was placed in a suspended state by an agent: either itself, a parent process, or the OS, for the purpose of preventing its execution
- The process may not be removed from this state until the agent explicitly orders the removal

One suspend state: A suspended process is SWAPPED OUT and resides in storage.

Two suspend states: A suspended process is SWAPPED OUT and resides in storage, and a suspended process is SWAPPED IN and resides in main memory.

### Reasons for process suspension

Reason | Description
---|---
Swapping | The OS needs to release sufficient main memory to bring in a process that is ready to execute.
Other OS reason | The OS may suspend a background or utility process or a process that is suspected of causing a problem.
Interactive user request | A user may wish to suspend execution of a program for purposes of debugging or in connection with the use of a resource.
Timing | A process may be executed periodically (e.g., an accounting or system monitoring process) and may be suspended while waiting for the next time interval.
Parent process request | A parent process may wish to suspend execution of a descendent to examine or modify the suspended process, or to coordinate the activity of various descendants.

# Process Description

# Process Control

# Security Issues
