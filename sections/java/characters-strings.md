# Characters and Strings

- Declare and manipulate data of the `char` data type.
- Write string processing programs using `String`, `StringBuilder`, and `StringBuffer` objects.
- Differentiate among the three string classes and use the correct class for a given task.
- Specify regular expressions for searching a pattern in a string.
- Use the `Pattern` and `Matcher` classes.
- Compare `String` objects correctly.

---

## Characters

In Java, single characters are represented using the `char` data type. Character constants are written as symbols enclosed in single quotes. Characters are stored in computer memory using some form of encoding. While ASCII is widely used, Java utilizes Unicode, which includes ASCII, for representing `char` constants.

### ASCII Encoding

For example, the character 'O' is represented as 79 (70 + 9).

```plaintext
O
9
70
```

### Unicode Encoding

Java uses the Unicode standard for representing `char` constants. The character 'X' has a Unicode value of 88.

```java
char ch1 = 'X';
System.out.println(ch1);      // X
System.out.println((int) ch1); // 88
```

---

## Character Processing

```java
// Declaration and initialization
char ch1, ch2 = 'X';

// Type conversion between int and char.
System.out.print("ASCII code of character X is " + (int) 'X');

// Comparison of characters
System.out.print("Character with ASCII code 88 is " + (char) 88);
System.out.println("Comparison: 'A' < 'c' is " + ('A' < 'c')); // true
```

---

## Strings

A string is a sequence of characters treated as a single value. Instances of the `String` class are used to represent strings in Java. Individual characters of a string can be accessed using the `charAt` method.

### Accessing Individual Elements

```java
// Individual characters accessed with the charAt method.
String name = "Sumatra";
System.out.println(name);          // Sumatra
System.out.println(name.charAt(3)); // a
```

---

## Example: Counting Vowels

```java
char letter;
System.out.println("Your name:");
String name = scanner.next(); // assume 'scanner' is created properly
int numberOfCharacters = name.length();
int vowelCount = 0;

for (int i = 0; i < numberOfCharacters; i++) {
    letter = name.charAt(i);
    if (letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' ||
        letter == 'i' || letter == 'I' || letter == 'o' || letter == 'O' ||
        letter == 'u' || letter == 'U') {
        vowelCount++;
    }
}

System.out.print(name + ", your name has " + vowelCount + " vowels");
```

---

## Example: Counting 'Java'

```java
int javaCount = 0;
boolean repeat = true;
String word;
Scanner scanner = new Scanner(System.in);

while (repeat) {
    System.out.print("Next word:");
    word = scanner.next();

    if (word.equals("STOP")) {
        repeat = false;
    } else if (word.equalsIgnoreCase("Java")) {
        javaCount++;
    }
}
```

---

## Other Useful String Operators

| Method       | Meaning                                             |
|--------------|------------------------------------------------------|
| `compareTo`  | Compares the two strings.                            |
| `substring`  | Extracts a substring from a string.                  |
| `trim`       | Removes leading and trailing spaces.                 |
| `valueOf`    | Converts a given primitive data value to a string.   |
| `startsWith` | Returns true if a string starts with a specified prefix. |
| `endsWith`   | Returns true if a string ends with a specified suffix.   |

See the `String` class documentation for details.

---

## Quick Check (Q & A)

Determine the output of the following code:

```java
String str = "Programming";

for (int i = 0; i < 9; i += 2) {
    System.out.print(str.charAt(i));
}
```

Output:

```
P r o g r a m m i n g
```

---

## Pattern Example

Suppose students are assigned a three-digit code:
- The first digit represents the major (5 indicates computer science).
- The second digit represents either in-state (1), out-of-state (2), or foreign (3).
- The third digit indicates campus housing (on-campus dorms are numbered 1-7, off-campus represented by the digit 8).

The 3-digit pattern to represent computer science majors living on-campus is `5[123][1-7]`.

### Regular Expressions

A regular expression is a textual pattern used to search in text. Symbols used include brackets `[ ]` for choices, asterisk `*` for zero or more occurrences, plus `+` for one or more occurrences, hat `^` for negation, hyphen `-` for ranges, and parentheses `()` and vertical bar `|` for a range of choices for multiple characters.

---

### Regular Expression Examples

| Expression                    | Description                                            |
|-------------------------------|--------------------------------------------------------|
| `[013]`                       | A single digit 0, 1, or 3.                               |
| `[0-9][0-9]`                  | Any two-digit number from 00 to 99.                      |
| `[0-9&&[^4567]]`              | A single digit that is 0, 1, 2, 3, 8, or 9.              |
| `[a-z0-9]`                    | A single character that is either a lowercase letter or a digit. |
| `[a-zA-z][a-zA-Z0-9_$]*`       | A valid Java identifier consisting of alphanumeric characters, underscores, and dollar signs, with the first character being an alphabet. |
| `[wb](ad|eed)`                 | Matches wad, weed, bad, and beed.                        |
| `(AZ|CA|CO)[0-9][0-9]`        | Matches AZxx, CAxx, and COxx, where x is a single digit. |

---

## Example: Matching Phone Numbers

```java
import java.util.*;

class MatchPhoneNumber {
    private static final String STOP = "0";
    private static final String VALID = "Valid phone number";
    private static final String INVALID = "Not a valid phone number";
    private static final String VALID_PHONE_PATTERN = "[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneStr, reply;

        while (true) {
            System.out.print("Phone#: ");
            phoneStr = scanner.next();

            if (phoneStr.equals(STOP)) break;

            if (phoneStr.matches(VALID_PHONE_PATTERN)) {
               

 reply = VALID;
            } else {
                reply = INVALID;
            }

            System.out.println(phoneStr + ": " + reply + "\n");
        }
    }
}
```

---

## The `replaceAll` Method

The `replaceAll` method replaces all occurrences of a substring that matches a given regular expression with a specified replacement string.

Example:

```java
String originalText, modifiedText;
originalText = ...; // assign string
modifiedText = originalText.replaceAll("[aeiou]", "@");
// Replace all vowels with the symbol '@'
```

---

## The `Pattern` and `Matcher` Classes

The Java regex API consists of two core classes:
- `Pattern` (java.util.regex.Pattern)
- `Matcher` (java.util.regex.Matcher)

`Pattern` is used to create patterns (regular expressions), while `Matcher` is used to match a given regular expression against a text multiple times.

---

## The `Pattern` and `Matcher` Classes (cont.)

Some methods in `Pattern` and `Matcher` classes:

### Pattern (java.util.regex.Pattern)
- `Pattern.matches()`
- `Pattern.compile()`
- `Pattern.matcher()`
- `Pattern.split()`
- `Pattern.pattern()`

### Matcher (java.util.regex.Matcher)
- `Matcher.matches()`
- `Matcher.find()`
- `Matcher.reset()`
- `Matcher.replaceAll()`

The `matches` and `replaceAll` methods of the `String` class are shorthand for using these classes.

---

## The `compile` Method

The `compile` method of the `Pattern` class converts the stated regular expression to an internal format for pattern-matching operations. Using `compile` is more efficient when searching for the same pattern multiple times.

Example:

```java
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(str);
```

---

## The `find` Method

The `find` method of the `Matcher` class searches for the next sequence in a string that matches the pattern and returns true if found. It provides the start and end methods to query the location of the matching sequence.

Example (see Ch9CountJavaPM):

```java
while (matcher.find()) {
    int start = matcher.start();
    int end = matcher.end();
    // Process the matched sequence
}
```

---

## The `String` Class is Immutable

In Java, a `String` object is immutable, meaning it cannot be changed once created. String methods create new strings from the original rather than modifying it. This design choice aims at efficiency.

---

## Effect of Immutability

```java
String str1 = "Hello";
String str2 = str1;
str2 = str2 + " World";
```

We can do this because `String` objects are immutable.

---

## The `StringBuffer` Class

In cases where we need to change the contents of a string, the `StringBuffer` class is used. It allows manipulation of the content of a string, such as replacing a character, appending a string, or deleting a portion.

Example:

```java
StringBuffer word = new StringBuffer("Java");
word.setCharAt(0, 'D');
word.setCharAt(1, 'i');
// Changing "Java" to "Diva"
```

---

## The `append` and `insert` Methods

- The `append` method appends a `String` or `StringBuffer` object to the end of a `StringBuffer` object. It can also take an argument of a primitive data type, converting it to a string before appending.
- The `insert` method inserts a string at a specified position in a `StringBuffer`.

Example:

```java
StringBuffer str = new StringBuffer("Caffeine");
str.insert(0, "Dr. ");
// Result: "Dr. Caffeine"
```

---

## The `StringBuilder` Class

Introduced in Java 5.0 (SDK 1.5), the `StringBuilder` class aims to improve the performance of the `StringBuffer` class. Both classes support the same set of methods, making them interchangeable.

Note: `StringBuilder` is used for all sample applications in this book.

---

## Sample Processing: Replace Vowels

```java
char letter;
String inSentence = JOptionPane.showInputDialog(null, "Sentence:");
StringBuilder tempStringBuilder = new StringBuilder(inSentence);
int numberOfCharacters = tempStringBuilder.length();

for (int index = 0; index < numberOfCharacters; index++) {
    letter = tempStringBuilder.charAt(index);

    if (letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' ||
        letter == 'i' || letter == 'I' || letter == 'o' || letter == 'O' ||
        letter == 'u' || letter == 'U') {
        tempStringBuilder.setCharAt(index, 'X');
    }
}

JOptionPane.showMessageDialog(null, tempStringBuilder);
```