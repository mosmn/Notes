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
A more general way to express the relationship between CookieCost and NumberOfBoxes is to say that CookieCost depends on NumberOfBoxes. Such a statement tells us the character of the relationship between CookieCost and NumberOfBoxes, even though it doesn’t give us the formula. More formally, we can say that CookieCost is __functionally dependent__ on NumberOfBoxes. Such a statement can be written as:
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

- - - -

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

### Composite Determinants

Composite determinant = a determinant of a functional dependency that consists of more than one attribute​
```
(StudentID, CourseID) -> (Grade)
```

## Finding Functional Dependencies

### Functional Dependencies in the SKU_DATA Table
To find functional dependencies in a table, we must ask “Does any column determine the value of another column?” For example, consider the values of the SKU_DATA table in this Figure:

![SKU_DATA Table](/imgs/sku.png)

Consider the last two columns. If we know the value of Department, can we determine a unique value of Buyer? No, we cannot, because a Department may have more than one Buyer. In these sample data, ‘Water Sports’ is associated with Pete Hansen and Nancy Meyers. Therefore, Department does not functionally determine Buyer.

What about the reverse? Does Buyer determine Department? In every row, for a given value of Buyer, do we find the same value of Department? Every time Jerry Martin appears, for example, is he paired with the same department? The answer is yes. Further, every time Cindy Lo appears, she is paired with the same department. The same is true for the other buyers. Therefore, assuming that these data are representative, Buyer does determine Department, and we can write:
```
Buyer -> Department
```
Does Buyer determine any other column? If we know the value of Buyer, do we know the value of SKU? No, we do not, because a given buyer has many SKUs assigned to him or her. Does Buyer determine SKU_Description? No, because a given value of Buyer occurs with many values of SKU_Description.

What about the other columns? It turns out that if we know the value of SKU, we also know the values of all of the other columns. In other words:
```
SKU -> SKU_Description
```
because a given value of SKU will have just one value of SKU_Description. Next,
```
SKU -> Department
```
because a given value of SKU will have just one value of Department. And, finally,
```
SKU -> Buyer
```
because a given value of SKU will have just one value of Buyer. We can combine these three statements as:
```
SKU -> (SKU_Description, Department, Buyer)
```
For the same reasons, SKU_Description determines all of the other columns, and we can write:
```
SKU_Description -> (SKU, Department, Buyer)
```
In summary, the functional dependencies in the SKU_DATA table are:
```
SKU -> (SKU_Description, Department, Buyer)​
SKU_Description -> (SKU, Department, Buyer)​
Buyer -> Department
```

### Functional Dependencies in the ORDER_ITEM Table

Now consider the ORDER_ITEM table in this Figure. For convenience, here is a copy of the data in that table:

![ORDER_ITEM Table](/imgs/oi.png)

What are the functional dependencies in the ORDER_ITEM table? Start on the left. Does OrderNumber determine another column? It does not determine SKU because several SKUs are associated with a given order. For the same reasons, it does not determine Quantity, Price, or ExtendedPrice. 

What about SKU? SKU does not determine OrderNumber because several OrderNumbers are associated with a given SKU. It does not determine Quantity or ExtendedPrice for the same reason. 

What about SKU and Price? From this data, it does appear that
```
SKU -> Price
```
but that might not be true in general. In fact, we know that prices can change after an order has been processed. Further, an order might have special pricing due to a sale or promotion. To keep an accurate record of what the customer actually paid, we need to associate a particular SKU price with a particular order. Thus:
```
(OrderNumber, SKU) -> Price
```
Considering the other columns, Quantity, Price, and ExtendedPrice do not determine anything else. You can decide this by looking at the sample data. You can reinforce this conclusion by thinking about the nature of sales. Would a Quantity of 2 ever determine an OrderNumber or an SKU? This makes no sense. At the grocery store, if I tell you I bought two of something, you have no reason to conclude that my OrderNumber was 1010022203466 or that I bought carrots. Quantity does not determine OrderNumber or SKU. Similarly, if I tell you that the price of an item was $3.99, there is no logical way to conclude what my OrderNumber was or that I bought a jar of green olives. Thus, Price does not determine OrderNumber or SKU. Similar comments pertain to ExtendedPrice. It turns out that no single column is a determinant in the ORDER_ITEM table.

What about pairs of columns? We already know that
```
(OrderNumber, SKU) -> Price
```
Examining the data, (OrderNumber, SKU) determines the other two columns as well. Thus:
```
(OrderNumber, SKU) -> (Quantity, Price, ExtendedPrice)
```
This functional dependency makes sense. It means that given a particular order and a particular item on that order, there is only one quantity, one price, and one extended price. Notice, too, that because ExtendedPrice is computed from the formula ExtendedPrice = (Quantity * Price) we have:
```
(Quantity, Price) -> ExtendedPrice
```
In summary, the functional dependencies in ORDER_ITEM are:
```
(OrderNumber, SKU) -> (Quantity, Price, ExtendedPrice)
(Quantity, Price) -> ExtendedPrice
```


## Keys

A key is a combination of one or more columns that is used to identify rows in a relation.​

A composite key is a key that consists of two or more columns.

### Candidate Keys

A candidate key is a key that determines all of the other columns in a relation. (just like in the SKU_DATA table. the SKU and SKU_Description columns are candidate keys because they determine all of the other columns in the table.)​

Candidate keys identify a unique row in a relation. Given the value of a candidate key, we can find one and only one row in the relation that has that value. For example, given the SKU value of 100100, we can find one and only one row in SKU_DATA. Similarly, given the OrderNumber and SKU values (2000, 101100), we can find one and only one row in ORDER_ITEM.

### Primary Keys

When designing a database, one of the candidate keys is selected to be the primary key. 

This term is used because this key will be defined to the database management system (DBMS), and the DBMS will use it as its primary means for finding rows in a table. A table has only one primary key. The primary key can have one column, or it can be a composite.

in short:
A primary key is a candidate key selected as the primary means of identifying rows in a relation.
- There is only one primary key per relation.​ 
- The primary key may be a composite key.​ 
- The ideal primary key is short, numeric, and never changes.

### Surrogate Keys

A surrogate key is an artificial column added to a relation to serve as a primary key.​
- DBMS supplied​
- Short, numeric, and never changes—an ideal primary key​
- Has artificial values that are meaningless to users​
- Normally hidden in forms and reports

### Foreign Keys

A foreign key is the primary key of one relation that is placed in another relation to form a link between the relations.​
- A foreign key can be a single column or a composite key.​
- The term refers to the fact that key values are foreign to the relation in which they appear as foreign key values.

## The Referential Integrity Constraint

A referential integrity constraint is a statement that limits the values of the foreign key to those already existing as primary key values in the corresponding relation.

Foreign Key with a​ Referential Integrity Constraint:

NOTE: The primary key of the relation is bolded. The foreign key is in italics.

SKU_DATA (__SKU__, SKU_Description, Department, Buyer)​

ORDER_ITEM (__OrderNumber__, *SKU* , Quantity, Price, ExtendedPrice)​

Where ORDER_ITEM.SKU must exist in SKU_DATA.SKU