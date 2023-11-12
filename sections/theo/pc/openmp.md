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

![img](https://www.researchgate.net/publication/281015120/figure/fig1/AS:561240796864512@1510821641226/OpenMP-fork-join-model.png)

### OpenMP Directive Format

- OpenMP directive forms
    - C and C++ use compiler directives
    - prefix: #pragma …
- A directive consists of a directive name followed by clauses
- C: #pragma omp parallel num_threads(4)…

### Sample OpenMP Program

```c
#include <stdio.h>
#include <omp.h>

int main() {
    #pragma omp parallel num_threads (4) // if you domt specify this reagion the number of threads will be the number of cores.
    {
        int i = omp_get_thread_num();
        printf("Hello from thread %d\n", i);
    }
}
```
output
```
Hello from thread 0
Hello from thread 1
Hello from thread 2
Hello from thread 3
```

## Work-sharing Construct

The work-sharing construct in OpenMP is used to specify how to assign independent work to one or all of the threads.

all must be within the `#pragma omp parallel` directive.

#### `omp for` or `omp do`
- Used to split up loop iterations among the threads.
- Also called loop constructs.

**Example:**
```c
#include <omp.h>

int main() {
    #pragma omp parallel for
    for (int i = 0; i < 10; i++) {
        // Work to be done in parallel
    }
    return 0;
}
```

#### `sections`
- Assigns consecutive but independent code blocks to different threads.

**Example:**
```c
#include <omp.h>

int main() {
    #pragma omp parallel sections
    {
        #pragma omp section
        {
            // Code block for thread 1
        }

        #pragma omp section
        {
            // Code block for thread 2
        }

        // Additional sections as needed
    }
    return 0;
}
```

#### `single`
- Specifies a code block that is executed by only one thread.
- Implies a barrier at the end of the single construct.

**Example:**
```c
#include <omp.h>

int main() {
    #pragma omp parallel
    {
        #pragma omp single
        {
            // Code block executed by only one thread
        }

        // Other parallel work outside the single construct
    }
    return 0;
}
```

#### `master`
- Similar to `single`, but the code block will be executed by the master thread only.
- No barrier is implied at the end.

**Example:**
```c
#include <omp.h>

int main() {
    #pragma omp parallel
    {
        #pragma omp master
        {
            // Code block executed by the master thread only
        }

        // Other parallel work outside the master construct
    }
    return 0;
}
```

These work-sharing constructs provide flexibility in parallelizing different types of tasks, from loop iterations to distinct code sections, depending on the parallelization requirements of the program.

## Clauses

Since OpenMP is a shared memory programming model, most variables in OpenMP code are visible to all threads by default. But sometimes private variables are necessary to avoid race conditions and there is a need to pass values between the sequential part and the parallel region (the code block executed in parallel), so data environment management is introduced as data sharing attribute clauses by appending them to the OpenMP directive. The different types of clauses are:

### Data Sharing Attribute Clauses
- **shared**: Declares data outside a parallel region as shared, visible and accessible by all threads.
- **private**: Declares data within a parallel region as private to each thread, with a local copy for each.
- **default**: Specifies the default data scoping within a parallel region, options include shared, none (C/C++) or shared, firstprivate, private, or none (Fortran).
- **firstprivate**: Similar to private but initialized using the value of the variable from the master thread.
- **lastprivate**: Similar to private, but the original value is updated after the construct.
- **reduction**: Safely joins work from all threads after the construct.

### Synchronization Clauses
- **critical**: Ensures a code block is executed by only one thread at a time, protecting shared data from race conditions.
- **atomic**: Performs memory updates atomically, optimizing performance compared to using critical.
- **ordered**: Executes a structured block in the order of iterations in a sequential loop.
- **barrier**: Causes each thread to wait until all other threads in a team reach this point.
- **nowait**: Allows threads completing assigned work to proceed without waiting for all team threads to finish.

### Schedule Clause
- **schedule (type, chunk)**: Specifies how iterations in a work-sharing construct are assigned to threads.
    - **static**: Allocates iterations to threads before execution, dividing them equally by default.
    - **dynamic**: Allocates some iterations to fewer threads, with a thread fetching more after finishing its allocation.

### IF Control
- **if**: Parallelizes the task only if a specified condition is met; otherwise, the code block executes serially.

### Reduction
- **reduction (operator | intrinsic : list)**: Creates a local copy of a variable in each thread, with values summarized (reduced) into a global shared variable.

### OMP general construct
```c
#include <omp.h>

int main() {
    // Declare variables
    int var1, var2, var3;

    // Serial code
    // ...

    // Beginning of parallel region. Fork a team of threads.
    // Specify variable scoping
    #pragma omp parallel private(var1, var2) shared(var3)
    {
        // Parallel region executed by all threads
        // ...

        // Other OpenMP directives
        // ...

        // Run-time Library calls
        // ...

        // All threads join master thread and disband
    }

    // Resume serial code
    // ...

    return 0;
}
```
- `private`: each of the threads will have its own copy of the variable, in this case var1 and var2.
- `shared`: the variable will be shared among all the threads, in this case var3.


### Simple "Hello World" program.

```c
#include <stdio.h>
#include <omp.h>

int main() {
    int nthreads, tid;
    /* Fork a team of threads giving them their own copies of variables */

    #pragma omp parallel private(nthreads, tid)
    {
        /* Obtain thread number */
        tid = omp_get_thread_num();
        printf("Hello World from thread = %d\n", tid);

        /* Only master thread does this */
        if (tid == 0) {
            nthreads = omp_get_num_threads();
            printf("Number of threads = %d\n", nthreads);
        }
    } /* All threads join master thread and disband */
}
```

- Every thread executes all code enclosed in the parallel region

- OpenMP library routines are used to obtain thread identifiers and total number of threads

Possible Output: **Assume :​ OMP_NUM_THREADS 8**
```
Hello World from thread = 0​

Hello World from thread = 3​

Hello World from thread = 2​

Number of threads = 8​

Hello World from thread = 6​

Hello World from thread = 1​

Hello World from thread = 4​

Hello World from thread = 7​

Hello World from thread = 5​
```

## Number of Threads

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


## Restrictions

- A parallel region must be a structured block that does not span
    multiple routines or code files
- It is illegal to branch (goto) into or out of a parallel region(u must complete the parallel region then branch out).
- Only a single IF clause is permitted
- Only a single NUM_THREADS clause is permitted
- A program must not depend upon the ordering of the clauses

## Interpreting an OpenMP Parallel Directive

**Meaning:**
- `if (is_parallel == 1) num_threads(8)`: If the value of the variable `is_parallel` is one, create 8 threads.
- `shared(b)`: Each thread shares a single copy of variable `b`.
- `private(a) firstprivate(c)`: Each thread gets private copies of variables `a` and `c`.
  - Each private copy of `c` is initialized with the value of `c` in the "initial thread," which is the one that encounters the parallel directive.
- `default(none)`: The default state of a variable is specified as none (rather than shared).
  - Signals an error if not all variables are specified as shared or private.

```c
#pragma omp parallel if (is_parallel == 1) num_threads(8) \ shared(b) private(a) firstprivate(c) default(none)
{
    /* structured block */
}
```

## Specifying Worksharing

- Within the scope of a parallel directive, worksharing directives allow concurrency between iterations or tasks.
- A work-sharing construct distributes the execution of the associated statement among the members of the team that encounter it.
- The work-sharing directives do not launch new threads, and there is no implied barrier on entry to a work-sharing construct.
- OpenMP (for C/C++) provides four directives:
  - **Do/for:** Concurrent loop iterations.
  - **Sections:** Concurrent tasks.
  - **Single:** One arbitrary thread executes the code.


```c
#include <stdio.h>
#include <omp.h>

void test(int val) {
    #pragma omp parallel if(val)
    {
        if (omp_in_parallel()) {
            #pragma omp single
            {
                printf("val = %d, parallelized with %d threads\n", val, omp_get_num_threads());
            }
        }
        else {
            printf("val = %d, serialized\n", val);
        }
    }
}

int main() {
    omp_set_num_threads(2);
    
    test(0);
    test(2);

    return 0;
}
```
The SINGLE directive specifies that the enclosed code is to be executed by only one thread in the team.

- `#pragma omp parallel if (val)`: Specifies a parallel region if the condition `val` is true.
- `if (omp_in_parallel())`: Checks if the current code is executed in parallel.
- `#pragma omp single`: Ensures that the enclosed block is executed by only one thread.
- The `test` function is called twice from the `main` function with different values.
- The `omp_set_num_threads(2)` sets the number of threads for the parallel region to 2.

### Vector Addition Program C/C++ Code Example

```c
#include <stdio.h>
#include <omp.h>

#define CHUNKSIZE 100
#define N 1000

int main() {
    int i, chunk;
    float a[N], b[N], c[N];

    /* Some initializations */
    for (i = 0; i < N; i++)
        a[i] = b[i] = i * 1.0;

    chunk = CHUNKSIZE;

    #pragma omp parallel shared(a, b, c, chunk) private(i)
    {
        #pragma omp for schedule(dynamic, chunk) nowait
        for (i = 0; i < N; i++)
            c[i] = a[i] + b[i];
    } /* end of parallel section */

    return 0;
}
```
- Arrays A, B, C, and variable N are shared by all threads.
- Variable `i` is private to each thread; each thread has its own unique copy.
- Iterations of the loop are distributed dynamically in `CHUNK` sized pieces.
- Each thread executes independently of the others.
- Threads will not synchronize upon completing their individual pieces of work (`NOWAIT`).

### Dynamic Scheduling

- "Dynamic" in OpenMP refers to a scheduling policy that distributes work among threads on an as-needed basis.
- Dynamic scheduling assigns tasks to threads as they become available, ensuring all threads are fully utilized.
- Useful in unpredictable workloads or when work items vary greatly in size.

### Example of Sections Directive

```c
#include <omp.h>
#define N 1000

int main(int argc, char *argv[]) {
    int i;
    float a[N], b[N], c[N], d[N];

    /* Some initializations */
    for (i = 0; i < N; i++) {
        a[i] = i * 1.5;
        b[i] = i + 22.35;
    }

    #pragma omp parallel shared(a, b, c, d) private(i)
    {
        #pragma omp sections nowait
        {
            #pragma omp section
            for (i = 0; i < N; i++)
                c[i] = a[i] + b[i];

            #pragma omp section
            for (i = 0; i < N; i++)
                d[i] = a[i] * b[i];
        } /* end of sections */
    } /* end of parallel region */

    return 0;
}
```

- Simple program demonstrating that different blocks of work will be done by different threads.

### Example of For in Sections Directive

```c
#include <omp.h>
#define N 1000

int main(int argc, char *argv[]) {
    int i;
    float a[N], b[N], c[N], d[N];

    /* Some initializations */
    for (i = 0; i < N; i++) {
        a[i] = i * 1.5;
        b[i] = i + 22.35;
    }

    #pragma omp parallel shared(a, b, c, d) private(i)
    {
        #pragma omp sections nowait
        {
            #pragma omp section
            #pragma omp for
            for (i = 0; i < N; i++)
                c[i] = a[i] + b[i];

            #pragma omp section
            #pragma omp for
            for (i = 0; i < N; i++)
                d[i] = a[i] * b[i];
        }
    } /* end of parallel region */

    return 0;
}
```

- Simple program demonstrating that different blocks of work will be done by different threads.

## Synchronization Construct

### Master Directive

- The MASTER directive specifies that the enclosed code is to be executed by only one thread in the team.
- The MASTER directive is often used to initialize data that is shared among all threads in the team.

```c
#include <omp.h>

int main() {
    int x = 0;

    #pragma omp parallel shared(x)
    {
        // ...

        #pragma omp master
        x = x + 1;

        // ...
    } /* end of parallel region */

    return 0;
}
```

### Critical Directive

- The CRITICAL directive specifies a region of code that must be executed by only one thread at a time.
- If a thread is currently executing inside a CRITICAL region and another thread reaches that CRITICAL region and attempts to execute it, it will block until the first thread exits that CRITICAL region.
- The optional name enables multiple different CRITICAL regions to exist.

```c
#include <omp.h>

int main() {
    int x = 0;

    #pragma omp parallel shared(x)
    {
        // ...

        #pragma omp critical
        x = x + 1;

        // ...
    } /* end of parallel region */

    return 0;
}
```

This code demonstrates the use of the CRITICAL directive to ensure exclusive access to a shared variable `x`.

### Purpose of ORDERED Directive

- The ORDERED directive specifies that iterations of the enclosed loop will be executed in the same order as if they were executed on a serial processor.
- Threads will need to wait before executing their chunk of iterations if previous iterations haven't completed yet.
- Used within a `for` loop with an ORDERED clause.
- The ORDERED directive provides a way to "fine-tune" where ordering is to be applied within a loop. Otherwise, it is not required.

```c
#pragma omp parallel
{
    #pragma omp for nowait shared(a)
    for (k = 0; k < nmax; k++) {
        // ...

        #pragma omp ordered
        {
            a[k] = a[k - 1] + ...;
        }

        // ...
    }
}
```

- The `ordered` clause ensures that carried dependence does not cause a data race.
- It's often used in scenarios where maintaining a specific order of execution within a parallel loop is essential.

## Directives summary

![img](https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQ_n7gvC_rZowHdog_RJ1XoNQ9wSsBUaPrDDibBjPLjlHQFBbRh)