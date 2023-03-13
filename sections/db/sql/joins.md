# Joining Tables Using SQL:1999 Syntax

Use a join to query data from more than one table:

```sql
SELECT tablel.column, table2.column
FROM tablel
[NATURAL JOIN table2] |
[JOIN table2 USING (column_name)] |
[JOIN table2
ON (table1.column_name = table2.column_name)] |
[LEFT RIGHT | FULL OUTER JOIN table2
ON (tablel.column name table2.column_name)] = [CROSS JOIN table2];
```
## Qualifying Ambiguous Column Names

- Use table prefixes to qualify column names that are in multiple tables.
- Use table prefixes to improve performance.
- Instead of full table name prefixes, use table aliases.
- Table alias gives a table a shorter name:
    - Keeps SQL code smaller, uses less memory
- Use column aliases to distinguish columns that have identical names, but reside in different tables.

# Creating Natural Joins

In a natural join, SQL will decide what is the joining condition not the user themselves.

Depending on the column names: SQL will check if there is any column that has the same name in both tables and then it will join the tables based on that column. if no matching column is found, it will return a cartesian product.

- The NATURAL JOIN clause is based on all the columns in the two tables that have the same name.
- It selects rows from the two tables that have equal values in all matched columns.
- If the columns having the same names have different data types, an error is returned.
```sql
SELECT department_id, department_name, location_id, city
FROM departments
NATURAL JOIN locations;
```

# Creating Joins with the USING Clause

- If several columns have the same names but the data types do not match, use the USING clause to specify the columns for the equijoin.
- Use the USING clause to match only one column when more than one column matches.
- The NATURAL JOIN and USING clauses are mutually exclusive.
```sql
SELECT employee_id, last_name, location_id, department_id
FROM employees
JOIN departments USING (department_id);
```
__NOTE: INNER JOIN AND JOIN ARE EQUIVALENT, ANY CAN BE USED__

## Using Table Aliases with the USING Clause

- Do not qualify a column that is used in the USING clause.
- If the same column is used elsewhere in the SQL statement, do not alias it.
```sql
SELECT 1.city, d.department_name
FROM locations 1 JOIN departments d
USING (location_id)
WHERE d.location_id = 1400;
```
Output:
```sql
ORA-25154: column part of USING clause cannot have qualifier
25154. 00000"column part of USING clause cannot have qualifier"
"Cause: Columns that are used for a named-join (either a NATURAL join or a join with a USING clause) cannot have an explicit qualifier. "
"Action: Remove the qualifier. Error at Line: 4 Column: 6
```

# Creating Joins with the ON Clause

- The join condition for the natural join is basically an equijoin of all columns with the same name.
- Use the ON clause to specify arbitrary conditions or specify columns to join.
- The join condition is separated from other search conditions.
- The ON clause makes code easy to understand.
```sql
SELECT e.employee_id, e.last_name, e.department_id,
d.department_id, d.location_id
FROM employees e JOIN departments d --we used aliases for table names to make the SQL statement easier to read.
ON (e.department_id = d.department_id);
```
## Creating Three-Way Joins with the ON Clause

```sql
SELECT employee_id, city, department_name
FROM employees e
JOIN departments d
ON d.department_id = e.department_id
JOIN locations 1
ON d.location_id = 1.location_id;
```

## Applying Additional Conditions to a Join

Use the AND clause or the WHERE clause to apply additional conditions:

```sql
SELECT e.employee_id, e.last_name, e.department_id, d. department_id, d.location_id
FROM employees e JOIN departments d
ON (e.department_id = d.department_id)
WHERE e.manager_id = 149;
```
OR
```sql
SELECT e.employee_id, e.last_name, e.department_id, d. department_id, d.location_id
FROM employees e JOIN departments d
ON (e.department_id = d.department_id)
AND e.manager_id = 149;
```

## Self-Joins Using the ON Clause

```sql
SELECT worker.last_name emp, manager.last_name mgr
FROM employees worker JOIN employees manager
ON (worker.manager_id = manager.employee_id);
```

## Equijoin vs Non-Equijoin

### Equijoin

- An equijoin is a join operation that uses the equality operator to match rows between two tables based on the values of a common column. In other words, an equijoin returns only the rows that have matching values in the specified columns of both tables.
```sql
SELECT e.employee_id, e.last_name, e.department_id, d.department_id, d.location_id
FROM employees e JOIN departments d
ON (e.department_id = d.department_id);
```

### Non-Equijoin

- A nonequijoin is a join operation that uses an operator other than equality (such as less than, greater than, or not equal to) to match rows between two tables. In other words, a nonequijoin returns all rows from one table that have a related row in the other table based on a condition that does not involve equality.
```sql
SELECT e.last_name, e.salary, j.grade_level
FROM employees e JOIN job grades j
ON e.salary 
    BETWEEN j.lowest_sal AND j.highest_sal;
```

# INNER Versus OUTER Joins

- In SQL:1999, the join of two tables returning only matched rows is called an INNER join.
- A join between two tables that returns the results of the INNER join as well as the unmatched rows from the left (or right) table is called a left (or right) OUTER join.
- A join between two tables that returns the results of an INNER join as well as the results of a left and right join is a full OUTER join.

## LEFT OUTER JOIN

- First it will do an inner join and then it will add the unmatched rows from the left table.
- for the unmatch records, the department_id will be null.
```sql
SELECT e.last_name, e.department_id, d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON (e.department_id = d.department_id);
```

## RIGHT OUTER JOIN

- First it will do an inner join and then it will add the unmatched rows from the right table.
- for the unmatch records, the department_id will be null.
```sql
SELECT e.last_name, e.department_id, d.department_name
FROM employees e RIGHT OUTER JOIN departments d
ON (e.department_id = d.department_id);
```

## FULL OUTER JOIN

- First it will do an inner join and then it will add the unmatched rows from both tables.
- for the unmatch records, the department_id will be null.
```sql
SELECT e.last_name, e.department_id, d.department_name
FROM employees e FULL OUTER JOIN departments d
ON (e.department_id = d.department_id);
```

# Cartesian Products

A Cartesian product is formed when:
- A join condition is omitted
- A join condition is invalid
- All rows in the first table are joined to all rows in the second table

Always include a valid join condition if you want to avoid a Cartesian product.

# Creating Cross Joins

- The CROSS JOIN clause produces the cross-product of two tables.
- This is also called a Cartesian product between the two tables.
```sql
SELECT last_name, department_name
FROM employees -- has 6 employees(6 rows)
CROSS JOIN departments; -- has 5 departments(5 rows)

-- The returned result set has 6*5 = 30 rows. CROSS JOIN is going to match every employee with each department.
```
Whenever you have a table that you want to join with another table but there is no common column between them, you can use the CROSS JOIN clause to create a Cartesian product between the two tables.

