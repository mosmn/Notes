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


