Basically we will get to know more about PROCESS

In the computer there are many PROCESS. Each…need RESOURCES to finish!

MUTUAL EXCLUSION is a method to ensure each PROCESS get these RESOURCES

We will get to know how OS provide MUTUAL EXCLUSIVITY to PROCESSES

# DEFINITION AND PRINCIPLES OF CONCURRENCY AND MUTUAL EXCLUSION (ME)

## Concurrency

a property of a system in which several process are executing simultaneously, and potentially interacting with each other (i.e. in using the resources)

- Concurrency control: It is the act of managing and running multiple processes at the same time

- Achieved through interleaving the process operations

Key Terms
---
- **Atomic Operation**: An operation that is indivisible, i.e. it cannot be interrupted by another process
    - A function / action implemented as a sequence of one or more instructions that appears to be indivisible (no other process can see an intermediate state or interrupt the operation). The sequence is guaranteed to execute as a group or not execute at all.
    - Atomicity guarantees isolation from concurrent process
    - They assist in implementing mutual exclusion

- **Critical Section**:
    - A section of code within a process that requires access to shared resources
    - Must not be executed while another process is in a corresponding section of code
    - Each process have their own critical section.

- **Deadlock**:
    - Situation in which two or more process are unable to proceed because each is waiting for one of the others to do something, thus neither ever does

- **Live lock**:
    -  Situation in which two or more process continuously changes their states in response to changes in the other without doing anything useful

- **Mutual Exclusion**:
    - refers to the requirement of ensuring that no two concurrent processes are in their critical section at the same time.
    - It is a requirement that prevents simultaneous access to a shared resource used in concurrency control and to prevent race conditions.

- **Race Condition**:
    - A situation in which multiple threads or processes read and write a shared data item and the final result depends on the relative timing of their execution.
    - It becomes a bug when events do not happen in the order the programmer intended.
    - The term originates with the idea of two signals racing each other to influence the output first.

- **Starvation**:
    - A situation in which a runnable program Is overlooked indefinitely by the scheduler; although it is able to proceed, it is never chosen.

## Basic characteristic of a multiprogramming System

The relative speed of execution of processes depends on :
1. activities of other processes
2. the way the OS handles interrupts
3. scheduling policies of the OS

## Difficulties in multiprogramming systems

1. Sharing of global resources - e.g. Location in memory that is used for input and output buffer
2. OS need to optimally managing the allocation of resources - no deadlock and no starvation
3. Locating programming errors (results are not deterministic and reproducible)

## Design and management issues raised by the existence of concurrency

The OS must:
1. Be able to keep track of various processes
2. Allocate and de-allocate resources for each active process
3. Protect the data and physical resources of each process against interference by other processes
4. Ensure that the processes and outputs are independent of the processing speed but relative to the speed of other concurrent processes

## Reasons for conflict

Concurrent processes come into conflict when they are competing for use of the same resource. for example: I/O devices, memory, processor time, clock.

As a result of competing process, THREE CONTROL PROBLEMS must be managed:
1. Need for mutual exclusion
2. Deadlock
3. Starvation

## PROCESS INTERACTION CATEGORIES

### 1. UNAWARE OF EACH OTHER

These are independent processes that are not intended to work together.
Each doing its own thing
Each requiring resource

OS needs to be concerned about competition for resources

Relationship with other process: Resource Competition

Example: Different program just competing for resource

### 2. INDIRECTLY AWARE OF EACH OTHER

These processes are not necessarily aware of each other by their respective process IDs but they share access to some object, such as an I/O buffer.

Relationship with other process: Cooperation by sharing resources

Example: Sharing resources such as i/o buffer

### 3. DIRECTLY AWARE OF EACH OTHER

These processes that are able to communicate with each other by process ID and are designed to work jointly on some activity.

Such processes exhibit cooperation

Relationship with other process: Cooperation by communication

Example: Designed from the start to work together

## Mutual Exclusion

A requirement of ensuring that no two concurrent processes are in their critical section at the same time.

It is a requirement that prevents simultaneous access to a shared resource used in concurrency control and to prevent race conditions.

### Requirements for Mutual Exclusion

1. Must be enforced
2. A halted process must NOT interfere with other processes
3. Each process will get its turn eventually (no deadlock / starvation)
4. A process must be given access to a critical section when there is no other process using it
5. No assumptions are made about relative process speeds or number of processes
6. A process remains inside its critical section for a finite time only (limited time)

# Hardware, Software and Programming Language Support for Mutual Exclusion

## Satisfying the requirements of ME

3 Approaches:
- Software approach - Process coordinate with one another
- Hardware approach - Using special machine instruction. Reducing overheads of the s/w approach.
- Programming Language Support - Programs explicitly support and specify critical section

## Software Solutions

- Leave the responsibility to the process that wish to execute concurrently.
- Whether they are system programs or application programs, would be required to coordinate with one another to enforce mutual exclusion.
- No support from programming language or operating system.
- Prone to high processing overhead and bugs
- E.g: Dekker’s Algorithm and Peterson Algorithm

## Hardware Support

1. Interrupt Disabling

In uniprocessor systems, disabling interrupts guarantees mutual exclusion.

Disadvantages:
- efficiency of execution could be noticeably reduced/degraded
- this approach is not suitable for multiprocessor systems

2. Special Machine Instructions

Several machine instruction that carry out two actions atomically. such as reading and writing or reading and testing.

Automatically meaning the instructions are performed in single step that cannot be interrupted.

Preformed in a single instruction cycle.

Not subject to interference from other processes.

Advantages | Disadvantages
--- | ---
Applicable to any number of processes on either a single or multiple processor sharing main memory | Busy-waiting is employed, thus while a process is waiting for access to a critical section it continues to consume processor time
Simple and easy to verify | Starvation is possible when a process leaves a critical section and more than one process is waiting
It can be used to support multiple critical sections. Each critical section can be verify by it owns variable. | Deadlock is possible

## Software Support for ME: Semaphore

An integer value used for signaling among processes. Only three operations may be performed on a semaphore, all of which are atomic: initialize, decrement, and increment. The decrement operation may result in the blocking of a process, and the increment operation may result in the unblocking of a process. Also known as a counting semaphore or a general semaphore.

Fundamental Principle:
Two or more processes can cooperate by means of simple
signals,
- such that a process can be forced to stop at a specified place (instruction) until it has received a specific signal (e.g: availability of certain resources or a state change).
- Semaphores are special variables used for signaling among processes.

Any complex coordination requirement can be satisfied by the appropriate structure of signals.

- To transmit a signal via semaphore s , a process executes the primitive semSignal(s) . 
- To receive a signal via semaphore s , a process executes the primitive semWait(s) ;
- If the corresponding signal has not yet been transmitted, the process is suspended until the transmission takes place.

There is no way to inspect or manipulate semaphores other than these three operations:

A variable that has an integer value upon which only three operations are defined:
1) May be initialized to a nonnegative integer value (0 and above)
2) The semWait operation decrements the value
- If the value becomes negative, process executing SemWait is blocked
- Else continue
3) The semSignal operation increments the value
- If the value becomes <= 0, then a process which was blocked by semWait, if any is unblocked

We explain these operations as follows. 

To begin, the semaphore has a zero or positive value. If the value is positive, that value equals the number of processes that can issue a wait and immediately continue to execute. If the value is zero, either by initialization or because a number of processes equal to the initial semaphore value have issued a wait, the next process to issue a wait is blocked, and the semaphore value goes negative. Each subsequent wait drives the semaphore value further into minus territory. The negative value equals the number of processes waiting to be unblocked. Each signal unblocks one of the waiting processes when the semaphore value is negative.