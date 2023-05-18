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

# Creating Tables

Create the table:
```sql
CREATE TABLE dept
(deptno NUMBER (2),
dname VARCHAR2 (14),
loc VARCHAR2 (13),
create_date DATE DEFAULT SYSDATE);
```
Confirm table creation:
```sql
DESCRIBE dept
```
output:
```sql
Name Null Type
----- ---- ----
DEPTNO NOT NULL NUMBER(2)
DNAME NOT NULL VARCHAR2(14)
LOC NOT NULL VARCHAR2(13)
CREATE_DATE NOT NULL DATE
```

## Data Types

Data Type | Description
---|---
VARCHAR2 (size) | Variable-length character data
CHAR (size) | Fixed-length character data
NUMBER (p, s) | Variable-length numeric data
DATE | Date and time values
LONG | Variable-length character data (up to 2 GB)
CLOB | Character data (up to 4 GB)
RAW and LONG RAW | Binary data (up to 4 GB)
BFILE | Binary data stored in an external file (up to 4 GB)
ROWID | A base-64 number system representing the unique address of a row in its table

Guidelines
- A LONG column is not copied when a table is created using a subquery. 
- A LONG column cannot be included in a GROUP BY or an ORDER BY clause.
- Only one LONG column can be used per table. 
- No constraints can be defined on a LONG column.
- You might want to use a CLOB column rather than a LONG column on-transfer

## Datetime Data Types

You can use several datetime data types:
Data Type | Description
---|---
TIMESTAMP | Date with fractional seconds
INTERVAL YEAR TO MONTH | Stored as an interval of years and months(e.g 1 year 2 months)
INTERVAL DAY TO SECOND | Stored as an interval of days, hours, minutes, and seconds(e.g 1 day 2 hours 3 minutes 4 seconds)

## Including Constraints

Constraints enforce rules at the table level.

Constraints prevent the deletion of a table and its contents if there are dependencies.

The following constraint types are valid:
- NOT NULL
- UNIQUE
- PRIMARY KEY
- FOREIGN KEY
- CHECK

### Constraint Guidelines

- You can name a constraint, or the Oracle server generates a name by using the SYS_Cn format.
- Create a constraint at either of the following times:
  - At the same time as the creation of the table
  - After the creation of the table
- Define a constraint at the column or table level.
- View a constraint in the data dictionary.

### Defining Constraint

Syntax:
```sql
CREATE TABLE [schema.] table
    (column datatype [DEFAULT expr]
        [column_constraint],
        [table_constraint] [,...]);
```
Column-level constraint syntax:
```sql
column (datatype [DEFAULT expr] [column_constraint])
```
Table-level constraint syntax:
```sql
column,...
[CONSTRAINT constraint_name] constraint_type
(column,...),
```

Example of a column-level constraint.
```sql
CREATE TABLE employees (
    employee_id NUMBER (6) CONSTRAINT emp_emp_id_pk PRIMARY KEY,
    first_name VARCHAR2(20),
    job_id VARCHAR2(10) NOT NULL);
```
Example of a table-level constraint:
```sql
CREATE TABLE employees (
    employee_id NUMBER(6),
    first_name VARCHAR2(20),
    job_id VARCHAR2(10) NOT NULL,
    CONSTRAINT emp_emp_id_pk PRIMARY KEY(employee_id));
```

### NOT NULL Constraint

- Ensures that null values are not allowed in a column.
- Primary key columns are implicitly NOT NULL.

### UNIQUE Constraint

- Defined at either the column or table level.
- Ensures that all values in a column are unique.

```sql
CREATE TABLE employees (
    employee_id NUMBER (6) CONSTRAINT emp_emp_id_pk PRIMARY KEY,
    first_name VARCHAR2(20),
    job_id VARCHAR2(10) NOT NULL,
    email VARCHAR2(25);
    CONSTRAINT emp_email_uk UNIQUE (email));
```

### PRIMARY KEY Constraint

- Ensures that all values in a column are unique.
- Ensures that a column or set of columns contains a non-null value.

### FOREIGN KEY Constraint

- Defined at either the column or table level.

```sql
CREATE TABLE employees (
    employee_id NUMBER (6) CONSTRAINT emp_emp_id_pk PRIMARY KEY,
    first_name VARCHAR2(20),
    job_id VARCHAR2(10) NOT NULL,
    email VARCHAR2(25);
    CONSTRAINT emp_email_uk UNIQUE (email),
    CONSTRAINT emp_job_id_fk FOREIGN KEY (job_id)
        REFERENCES jobs (job_id));
```

- FOREIGN KEY: Defines the column in the child table at the table-constraint level
- REFERENCES: Identifies the table and column in the parent table  
- ON DELETE CASCADE: Deletes the dependent rows in the child table when a row in the parent table is deleted
- ON DELETE SET NULL: Converts dependent foreign key values to null

### CHECK Constraint

- Defines a condition that each row must satisfy.

- The following expressions are not allowed:
  - References to CURRVAL, NEXTVAL, LEVEL, and ROWNUM pseudocolumns
  - Calls to SYSDATE, UID, USER, and USERENV functions
  - Queries that refer to other values in other rows

```sql
..., salary NUMBER (2)
    CONSTRAINT emp_salary_min
        CHECK (salary > 0),...
```

## CREATE TABLE example

```sql
CREATE TABLE employees
    (employee_id NUMBER (6)
        CONSTRAINT emp_employee_id_pk PRIMARY KEY,
    first_name VARCHAR2 (20),
    last_name VARCHAR2 (25)
        CONSTRAINT emp_last_name_nn NOT NULL,
    email VARCHAR2 (25)
        CONSTRAINT emp_email_nn NOT NULL UNIQUE,
    phone_number VARCHAR2 (20),
    hire_date DATE
        CONSTRAINT emp_hire_date_nn NOT NULL,
    job_id VARCHAR2 (10)
        CONSTRAINT emp_job_nn NOT NULL,
    salary NUMBER (8,2)
        CONSTRAINT emp_salary_nn NOT NULL,
    commission_pct NUMBER (2,2)
        CONSTRAINT emp_commission_pct_ck
            CHECK (commission_pct >= 0),
    manager_id NUMBER (6)
        CONSTRAINT emp_manager_fk
            REFERENCES employees (employee_id)
            ON DELETE SET NULL,
    department_id NUMBER (4)
        CONSTRAINT emp_dept_fk
            REFERENCES departments (department_id)
            ON DELETE CASCADE);
```

## Violating Constraints

```sql
UPDATE employees
SET department_id = 55
WHERE department_id = 110;
```
output:
```bash
Error starting at line 1 in command:
UPDATE employees
SET department_id=55
WHERE department id 110 Error report:
SQL Error: ORA-02291: integrity constraint (ORA1.EMP_DEPT_FK) violated parent key not found 02291. 00000"integrity constraint (s.xs) violated parent key not found" "Cause: A foreign key value has no matching primary key value. *Action: Delete the foreign key or add a matching primary key. has
Department 55 does not exist.
```
Department 55 does not exist.

# Creating tables using a subquery

Create a table and insert rows by combining the CREATE TABLE statement and the AS subquery option.
```sql
CREATE TABLE table
    [(column, column...)]
AS subquery;
```
Match the number of specified columns to the number of subquery columns.

Define columns with column names and default values.

```sql
CREATE TABLE dept80
    AS
        SELECT employee_id, last_name, salary*12 ANNSAL
            FROM employees
            WHERE department_id = 80;
```
output:
```bash
Name Null Type
-------------------------- -------- ----------------------------
EMPLOYEE_ID NOT NULL NUMBER
LAST_NAME NOT NULL VARCHAR2(25)
ANNSAL NOT NULL NUMBER
```

# ALTER TABLE statement

Use the ALTER TABLE statement to:
- Add a new column
- Modify an existing column definition
- Define a default value for the new column
- Drop a column
- Rename a column
- Change table to read-only status

1. Add a new column:
To add a new column to an existing table, use the following syntax:

```
ALTER TABLE table_name ADD column_name data_type;
```

For example, to add a new column called "phone_number" of type VARCHAR(20) to a table called "customers", use the following statement:

```
ALTER TABLE customers ADD phone_number VARCHAR(20);
```

2. Modify an existing column definition:
To modify the definition of an existing column, use the following syntax:

```
ALTER TABLE table_name MODIFY column_name new_data_type;
```

For example, to change the data type of a column called "age" from INT to SMALLINT in a table called "employees", use the following statement:

```
ALTER TABLE employees MODIFY age SMALLINT;
```

3. Define a default value for a new column:
To define a default value for a new column, use the following syntax:

```
ALTER TABLE table_name ADD column_name data_type DEFAULT default_value;
```

For example, to add a new column called "status" of type VARCHAR(10) with a default value of "active" to a table called "orders", use the following statement:

```
ALTER TABLE orders ADD status VARCHAR(10) DEFAULT 'active';
```

4. Drop a column:
To drop an existing column from a table, use the following syntax:

```
ALTER TABLE table_name DROP COLUMN column_name;
```

For example, to drop a column called "address" from a table called "customers", use the following statement:

```
ALTER TABLE customers DROP COLUMN address;
```

5. Rename a column:
To rename an existing column in a table, use the following syntax:

```
ALTER TABLE table_name RENAME COLUMN old_column_name TO new_column_name;
```

For example, to rename a column called "product_code" to "item_code" in a table called "products", use the following statement:

```
ALTER TABLE products RENAME COLUMN product_code TO item_code;
```

6. Change table to read-only status:
To change a table to read-only status, use the following syntax:

```
ALTER TABLE table_name READ ONLY;
```

For example, to make a table called "sales" read-only, use the following statement:

```
ALTER TABLE sales READ ONLY;
```

7. Rename a table:
To rename an existing table in a database, use the following syntax:

```
ALTER TABLE old_table_name RENAME TO new_table_name;
```

For example, to rename a table called "customers" to "clients", use the following statement:

```
ALTER TABLE customers RENAME TO clients;
```

8. Rename a column:
To rename an existing column in a table, use the following syntax:

```
ALTER TABLE table_name RENAME COLUMN old_column_name TO new_column_name;
```

For example, to rename a column called "emp_name" to "full_name" in a table called "employees", use the following statement:

```
ALTER TABLE employees RENAME COLUMN emp_name TO full_name;
```

## Read-Only Tables

You can use the ALTER TABLE syntax to:
- Put a table into read-only mode, which prevents DDL or DML changes during table maintenance
- Put the table back into read/write mode

```sql
ALTER TABLE employees READ ONLY;
-- perform table maintenance and then
-- return table back to read/write mode
ALTER TABLE employees READ WRITE;
```

## Dropping a Table

- Moves a table to the recycle bin
- Removes the table and all its data entirely if the PURGE clause is specified
- Invalidates dependent objects and removes object privileges on the table

```sql
DROP TABLE employees;
```

with PURGE:
```sql
DROP TABLE employees PURGE;
```