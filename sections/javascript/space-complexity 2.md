# Space complexity

Space complexity can be considered to be the total space used by an algorithm relative to the size of the input. Thinking back to the previous lesson, you’ll recall that we don’t consider the efficiency of an algorithm in how it performs in one specific instance of that algorithm running. Instead, we want to know how the efficiency changes when the size of the input changes.

Measuring space complexity considers the space used by your algorithm input and auxiliary space. Auxiliary space is the extra space used by the algorithm. These can be things like temporary variables created during the execution of the algorithm. They won’t have a lasting impact on memory space but during the execution of the algorithm will need to be considered. Therefore, you can consider the space complexity to be the total amount of working memory our algorithm needs.

## Measuring Space Complexity

The first thing to know is that, like time complexity, we measure space complexity by considering all steps including any constants, and then we drop the constants when applying a Big O Notation to the algorithm. So we may have an algorithm that uses memory in Linear Complexity as the input changes, and in doing so creates 3 temporary variables. So we can think of the complexity of our algorithm as O(N) + 3 auxiliary variables using memory. Because those 3 variables are the same no matter our input size, we don’t concern ourselves with them when considering the space complexity of our algorithm. So we’d say the space complexity is O(N). This should be familiar to you from the time complexity lesson.

As a reminder the Big O Notations are:
- O(1) - Constant Complexity
- O(log N) - Logarithmic Complexity
- O(N) - Linear Complexity
- O(N log N) - N x log N Complexity
- O(n²) - Quadratic Complexity
- O(n³) - Cubic Complexity
- O(2ⁿ) - Exponential Complexity
- O(N!) - Factorial Complexity

### O(1) - Constant Complexity

```js
function multiply(num1, num2) {
  return num1 * num2;
}
```
No matter the arguments we enter when we call the function, only two variables are created. It doesn’t change. Therefore, we can consider the space this takes is always O(1).

### O(N) - Linear Complexity
Most data structures you come across will have a space complexity of O(N). That makes sense - when you increase the number of items in your data structure, it increases the space that data structure occupies in a linear way.
```js
function sumArr(arr) {
  const copyArr = arr.slice();
  let sum = 0;
  copyArr.forEach((number) => {
    sum += number;
  });
  return sum;
}
```
We wrote this in a slightly more verbose way than you’d normally write it in JavaScript to make it a little clearer. Here we have a method which accepts an array. Within, we have two variables. One called sum and the other copyArr which holds a copy of the array passed in. We then have a forEach loop that iterates over the array. The amount of space that this algorithm takes depends on the array that is passed to it. It could be 3 elements in the array or 300. When we don’t know the length of the array, we refer to it as N, so we have N + 1 variable called sum. We know that we drop constants with Big O, so we are left with N, or O(N) for its Big O notation.

Why did we make a copy of the array? That will be discussed in a later section.

The complexity is replicated no matter the data structure:
```js
function sumObjectValues(obj) {
  const copyObject = { ...obj };
  let sum = 0;
  Object.values(copyObject).forEach((value) => {
    sum += value
  });
  return sum;
}
```
Here as the object size increases, the space it uses grows in a linear way.

## Other considerations

One of the common areas that causes confusion when considering space complexity is what constitutes using space in the context of an algorithm. In an earlier example we wrote methods that duplicated an array and object argument. We did that to be explicit. But what if we’d written the method as:
```js
function sumArr(arr) {
  let sum = 0;
  arr.forEach((number) => {
    sum += number;
  });
  return sum;
}
```
When a data structure is passed in as the argument, especially for languages that pass arrays by reference rather than value, it can be a bit unclear if that method considers the space used by that data structure when calculating its space complexity. If we didn’t count it, then it would be easy for all our methods to have great space usage on paper because we put the onus on the caller to allocate that space. If we did count it, but the data structure was created for use by many different methods, then the space complexity for all those methods is O(N) when they aren’t utilizing additional space. Then consider that if your method receives an array as an input and loops it, an index must be created for the loop which uses additional space.

Ultimately when you consider Big O measures the worst-case scenario, it would be easier to err on the side of caution and do consider the space of arguments passed to your method.

- [see](https://dev.to/mwong068/big-o-space-complexity-lcm)
- [recursion](https://dev.to/elmarshall/recursion-and-space-complexity-13gc)