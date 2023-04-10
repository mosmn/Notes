# Steps for Transforming a ​Data Model into a Database Design

1. Create a table for each entity:
- Specify the primary key (consider surrogate keys, as appropriate)
- Specify candidate (alternate) keys
- Specify properties for each column:
 - Null status
 - Data type
 - Default value (if any)
 - Data constraints (if any)
- Verify normalization
2. Create relationships by placing foreign keys
- Relationships between strong entities (1:1, 1:N, N:M)
- Identifying relationships with ID-dependent entities (intersection tables,
 association patterns, multivalued attributes, archetype/instance patterns)
- Relationships between a strong entity and a weak but non–ID-dependent
 entity (1:1, 1:N, N:M)
- Mixed relationships
- Relationships between supertype/subtype entities
- Recursive relationships (1:1, 1:N, N:M)
3. Specify logic for enforcing minimum cardinality:
- O-O relationships
- M-O relationships
- O-M relationships
- M-M relationships

## 1. Create a table for each entity

![Entity Relationship Diagram](/imgs/dbd1.png)

### 1.1 Specify the primary key (consider surrogate keys, as appropriate)

- The ideal primary key is short, numeric, and fixed.​
- Surrogate keys meet the ideal, but have no meaning to users.

### 1.2 Specify candidate (alternate) keys

- The terms candidate key and alternate key are synonymous.​
- Candidate keys are alternate identifiers of unique rows in a table.​
- Will use AKn.m notation, where n is the number of the alternate key, and m is the column number in that alternate key.

![Candidate Keys](/imgs/dbd2.png)
In Figure 6-3(b), CustomerNumber is the primary key of CUSTOMER, and both the composite (Name, City) and EmailAddress are
candidate keys.

### 1.3 Specify properties for each column

#### 1.3.1 Null status

Null status indicates whether or not the value of the column can be NULL.

#### 1.3.2 Data type

Generic data types:​
- CHAR(n)​
- VARCHAR(n)​
- DATE​
- TIME​
- MONEY​
- INTEGER​
- DECIMAL

Specify Column Properties:​ Data Type + Null Status

![Data Type](/imgs/dbd3.png)

#### 1.3.3 Default value (if any)

A default value is a value supplied by the DBMS when a new row is created.

The value can be a constant, such as the string ‘New Hire’ for the EmpCode column in EMPLOYEE, or it can be the result of a function, such as the date value of the computer’s clock for the HireDate column.

#### 1.3.4 Data constraints (if any)

Data constraints are limitations on data values:​
- Domain constraint—column values must be in a given set of specific values.​
- Range constraint—column values must be within a given range of values.​
- Intrarelation constraint—column values are limited by comparison to values in other columns in the same table.​
- Interrelation constraint—column values are limited by comparison to values in other columns in other tables (referential integrity constraints on foreign keys).

### 1.4 Verify normalization

The tables should be normalized based on the data model.​ (Table normalization is the process of organizing data in a database in a way that reduces data redundancy and improves data integrity.)

Verify that all tables are:​
- BCNF​(Boyce-Codd Normal Form )
- 4NF(4th Normal Form)

## 2. Create relationships by placing foreign keys

### 2.1 Relationships between strong entities 1:1

- Place the key of one entity in the other entity as a foreign key.​
    - Either design will work—no parent, no child​
    - Minimum cardinality considerations may be important.​
        - O-M will require a different design than M-O.​
        - One design will be very preferable.

![1:1](/imgs/dbd4.png)


### 2.2 Relationships between strong entities 1:N

- Place the primary key of the table on the one side of the relationship into the table on the many side of the relationship as the foreign key.​
- The one side is the parent table and the many side is the child table, so “place the key of the parent in the child.”

### 2.3 Relationships between strong entities N:M

In an N:M strong entity relationship there is no place for the foreign key in either table.​
- A COMPANY may supply many PARTs.​
- A PART may be supplied by many COMPANYs.

Suppose we try to represent this relationship by placing the primary key of one table as a foreign key in the second table, as we did for 1:N relationships. Say we place the primary key of PART in COMPANY as follows:
```
COMPANY (CompanyName, City, Country, Volume, PartNumber)
PART (PartNumber, PartName, SalesPrice, ReOrderQuantity, QuantityOnHand)
```

With this design, a given PartNumber may appear in many rows of COMPANY so that many companies can supply the part. But how do we show that a company can supply many parts? There is only space to show one part. We do not want to duplicate the entire row for a company just to show a second part; such a strategy would result in unacceptable data duplication and data integrity problems. Therefore, this is not an acceptable solution, and a similar problem will occur if 

The solution is to create an intersection table that stores data about the corresponding rows from each entity.​

The intersection table consists only of the primary keys of each table which form a composite primary key.​

Each table’s primary key becomes a foreign key linking back to that table.​

COMPANY_PART_INT (CompanyName, PartNumber)

![N:M](/imgs/dbd5.png)

### 2.4 Identifying relationships with ID-dependent entities (Association Patterns)

An intersection table​
- Holds the relationships between two strong entities in an N:M relationship​
- Contains only the primary keys of the two entities:​
    - As a composite primary key​
    - As foreign keys​

An association table​
- Has all the characteristics of an intersection table​
- PLUS it has one or more columns of attributes specific to the associations of the other two entities

![Association Patterns](/imgs/dbd6.png)
a COMPANY need not have any QUOTATION rows, but a PART must have at least one
QUOTATION row.

### 2.5 Identifying relationships with ID-dependent entities (Multivalued Attributes)

- The third use for ID-dependent entities is to represent multivalued entity attributes. 
- a multivalued attribute is an attribute that can have multiple values for a single entity instance. 
- Multivalued attributes can create problems in database design because they violate the principles of atomicity and normalization. 
- To overcome this problem, we can use ID-dependent entities to represent multivalued attributes. An ID-dependent entity is a separate entity that has a one-to-many relationship with the entity that contains the multivalued attribute.

![Multivalued Attributes](/imgs/dbd7.png)