# Pthreads


## What is a Thread?

- Thread: an independent flow of control
    - software entity that executes a sequence of instructions
- Thread requires
    - program counter
    - a set of registers
    - an area in memory, including a call stack
    - a thread id
- A process consists of one or more threads that share
    - address space
    - attributes including user id, open files, working directory, ...


## Definitions

- What is a Thread?
    - **A thread is a single sequence stream within in a process** processes,they are sometimes calledlightweight processes.. Because threads have some of the properties of
- What are the differences between process and thread?
    - Threads are not independent of one other like processes as a result threads shares with other threads their code section, data section and OS resources like open files and signals. But, like process, a thread has its own
       program counter (PC), a register set, and a stack space.
- Why Multithreading?
    - Threads are popular way to improve application through parallelism. For example, in a browser, multiple tabs can be different threads. MS word uses multiple threads, one thread to format the text, other thread to
       process inputs, etc.
- Threads operate faster than processes due to following reasons:
    - 1) Thread creation is much faster.
    - 2) Context switching between threads is much faster.
    - 3) Threads can be terminated easily
    - 4) Communication between threads is faster.


## Why Threads?

- Well matched to multicore hardware
- Software Portability
    - Threaded applications can be developed on serial machines and run on parallel machines without any changes.
    - This ability to migrate programs between diverse architectural platforms is a very significant advantage of threaded APIs.
- Latency Hiding
    - e.g. latency due to memory, communication, I/O
    - By allowing multiple threads to execute on the same processor, threaded APIs enable this latency to be hidden
    - In effect, while one thread is waiting for a communication operation, other threads can utilize the CPU, thus masking associated overhead.
- Useful for scheduling and load balancing
    - Threaded APIs allow the programmer to specify a large number of concurrent tasks and support systemdynamic mapping of tasks to processors with a view to minimizing idling overheads. -level
- Relatively easy to program
    - easier than message-passing? you be the judge!


## Threads and Memory

- All memory is globallyaccessible to every thread
- Each thread’s stack istreated as local to thethread

- Additional local storage can be allocated on a per-thread basis

- Idealization: treat all memory as equidistant


## Targets for Threaded Programs

### Shared-memory parallel systems

- Multicore processor
- Workstations or cluster nodes with multiple processors
- Xeon Phi accelerator
    - ~250 threads
- SGI UV: scalable shared memory system
    - up to 4096 threads


## Shared Memory

- The term shared memory means that the processors all share a common address space.
- Suppose processor P3 issues the instruction
    MOV 200, EAX
which reads memory location 200 and places the result in the EAX register in the CPU.
- If processor P4 does the same, they both will be referring to the same physical memory
    cell.
       - However, that each CPU has a separate register set, so each will have its own independent EAX.
- In nonshared-memory machines, each processor has its own private memory, and each
    one will then have its own location 200, completely independent of the locations 200 at
    the other processors' memories.
- E.g. SMP , NUMA


## Threaded Programming Models

- Library-based models
    - all data is shared, unless otherwise specified
    - examples: Pthreads, Intel Threading Building Blocks, Java Concurrency, Boost,
       Microsoft .Net Task Parallel Library
- Directive-based models, e.g., OpenMP
    - shared and private data
    - pragma syntax simplifies thread creation and synchronization
- Programming languages
    - CilkPlus (Intel, GCC)
    - CUDA (NVIDIA)
    - Habanero-Java (Rice)


## Pthreads

## Introduction

- In shared memory multiprocessor architectures, threads can be used to implement parallelism.

- Historically, hardware vendors have implemented their own proprietary versions of threads, making portability a concern fo software developers.

- For UNIX systems, a standardized C language threads programming interface has been specified by the IEEE POSIX 1003.1c standard.

- Implementations that adhere to this standard are referred to as POSIX threads, or Pthreads.


## Threads Within A Unix Process

- Threads use and exist within these process resources, yet are able to be scheduled by the operating system and run as independent entities largely because they duplicate only the bare essential resources that enable them to exist as executable
    code. This independent flow of control is accomplished because a thread maintains its own:
       - Stack pointer
       - Registers
       - Scheduling properties (such as policy or priority)
       - Set of pending and blocked signals
       - Thread specific data.
- So, in summary, in the UNIX environment a thread:
    - • Exists within a process and uses the process resourcesHas its own independent flow of control as long as its parent process exists and the OS supports it
    - Duplicates only the essential resources it needs to be independently schedulable
    - May share the process resources with other threads that act equally independently (and dependently)
    - Dies if the parent process dies -or something similar
    - Is "lightweight" because most of the overhead has already been accomplished through the creation of its process.
- Because threads within the same process share resources:
    - Changes made by one thread to shared system resources (such as closing a file) will be seen by all other threads.
    - Two pointers having the same value point to the same data.
    - Reading and writing to the same memory locations is possible, and therefore requires explicit synchronization by the programmer.


## Why Pthreads?

- Light Weight
    - When compared to the cost of creating and managing a process, a thread can
       be created with much less operating system overhead. Managing threads
       requires fewer system resources than managing processes.

- Efficient Communications/Data Exchange
    - The primary motivation for considering the use of Pthreads in a high performance
       computing environment is to achieve optimum performance. In particular, if an
       application is using MPI for on-node communications, there is a potential that
       performance could be improved by using Pthreads instead.
    - MPI libraries usually implement on-node task communication via shared memory,
       which involves at least one memory copy operation (process to process).
    - For Pthreads there is no intermediate memory copy required because threads share
       the same address space within a single process. There is no data transfer, per se. It
       can be as efficient as simply passing a pointer.
    - In the worst case scenario, Pthreadcommunications become more of a cache-to-CPU
       or memory-to-CPU bandwidth issue. These speeds are much higher than MPI shared
       memory communications.

# Designing Threaded Programs


## Parallel Programming

- On modern, multi-core machines, Pthreadsare ideally suited for parallel
    programming, and whatever applies to parallel programming in general, applies
    to parallel Pthreadsprograms.
- There are many considerations for designing parallel programs, such as:
    - What type of parallel programming model to use?
    - Problem partitioning
    - Load balancing
    - Communications
    - Data dependencies
    - Synchronization and race conditions
    - Memory issues
    - I/O issues
    - Program complexity
    - Programmer effort/costs/time


## Threaded programs models

- **Manager/worker**
    - a single thread, the manager assigns work to other threads, the workers.
       Typically, the manager handles all input and parcels out work to the other
       tasks. At least two forms of the manager/worker model are common: static
       worker pool and dynamic worker pool.
- **Pipeline**
    - a task is broken into a series of suboperations, each of which is handled in
       series, but concurrently, by a different thread. An automobile assembly line
       best describes this model.
- **Peer**
    - similar to the manager/worker model, but after the main thread creates other
       threads, it participates in the work.


## Shared Memory Model

- All threads have access to the same global, shared memory

- Threads also have their own private data

- Programmers are responsible for synchronizing access (protecting) globally shared data.


## Thread-safeness

- Thread-safeness: in a nutshell, refers an application's ability to execute multiple threads simultaneously without "clobbering" shared data or creating "race" conditions.

- For example, suppose that your application creates several threads, each of which makes a call to the same library routine:

- This library routine accesses/modifies a global structure or location in memory.

- As each thread calls this **routine** it is possible that they may try to modify this global structure/memory location at the same time.

- If the routine does not employ some sort of synchronization constructs to prevent data corruption, then it is not thread-safe.


## Thread Limits

- Although the Pthreads API is an ANSI/IEEE standard, implementations can, and usually do, vary in ways not specified by the standard.

- Because of this, a program that runs fine on one platform, may fail or produce wrong results on another platform.

- For example, the maximum number of threads permitted, and the default thread stack size are two important limits to consider when designing your program.


## Thread Limits

- The implication to users of external library routines is that if you aren't 100% certain the routine is thread- safe, then you take your chances with problems that could arise.

- Recommendation: Be careful if your application uses libraries or other objects that don't explicitly guarantee thread-safeness. When in doubt, assume that they are not thread-safe until proven otherwise. This can be done by "serializing" the calls to the uncertain routine, etc.


## Mutual Exclusion (Mutex)

- A mutual exclusion (mutex) is a program object that **prevents** simultaneous access to a shared resource. This concept is used in concurrent programming with a critical section, a piece of code in which processes or threads access a shared resource. Only one thread owns the mutex at a time, thus a mutex with a unique name is created when a program starts. When a thread holds a resource, it has to lock the mutex from other threads to prevent concurrent access of the resource. Upon releasing the resource, the thread unlocks the mutex.

- Mutex comes into the picture when two threads work on the same data at the same time. It acts as a lock and is the most basic synchronization tool. When a thread tries to acquire a mutex, it gains the mutex if it is available, otherwise the thread is set to **sleep condition**. Mutual exclusion reduces latency and busy-waits using queuing and context switches. Mutex can be enforced at both the hardware and software levels.


## Deadlock

- Inconcurrent computing, adeadlockis a state in which **each member of a group**
    **waits for another member** , including itself, to take action, such as sending a
    message or more commonly releasing alock.[1]Deadlocks are a common problem
    in multiprocessingsystems, parallel computing, anddistributed systems, where
    software and hardware locks are used to arbitrate shared resources and
    implement process synchronization.
- In an operating system, a deadlock occurs when aprocessor threadenters a
    waiting statebecause a requestedsystem resource is held by another waiting
    process, which in turn is waiting for another resource held by another waiting
    process. If a process is unable to change its state indefinitely because the
    resources requested by it are being used by another waiting process, then the
    system is said to be in a deadlock.
- In a communications system, deadlocks occur mainly due to lost or corrupt
    signals rather than resource contention.


## The Pthreads API

- The subroutines which comprise the PthreadsAPI can be informally

#### grouped into four major groups:

- **Thread management** : Routines that work directly on threads -creating, detaching,
    joining, etc. They also include functions to set/query thread attributes (joinable,
    scheduling etc.)
- **Mutexes** : Routines that deal with synchronization, called a "mutex", which is an
    abbreviation for "mutual exclusion". Mutex functions provide for creating,
    destroying, locking and unlocking mutexes. These are supplemented by mutex
    attribute functions that set or modify attributes associated with mutexes.
- **Condition variables** : Routines that address communications between threads that
    share a mutex. Based upon programmer specified conditions. This group includes
    functions to create, destroy, wait and signal based upon specified variable values.
    Functions to set/query condition variable attributes are also included.
- **Synchronization** : Routines that manage read/write locks and barriers.


## Examples of Library Routines

- Naming conventions: All identifiers in the threads library begin with
- The PthreadsAPI contains around 100 subroutines

| Routine Prefix         | Functional Group                   |
|------------------------|-----------------------------------|
| pthread_               | Threads themselves and miscellaneous subroutines |
| pthread_attr_          | Thread attributes objects          |
| pthread_mutex_         | Mutexes                           |
| pthread_mutexattr_     | Mutex attributes objects           |
| pthread_cond_          | Condition variables                |
| pthread_condattr_      | Condition attributes objects       |
| pthread_key_           | Thread-specific data keys          |
| pthread_rwlock_        | Read/write locks                   |
| pthread_barrier_       | Synchronization barriers           |



## Creating and Terminating Threads

- Routines:
    - pthread_create(thread,attr,start_routine,arg)
    - pthread_exit(status)
    - pthread_cancel (thread)
    - pthread_attr_init (attr)
    - pthread_attr_destroy(attr)


## Creating Threads

- Initially, your main() program comprises a single, default thread. All other threads
    must be explicitly created by the programmer.
- **pthread_create** creates a new thread and makes it executable. This routine can
    be called any number of times from anywhere within your code.
- pthread_createarguments:
    - thread: An opaque, unique identifier for the new thread returned by the subroutine.
    - attr: An opaque attribute object that may be used to set thread attributes. You can specify a
       thread attributes object, or NULL for the default values.
    - start_routine: the C routine that the thread will execute once it is created.
    - arg: A single argument that may be passed to start_routine. It must be passed by reference as
       a pointer cast of type void. NULL may be used if no argument is to be passed.
- The maximum number of threads that may be created by a process is
    implementation dependent. Programs that attempt to exceed the limit can fail or
    produce wrong results.


## Creating Threads:

- Once created, threads are peers, and may create other threads. There is no
    implied hierarchy or dependency between threads.


## Thread Attributes

- By default, a thread is created with certain attributes. Some of these attributes can be
    changed by the programmer via the thread attribute object.
- **pthread_attr_init** and **pthread_attr_destroy** are used to initialize/destroy the thread
    attribute object.
- Other routines are then used to query/set specific attributes in the thread attribute
    object. Attributes include:
       - Detached or joinable state
       - Scheduling inheritance
       - Scheduling policy
       - Scheduling parameters
       - Scheduling contention scope
       - Stack size
       - Stack address
       - Stack guard (overflow) size


## Thread Binding and Scheduling

- Question: After a thread has been created, how do you know a)when it will be scheduled
    to run by the operating system, and b)which processor/core it will run on?
- The PthreadsAPI provides several routines that may be used to specify how threads are
    scheduled for execution. For example, threads can be scheduled to run FIFO (first-in first-
    out), RR (round-robin) or OTHER (operating system determines). It also provides the
    ability to set a thread's scheduling priority value.
- These topics are not covered here, however a good overview of "how things work" under
    Linux can be found in the sched_setschedulerman page.
- The PthreadsAPI does not provide routines for binding threads to specific CPUs/cores.
    However, local implementations may include this functionality -such as providing the
    non-standard pthread_setaffinity_nproutine. Note that "_np" in the name stands for
    "non-portable".
- Also, the local operating system may provide a way to do this. For example, Linux
    provides the sched_setaffinityroutine.


## Terminating Threads & pthread_exit():

- There are several ways in which a thread may be terminated:
    - The thread returns normally from its starting routine. Its work is done.
    - The thread makes a call to the pthread_exitsubroutine -whether its work is done or not.
    - The thread is canceled by another thread via the pthread_cancelroutine.
    - The entire process is terminated due to making a call to either the exec() or exit()
    - If main() finishes first, without calling pthread_exitexplicitly itself
- **pthread_exit()** routine allows the programmer to specify an optional termination status parameter. This optional parameter is typically returned to threads "joining" the terminated thread. 
- Cleanup: the after the thread is terminated.pthread_exit() routine does not close files; any files opened inside the thread will remain open
- Discussion on calling pthread_exit() from main():
    - There is a definite problem if main() finishes before the threads it spawned if you don't call the threads it created will terminate because main() is done and no longer exists to support the threads.pthread_exit() explicitly. All of
- By having main() explicitly call support the threads it created until they are done.pthread_exit() as the last thing it does, main() will block and be kept alive to support the threads it created until they are done.

## Sample Pthread program

```c
#include <pthread.h>
#include <stdio.h>

#define NUM_THREADS 5

void *PrintHello(void *threadid) {
    long tid = (long) threadid;
    printf("Hello World! It's me, thread #%ld!\n", tid);
    pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
    int rc;
    long t;
    pthread_t threads[NUM_THREADS];// declare 5 threads
    
    for (t = 0; t < NUM_THREADS; t++) {
        printf("In main: creating thread %ld\n", t);
        rc = pthread_create(&threads[t], NULL, PrintHello, (void *) t); // create 5 threads
        if (rc) {
            printf("ERROR; return code from pthread_create() is %d\n", rc);
        }
    }
    
    pthread_exit(NULL); // main thread exit
}
```

## Sample Pthread program: Explanation

- `int main(int argc, char *argv[])` is the main function that can process command line arguments passed as `argc` and `argv`.

## Thread management

### Passing Arguments to Threads

- The `pthread_create()` routine allows passing one argument to the thread start routine. For passing multiple arguments, use a structure to hold them and pass a pointer to the structure in `pthread_create()`.

- All arguments must be passed by reference and cast to `(void *)`.

### Example 1 - Thread Argument Passing

```c
long taskids[NUM_THREADS];
for (t = 0; t < NUM_THREADS; t++) {
    taskids[t] = t;
    printf("Creating thread %ld\n", t);
    rc = pthread_create(&threads[t], NULL, PrintHello, (void *) taskids[t]);
    // ...
}
```

This code fragment demonstrates how to pass a simple integer to each thread.

The calling thread uses a unique data structure for each thread, insuring that each thread's argument remains intact throughout the program.

### Example 2 - Thread Argument Passing

```c
#include <stdio.h>
#include <pthread.h>

// Define the structure to hold thread data
struct thread_data {
    int thread_id;
    int sum;
    char *message;
};

#define NUM_THREADS 5

// Array to store thread data for each thread
struct thread_data thread_data_array[NUM_THREADS];

// Thread function
void *PrintHello(void *threadarg) {
    // Cast the argument back to a thread_data structure
    struct thread_data *my_data = (struct thread_data *)threadarg;
    
    // Extract data from the structure
    int taskid = my_data->thread_id;
    int sum = my_data->sum;
    char *hello_msg = my_data->message;
    
    // Perform thread-specific tasks
    // ...

    pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
    int rc;
    pthread_t threads[NUM_THREADS];

    // Populate thread_data_array with data for each thread
    for (int t = 0; t < NUM_THREADS; t++) {
        thread_data_array[t].thread_id = t;
        // Assign values to other fields in thread_data_array
        // e.g., thread_data_array[t].sum = ...;
        //      thread_data_array[t].message = ...;

        // Create a new thread and pass the corresponding thread_data structure as an argument
        rc = pthread_create(&threads[t], NULL, PrintHello, (void *)&thread_data_array[t]);
        if (rc) {
            printf("ERROR; return code from pthread_create() is %d\n", rc);
        }
    }

    // Optionally, you can wait for the threads to finish using pthread_join

    pthread_exit(NULL);
}
```

- The structure `thread_data` is defined to hold data that will be passed to each thread.
- An array `thread_data_array` is declared to store the data for each thread.
- The `PrintHello` function is the thread entry point and extracts the data from the `thread_data` structure passed as an argument.
- In the `main` function, the `thread_data_array` is populated with data specific to each thread.
- Threads are created using `pthread_create`, and each thread receives its corresponding `thread_data` structure as an argument.

This example shows how to setup/pass multiple arguments via a structure. Each thread receives a unique instance of the structure.

### Example 3 - Thread Argument Passing (Incorrect)

In this example, the thread argument is passed incorrectly, using the address of a shared variable `t`.
This example performs argument passing incorrectly.
• It passes the address of variable t, which is shared memory space and visible to all threads.
• As the loop iterates, the value of this memory location changes, possibly before the created threads can access
it.
• The result is that all threads may end up using the same value for their argument.

```c
int rc;
long t;
for(t=0; t<NUM_THREADS; t++)
{
printf("Creating thread %ld\n", t);
rc = pthread_create(&threads[t], NULL, PrintHello, (void *) &t);
...
}
```

## Joining and Detaching Threads

- Functions for joining and detaching threads include:
  - `pthread_join(threadid, status)`
  - `pthread_detach(threadid)`
  - `pthread_attr_setdetachstate(attr, detachstate)`
  - `pthread_attr_getdetachstate(attr, detachstate)`

### Joining:

- `pthread_join()` blocks the calling thread until the specified thread terminates.
- A joining thread can match only one `pthread_join()` call.

### How to JOIN

- When a thread is created, its attribute defines whether it's joinable or detached.
- Threads created as joinable can be joined, but detached threads can never be joined.

### Detaching

- `pthread_detach()` can be used to explicitly detach a thread even if it was created as joinable.

# Mutex

## What?

- Mutex stands for "mutual exclusion" and is used for thread synchronization and protecting shared data.
- Only one thread can own a mutex at a time, ensuring that protected data is accessed one at a time.

## How?

- Typical sequence for using a mutex:
    - Create and initialize a mutex variable.
    - Threads attempt to lock the mutex.
    - Only one thread succeeds and owns the mutex.
    - The owner performs actions.
    - The owner unlocks the mutex.
    - Another thread acquires the mutex and repeats the process.
    - Finally, the mutex is destroyed.

## Creating and Destroying Mutexes

- Functions for creating and destroying mutexes:
  - `pthread_mutex_init(mutex, attr)`
  - `pthread_mutex_destroy(mutex)`
  - `pthread_mutexattr_init(attr)`
  - `pthread_mutexattr_destroy(attr)`

- Mutex variables must be declared with type `pthread_mutex_t` and must be initialized before use.

## Condition Variables

- Condition variables provide a way for threads to synchronize based on the value of data.
- They allow threads to wait for a specific condition without polling.
- Condition variables are used in conjunction with a mutex lock.


