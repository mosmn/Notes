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
    - Must not be executed while another process is in a corresponding section of code Critical for me to get the fork Okla you eat first Concurrency Key Terms
    - Each process have their own critical section. 

# Hardware, Software and Programming Language Support for Mutual Exclusion