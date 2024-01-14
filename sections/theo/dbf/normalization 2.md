# Normalization

Normalization is a technique for producing a set of suitable relations that support the data requirements of an enterprise. ​

The process of analyzing a given relation schema based on their functional dependencies and Primary Key to achieve a minimum redundancy and insertion, deletion and modification anomalies.

Relations that contain redundant information may potentially suffer from update anomalies.  ​

ANOMALIES: Errors that occur when we want to update a table that contains redundant data.​

## Types of update anomalies include​
- Insertion​
- Deletion​
- Modification

Data Redundancy and Update Anomalies:

![r](/imgs/norm1.png)

### Modification Anomalies - INSERTION

StaffBranch relation​(unnormalized)
- Insert new members - must include the details of the branch at which the staff are to be located.​
- Insert new branch with NO staff​
    - Not possible because StaffNo is a primary key – violates ​

Staff and Branch relation​(normalized)
- Can insert new members directly into Staff relation​
- Can insert new branch directly into Branch relation

### Modification Anomalies - DELETION

StaffBranch relation​
- Delete staff SA9​
    - Information on branch B007 will be deleted​

Staff and Branch relation​
- Delete staff SA9​
- the details on branch number B007 remain unaffected in the Branch relation.

### Modification Anomalies - UPDATE

StaffBranch relation​
- Change address for branch B003​
- Need to update all rows related to B003​
- If this modification is not carried out on all the appropriate tuples of the StaffBranch relation, the database will become inconsistent.​ß
​
Branch relation​
- Just change the address for B003 in Branch relation.

## Functional Dependencies

important concept associated with normalization.​

Functional dependency describes relationship between attributes.​

For example, if A and B are attributes of relation R, B is functionally dependent on A (denoted A -> B), if each value of A in R is associated with exactly one value of B in R.

A functionally determines B.​

The determinant of a functional dependency refers to the attribute or group of attributes on the left-hand side of the arrow.​

A is the determinant of B.

1. Full Functional Dependency indicates that if A and B are attributes of a relation, B is fully functionally dependent on A, if B is functionally dependent on A, but not on any proper subset of A.​
```
A,B -> C,D [Full Functional Dependency]​
A -> E [Partial Dependency]​
B -> F, G, H, I [Partial Dependency]​
H -> I [Transitive Dependency]​
```
2. Partial Dependency: depends on part of the key​

3. Transitive Dependency: A -> B, B -> C then A -> C​

Non key attributes can determine other attributes

## NORMALIZATION OF RELATIONS

Definition : The process of analyzing a given relation schema based on their functional dependencies and Primary Key to achieve a minimum redundancy and insertion, deletion and modification anomalies.​

Proposed by Codd, which requires relation schemas to go through ‘series of normal form test’.

NORMALIZATION PROCESS:

![r](/imgs/norm2.png)

### FIRST NORMAL FORM (1NF)

- The relation is in 1NF if any repeating groups have been removed.​
- Each row has only single value for each attribute.

### SECOND NORMAL FORM (2NF)

- A relation that is in 1NF and every non-primary-key attribute is fully functionally dependent on the primary key.​
- Partial dependencies have been removed.

1NF to 2NF​:
- Identify the primary key for the 1NF relation.​
- Identify the functional dependencies in the relation.​
- If partial dependencies exist on the primary key remove them by placing them in a new relation along with a copy of their determinant.

- Functional Dependencies:​
```
clientNo -> cName [Partial] – Remove ​
propertyNo -> pAddress, rent, ownerNo, oName [Partial] – Remove​
clientNo, propertyNo -> rentStart, rentFinish [Full]​
ownerNo, -> oName [Transitive] – not relevant in second normal form​
```
Remove meaning to create a new relation

- From ClientRental relation:​
```
Client (clientNo, cName)​
Property (propertyNo, pAddress, rent, ownerNo, oName)​
Rental (clientNo, propertyNo, rentStart, rentFinish)
```

### THIRD NORMAL FORM (3NF)

- A relation that is in 1NF and 2NF and in which no non-primary-key attribute is transitively dependent on the primary key.​
- Transitive dependencies have been removed.

2NF to 3NF​:
- Identify the primary key in the 2NF relation.​
- Identify functional dependencies in the relation.​
- If transitive dependencies exist on the primary key remove them by placing them in a new relation along with a copy of their determinant.

Relation in 2NF:​
```
Client (clientNo, cName) - Full​
Property (propertyNo, pAddress, rent, ownerNo, oName) ​
ownerNo -> oName [Transitive]​
Rental (clientNo, propertyNo, rentStart, rentFinish) – Full​
```

```
Client (clientNo, cName) ​
Rental (clientNo, propertyNo, rentStart, rentFinish)​
Property (propertyNo, pAddress, rent, ownerNo) ​
Owner (ownerNo, oName)
```