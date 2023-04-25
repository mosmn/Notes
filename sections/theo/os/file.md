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

# Organization and
Access