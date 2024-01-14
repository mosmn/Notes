# I/O Categories and Techniques

External devices that engage in I/O with computer systems can be grouped into three categories:
1. Human readable
    * suitable for communicating with the computer user
    * printers, terminals, video display, keyboard, mouse
2. Machine readable
    * suitable for communicating with electronic equipment
    * disk drives, USB keys, sensors, controllers
3. Communication
    * suitable for communicating with remote devices
    * modems, digital line drivers, network interface card (NIC)

## Differences in I/O devices

- Data Rate
    - How fast is the transfer?
    - there may be differences of magnitude between the data transfer rates
- Application
    - Which application uses it?
    - a device usage has an influence on the software and OS policies / utilities
- Complexity of Control
    - What is being control? How is it done?
    - the effect on the operating system is filtered by the complexity of the I/O module that controls the device,
    depending on its function
- Unit of Transfer
    - How big of data is being transferred?
    - data may be transferred as a stream of bytes or characters or in larger blocks
- Data Representation
    - Block? Stream? Movement? Gesture?
    - different data encoding schemes are used by different devices
- Error Conditions
    - What to do when things go wrong?
    - the nature of errors, the way in which they are reported, their consequences, and the available range of responses differs from one device to another

## Evolution of the I/O Function

1. Simple Microprocessor-controlled device
    - Processor directly controls a peripheral device
2. Processor uses programmed I/O w/out interrupts
    - A controller or I/O module is added
3. Processor need not wait for I/O to be performed
    - Same configuration as step 2, but now interrupts are employed
4. Block of data can be transferred w/out involving processor
    - The I/O module is given direct control of memory via DMA(Direct Memory Access)
5. Processor time can be utilized better
    - The I/O module is enhanced to become a separate processor, with a specialized instruction set tailored for I/O
6. a large set of I/O devices can be controlled, with minimal processor involvement
    - The I/O module has a local memory of its own and is, in fact, a computer in its own right

## Techniques for Performing I/O

1. Programmed I/O
    - the processor issues an I/O command on behalf of a process to an I/O module
    - process then busy waiting for the operation to be completed before proceeding
2. Interrupt-driven I/O
    - the processor issues an I/O command on behalf of a process
        - if non-blocking – processor continues to execute instructions from the process that issued the I/O command
        - if blocking – the next instruction the processor executes is from the OS, which will put the current process in a blocked state and schedule another process
3. Direct Memory Access (DMA)
    - a DMA module controls the exchange of data between main memory and an I/O module
    - the processor is involved only at the beginning and end of the transfer

### detail

When the processor is executing a program and encounters an instruction relating to I/O, it executes that instruction by issuing a command to the appropriate I/O module. In the case of programmed I/O, the I/O module performs the requested action, then sets the appropriate bits in the I/O status register but takes no further action to alert the processor. In particular, it does not interrupt the processor. Thus, after the I/O instruction is invoked, the processor must take some active role in determining when the I/O instruction is completed. For this purpose, the processor periodically checks the status of the I/O module until it finds that the operation is complete.
With programmed I/O, the processor has to wait a long time for the I/O module of concern to be ready for either reception or transmission of more data. The processor, while waiting, must repeatedly interrogate the status of the I/O module. As a result, the performance level of the entire system is severely degraded.
An alternative, known as interrupt-driven I/O, is for the processor to issue an I/O command to a module then go on to do some other useful work. The I/O module will then interrupt the processor to request service when it is ready to exchange data with the processor. The processor then executes the data transfer, as before, and resumes its former processing.
Interrupt-driven I/O, though more efficient than simple programmed I/O, still requires the active intervention of the processor to transfer data between memory and an I/O module, and any data transfer must traverse a path through the processor. Thus, both of these forms of I/O suffer from two inherent drawbacks:
- The I/O transfer rate is limited by the speed with which the processor can test and service a device.
- The processor is tied up in managing an I/O transfer; a number of instructions must be executed for each I/O transfer.

When large volumes of data are to be moved, a more efficient technique is required: direct memory access (DMA). The DMA function can be performed by a separate module on the system bus, or it can be incorporated into an I/O module. In either case, the technique works as follows. When the processor wishes to read or write a block of data, it issues a command to the DMA module by sending the following information:

Whether a read or write is requested
- The address of the I/O device involved
- The starting location in memory to read data from or write data to
- The number of words to be read or written

The processor then continues with other work. It has delegated this I/O operation to the DMA module, and that module will take care of it. The DMA module transfers the entire block of data, one word at a time, directly to or from memory without going through the processor. When the transfer is complete, the DMA module sends an interrupt signal to the processor. Thus, the processor is involved only at the beginning and end of the transfer.

### Direct Memory Access (DMA)

Direct Memory Access (DMA) is a capability provided by a computer architecture that
- allows data to be sent directly from an attached peripheral device (such as a disk drive) to the memory on the computer's motherboard.
- The processor is freed from involvement with the data transfer, thus speeding up overall computer operation.
    - the processor is involved only at the beginning and end of the transfer

# I/O Facilities Design

## I/O facility design objectives

1. Efficiency
    - Major effort in I/O design
    - Important because I/O operations often form a bottleneck
        - Bottleneck cause?
            - I/O transfer is slow compared to the speed of CPU
            - How can the data transfer be improved?
    - Most I/O devices are extremely slow compared with main memory and the processor
        - Even with the vast size of main memory in today’s machines, it will still often be the case that I/O is not keeping up with the activities of the processor.
        - Handled through multiprogramming, keeping processor busy
    - The area that has received the most attention is disk I/O
2. Generality
    - Desirable to handle all devices in a uniform manner
    - applies to both the way processes view I/O devices and the way the operating system manages I/O devices and operations

## A Model of I/O Organization

The three most important logical structures are presented in the figure.

![I/O Organization](/imgs/iom1.png)

A particular operating system may not conform exactly to these structures. This is just an approximation

The following layers are involved:
1. Logical I/O
2. Device I/O
3. Scheduling and Control
4. Directory Management
5. File System
6. Physical Organization

### 1. Logical I/O

- The logical I/O module deals with the device as a logical resource
- The logical I/O module is concerned with managing general I/O functions on behalf of user processes
- It allows module to deal with the device in terms of a device identifier and simple commands such as open, close, read, and write.

### 2. Device I/O

- The requested operations and data (buffered characters, records, etc.) are converted into:
    - appropriate sequences of I/O instructions, channel commands, and controller orders.
    - Buffering techniques may be used to improve utilization.

### 3. Scheduling and Control

- The actual queuing and scheduling of I/O operations occurs at this layer, as well as the control of the operations.
- Thus, interrupts are handled at this layer and I/O status is collected and reported.

### 4. Directory management

- Symbolic file names are converted to identifiers that either reference the file directly or indirectly through a file descriptor or index table.
- This layer is also concerned with user operations that affect the directory of files, such as add, delete, and reorganize.

### 5. File system

- Deals with the logical structure of files and with the operations that can be specified by users, such as open, close, read, and write.
- Access rights are also managed at this layer.

### 6. Physical organization

- logical references to files and records must be converted to physical secondary storage addresses
- taking into account the physical track and sector structure of the secondary storage device.
- Allocation of secondary storage space and main storage buffers is generally treated at this layer as well.

## TWO TYPES OF I/O DEVICES

In terms of data transfer

Block-oriented devices
- Information is stored in fixed sized blocks
- Transfers are made one block at a time
- Possible to reference data by its block number
- disks and USB keys are examples

Stream-oriented devices
- Transfers data in and out as a stream of bytes (could be byte at a time or line at a time)
- No block structure
- Terminals, printers, communications ports, and most other devices that are not secondary storage are examples

# I/O Buffering

Consider the following situation:
- Suppose user process wishes to read blocks of data from a tape one at a time.
- Each block have a length of 512 bytes.
- Data are to be read into a data area within the address space of the user process at location 1000 to 1511
- Execute an I/O command to the tape unit and wait for the data to become available.

There are two problems with this approach.
1. User program hung up waiting for the I/O to complete
2. Interferes with swapping decisions by OS
    - Location 1000 – 1511 must remain in main memory during the course of block transfer, if not some data maybe lost.
    - Risk of single process deadlock
        - Process suspend because waiting for I/O command and being swapped out.
        - The process is blocked waiting for I/O event and the I/O operation is blocked waiting for the process to be swapped in.

To avoid the problem used “frame locking”.

## Buffering

- Perform input transfers in advance of requests being made
- Perform output transfers some time after the request is made

Why buffering??
- Processes must wait for I/O to complete before proceeding
- Certain pages must remain in main memory during I/O

No Buffer: The OS directly accesses the device when it needs

Three types of buffering:
- Single Buffer
- Double Buffer
- Circular Buffer

### Single Buffer

Operating system assigns a buffer in main memory for an I/O request

The simplest type of support that the operating system can provide.
- When a user process issues an I/O request, the OS assigns a buffer in the system portion of main memory to the operation.

#### Block – Oriented Single Buffer

- Input transfers are made to the buffer
- Reading ahead/anticipated input
    - is done in the expectation that the block will eventually be needed
    - when the transfer is complete, the process moves the block into user space and immediately requests another block
- Generally provides a speedup compared to the lack of system buffering
    - User process can process one block of data while next block is read in
- For output, when data are being transmitted to a device, they first copied from user space to buffer then will be written to disk.
- Disadvantages:
    - complicates the existing logic in the operating system
    - swapping logic is also affected

#### Stream -Oriented Single Buffer

- Used a line at time OR byte at a time
- User input from a terminal is one line at a time with carriage return signaling the end of the line
- Output to the terminal is one line at a time
- Buffer used to hold a single line
    - User process is suspended during input because waiting for arrival of the entire line.
    - For output user process can place a line of output in the buffer and continue processing.

1. Line-at-a-time operation
    - appropriate for scrollmode terminals (dumb terminals)
    - user input is one line at a time with a carriage return (enter key) signaling the end of a line
    - output to the terminal is similarly one line at a time
2. Byte-at-a-time operation
    - used on forms-mode terminals
    - when each keystroke is significant
    - other peripherals such as sensors and controllers

### Double Buffer

- Use two system buffers instead of one
- A process can transfer data to or from one buffer while the operating system empties or fills the other buffer
- Also known as buffer swapping

### Circular Buffer

- Two or more buffers are used
- Each individual buffer is one unit in a circular buffer
- Used when I/O operation must keep up with process

### summary

- Buffering is a technique that smooth out peaks in I/O demand.
- However no amount of buffering will allow an I/O device to keep pace with a process.
- Even with multiple buffers, all of the buffers will eventually fill up and the process will have to wait after processing each chunk of data.
- In multiprogramming buffering can be a tool that can increase the efficiency of the operating system and the performance of individual processes.

# I/O Scheduling – Disk Performance

## Disk performance parameters

The actual details of disk I/O operation depend on the:
1. Computer system (the architecture)
2. Operating system
3. Nature of the I/O channel and disk controller hardware (scheduling)

## Positioning the Read/Write Heads

[in a hard disk drive](https://www.youtube.com/watch?v=kdmLvl1n82U)

When the disk drive is operating, the disk is rotating at constant speed. To read or write, the head must be positioned at the desired track and at the beginning of the desired sector on that track.
- To read or write, the head must be positioned at the desired track and at the beginning of the desired sector on that track.
- Track selection involves moving the head in a movable-head system or electronically selecting one head on a fixed-head system.
- Seek Time (ST) is the time it takes to position the head at the track.
- Rotational Delay (RD) is the time it takes for the beginning of the sector to reach the head.
- Access Time is the sum of the seek time and the rotational delay (ST + RD).
Once the head is in position, the read or write operation is performed as the sector moves under the head.

Disk performance parameters
- Transfer time is the time required for the transfer

## Disk Scheduling

- Seek time is the reason for differences in performance.(the time it takes to position the head at the track)
- If sector access requests involve selection of tracks at random, then the performance of the disk I/O will be as poor as possible.
- To improve, need to reduce the time spent on seeks
- For a single disk there will be a number of I/O requests (read and write) from various processes in a queue
- If requests are selected randomly -> poor performance

Policies:
- First In First Out
- Priority
- Last In First Out
- Shortest Service Time First (SSTF)
- SCAN
- C-SCAN
- N-Step-SCAN
- FSCAN

E.g.:
- A disk track request: 55, 58, 39, 18, 90, 160, 150, 38, 184
- Head is at track 100
- Head movement - increasing

## First-In, First-Out (FIFO)

- Processes in sequential order
- Fair to all processes
- Approximates random scheduling in performance if there are many processes competing for the disk

## Shortest Service Time First (SSTF)

- Select the disk I/O request that requires the least movement of the disk arm from its current position
- Always choose the minimum seek time

## SCAN

- Also known as the elevator algorithm
- Arm moves in one direction and reverse
- Satisfies all outstanding requests until it reaches the last track in that direction or no more requests in the direction (LOOK), then the direction is reversed
- does NOT exploit locality (i.e., against the area recently traversed)

## C-SCAN

- Restricts scanning to one direction only
- When the last track has been visited in one direction, the arm is returned to the opposite end of the disk and the scan begins again

# Disk Cache

Cache memory is used to apply to a memory that is smaller and faster than main memory and that is interposed between main memory and the processor

- Reduces average memory access time by exploiting the principle of locality
- Disk cache is a buffer in main memory for disk sectors
- Contains a copy of some of the sectors on the disk

When an I/O request is made for a particular sector, a check is made to determine if the sector is in the disk cache
- if YES the request is satisfied via the cache
- if NO the requested sector is read into the disk cache from the disk

## Design Consideration

When a new sector is brought into the disk cache, one of the existing blocks must be replaced.
- Least Recently Used (LRU) – based on access time
- Least Frequently Used (LFU) – based on number of access

### Least Recently Used (LRU)

- Most commonly used algorithm that deals with the design issue of replacement strategy
- The block that has been in the cache the longest with no reference to it is replaced
- A stack of pointers reference the cache
    - most recently referenced block is on the top of the stack
        - when a block is referenced or brought into the cache, it is placed on the top of the stack

Memory Cache
- Block A :Time used: just now
- Block B: Time used: this morning
- Block C: Time used: yesterday(Least Recently Used (LRU))

### Least Frequently Used (LFU)

- The block that has experienced the fewest references is replaced
- A counter is associated with each block
    - Counter is incremented each time block is accessed
- When replacement is required, the block with the smallest count is selected

Memory Cache
- Block A :Time accessed: 137
- Block B: Time accessed: 57
- Block C: Time accessed: 10(Least Frequently Used (LFU))