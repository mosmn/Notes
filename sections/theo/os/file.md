# File System and Structure

## What is a file?

In most application the input to the application is by means of a file, and in virtually all applications output is saved in a file for longterm storage and for later access.

Users has to be able to access files, save them and maintain the integrity of their contents.

In managing files, all operating systems provide file management system (FMS).
- Consists of system utility programs that run as privileged applications.
- Need special services from the operating system.

__FILE: Data collections created by users__

3 desirable properties of files:
- Long-term existence - files are stored on disk or other secondary storage and do not disappear when a user logs off
- Sharable between processes - files have names and can have associated access permissions that permit controlled sharing
- Structure - files can be organized into hierarchical or more complex structure to reflect the relationships among files

## File Systems

The File System is one of the most important parts of the OS to a user

Provide a means to store:
1. organized data
2. a collection of authorized operations that can be performed on files

6 Operations:
1. Create - A new file is defined and positioned within the structure of files.
2. Delete - A file is removed from the file structure and destroyed.
3. Open - An existing file is declared to be “opened” by a process, allowing the process to perform functions on the file.
4. Close - The file is closed with respect to a process, so that the process no longer may perform functions on the file, until the process opens the file again.
5. Read - A process reads all or a portion of the data in a file.
6. Write - A process updates a file, either by adding new data that expands the size of the file or by changing the values of existing data items in the file.

## File Structure

Four terms are commonly used when discussing files:
1. Field
- basic element of data
- contains a single value
- length and data type
2. Record
- collection of related fields that can be treated as a unit by some application program
- fixed or variable length
3. File
- collection of similar records
- treated as a single entity
- may be referenced by name
- access control restrictions usually apply at the file level
4. Database
- collection of related data
- relationships among elements of data are explicit
- designed for use by a number of different applications
- consists of one or more types of files

![File Structure](/imgs/fms1.png)

# File Management System (FMS)

__FMS: set of system software that provides services to users and applications in the use of files__

## Minimal User Requirements

Each user:
1. should be able to create, delete, read, write and modify files
2. may have controlled access to other users’ files
3. may control what type of accesses are allowed to the files
4. should be able to restructure the files in a form appropriate to the problem
5. should be able to move data between files
6. should be able to back up and recover files in case of damage
7. should be able to access his or her files by name rather than by numeric identifier

## FMS objectives

1. Meet the data management needs of the user
2. Guarantee that the data in the file are valid
3. Optimize performance (how will the file be accessed/shared?)
4. Provide I/O support for a variety of storage device types
5. Minimize the potential for lost or destroyed data
6. Provide a standardized set of I/O interface routines to user processes
7. Provide I/O support for multiple users in the case of multiple-user systems

# Software Organization for Files

![Software Organization for Files](/imgs/fms2.png)

## Device Drivers

- Lowest level (device communication / machine level)
- Communicates directly with peripheral devices
- Which is the source / destination for files
- Responsible for starting I/O operations on a device
- Processes the completion of an I/O request

## Basic File System

- Also referred to as the physical I/O level
    - Primary interface with the environment outside the computer system
- Deals with blocks of data that are exchanged with disk or tape systems
- Concerned with
    - the placement of blocks on the secondary storage device
    - buffering blocks in main memory

## Basic I/O Supervisor

- Responsible for all file I/O initiation and termination
    - Maintaining Control structures that deal with:
    - device I/O
    - Scheduling
    - file status
- Selects the device on which I/O is to be performed
- Scheduling disk and tape accesses to optimize performance
- I/O buffers are assigned and secondary memory is allocated at this level

## Logical I/O

- Enables users and applications to access records
- Provides general-purpose record I/O capability
- Maintains basic data about files

## Access Method

- Level of the file system closest to the user
- Provides a standard interface between applications and the file systems and devices that hold the data
- Different access methods reflect different file structures and different ways of accessing and processing the data

## File Management Functions

How files are stored and organized by the OS?
Method related to file organization :The piles, index, sequential index etc.

- Users and application program interact with the file system by means of commands for creating and deleting files and for performing operation on files.
- Before performing any operation, it must identify and locate the selected file.
    - Requires the use of some sort of directory that serves to describe the location of all files and their attributes.
- In shared system the user access control is enforce.
    - Only authorized users are allowed to access particular files in particular ways.
- The basic operations that a user or application may perform on a file are performed at the record level.
    - The user or application views the file as having some structure that organizes the records
        - Example as a sequential structure (records are stored alphabetically)
    - To translate user commands into specific file manipulation commands, the access appropriate to this file structure must be employed.
- The record of a file must be stored in a block because I/O is done on a block basis.
    - Record must be block for output and unblocked after input
- To support block I/O of files, several functions are needed and secondary storage must be managed.
    - Disk scheduling and file allocation are concerned with optimizing performance.
    - Need to be considered together.

# File Organization and Access

__File Organization: the logical structuring of the records as determined by the way in which they are accessed__
- Logical = how it is represented by the OS

In choosing a file organization, several criteria are important (more the one method can be chosen):
1. Short access time
2. Ease of update
3. Economy of storage
4. Simple maintenance
5. Reliability

Priority of criteria depends on the application that will use the file

## File Organization Types

- The pile
- The sequential file
- The indexed sequential file
- The indexed file
- The direct, or hashed, file

### The Pile

- Least complicated form of file organization
- Data are collected in the order they arrive (First In Last Out)
- Each record consists of one burst of data
- Purpose is simply to accumulate the mass of data and save it
- Record access is by exhaustive search since there is no proper index

### The Sequential File

- Most common form of file structure
- A fixed format is used for records
- Key field uniquely identifies the record (EXAMPLE: StudentID)
    - records are stored either alphabetical/numerical order
- Typically used in batch applications
    - Read files -> process the files -> Generate report
    - Less human intervention
- Only organization that is easily stored on tape as well as disk

### The Indexed Sequential File

- Adds:
    1. an index to the file to support random access
        - Provides lookup capability to quickly reach desired record
    2. an overflow file
        - Providing pointer from previous record
        - Greatly reduces the time required to access a single record
- Multiple levels of indexing can be used to provide greater efficiency in access

For example, depending on needs file can be indexed based on:
- First Name
- Last Name
- Department
- Major
- Etc.

### The Indexed File

- Records are accessed only through their indexes, each important field is given a separate index.
- For example:
    - Name = index 1, State=index 1b, Major=index 1c
        - Variable-length records can be employed
        - Exhaustive index contains one entry for every record in the main file (studentID + Major + State)
        - Partial index contains entries to records where the field of interest exists (studentID + Major)
- Used mostly in applications where timeliness of information is critical
    - Example:
        - airline reservation systems
        - inventory control systems

### Direct or Hashed File

- Access directly any block of a known address, directly search based on the hashed field value.
- Adds in
    - Hashing based on the key value (example: user age groups, user salary)
    - Hashed is used for integrity checks
- Often used where:
    1. very rapid access is required
    2. fixed-length records are used
    3. records are always accessed one at a time

# File Directories

Associated with any file management system and collection of files is a file directory.

Directory contains information about files
1. Attributes – size, format, creation date
2. Location – where is it on the disc, drives
3. Ownership – creator, owner, editor

Directory itself is a file owned by the operating system
- Provides mapping between file names and the files themselves
- Enables user to easily locate files

## Operations Performed on a Directory

- Search - When a user or application references a file, the directory must be searched to find the entry corresponding to that file.
- Create file - When a new file is created, an entry must be added to the directory.
- Delete file - When a file is deleted, an entry must be removed from the directory.
- List directory - All or a portion of the directory may be requested.
    - Generally, this request is made by a user and results in a listing of all files owned by that user plus some of the attributes of each file (e.g., type, access control information, usage information).
    - plus some of the attributes of each file (e.g., type, access control information, usage information).
- Update directory - Because some file attributes are stored in the directory, a change in one of these attributes requires a change in the corresponding directory entry.

## Directory Schemes

### Two-Level Scheme

- Handling the basic needs for directory management (based on the previous required operations)
- Master directory has an entry for each user directory providing address and access
- There is one control information directory for each user and a master directory
- Directory Scheme
    - Each user directory is a simple list of the files of that user
    - Names must be unique only within the collection of files of a single user
    - File system can easily enforce access restriction on directories

### Hierarchical Scheme

- A more powerful and flexible approach
    - Universally adopted
- Same as two level scheme, there is a master directory with user directories underneath it
- This time, each user directory may have subdirectories and files as entries

# File Sharing and Access Rights

Two issues arise when allowing files to be shared among a number of users:
- access rights
- management of simultaneous access

## Access Rights

- None - the user would not be allowed to read the user directory that includes the file
- Knowledge - the user can determine that the file exists and who its owner is and can then petition the owner for additional access rights
- Execution - the user can load and execute a program but cannot copy it
- Reading - the user can read the file for any purpose, including copying and execution
- Appending - the user can add data to the file but cannot modify or delete any of the file’s contents
- Updating - the user can modify, delete, and add to the file’s data
- Changing protection - the user can change the access rights granted to other users
- Deletion - the user can delete the file from the file system

## Classes of Users

- Owner - usually the initial creator of the file - has full rights - may grant rights to others
- Specific Users - individual users who are designated by user ID
- User Groups - a set of users who are not individually defined
- All - all users who have access to this system - these are public files

## Simultaneous Access

- When access is granted to append or update a file to more than one user, the OS or FMS must enforce discipline.
    - A brute-force approach is to allow a user to lock the entire file when it is to be updated.
    - A finer grain of control is to lock individual records during update.
- Issues of mutual exclusion and deadlock must be addressed in designing the shared access capability.

# Record Blocking 

Blocks are the transfer unit of I/O with secondary storage
- Blocks are needed to store FILES/RECORDS
- for I/O to be performed records must be organized as blocks

Given the size of a block, three methods of blocking can be used:
1. Fixed-Length Blocking
    - fixed-length records are used, and an integral number of records are stored in a block
    - Internal fragmentation – unused space at the end of each block
2. Variable-Length Unspanned Blocking
    - variable-length records are used, but spanning is not employed
3. Variable-Length Spanned Blocking
    - variable-length records are used and are packed into blocks with no unused space

## Fixed-Length Blocking

1. Assumes that the file is large enough to span two tracks.
2. Wasted space due to block size incompatibility

## Variable-Length Unspanned Blocking

1. The record size are varied and cannot span multiple tracks
2. Wasted space in most block because of the inability to use the remainder of a block if the next record is larger than the remaining unused space

# Secondary Storage Management

## File Allocation

On secondary storage, a file consists of a collection of blocks

The operating system or file management system is responsible for allocating blocks to files
1. The approach taken for file allocation may influence the approach taken for free space management
2. Space is allocated to a file as one or more portions (contiguous set of allocated blocks)

File Allocation Table (FAT)
- data structure used to keep track of the portions assigned to a file

## Preallocation vs Dynamic Allocation

Preallocation:
- Requires that the maximum size of a file be declared at the time of the file creation request
- For many applications it is difficult to estimate reliably the maximum potential size of the file
- Tends to be wasteful because users and application programmers tend to overestimate size

Dynamic Allocation:
- Allocates space to a file in portions as needed

## Portion Size

"Portion" refer to space is allocated to a file as one or more contagious units

There is a trade-off between efficiency from the point of view of a single file versus overall system efficiency

Items to be considered:
1. Contiguity of space increases performance
    - Especially for Retrieve_Next operations, and greatly for transactions running in a transaction-oriented operating system
2. Having a large number of small portions increases the size of tables needed to manage the allocation information
    - Having fixed-size portions simplifies the reallocation of space
    - Having variable-size or small fixed-size portions minimizes waste of unused storage due to overallocation

## Alternatives based on the considerations

Two major alternatives:
1. Variable, large contiguous portions (Dynamic)
    - provides better performance
    - the variable size avoids waste
    - the file allocation tables are small
2. Blocks (Fixed)
    - small fixed portions provide greater flexibility
    - they may require large tables or complex structures for their allocation
    - contiguity has been abandoned as a primary goal
    - blocks are allocated as needed

## File Allocation Methods

### Contiguous File Allocation

- to provide:
    - Efficient disk space utilization.
    - Fast access to the file blocks.

- A single contiguous set of blocks is allocated to a file at the time of file creation
- Preallocation strategy using variable-size portions
- Is the best from the point of view of the individual sequential file  fast access because contagious allocation of file blocks
- Inefficient memory utilization  suffer from both internal and external fragmentation
- From time to time, it will be necessary to perform a compaction algorithm to free up additional space on the disk

### Linked / Chained Allocation

- Allocation is on an individual block basis  does not need to be contagious
- Each block contains a pointer to the next block in the chain
- The file allocation table needs just a single entry for each file
- No external fragmentation to worry about
- Best for sequential files
- Flexible in terms of file size, can be increased easily
- No external fragmentation
- one consequence of chaining, is that there is no accommodation of the principle of locality  slower need to traverse all blocks to find a record
- Thus, if it is necessary to bring in several blocks of a file at a time, as in sequential processing, consolidation are required

### Indexed Allocation with Fixed Size Block

- Addresses shortcomings of contiguous and chained allocation
- Here the file allocation table contains a separate one-level index for each file;
    1. the index has one entry for each portion allocated to the file.
    2. Typically, the file indexes are not physically stored as part of the file allocation table.
    3. The file index for a file is kept in a separate block, and the entry for the file in the file allocation table points to that block.

### Indexed Allocation with Variable Size Portions

- Allocation may be on the basis of either fixed-size blocks or variable-size portions.
- Allocation by blocks eliminates external fragmentation, whereas allocation by variable-size portions improves locality.


