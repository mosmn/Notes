Objectives

- To explain the concept of OpenMP in parallel computing
- To apply the OpenMP API in the program
- To explain the usage of OpenMP directives


# What is OpenMP?

- OpenMP (Open Multi-Processing) is an application programming interface (API) that
    provides a simple and flexible way to parallelize code across multiple processors in a
    shared memory system. It is a popular standard for writing parallel programs that can
    take advantage of multi-core processors and shared memory
- OpenMP enables programmers to write code that can automatically distribute tasks
    across multiple processors, without requiring complex and error-prone manual
    parallelization. It provides a set of **compiler directives, library routines, and environment
    variables** that allow developers to specify which parts of their code should be parallelized
    and how the work should be distributed among the processors in a parallel system.

- OpenMP is designed to work with a wide range of programming languages, including C,
    C++, and Fortran, and is supported by most major compilers and operating systems. It is
    widely used in scientific computing, high-performance computing, and other areas
    where parallel processing is important.
- Some common use cases for OpenMP include speeding up simulations and modeling,
    processing large datasets, and improving the performance of numerical algorithms. By
    allowing programmers to take advantage of the full power of multi-core processors,
    OpenMP can help to significantly reduce the time and resources required to complete
    complex computational tasks.

- The core elements of OpenMP are the constructs for thread creation, workload distribution (work sharing), data-environment management, thread synchronization, user-level runtime routines and environment variables.

- In C/C++, OpenMP uses #pragmas. The OpenMP specific pragmas are listed below.
- Thread creation

- The pragma omp parallel is used to fork additional threads to carry out the work enclosed in the construct in parallel. The original thread will be denoted as master thread with thread ID 0.

- Example (C program): Display "Hello, world." using multiple threads.

### OpenMP Targets Ease of Use

- OpenMP does not require that single-threaded code be changed for
threading
- enables incremental parallelization of a serial program
- OpenMP only adds compiler directives
- pragmas (C/C++); significant comments in Fortran
- if a compiler does not recognize a directive, it ignores it
- simple & limited set of directives for shared memory programs
- significant parallelism possible using just 3 or 4 directives
- both coarse-grain and fine-grain parallelism
- If OpenMP is disabled when compiling a program, the program will
execute sequentially

## OpenMP: Fork-Join Parallelism

- OpenMP program begins execution as a single master thread
- Master thread executes sequentially until 1st parallel region
- When a parallel region is encountered, master thread
    - creates a group of threads
    - becomes the master of this group of threads
    - is assigned the thread id 0 within the group

```
6
```




Work-sharing construct

- Used to specify how to assign independent work to one or all of the threads.
_- omp for_ or _omp do_ : used to split up loop iterations among the threads, also called loop
    constructs.
_- sections_ : assigning consecutive but independent code blocks to different threads
_- single_ : specifying a code block that is executed by only one thread, a barrier is implied in
    the end
_- master_ : similar to single, but the code block will be executed by the master thread only
    and no barrier implied in the end.

2021 Parallel Computing | UNITEN^10



Clauses

- Since OpenMP is a shared memory programming model, most variables in OpenMP code are visible
    to all threads by default. But sometimes private variables are necessary to avoid race conditions
    and there is a need to pass values between the sequential part and the parallel region (the code
    block executed in parallel), so data environment management is introduced as data sharing
    attribute clauses by appending them to the OpenMP directive. The different types of clauses are:
**Data sharing attribute clauses**
- **shared** : the data declared outside a parallel region is shared, which means visible and accessible by
all threads simultaneously. By default, all variables in the work sharing region are shared except the
loop iteration counter.
- **private** : the data declared within a parallel region is private to each thread, which means each
thread will have a local copy and use it as a temporary variable. A private variable is not initialized
and the value is not maintained for use outside the parallel region. By default, the loop iteration
counters in the OpenMP loop constructs are private.

2021 Parallel Computing | UNITEN^12


- default: allows the programmer to state that the default data scoping within a
    parallel region will be either shared, or none for C/C++, or shared, firstprivate,
    private, or none for Fortran. The none option forces the programmer to declare
    each variable in the parallel region using the data sharing attribute clauses.
- firstprivate: like private except but initialized using the value of the variable using
    the same name from the master thread.
- lastprivate: like private except original value is updated after construct.
- reduction: a safe way of joining work from all threads after construct.

2021 Parallel Computing | UNITEN^13


Synchronization clauses

- **critical** : the enclosed code block will be executed by only one thread at a time, and not
    simultaneously executed by multiple threads. It is often used to protect shared data from
    race conditions.
- **atomic** : the memory update (write, or read-modify-write) in the next instruction will be
performed atomically. It does not make the entire statement atomic; only the memory
update is atomic. A compiler might use special hardware instructions for better
performance than when using critical.
- **ordered** : the structured block is executed in the order in which iterations would be
executed in a sequential loop
- **barrier** : each thread waits until all of the other threads of a team have reached this point.
A work-sharing construct has an implicit barrier synchronization at the end.
- **nowait** : specifies that threads completing assigned work can proceed without waiting for
all threads in the team to finish. In the absence of this clause, threads encounter a barrier
synchronization at the end of the work sharing construct.

2021 Parallel Computing | UNITEN^14


_- schedule (type, chunk)_ :
    - This is useful if the work sharing construct is a do-loop or for-loop. The iterations in
       the work sharing construct are assigned to threads according to the scheduling
       method defined by this clause.
_- static_ : Here, all the threads are allocated iterations before they execute the loop
    iterations. The iterations are divided among threads equally by default.
_- dynamic_ : Here, some of the iterations are allocated to a smaller number of threads. Once
    a particular thread finishes its allocated iteration, it returns to get another one from the
    iterations that are left.

2021 Parallel Computing | UNITEN^15


IF control

- if: This will cause the threads to parallelize the task only if a condition
    is met. Otherwise the code block executes serially.

Reduction

- reduction (operator | intrinsic : list): the variable has a local copy in
    each thread, but the values of the local copies will be summarized
    (reduced) into a global shared variable.

2021 Parallel Computing | UNITEN^16


A Simple Example Using parallel

```
17
```

OMP General Construct

#include <omp.h>
main () {
int var1, var2, var3;

_Serial code
.
Beginning of parallel region. Fork a team of threads.
Specify variable scoping_

#pragma omp parallel private(var1, var2) shared(var3)
{
Parallel region executed by all threads
.
Other OpenMP directives
.
Run-time Library calls
.
All threads join master thread and disband
}

_Resume serial code_
}
https://curc.readthedocs.io/en/latest/programming/OpenMP-C.html

```
18
```

```
19
```
Simple "Hello World"
program.

Every thread executes
all code enclosed in the
parallel region

OpenMP library
routines are used to
obtain thread identifiers
and total number of
threads


## Possible Output

- 2021 Parallel Computing | UNITEN
- 2021 Parallel Computing | UNITEN
- 2021 Parallel Computing | UNITEN
- 2021 Parallel Computing | UNITEN
-
- Hello World from thread =
- Hello World from thread =
- Hello World from thread =
- Number of threads =
- Hello World from thread =
- Hello World from thread =
- Hello World from thread =
- Hello World from thread =
- Hello World from thread =
- OMP_NUM_THREADS Assume :


Number of Threads

- To determine the number of threads that are requested, the following rules will be
    considered in order. The first rule whose condition is met will be applied:
       1. Evaluation of the **IF** clause
       2. If the num_threads clause is present, then the value of the integer expression is
          the number of threads requested.
       3. If the omp_set_num_threads library function has been called, then the value of
          the argument in the most recently executed call is the number of threads
          requested.
       4. If the environment variable OMP_NUM_THREADS is defined, then the value of this
          environment variable is the number of threads requested.
       5. If none of the methods above were used, then the number of threads requested is
          implementation-defined

```
21
```

Restrictions

- A parallel region must be a structured block that does not span
    multiple routines or code files
- It is illegal to branch (goto) into or out of a parallel region
- Only a single IF clause is permitted
- Only a single NUM_THREADS clause is permitted
- A program must not depend upon the ordering of the clauses

```
22
```

```
23
```
The
SINGLE
directive
specifies
that the
enclosed
code is to
be
executed
by only
one thread
in the
team.


```
24
```
**C/C++**

#include <omp.h>
#define CHUNKSIZE 100
#define N 1000
main()
{
int i, chunk;
float a[N], b[N], c[N];
/* Some initializations */
for (i=0; i < N; i++)
a[i] = b[i] = i * 1.0;
chunk = CHUNKSIZE;
#pragma omp parallel shared(a,b,c,chunk) private(i)
{
#pragma omp for schedule(dynamic, chunk) nowait
for (i=0; i < N; i++)
c[i] = a[i] + b[i];

} /*end of parallel section*/
}

- Simple vector-add program
- Arrays A, B, C, and variable N
    will be shared by all threads.
- Variable _i_ will be private to
    each thread; each thread
    will have its own unique
    copy.
- The iterations of the loop
    will be distributed
    dynamically in CHUNK sized
    pieces.
- Threads will not synchronize
    upon completing their
    individual pieces of work
    (NOWAIT).


Dynamic scheduling

- In OpenMP, "dynamic" refers to a scheduling policy that can be used to distribute work
    among threads in a parallel region. Dynamic scheduling allows work to be assigned to
    threads on an as-needed basis, rather than dividing the work into fixed-size chunks as
    with static scheduling.
- Under dynamic scheduling, the work is divided into individual tasks, and threads are
    assigned tasks as they become available. This can help to ensure that all threads are
    being fully utilized and that no single thread is left idle while others are still working. It
    can also be useful in situations where the workload is unpredictable or where the work
    items vary greatly in size.

```
25
```

Example of Sections directive

```
#include <omp.h>
#define N 1000
main(int argc, char *argv[]) {
int i;
float a[N], b[N], c[N], d[N];
/* Some initializations */
for (i=0; i < N; i++) {
a[i] = i * 1.5;
b[i] = i + 22.35;
}
#pragma omp parallel shared(a,b,c,d) private(i)
{
#pragma omp sections nowait
{
#pragma omp section
for (i=0; i < N; i++)
c[i] = a[i] + b[i];
#pragma omp section
for (i=0; i < N; i++)
d[i] = a[i] * b[i];
} /* end of sections */
} /* end of parallel region */
}
26
```
- Simple program
    demonstrating that
    different blocks of work
    will be done by different
    threads.


Example of For in Sections directive

```
#include <omp.h> #define N 1000
main(int argc, char *argv[]) {
```
int i; float a[N], b[N], c[N], d[N]; (^)
/* Some initializations */ for (i=0; i < N; i++)
{ a[i] = i * 1.5; b[i] = i + 22.35; } #pragma omp parallel shared(a,b,c,d) private(i) (^)
{ (^) #pragma omp sections nowait
{ #pragma omp section { (^)
#pragma omp for for (i=0; i < N; i++) c[i] = a[i] + b[i]; (^)
} #pragma omp section { (^)
#pragma omp for for (i=0; i < N; i++) d[i] = a[i] * b[i]; (^)
} } (^)
/* end of sections */ }
/* end of parallel region */ }
27

- Simple program
    demonstrating that
    different blocks of work
    will be done by
    different threads.


# Synchronization

# Construct

NEXT:

```
28
```

Synchronization Construct

- Consider a situation where two threads on two different processors
    are both trying to increment a variable x at the same time ....
       (like the need for MUTEX in Pthreads)
- To avoid a situation like this, the incrementing of x must be
    synchronized between the two threads to ensure that the correct
    result is produced.
- OpenMP provides a variety of Synchronization Constructs that control
    how the execution of each thread proceeds relative to other team
    threads.

```
29
```

**CRITICAL Directive**

- The CRITICAL directive specifies a region of code that must be executed by only one
    thread at a time.
- If a thread is currently executing inside a CRITICAL region and another thread reaches
    that CRITICAL region and attempts to execute it, it will block until the first thread exits
    that CRITICAL region.
- The optional name enables multiple different CRITICAL regions to exist:
    - Names act as global identifiers. Different CRITICAL regions with the same name are
       treated as the same region.
    - All CRITICAL sections which are unnamed, are treated as the same section.

```
30
```
```
C/C++ #pragma omp critical newline structured_block[ name ]
```

Example of CRITICAL

## #include <omp.h>

## main(int argc, char *argv[])

## {

## int x;

## x = 0;

## #pragma omp parallel shared(x)

## { .....

## 

## #pragma omp critical

## x = x + 1;

## } /* end of parallel region */

## }

```
31
```

References

- There are many more directives that can be used with OpenMP
- Some easy to understand references that you can refer to to learn
    more on OpenMP
       - https://computing.llnl.gov/tutorials/openMP/#Directives
- Blaise Barney. LLNL OpenMP tutorial.
    - [http://www.llnl.gov/computing/tutorials/openMP](http://www.llnl.gov/computing/tutorials/openMP)
- Adapted from slides “Programming Shared Address Space Platforms”
    by Ananth Grama
       - Ananth Grama, Anshul Gupta, George Karypis, and Vipin Kumar. Introduction
          to
- Parallel Computing. Chapter 7. Addison Wesley, 2003.

```
32
```

```
Copyright © Universiti Tenaga Nasional 2021
```
2021 Parallel Computing | UNITEN^33


