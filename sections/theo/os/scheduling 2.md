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

## First-Come-First-Served (FCFS)

- Simplest scheduling policy.
- Selection Function: Will select the process based on the arrival time.
- Decision mode: Non - Preemptive
- Also known as first-in-first-out (FIFO) or a strict queuing scheme
- When the current process ceases to execute, the longest process in the Ready queue is selected

Process | Arrival Time | Service Time
--- | --- | ---
A | 0 | 3
B | 2 | 6
C | 4 | 4
D | 6 | 5
E | 8 | 2

Waiting time = start execution time – arrival time
- start execution time is the time when the process is selected to be executed, meaning its calculated based on the service time of the previous processes.

```
Process A -> 0 - 0 = 0
Process B -> 3 - 2 = 1
Process C -> 9 - 4 = 5
Process D -> 13 - 6 = 7
Process E -> 18 - 8 = 10
```

```
                        Total waiting time
Average Waiting Time = --------------------
                        Number of processes

= 0+1+5+7+10
  -------------
        5

= 4.6ms
```

Performs much better for long processes than short ones
 
Tends to favor processor-bound processes (mostly uses processor) over I/O-bound processes (mostly uses I/O)
1. When a processor-bound process is running, all of the I/O bound processes must wait.
2. Some of these may be in I/O queues (blocked state) but may move back to the ready queue while the processor-bound process is executing.
3. At this point, most or all of the I/O devices may be idle, even though there is potentially work for them to do.
4. When the currently running process leaves the Running state, the ready I/Obound processes quickly move through the Running state and become blocked on I/O events.
5. If the processor-bound process is also blocked, the processor becomes idle.
6. Thus, FCFS may result in inefficient use of both the processor and the I/O devices.

## Shortest Process Next (SPN)

- Selection Function: Will select the process with the shortest service time.
- Decision mode: Non - Preemptive
- A short process will jump to the head of the queue
- Possibility of starvation for longer processes, as long as there is a steady flow of shorter processes

Process | Arrival Time | Service Time
--- | --- | ---
A | 0 | 3
B | 2 | 6
C | 4 | 4
D | 6 | 5
E | 8 | 2

Waiting time = total of (start execution time – arrival time)
```
Process A -> 0
Process B -> 3 - 2 = 1
Process C -> 11 - 4 = 7
Process D -> 15 - 6 = 9
Process E -> 9 - 8 = 1
```

![s](/imgs/ups6.png)

```                           
                        Total waiting time
Average Waiting Time = --------------------
                        Number of processes
= 1+7+9+1
  -------------
        5

= 3.6ms
```

One difficulty is the need to know, or at least estimate, the required processing time of each process

If the programmer’s estimate is substantially under the actual running time, the system may abort the job

## Highest Response Ratio Next (HRRN)

- Selection Function: Will select the process with the greatest ratio.
```
Ratio = (time spent waiting + expected service time) / expected service time
```

- Decision mode: Non - Preemptive
- Attractive because it counts the age of the process in the system
- While shorter jobs are favored, aging without service increases the ratio so that a longer process will eventually get past competing shorter jobs

Calculate the `time spent waiting`:
- c 9-4 = 5
- d 9-6 = 3
- d 9-8 = 1

Calculate the Ration using the above formula:
- (5+4)/4 = 2.25 ----> therefore C would be selected to run next.
- (3+5)/5 = 1.5
- (1+2)/2 = 1.5 

# Preemptive Policies

## Shortest Remaining Time (SRT)

- Selection Function: Will select the process with the shortest expected service time.
- Decision mode: Preemptive
- Risk of starvation of longer processes
- Should give superior turnaround time performance to SPN because a short job is given immediate preference to a running longer job

Process | Arrival Time | Service Time
--- | --- | ---
A | 0 | 3
B | 2 | 6
C | 4 | 4
D | 6 | 5
E | 8 | 2

![s](/imgs/ups7.png)
see how as soon as proccess C arrived its given immediate control

Waiting time = total of (start execution time – arrival time)
```
Process A -> 0
Process B -> (3 - 2) + (10-4) = 7
Process C -> 4-4 = 0
Process D -> 15-6 = 9
Process E -> 8-8 = 0
```

average wt = 3.2ms

## Round Robin

- A straightforward way to reduce the penalty that short jobs suffer with FCFS is to use pre-emption based on a clock.
- Selection Function: Will select the process as FCFS after each time quantum.
- Decision mode: Preemptive (time quantum basis)
- Also known as time slicing because each process is given a slice of time before being preempted
- Principal design issue is the length of the time quantum, or slice, to be used
- there is processing overhead involved in handling the clock Interrupt and performing the scheduling and dispatching function.
- Particularly effective in a general-purpose time-sharing system or transaction processing system
- One drawback is its relative treatment of processor-bound and I/O-bound processes


### (q=1)

- A clock interrupt is generated at periodic intervals.
- When the interrupt occurs, the currently running process is placed in the ready queue, and the next ready job is selected on a FCFS basis.
- This technique is also known as time slicing , because each process is given a slice of time before being preempted.

Process | Arrival Time | Service Time
--- | --- | ---
A | 0 | 3
B | 2 | 6
C | 4 | 4
D | 6 | 5
E | 8 | 2

![s](/imgs/ups8.png)

Running Ready
A,A,B (interrupts A), A (waits in the queue),
A (interrupts B), B (waits in the queue),
B, C (interrupts B), B (waits in the queue),
B (interrupts C),
D (arrive),
C (waits in the queue),
D (interrupts B), B (waits in the
C (interrupts D), queue), D (waits in the queue),
B (interrupts C), C (waits in the queue),
E (arrive),
E (interrupts B) B (waits in the queue),

Waiting time = total of (start execution time – arrival time)
```
Process A -> 3-2 = 1
Process B -> (4-3) + (6-5) + (9-7) + (13-10)+ (17-14) = 10
Process C -> (5-4) + (8-6) + (12-9) + (16-13)= 9
Process D -> (7-6) + (11-8) + (15-12) + (18-16) = 9
Process E -> (10-8) + (14-11) = 5
```

## Feedback

- Penalize jobs that have been running longer
- A short process will complete quickly without slipping very far down the hierarchy of ready queues
- A longer process will gradually drift down
- Within each queue (not the lowest queue), a simple FCFS mechanism is used.
- For lowest priority queue
    - a process cannot go lower, but it is returned to this queue repeatedly until it completes execution, it will treated in round robin fashion.
- Newer shorter processes are favored over older, longer processes.

Process | Arrival Time | Service Time
--- | --- | ---
A | 0 | 3
B | 2 | 6
C | 4 | 4
D | 6 | 5
E | 8 | 2

![s](/imgs/ups9.png)

# Summary

The operating system must make three types of scheduling decisions with respect to the execution of processes:
1. Long-term – determines when new processes are admitted to the system
2. Medium-term – part of the swapping function and determines when a program is brought into main memory so that it may be executed
3. Short-term – determines which ready process will be executed next by the processor

- From a user’s point of view, response time is generally the most important characteristic of a system
- From a system’s point of view, throughput or processor utilization is important
- Algorithms:
    - FCFS, SPN, HRRN, SRT, Round Robin and Feedback