# Queues in C++

## What is a Queue?

- A queue, similar to a stack, is a linear data structure with restricted access.
- **Restricted to one end (the rear) for additions and the other (the front) for deletions.**
- Items are removed in the order they are added, following the **First In First Out (FIFO) structure.**
- Queue operations: **Enqueue (append)** at the back and **Dequeue (serve)** from the front.

## Queue Structure

- Pop
- Push 91
  - Push 91, Pop
- First-in First-out (FIFO) Structures

## Queue Implementation

- Three ways to implement a queue:
  1. **Array-based** (covered in Programming 1)
  2. **Standard Template Library (STL)**
  3. **Linked List**

### Standard Template Library (STL)

```cpp
// Example Queue STL Implementation
#include <iostream>
#include <queue>

using namespace std;

int main() {
    queue<char> myQ;

    myQ.push('C');
    myQ.push('A');

    cout << "Queue is empty: " << myQ.empty() << endl;  // Returns false

    // Function Operations
    cout << "Front element: " << myQ.front() << endl;     // Returns C
    cout << "Back element: " << myQ.back() << endl;       // Returns A

    myQ.emplace('D');
    myQ.pop();  // Removes front element

    // Swap contents with another queue
    queue<char> urQ;
    myQ.swap(urQ);

    cout << "Contents after swap:" << endl;
    while (!urQ.empty()) {
        cout << urQ.front() << " ";
        urQ.pop();
    }
    return 0;
}
```

## Exercise 1

**Level: Easy**

1. Write the include preprocessor to use the queue container.
2. Display the first and last values in myQueue.
3. Declare an integer queue myQueue and insert the value 30.

```cpp
#include <iostream>
#include <queue>

using namespace std;

int main() {
    // 1. Write the include preprocessor to use the queue container.
    queue<int> myQueue;

    // 3. Declare an integer queue myQueue and insert the value 30.
    myQueue.push(30);

    // 2. Display the first and last values in myQueue.
    cout << "First value: " << myQueue.front() << endl;
    cout << "Last value: " << myQueue.back() << endl;

    return 0;
}
```

## Exercise 2

**Level: Easy**

Create a program that accepts five integer values from the user, displays total data in the queue, and removes data one by one until the queue is empty.

```cpp
#include <iostream>
#include <queue>

using namespace std;

int main() {
    queue<int> myQueue;

    // Accept five integer values from the user
    cout << "Enter five integer values:" << endl;
    for (int i = 0; i < 5; ++i) {
        int value;
        cin >> value;
        myQueue.push(value);
    }

    // Display total data in the queue
    cout << "Total data in the queue: " << myQueue.size() << endl;

    // Remove data one by one until the queue is empty
    cout << "Data in the queue before removal:" << endl;
    while (!myQueue.empty()) {
        cout << myQueue.front() << " ";
        myQueue.pop();
    }

    return 0;
}
```

## Exercise 3

**Level: Easy**

Using queue STL implementation, create a C++ program that accepts records with details: idNo (int) and weight (float). Display total records and all record details in the queue.

```cpp
#include <iostream>
#include <queue>

using namespace std;

struct Record {
    int idNo;
    float weight;
};

int main() {
    queue<Record> recordQueue;

    // Accept records from the user
    cout << "Enter records (idNo and weight):" << endl;
    for (int i = 0; i < 3; ++i) {
        Record newRecord;
        cin >> newRecord.idNo >> newRecord.weight;
        recordQueue.push(newRecord);
    }

    // Display total records in the queue
    cout << "Total records in the queue: " << recordQueue.size() << endl;

    // Display all record details in the queue
    cout << "Record details in the queue:" << endl;
    while (!recordQueue.empty()) {
        Record frontRecord = recordQueue.front();
        cout << "idNo: " << frontRecord.idNo << ", weight: " << frontRecord.weight << endl;
        recordQueue.pop();
    }

    return 0;
}
```

## Linked List

- **Enqueue/append:** Add a new element at the end of the linked list.
- **Dequeue/serve:** Remove the first element from the list.

### Linked List Implementation (Option 1)

Algorithm:
- Insertion: Insert a new node at the end of the linked list
- Deletion: Remove the node at the beginning of the linked list

### Linked List Implementation (Option 2)

Algorithm:
- Insertion: Insert a new node at the beginning of the linked list
- Deletion: Remove the node at the end of the linked list

## Exercise 4

Modify the STL implementation in Exercise 2 to Linked List implementation without changing the program flow.

```cpp
// Modify the STL implementation in Exercise 2 (Slide 11) to Linked List implementation
#include <iostream>
#include <list>

using namespace std;

int main() {
    list<int> myList;

    // Accept five integer values from the user
    cout << "Enter five integer values:" << endl;
    for (int i = 0; i < 5; ++i) {
        int value;
        cin >> value;
        myList.push_back(value);
    }

    // Display total data in the list
    cout << "Total data in the list: " << myList.size() << endl;

    // Remove data one by one until the list is empty
    cout << "Data in the list before removal:" << endl;
    while (!myList.empty()) {
        cout << myList.front() << " ";
        myList.pop_front();
    }

    return 0;
}
```

## Queue Applications

- Queues find applications in various scenarios:
  - Shared resource management (e.g., CPU scheduling, disk scheduling).
  - Asynchronous data transfer between processes (e.g., IO Buffers, pipes, file IO).
  - Operating systems (e.g., spooling in printers, handling website traffic).
  - Networks (e.g., handling interrupts, routers, switches, mail systems).