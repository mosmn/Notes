# SCHEDULING OBJECTIVES

## Processor Scheduling Aims

System objectives: performance

1. Low response time (fast response)
- Response Time: Time elapse from the submission of a request to the beginning of the response.
    - Process needs to run as soon as it enters the system
2. High Throughput:
- Throughput: Number of processes completed per unit time
    - Try getting as much process/jobs done at a time
3. Processor efficiency:
- High processor utilization (min processor idle time)
    - Processor is always doing task

## Scheduling Types

The key to multiprogramming is scheduling. 

Four types of scheduling typically involves:
- long term scheduling
- medium term scheduling
- short term scheduling
- I/O Scheduling

It directly relates to the PROCESS STATES

Long-term scheduling( job scheduler):
- The decision to add to the pool of processes to be executed.
Medium-term scheduling:
- The decision to add to the number of processes that are partially or fully in main memory.
Short-term scheduling (CPU Scheduler):
- The decision as to which available process will be executed by the processor.
- Which READY process will be selected next.
I/O scheduling:
- The decision as to which process’s pending I/O request shall be handled by an available I/O device.

# SCHEDULING FUNCTIONS AND PROCESS STATE TRANSITIONS

## Long-Term Scheduler

![s](/imgs/ups1.png)

- Triggered when a new process is created
- Determines which programs are admitted to the system for processing
- Controls the degree of multiprogramming
    1. the more processes that are created, the smaller the percentage of time that each process can be executed (Average waiting time will be bigger)
    2. may limit to provide satisfactory service to the current set of processes

Creates processes from the queue when it can, but must decide:
- when the operating system can take on one or more additional processes
- which jobs to accept and turn into processes
    - first come, first served
    - priority, expected execution time, I/O

## Medium-Term Scheduler

![s](/imgs/ups2.png)

- Part of the swapping function
- Determine which process will be swapped in and swapped out
- Swapping-in decisions are based on the need to manage the degree of multiprogramming
    - considers the memory requirements of the swapped-out processes

## Short-Term Scheduler

![s](/imgs/ups3.png)

- Short-term scheduling is the actual decision of which ready process to execute next.
    - It determines which process will be executed by the processor
- Executes most frequently
- Invoked when an event occurs that may :
    1. lead to the blocking of the current process or
    2. provide an opportunity to preempt a currently running process in favor of another

Examples:
- Clock interrupts
- I/O interrupts
- Operating system calls
- Signals (e.g., semaphores)

## Nesting of Scheduling Functions

![s](/imgs/ups4.png)

- Scheduling affects the performance of the system because it determines which processes will wait and which will progress.
- Fundamentally, scheduling is a matter of managing queues to:
    1. minimize queuing delay
    2. optimize performance in a queuing environment.

# SCHEDULING POLICIES AND ALGORITHMS

## Alternative Scheduling Policies

![s](/imgs/ups5.png)

### Selection Function

Determines which process, among ready processes, is selected next for execution

May be based on:
1. Priority
2. Resource requirements
3. The execution characteristics of the process
    - if based on execution characteristics then important quantities are:
        - w = time spent in system so far, waiting
        - e = time spent in execution so far
        - s = total service time required by the process, including e; generally, this quantity must be estimated or supplied by the user

### Decision Mode

Specifies the instants in time at which the selection function is exercised

Two categories:
1. Nonpreemptive
    - once a process is in the RUNNING STATE, it will continue to execute until
        1. it terminates or
        2. blocks itself to wait for I/O, or request some OS service

2. Preemptive
    - currently running process may be interrupted and moved to ready state by the OS
    - preemption may occur when:
        1. A new process arrives
        2. An interrupt occurs that places a blocked process in the Ready state
        3. Periodically 

## Scheduling Criteria

Different scheduling algorithms have different properties and may favor one class of processes over another. 

The characteristics used for comparison can make substantial difference in the determination of the best algorithm.

The criteria are:
1. CPU utilization - keep CPU as busy as possible.
2. Throughput - number of processes that complete their execution per time unit.
3. Turnaround time - amount of time to execute a particular process.
4. Waiting time - amount of time a process has been waiting in the ready queue
5. Response time - amount of time it takes from when a request was submitted until the first response is produced, not output (for time-sharing environment)

## Scheduling Policies

We will use these set of processes as a running example

Process | Arrival Time | Service Time
--- | --- | ---
A | 0 | 3
B | 2 | 6
C | 4 | 4
D | 6 | 5
E | 8 | 2

Policies:
1. First Come First Serve (FCFS)
2. Shortest Process Next (SPN)
3. Highest Response Ratio Next (HRRN)
4. Shortest Remaining Time (SRT)
5. Round Robin (RR)
6. Feedback

# Non-Preemptive Policies

# Preemptive Policies