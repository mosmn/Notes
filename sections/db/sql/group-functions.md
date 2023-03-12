# Group functions

Group functions operate on sets of rows to give one result per group. The group functions are:
- `AVG`
- `COUNT`
- `MAX`
- `MIN`
- `STDDEV`
- `SUM`
- `VARIANCE`

## Syntax

```sql
SELECT group_function(column_name),......
FROM table_name
WHERE condition;
```

### AVG and SUM

```sql
SELECT AVG(salary), SUM(salary), MIN(salary), MAX(salary)
FROM employees;
WHERE job_id = 'IT_PROG';
```
Output:
```
AVG(salary) | SUM(salary) | MIN(salary) | MAX(salary)
------------+-------------+-------------+------------
  5760      |  11520      |  4200       |  7300
```

### MIN and MAX

```sql
SELECT MIN(hire_date), MAX(hire_date)
FROM employees;
```
Output:
```
MIN(hire_date) | MAX(hire_date)
---------------+---------------
  17-JUN-03    |  17-JAN-04
```

### COUNT

`COUNT (*)` counts all rows in a table, including rows with null values.
```sql
SELECT COUNT(*)
FROM employees;
WHERE department_id = 90;
```
Output:
```
COUNT(*)
---------
  30
```

`COUNT(expr)` counts the number of rows with non-null values in the specified column(expr.)
```sql
SELECT COUNT(job_id)
FROM employees;
WHERE department_id = 90;
```
Output:
```
COUNT(job_id)
--------------
  10
```

#### DISTINCT

`COUNT(DISTINCT expr)` returns the number of distinct non-null values of expr.

To display the number of distinct department values in the EMPLOYEES table:
```sql
SELECT COUNT(DISTINCT department_id)
FROM employees;
```
Output:
```
COUNT(DISTINCT department_id)
------------------------------
  7
```

## Group Functions and Null Values

Group functions ignore null values in the column:
```sql
SELECT AVG(commission_pct)
FROM employees;
```
Output:
```
AVC(COMMISSION_PCT)
--------------------
0.2125
```

The `NVL` function forces group functions to include null values:
```sql
SELECT AVG(NVL(commission_pct, 0))
FROM employees;
```
Output:
```
AVG(NVL(COMMISSION_PCT,0))
---------------------------
 0.0425
```

## Creating Groups of Data

Average salary in the EMPLOYEES table for each department:
```sql
SELECT department_id, AVG(salary)
FROM employees;
GROUP BY department_id;
```
Output:
```
DEPARTMENT_ID | AVG(SALARY)
--------------+-------------
  10          |  8200
  20          |  6500
  30          |  5800
  40          |  6500
```

# GROUP BY

You can divide rows in a table into smaller groups by using the GROUP BY clause.
```sql
SELECT column, group_function (column)
FROM table
[WHERE condition]
[GROUP BY group_by_expression]
[ORDER BY column];
```

All the columns in the SELECT list that are not in group functions must be in the GROUP BY clause.
```sql
SELECT department_id, AVG(salary)
FROM employees
GROUP BY department_id;
```
Output:
```
DEPARTMENT_ID | AVG(SALARY)
--------------+-------------
    (null)    |  7000
      20      |  9500
        30      |  19333.333333333333...
        40      |  10150
        50      |  3500
        60      |  10033.333333333333...
        70      |  4400
        80      |  6400
```

The GROUP BY column does not have to be in the SELECT list.
```sql
SELECT AVG(salary)
FROM employees
GROUP BY department_id;
```

### GROUPING BY MORE THAN ONE COLUMN

Add the salaries in the employees table for each job, grouped by department:
```sql
SELECT department_id, job_id, SUM(salary)
FROM employees
GROUP BY department_id, job_id;
```

### Illegal Queries Using Group Functions

Any column or expression in the SELECT list that is not an aggregate function must be in the GROUP BY clause:
```sql
SELECT department_id, COUNT(last_name)
FROM employees;
```
Output:
```
ORA-00937: not a single-group group function
00937.00000 - "not a single-group group function"
```
A `GROUP BY` clause must be added to count the last names for each department_id.
```sql
SELECT department_id, job_id, COUNT(last_name)
FROM employees
GROUP BY department_id;
```
Output:
```
ORA-00979: not a GROUP BY expression
00979.00000- "not a GROUP BY expression"
```
Either add my id in th GROUP BY or remove the ejob_id column from the 1 list.

- You cannot use the WHERE clause to restrict groups.
- You use the HAVING clause to restrict groups.
- You cannot use group functions in the WHERE clause.
```sql
SELECT department_id, AVG(salary)
FROM employees
WHERE AVG(salary) > 8000
GROUP BY department_id;
```
Output:
```
ORA-00934: group function is not allowed here
00934.00000 - "group function is not allowed here"
Cause:
Action:
Error at Line: 3 Column: 9
```
Cannot use the WHERE clause to restrict groups.


# HAVING

### Restricting Group Results with the HAVING Clause

When you use the HAVING clause, the Oracle server restricts groups as follows:
1. Rows are grouped.
2. The group function is applied.
3. Groups matching the HAVING clause are displayed.
```sql
SELECT column, group_function (column)
FROM table
[WHERE condition]
[GROUP BY group_by_expression]
[HAVING group_condition]
[ORDER BY column];
```

### HAVING Clause Syntax

```sql
SELECT department_id, MAX(AVG(salary))
FROM employees
GROUP BY department_id;
HAVING MAX(AVG(salary)) > 10000;
```

```sql
SELECT job_id, SUM(salary) PAYROLL
FROM employees
WHERE job_id NOT LIKE 'REP%'
GROUP BY job_id
HAVING SUM(salary) > 11000;
ORDER BY SUM(salary);
```

### Nesting Group Functions

```sql
SELECT MAX(AVG(salary))
FROM employees
GROUP BY department_id;
```



