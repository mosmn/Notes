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

## Structure Arrays

- We can declare arrays of structures.
- The syntax is similar to that of declaring arrays of other data types.
```C++
struct person
{
    char name[20];
    int age;
    float salary;
};

int main()
{
    struct person p1[3];

    for (int i = 0; i < 3; i++)
    {
        cout << "Enter name: ";
        cin >> p1[i].name;
        cout << "Enter age: ";
        cin >> p1[i].age;
        cout << "Enter salary: ";
        cin >> p1[i].salary;
    }

    cout << "Displaying Information:" << endl;
    for (int i = 0; i < 3; i++)
    {
        cout << "Name: " << p1[i].name << endl;
        cout << "Age: " << p1[i].age << endl;
        cout << "Salary: " << p1[i].salary << endl;
    }

    return 0;
}
```

## Pointers to Structures

- We can declare pointers to structures.
- The syntax is similar to that of declaring pointers to other data types.
```C++
struct person
{
    char name[20];
    int age;
    float salary;
};

int main()
{
    struct person p1;
    struct person *ptr; // or we can just write struct person *ptr = &p1;
    ptr = &p1;
    cout << "Enter name: ";
    cin >> ptr->name;
    cout << "Enter age: ";
    cin >> ptr->age;
    cout << "Enter salary: ";
    cin >> ptr->salary;
    cout << "Displaying Information:" << endl;
    cout << "Name: " << ptr->name << endl;
    cout << "Age: " << ptr->age << endl;
    cout << "Salary: " << ptr->salary << endl;
    return 0;
}
```

## Nested Structures

- We can define structures within structures.
- The syntax is similar to that of defining structures.
```C++
struct address
{
    char city[20];
    char state[20];
    char country[20];
};

struct person
{
    char name[20];
    int age;
    float salary;
    struct address add; // or just address add;
};

int main()
{
    struct person p1;
    cout << "Enter name: ";
    cin >> p1.name;
    cout << "Enter age: ";
    cin >> p1.age;
    cout << "Enter salary: ";
    cin >> p1.salary;
    cout << "Enter city: ";
    cin >> p1.add.city;
    cout << "Enter state: ";
    cin >> p1.add.state;
    cout << "Enter country: ";
    cin >> p1.add.country;
    cout << "Displaying Information:" << endl;
    cout << "Name: " << p1.name << endl;
    cout << "Age: " << p1.age << endl;
    cout << "Salary: " << p1.salary << endl;
    cout << "City: " << p1.add.city << endl;
    cout << "State: " << p1.add.state << endl;
    cout << "Country: " << p1.add.country << endl;
    return 0;
}
```
