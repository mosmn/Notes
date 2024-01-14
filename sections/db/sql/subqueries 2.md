# Using subquery to solve a problm

Who has a salary greater than Abels?
![e](/imgs/usq1.png)

## Subquery syntax

```sql
SELECT column_name(s)
FROM table_name
WHERE column_name operator
    (SELECT column_name 
    FROM table_name 
    WHERE condition);
```
- The subquery(innner query) executes before the main query(outer query).
- The result of the subquery is used in the main query.

```sql
SELECT last_name, salary
FROM employees
WHERE salary > (SELECT salary
                FROM employees
                WHERE last_name = 'Abel');
```

## Rules for subqueries

- Enclose subqueries in parentheses.
- Place subqueries on the right side of the comparison condition for readability. (However, the subquery can appear on either side of the comparison operator.)
- Use single-row operators with single-row subqueries and multiple-row operators with multiple-row subqueries

## Types of subqueries

- Single-row subqueries
- Multiple-row subqueries

### Single-row subqueries

- Returns only one row
- Use single-row comparison operators

Operator | Meaning
--- | ---
`=`| Equal to
`>`| Greater than
`>=`| Greater than or equal to
`<`| Less than
`<=`| Less than or equal to
`<>`| Not equal to

Executing Single-Row Subqueries

```sql
SELECT last_name, job_id, salary
FROM employees
WHERE job_id =
              (SELECT job_id
              FROM employees
              WHERE last_name = 'Taylor')
AND salary >
              (SELECT salary
              FROM employees
              WHERE last_name = 'Taylor');
```

Using group functions with single-row subqueries:
```sql
SELECT last_name, job_id, salary
FROM employees
WHERE salary >
              (SELECT AVG(salary)
              FROM employees
              WHERE job_id = 'IT_PROG');
```

HAVING Clause with Subqueries:
- The Oracle server executes the subqueries first.
- The Oracle server returns results into the HAVING clause of the main query.

```sql
SELECT department_id, MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) >
    (SELECT MIN(salary)
    FROM employees
    WHERE department_id = 20);
```


### Multiple-row subqueries

- Returns more than one row
- Use multiple-row comparison operators

Operator | Meaning
--- | ---
`IN`| Equal to any value in a list
`ALL`| Must be preceded by a comparison operator(>, <, =, etc.). returns true if the comparison operator is true for all rows in the subquery.
`ANY`| Must be preceded by a comparison operator(>, <, =, etc.). returns true if the comparison operator is true for any row in the subquery.

ANY:
```sql
SELECT last_name, salary
FROM employees
WHERE salary > ANY
              (SELECT salary
              FROM employees
              WHERE job_id = 'IT_PROG');
```

ALL:
```sql
SELECT last_name, salary
FROM employees
WHERE salary > ALL
              (SELECT salary
              FROM employees
              WHERE job_id = 'IT_PROG');
```

IN:
```sql
SELECT last_name, salary
FROM employees
WHERE salary > ANY
              (SELECT salary
              FROM employees
              WHERE job_id = 'IT_PROG');
```
just like using `= ANY`

## EXISTS and NOT EXISTS

These operators simply test whether or not any values are returned by the subquery
- which indicates there are values meeting its conditions.

If one or more values are returned, then values from the subquery are used to run the top-level query.

If no values are returned, the top-level query produces an empty set as the result.

EXISTS:
```sql
SELECT E1.EmployeeNumber, E1.Department, E1.DeptPhone
FROM EMPLOYEE AS E1
WHERE EXISTS
 (SELECT E2.Department
 FROM EMPLOYEE AS E2
 WHERE E1.Department = E2.Department
    AND E1.DeptPhone <> E2.DeptPhone);
```

NOT EXISTS:
```sql
SELECT E1.EmployeeNumber, E1.Department, E1.DeptPhone
FROM EMPLOYEE AS E1
WHERE NOT EXISTS
 (SELECT E2.Department
 FROM EMPLOYEE AS E2
 WHERE E1.Department = E2.Department
    AND E1.DeptPhone <> E2.DeptPhone);
```

# NULL Values in a Subquery

```sql
SELECT emp.last_name
FROM employees emp
WHERE emp.employee_id NOT IN
(SELECT mgr.manager_id
FROM employees mgr);
```
Subquery returns no rows because one of the values returned by a subquery is Null.

Alternatively, a WHERE clause can be included in the subquery to display all employees who do not have any subordinates:
```sql
SELECT last_name FROM employees
WHERE employee_id NOT IN
    (SELECT manager_id
    FROM employees
    WHERE manager_id IS NOT NULL);
```

