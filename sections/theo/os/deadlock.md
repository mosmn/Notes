# DEADLOCK BACKGROUND

## Deadlock

Definition: The permanent blocking of a set of processes that either compete for system resources or communicate with each other

A set of processes is deadlocked when each process in the set is blocked: awaiting an event that can only be triggered by another blocked process in the set

Since none of the events ever triggered, deadlock is:-
- Permanent
- No efficient solution in the general case (hard reset, kill, OS needs to intervene)

## 2 Resource Categories

Reusable | Consumable
--- | ---
Can be safely used by only one process at a time | Can be created(produced) and destroyed(consumed)
like: processors, I/O channels, main and secondary memory, devices, and data structures such as files, databases, and semaphores | like: interrupts, signals, messages, and information. information inside I/O buffers

### Reusable Resources Deadlock

![Reusable Resources Deadlock](/imgs/rrd.png)

consider two processes that compete for exclusive access to a disk file D and a drive T. The programs engage in the operations depicted above

Deadlock occurs if each process holds one resource and requests the other. For example:
- D is still locked by P
- T is still locked by Q

Deadlock occurs if both processes progress to their second request

### Consumable Resources Deadlock

Consider a pair of processes, in which each process attempts to receive a message from the other process and then send a message to the other process:
- Deadlock occurs if the Receive is blocking, meaning the receiving process is blocked until the message is received. in this case, both processes are receiving so they are both blocked.

## Resource Allocation Graphs

![Resource Allocation Graphs](/imgs/rag.png)

a directed graph that depicts a state of :
- the system of resources and processes,
- with each process and each resourcerepresented by a node

A graph edge directed from a process to a resource indicates a resource that has been requested by the process but not yet granted ( Figure a ).

A graph edge directed from a reusable resource node dot to a process indicates a request that has been granted ( Figure b ); that is, the process has been assigned one unit of that resource

![Resource Allocation Graphs](/imgs/rag2.png)

Figure c shows an example deadlock. There is only one unit each of resources Ra and Rb. Process P1 holds Rb and requests Ra, while P2 holds Ra but requests Rb

Figure d has the same topology as Figure c , but there is no deadlock because multiple units of each resource are available.

# DEADLOCK CONDITION

## 4 Conditions for Deadlock

Mutual Exclusion | Hold and Wait | No Preemption | Circular Wait
--- | --- | --- | ---
only one process may use a resource at a time | a process may hold allocated resources while awaiting assignment of others | no resource can be forcibly removed from a process holding it | a closed chain of processes exists, such that each process holds at least one resource needed by the next process in the chain

Three conditions of policy must be present for a deadlock to be possible: Mutual Exclusion, Hold and Wait, and No Preemption.

The first three conditions are necessary, but not sufficient, for a deadlock to exist. For deadlock to actually take place, a fourth condition is required: Circular wait.The fourth condition is, actually, a potential consequence of the first three. That is, given that the first three conditions exist, a sequence of events may occur that lead to an unresolvable circular wait. The unresolvable circular wait is in fact the definition of deadlock. The circular wait listed as condition 4 is unresolvable because the first three conditions hold. Thus, the four conditions, taken together, constitute necessary and sufficient conditions for deadlock.

# DEALING WITH DEADLOCKS

Three general approaches exist for dealing with deadlock:
- Prevent Deadlock: adopt a policy that eliminates one of the conditions
- Avoid Deadlock: make the appropriate dynamic choices based on the current state of resource allocation
- Detect Deadlock: attempt to detect the presence of deadlock and take action to recover

## Deadlock Prevention

Design a system in such a way that the possibility of deadlock is excluded

Two main methods:
1. Indirect: prevent the occurrence of one of the three necessary conditions
2. Direct: prevent the occurrence of a circular wait (the fourth condition)

### Indirect Prevention

- Mutual Exclusion: Cannot be
disallowed
if access to a
resource requires
mutual exclusion
then it must be
supported by the
OS

## Deadlock Avoidance

## Deadlock Detection

# RECOVERY