# Important Relational Model Terms

Entity​

Relation​

Functional dependency​

Determinant​

Candidate key​

Composite key​

Primary key​

Surrogate key​

Foreign key​

Referential integrity constraint

## Entity

An entity is some identifiable thing that users want to track (tangible or intangible):​
- Customers​
- Computers​
- Sales​
- Orders

## Relation

Relational DBMS products store data about entities in relations, which are a special type of table.

A relation is a two-dimensional table that has the following characteristics:​
- Rows contain data about an entity.​
- Columns contain data about attributes of the entity.​
- All entries in a column are of the same kind.​
- Each column has a unique name.​
- Cells of the table hold a single value.​
- The order of the columns is unimportant.​
- The order of the rows is unimportant.​
- No two rows may be identical.

Tables That Are Not Relations:
- Multiple Entries per Cell
- Table with Required Row Order

A Relation with Values​ of Varying Length:
- Even though every cell of a relation must
have a single value, this does not mean that all values must have the same
length. 

![Relation with Values of Varying Length](/imgs/rvvl.png)

This table is a relation even though the length of the Comment column varies from row to row. It is a relation because, even though the comments have
different lengths, there is only one comment per cell.

Alternative Terminology:
- Although not all tables are relations, the terms table and relation are normally used interchangeably.​
- The following sets of terms are equivalent:
![Equivalent Terms](/imgs/att.png)

## Functional Dependency
