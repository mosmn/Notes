# Recursion

Recursion is the idea that a function calls itself.

It’s used to take a big problem and start breaking it down into smaller and smaller pieces (“Divide and Conquer”) and continuing to feed their solutions back into the original function until some sort of answer is achieved and the whole chain unwinds.

>In computer science, divide and conquer (D&C) is an important algorithm design paradigm based on multi-branched recursion. A divide and conquer algorithm works by recursively breaking down a problem into two or more sub-problems of the same (or related) type, until these become simple enough to be solved directly. The solutions to the sub-problems are then combined to give a solution to the original problem.

## Two ways of thinking

For something simple to start with – let’s write a function pow(x, n) that raises x to a natural power of n. In other words, multiplies x by itself n times.
```js
pow(2, 2) = 4
pow(2, 3) = 8
pow(2, 4) = 16
```
There are two ways to implement it.

Iterative thinking: the `for` loop:
```js
function pow(x, n) {
  let result = 1;

  // multiply result by x n times in the loop
  for (let i = 0; i < n; i++) {
    result *= x;
  }

  return result;
}

alert( pow(2, 3) ); // 8
```
Recursive thinking: simplify the task and call self:
```js
function pow(x, n) {
  if (n == 1) {
    return x;
  } else {
    return x * pow(x, n - 1);
  }
}

alert( pow(2, 3) ); // 8
```

When pow(x, n) is called, the execution splits into two branches:
```js
              if n==1  = x
             /
pow(x, n) =
             \
              else     = x * pow(x, n - 1)
```
If n == 1, then everything is trivial. It is called the __base of recursion__, because it immediately produces the obvious result: pow(x, 1) equals x.
Otherwise, we can represent pow(x, n) as x * pow(x, n - 1). In maths, one would write xn = x * xn-1. This is called a recursive step: we transform the task into a simpler action (multiplication by x) and a simpler call of the same task (pow with lower n). Next steps simplify it further and further until n reaches 1.

For example, to calculate pow(2, 4) the recursive variant does these steps:
1. pow(2, 4) = 2 * pow(2, 3)
2. pow(2, 3) = 2 * pow(2, 2)
3. pow(2, 2) = 2 * pow(2, 1)
4. pow(2, 1) = 2

The maximal number of nested calls (including the first one) is called __recursion depth__. In our case, it will be exactly `n`.

## The execution context and stack(how recursive calls work)

The [execution context](https://tc39.es/ecma262/#sec-execution-contexts) is an internal data structure that contains details about the execution of a function: where the control flow is now, the current variables, the value of this (we don’t use it here) and few other internal details.

When a function makes a nested call, the following happens:
- The current function is paused.
- The execution context associated with it is remembered in a special data structure called __execution context stack.__
- The nested call executes.
- After it ends, the old execution context is retrieved from the stack, and the outer function is resumed from where it stopped.