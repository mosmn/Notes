# Message Passing Interface (MPI)

### Overview

- MPI is the first standardized, vendor-independent message passing library.
- While not an IEEE or ISO standard, MPI has become the industry standard for writing message passing programs on High-Performance Computing (HPC) platforms.
- MPI primarily addresses the message-passing parallel programming model.

### Evolution of MPI

- Originally designed for distributed memory architectures in the 1980s - early 1990s.
- Adapted to hybrid distributed memory/shared memory systems as architecture trends changed.

### Current Adaptability

- MPI libraries have been adapted to seamlessly handle various memory architectures, interconnects, and protocols.
- Today, MPI runs on distributed memory, shared memory, and hybrid platforms.

### How MPI Works

- Treat each node as a thread.
- Message passing involves sending work to a node, processing it, and returning results.
- Similarities and differences between threads and MPI.

### General Program Structure of MPI

#### Communicators and Group

- Define which collection of processes may communicate with each other using `MPI_COMM_WORLD`.
- MPI allows subdivision of nodes into groups for performance and code clarity.
- The totality of all groups is denoted by `MPI_COMM_WORLD`.

#### Rank

- Each process within a communicator is assigned a unique integer identifier.
- Contiguous numbering starting at zero.
- Used to specify the source and destination of messages.

### MPI APIs

- `MPI_Init`
- `MPI_Comm_size`
- `MPI_Comm_rank`
- `MPI_Abort`
- `MPI_Get_processor_name`
- `MPI_Get_version`
- `MPI_Initialized`
- `MPI_Wtime`
- `MPI_Wtick`
- `MPI_Finalize`

### Examples

#### Example in C/C++

```c
#include "mpi.h"
#include <stdio.h>

int main(int argc, char** argv)
{
    int rank, numtasks, rc, len;
    char hostname[MPI_MAX_PROCESSOR_NAME];

    rc = MPI_Init(&argc, &argv);
    if (rc != MPI_SUCCESS) {
        printf("Error.\n");
        MPI_Abort(MPI_COMM_WORLD, rc);
    }

    MPI_Comm_size(MPI_COMM_WORLD, &numtasks);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Get_processor_name(hostname, &len);

    printf("Number of tasks: %d My rank: %d on host %s\n", numtasks, rank, hostname);

    MPI_Finalize();
    return 0;
}
```

**Example 2:**
```c
#include <mpi.h>
#include <stdio.h>
#include <unistd.h>

int main(int argc, char** argv)
{
    int rank;
    char hostname[256];

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Get_processor_name(hostname, 255);

    printf("Hello world! I am process number: %d on host %s\n", rank, hostname);

    MPI_Finalize();
    return 0;
}
```

### Output Example

```sh
hpc-login3: ls -l slurm-*.out
-rw------- 1 ttrojan rds 0 Mar 22 11:00 slurm-12240.out

hpc-login3: more slurm-12240.out
Running on 8 processors: hpc
Running ./mpitest
Hello world! I am process number: 0 on host hpc0632
Hello world! I am process number: 1 on host hpc0632
Hello world! I am process number: 2 on host hpc0632
Hello world! I am process number: 3 on host hpc0632
Hello world! I am process number: 4 on host hpc0632
Hello world! I am process number: 5 on host hpc0632
Hello world! I am process number: 6 on host hpc0632
Hello world! I am process number: 7 on host hpc0632
Done Thu Mar 22 11:00:06 PDT 2018
```


### MPI_Init

```
MPI_Init (&argc,&argv)
```
- Initializes the MPI execution environment
- Must be called
    - every MPI program
    - before any other MPI functions
    - only once in an MPI program.
- For C programs, MPI_Init may be used to pass the command line arguments to all
    processes
- Its implementation dependant. MPI Init() will probably set up the TCP/IP sockets
    via which the various nodes communicate with each other. On an
    Infiniband-based cluster, connections in the special Infiniband network protocol
    will be established. On a shared-memory multiprocessor, an implementation of
    MPI that is tailored to that platform would take very diferent actions.


### MPI_Comm_size

```
MPI_Comm_size(comm,&size)
```
- Returns the total number of MPI processes in the specified
    communicator
       - MPI_COMM_WORLD 🡪 represents the number of MPI tasks available


### MPI_Abort

- Terminates all MPI processes associated with the communicator
- Terminates ALL processes regardless of the communicator specified


### MPI_Get_processor_name

```
MPI_Get_processor_name(&name,&resultlength)
```
- Returns the processor name, returns the length of the name
- Buffer for "name" must be at least MPI_MAX_PROCESSOR_NAME
    characters in size
- Return value - "name" is implementation dependent - may not be the
    same as the output of the "hostname" or “host” shell commands


### MPI_Get_version

```
MPI_Get_version(&version,&subversion
```
- Returns the version and subversion of MPI


### MPI_Initialized

```
MPI_Initialized(&flag)
```
- Indicates whether MPI_Init has been called - returns flag as either
    logical true (1) or false(0)
- MPI requires that MPI_Init be called once and only once by each
    process
       - Pose a problem for modules that want to use MPI and are prepared to call
          MPI_Init if necessary
- MPI_Initialized solves this problem


### MPI_Wtime & MPI_Wtick

```
MPI_Wtime()
```
- Returns an elapsed wall clock time in seconds (double precision) on the calling processor
- MPI_WTIME returns a floating-point number of seconds, representing elapsed wall-clock time since some time in the past.
- The ``time in the past'' is guaranteed not to change during the life of the process. The user is responsible for converting large numbers of seconds other units if they are preferred. to
- This function is portable (it returns seconds, not ``ticks''), it allows high-resolution, and carries no unnecessary baggage. One would use it like this:
_{ double starttime, endtime;
starttime = MPI_Wtime();
.... stuff to be timed ...
endtime = MPI_Wtime();
printf("That took %f seconds\n",endtime-starttime);
}_

```
MPI_Wtick()
```
- MPI_WTICK returns the resolution of MPI_WTIME in seconds. That is, it returns, as a double precision value, the number of seconds between successive clock ticks. For example, if the clock is implemented by the hardware as a counter that is incremented every millisecond, the value
    returned by MPI_WTICK should be 10-3.


### Example

```
#include "mpi.h"
#include <windows.h>
#include <stdio.h>
int main( int argc, char *argv[] )
{
double t1, t2;
MPI_Init( 0, 0 );
t1 = MPI_Wtime();
Sleep(1000);
t2 = MPI_Wtime();
printf("MPI_Wtime measured a 1 second sleep to
be: %1.2f\n", t2-t1);
fflush(stdout);
MPI_Finalize( );
return 0;
}
```
- The following sample
    code illustrates
    MPI_Wtime.


### MPI_Finalize

```
MPI_Finalize()
```
- Terminates the MPI execution environment
- Should be the last MPI routine called in every MPI program - no other
    MPI routines may be called after it


# Point-to-Point

# Operations


### Point-to-Point Operations

- Involve message passing between two, and only two, different MPI
    tasks
- One task is performing a send operation and the other task is
    performing a receive operation


### Types of Send/Receive Routines

- Buffering
- Blocking send / blocking receive
- Non-blocking send / non-blocking receive


### Routines


### Routines – Arguments

- Buffer - Program (application) address space that references the data that is to be sent or
    received – send/receive variable address that is be sent/received: &var1
- Data count - Indicates the number of data elements of a particular type to be sent
- Data type - MPI predefines data types. Refer to the following table
- Destination - where a message should be delivered. Specified as the rank of the receiving
    process
- Source - originating process of the message. Specified as the rank of the sending process
- Tag - non-negative integer - assigned by the programmer - uniquely identify a message.
    Send and receive operations should match message tags
- Communicator - Indicates the communication context, or set of processes for which the
    source or destination fields are valid - MPI_COMM_WORLD Any process can use MPI
    Comm World to communicate with any other process in the program, as long as the
    process is part of the communicator.


### MPI Pre-defined Datatype

```
Data type Description
MPI_CHAR signed char
MPI_INT signed int
MPI_FLOAT Float
MPI_DOUBLE Double
More on
https://computing.llnl.gov/tutorials/mpi
```

### MPI Send()

```
MPI_Send(mymin, 2, MPI_INT, 0, MYMIN_MSG, MPI_COMM_WORLD);
```
- mymin, :
    - We are sending a set of bytes. This argument states the address at which these bytes begin
- 2, MPI_INT, :
    - This says that our set of bytes to be sent consists of 2 objects of type MPI INT.
- 0 , :
    - We are sending to node 0.
- MYMIN_MSG
    - This is the programmer-defined message type. Receive calls, described in the next section, can ask to receive only
       messages of a certain type.
- MPI_COMM_WORLD
    - This is the node group to which the message is to be sent. Above, where we said we are sending to node 0, we
       technically should say we are sending to node 0 within the group MPI COMM WORLD.


### MPI Recv()

```
MPI_Recv (othermin,2,MPI_INT,i,MYMIN_MSG,MPI_COMM_WORLD,&status);
```
- othermin: The received message is to be placed at our location othermin.
- 2, MPI INT:
    - Two objects of MPI INT type are to be received.
- i:
    - Receive only messages from node i. If we did not care what node we received a message from, we could specify the value MPI ANY SOURCE.
- MYMIN MSG:
    - Receive only messages of type MYMIN MSG. If we did not care what type of message we
       received, we would specify the value MPI ANY TAG
- status: MPI_Status status; // describes result of MPI_Recv() call
    - The type is an MPI struct containing information about the received message. Its primary fields of interest are MPI SOURCE, which contains the identity of the sending node, and
       MPI TAG, which contains the message type.
    - the status argument would then tell us which node sent the message and what type the

#### message was.


### Buffering

- Deal with storing data
- Within CPU - system buffer area is reserved to hold data in transit
- System Buffer
- Managed entirely by the MPI library
- A finite resource that can be easy to exhaust
- Often mysterious and not well documented
- Able to exist on the sending side, the receiving side, or both
- Something that may improve program performance because it allows
    send - receive operations to be asynchronous.


### Blocking

- MPI blocking refers to a type of communication operation in the Message
    Passing Interface (MPI) standard that causes the sender and receiver
    processes to block, or wait, until the communication is complete before
    continuing with their execution.
- In MPI, communication operations can be either blocking or non-blocking.
    Blocking communication is synchronous, which means that the sender
    process halts its execution until the message has been successfully
    delivered to the receiver process. Similarly, the receiver process halts its
    execution until it has received the message. Blocking communication can be
    achieved through functions such as MPI_Send and MPI_Recv.

2021 Parallel Computing | UNITEN^32


- Blocking communication can simplify the programming of MPI applications
    because it ensures that the sender and receiver processes are synchronized
    and that the data has been correctly transmitted before proceeding.
    However, blocking communication can also lead to performance issues,
    especially in programs with many communication operations, as it can
    cause processes to idle while waiting for messages to be transmitted.
- In contrast, non-blocking communication allows the sender and receiver
    processes to continue with their execution without waiting for the
    communication to complete. This can improve the performance of MPI
    applications by allowing processes to overlap communication and
    computation operations. Non-blocking communication can be achieved
    through functions such as MPI_Isend and MPI_Irecv.

2021 Parallel Computing | UNITEN^33


### Order

- MPI guarantees that messages will not overtake each other
    - Sender sends two messages (Message 1 and Message 2) in succession to the
       same destination, and both match the same receive, the receive operation
       will receive Message 1 before Message 2
    - If a receiver posts two receives (Receive 1 and Receive 2), in succession, and
       both are looking for the same message, Receive 1 will receive the message
       before Receive 2


### Fairness

- MPI does not guarantee fairness - it's up to the programmer to prevent
    "operation starvation”
- Fairness in the context of parallel computing refers to the notion that each
    process should receive a fair share of the available resources, such as CPU
    time and memory, to execute its tasks. However, MPI does not define any
    specific mechanism for resource allocation or task scheduling, leaving these
    aspects to the discretion of the programmer or the underlying operating
    system.
- As a result, the allocation of resources and the scheduling of tasks may not
    be balanced across all processes, leading to unfairness in the execution. For
    example, some processes may be starved of resources while others may
    monopolize them, leading to slowdowns and inefficiencies in the overall
    computation.


### Scope

- Collective communication routines must involve **all processes** within
    the scope of a communicator
       - All process - members in the communicator MPI_COMM_WORLD
- All processes within a communicator participate in any collective
    operations


## Collective Communication

## Routines


### Types of Collective Operations

**- Synchronization** - processes wait until all members of the group have
    reached the synchronization point
**- Data Movement** - broadcast, scatter/gather, all to all
**- Collective Computation (reductions)** - one member of the group
    collects data from the other members and performs an operation
    (min, max, add, multiply, etc.) on that data


### Types of Collective Operations


### Collective

### operation: Example

**C/C++**
#include <stdio.h>
#define SIZE 4
int main(int argc, char *argv[]){
int numtasks, rank, sendcount, recvcount,
source;;
float sendbuf[SIZE][SIZE] = {
{1.0, 2.0, 3.0, 4.0},
{5.0, 6.0, 7.0, 8.0},
{9.0, 10.0, 11.0, 12.0},
{13.0, 14.0, 15.0, 16.0} };
float recvbuf[SIZE];
MPI_Init(&argc,&argv);
MPI_Comm_rank(MPI_COMM_WORLD, &rank);
MPI_Comm_size(MPI_COMM_WORLD, &numtasks);

```
C/C++
if (numtasks == SIZE) {
source = 1;
sendcount = SIZE;
recvcount = SIZE;
MPI_Scatter(sendbuf,sendcount,MPI_FLOAT
, recvbuf,recvcount,MPI_FLOAT,source,
MPI_COMM_WORLD);
printf("rank= %d Results: %f %f %f
%f\n", rank, recvbuf[0], recvbuf[1],
recvbuf[2], recvbuf[3]);
}
else
printf("Must specify %d processors.
Terminating.\n",SIZE);
MPI_Finalize();
}
```
```
C/C++: Output
Sample program output:
rank= 0 Results: 1.000000 2.000000 3.000000 4.000000
rank= 1 Results: 5.000000 6.000000 7.000000 8.000000
rank= 2 Results: 9.000000 10.000000 11.000000 12.000000
rank= 3 Results: 13.000000 14.000000 15.000000 16.000000
```

### MPI Scatter and Mpi Bcast

- MPI Scatter is a collective communication operation that distributes an array of data from one
    process (called the root process) to all other processes in the communicator. The root process
    divides the array into equal-sized chunks, and each chunk is sent to a different process in the
    communicator. The receiving processes receive only their portion of the array. MPI Scatter is
    useful when different processes need to work on different parts of a larger dataset.
- MPI Broadcast is another collective communication operation that sends a copy of the same data
    from one process (called the root process) to all other processes in the communicator. The root
    process sends the data to all other processes in the communicator, and all processes receive the
    same data. MPI Broadcast is useful when a single piece of data needs to be sent to all processes
    in a program, such as when initializing a variable or setting up a shared resource.
- In summary, MPI Scatter distributes an array of data to multiple processes, with each process
    receiving a portion of the array, while MPI Broadcast sends a copy of the same data to all
    processes in a program.


### Collective Operations Routines

**Routine Description**

MPI_Barrier • Synchronization
operation

- Creates a barrier
    synchronization in a
    group
- Each task, when reaching
    the MPI_Barrier call
       1. blocks until all tasks
          in the group reach
          the same
          MPI_Barrier call
       2. Then all tasks are
          free to proceed
- MPI_Barrier (comm)

```
Routine Description
MPI_Bcast • Data movement operation
```
- Broadcasts (sends) a message from
    the process with rank "root" to all
    other processes in the group
- MPI_Bcast
    (&buffer,count,datatype,root,comm)

```
MPI_Scatter • Data movement operation
```
- Distributes distinct messages from a
    single source task to each task in the
    group
- MPI_Scatter
    (&sendbuf,sendcnt,sendtype,&recvb
    uf, recvcnt, recvtype, root,comm)


### Collective Operations Routines

**Routine Description**

MPI_Gather • Data movement operation

- Gathers distinct messages
    from each task in the
    group to a single
    destination task.
- Reverse operation of
    MPI_Scatter
- MPI_Gather
    (&sendbuf,sendcnt,sendty
    pe,&recvbuf, recvcount,
    recvtype,root,comm)

```
Routine Description
MPI_Allgather • Data movement operation
```
- Concatenation of data to all
    tasks in a group
- Each task in the group, in
    effect, performs a one- to- all
    broadcasting operation within
    the group
- MPI_Allgather
    (&sendbuf,sendcount,sendtyp
    e, &recvbuf, recvcount,
    recvtype,comm)


### Collective Operations Routines

**Routine Description**

MPI_Reduce • • Collective computation operationApplies a reduction operation on all tasks in^

```
the group and places the result in one task
```
- MPI_Reduce
    (&sendbuf,&recvbuf,count,datatype,op,root
    ,comm)

MPI_Allreduc
e

- Collective computation
    operation + data movement
- Applies a reduction operation
    and places the result in all tasks
    in the group
- Equivalent to an MPI_Reduce
    followed by an MPI_Bcast
- MPI_Allreduce
    (&sendbuf,&recvbuf,count,data
    type,op,comm)

```
Routine Description
MPI_Reduce_scatter • Collective computation
operation + data movement
```
1. First does an element-
    wise reduction on a
    vector across all tasks in
    the group
2. result vector is split into
    disjoint segments and
    distributed across the
    tasks - equivalent to an
    MPI_Reduce followed
    by an MPI_Scatter
    operation
- MPI_Reduce_scatter
(&sendbuf,&recvbuf,recvcou
nt,datatype, op, comm)
More on https://computing.llnl.gov/tutorials/mpi



### Reference

1. https://computing.llnl.gov/tutorials/mpi


```
Copyright © Universiti Tenaga Nasional 2021
```
2021 Parallel Computing | UNITEN^47


