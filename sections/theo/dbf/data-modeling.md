# The Data Model

A data model is a plan or blueprint for a database design.​

A data model is more generalized and abstract than a database design.​

It is easier to change a data model than it is to change a database design, so it is the appropriate place to work through conceptual database problems.

## E-R Model

Entity-Relationship model is a set of concepts and graphical symbols that can be used to create conceptual schemas.​

Versions:​ 
- Original E-R model—by Peter Chen (1976)​ 
- Extended E-R model—extensions to the Chen model​ 
- Information Engineering (IE)—by James Martin (1990); uses “crow’s foot” notation, is easier to understand.​ 
- IDEF1X—a national standard developed by the National Institute of Standards and Technology ​ 
- Unified Modeling Language (UML)—by the Object Management Group; it supports object-oriented methodology

## Entities

Something that can be identified and the users want to track:​
- Entity class—a collection of entities of a given type​
  - Entities of a given type are grouped into an entity class. Thus, the EMPLOYEE entity class is the collection of all EMPLOYEE entities.
- Entity instance—the occurrence of a particular entity​

There are usually many instances of an entity in an entity class.

CUSTOMER:​

The Entity Class and Two Entity Instances

![CUSTOMER](/imgs/dme1.png)

## Attributes

Attributes describe an entity’s characteristics.​

All entity instances of a given entity class have the same attributes, but vary in the values of those attributes.​

Originally shown in data models as ellipses.​

Data modeling products today commonly show attributes in rectangular form.

EMPLOYEE:​

Attributes in Ellipses

![EMPLOYEE](/imgs/dme2.png)

Attributes in Entity Rectangle

![EMPLOYEE](/imgs/dme3.png)

## Identifiers

Identifiers are attributes that name, or identify, entity instances.​

The identifier of an entity instance consists of one or more of the entity’s attributes.​

Composite identifiers are identifiers that consist of two or more attributes.​

Identifiers in data models become keys in database designs.​

Entities have identifiers.​

Tables (or relations) have keys.

![IDENTIFIER](/imgs/dme4.png)

Entity Attribute Display​ in Data Models:

![IDENTIFIER](/imgs/dme5.png)

BY THE WAY: Notice the correspondence between identifiers and keys. The term identifier is used in a data model, and the term key (which we have already introduced in our discussion of relational databases in Chapter 3) is used in a database design. Thus, entities have identifiers, and tables (or relations) have keys. Identifiers serve the same role for entities that keys serve for tables.

## Relationships

Entities can be associated with one another in relationships:​
- Relationship classes: associations among entity classes​
- Relationship instances: associations among entity instances​

In the original E-R model, relationships could have attributes, but today this is no longer done.​

A relationship class can involve two or more entity classes.

### Degree of the Relationship

The degree of the relationship is the number of entity classes in the relationship:​
- Two entities have a binary relationship of degree two.​
- Three entities have a ternary relationship of degree three.

Binary Relationship​:

![BINARY](/imgs/dme6.png)

Ternary Relationship​:

![TERNARY](/imgs/dme7.png)

### Entities and Tables

- The principle difference between an entity and a table (relation) is that you can express a relationship between entities without using foreign keys.​
- This makes it easier to work with entities in the early design process where the very existence of entities and the relationships between them is uncertain.

In the E-R model, you can specify a relationship just by drawing a line connecting two entities. Because you are doing logical data modeling and not physical database design, you need not worry about primary and foreign keys, referential integrity constraints, and the like. Most data modeling products will allow you to consider such details if you choose to, but they do
not require it.

This characteristic makes entities easier to work with than tables, especially early in a project when entities and relationships are fluid and uncertain. You can show relationships between entities before you even know what the identifiers are. For example, you can say that a DEPARTMENT relates to many EMPLOYEEs before you know any of the attributes of either EMPLOYEE or DEPARTMENT. This characteristic enables you to work from the general to the specific. First, identify the entities, then think about relationships, and, finally, determine the attributes.

## Cardinality

Cardinality means “count,” and is expressed as a number.​
- Maximum cardinality is the maximum number of entity instances that can participate in a relationship.​
- Minimum cardinality is the minimum number of entity instances that must participate in a relationship.

### Maximum Cardinality

Maximum cardinality is the maximum number of entity instances that can participate in a relationship.​

There are three types of maximum cardinality:​
- One-to-One [1:1]​ - In a 1:1 relationship, an entity instance of one type is related to, at most, one entity instance of the other type
- One-to-Many [1:N]​ - Here a single instance of EMPLOYEE can be associated with many instances of COMPUTER, but a COMPUTER instance is associated with, at most, one instance of EMPLOYEE.
- Many-to-Many [N:M] - According to the Qualification relationship, an EMPLOYEE instance can be associated with many SKILL instances, and a SKILL instance can be associated with many EMPLOYEE instances. This relationship documents the fact that an employee may have many skills and a skill may be held by many employees.

Crows Foot notation:

![CROWSFOOT](/imgs/dme8.png)

Sometimes students wonder why we do not write many-to-many relationships as N:N or M:M. The reason is that cardinality in one direction may be different from the cardinality in the other direction. In other words, in an N:M relationship, N need not equal M. An EMPLOYEE can have five skills, for example, but one of those skills can have three employees. Writing the relationship as N:M highlights the possibility that the cardinalities may be different.

Sometimes the maximum cardinality is an exact number. For example, for a sports team, the number of players on the roster is limited to some fixed number, say, 15. In that case, the maximum cardinality between TEAM and PLAYER would be set to 15 rather than to the more general N.

#### Parent and Child Entities​:

When discussing one-to-many relationships, the terms parent and child are sometimes used. The parent is the entity on the 1 side of the relationship, and the child is the entity on the many side of the relationship. Thus, in a 1:N relationship between DEPARTMENT and EMPLOYEE, DEPARTMENT is the parent and EMPLOYEE is the child (one DEPARTMENT has many EMPLOYEEs).

In a one-to-many relationship:​
- The entity on the one side of the relationship is called the parent entity or just the parent.​
- The entity on the many side of the relationship is called the child entity or just the child.​

In the figure above, USER is the parent and VIDEO is the child

#### HAS-A Relationships​:

The relationships we have been discussing are known as HAS-A relationships:​

Each entity instance has a relationship with another entity instance.​
- A USER has rented one or more VIDEOS.​
- A VIDEO has one borrowed USER.

### Minimum Cardinality​

Minimum cardinality is the minimum number of entity instances that must participate in a relationship.​

Minimums are generally stated as either zero or one:​
- Optional participation. IF zero [0] THEN participation in the relationship by the entity is optional, and no entity instance must participate in the relationship.​
- Mandatory participation. IF one [1] THEN participation in the relationship by the entity is mandatory, and at least one entity instance must participate in the relationship.

Crows Foot notation:

![CROWSFOOT](/imgs/dme9.png)

#### Indicating Minimum Cardinality​:

As shown in the examples in a following [image](#crows-foot-notation-for-minimum-cardinality),​
- Minimum cardinality of zero [0] indicating optional participation is indicated by placing an oval ssnext to the optional entity.​
- Minimum cardinality of one [1] indicating mandatory (required) participation is indicated by placing a vertical hash mark next to the required entity.

#### Reading Minimum Cardinality​:

Look toward the entity in question:​
- IF you see an oval THEN that entity is optional (minimum cardinality of zero [0]).​
- IF you see a vertical hash mark THEN that entity is mandatory (required) (minimum cardinality of one [ 1]).

#### Crows Foot Notation​ for Minimum Cardinality​

To better understand these terms, consider Figure 5-6. In the Employee_Identity relationship in Figure 5-6(a), the hash marks indicate that an EMPLOYEE is required to have a
BADGE, and a BADGE must be allocated to an EMPLOYEE. Such a relationship is referred
to as a mandatory-to-mandatory (M-M) relationship because entities are required on
both sides. The complete specification for the Employee_Identity relationship is that it is a
1:1, M-M relationship.

In Figure 5-6(b), the two small circles indicate that the Computer_Assignment relationship is an optional-to-optional (O-O) relationship. This means that an EMPLOYEE
need not have a COMPUTER and a COMPUTER need not be assigned to an EMPLOYEE.
The Computer_Assignment relationship is thus a 1:N, O-O relationship.

Finally, in Figure 5-6(c), the combination of a circle and a hash mark indicates an
optional-to-mandatory (O-M) relationship. Here an EMPLOYEE must be assigned
to at least one SKILL, but a SKILL may not necessarily be related to any EMPLOYEE. The
complete specification for the Qualification relationship is thus an N:M, O-M relationship.
The positions of the circle and the hash mark are important. Because the circle is next to
EMPLOYEE, it means that the employee is optional in the relationship.

![CROWSFOOT](/imgs/dme10.png)

## Data Modeling Notation:​ IE Crow’s Foot

![CROWSFOOT](/imgs/dme11.png)

### IE Crow’s Foot 1:N

![CROWSFOOT](/imgs/dme12.png)

### IE Crow’s Foot N:M

![CROWSFOOT](/imgs/dme13.png)

# Examples

## Example 1

I want a course registratio database. Store information about my students, including their IDs, names, and emails. A course should have information about course ID, course name, and instructor name.
- How many entities do you need?​
    - Student​
    - Course​
- Draw a diagram for each entity.
```mermaid
classDiagram
    class Student {
      <<entity>>
      +ID (primary key)
      +Name
      +Email
    }
    class Course {
      <<entity>>
      +ID (primary key)
      +Name
      +Instructor
    }
```

## Example 2

I am a the manager for apartment rental office. I want a database to maintain all my apartments. Each apartment building will have a building name, address, city, state, and zip code. A building has many apartments. An apartment has a apartment number, number of bedrooms, number of bathrooms, and rent cost.
- How many entities do you need?​
    - Building​
    - Apartment​
- Draw a diagram for each entity.
```mermaid
classDiagram
    class Building {
      <<entity>>
      +BuildingID (primary key)
      +Name
      +Address
      +City
      +State
      +Zip
    }
    class Apartment {
      <<entity>>
      +BuildingID (primary key)
      +ApartmentID (primary key)
      +NumberOfBed
      +NumberOfBath
      +Rent
    }
```

## ID-Dependent Entities​

An ID-dependent entity is an entity (child) whose identifier includes the identifier of another entity (parent).​

The ID-dependent entity is a logical extension or subunit of the parent:​
- BUILDING : APARTMENT​
- PAINTING : PRINT​

The minimum cardinality from the ID-dependent entity to the parent is always one.

![ID-DEPENDENT](/imgs/dme14.png)

## Weak Entities​

A weak entity is an entity whose existence depends upon another entity.​

All ID-Dependent entities are considered weak.​

There are also non-ID-dependent weak entities.​
- The identifier of the parent does not appear in the identifier of the weak child entity.

![WEAK](/imgs/dme15.png)

# IE Crow’s Foot Symbol Summary I

![CROWSFOOT](/imgs/dme16.png)

# Strong Entity Patterns

## 1:1 Strong Entity Relationships

![1:1](/imgs/dme17.png)

## 1:N Strong Entity Relationships

![1:N](/imgs/dme18.png)

## N:M Strong Entity Relationships

![N:M](/imgs/dme19.png)

# ID-Dependent Relationships

## The Association Pattern

![ASSOCIATION](/imgs/dme20.png)

## The Multivalued Attribute Pattern

![MULTIVALUED](/imgs/dme21.png)
![MULTIVALUED](/imgs/dme22.png)

## Composite Multivalued Attributes

![COMPOSITE](/imgs/dme23.png)

## The Archetype/Instance Pattern

The archetype/instance pattern occurs when the ID-dependent child entity is the physical manifestation (instance) of an abstract or logical parent.​
- PAINTING : PRINT​
- CLASS : SECTION​
- YACHT_DESIGN : YACHT​
- HOUSE_MODEL: HOUSE

![ARCHETYPE](/imgs/dme24.png)
![ARCHETYPE](/imgs/dme25.png)

# Mixed Patterns

## The Line-Item Pattern

![MIXED](/imgs/dme26.png)

## The For-Use-By Pattern

![MIXED](/imgs/dme27.png)

# Recursive Relationships

A recursive relationship occurs when an entity has a relationship to itself.

## 1:1 Recursive Relationship

![RECURSIVE](/imgs/dme28.png)

## 1:N Recursive Relationship

![RECURSIVE](/imgs/dme29.png)

## N:M Recursive Relationship

![RECURSIVE](/imgs/dme30.png)

# EER Model

Since 1980s there has been an increase in emergence of new database applications with more demanding requirements.​

Basic concepts of ER modeling are not sufficient to represent requirements of newer, more complex applications.​

Semantic concepts are incorporated into the original ER model and called the Enhanced Entity-Relationship (EER) model.​

Examples of additional concept of EER model is called specialization / generalization.

## Specialization/Generalization​

Superclass/Supertype​
- An entity type that includes one or more distinct subgroupings of its occurrences.​
- The superclass contains all common attributes.​

Subclass/Subtype​
- A distinct subgrouping of occurrences of an entity type.​
- Subclass contain specific attributes.

Attribute Inheritance​
- An entity in a subclass represents same ‘real world’ object as in superclass, and may possess subclass-specific attributes, as well as those associated with the superclass.​

Specialization​
- Process of maximizing differences between members of an entity by identifying their distinguishing characteristics.​

Generalization​
- Process of minimizing differences between entities by identifying their common characteristics.​

### Subclass with Discriminator

![DISCRIMINATOR](/imgs/dme31.png)

### Subclass: Exclusive or Inclusive

- If subclass are exclusive, one superclass relates to at most one subclass.​
- If subclasses are inclusive, one superclass can relate to one or more subclasses.

![EXCLUSIVE](/imgs/dme32.png)

### IE Crow’s Foot Symbol Summary

![CROWSFOOT](/imgs/dme33.png)
​