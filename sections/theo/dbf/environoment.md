# Database System Environment

DB systems refers to an organization of components that define and regulate thr collection, storage, management and use of data. The components of a DB system are:
1. hardware
2. software
3. people
4. procedures
5. data

## Hardware

- Identifies all the systems physical devices. includes computers, computer peripherals(like printers, scanners, etc), network components, etc.

## Software

- Its the collection of programs used within the DB system. It includes the OS, DBMS, and other programs.
    - OS, manages the hardware resources and provides an environment for the execution of programs.
    - DBMS, manages the DB and provides an environment for the execution of DB applications.
    - Application programs, are programs that use the DBMS to access and manipulate data and to manage the operating environment of the DB.

## People

- Includes all users associated with the DB system. They are the ones who use the DB system to perform their tasks.

- Five types of users:(there are many more)
    - System administrators, oversees the DB system general operations.
    - Data modelers(architects), designs the DB structure based on the requirements of the organization.
    - DB administrators, physically implement the DB according to the logical design and maintain the DB.
    - System analysts and programmers, develop the application programs that use the DB.
    - End users, use the DB system to perform their tasks. e.g in a banking system, the end users are the customers. 

## Procedures

- Are instructions and business rules that govern the design and use of the DB system.
- Procedures enforce the standerds by which business is conducted within the organization and with customers.

## Data

- Data are the collection of raw facts stored in the database.

- To enter appropriate data into the database and how such data are to be organized is a vital part of the database designer’s job.​

# ANSI-SPARC architecture

- Its an abstract design standard for a DBMS first proposed 1975.
- Most modren commercial DBMSs are based on this system. however, it never became an formal industry standard.

It consists of 3 layers:
1. External level, how data is viewed by an individual user.(viewed based on the user's needs, e.g shanging an attribute name aka aliasing)
2. Conceptual level, how data is viewed by A community of users.(original data)
3. Internal level, how data is physically stored.

- The whole point of this architecture is to ensure data independence, that means if one layer is changed, the other layers are not affected.

Objectives of the architecture:
- allow all users to access the same data.
- make sure a users view is immune(meaning unaffected) to changes made by other users.
- allow DBA (database administrator) to change the conceptual/internal level without affecting the external level.
- ensure the internal structure is unaffected by changes to the physical aspects of the storage.
- users can use the DB without needing to know the physical storage details.

Again, all these objectives are required to achieve data independence.
- Logical data independence, conceptual schema changes should not require changes to the external schema.
- Physical data independence, internal schema changes should not require changes to the conceptual schema.



