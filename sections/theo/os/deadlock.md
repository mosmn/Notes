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

- Mutual Exclusion: 
    - Cannot be disallowed
    - if access to a resource requires mutual exclusion then it must be supported by the OS

- Hold and Wait:
    - require that a process request all of its required resources at one time and blocking the process until all requests can be granted simultaneously

- No Preemption:
    - If a process holding certain resources is denied a further request, that process must release its original resources and request them again
    - OS may preempt the second process and require it to release its resources

### Direct Prevention

- Circular Wait:
    - define a linear ordering of resource types

#### Havender's Linear Ordering

![Havender's Linear Ordering](/imgs/hlo.png)

- Each resource type is labeled with a value with those resource commonly needed at the beginning of a tasks having lower values than those that typically come at the end of a task.

- A process may request and hold resources in an ascending order only.
    - This means that a process may not request any resource of a lower value (ordering value) so long as any resources of a highervalue are being held.

- For example, while process P1 has possession of R4 it may not requestan R3 or an R2.
    - A Process may not request any resource of a lower value if it still holds the higher one

## Deadlock Avoidance

Sometimes it is not feasible to prevent deadlock. 
    - This can occur when we need the most effective use of all our resources.

Allows the three necessary conditions but makes judicious choices to assure that the deadlock point is never reached.

Avoidance allows more concurrency than prevention

A decision is made dynamically whether the current resource allocation request will, if granted, potentially lead to a deadlock

Requires knowledge of future process requests

Two approaches to deadlock avoidance:
1. Resource Allocation Denial
2. Process initiation Denial

### Resource Allocation Denial

Referred to as the banker’s algorithm

- State of the system reflects the current allocation of resources to processes
    1. Safe state
        - There is at least one sequence of resource allocations to processes that does not result in a deadlock
    2. Unsafe state 
        - is a state that is not safe
        - There is not enough resource to allocate to any process

Bankers algorithm:
- Concept: ensure that the system of processes and resources is always in a safe state
- Mechanism: when a process makes a request for a set of resources
    - Assume that the request is granted(ASSUMPTION NOT ACTUAL, just for the sake of the algorithm)
    - Update the system state accordingly(BASED ON THE ASSUMPTION)
    - Determine if the result is a safe state
        - If so, grant the request;
        - If not, block the process until it is safe to grant the request

#### Determination of a Safe State

![Determining a Safe State](/imgs/dss.png)

Can any of the four processes be run to completion with the resources available?

Steps needed to check either it is a safe state or not:

1. Construct the Need Matrix
    - Need = Claim Matrix – Allocation Matrix
    ![Need Matrix](/imgs/nm.png)
    - it shows how many resources needed by each program in order for the process to complete execution.
2. To check either the current state is safe or not safe,
    - Compare the content of available vector with the need matrix.
        - Is there any process which can be allocated with the available resources and the process can run to completion?
    ![Safe State](/imgs/dss2.png)
    - For this example the system has 1 unit of R2 and 1 unit of R3. Based from the claim matrix P2 can runs to completion.
3. After a process runs to completion, it will release all the resources to system. Construct new available vector.
    - New AV = Current Av + Allocation Matrix of the chosen process

    ![Safe State](/imgs/dss3.png)

Repeat step 2 and 3 until all processes complete execution.

- Determination of a Safe State P1 Executes
![Determining a Safe State](/imgs/dssp1.png)

- Determination of a Safe State P3 Executes
![Determining a Safe State](/imgs/dssp3.png)

- Determination of a Safe State P4 Executes
![Determining a Safe State](/imgs/dssp4.png)

When all processes run to completion, the value for available vector is equal to resource vector
![Determining a Safe State](/imgs/dssf.png)

Thus, the state defined originally is a safe state

#### Determination of a Unsafe State

![Determining a Unsafe State](/imgs/dus.png)

P1 request for additional of 1 unit of R1 and 1 unit of R3. Is it safe to grant what P1 want?

Is this a safe state? 
- The answer is no, because each process will need at least one additional unit of R1, and there are none available. Thus, on the basis of deadlock avoidance, the request by P1 should be denied and P1 should be blocked. The deadlock avoidance strategy does not predict deadlock with certainty; it merely anticipates the possibility of deadlock and assures that there is never such a possibility.

### Deadlock Avoidance Advantages

It is not necessary to pre-empt and rollback processes, as in deadlock detection
- Processes may still hold on to resources while waiting for other resources
It is less restrictive than deadlock prevention
- Processes only have to be block if their continuation might result in a deadlock situation

### 4 Deadlock Avoidance Restrictions

1. Maximum resource requirement for each process must be stated in advance
2. Processes under consideration must be independent and with no synchronization requirements
3. There must be a fixed number of resources to allocate
4. No process may exit while holding resources

## Deadlock Detection

Deadlock prevention strategies are very conservative
- limit access to resources by imposing restrictions on processes
Deadlock detection strategies do the opposite
- resource requests are granted whenever possible

### Deadlock Detection Algorithms

Can be made as frequently as each resource request or, less frequently, depending on how likely it is for a deadlock to occur
- Advantages:
    - it leads to early detection
    - the algorithm is relatively simple
- Disadvantage
    - frequent checks consume considerable processor time

Steps:
1. Mark each process that has a row in the Allocation Matrix of all zeros.
    - This process does not hold any resources
2. Initialize a temporary vector W to equal to Available Vector.
3. Find an index i such that process i is currently unmarked and ith row of Q is less then or equal to W (Q <= W). If no such row found terminate the algorithm.
4. If such a row is found ( ith row exist), mark process i and add the corresponding row of the Allocation Matrix to W. Then return to step 3.

Example:

![Deadlock Detection](/imgs/dd.png)

- Step 1: Mark P4, because P4 has no allocated resources.
- Step 2: Set W = (0 0 0 0 1) which equals to the avalible vector.
- Step 3: The request of process P3 is less than or equal to W, so mark P3 and set W=W + (0 0 0 1 0) = (0 0 0 1 1).
- Step 4: No other unmarked process has a row in Q that is less than or equal to W. Therefore, terminate the algorithm.
P1 and P2 are unmarked, these processes are DEADLOCKED

Deadlock exists if and only if there are unmarked processes at the end of the algorithm (exist a process request that can’t be fulfilled)

Strategy in this algorithm is to find:
- a process whose resource requests can be satisfied with the available resources and then;
- assume that those resources are granted and the process runs to completion and release its resources.

Then the algorithm will look for another process.

This algorithm will not guarantee to prevent deadlock, it will depend on the order in which requested are granted.

It is only to determine either deadlock currently exist or not

# RECOVERY

## Recovery Strategies

1. Abort all deadlocked processes (most common strategy)
2. Back up each deadlocked process to some previously defined checkpoint and restart all processes (rollback/restart)
3. Successively abort deadlocked processes until deadlock no longer exists
4. Successively preempt resources/processes until deadlock no longer exists.

The process in 3 and 4 will be selected according to certain criteria, e.g.
- least amount of CPU time consumed
- lowest priority
- least total resources allocated so far

## Integrated Deadlock Strategy

Combine the previous approaches into the following way:
- Group resources into a number of different resource classes
- Use the linear ordering strategy (prevention of circular wait) to prevent deadlock between resource classes
- Within a resource class, use the algorithm that is most appropriate for that class.

Example of resource classes:
- Swappable space
    - Blocks of memory on secondary storage for use in swapping processes.
    - Deadlock strategy: Prevention as in hold-and-wait
- Process resources
    - Assignable devices, such as tape drives and files
    - Deadlock strategy: Avoidance and Prevention with linear ordering.
- Main memory
    - Assignable to processes in pages and segments
    - Deadlock strategy: Prevention by preemption, when process is preempted it will be swapped out so will freeing the space.
- Internal resources
    - Such as I/O channels
    - Deadlock strategy: prevention with linear ordering
    
# Summary

Deadlock:
- the blocking of a set of processes that either compete for system resources or communicate with each other
- blockage is permanent unless OS takes action
- may involve reusable or consumable resources

Dealing with deadlock:
- prevention – guarantees that deadlock will not occur
- avoidance – analyzes each new resource request
- detection – OS checks for deadlock and takes action