# Introduction to Classes, Objects and Strings

Typically, the programs you develop in C++ will consist of function main​ and one or more classes, each containing data members and member functions​

- Classes is an improvement to Data Structure​
- Data Structure can only store data members​
- Classes can store data members and functions (methods) with other characteristics manipulator

Example that consists of 
- class GradeBook which will represent a grade book that an instructor can use to maintain student test scores
- a main function that creates a GradeBook object:
```C++
#include <iostream>
using namespace std;

// GradeBook class definition
class GradeBook
{
public:
    // function that displays a welcome message to the GradeBook user
    void displayMessage()
    {
        cout << "Welcome to the Grade Book!" << endl;
    } // end function displayMessage
}; // end class GradeBook

// function main begins program execution
int main()
{
    GradeBook myGradeBook; // create a GradeBook object named myGradeBook
    myGradeBook.displayMessage(); // call object's displayMessage function
}
```
Function main uses this object and its member function to display a message on the screen welcoming the instructor to the grade-book program.

The GradeBook class definition contains a member function called displayMessage that displays a message on the screen.

- By convention, the name of a user-defined class begins with a capital letter, and for readability, each subsequent word in the class name begins with a capital letter. This capitalization style is often referred to as Camel case, because the pattern of uppercase and lowercase letters resembles the silhouette of a camel.

Recall that the function main is always called automatically when you execute a program​. Most functions do not get called automatically. As you’ll soon see, you must call member function displayMessage explicitly to tell it to perform its task

The keyword `public`, which is an access specifier. The member function displayMessage appears after access specifier public: to indicate that the function is “available to the public”—that is, it can be called by other functions in the program (such as main), and by member functions of other classes (if there are any)

UML Class Diagram for Class GradeBook:

```mermaid
classDiagram
    GradeBook <|-- GradeBook
    class GradeBook{
        +displayMessage()
    }
```
The plus sign (+) in front of the operation name indicates that displayMessage is a public operation in the UML

# Defining a Member Function with a Parameter

```C++
#include <iostream>
using namespace std;

class GradeBook
{
public:
    void displayMessage(string courseName)
    {
        cout << "Welcome to the grade book for\n" << courseName << "!" << endl;
    }
};

int main()
{
    string nameOfCourse;
    GradeBook myGradeBook;

    cout << "Please enter the course name:" << endl;
    getline(cin, nameOfCourse);
    cout << endl;

    myGradeBook.displayMessage(nameOfCourse);
}
```
output:
```C++
Please enter the course name:
CSEB214 Object Oriented Programming

Welcome to the grade book for
CSEB214 Object Oriented Programming!
```

Updated UML Class Diagram for Class GradeBook:
```mermaid
classDiagram
    GradeBook <|-- GradeBook
    class GradeBook{
        +displayMessage(courseName : String)
    }
```

# GradeBook Class with a Data Member, a set Function and a get Function

```C++
#include <iostream>
#include <string>
using namespace std;

class GradeBook
{
public:
    void setCourseName(string name)
    {
        courseName = name;
    }

    string getCourseName()
    {
        return courseName;
    }

    void displayMessage()
    {
        cout << "Welcome to the grade book for\n" << getCourseName() << "!" << endl;
    }
    private:
        string courseName;
};

int main()
{
    string nameOfCourse;
    GradeBook myGradeBook;

    cout << "Initial course name is: " << myGradeBook.getCourseName() << endl;

    cout << "\nPlease enter the course name:" << endl;
    getline(cin, nameOfCourse);
    cout << endl;

    myGradeBook.setCourseName(nameOfCourse);
    cout << endl;

    myGradeBook.displayMessage();
}
```
output:
```C++
Initial course name is:

Please enter the course name:
CSEB214 Object Oriented Programming

Welcome to the grade book for
CSEB214 Object Oriented Programming!
```

The class contains member functions setCourseName, getCourseName and displayMessage. 
- Member function setCourseName stores a course name in a GradeBook data member named courseName.
- Member function getCourseName returns the value of courseName to the function that called it.
- Member function displayMessage displays a welcome message by calling getCourseName to retrieve the course name.

# Access Specifiers public and private

Most data-member declarations appear after the private access specifier.

Variables or functions declared after access specifier private (and before the next access specifier if there is one) are accessible only to member functions of the class for which they’re declared (or to “friends” of the class, as you’ll see in Chapter 5).

Thus, data member courseName can be used only in member functions setCourseName, getCourseName and displayMessage of class GradeBook (or to “friends” of the class, if there were any).

The default access for class members is private so all members after the class header and before the first access specifier (if there are any) are private.

The access specifiers public and private may be repeated, but this is unnecessary and can be confusing.

Declaring data members with access specifier private is known as __data hiding.__

# Software Engineering with Set and Get Functions

The set and get functions of a class also should be used by other member functions within the class to manipulate the class’s private data, although these member functions can access the private data directly.

For example,
- Member functions setCourseName and getCourseName are public member functions, so they’re accessible to clients of the class, as well as to the class itself. Member function displayMessage calls member function getCourseName to obtain the value of data member courseName for display purposes, eventhough displayMessage can access courseName directly—accessing a data member via its get function creates a better, more robust class.

A class’s private data members can be manipulated only by member functions of that class (and by “friends” of the class). So a client of an object—that is, any statement that calls the object’s member functions from outside the object—calls the class’s public member functions to request the class’s services for particular objects of the class.

This is why the statements in function main call member functions setCourseName, getCourseName and displayMessage on a GradeBook object. Classes often provide public member functions to allow clients of the class to set (i.e., assign values to) or get (i.e., obtain the values of) private data members.

GradeBook’s UML Class Diagram with a Data Member and set and get Functions:
```mermaid
classDiagram
    GradeBook <|-- GradeBook
    class GradeBook{
        +setCourseName(name : String)
        +getCourseName() : String
        +displayMessage()
        -courseName : String
    }
```

# Initializing Objects with Constructors

When an object of class GradeBook is created, its data member courseName is initialized to the empty string by default.

What if you want to provide a course name when you create a GradeBook object?
- Each class you declare can provide a constructor that can be used to initialize an object of the class when the object is created.

 A constructor is a special member function that must be defined with the same name as the class, so that the compiler can distinguish it from the class’s other member functions.

 An important difference between constructors and other functions is that constructors cannot return values, so they cannot specify a return type (not even void).
 
 Normally, constructors are declared public.

 C++ requires a constructor call for each object that’s created, which helps ensure that each object is initialized properly before it’s used in a program.

 The constructor call occurs implicitly when the object is created. If a class does not explicitly include a constructor, the compiler provides a default constructor—that is, a constructor with no parameters.

 GradeBook object is created in line 31, the default constructor is called. The default constructor provided by the compiler creates a GradeBook object without giving any initial values to the object’s fundamental type data members. [Note: For data members that are objects of other classes, the default constructor implicitly calls each data member’s default constructor to ensure that the data member is initialized properly.]

 This is why the string data member courseName was initialized to the empty string—the default constructor for class string sets the string’s value to the empty string. You’ll learn more about initializing data members that are objects of other classes in future chapters.

 ```C++
#include <iostream>
#include <string>
using namespace std;

class GradeBook
{
    public:
        // constructor initializes courseName with string supplied as argument
        GradeBook(string name)
        {
            setCourseName(name);
        }

        void setCourseName(string name)
        {
            courseName = name;
        }

        string getCourseName()
        {
            return courseName;
        }

        void displayMessage()
        {
            cout << "Welcome to the grade book for\n" << getCourseName() << "!" << endl;
        }

    private:
        string courseName;
};

int main()
{
    // create two GradeBook objects
    GradeBook gradeBook1("CS101 Introduction to C++ Programming");
    GradeBook gradeBook2("CS102 Data Structures in C++");

    cout << "gradeBook1 created for course: " << gradeBook1.getCourseName() << "\ngradeBook2 created for course: " << gradeBook2.getCourseName() << endl;
}
```
output:
```C++
gradeBook1 created for course: CS101 Introduction to C++ Programming
gradeBook2 created for course: CS102 Data Structures in C++ Programming
```

## Two Ways to Provide a Default Constructor for a Class

Any constructor that takes no arguments is called a default constructor. A class can get a default constructor in one of two ways:

1. The compiler implicitly creates a default constructor in a class that does not define a constructor. Such a constructor does not initialize the class’s data members, but does call the default constructor for each data member that’s an object of another class. An uninitialized variable typically contains a “garbage” value. ​

2. You explicitly define a constructor that takes no arguments. Such a default constructor will call the default constructor for each data member that’s an object of another class and will perform additional initialization specified by you. 

Adding the Constructor to Class GradeBook’s UML Class Diagra:
```mermaid
classDiagram
    GradeBook <|-- GradeBook
    class GradeBook{
        +GradeBook()
        +setCourseName(name : String)
        +getCourseName() : String
        +displayMessage()
        -courseName : String
    }
```
