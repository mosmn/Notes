# Data Manipulation Language

A DML statement is executed when you:
- Add new rows to a table
- Modify existing rows in a table
- Remove existing rows from a table A transaction consists of a collection of DML statements that form a logical unit of work.

## INSERT Statement Syntax

Add new rows to a table by using the INSERT statement:
```sql
INSERT INTO table[(column [, column...])]
VALUES (value [, value...]);
```
With this syntax, only one row is inserted at a time.

### Inserting a new row

- insert a new row containg values for each column
- List values in the default order of the columns in the table
- Optionally, list the columns in the INSERT clause.
```sql
INSERT INTO departments (department_id, department_name, manager_id, location_id) 
VALUES (70, 'Public Relations', 100, 1700);
```
1 rows inserted
- Enclose character and date values within single marks.

### Inserting Rows with Null Values

- Implicit method: Omit the column from the column list.
```sql
INSERT INTO departments (department_id, department_name)
VALUES (30, 'Purchasing');
```

- Explicit method: Specify the NULL keyword in the VALUES clause. has a non-transfera
```sql
INSERT INTO departments
VALUES (100, 'Finance', NULL, NULL);
```

### Inserting Special Values

The SYSDATE function records the current date and time.
```sql
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES (113, 'Louis', 'Popp', 'LPOPP', '515.124.4567', SYSDATE, 'AC_ACCOUNT', NULL, 205, 110);
```

### Inserting Specific Date and Time Values

- Add a new employee.
```sql
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES (114, 'Den', 'Raphealy', 'DRAPHEAL', '515.127.4561', TO_DATE('03-FEB-99', 'DD-MON-RR'), 'SA_REP', 11000, 0.2, 100, 60);
```

- Verify your addition.
| | EMPLOYEE ID | FIRST_NAME | LAST NAME | EMAIL | PHONE NUMBER | HIRE DATE | JOB_ID | SALARY | Cansfera COMMISSION_PCT |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
1 | 114 | Den | Raphealy | DRAPHEAL | 515.127.4561 | 03-FEB-99 | SA_REP | 11000 | 0.2 |

### Creating a Script

- Use the & substitution in a SQL statement to prompt for values.
- & is a placeholder for the variable value.
```sql
INSERT INTO departments (department_id, department_name, location_id)
VALUES (&department_id, '&department_name', &location_id);
```

### Copying Rows from Another Table

- Write your INSERT statement with a subquery:
```sql
INSERT INTO sales_reps (id, name, salary, commission_pct)
SELECT employee_id, last_name, salary, commission_pct
FROM employees
WHERE job_id LIKE '%REP%';
```

- Do not use the VALUES clause.
- Match the number of columns in the INSERT clause those in the subquery. non-transf
- Inserts all the rows returned by the subquery in the table, sales_reps.

## UPDATE Statement Syntax

Modify existing values in a table by using the UPDATE statement:
```sql
UPDATE table
SET column = value [, column = value...]
[WHERE condition];
```

### Updating Rows in a Table

- Values for a specific row or rows are modified if you specify the WHERE clause:
```sql
UPDATE employees
SET department_id = 50
WHERE employee_id = 113;
```
- Values for all the rows in the table are modified if you the WHERE clause:
```sql
UPDATE copy_emp
SET department_id = 110;
```
- Specify SET column_ value to NULL.

### Updating Two Columns with a Subquery

Update employee 113's job and salary to match those of employee 205.
```sql
UPDATE employees
SET (job_id, salary) = (SELECT job_id, salary
FROM employees
WHERE employee_id = 205)
WHERE employee_id = 113;
```

## DELETE Statement Syntax

You can remove existing rows from a table by using the DELETE statement:
```sql
DELETE [FROM] table
[WHERE condition];
```

### Deleting Rows from a Table

- Specific rows are deleted if you specify the WHERE clause:
```sql
DELETE FROM departments
WHERE department_name = 'Finance';
```
- All rows in the table are deleted if you omit the WHERE clause:
```sql
DELETE FROM copy_emp;
```

### TRUNCATE Statement

- Removes all rows from a table, leaving the table empty and the table structure intact
- Is a data definition language (DDL) statement rather than a DML statement; cannot easily be undone
- Syntax:
```sql
TRUNCATE TABLE copy_emp;
```
- Example:
```sql
TRUNCATE TABLE copy_emp;
```
