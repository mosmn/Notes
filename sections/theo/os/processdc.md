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

![Queuing Diagram](/imgs/osqd.png)
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

![Two Queues](/imgs/tqd.png)
    
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

### One suspend state

After the OS swaps-out a process from blocked state to suspend state, it brings back a previously suspended process into main memory.

the problem with this is that all of the processes that have been suspended were in the Blocked state at the time of suspension. It clearly would not do any good to bring a blocked process back into main memory, because it is still not ready for execution. Recognize, however, that each process in the Suspend state was originally blocked on a particular event. When that event occurs, the process is not blocked and is potentially available for execution.

Therefore, we need to rethink this aspect of the design. leading us to the two suspend state model.

### Two suspend states

There are two independent concepts here: whether a process is waiting on an event (blocked or not), and whether a process has been swapped out of main memory (suspended or not). To accommodate this 2×2 combination, we need four states:

- Ready: The process is in main memory and available for execution.
- Blocked: The process is in main memory and awaiting an event.
- Blocked/Suspend: The process is in secondary memory and awaiting an event.
- Ready/Suspend: The process is in secondary memory but is available for execution as soon as it is loaded into main memory.

### Reasons for process suspension

Reason | Description
---|---
Swapping | The OS needs to release sufficient main memory to bring in a process that is ready to execute.
Other OS reason | The OS may suspend a background or utility process or a process that is suspected of causing a problem.
Interactive user request | A user may wish to suspend execution of a program for purposes of debugging or in connection with the use of a resource.
Timing | A process may be executed periodically (e.g., an accounting or system monitoring process) and may be suspended while waiting for the next time interval.
Parent process request | A parent process may wish to suspend execution of a descendent to examine or modify the suspended process, or to coordinate the activity of various descendants.

# Process Description

The OS contorls events within computer system. Schedules and dispatches processes for execution by the processor, allocates resources(memory, i/o devices, files) to processes and responds to requests by user processes for basic services.

For the OS to manage the processes and resources, it must have information about the current status of each process and resource.

Tables are constructed for each entity the operating system manages. these tables are called OS control tables.

## OS Control Tables

### Memory tables

- used to keep tack of both main(real) memory and secondary(virtual) memory.
- Processes are maintained on secondary memory using some sort of virtual memory or simple swapping mechanism

Must include:
- allocation of main memory toprocesses
- allocation of secondary memory to processes
- protection attributes of blocks of main or virtual memory
- information needed to manage virtual memory

### I/O tables

- Used by the OS to manage the I/O devices and channels of the computer system
- At any given time, an I/O device may be available or assigned to a particular process

If an I/O operation is in progress, the OS needs to know:
- the status of the I/O operation
- the location in main memory being used as the source or destination of the I/O transfer

### File tables

- Provides info about:
    - existence of files
    - location on secondary memory
    - current status
    - other attributes

Much, if not all, of this information may be maintained and used by a file management system, in which case the OS has little or no knowledge of files. In other operating systems, much of the detail of file management is managed by the OS itself.

### Process tables

- Must be maintained to manage processes
- There must be some reference to memory, I/O, and files, directly or indirectly
- The tables themselves must be accessible by the OS and therefore are subject to memory management

In order to manage and control a process the OS must know:
1. Process attributes, what a process is
2. Process location, where a process is

## Process location

A process will need sufficient memory to hold the programs and data of that process.

The execution of a program typically involves a stack that is used to keep track of procedure calls and parameter passing between procedures.

Keeping track of the Process Location requires good memory management by the OS.

## Process image

The collection of program, data, stack, and attributes is referred to as the process image.

ElementS of a process image:
- User data - The Modifiable part of the User Space. May include:
    - Program Data
    - User Stack Area
    - Modifiable Programs
- User program - Programs ready to be executed
- Stack - used to store parameters and calling addresses for procedure and system calls
- Process Control Block - contains information about the process used by OS to control the process

Process image location will depend on the memory management scheme being used
- In the simplest case, the process image is maintained as a continuous block of memory.
- This block is maintained in secondary memory (usually disk) but a small portion of it will remain in main memory.

To execute a process, the ENTIRE process image must be loaded onto memory.

# Process Control

## Modes of Execution

User mode | Kernel mode
---|---
User program executes in user mode | Monitor executes in kernel mode
Certain areas of memory are protected from user access | Protected areas of memory may be accessed
Certain instructions may not be executed | Privileged instructions may be executed
Less privileged | More privileged

Why two modes?
- Necessary to protect the OS and other OS tables such as PCB from interference by user program
- In the kernel mode, the software has complete control of the processor and all its instruction, registers and memory.
- This level of control is not necessary and for safety is not desirable for user programs.

How does the processor know which mode it is to be executed?
Using a bit in PSW (program status word) that indicates the mode of execution.

How the mode is change?
Bit changed in response to certain event:
- When a user make a call to an OS service / interrupts trigger execution of an OS routine -> set to System Mode
- Return from the service to user process -> set to User Mode

## What happens during Process Creation?

Once the OS decides to create a new process it:
1. assigns a unique process identifier to the new process
2. allocates space for the process
3. initializes the process control block
4. sets the appropriate linkages
5. creates or expands other data structures

## Process Switching

A process switch may occur any time when the OS has gained control from the currently running process.

Process switch (change) from one state to another state. E.g. A running process is interrupted and the OS assigns other process to the Running state and give control to the process.

issues:
1. What events trigger a process switch?
2. Must recognize the distinction between mode switching and process switching?
3. What must the OS do to the various data structures under its control to achieve process switch?

### What events trigger a process switch?

1. Interrupts

Due to some sort of event that is external to and independent of the currently running process

- Clock interrupt - process has executed for the maximum allowable time slice and is transferred to Ready state.
- I/O interrupt
    - first move the processes that where waiting for this event to the ready (or ready suspend) state
    - then resume the running process or choose a process of higher priority
- Memory fault
    - memory address is in virtual memory so it must be brought into main memory
    - Thus move this process to Blocked state (waiting for I/O to complete)

2. Trap

An error or exception condition generated within the currently running process

OS determines if the condition is fatal
- moved to the Exit state and a process switch occurs
- action will depend on the nature of the error

3. Supervisor Call

OS activated by a supervisor call from the program being executed

Example:
- A user process is running an and an instruction is executed that request an I/O operation.
- This call result in a transfer to a routing that is part of the OS code.
- The user process will move to Blocked state.


### Must recognize the distinction between mode switching and process switching?

Mode switching may happen if the interrupt is not produce a process switch.

The control can just return to the interrupted program.

Then only the processor state information needs to be saved on stack

Less overhead: no need to update the PCB like for process switching

Mode Switching:
- User mode switch to kernel mode when going into Interrupt Handler
- A process will not change it’s state that is currently in Running state.

If no interrupts are pending the processor:
- proceeds to the fetch stage and fetches the next instruction of the current program in the current process

If an interrupt is pending the processor:
- sets the program counter to the starting address of an interrupt handler program
- switches from user mode to kernel mode so that the interrupt processing code may include privileged instructions

### What must the OS do to the various data structures under its control to achieve process switch?

If the currently running process is to be moved to another state (Ready, Blocked, etc.), then the OS must make substantial changes in its environment.

Steps in process switching:
1. save the context of the processor
2. update the process control block of the process currently in the Running state
3. move the process control block of this process to the appropriate queue
4. select another process for execution
5. update the process control block of the process selected
6. update memory management data structures
7. restore the context of the processor to that which existed at the time the selected process was last switched out

# Security Issues

A key security issue in the design of any OS is to prevent, or at least detect, attempts by a user or a malware from gaining unauthorized privileges on the system and from gaining root access.

An OS associates a set of privileges with each process

Typically a process that executes on behalf of a user has the privileges that the OS recognizes for that user

Highest level of privilege is referred to a root access or administrator or supervisor
- It provide access to all the functions and services of the OS.
- Complete control to the system.

## Two System Access Threats

### Intruders

- Often referred to as a hacker or cracker (a Person)
- Objective is to gain access to a system or to increase the range of privileges accessible on a system
- Attempts to acquire information that should have been protected

### Malicious software

- Most sophisticated types of threats to computer systems (a Program)
- Can be relatively harmless or very damaging

## Countermeasures

1. Intrusion Detection
2. Authentication
3. Access Control
4. Firewalls