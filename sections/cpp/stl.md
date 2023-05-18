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