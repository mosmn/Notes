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
CONCAT (column1 | expression1, column2 expression2) | Concatenates the first character value to the second character value; equivalent to concatenation operator (||)
SUBSTR (column/expression, m[| Returns specified characters from character value ,n]) | starting at character position m, n characters long (If m is negative, the count starts from the end of the character value. If n is omitted, all characters to the end of the string are returned.)
LENGTH (column/expression) | Returns the number of characters in the expression
INSTR (column/expression, 'string', [,m], [n] ) | Returns the numeric position of a named string. Optionally, you can provide a position m to start searching, and the occurrence n of the string. m and n default to 1, meaning start the search at the beginning of the string and report the first occurrence.
LPAD (column expression, n, 'string') | Returns an expression left-padded to length of n characters with a character expression.
RPAD (column | expression, n, 'string') | Returns an expression right-padded to length of n characters with a character expression.
TRIM (leading/trailing/both, trim_character FROM trim_source) | Enables you to trim leading or trailing characters (or both) from a character string. If trim_character or trim_source is a character literal, you must in single quotation marks. This is a feature that is available in and later a no gracies lose itble versions.
REPLACE (text, search_string, replacement_string) | Searches a text expression for a character string and, if four Maces it with a s nt Guspecified replacement string


