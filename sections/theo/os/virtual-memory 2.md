# Hardware and Control Structures

## Terminology

- Virtual memory: A storage allocation scheme in which secondary memory can be addressed as though it were part of main memory. The addresses a program may use to reference memory are distinguished from the addresses the memory system uses to identify physical storage sites, and program-generated addresses are translated automatically to the corresponding machine addresses.The size of virtual storage is limited by the addressing scheme of the computer system and by the amount of secondary memory available and not by the actual number of main storage locations.
- Virtual address: The address assigned to a location in virtual memory to allow that location to be accessed as though it were part of main memory.
- Virtual address space: The virtual storage assigned to a process.
- Address space: The range of memory addresses available to a process.
- Real address: The address of a storage location in main memory.

## Execution of a Process

1. Operating system brings into main memory a few pieces of the program (resident set- portion of process that is in main memory)
2. An interrupt is generated when an address is needed that is not in main memory
3. Operating system places the process in a blocking state
4. Piece of process that contains the logical address is brought into main memory
5. Operating system issues a disk I/O Read request
6. Another process is dispatched to run while the disk I/O takes place
7. An interrupt is issued when disk I/O is complete, which causes the operating system to place the affected process in the Ready state

### Implications of breaking up process into pieces

More processes may be maintained in main
- only load in some of the pieces of each process
- with so many processes in main memory, it is very likely a process will be in the Ready state at any particular time

A process may be larger than all of main memory

## Real and Virtual Memory

Real Memory
- main memory, the actual RAM
Virtual Memory
- memory on disk
- allows for effective multiprogramming and relieves the user of tight constraints of main memory


## Characteristics of Paging and Segmentation

Simple Paging | Virtual Memory Paging | Simple Segmentation | Virtual Memory Segmentation
--- | --- | --- | ---
Main memory partitioned into small fixed-size chunks called frames | Main memory partitioned into small fixed-size chunks called frames | Main memory not partitioned | Main memory not partitioned
Program broken into pages by the compiler or memory management system | Program broken into pages by the compiler or memory management system | Program segments specified by the programmer to the compiler (ie., the decision is made by the programmer) | Program segments specified by the programmer to the compiler (ie., the decision is made by the programmer)
Internal fragmentation within frames | Internal fragmentation within frames | No internal fragmentation | No internal fragmentation
No external fragmentation | No external fragmentation | External fragmentation | External fragmentation
Operating system must maintain a page table for each process showing which frame each page occupies | Operating system must maintain a page table for each process showing which frame each page occupies | Operating system must maintain a segment table for each process showing the load address and length of each segment | Operating system must maintain a segment table for each process showing the load address and length of each segment
Operating system must maintain a free frame list | Operating system must maintain a free frame list | Operating system must maintain a list of free holes in main memory | Operating system must maintain a list of free holes in main memory
Processor uses page number, offset to calculate absolute address | Processor uses page number, offset to calculate absolute address | Processor uses segment number, offset to calculate absolute address | Processor uses segment number, offset to calculate absolute address
All the pages of a process must be in main memory for process to run, unless overlays are used | Not all pages of a process need be in main memory frames for the process to run. Pages may be read in as needed | All the segments of a process must be in main memory for process to run, unless overlays are used | Not all segments of a process need be in main memory for the process to run. Segments may be read in as needed
| |Reading a page into main memory may require writing a page out to disk | | Reading a segment into main memory may require writing one or more segments out to disk 

## Locality and Virtual Memory

To accommodate as many processes as possible, only a few pieces of each process is maintained in main memory.

But main memory may be full so OS will brings one piece in and must swap one piece out.

The OS must not swap out a piece of a process just before that piece is needed.

If it does this too often this leads to trashing:
- The processor spends most of its time swapping pieces rather than executing user instructions

To avoid this, the operating system tries to guess, based on recent history, which pieces are least likely to be used in the near future

### Principle of Locality

The principle that the instruction currently being fetched/executed is very close in memory to the instruction to be fetched/executed next.

so if we keep the most active segments of program and data in the cache, overall execution speed for the program will be optimized.

Our strategy for cache utilization should maximize the number of cache read/write operations, in comparison with the number of main memory read/write operations.

- Program and data references within a process tend to cluster(ie., be close together) in time and space
- Only a few pieces of a process will be needed over a short period of time
- Therefore it is possible to make intelligent guesses about which pieces will be needed in the future, hence Avoids thrashing.

## Support Needed for VM

For virtual memory to be practical and effective:
- Hardware must support paging and segmentation
- OS must include software for managing the movement of pages and/or segments between secondary memory and main memory

## Paging

In simple paging, the page table is loaded into memory when the process is loaded into memory.

Each page table entry contains the frame number of the corresponding page in memory.

With virtual memory scheme, the page table becomes more complex.

Each page table entry contains:
1. Present bit (P)
2. Modify bit (P)
3. Other Control Bits
4. Frame Number

1. Present bit (P)
- To indicate whether the page is in main memory or not.
    - If it is in memory, the entry contains the frame number of the corresponding page in main memory
    - If it is not in memory, the entry may contain the address of that page on disk or the page number may be used to index another table (often in the PCB) to obtain the address of that page on disk.
2. Modify Bit (M)
- Indicate if the page has been altered since it was last loaded into main memory
    - If no change has been made, the page does not have to be written to the disk when it needs to be swapped out
3. Other control bits
- May be present if protection is managed at the page level
    - a read-only/read-write bit
    - protection level bit: kernel page or user page

### Translation of Addresses

When a particular process is running, register holds the starting address of the page table for the process.

The page number of a virtual address is used to index that table to get the frame number.

Than combined it with offset of a virtual address to produce the desired physical address.

![s](/imgs/vm1.png)

### Page Table Structures

Page table is needed when translating the virtual address to physical address.

Page tables are variable in length (depends on process size)
- Must be in main memory instead of registers

There is one page table for each of the process.

But each of process can occupy huge amounts of virtual memory.
- E.g. VAX architecture
    - Process can have up to 2^31 GB of virtual memory
    - Using 2^9=512-byte pages -> 2^22 page tables entries are required perprocess

To overcome this problem, most virtual memory schemes store page tables in virtual memory rather than real memory.
- So, page table is also subject to paging.

When a process is running, at least part of its page table must be in memory.

Approach to organize the page table:
1. Two level scheme
2. Inverted Page Table Structure

### Translation Lookaside Buffer (TLB)

Each virtual memory reference can cause two physical memory accesses:
- one to fetch the page table entry
- one to fetch the data

To overcome the effect of doubling the memory access time, most virtual memory schemes make use of a special high-speed cache called a translation lookaside buffer (TLB)
- Contains page table entries that have been most recently used.
- Works similar to main memory cache.

![s](/imgs/vm2.png)

Given a virtual address, processor examines the TLB (Figure 8.7)
- If page table entry is present (TLB hit), the frame number is retrieved and the physical address is formed
- If page table entry is not found (TLB miss), the page number is used to index the process page table and examine the corresponding PTE.
    - If the present bit is set, then the page is in memory and the processor can retrieve the frame number from the PTE. The processor updates the TLB to include this new PTE.
    - If the present bit is not set, then the desired page is not in memory and a memory access fault called page fault is issued.

Figure 8.8 is a flowchart that shows the use of TLB.
- If the desired page is not in memory, a page fault interrupt causes the page fault handling routine to be invoked.

![s](/imgs/vm3.png)

### Page Size

The smaller the page size, the lesser the amount of internal fragmentation
- However, more pages are required per process
    - more pages per process means larger page tables
    - for large programs in a heavily multiprogrammed environment some portion of the page tables of active processes must be in virtual memory instead of main memory (double page faults)

The physical characteristics of most secondary-memory devices (disks) favor a larger page size for more efficient block transfer of data

The design issue of page size is related to the size of physical main memory and program size

main memory is getting larger and address space used by applications is also growing

most obvious on personal computers where applications are becoming increasingly complex

- Contemporary programming techniques (Object Oriented & multi-threading) used in large programs tend to decrease the locality of references within a process

## Segmentation

Segmantation allow programmer to view memory as consisting of multiple address spaces or segment

Segment may be unequal dynamic size.

Memory references consists of a segment number and offset

Each process has its own segment table

Each segment table entry contains:
1. Present bit (P)
2. Modify bit (P)
3. Other Control Bits

If segment is in main memory, the entry contains the starting address and the length of that segment

Other control bits may be present if protection and sharing is managed at the segment level

Logical to physical address translation is similar to paging except that the offset is added to the starting address (instead of being appended)

The basic mechanism for reading a word from memory involves the translation of a virtual address consisting of a segment number and offset into physical address using segment table.

Size of the segment table depends on the size of the process and we can’t expect to hold it in register and it must be in memory to be accessed.

Fig. 8.12 suggests a hardware implementation of this scheme:
- When a particular process is running, a register holds the starting address of segment table for that process.
- The segment number of a virtual address is used to index that table and look for the corresponding memory address for the start of the segment.
- Then it is added to the offset portion on the virtual address to produce the desired physical address.

![s](/imgs/vm4.png)

## Combined Paging and Segmentation

A memory is broken up into a number of fixed-size frame

A process is:
- Broken up into a number of segments.
- Each segment is broken up into a number of fixed-sized pages which are equal in length to a main memory frame

Segmentation is visible to the programmer

Paging is transparent to the programmer

From a programmer’s point of view, a logical address still consists of a segment number and offset.

From system’s point of view the segment offset is viewed as a page number and page offset for a page within the specified segment.

Each process has:
- one segment table
- several page tables: one page table per segment

The virtual address consist of:
- Segment number: used to index the segment table whose entry gives the starting address of the page table for that segment
- Page number: used to index that page table to obtain the corresponding frame number
- Offset: used to locate the word within the frame

Segment table entry:
1. Length field
2. Base field - is the physical address of the page table of that segment
3. Other control bits is used for sharing and protection purposes.
4. The present and modified bits are not needed because these matters are handled at the page table

Page table entry:
1. Present bit (P)
2. Modify bit (M)
3. Other Control Bits
4. Frame Number.

Protection and sharing info most naturally resides in segment table entry
- Ex: a read-only/read-write bit, a kernel/user bit...

Figure 8.13 suggests a structure to support combined paging/segmentation.
- For each process there is segment table and number of page tables., one per process segment.
- When a process is running, a register holds the starting address of the segment table for that process.
- Presented with a virtual address, the processor uses the segment number portion to index into the process segment to find the page table for that segment.
- Then the page number portion of the virtual address is used to index the page table and look up the corresponding frame number.
- Then, combined it with the offset portion of the virtual address to produce physical address

![s](/imgs/vm5.png)

# Operating System Software

The design of the memory management
portion of an operating system depends on
three fundamental areas of choice:
1. Whether or not to use virtual memory
techniques
2. The use of paging or segmentation or both
3. The algorithms/policy employed for various
aspects of memory management

Issues with Virtual Memory: Performance
- A lot of page faults will drop the system performance

Need to minimize page faults

## Fetch Policy

Determines when a page should be brought into memory

### Demand Paging

- only brings pages into main memory when a reference is made to a location on the page
- many page faults when process is first started
- principle of locality suggests that as more and more pages are brought in, most future references will be to pages that have recently been brought in, and page faults should drop to a very low level

### Pre-paging

- pages other than the one demanded are brought in
- exploits the characteristics of most secondary memory devices
    - if pages of a process are stored contiguously in secondary memory (disk) it is more efficient to bring in a number of pages at one time
    - ineffective if extra pages are not referenced

## Placement Policy

Determines where in real memory a process piece resides

For pure segmentation systems:
- first-fit, next fit, best fit

For paging (and paged segmentation):
- the hardware decides where to place the page, the chosen frame location is irrelevant since all memory frames are equivalent (not an issue)s

## Replacement Policy

Deals with the selection of a page in main memory to be replaced when a new page is brought in

Objective is that the page that is removed will be the page least likely to be referenced in the near future

The more sophisticated the replacement policy, the greater the hardware and software overhead to implement it

Not all pages in main memory can be selected for replacement

Some frames are locked (cannot be paged out) known as Frame Locking:
- kernel of the OS as well as key control structures are held in locked frames
- I/O buffers and time-critical areas may be locked into main memory frames

Locking is achieved by associating a lock bit with each frame

The OS might decide that the set of pages considered for replacement should be:
- limited to those of the process that has suffered the page fault 
- the set of all pages in unlocked frames

The decision for the set of pages to be considered for replacement is related to the resident set management strategy:
- how many page frames are to be allocated to each process?

No matter what is the set of pages considered for replacement, the replacement policy deals with algorithms that will choose the page within that set

Replacement Policy Algorithms
1. Optimal Policy
2. Least recently Used (LRU)
3. First In First Out (FIFO)
4. Clock Policy (not cover in the syllabus)

Example:

Resident Set = 3 frames

The process execution requires a reference to five distinct pages.

The page address stream formed by executing the program is given as below
- 2 3 2 1 5 2 4 5 3 2 5 2
- Pages involve: Page 1, 2, 3, 4 and 5

### Optimal Policy

- Selects the page for which the time to the next reference is the longest
- Impossible to implement because need to have perfect knowledge of future events.
- Produce the fewest number of page faults

### Least Recently Used (LRU)

- Replaces the page that has not been referenced for the longest time
- By the principle of locality, this should be the page least likely to be referenced in the near future
- Difficult to implement
    - one approach is to tag each page with the time of last reference
    - this requires a great deal of overhead

### First In First Out (FIFO)

- Treats page frames allocated to a process as a circular buffer
- Pages are removed in round-robin style
- Simplest replacement policy to implement
- Page that has been in memory the longest is replaced

## Page Buffering

Is a strategy that can improves paging performance and allows the use of a simpler page replacement policy.

A replaced page is not lost, but rather assigned to one of these two lists:
- Free Page List - For page that has been chosen for replacement and has not been modified
- Modified Page List - For page that has been chosen for replacement and has been modified

When a page is to be read in (loaded into the main memory), the page frame at the head of the free page list is used, destroying the page that was there.

When unmodified page is to be replaced, it remains in memory and its page frame is added to the tail of the free page list.

When a modified page is to be written out and replaced, its page frame is added to the tail of the modified page list.

At each page fault the two lists are first examined to see if the needed page is still in main memory

If it is STILL in the memory:
- set back the present bit in the corresponding page table entry
- and remove the matching entry in the relevant page list

If it is NOT in the memory:
- the needed page is brought in, it is placed in the frame pointed by the head of the free frame list
    - overwriting the page that was there
- the head of the free frame list is moved to the next entry

## Cleaning Policy

Concerned with determining when a modified page should be written out to secondary memory (disk)

### Demand Cleaning

- a page is written out to secondary memory only when it has been selected for replacement
- Disadvantages:
    - It minimize page writes, but the page that suffers page fault may have to wait for two page transfer before it can be unblocked.
    - Decrease processor utilization.

### Precleaning

- Writes modified pages before their page frames are needed; allows the writing of pages in batches
- Disadvantages:
    - A page is written out but remains in memory until it has been selected for replacement.
    - Allow writing of pages in batches, but if majority of them have been modified again before they are replaced.
    - The transfer capacity of secondary memory is limited and should not be wasted with unnecessary cleaning operations.

A better approach for cleaning policy by incorporates page buffering.
- Clean only pages that are replaceable.
- The pages on the modified list can periodically be written out in batches and moved to the unmodified list.
- A page in unmodified list is either reclaimed if it is referenced, or lost when its frame is assigned to another page.

