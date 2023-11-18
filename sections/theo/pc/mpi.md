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

```c
MPI_Init (&argc, &argv)
```

- Initializes the MPI execution environment.
- Must be called:
  - in every MPI program.
  - before any other MPI functions.
  - only once in an MPI program.
- For C programs, MPI_Init may be used to pass the command line arguments to all processes.
- Implementation-dependent. MPI_Init() sets up the communication mechanism (e.g., TCP/IP sockets, Infiniband, shared-memory) based on the underlying platform.

### MPI_Comm_size

```c
MPI_Comm_size(comm, &size)
```

- Returns the total number of MPI processes in the specified communicator (`MPI_COMM_WORLD` represents the number of MPI tasks available).

### MPI_Abort

- Terminates all MPI processes associated with the communicator.
- Terminates ALL processes regardless of the communicator specified.

### MPI_Get_processor_name

```c
MPI_Get_processor_name(&name, &resultlength)
```

- Returns the processor name and the length of the name.
- Buffer for "name" must be at least `MPI_MAX_PROCESSOR_NAME` characters in size.
- Return value of "name" is implementation-dependent and may not be the same as the output of the "hostname" or “host” shell commands.

### MPI_Get_version

```c
MPI_Get_version(&version, &subversion)
```

- Returns the version and subversion of MPI.

### MPI_Initialized

```c
MPI_Initialized(&flag)
```

- Indicates whether MPI_Init has been called and returns `flag` as either logical true (1) or false (0).
- Solves the problem for modules that want to use MPI and are prepared to call MPI_Init if necessary.

### MPI_Wtime & MPI_Wtick

```c
MPI_Wtime()
```

- Returns an elapsed wall clock time in seconds (double precision) on the calling processor.
- Allows high-resolution and portable timing.

```c
MPI_Wtick()
```

- Returns the resolution of MPI_WTIME in seconds.

### Example

```c
#include "mpi.h"
#include <windows.h>
#include <stdio.h>

int main(int argc, char *argv[])
{
    double t1, t2;
    MPI_Init(0, 0);
    t1 = MPI_Wtime();
    Sleep(1000);
    t2 = MPI_Wtime();
    printf("MPI_Wtime measured a 1 second sleep to be: %1.2f\n", t2 - t1);
    fflush(stdout);
    MPI_Finalize();
    return 0;
}
```

- The example code illustrates the use of MPI_Wtime.

### MPI_Finalize

```c
MPI_Finalize()
```

- Terminates the MPI execution environment.
- Should be the last MPI routine called in every MPI program - no other MPI routines may be called after it.

# Point-to-Point

## Operations

### Point-to-Point Operations

- Involve message passing between two, and only two, different MPI tasks.
- One task is performing a send operation, and the other task is performing a receive operation.

### Types of Send/Receive Routines

- Buffering
- Blocking send / blocking receive
- Non-blocking send / non-blocking receive

### Routines

#### Routines – Arguments

- **Buffer:** Program (application) address space that references the data that is to be sent or received – send/receive variable address that is to be sent/received: &var1.
- **Data count:** Indicates the number of data elements of a particular type to be sent.
- **Data type:** MPI predefines data types.
- **Destination:** Where a message should be delivered. Specified as the rank of the receiving process.
- **Source:** Originating process of the message. Specified as the rank of the sending process.
- **Tag:** Non-negative integer assigned by the programmer, uniquely identifying a message.
- **Communicator:** Indicates the communication context or set of processes for which the source or destination fields are valid - MPI_COMM_WORLD.

#### MPI Pre-defined Datatype

```c
Data type Description
MPI_CHAR signed char
MPI_INT signed int
MPI_FLOAT Float
MPI_DOUBLE Double
```

### MPI Send()

```c
MPI_Send(mymin, 2, MPI_INT, 0, MYMIN_MSG, MPI_COMM_WORLD);
```

- **mymin:** Address at which the bytes begin.
- **2, MPI_INT:** Set of bytes consists of 2 objects of type MPI_INT.
- **0:** Sending to node 0.
- **MYMIN_MSG:** Programmer-defined message type.
- **MPI_COMM_WORLD:** Node group to which the message is to be sent.

### MPI Recv()

```c
MPI_Recv(othermin, 2, MPI_INT, i, MYMIN_MSG, MPI_COMM_WORLD, &status);
```

- **othermin:** Received message placed at our location.
- **2, MPI_INT:** Two objects of MPI_INT type to be received.
- **i:** Receive only messages from node i.
- **MYMIN_MSG:** Receive only messages of type MYMIN_MSG.
- **status:** MPI_Status status; describes the result of MPI_Recv() call.

### Buffering

- Deal with storing data.
- Within CPU - system buffer area is reserved to hold data in transit.
- System Buffer - Managed entirely by the MPI library.
- A finite resource that can be easy to exhaust.
- Often mysterious and not well documented.
- Can exist on the sending side, the receiving side, or both.
- May improve program performance because it allows send-receive operations to be asynchronous.

### Blocking

- MPI blocking refers to a type of communication operation in the Message Passing Interface (MPI) standard that causes the sender and receiver processes to block or wait until the communication is complete before continuing with their execution.
- Blocking communication is synchronous, causing the sender process to halt its execution until the message has been successfully delivered to the receiver process. Similarly, the receiver process halts its execution until it has received the message.
- Blocking communication simplifies programming but can lead to performance issues.

### Order

- MPI guarantees that messages will not overtake each other.
- The order of message reception is determined by the order of sending.

### Fairness

- MPI does not guarantee fairness; it's up to the programmer to prevent "operation starvation."
- Fairness refers to each process receiving a fair share of available resources, but MPI does not define specific mechanisms for resource allocation or task scheduling.

### Scope

- Collective communication routines must involve all processes within the scope of a communicator.
- All processes within a communicator participate in any collective operations.

# Collective Communication

## Routines

### Types of Collective Operations

- **Synchronization**: Processes wait until all members of the group have reached the synchronization point.
- **Data Movement**: Broadcast, scatter/gather, all to all.
- **Collective Computation (reductions)**: One member of the group collects data from the other members and performs an operation (min, max, add, multiply, etc.) on that data.

- **Broadcast**: One process sends the same message to all other processes in the group.
- **Scatter**: One process sends distinct messages to all other processes in the group.
- **Gather**: One process receives distinct messages from all other processes in the group.
- **Reduction**: One process collects data from all other processes in the group and performs an operation on that data.

### Collective Operations Routines

#### MPI_Barrier

- **Description**: Synchronization operation.
- Creates a barrier synchronization in a group.
- Each task, when reaching the MPI_Barrier call, blocks until all tasks in the group reach the same MPI_Barrier call. Then, all tasks are free to proceed.
- **Usage**: `MPI_Barrier(comm)`

#### MPI_Bcast

- **Description**: Data movement operation.
- Broadcasts (sends) a message from the process with rank "root" to all other processes in the group.
- **Usage**: `MPI_Bcast(&buffer, count, datatype, root, comm)`

#### MPI_Scatter

- **Description**: Data movement operation.
- Distributes distinct messages from a single source task to each task in the group.
- **Usage**: `MPI_Scatter(&sendbuf, sendcnt, sendtype, &recvbuf, recvcnt, recvtype, root, comm)`

#### MPI_Gather

- **Description**: Data movement operation.
- Gathers distinct messages from each task in the group to a single destination task. (Reverse operation of MPI_Scatter)
- **Usage**: `MPI_Gather(&sendbuf, sendcnt, sendtype, &recvbuf, recvcount, recvtype, root, comm)`

#### MPI_Allgather

- **Description**: Data movement operation.
- Concatenation of data to all tasks in a group.
- Each task in the group, in effect, performs a one-to-all broadcasting operation within the group.
- **Usage**: `MPI_Allgather(&sendbuf, sendcount, sendtype, &recvbuf, recvcount, recvtype, comm)`

#### MPI_Reduce

- **Description**: Collective computation operation.
- Applies a reduction operation on all tasks in the group and places the result in one task.
- **Usage**: `MPI_Reduce(&sendbuf, &recvbuf, count, datatype, op, root, comm)`

#### MPI_Allreduce

- **Description**: Collective computation operation + data movement.
- Applies a reduction operation and places the result in all tasks in the group (Equivalent to MPI_Reduce followed by MPI_Bcast).
- **Usage**: `MPI_Allreduce(&sendbuf, &recvbuf, count, datatype, op, comm)`

#### MPI_Reduce_scatter

- **Description**: Collective computation operation + data movement.
- First does an element-wise reduction on a vector across all tasks in the group. The result vector is split into disjoint segments and distributed across the tasks.
- Equivalent to MPI_Reduce followed by MPI_Scatter operation.
- **Usage**: `MPI_Reduce_scatter(&sendbuf, &recvbuf, recvcnt, datatype, op, comm)`

For more details, refer to [LLNL MPI Tutorial](https://computing.llnl.gov/tutorials/mpi).


