# Traditional file-based system.

A collection of application programs that preform services for the end user, each programe defines and manages its own data.

### Limitations

- Separation and isolation of data: user of set program may be unaware of the existence of other useful programs and data because each program defines and manages its own data.
- Data duplication: data may be duplicated in several programs. results in wasted space and inconsistent data(different values/formats for the same data).
- Data dependency: file structure is defined in the program code, so if the program is changed, the file structure must be changed too.
- Incompatible file formats: written in different languages, so they cant easily share data.
- Fixed queries: written to satisfy specific functions, so any new queries must be added to the program.

# Database approach.

### Database

A collection of logically related data(with description of that data), stored in a manner that allows access, retrieval, and use of that data.

The system catalog, also known as metadata, is a database that contains information about the structure and relationships of data stored in a system. This information includes descriptions of tables, columns, indexes, constraints, and other data elements. The purpose of the system catalog is to provide program-data independence, meaning that the structure of the data can be changed without affecting the programs that use it. This is because the programs use the information in the system catalog to access the data, rather than hard-coding the data's structure into the programs themselves. This allows for more flexible and maintainable software systems, as changes to the data structure can be made without having to make corresponding changes to every program that uses the data.

logically related data refers to the entities, attributes, and relationships that make up the information of an organization. An entity is a real-world object or concept that is being modeled in the data, such as a customer or an order. Attributes are the characteristics or properties of an entity, such as a customer's name or an order's date. Relationships describe how entities are connected to one another, such as a customer having multiple orders or an order belonging to a single customer. By organizing data into entities, attributes, and relationships, it becomes possible to create a logical model of an organization's information that accurately represents the real-world relationships between the data. This model can then be used to support the storage and retrieval of data in a manner that is both efficient and easy to understand.

### Why use database approach?

- Allow the storage of data in one place and eliminate duplications.
- Allow the sharing of data.
- Data is stored in tables, which have rows and columns like a spreadsheet. A database may have multiple tables, where each table stores data about a different thing.
- Each row in a table stores data about an occurrence or instance of the thing of interest.
- A database stores data and relationships.

# Components of database system.

- Database Applications are the computer programs that users work with. A computer program that interacts with database by issuing an appropriate request (SQL statement) to the DBMS.
- The Database Management System (DBMS) creates, processes, and administers databases.
- Structured Query Language (SQL) is an internationally recognized standard database language that is used by all commercial DBMSs.

## Database Applications.

- Create and process Forms.
- Process queries.
- Create and process reports.
- Execute app logic.
- control application.

## Database Management System (DBMS) and its functions.

- Create database
- Create tables
- Create supporting structures (e.g indexes)
- Read database data
- Modify (insert, update or delete)
- database data
- Maintain database structures
- Enforce rules
- Control concurrency
- Provide security
- Perform backup and recovery

Advantages | Disadvantages
--- | ---
Control of data redundancy | Complexity
Data consistency | Size
More information from the same amount of data | Cost of DBMS
Sharing of data | Additional hardware costs
Improved data integrity and security | Cost of conversion
Enforcement of standards | Performance
Improved data accessibility and responsiveness | Higher impact of a failure
Increased productivity |
Improved maintenance through data independence |
Increased concurrency (enables multiple users and access) |
Improved backup and recovery services |

## Structured Query Language (SQL).

# History of database processing.

# Database future trends.
