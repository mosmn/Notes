# Database Objects

Object | Description
---|---
Table | Basic unit of storage; composed of rows
View | Logically represents subsets of data from one or more tables
Sequence | Generates numeric values
Index | Improves the performance of some queries
Synonym | Gives alternative name to an object

# Naming Rules

Table names and column names must:
- Begin with a letter
- Be 1-30 characters long
- Contain only A-Z, a—z, 0—9, _, $, and #
- Not duplicate the name of another object owned by the same user
- Not be an Oracle server-reserved word

# CREATE TABLE

You must have:
- The CREATE TABLE privilege
- A storage area
```sql
CREATE TABLE [schema.] table
(column datatype [DEFAULT expr] [, ...])
```
You specify:
- The table name
- The column name, column data type, and column size

## Refrenceing another user's table

Tables belonging to other users are not in the user's schema.

You should use the owner's name as a prefix to those tables.
- USERA:
```sql
SELECT *
FROM userB.employees;
```
- USERB:
```sql
SELECT *
FROM userA.employees;
```

## DEFAULT option

Specify a default value for a column during an insert.
```sql
... hire_date DATE DEFAULT SYSDATE, ...
```
Literal values, expressions, or SQL functions are legal values.

Another column's name or a pseudocolumn are illegal values.

The default data type must match the column data type.
```sql
CREATE TABLE hire_dates
(id NUMBER (8),
hire_date DATE DEFAULT SYSDATE);
```
