# Linked-list

The principal benefit of a linked list over a conventional array is that the list elements can easily be inserted or removed without reallocation of any other elements.

In some programming languages, the size of an array is a concern and one of the ways to overcome that problem and allow dynamically allocated data is using linked lists. Luckily in Javascript, arrays aren’t limited to a certain size, so you don’t have to think about overcoming that limitation.


## Structure of a Linked List

__A linked list is a linear collection of data elements called nodes that “point” to the next node by means of a pointer.__

![gif](https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.geeksforgeeks.org%2Fremove-last-node-of-the-linked-list%2F&psig=AOvVaw1ouHPX_My_S9fvT8CXAZlO&ust=1687592684022000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCNC2ieXy2P8CFQAAAAAdAAAAABAd)

Each node holds a single element of data and a link or pointer to the next node in the list.

A head node is the first node in the list, a tail node is the last node in the list. Below is a basic representation of a linked list:

`[ NODE(head) ] -> [ NODE ] -> [ NODE(tail) ] -> null`

They are linear data structures, which means that there is a sequence and an order to how they are constructed and traversed.
- [see more](https://dev.to/vaidehijoshi/whats-a-linked-list-anyway)
- [also](https://web.archive.org/web/20200217010131/http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html)

[Video](https://www.youtube.com/watch?v=oiW79L8VYXk)