# Searching

### What is Searching?

Searching in data structures refers to the process of finding required information from a collection of items stored as elements in the computer memory. These items can be in different forms, such as an array, linked list, graph, or tree.

**Example Applications:**
- Looking for a Name by giving the telephone number.
- Databases (student record, staff record, sales record).
- Internet search engines (Yahoo, Google).

### Type of Searching

1. **Sequential Search:**
   - The list or array is traversed sequentially, checking every component of the set.
   - Example: Linear Search.

2. **Interval Search:**
   - Specifically designed for searching in sorted data structures.
   - More efficient than Linear Search, targeting the center of the search structure and dividing the search space in half.
   - Example: Binary Search.
   
3. **Search by Hashing**

### Sequential Search

**Algorithm:**
- Mark the first element as LOW and the last element as HI.
- Find the mid-point: MID = (LOW + HI) / 2.
- If key = MID, return the index.
- If key < MID, set HI = MID – 1.
- If key > MID, set LOW = MID + 1.
- Repeat until the value is found or LOW and HI cross each other.

**Time Complexity:**
- Best-case = O(1).
- Worst-case = O(n).
- Average-case = depends on the position of the item.

**Examples:**
- Array implementation of sequential search.
- STL implementation of sequential search.
- Linked List implementation of sequential search.

**Advantages:**
- Useful for limited-sized datasets.
- Simple and does not require structured data.

**Disadvantages:**
- Time-consuming for large lists.

### Binary Search

Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half. It works on the principle of divide and conquer.

**Algorithm:**
1. Mark the first element as LOW and last element as HI.
2. Find the mid-point: MID = (LOW + HI) / 2.
3. If key = MID, return index.
4. If key < MID, set HI = MID – 1.
5. If key > MID, set LOW = MID + 1.
6. Repeat until the value is found or LOW and HI cross each other.

**Runtime Complexity:**
- Ο(log n)

**Examples:**
- Example 1: Searching for the target value 62.
- Example 2: Searching for the target value 9.

## What is Hashing?

- Hashing is a technique of mapping a large amount of data into small tables using a hashing function.
- It uniquely identifies a specific item from a collection of similar items.
- Uses hash tables to store data in an array format, where each value has a unique index number.
- Hash function converts the item into a small integer or hash value.

**Example:**
```plaintext
ID   | Name               | Course
-----|----------------------|-------
10050| Ali Bin Abu         | BCS(SE)
10048| Lim Li Hiang        | BCS(SN)
10021| Ramu A/L Ravi        | BCS(CS)
10079| Sameer               | BIT(GM)
10087| John Lee             | BIT(IS)
10033| Hussein              | BIT(VM)
...  | ...                  | ...
```

## Requirements of Hashing Function

- A good hash function should be easy to compute.
- It should avoid clustering and distribute keys evenly across the hash table.
- Collision avoidance is crucial; a good hash function minimizes the chance of two keys mapping to the same hash value.

## Types of Hashing Function

**1. Truncation Method**
- Truncates a part of the given keys based on the size of the hash table.
- Uses right, left, or both right and left digits as the hash code value.

**Example:**
- Truncate the first 3 digits of the original key 26785: Key % 1000 = 785

**2. Digit Extraction Method**
- Selects specific digits from the key as the address.

**Example:**
- Using UNITEN eight employee number to hash to a five-digit address (00001 to 99999) by selecting the first, fourth, and last three digits.

**3. Modular Arithmetic**
- Converts the key into an integer, divides it by the size of the index range, and takes the remainder as the index position.
- The remainder is calculated using a hash function.
- We might still have the situation where two keys map to the same index, for example: 100252 and 100352. This condition is called a COLLISION.
- Collision happens in Modular Arithmetic becase the algorithm is fixed unlike the other two methods which are flexible.

**Example:**
- For key 100252 and assuming the array size is 100: Index = key % size = 52

## Collision

- Hashing encounters a collision when two keys are assigned the same index number in the hash table.
- Collisions create problems as each index should store only one value.
- Collision resolution techniques include Linear Probing, Quadratic Probing, Chaining, Double Hashing, etc.

## Linear Probing

- In linear probing, a search operation probes linearly for the next empty cell after a collision.
- Start at the point of collision and sequentially search for an empty location.
- If the end of the table is reached, start probing from the first cell again.

**Example:**
- Inserting keys into a hash table using linear probing.

## Quadratic Probing

- In quadratic probing, a search operation probes for the next empty cell using a quadratic algorithm after a collision.
- Steps:
  1. If the slot `hash(x) % array size` is occupied, try `(hash(x) + i^2) % array size`.
  2. Repeat the process for increasing values of i until an empty slot is found.

**Example:**
- Resolving collisions by quadratic probing.

## Chaining

- Chaining involves making each cell of the hash table point to a linked list of records with the same hash function value.
- A new node is created for each collision, and the new value is linked to the old value.

**Advantages:**
1. Simple to implement.
2. Hash table never fills up, and elements can be added indefinitely.
3. Less sensitive to hash function or load factors.
4. Suitable when it's unknown how many or how frequently keys may be inserted or deleted.
5. Deletion process is easier.

**Disadvantages:**
1. Cache performance is not optimal as keys are stored in a linked list.
2. Wastage of space as some parts of the hash table are never used.
3. Search time can become O(n) in the worst case if the chain becomes long.
4. Uses extra space for links.

**Example:**
- Inserting keys into a hash table using chaining.

## Double Hashing

- Double hashing uses a second hash function to resolve collisions.
- The second hash function is applied when a collision occurs, and it helps find the next empty cell.
- A popular second hash function is `hash2(key) = PRIME - (key % PRIME)`.

**Example:**
- Inserting keys into a hash table using double hashing.