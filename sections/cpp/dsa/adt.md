# What is Data Structure?​

Programs are comprised of two things: data and algorithms. ​

Data may be organized in many different ways. The logical or mathematical model of a particular organization of data is called a data structure. __It is a technique of storing and organizing data so it can be used efficiently​__

The choice of a particular data model depends on two considerations. First, it must be rich enough in structure to mirror the actual relationships of the data in the real world. On the other hands, the structure should be simple enough that one can effectively process the data when necessary.​

Algorithms describe the way the data is to be transformed.

The reason for learning about data structures is because adding structure to our data can make the algorithms much simpler, easier to maintain, and often faster.​

Data structure also describes the relationship among the elements in addition to memory storage. The data appearing in the data structure are processed by means of certain operations. __The four operations that play a major role are Inserting, Deleting, Traversing and Searching.​__

Other than that, Sorting and Merging are two additional operations used in special situations.

# Abstract Data Types

In our program models, __data structures are described by abstract data types (ADTs)​__

In computer science, an abstract data type (ADT) is a mathematical model for data types where a data type is defined by its behavior (semantics) from the point of view of a user of the data, specifically in terms of possible values, possible operations on data of this type, and the behavior of these operations. ​

Only behavior is defined but not implementation​

Examples: Array, List, Queue, Stack, Table, Tree, Vector and many more (these are what we use to describe data structures, they are mathematical models for data types)​

Typical design methodologies focus on developing models of solutions before implementing them​

These models emphasize structure and function of the algorithms used​

Initially our attention is on what needs to be done, not how it is done​

So, we define program behavior in terms of operations to be performed on data

### Example: Stack

A stack is a last-in first-out (LIFO) linear structure where items can only be added and removed from one end​

Operations on this stack ADT might include:​

PUSH – add an item to the stack​

POP – remove the item at the top of the stack​

TOP – return the value of the item at the top of the stack​

EMPTY – determine if the stack is empty​

CREATE – create a new empty stack​

Notice these simply describe the things we can do, not how they are done. These details will be reserved for implementation

# Standard Template Library (STL)

Standard Template Library (STL) provides three generic entities: containers, iterators, and algorithms, and a set of classes that overload the function operator called function objects​

It also has a ready-made set of common classes for C++, such as container and associative arrays​

These can be used with any built-in type and with any user-defined type that supports some elementary operations

![STL](https://d1m75rqqgidzqn.cloudfront.net/wp-data/2021/03/23180546/23-1024x332.png)

STL algorithms are independent of containers, which significantly reduces the complexity of the library​

The results of the STL are achieved through using templates​

This allows the use of static binding polymorphism (as opposed to run-time or dynamic binding polymorphism) which is frequently more efficient

## Container​

A container is a data structure that is typically designed to hold objects of the same type and is a way stored data is organized in memory, e.g., an array of elements.​

Containers are implemented as template classes whose methods specify operations on the data in the structures as well as the structures themselves​

A number of these methods are common to all containers, while some are more specific to the container they are defined in​

The data stored in containers can be of any type and must supply some basic methods and operations​

This is especially necessary if pointers are involved

![Container](https://d1m75rqqgidzqn.cloudfront.net/wp-data/2021/03/23180800/23a-1024x539.png)