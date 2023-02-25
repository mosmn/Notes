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






