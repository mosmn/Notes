# What is Data Structure?

Programs are comprised of two things: data and algorithms.

Data may be organized in many different ways. The logical or mathematical model of a particular organization of data is called a data structure. It is a technique of storing and organizing data so it can be used efficiently.

The choice of a particular data model depends on two considerations. First, it must be rich enough in structure to mirror the actual relationships of the data in the real world. On the other hand, the structure should be simple enough that one can effectively process the data when necessary.

Algorithms describe the way the data is to be transformed.

The reason for learning about data structures is because adding structure to our data can make the algorithms much simpler, easier to maintain, and often faster.

Data structure also describes the relationship among the elements in addition to memory storage. The data appearing in the data structure are processed by means of certain operations. The four operations that play a major role are Inserting, Deleting, Traversing, and Searching. Other than that, Sorting and Merging are two additional operations used in special situations.

# Abstract Data Types

In our program models, data structures are described by abstract data types (ADTs).

In computer science, an abstract data type (ADT) is a mathematical model for data types where a data type is defined by its behavior (semantics) from the point of view of a user of the data, specifically in terms of possible values, possible operations on data of this type, and the behavior of these operations. Only behavior is defined but not implementation.

Examples: Array, List, Queue, Stack, Table, Tree, Vector, and many more (these are what we use to describe data structures; they are mathematical models for data types).

Typical design methodologies focus on developing models of solutions before implementing them. These models emphasize the structure and function of the algorithms used. Initially, our attention is on what needs to be done, not how it is done. So, we define program behavior in terms of operations to be performed on data.

### Example: Stack

A stack is a last-in, first-out (LIFO) linear structure where items can only be added and removed from one end. Operations on this stack ADT might include:

- PUSH – add an item to the stack
- POP – remove the item at the top of the stack
- TOP – return the value of the item at the top of the stack
- EMPTY – determine if the stack is empty
- CREATE – create a new empty stack

Notice these simply describe the things we can do, not how they are done. These details will be reserved for implementation.

# Standard Template Library (STL)

Standard Template Library (STL) provides three generic entities: containers, iterators, and algorithms, and a set of classes that overload the function operator called function objects. It also has a ready-made set of common classes for C++, such as container and associative arrays. These can be used with any built-in type and with any user-defined type that supports some elementary operations.

![STL](https://d1m75rqqgidzqn.cloudfront.net/wp-data/2021/03/23180546/23-1024x332.png)

STL algorithms are independent of containers, which significantly reduces the complexity of the library. The results of the STL are achieved through using templates. This allows the use of static binding polymorphism (as opposed to run-time or dynamic binding polymorphism) which is frequently more efficient.

## Container

A container is a data structure that is typically designed to hold objects of the same type and is a way stored data is organized in memory, e.g., an array of elements. Containers are implemented as template classes whose methods specify operations on the data in the structures as well as the structures themselves. A number of these methods are common to all containers, while some are more specific to the container they are defined in. The data stored in containers can be of any type and must supply some basic methods and operations. This is especially necessary if pointers are involved.

![Container](https://d1m75rqqgidzqn.cloudfront.net/wp-data/2021/03/23180800/23a-1024x539.png)

## Iterators

An iterator is an object that accesses the elements of a container. Iterators are a generalization of the concept of pointers; they point to elements in a container. For example, you can increment an iterator to point to the next element in an array. These capabilities make iterators a major feature that allows the generality of the STL. The STL implements five types of iterators:

- Input iterators: can read a sequence of values
- Output iterators: can write a sequence of values
- Forward iterators: can be read, written to, or moved forward
- Bidirectional iterators: behave like forward iterators but can also move backward
- Random iterators: can move freely in any direction at one time

## Algorithms

Algorithms in the STL are procedures that are applied to containers to process their data, for example, search for an element in an array, or sort an array. About 70 generic functions, known as algorithms, are provided in the STL. These perform operations such as searching and sorting. Each is implemented to require a certain level of iterator (and therefore will work on any container that provides an interface by iterators). Algorithms are in addition to the methods provided by containers, but some algorithms are implemented as member functions for efficiency.

# Vector & List

## Vector

- **Description**: A vector is one of the simplest containers in the STL (Standard Template Library).

- **Characteristics**:
  - Elements are stored contiguously in memory, similar to a dynamic array.
  - Low memory utilization, good locality of reference, and good data cache utilization.
  - Allows random access with indices.
  - Efficient memory allocation.
  - Automatically resizes when elements are inserted or deleted.

- **Syntax**:
  ```cpp
  vector <data_type> vector_name;
  ```
  Example:
  ```cpp
  vector <int> myVector;
  ```

- **Member Functions**:
  - **Modifier Functions**:
    - **assign()**: Assigns new values to the vector elements by replacing old ones.
    - **push_back()**: Pushes elements into a vector from the back.
    - **pop_back()**: Removes the last element from the vector.
    - **insert()**: Inserts new elements before the element at the specified position.
    - **erase()**: Removes elements from a container at the specified position or range.
    - **swap()**: Swaps the contents of one vector with another vector of the same type, even if their sizes differ.
    - **clear()**: Removes all the elements from the vector container.
    - **emplace()**: Extends the container by inserting a new element at a specific position.
    - **emplace_back()**: Inserts a new element at the end of the vector.

  - **Capacity Functions**:
    - **size()**: Returns the number of elements in the vector.
    - **max_size()**: Returns the maximum number of elements that the vector can hold.
    - **capacity()**: Returns the size of the storage space currently allocated to the vector expressed as the number of elements.
    - **resize(n)**: Resizes the container so that it contains 'n' elements.
    - **empty()**: Returns whether the container is empty.
    - **shrink_to_fit()**: Reduces the capacity of the container to fit its size and destroys all elements beyond the capacity.
    - **reserve()**: Requests that the vector's capacity be at least enough to contain 'n' elements.

  - **Accessor Functions**:
    - **operator []**: Returns a reference to the element at position 'g' in the vector.
    - **at()**: Returns a reference to the element at position 'g' in the vector.
    - **front()**: Returns a reference to the first element in the vector.
    - **back()**: Returns a reference to the last element in the vector.
    - **data()**: Returns a direct pointer to the memory array used internally by the vector to store its owned elements.

  - **Iterator Functions**:
    - **begin()**: Returns an iterator pointing to the first element in the vector.
    - **end()**: Returns an iterator pointing to the theoretical element that follows the last element in the vector.
    - **rbegin()**: Returns a reverse iterator pointing to the last element in the vector (reverse beginning).
    - **rend()**: Returns a reverse iterator pointing to the theoretical element preceding the first element in the vector (reverse end).
    - **cbegin()**: Returns a constant iterator pointing to the first element in the vector.
    - **cend()**: Returns a constant iterator pointing to the theoretical element that follows the last element in the vector.
    - **crbegin()**: Returns a constant reverse iterator pointing to the last element in the vector (reverse beginning).
    - **crend()**: Returns a constant reverse iterator pointing to the theoretical element preceding the first element in the vector (considered as reverse end).

- **Example**:
  ```cpp
  #include <iostream>
  #include <vector>
  using namespace std;

  int main() {
      vector<float> floatVector = {1.1, 2.2, 3.3, 4.4, 5.5};
      vector<float>::reverse_iterator i = floatVector.rbegin();

      while (i != floatVector.rend()) {
          cout << *i << " ";
          i++;
      }

      return 0;
  }
  ```

## List

- **Description**: Lists are sequence containers that allow non-contiguous memory allocation, offering constant time insert and erase operations anywhere within the sequence.

- **Characteristics**:
  - Ideal for insertions, extractions, and moving elements in any position.
  - No contiguous memory allocation.
  - Efficient for algorithms that require such operations.

- **Syntax**:
  ```cpp
  list <data_type> list_name;
  ```
  Example:
  ```cpp
  list <int> myList;
  ```

- **Member Functions**:
  - **Modifier Functions**:
    - **assign()**: Assigns new values to the list elements by replacing old ones.
    - **push_front()**: Inserts an element at the beginning.
    - **pop_front()**: Removes the element from the beginning.
    - **push_back()**: Pushes elements into a list from the back.
    - **pop_back()**: Removes the last element from the list.
    - **insert()**: Inserts new elements before the element at the specified position.
    - **erase()**: Removes elements from a container at the specified position or range.
    - **swap()**: Swaps the contents of one list with another list of the same type, even if their sizes differ.
    - **clear()**: Removes all the elements from the list container.
    - **emplace()**: Constructs and inserts an element.
    - **emplace_front()**: Extends the list container by inserting a new element at the beginning.
    - **emplace_back()**: Inserts a new element at the end of the list.

  - **Capacity Functions**:
    - **size()**: Returns the number of elements in the list.
    - **max_size()**: Returns the maximum number of elements that the list can hold.
    - **capacity()**: Not applicable to lists (constant memory overhead).

  - **Accessor Functions**:
    - **front()**: Returns a reference to the first element in the list.
    - **back()**: Returns a reference to the last element in the list.

  - **Iterator Functions**:
    - **begin()**: Returns an iterator pointing to the first element in the list.
    - **end()**: Returns an iterator pointing to the theoretical element that follows the last element in the list.
    - **rbegin()**: Returns a reverse iterator pointing to the last element in the list (reverse beginning).
    - **rend()**: Returns a reverse iterator pointing to the theoretical element preceding the first element in the list (reverse end).
    - **cbegin()**: Returns a constant iterator pointing to the first element in the list.
    - **cend()**: Returns a constant iterator pointing to the theoretical element that follows the last element in the list.
    - **crbegin()**: Returns a constant reverse iterator pointing to the last element in the list (reverse beginning).
    - **crend()**: Returns a constant reverse iterator pointing to the theoretical element preceding the first element in the list (considered as reverse end).
   
   - **Operations**:
        - **splice()**: Transfers elements from one list to another.
        - **remove()**: Removes elements with a specific value from the list.
        - **remove_if()**: Removes elements that fulfill a specified condition.
        - **unique()**: Removes duplicate values from the list.
        - **merge()**: Merges sorted lists into one.
        - **sort()**: Sorts elements in the list.
        - **reverse()**: Reverses the order of elements in the list.

## Vector vs List

| Vector | List |
| --- | --- |
| **Contiguous memory.** | **Non-contiguous memory.** |
| Pre-allocates space for future elements, requiring extra space. | No pre-allocated memory; constant memory overhead. |
| Each element requires space for the element type itself. | Each element requires extra space for the node. |
| Re-allocates memory for the entire vector when adding elements. | Never re-allocates memory for the whole list when adding elements. |
| Insertions elsewhere are costly (O(n)). | Insertions and erasures are cheap anywhere in the list. |
| Iterators are invalidated when adding or removing elements. | Iterators remain valid when adding or removing elements. |
| Supports random access. | No random access support. |
| Can access the underlying array. | No direct access to an underlying array. |
