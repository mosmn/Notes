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
