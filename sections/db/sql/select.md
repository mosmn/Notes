# SELECT statement

The SELECT statement is used to retrieve data from a database. The data is returned in a table-like structure called a result table. e.g.

```sql
SELECT column1, column2
FROM table_name;
```
this will return column1 and column2 from table_name.

```sql
SELECT *
FROM table_name;
```
this will return all columns from table_name.

# Arithmetic Expressions

```sql
SELECT first_name, last_name, salary, salary * 12
FROM employees;
```
this will return the first_name, last_name, salary and salary * 12 from employees. you can also use the following operators:
`+ - * / %`

Operator precedence is the same as in mathematics. e.g. 2 + 3 * 4 = 14

# Null values

its a value that is unknown or undefined. its not the same as 0 or an empty string. e.g.

it will appear as - in the result table or as NULL in the result table.

Arithmetic expressions involving null values will return null.
if you want to return a value instead of null, you can use the COALESCE function.

```sql
SELECT first_name, last_name, salary, COALESCE(salary * 12, 0)
FROM employees;
```
this will return the first_name, last_name, salary and salary * 12 from employees. if salary * 12 is null, it will return 0 instead.

alternatively, you can use the nvl function.

```sql
SELECT first_name, last_name, salary, nvl(salary * 12, 0)
FROM employees;
```

# Column Aliases

used to give a column or expression a temporary name. mostly used with calculated columns. e.g.

```sql
SELECT first_name, last_name, salary, salary * 12 AS annual_salary
FROM employees;
```

can be used without the AS keyword.

```sql
SELECT first_name, last_name, salary, salary * 12 "Annual salary"
FROM employees;
```
quotes are only required if the column name contains spaces or special characters, or case-sensitive(meaning if you want to specify which letter is capital and which one is not).

# Concatenation operator

used to combine two or more strings or columns. e.g.

```sql
SELECT first_name || ' ' || last_name AS full_name
FROM employees;
```
this will return the first_name and last_name combined into one column called full_name.

# Literal character

used to specify a string value. e.g.

```sql
SELECT last_name || ' is a ' || job_id || ' at ' || department_id AS description
FROM employees;
```
this will return the last_name and job_id and department_id combined into one column called description.

# DISTINCT keyword

used to return only distinct (different) values. e.g.

```sql
SELECT DISTINCT department_id
FROM employees;
```
this will return only the different department_id from employees.

# DESCRIBE command

used to get information about a table (or metadata). e.g.

```sql
DESCRIBE employees;
```

or

```sql
DESC employees;
```
will both return the metadata of employees.

Metadata is data about data. e.g. the name of the columns, the data type of the columns, the size of the columns, etc.
