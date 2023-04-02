# Inheritance

Inheritance is a form of software reuse in which you create a class that absorbs an existing class’s capabilities, then customizes or enhances them.

Software reuse saves time during program development by taking advantage of proven, high-quality software.

When creating a class, instead of writing completely new data members and member functions, you can specify that the new class should inherit the members of an existing class. 

This existing class is called the base class, and the new class is called the derived class.

Other programming languages, such as Java and C#, refer to the base class as the superclass and the derived class as the subclass. A derived class represents a more specialized group of objects.

C++ offers public, protected and private inheritance. In this chapter, we concentrate on public inheritance and briefly explain the other two.

With public inheritance, every object of a derived class is also an object of that derived class’s base class. However, baseclass objects are not objects of their derived classes.

For example, if we have Vehicle as a base class and Car as a derived class, then all Cars are Vehicles, but not all Vehicles are

For example, if we have Vehicle as a base class and Car as a derived class, then all Cars are Vehicles, but not all Vehicles are Cars—for example, a Vehicle could also be a Truck or a Boat.

We distinguish between the is-a relationship and the has-a relationship. The is-a relationship represents inheritance. In an is-a relationship, an object of a derived class also can be treated as an object of its base class—for example, a Car is a Vehicle, so any attributes and behaviors of a Vehicle are also attributes and behaviors of a Car.

# Base Classes and Derived Classes

Below figure lists several simple examples of base classes and derived classes. Base classes tend to be more general and derived classes tend to be more specific.

Base class
Derived classes
Student
GraduateStudent, UndergraduateStudent
Shape
Circle, Triangle, Rectangle, Sphere, Cube
Loan
CarLoan, Home Improvement Loan, MortgageLoan
Employee
Faculty, Staff
Account
CheckingAccount, Savings Account

Because every derived-class object is an object of its base class, and one base class can have many derived classes, the set of objects represented by a base class typically is larger than the set of objects represented by any of its derived classes.

For example, the base class Vehicle represents all vehicles, including cars, trucks, boats, airplanes, bicycles and so on. By contrast, derived class Car represents a smaller, more specific subset of all vehicles. Inheritance relationships form class hierarchies. 

# Inheritance: Public, Protected, Private

```C++
```

The inheritance relationship of two classes is declared in the derived class. Derived classes definitions use the following syntax:
```C++
class derived_class_name: public base_class_name{ /*...*/ };
```
The public access specifier may be replaced by any one of the other access specifiers (protected or private). This access specifier limits the most accessible level for the members inherited from the base class: The members with a more accessible level are inherited with this level instead, while the members with an equal or more restrictive access level keep their restrictive level in the derived class.

The objects of the classes Rectangle and Triangle each contain members inherited from Polygon. These are: width, height and set_values. The protected access specifier used in class Polygon is similar to private. Its only difference occurs in fact with inheritance: When a class inherits another one, the members of the derived class can access the protected members inherited from the base class, but not its private members.s

By declaring width and height as protected instead of private, these members are also accessible from the derived classes Rectangle and Triangle, instead of just from members of Polygon. If they were public, they could be access just from anywhere.

We can summarize the different access types according to which functions can access them in the following way:

Where "not members" represents any access from outside the class, such as from main, from another class or from a function.

In the example above, the members inherited by Rectangle and Triangle have the same access permissions as they had in their base class Polygon

This is because the inheritance relation has been declared using the public keyword on each of the derived classes:
```C++
class Rectangle : public Polygon { }
```
This public keyword after the colon (:) denotes the most accessible level the members inherited from the class that follows it (in this case Polygon) will have from the derived class (in this case Rectangle).

Since public is the most accessible level, __by specifying this keyword the derived class will inherit all the members with the same levels they had in the base class.__

With protected, all public members of the base class are inherited as protected in the derived class.

Conversely, if the most restricting access level is specified (private), all the base class members are inherited as private and thus cannot be accessed from the derived class.

For example, if daughter were a class derived from mother that we defined as:
```C++
class Daughter : protected Mother { }
```
This would set protected as the less restrictive access level for the members of Daughter that it inherited from mother. That is, all members that were public in Mother would become protected in Daughter. Of course, this would not restrict Daughter from declaring its own public members. That __less restrictive access level is only set for the members inherited from Mother.If no access level is specified for the inheritance, the compiler assumes private for classes declared with keyword class and public for those declared with struct.__

In a nutshell, the table shows the summary for each type of inheritance the accessibility of base-class members in a derived class. The first column contains the base-class access specifiers.

![in](/imgs/inh1.png)

# What is inherited from the base class?

In principle, a derived class inherits every member of a base class except:
- its constructors and its destructor
- its assignment operator members (operator=)
- its friends
- its private members

Although the constructors and destructors of the base class are not inherited as constructors and destructors in the derived class, they are still called by the derived class's constructor. Unless otherwise specified, the constructors of derived classes call the default constructors of their base classes (i.e., the constructor taking no arguments), which must exist.

Calling a different constructor of a base class is possible, using the same syntax as to initialize member variables in the initialization list:
```C++
derived constructorname (parameters) : baseconstructorname (parameters) 
```

### Mother, Son and Daughter Classes

```C++
```

# Multiple Inheritance

A class may inherit from more than one class by simply specifying more base classes, separated by commas, in the list of a class's base classes (i.e., after the colon).

For example, if the program had a specific class to print on screen called Output, and we wanted our classes Rectangle and Triangle to also inherit its members in addition to those of Polygon we could write:
```C++
class Rectangle: public Polygon, public Output;
class Triangle: public Polygon, public Output; 
```

```C++
```