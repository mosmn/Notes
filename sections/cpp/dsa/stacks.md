# What is Stack?

- Stack is a **restricted access** linear data structure which follows a particular order in
which the operations are performed.
- It can only be accessed at one of its ends for adding and removing data elements
- It is also known as LIFO (Last In First Out) structure
- Stacks are particularly useful in situations where data have to be stored and
processed in reverse order


## Stack Implementation

- There are three ways to implement a stack:
    - Using Array-based (not covered in this syllabus)
    - Using Standard Template Library (STL)
    - Using Linked List

### Stack STL Implementation

**Standard Template Library (STL)**

you have to choose whether u want to preform the stack operation at the front or the back

**Operations**
- **insertion**
  - front
  - end
- **deletion**
  - front
  - end

#### Stack STL Implementation (cont)

```cpp
#include <stack>
```

```cpp
stack<char> mystack;
```

**Functions and Operations**
Function | Operation
--- | ---
**_empty( )_** | Determines if the stack is empty
**_push(el)_** | Pushes the data item `el` onto the top of the stack
**_pop( )_** | Removes the top element from the stack
**_top( )_** | Returns the value of the top element of the stack without removing it
**_swap()** | Swaps the contents of one stack with another stack of the same type but the size may vary
**_emplace()_** | Inserts a new element into the stack container; the new element is added on top of the stack

```cpp
mystack.push('C');
```

```cpp
mystack.push('A');
```

```cpp
mystack.top() returns 'A'
```

```cpp
mystack.emplace('D');
```

```cpp
mystack.pop(); // A
```


```cpp
stack<char> urstack;
mystack.swap(urstack);
```

```cpp
D
C
urstack
```

**Example 1**

1. Write the include preprocessor to use stack container. [1 mark]
   
   **Solution:**

   ```cpp
   #include <stack>
   ```

2. Insert value 30 to `myStack`. [1 mark]

   **Solution:**

   ```cpp
   mystack.push(30);
   ```

3. Declare an integer stack `myStack`. [1 mark]

   **Solution:**

   ```cpp
   std::stack<int> myStack;
   ```

**Example 2**

Create a stack program that accepts five (5) integer values from the user. Display the total data in the stack. Remove the data from the stack one by one until the stack is empty, displaying the data before removal.

**Sample Output:**

```
Enter 5 integer values:
Enter value 1: 12
Enter value 2: 34
Enter value 3: 56
Enter value 4: 78
Enter value 5: 90

Total data in stack: 5

Removing data from the stack:
Top value: 90
Top value: 78
Top value: 56
Top value: 34
Top value: 12
```

**Solution:**

```cpp
#include <iostream>
#include <stack>
using namespace std;

int main()
{
    stack<int> mystack;
    int num;

    cout << "Enter 5 integer values: " << endl;
    for (int i = 0; i < 5; i++)
    {
        cout << "Enter value " << i + 1 << ": ";
        cin >> num;
        mystack.push(num);
    }

    cout << "\nTotal data in stack: " << mystack.size() << endl;

    cout << "\nRemoving data from the stack: " << endl;
    while (!mystack.empty())
    {
        cout << "Top value: " << mystack.top() << endl;
        mystack.pop();
    }

    cout << "\n Stack is empty!" << endl;

    return 0;
}
```

**Example 3**

Using stack STL implementation, create a C++ program that accepts records with the following details:
- `idNo`: int
- `weight`: float

Display the total number of records in the stack and display all record details in the stack.

**Sample Output:**

```
Enter the number of records: 3

Enter record 1:
ID Number: 101
Weight: 75.5

Enter record 2:
ID Number: 102
Weight: 82.3

Enter record 3:
ID Number: 103
Weight: 68.9

Total records in stack: 3

Records in the stack:
Record 1: ID Number: 101, Weight: 75.5
Record 2: ID Number: 102, Weight: 82.3
Record 3: ID Number: 103, Weight: 68.9
```

**Solution:**

```cpp
#include <iostream>
#include <stack>
using namespace std;

struct Record
{
    int idNo;
    float weight;
};

int main()
{
    stack<Record> mystack;
    Record rec;
    int num;

    cout << "Enter the number of records: ";
    cin >> num;

    for (int i = 0; i < num; i++)
    {
        cout << "\nEnter record " << i + 1 << ": " << endl;
        cout << "ID Number: ";
        cin >> rec.idNo;
        cout << "Weight: ";
        cin >> rec.weight;
        mystack.push(rec);
    }

    cout << "\nTotal records in stack: " << mystack.size() << endl;

    cout << "\nRecords in the stack: " << endl;
    while (!mystack.empty())
    {
        cout << "Record " << i + 1 << ": ID Number: " << mystack.top().idNo << ", Weight: " << mystack.top().weight << endl;
        mystack.pop();
    }

    return 0;
}
```

If you dont want to delete the data, you can do it this way:

```cpp
void display(stack<Record> s)
{
    while (!s.empty())
    {
        cout << "Record " << i + 1 << ": ID Number: " << s.top().idNo << ", Weight: " << s.top().weight << endl;
        s.pop();
    }
}

int main()
{
    stack<Record> mystack;
    Record rec;
    int num;

    cout << "Enter the number of records: ";
    cin >> num;

    for (int i = 0; i < num; i++)
    {
        cout << "\nEnter record " << i + 1 << ": " << endl;
        cout << "ID Number: ";
        cin >> rec.idNo;
        cout << "Weight: ";
        cin >> rec.weight;
        mystack.push(rec);
    }

    cout << "\nTotal records in stack: " << mystack.size() << endl;

    cout << "\nRecords in the stack: " << endl;
    display(mystack);

    return 0;
}
```
your original stack will not be affected.

### Stack Linked List Implementation

you have to choose whether u want to preform the stack operation at the front or the back
**Linked List Implementation (Option 2):beginning**
- **Insertion:** Insert a new node at the start of the linked list
    - The complexity of the stack operations is O(1)
- **Deletion:** Remove the node at the start of the linked list
    - The complexity of the stack operations is O(1)
**Linked List Implementation (Option 2):end**
- **Insertion:** Insert a new node at the end of the linked list
    - Without tail pointer the complexity of the stack operations is O(n)
    - With tail pointer the complexity of the stack operations is O(1)
- **Deletion:** Remove the node at the end of the linked list
    - The complexity of the stack operations is O(n) regardless of whether the tail pointer is used or not

**Example 4**

**Question:**

Without changing the program flow, modify the STL implementation in Example 2 to Linked List implementation.

**Solution:**

```cpp
#include <iostream>
#include <stack>
using namespace std;

struct Node
{
    int data;
    Node *next;
};

int main()
{
    Node *top = NULL;
    Node *newNode;
    int num;

    cout << "Enter 5 integer values: " << endl;
    for (int i = 0; i < 5; i++)
    {
        cout << "Enter value " << i + 1 << ": ";
        cin >> num;
        newNode = new Node;
        newNode->data = num;
        newNode->next = top;
        top = newNode;
    }

    cout << "\nTotal data in stack: " << endl;
    Node *temp = top;
    int count = 0;
    while (temp != NULL)
    {
        count++;
        temp = temp->next;
    }
    cout << count << endl;

    cout << "\nRemoving data from the stack: " << endl;
    Node *temp2 = top;
    while (top != NULL)
    {
        cout << "Top value: " << top->data << endl;
        top = top->next;
        free(temp2);
        temp2 = top;
    }

    cout << "\n Stack is empty!" << endl;

    return 0;
}
```


## Stack Applications

There are numerous applications of stacks in computer science and programming:

- Evaluating expressions and parsing syntax
- Balancing delimiters in program code
- Converting numbers between bases
- Processing financial data
- Backtracking algorithms
- Undo function, such as in applications or software.
- Infix to Postfix/Prefix expression conversion
- Forward and backward features in web browsers
- Used in many algorithms like Tower of Hanoi, tree traversals, stock span problem, histogram problem.
- In Graph Algorithms like Topological Sorting and Strongly Connected Components.

**Stack Algorithm 1: Checking for Balanced Parentheses in a Mathematical Expression**

- Begin
  - While not the end of the expression
    - Read a token
    - If the token is "(", "{", or "["
      - Push the token onto the stack
    - If the token is ")", "}", or "]"
      - Pop the token from the stack
      - Compare the popped item with the current token
      - If they do not match
        - Print an error message
        - End the while loop
  - If the stack is empty
    - All parenthesis pairs were of the same type (expression is balanced)
  - Else
    - The expression is not balanced
  - End

**Example:**
Use the algorithm to check the following expression:
**( a – [ ( b + c ) – ( d + e ) ] * sin ( x - y ) )**

1. Push "(" onto the stack
   Stack: "("
2. Push "(" onto the stack
   Stack: "(", "("
3. Push "[" onto the stack
   Stack: "(", "(", "["
4. Pop the token from the stack ("]")
   Stack: "(", "("
5. Pop the token from the stack (")")
   Stack: "("
6. Imbalance (mismatch)

In this example, the algorithm correctly detects an imbalance in the expression because the closing parenthesis ")" did not match the corresponding opening parenthesis.

Here's an organized presentation of the Stack Algorithms and related exercises:

**Stack Algorithm 2: Converting Infix to Postfix**

- Infix notation is used by humans/programmers in programming, while Postfix notation is used by compilers for efficiency and easier parsing.
    - Infix: A + B
    - operand operator operand
- Postfix evaluation doesn't require parentheses during evaluation.
    - Postfix: A B +
    - operand operand operator

```plaintext
BEGIN
Create a new Stack (empty stack)
While not error and not the end of the expression, do
  Retrieve the following token
  if the token is equal to '(':
    Push onto Stack
  if the token is ')':
    Pop out and display items from the Stack until '(' is encountered in the Stack, but do not display '(', display an error if '(' is not found
  Operators *, /, +, -:
  If emptyStack or the current token has higher priority compared to the top of the stack,
    Push the token to the Stack
  else
    Pop the top item from the stack and display, repeat this comparison with the remaining items.
    Push the current token onto the stack
  Operand:
  Display the Operand
End while
Pop all elements
END
```

**Example 1:**

**Question:**
Convert the following infix expressions to postfix expressions.

**Solution:**
1. ( (A + B) * C - D) * E
   - Postfix: A B + C * D - E *
2. 5 + ( (1 + 2) * 4) - 3
   - Postfix: 5 1 2 + 4 * + 3 -

### Stack Algorithm: Converting Postfix to Infix

- **BEGIN**
  - Create an empty stack
  - Do while not the end of the expression
    - Get the next token in the expression
    - If the token is an operand, push it onto the stack
    - If the token is an operator:
      - Pop the top two items from the stack
      - Execute the expression and push the result onto the stack
    - If the end of the expression is encountered, the final value for the expression is equal to the top value of the stack
  - **End**

**Example:**

Use the algorithm to check the following expression:

Input: 2 4 * 9 5 + -

- Stack:
  - 2
  - 4
  - 14 (pop and push)
  - 9
  - 5
  - 14 -^ 5 (pop and push)
  - 8 (pop and push)
  - Final result: 8

#### Exercise 6

**Question:**
Convert the following postfix expressions to infix expressions.

**Solution:**
1. 512 + 4 * + 3 -
   - Infix: 5 + 12 + 4 * 3 -
2. 7 8 * 2 3 +
   - Infix: 7 * 8 + 2 + 3

#### Exercise 7

**Question (Sem 2, 2017/2018):**
What is the equivalent postfix for the infix expression **A + (B - C) + D**?
a) A B + C - D +
b) A B C D - + +
c) A B C - + D +
d) A B C D + - + 

**Solution:** a) A B + C - D +

#### Exercise 8

**Question (Sem 1, 2020/2021):**
Given an infix expression as in **Figure 1** above:
a) Show the content of the stack after tokens at positions marked by (i) and (ii) are read.
b) Convert the infix expression to postfix expression.

(Solution for part (a) and part (b) would require more specific information about the expression and the tokens at positions (i) and (ii).)

Sure, let's organize the provided code snippets and add some comments to explain each part:

### Slide No 10 (Exercise 2)

#### Option 1
```cpp
#include <stack>
#include <iostream>

using namespace std;

int main()
{
    stack<int> record;
    int i = 1, no;

    // Insertion
    for (; i < 6; i++)
    {
        cout << "Enter a number:";
        cin >> no;
        record.push(no);
    }

    cout << "Total data in stack : " << record.size() << endl;

    // Deletion
    cout << "::Deletion process:: ";
    while (!record.empty())
    {
        cout << "\nTop value: " << record.top();
        record.pop();
    }

    cout << "\nStack is empty";
    return 0;
}
```

#### Option 2 (Function)
```cpp
#include <iostream>
#include <stack>

using namespace std;

void display(stack<int> no)
{
    while (!no.empty())
    {
        cout << "Top value : " << no.top() << endl;
        no.pop();
    }
}

void deletion(stack<int> *no)
{
    while (!no->empty())
    {
        cout << "Top value : " << no->top() << endl;
        no->pop();
    }
}

int main()
{
    stack<int> number;
    int i = 1, val;

    for (; i <= 5; i++)
    {
        cout << "Enter value " << i << ":";
        cin >> val;
        number.push(val);
    }

    cout << "\n::Content of stack::" << endl;
    display(number);

    cout << "\n::Deletion process::" << endl;
    deletion(&number);

    if (number.empty())
        cout << "Stack is empty";
    return 0;
}
```

### Slide No 11 (Exercise 3)

```cpp
#include <iostream>
#include <stack>
#include <iomanip>

using namespace std;

struct person
{
    int idNo;
    float weight;
};

void display(stack<person> rec)
{
    int i = 1;
    while (!rec.empty())
    {
        cout << "Record " << i << " - Id no:" << rec.top().idNo;
        cout << ", Weight: " << fixed << setprecision(2) << rec.top().weight << endl;
        rec.pop();
        i++;
    }
}

void deletion(stack<person> *rec)
{
    int i = 1;
    while (!rec->empty())
    {
        cout << "Record " << i << " - Id no:" << rec->top().idNo;
        cout << ", Weight: " << fixed << setprecision(2) << rec->top().weight << endl;
        rec->pop();
        i++;
    }
}

int main()
{
    stack<person> record;
    person data;
    int i = 1;

    for (; i <= 3; i++)
    {
        cout << "Record " << i << ":" << endl;
        cout << "Enter id :";
        cin >> data.idNo;
        cout << "Enter weight :";
        cin >> data.weight;
        record.push(data);
    }

    cout << "Total data in stack :" << record.size();

    cout << "\n::Details of record::" << endl;
    display(record);

    cout << "\n::Deletion process::" << endl;
    deletion(&record);

    if (record.empty())
        cout << "End of stack record";
    return 0;
}
```

### Slide No 15 (Exercise 4)
```cpp
#include <iostream>

using namespace std;

struct data
{
    int number;
    data *next;
};

data *createNode(int no)
{
    data *n = new data();
    n->number = no;
    n->next = NULL;
    return n;
}

void push(data **head, int val)
{
    data *n = createNode(val);
    n->next = *head;
    *head = n;
}

void pop(data **head)
{
    data *p;
    while (*head != NULL)
    {
        p = *head;
        cout << "Top value : " << p->number << endl;
        *head = (*head)->next;
        free(p);
    }
}

void display(data *head)
{
    while (head != NULL)
    {
        cout << "Top value : " << head->number << endl;
        head = head->next;
    }
}

int main()
{
    int i = 1, val;
    data *head = NULL;

    for (; i <= 5; i++)
    {
        cout << "Enter value " << i << ":";
        cin >> val;
        push(&head, val);
    }

    cout << "\n::Content of stack::" << endl;
    display(head);

    cout << "\n::Deletion process::" << endl;
    pop(&head);

    if (head == NULL)
        cout << "Stack is empty";
    return 0;
}
```
