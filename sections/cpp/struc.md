# Structure

## Definition

- Structures are aggregate data types built using elements of other types.
- Structures are defined using the keyword struct, followed by the declarations of the elments within the structure.
- Syntax:
```C++
struct <struct_name>
{
    datatype1 identifier1
    datatype2 identifier2
    …..
    datatypen identifiern
    and so on
}
```

## Description

- Structure members can be of any type.
- One structure may contain members of many different type.
- When we define a structure is like we are defining a new data type of our design.
- We can then declare variables, arrays or pointers of the type of structure that we have defined.

## Example

```C++
struct student
{
    int roll;
    char name[20];
    float marks;
};

struct car
{
    char name[20];
    int year;
    float price;
};
```
Now we can have variables of the structure we declare:
```C++
struct student s1;// a single object of type student
struct student s2, s3;// two objects of type student
struct student s4[10];// an array of 10 objects of type student

struct car *mercedes;// a pointer to a car object
struct car *bmw, *audi;// two pointers to car objects
```

## Accessing Members of Structure

- Members of a structure are accessed using the member access operators – known as the dot operator `.` and the arrow operator `->`
```C++
struct student
{
    int roll;
    char name[20];
    float marks;
};

int main()
{
    struct student s1;
    s1.roll = 1;
    strcpy(s1.name, "John");
    s1.marks = 90.5;
    return 0;
}
```
output:
```C++
1
John
90.5
```

- The expression `timePtr->hour` is the same as `(*timePtr).hour`
```C++
struct time
{
    int hour;
    int minutes;
    int seconds;
};

int main()
{
    struct time t1;
    struct time *timePtr;
    timePtr = &t1;
    timePtr->hour = 10;
    timePtr->minutes = 20;
    timePtr->seconds = 30;
    return 0;
}
```
output:
```C++
10
20
30
```
