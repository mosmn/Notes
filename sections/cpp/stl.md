# deque sequence container

Class deque provides many of the benefits of a vector and a list in one
container.

The term deque (pronounced "deek") is short for "double-ended queue." Class
deque is implemented to provide efficient indexed access (using subscripting)
for reading and modifying its elements, much like a vector.

Class deque is also implemented for efficient insertion and deletion
operations at its front and back, much like a list (although a list is also capable
of efficient insertions and deletions in the middle of the list). 

Class deque provides support for random-access iterators, so deques can be
used with all STL algorithms. One of the most common uses of a deque is to
maintain a first-in-first-out queue of elements.

Class deque provides the same basic operations as class vector (will be
covered later), but adds member functions push_front and pop_front to
allow insertion and deletion at the beginning of the deque, respectively

Example 1:
```cpp
#include <iostream>
#include <deque>
#include <algorithm>
#include <iterator>
using namespace std;

int main()
{
    int i; //loop counter
    deque<int> Mo; //create an empty deque

    // create a loop that will show the values in the deque
    for(i=0; i < Mo.size(); i++)
        cout << Mo[i] << " ";
}
```

### push_front() & push_back() | pop_front() & pop_back()

Example 1:
```cpp
#include <iostream>
#include <deque>
#include <algorithm>
#include <iterator>
using namespace std;

int main()
{
    int i; 
    deque<int> Mo;

    // push_front() inserts an element at the beginning of the deque(left)
    Mo.push_front(3);
    Mo.push_front(5);
    Mo.push_front(7);

    for(i=0; i < Mo.size(); i++)
        cout << Mo[i] << " ";

    return 0;
}
```
output:
```
7 5 3
```

Example 2:
```cpp
#include <iostream>
#include <deque>
#include <algorithm>
#include <iterator>
using namespace std;

int main()
{
    int i; 
    deque<int> Mo;

    
    Mo.push_front(3);
    Mo.push_front(5);
    Mo.push_front(7);
    // push_back() inserts an element at the end of the deque(right)
    Mo.push_back(2);

    for(i=0; i < Mo.size(); i++)
        cout << Mo[i] << " ";

    return 0;
}
```
output:
```
7 5 3 2
```

Example 3:
```cpp
#include <iostream>
#include <deque>
#include <algorithm>
#include <iterator>
using namespace std;

int main()
{
    int i; 
    deque<int> Mo;
    
    Mo.push_front(3);
    Mo.push_front(5);
    Mo.push_front(7);
    Mo.push_back(2);

    // pop_front() removes an element from the beginning of the deque(left)
    Mo.pop_front();

    for(i=0; i < Mo.size(); i++)
        cout << Mo[i] << " ";

    return 0;
}
```
output:
```
5 3 2
```


### Using class iterator to display the contents of a deque

Example 1:
```cpp
#include <iostream>
#include <deque>
#include <algorithm>
#include <iterator>
using namespace std;

int main()
{
    int i; 
    deque<int> Mo;
    // create an iterator for deque<int> with the name Osman and space between each element
    ostream_iterator<int>  Osman(cout, " ");

    Mo.push_front(3);
    Mo.push_front(5);
    Mo.push_front(7);
    Mo.push_back(2);

    copy(Mo.begin(), Mo.end(), Osman); //this function is from class algorithm
}
```
output:
```
7 5 3 2
```

Example 2: multiple iterators
```cpp
#include <iostream>
#include <deque>
#include <algorithm>
#include <iterator>
using namespace std;

int main()
{
    int i; 
    deque<int> Mo;
    ostream_iterator<int>  Osman(cout, " ");
    ostream_iterator<int>  Osman2(cout, " $ ");

    Mo.push_front(3);
    Mo.push_front(5);
    Mo.push_front(7);
    Mo.push_back(2);

    copy(Mo.begin(), Mo.end(), Osman);
    cout << endl;
    copy(Mo.begin(), Mo.end(), Osman2);
}
```
output:
```
7 5 3 2
7 $ 5 $ 3 $ 2
```

Example 3: 
```cpp
#include <iostream>
#include <deque>
#include <algorithm>
#include <iterator>
using namespace std;

int main()
{
    int i; 
    deque<int> Mo;
    ostream_iterator<int>  Osman(cout, " ");
    ostream_iterator<int>  Osman2(cout, " $ ");

    Mo.push_front(3);
    Mo.push_front(5);
    Mo.push_front(7);
    Mo.push_back(2);

    copy(Mo.begin(), Mo.end(), Osman2);
    cout << endl;

    for(i=0; i < 5; i++)
        Mo.push_back(i);
    
    copy(Mo.begin(), Mo.end(), Osman2);
}
```
output:
```
7 $ 5 $ 3 $ 2
7 $ 5 $ 3 $ 2 $ 0 $ 1 $ 2 $ 3 $ 4
```