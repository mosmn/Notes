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
```
+-------------------+
|                   |
|   GradeBook       |
|                   |
+-------------------+
|                   |
| +displayMessage() |
|                   |
+-------------------+
```
The plus sign (+) in front of the operation name indicates that displayMessage is a public operation in the UML