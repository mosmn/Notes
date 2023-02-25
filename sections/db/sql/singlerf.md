# Single-Row Functions

These functions operate on single rows only and return one result per row. There are different types of single-row functions. This lesson covers the following functions:
- Character
- Number
- Date
- Conversion
- General

## Character Functions

Single-row character functions accept character data as input and can return both character and numeric values. Character functions can be divided into the following:

### Case-conversion Functions

Function | Purpose
--- | ---
LOWER(column/expression) | Converts alpha character values to lowercase
UPPER(column/expression) | Converts alpha character values to uppercase
INITCAP(column/expression) | Converts alpha character values to uppercase for the first letter of each word; all other letters in lowercase

e.g:
```sql
SELECT LOWER('HELLO') AS lower, UPPER('hello') AS upper, INITCAP('hello world') AS initcap;
```
Output:
```
lower | upper | initcap
------|-------|--------
hello | HELLO | Hello World
```

### Character-manipulation Functions

Function | Purpose
--- | ---
CONCAT (column1/expression1, column2/expression2) | Concatenates the first character value to the second character value; equivalent to concatenation operator (||)
SUBSTR (column/expression, m[,n])| Returns specified characters from character value starting at character position m, n characters long (If m is negative, the count starts from the end of the character value. If n is omitted, all characters to the end of the string are returned.)
LENGTH (column/expression) | Returns the number of characters in the expression
INSTR (column/expression, 'string', [m], [n]) | Returns the numeric position of a named string. Optionally, you can provide a position m to start searching, and the occurrence n of the string. m and n default to 1, meaning start the search at the beginning of the string and report the first occurrence.
LPAD (column/expression, n, 'string') | Returns an expression left-padded to length of n characters with a character expression.
RPAD (column/expression, n, 'string') | Returns an expression right-padded to length of n characters with a character expression.
TRIM (leading/trailing/both, trim_character FROM trim_source) | Enables you to trim leading or trailing characters (or both) from a character string. If trim_character or trim_source is a character literal, you must in single quotation marks. This is a feature that is available in and later a no gracies lose itble versions.
REPLACE (text, search_string, replacement_string) | Searches a text expression for a character string and, if found, replaces it with another character string. The search is case-sensitive.

e.g:
```sql
SELECT CONCAT('Hello', 'World') AS concat, SUBSTR('HelloWorld', 3, 5) AS substr, LENGTH('HelloWorld') AS length, INSTR('HelloWorld', 'World') AS instr, LPAD('HelloWorld', 15, '#') AS lpad, RPAD('HelloWorld', 15, '#') AS rpad, TRIM(LEADING 'X' FROM 'XXXXHelloXWorld') AS trim, REPLACE('HelloWorld', 'World', 'Universe') AS replace;
```

Output:
```
concat | substr | length | instr | lpad | rpad | trim | replace
-------|--------|--------|-------|------|------|------|--------
HelloWorld | lloWo | 10 | 6 | ###HelloWorld | HelloWorld### | HelloXWorld | HelloUniverse
```

## Number Functions

Functions | Purpose
--- | ---
ROUND (column/expression, n) | Rounds a numeric value to n decimal places
TRUNC (column/expression, n) | Truncates a numeric value to n decimal places
MOD (column/expression, n) | Returns the remainder of a division operation

e.g:
```sql
SELECT ROUND(123.456, 2) AS round, TRUNC(123.456, -1) AS trunc, MOD(123, 10) AS mod;
```

Output:
```
round | trunc | mod
------|-------|-----
123.46 | 120 | 3
```

The difference between `ROUND` and `TRUNC` is that `ROUND` rounds the number to the nearest value, while `TRUNC` truncates (means to cut off) the number to the nearest value without rounding.

### DUAL Table

is a public table that you can use to view results from functions and calculations.

e.g:
```sql
SELECT ROUND(34.5678, 2), TRUNC(34.5678, 2), MOD(34.5678, 2)
FROM DUAL;
```

## Date Functions

The Oracle Database stores dates in an internal numeric format: century, year, month, day, hours, minutes, and seconds.

The default date display format is DD-MON-RR.
- Enables you to store 21st-century dates in the 20th century by specifying only the last two digits of the year
- Enables you to store 20th-century dates in the 21st century in the same way

```sql
SELECT last_name, hire_date 
FROM employees 
WHERE hire_date < '01-FEB-88';
```
output:
```
last_name | hire_date
----------|-----------
King | 17-NOV-81
Kochhar | 21-JUN-82
```

### RR date format

If you use the TO_DATE function with the YY datetime format element, then the year returned always has the same first 2 digits as the current year. If you use the RR datetime format element instead, then the century of the return value varies according to the specified two-digit year and the last two digits of the current year.

That is:

If the specified two-digit year is 00 to 49, then:
- If the last two digits of the current year are 00 to 49, then the returned year has the same first two digits as the current year.
- If the last two digits of the current year are 50 to 99, then the first 2 digits of the returned year are 1 greater than the first 2 digits of the current year.

If the specified two-digit year is 50 to 99, then:
- If the last two digits of the current year are 00 to 49, then the first 2 digits of the returned year are 1 less than the first 2 digits of the current year.
- If the last two digits of the current year are 50 to 99, then the returned year has the same first two digits as the current year.

The following examples demonstrate the behavior of the RR datetime format element.

RR Datetime Format Examples
Assume these queries are issued between 1950 and 1999:

```sql
SELECT TO_CHAR(TO_DATE('27-OCT-98', 'DD-MON-RR') ,'YYYY') "Year"
FROM DUAL;
```

Output:
```
Year
----
1998
```

```sql
SELECT TO_CHAR(TO_DATE('27-OCT-17', 'DD-MON-RR') ,'YYYY') "Year"
FROM DUAL;
```

Output:
```
Year
----
2017
```

This data is stored internally as follows:
CENTURY | YEAR | MONTH | DAY | HOUR | MINUTE | SECOND
--------|------|-------|-----|------|--------|-------
19 | 87 | 06 | 17 | 17 | 10 | 43

Centuries and the Year 2000:
When a record with a date column is inserted into a table, the century information is picked up from the SYSDATE function. However, when the date column is displayed on the screen, the century component is not displayed (by default).
The DATE data type uses 2 bytes for the year information, one for century and one for year. The century value is always included, whether or not it is specified or displayed. In this case, RR determines the default value for century on INSERT.


### SYSDATE function

Returns Date and Time

```sql
SELECT SYSDATE 
FROM DUAL;
```

Output:
```
SYSDATE
-------
17-JUN-17
```

#### Arithmetic with Dates

- Add to or subtract a number from a date for a resultant date value.
- Subtract two dates to find the number of days between those dates.
- Add hours to a date by dividing the number of hours by 24.

Example 1:
```sql
SELECT last_name, (SYSDATE - hire_date)/7 AS weeks_since_hired
FROM employees;
```
Output:
```
last_name | weeks_since_hired
----------|------------------
King | 104.142857142857
Kochhar | 98.7142857142857
De Haan | 98.7142857142857
```
the output is in weeks.

Example 2:
```sql
SELECT last_name, (SYSDATE - hire_date)*24 AS hours_since_hired
FROM employees;
```
Output:
```
last_name | hours_since_hired
----------|------------------
King | 2416.57142857143
Kochhar | 2235.42857142857
De Haan | 2235.42857142857
```
the output is in hours.

### Date-manipulation Functions

Function | Purpose
--- | ---
MONTHS_BETWEEN | Number of months between two dates
ADD_MONTHS | Add calendar months to date
NEXT_DAY | Next day of the date specified
LAST_DAY | Last day of the month
ROUND | Round date
TRUNC | Truncate date

e.g:
Function | Result
--- | ---
MONTHS_BETWEEN('01-JAN-2000', '01-JAN-2001') | 12
ADD_MONTHS('01-JAN-2000', 12) | 01-JAN-2001
NEXT_DAY('01-JAN-2000', 'MON') | 03-JAN-2000
LAST_DAY('01-JAN-2000') | 31-JAN-2000

### ROUND and TRUNC functions with dates

Assume that the current date(SYSDATE) is '25-JUL-03'.

Function | Result
--- | ---
ROUND(SYSDATE, 'MONTH') | 01-AUG-03
ROUND(SYSDATE, 'YEAR') | 01-JAN-04
TRUNC(SYSDATE, 'MONTH') | 01-JUL-03
TRUNC(SYSDATE, 'YEAR') | 01-JAN-03

