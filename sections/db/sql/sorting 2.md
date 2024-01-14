# WHERE

to limit the rows selected by the query.

```sql
SELECT column_name(s)
FROM table_name
WHERE column_name = value;
```

character string and date values must be enclosed in single quotes.

```sql
SELECT last_name, first_name
FROM employees
WHERE last_name = 'Smith';
```

```sql
SELECT last_name, hire_date
FROM employees
WHERE hire_date = '1990-01-01';
```

## Comparison Operators

| Operator | Description |
| --- | --- |
| = | Equal |
| <> | Not equal. Note: In some versions of SQL this operator may be written as != |
| > | Greater than |
| < | Less than |
| >= | Greater than or equal |
| <= | Less than or equal |
| BETWEEN | Between a certain range (inclusive) |
| LIKE | Search for a pattern |
| IN | To specify multiple possible values for a column |
| IS NULL | To test for NULL values |

### Greater/Less Than

```sql
SELECT last_name, first_name, salary
FROM employees
WHERE salary <= 60000;
```

### BETWEEN

```sql
SELECT last_name, first_name, salary
FROM employees
WHERE salary BETWEEN 60000 AND 70000;
```

### IN

```sql
SELECT last_name, first_name, salary, manager_id
FROM employees
WHERE manager_id IN (100, 101, 102);
```

### LIKE

- % denotes zero or any number of characters
- _ denotes a single character

```sql
SELECT last_name
FROM employees
WHERE last_name LIKE 'S%';
```
means any last name that starts with S

```sql
SELECT last_name
FROM employees
WHERE last_name LIKE '_o%';
```
means any last name that starts with any character followed by o

### IS NULL

```sql
SELECT last_name, first_name, salary, manager_id
FROM employees
WHERE manager_id IS NULL;
```

## Defining conditions using logical operators

| Operator | Description |
| --- | --- |
| AND | If both the left and right operands are true, then the condition becomes true. |
| OR | If either of the two operands are non-zero, then the condition becomes true. |
| NOT | Used to reverse the logical state of its operand. |

### AND

```sql
SELECT last_name, first_name, salary, manager_id
FROM employees
WHERE salary >= 60000 
AND manager_id IS NULL;
```
will return all employees with salary greater than or equal to 60000 and no manager.

### OR

```sql
SELECT last_name, first_name, salary, manager_id
FROM employees
WHERE salary >= 10000
OR manager_id IS NULL;
```
will return all employees with salary greater than or equal to 10000 or no manager.

### NOT

```sql
SELECT last_name, job_id
FROM employees
WHERE job_id
    NOT IN ('IT_PROG', 'AC_ACCOUNT', 'AD_ASST');
```
will return all employees with job_id not in the list.

## Rules of precedence

ranking:
rank | operator
--- | ---
1 | arithmetic operators
2 | concatenation operator
3 | comparison operators
4 | IS [NOT] NULL, LIKE, [NOT] IN
5 | [NOT] BETWEEN
6 | Not equal to
7 | NOT
8 | AND
9 | OR

You can use parentheses to override the default precedence.

```sql
SELECT last_name, job_id, salary
FROM employees
WHERE job_id = 'IT_PROG'
OR job_id = 'AC_ACCOUNT'
AND salary > 60000;
```
will return all employees with job_id either IT_PROG or AC_ACCOUNT and salary greater than 60000.

```sql
SELECT last_name, job_id, salary
FROM employees
WHERE (job_id = 'IT_PROG'
OR job_id = 'AC_ACCOUNT')
AND salary > 60000;
```
we added parentheses to override the default precedence. so OR will be evaluated first and then AND.

# ORDER BY

- ASC: ascending order, default
- DESC: descending order
order by comes last in the query.

```sql
SELECT last_name, first_name, salary
FROM employees
WHERE salary > 60000
ORDER BY salary;
```

decending order:
```sql
SELECT last_name, first_name, salary
FROM employees
WHERE salary > 60000
ORDER BY salary DESC;
```

sorting by column alias:
```sql
SELECT last_name, first_name, salary * 12 AS annual_salary
FROM employees
WHERE salary > 60000
ORDER BY annual_salary DESC;
```

using columns number:
```sql
SELECT last_name, first_name, salary * 12 AS annual_salary
FROM employees
WHERE salary > 60000
ORDER BY 3 DESC;
```
this will sort by the third column in the select statement.(annual_salary)

sorting by multiple columns:
```sql
SELECT last_name, first_name, salary * 12 AS annual_salary
FROM employees
WHERE salary > 60000
ORDER BY first_name, annual_salary;
```

# Substitution Variables

Used to temporarily store values with single-ampersand (&) prefix and double-ampersand (&&) prefix. used to supplement the following:
- WHERE conditions
- ORDER BY clause
- Column expressions
- Table names
- Entire SELECT statements

## Single-ampersand substitution variables

```sql
SELECT last_name, first_name, salary, department_id
FROM employees
WHERE department_id = &dept_num;
```
it will prompt you to enter a value for &dept_num and then it will execute the query.

in column names:
```sql
SELECT last_name, first_name, job_id, &col_name
FROM employees
WHERE &condition;
ORDER BY &order_by;
```
this will prompt you to enter a value for &col_name, &condition, &order_by.

## Double-ampersand substitution variables

&& will allow you to reuse the varianle value without prompting you each time.

```sql
SELECT last_name, first_name, salary, department_id, &&col_name
FROM employees
ORDER BY &&col_name;
```

## DEFINE

To create and initialize a substitution variable.

```sql
DEFINE dept_num = 90;

SELECT last_name, first_name, salary, department_id
FROM employees
WHERE department_id = &dept_num;

UNDEFINE dept_num;
```
undefine to remove the variable.

## VERIFY

to toggle the display of substitution variables. both before and after developer replaces the variable with a value.

```sql
SET VERIFY ON;
```
