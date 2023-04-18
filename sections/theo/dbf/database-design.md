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


Four Uses for ID-Dependent Entities:
- Representing N:M relationships​
- Representing association relationships​
- Storing multivalued attributes​
- Representing archetype/instance relationships​

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

### 2.6 Identifying relationships with ID-dependent entities (Archetype/Instance Relationships)

The archetype/instance pattern (also called version/instance) occurs when one entity represents a manifestation or an instance of another entity. You have already seen one example of archetype/instance in the example of PAINTING and PRINT in Figure 5-10. The painting is the archetype, and the prints made from the painting are the instances of that archetype.

An archetype is like a model or a template that represents a general idea or concept. An instance is a specific example or manifestation of that archetype. For example, a painting can be an archetype, which represents the general idea or concept of a painting. Prints made from the painting are instances of that archetype because they are specific examples or manifestations of the painting.

![Archetype/Instance Relationships](/imgs/dbd8.png)

### Mixed relationships

the design of mixed entity patterns is a combination of strong entity and ID-dependent entity designs

![Mixed Relationships](/imgs/dbd9.png)

Here the entity EMPLOYEE_SKILL is ID-dependent on EMPLOYEE, but it has a nonidentifying relationship to SKILL.

The database design of the E-R model for the data model in Figure 6-18(a) is shown
in Figure 6-18(b). Notice that EmployeeNumber is both a part of the primary key of
EMPLOYEE_SKILL and a foreign key to EMPLOYEE. The 1:N nonidentifying relationship
between SKILL and EMPLOYEE_SKILL is represented by placing the key of SKILL, which is
SkillName, in EMPLOYEE_SKILL. Note that EMPLOYEE_SKILL.SkillName is a foreign key
but not part of the primary key of EMPLOYEE_SKILL.

### Relationships between supertype/subtype entities

Representing relationships between supertype entities and their subtypes is easy. 

these relationships are also called IS-A relationships because a subtype and its supertype are representations of the same underlying entity. A MANAGER (subtype) is an EMPLOYEE (supertype), and a SALESCLERK (subtype) is also an EMPLOYEE (supertype). 

Because of this equivalence, the keys of all subtype tables are identical to the key of the supertype table.

![Relationships between supertype/subtype entities](/imgs/dbd10.png)

### Recursive relationships (1:1, 1:N, N:M)

#### 1:1

Consider the 1:1 recursive BOXCAR relationship in Figure 6-21(a), which is the same data
model we developed in Figure 5-39. To represent the relationship, we create a foreign key
in BOXCAR that contains the identifier of the boxcar behind, as shown in Figure 6-21(b).
Because the relationship is 1:1, we make the foreign key unique by defining it as unique
(shown here as an alternate key). This restriction enforces the fact that a boxcar can have, at
most, one boxcar behind it.

![1:1](/imgs/dbd11.png)

Notice that both sides of the relationship are optional. This occurs because the last car
on the train has no other car behind it and because the first car on the train is behind no
other car. If the data structure were circular, this restriction would not be necessary. For
example, if you wanted to represent the sequence of names of the calendar months and you
wanted December to lead to January, then you could have a 1:1 recursive structure with
required children.

#### 1:N

As with all 1:N relationships, 1:N recursive relationships are represented by placing the primary key of the parent in the child as a foreign key. Consider the Manages relationship in Figure 6-22(a), which is the data model we developed in Figure 5-41. In this case, we place the name of the manager in each employee’s row. Thus, in Figure 6-22(b), the Employee NameMgr has been added to the EMPLOYEE table.

![1:N](/imgs/dbd12.png)

Notice that both the parent and the child are optional. This is true because the lowestlevel employees manage no one and because the highest-level person, the CEO or other most senior person, has no manager. If the data structure were circular, this would not be the case.

#### N:M

The trick for representing N:M recursive relationships is to decompose the N:M relationship into two 1:N relationships. We do this by creating an intersection table, just as we did for N:M relationships between strong entities.

![N:M](/imgs/dbd13.png)

Figure 6-23(a) is the data model we developed in Figure 5-43. It shows the solution to an example for a bill-of-materials problem. Each part has potentially many subordinate parts, and each part can be used as a component in potentially many other parts. To represent this relationship, create an intersection table that shows the correspondence of a part/part use. You can model upward or downward. If the former, the intersection 

## Specify logic for enforcing minimum cardinality

Relationships can have the following types of minimum cardinality:​
- O-O: parent optional and child optional​
- M-O: parent mandatory and child optional​
- O-M: parent optional and child mandatory​
- M-M: parent mandatory and child mandatory​

We will use the term action to mean a minimum cardinality enforcement action.​

No action needs to be taken for O-O relationships.