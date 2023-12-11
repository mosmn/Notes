# Array Basics

An array is a collection of data values. If your program needs to deal with 100 integers, 500 Account objects, 365 real numbers, etc., you will use an array. In Java, an array is an indexed collection of data values of the same type.

## Arrays of Primitive Data Types

### Array Declaration

```java
<data type> [] <variable> // Variation 1
<data type> <variable>[] // Variation 2
```

### Array Creation

```java
<variable> = new <data type> [ <size> ]
```

#### Example

```java
// Variation 1
double[] rainfall;
rainfall = new double[12];

// Variation 2
double rainfall[];
rainfall = new double[12];
```

An array is like an object!

## Accessing Individual Elements

Individual elements in an array are accessed with the indexed expression.

```java
double[] rainfall = new double[12];

// The index of the first position in an array is 0.
// Indices: 0 1 2 3 4 5 6 7 8 9 10 11
double value = rainfall[2]; // Refers to the element at position 2
```

## Array Processing – Sample

```java
Scanner scanner = new Scanner(System.in);
double[] rainfall = new double[12];
double annualAverage, sum = 0.0;

for (int i = 0; i < rainfall.length; i++) {
    System.out.print("Rainfall for month " + (i + 1));
    rainfall[i] = scanner.nextDouble();
    sum += rainfall[i];
}

annualAverage = sum / rainfall.length;
```

The public constant `length` returns the capacity of an array.

## Array Initialization

Like other data types, it is possible to declare and initialize an array at the same time.

```java
int[] number = { 2, 4, 6, 8 };

double[] samplingData = { 2.443, 8.99, 12.3, 45.009, 18.2, 9.00, 3.123, 22.084, 18.08 };

String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
```

## Variable-size Declaration

In Java, we are not limited to fixed-size array declaration. The following code prompts the user for the size of an array and declares an array of designated size:

```java
Scanner scanner = new Scanner(System.in);
int size;
int[] number;

System.out.print("Size of an array:");
size = scanner.nextInt();
number = new int[size];
```

## Arrays of Objects

In Java, in addition to arrays of primitive data types, we can declare arrays of objects. An array of primitive data is a powerful tool, but an array of objects is even more powerful. The use of an array of objects allows us to model the application more cleanly and logically.

## The Person Class

We will use Person objects to illustrate the use of an array of objects (Person class is in Person.java).

```java
Person latte;
latte = new Person();
latte.setName("Ms. Latte");
latte.setAge(20);
latte.setGender('F');

System.out.println("Name: " + latte.getName());
System.out.println("Age : " + latte.getAge());
System.out.println("Sex : " + latte.getGender());
```

Creating an Object Array - 1:

```java
Person[] person;
person = new Person[20];
```

Creating an Object Array - 2:

```java
Person[] person;
person = new Person[20];
person[0] = new Person();
```

Creating an Object Array - 3:

```java
Person[] person;
person = new Person[20];
person[0] = new Person();
```

## Person Array Processing – Sample 1

Create Person objects and set up the person array.

```java
String name, inpStr; 
int age; 
char gender;
Scanner scanner = new Scanner(System.in);

for (int i = 0; i < person.length; i++) {
    System.out.print("Enter name:");
    name = scanner.next();
    System.out.print("Enter age:");
    age = scanner.nextInt();
    System.out.print("Enter gender:");
    inpStr = scanner.next();
    gender = inpStr.charAt(0);

    person[i] = new Person(name, age, gender);
    person[i].setName(name);
    person[i].setAge(age);
    person[i].setGender(gender);
}
```

## Person Array Processing – Sample 2

Find the youngest and oldest persons using index.

```java
int minIdx = 0; // index to the youngest person
int maxIdx = 0; // index to the oldest person

for (int i = 1; i < person.length; i++) {
    if (person[i].getAge() < person[minIdx].getAge()) {
        minIdx = i; // found a younger person
    }
    if (person[i].getAge() > person[maxIdx].getAge()) {
        maxIdx = i; // found an older person
    }
}

// person[minIdx] is the youngest and person[maxIdx] is the oldest
```

## Object Deletion – Approach 1

```java
int delIdx = 1;
person[delIdx] = null;
```

Delete Person B by setting the reference in position 1 to null.

## Object Deletion – Approach 2

```java
int delIdx = 1, last = 3;
person[delIdx] = person[last];
person[last] = null;
```

Delete Person B by setting the reference in position 1 (delIdx) to the last person.

## Person Array Processing – Sample 3

Searching for a particular person using Approach 2 Deletion.

```java
int i = 0;

while (person[i] != null && !person[i].getName().equals("Latte")) {
    i++;
}

if (person[i] == null) {
    // not found - unsuccessful search
    System.out.println("Ms. Latte was not in the array");
} else {
    // found - successful search
    System.out.println("Found Ms. Latte at position " + i);
}
```

## The For-Each Loop

This new for loop is available from Java 5.0. The for-each loop simplifies the processing of elements in a collection.

Syntax: `for(variable : arrayname)`

```java
int sum = 0;

// Standard for loop
for (int i = 0; i < number.length; i++) {
    sum = sum + number[i];
}

// For-each loop
int sum = 0;
for (int value : number) {
    sum = sum + value;
}
```

### Processing an Array of Objects with For-Each

```java
for (int i = 0; i < person.length; i++) {
    System.out.println(person[i].getName());
}

// For-each loop
for (Person p : person) {
    System.out.println(p.getName());
}
```

## For-Each: Key Points to Remember

- A for-each loop supports read access only. The elements cannot be changed.
- A single for-each loop allows access to a single array only, i.e., you cannot access multiple arrays with a single for-each loop.
- A for-each loop iterates over every element of a collection from the first to the last element. You cannot skip elements or iterate backward.

## Passing Arrays to Methods

### Sample Method

```java
class TestArray {
    static void min(int arr[]) {
        int min = arr[0];

        for (int num : arr) { // for-each loop
            if (min > num)
                min = num;
        }

        System.out.println(min);
    }

    public static void main(String args[]) {
        int a[] = { 23, 24, 25, 26 };
        min(a); // passing array to method
    }
}
```

## Two-Dimensional Arrays

Two-dimensional arrays are useful in representing tabular information.

### Declaring and Creating a 2-D Array

#### Declaration

```java
<data type> [][] <variable> // Variation 1
<data type> <variable>[][] // Variation 2
```

#### Creation

```java
<variable> = new <data type> [ <size1> ][ <size2> ]
```

### Example

```java
double[][] payScaleTable;
payscaleTable = new double[4][5];
```

### Accessing an Element

An element in a two-dimensional array is accessed by its row and column index.

### Sample 2-D Array Processing

Find the average of each row.

```java
double[] average = { 0.0, 0.0, 0.0, 0.0 };

for (int i = 0; i < payScaleTable.length; i++) {
    for (int j = 0; j < payScaleTable[i].length; j++) {
        average[i] += payScaleTable[i][j];
    }
    average[i] = average[i] / payScaleTable[i].length;
}
```