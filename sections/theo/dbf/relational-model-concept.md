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

We begin with a short excursion into the world of algebra. Suppose you are buying boxes of cookies and someone tells you that each box costs $5.00. With this fact, you can compute the cost of several boxes with the following formula:
```
CookieCost = NumberOfBoxes * $5
```
A more general way to express the relationship between CookieCost and NumberOfBoxes is to say that CookieCost depends on NumberOfBoxes. Such a statement tells us the character of the relationship between CookieCost and NumberOfBoxes, even though it doesn’t give us the formula. More formally, we can say that CookieCost is functionally dependent on NumberOfBoxes. Such a statement can be written as:
```
NumberOfBoxes -> CookieCost
```
This expression can be read as “NumberOfBoxes determines CookieCost.” The variable on the left, here NumberOfBoxes, is called the determinant. Using another formula, we can compute the extended price of a part order by multiplying the quantity of the item by its unit price, or:
```
ExtendedPrice = Quantity * UnitPrice
```
In this case, we say that ExtendedPrice is functionally dependent on Quantity and UnitPrice, or:
```
(Quantity, UnitPrice) -> ExtendedPrice
```
Here the determinant is the composite (Quantity, UnitPrice).

- A functional dependency occurs when the value of one (set of) attribute(s) determines the value of a second (set of) attribute(s): ​
```
StudentID -> StudentName​
StudentID -> (DormName, DormRoom, Fee)​
```
The attribute on the left side of the functional dependency is called the determinant.​

- Functional dependencies may be based on equations:​
```
ExtendedPrice = Quantity X UnitPrice​
(Quantity, UnitPrice) -> ExtendedPrice​
```
- Function dependencies are not equations!