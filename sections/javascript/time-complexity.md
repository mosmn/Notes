# “Time complexity”: analysing how the runtime of an algorithm changes as the input increases.

In programming, there are two ways we can measure the efficiency of our code. We can measure the time complexity or the space complexity.

# Efficiency Basics

The very first step in mastering efficient code is to understand how to measure it. Let’s take a look at a simple little program that prints out all odd numbers between 1 and 10.
```js
function oddNumbersLessThanTen() {
  let currentNumber = 1;

  while (currentNumber < 10) {
    if (currentNumber % 2 !== 0) {
      console.log(currentNumber);
    }

    currentNumber += 1;
  }
}
```

If you were to run this in your terminal, you should get the numbers 1, 3, 5, 7 and 9 printed to the console. It probably took a fraction of a second to run. If you were to run it again, it might take the same time, or it might be faster or slower depending on what else your computer is doing. If you were to run it on a different computer, it would again run faster or slower. Therefore it’s important to understand that you never measure the efficiency of an algorithm by how long it takes to execute.

So how do we measure it?

The way to measure code efficiency is to evaluate how many ‘steps’ it takes to complete. If you know that one algorithm you write takes 5 steps and another one takes 20 steps to accomplish the same task, then you can say that the 5-step algorithm will always run faster than the 20-step algorithm on the same computer.

Let’s go back to our `oddNumbersLessThanTen` function. How many steps does our algorithm take?
1. We assign the number 1 to a variable. That’s one step.

2. We have a loop. For each iteration of the loop, we do the following:
- Compare `currentNumber` to see if it is less than 10. That is 1 step.
- We then check if `currentNumber` is odd. That is 1 step.
- If it is then we output it to the terminal. That’s 1 step every 2 iterations.
- We increase `currentNumber` by 1. That is 1 step.
3. To exit the loop, we need to compare `currentNumber` one last time to see that it is not less than ten any more. That is one last step.
So there are 3 steps for every loop iteration and it iterates 9 times which is 27 steps. Then we have one step which iterates for only half the loop iteration which is 5 steps. Assigning an initial value to `currentNumber` and checking the exit condition of the loop is one step each. 27 + 5 + 1 + 1 = 34 steps.

__Therefore, we can say our algorithm takes 34 steps to complete.__

While this is useful to know, it isn’t actually helpful for comparing algorithms. To see why, let’s slightly modify our initial algorithm to take in a number instead of setting a hard default of 10.
```js
function oddNumbers(maxNumber) {
  let currentNumber = 1;

  while (currentNumber < maxNumber) {
    if (currentNumber % 2 !== 0) {
      console.log(currentNumber);
    }

    currentNumber += 1;
  }
}
```
How many steps does this algorithm take?

You’ve probably realised the answer is it depends. If you set maxNumber to be 10, like we did before, the number of steps is 34, but if you enter another number then the number of steps changes. There is no concrete number we can use to measure the efficiency of our code because it changes based on an external input.

__So what we really want to be able to measure is how the number of steps of our algorithm changes when the data changes. This helps us answer the question of whether the code we write will scale.__

To do that, we need to delve into a new concept: Asymptotic Notations and, in particular, Big O.

# Asymptotic Notations

Asymptotic Notations are used to describe the running time of an algorithm. Because an algorithm’s running time can differ depending on the input, there are several notations that measure that running time in different ways. The 3 most common are as follows:
- Big O Notation - represents the upper bound of an algorithm. This means the worst-case scenario for how the algorithm will perform.
- Omega Notation - represents the lower bound of an algorithm. This is the best-case scenario.
- Theta Notation - represents both the upper bound and lower bound and therefore analyses the average case complexity of an algorithm.
Big O is the one you’ll most commonly see referenced because you need to be sure the worst-case scenario for any code you write is scalable as the inputs grow in your application.

## Big O Notation

Big O gives us a consistent way to measure the efficiency of an algorithm. It gives us a measurement for the time it takes for an algorithm to run as the input grows so that you can directly compare the performance of two algorithms and pick the best one.

Big O is not a piece of code you can put your algorithm into and it tells you how efficient it is. __You will need to measure how the number of steps changes as the data grows__, and using this you can apply a Big O Notation to it and measure it against other algorithms. In many cases you’ll be using a data structure in which the ways you interact with it are well known, and in that case it’s easier to judge how it will scale as the input changes.

The Big O Notations in the order of speed from fastest to slowest are:
- O(1) - Constant Complexity,pronounced “Big O of 1”
- O(log N) - Logarithmic Complexity, pronounced “Big O of log N”
- O(N) - Linear Complexity, pronounced “Big O of N”
- O(N log N) - N x log N Complexity, pronounced “Big O of N log N”
- O(n²) - Quadratic Complexity, pronounced “Big O of N squared”
- O(n³) - Cubic Complexity, pronounced “Big O of N cubed”
- O(2ⁿ) - Exponential Complexity, pronounced “Big O of 2 to the N”
- O(N!) - Factorial Complexity, pronounced “Big O of N factorial”

### O(1) - Constant Complexity

```js
arr = [1, 2, 3, 4, 5]
```
If we want to look up what is at index 2, we can get to the element using arr[2] which would give us back 3. This takes just one step. If we double our array…
```js
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```
We can still access any element in just one step. arr[7] gives us 8 in a single step. Our array can keep growing and we can always access any element in a single step. It’s constant. Hence we have O(1).

Looking up something in one step is as good as it gets for time complexity.

While we’re looking at the simplest form of Big O, let’s take a look at one of its little gotchas to keep in mind. You may have thought a moment ago, is it really just one step? The answer is technically no, in reality the computer must first look up where the array is in memory, then from the first element in the array it needs to jump to the index argument provided. That’s at least a couple of steps. So you wouldn’t be wrong for writing something like O(1 + 2(steps)). However, the 2 steps are merely incidental. With an array of 10,000 elements, it still takes the same amount of steps as if the array was 2 elements. Because of this, Big O doesn’t concern itself with these incidental numbers. They don’t provide any context to how the complexity grows when the data size changes, because they are constant, and so in Big O they are dropped. Big O only wants to tell us an algorithm’s complexity relative to the size of the input.

Do the number of steps matter? Yes, they might. We’ll touch on when this may be the case a little later.

### O(log N) - Logarithmic Complexity

Logarithmic a quantity representing the power to which a fixed number (the base) must be raised to produce a given number.

Logarithmic Complexity tells us that the numbers of steps an algorithm takes increases by 1 as the data doubles. That’s still pretty efficient when you think about it. Going from 5,000 to 10,000 data elements and only taking one additional step can scale really well.

One such algorithm that does this is Binary Search. It only works on sorted arrays, but if you have an array of 10 items in sorted order
```js
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```
and wanted to know if it had the number 7, Binary Search would guess the middle item of the array and see what is there. Because the array is sorted, if the number at the middle index was 6, then we know anything to the left of that index cannot be the number 7, as those items must be lower than 6 in a sorted array.
```js
arr = [-, -, -, -, -, 6, 7, 8, 9, 10]
```
Therefore in just one step, we’ve eliminated half of the array. We can do the same with the remaining half. We can guess the middle index and see if it’s 7. Half of that (half of an array) array eliminated again. In this case, the middle index would be 8, and we know that 7 is less than 8 so we can eliminate anything to the right of the number 8.
```js
arr = [6, 7, 8, -, -]
```
We can keep doing this until we have an array of just one item. If it matches the number we’re looking for, we’ve found it. If not, then it isn’t in the array.
åå
The below table summarises the size of an array doubling and how many steps in Big O terms we would need to arrive at one element to see if it matches what we’re looking for:
```
Size	Steps
1	1
2	2
4	3
8	4
16	5
32	6
```

### O(N) - Linear Complexity
This one is pretty easy to wrap your head around. Linear Complexity just tells us that as the number of items grows, the number of steps grows at exactly the same rate. Every time you iterate over an array is an example of Linear Complexity. If you have an array of 5 items, then we can iterate every element in 5 steps. An array of 10 items can be iterated in 10 steps. If you come across any algorithm with a Big O efficiency of O(N), you know that the number of steps will increase in line with the number of elements in your data structure.

### O(N log N) - N x log N Complexity
You can’t say this one isn’t appropriately named. This notation means we have an algorithm which initially is O(log N) such as our example earlier of Binary Search where it repeatedly breaks an array in half, but with O(N log N) each of those array halves is processed by another algorithm with a complexity of O(N).

One such algorithm is merge sort, and it just so happens you tackle this project in our course :)

### O(n²) - Quadratic Complexity
You’ve probably written code with a Quadratic Complexity on your programming journey. It’s commonly seen when you loop over a data set and within each loop you loop over it again. Therefore, when the number of items in the data increases by 1, it requires 2 extra iterations. 2 extra items requires 4 extra iterations (2 in the outer loop and two in the inner loop). 3 extra items adds 9 steps, and 4 adds 16 extra steps. We hope you can see where we’re going with this…

#### Example 3 – Quadratic time complexity: Big O(n^2)

Here’s a function called multiplyAll which accepts two arrays. It first makes sure they’re of equal length; if they are then it will continue down and multiply every number in the first array with every number in the second array and return the sum of all these products.
```js
function multiplyAll(arr1, arr2) {
  if (arr1.length !== arr2.length) return undefined
  let total = 0
  for (let i of arr1) {
    for (let j of arr2) {
      total += i * j
    }
  }
  return total
}
let result1 = multiplyAll([1, 2], [5, 6]) // 33
let result2 = multiplyAll([1, 2, 3, 4], [5, 3, 1, 8]) // 170
```
It does this using two for-loops. The first for-loop loops over the first array. Then inside this for-loop, we have a second, nested for loop, which loops over every item in the second array. So, for every item we loop over in the first array, we have to loop over every item in the second array.

If we pass in two arrays of length two ([1, 2] and [5, 6]), then for the first run through the outer loop, i will point at 1. It will then loop through the second array starting with 5, and 1 * 5 will be added to the total. It will then go to the second element in the second array and do 1 * 6 and add it to the total.

Then we get to the end of that loop, so we go back to the outer loop, and increment to the second element which is 2. We then do 2 * 5 and add it to the total, then, finally, 2 * 6 and add it to the total.

As we can see, for every item in the first array, we have to loop over every single item in the second array and perform a multiplication. So the total number of operations will be the length of the first array, which is n, times the length of the second array, which is also n, because we checked to make sure they are the same length. This results in a Big O(n^2) - quadratic time complexity.

If you are incredibly astute, you may have noticed that technically this algorithm would have a Big O(3 * n^2), because for every item in arr1, we:

- loop over every item in arr2 (n^2 operations)
- multiply two numbers (another n^2 operations)
- add to the total (another n^2 operations).
- Therefore, the total number of operations is n^2 + n^2 + n^2 which equals 3n^2 .

But remember again, with Big O Notation, we are looking at the big picture, the worst-case scenario as the input length approaches infinity, and 3 times infinity is still infinity – a humungous number. So as the input size grows, this 3 becomes insignificant in the grand scheme of things and we simplify to say that this algorithm has a Big O(n^2) - “quadratic time-complexity”.

Let’s reintroduce the graph of Big O Notation and discuss quadratic time complexity…

### O(n³) - Cubic Complexity
Think triple nested loops baby. 1 extra item adds 3 extra steps, 2 adds 8, and 3 adds about 27. 100 items will be about 1,000,000 steps. Ouch!

### O(2ⁿ) - Exponential Complexity
Exponential Complexity means that with each item added to the data size, the number of steps doubles from the previous number of steps. Let’s provide a little table to see how quickly this can get out of hand.
```
Size	Steps
1	2
2	4
3	8
4	16
5	32
6	64
7	128
8	256
9	512
10	1024
```
You want to avoid this if at all possible, otherwise you won’t be processing much data quickly.

### O(N!) - Factorial Complexity
A factorial is the product of the sequence of n integers. The factorial of 4(4!) is 4 * 3 * 2 * 1.

You will come across Factorial Complexity if you ever need to calculate permutations or combinations. If you have an array and have to work out all the combinations you can make from the array, that is a Factorial complexity. It’s manageable for a small number of items, but the leap with each new item in a dataset can be huge.

The factorial of 3 is 6 (3 * 2 * 1). The factorial of 4 is 24. The factorial of 10? 3,628,800. So you can see how quickly things can get out of hand.

## Alternatives to Big O
If Big O gives us the worst-case scenario of how our algorithm will scale, what alternatives are there?

### Big Ω (Omega Notation)
Omega Notations gives us the best-case scenario for an algorithm. To understand where this might be, let’s look at a method and discuss how we can measure its complexity.
```js
function findValue(arr) {
  for (let i = 0; i < arr.length; i++) {
    let item = arr[i];
    if (item === 1) {
      return item
    }
  }
}
```
In the worst case (Big O), which would happen if the item is not in the array, we would say it had linear complexity O(N). This is because the item we are looking for is not in the array, so our code must iterate on every value. If the array input doubles in size then the worst case also means our method must double the number of iterations looking for the item.

However, in the best-case scenario the value we are looking for will be the first item in the array. In this case our algorithm takes just one step. This has a complexity of O(1). This is its Omega Complexity.

Omega Notation isn’t considered as useful because it is unlikely our item will often be the first item in our data structure search, so it doesn’t give us any idea how well the algorithm will scale.

### Big-Θ (Big-Theta Notation)
While Omega Notation measures the best-case scenario for an algorithm’s efficiency, and Big O measures the worst case, Theta looks to give the exact value or a useful range between narrow upper and lower bounds.

If we had some code that looped every item in an array, then it doesn’t matter the size of the array. Our algorithm will always run in O(N) time in its best-case and worst-case scenarios. In that case we know it’s exact performance in all scenarios is O(N), and that is the Theta performance of our algorithm. For other algorithms, Theta may represent both the lower and upper bound of an algorithm that has different complexities. We won’t get into this more here because Big O is the primary notation used for general algorithm time complexity.

This is just a simplistic explanation to try to make the topic approachable. If you do happen to be mathematically minded, then you’ll find more detailed explanations with a quick search online.

## Why Big O
Now that we’ve touched on the different ways of quantifying an algorithm’s efficiency, hopefully it’s clear why we choose to use the worst-case scenario when measuring the efficiency of that algorithm.

Using a worst-case scenario we can make sure our algorithm will scale in all outcomes. If we write an algorithm that could potentially run in constant time, but could also run in linear time in the worst case, it can only scale as the input grows if it still works when the worst case does happen. You need to be confident your code won’t lock up and leave users frustrated if you suddenly get an input of a million items instead of 10.

## Algorithms with the same complexity
If we write two algorithms with the same complexity, does that mean they’re equally good to use? We’ll answer this question with two code examples which we’ll then discuss a bit further to try and answer the question.

The first example is some code we’ve seen already, our oddNumbers function.
```js
function oddNumbers(maxNumber) {
  let currentNumber = 1;

  while (currentNumber < maxNumber) {
    if (currentNumber % 2 !== 0) {
      console.log(currentNumber);
    }

    currentNumber += 1;
  }
}
```
The time complexity of this algorithm is O(N). As the data size increases, the number of steps of our algorithm increases at the same rate.

Let’s look at another version:
```js
function oddNumbers(maxNumber) {
  let currentNumber = 1;

  while (currentNumber < maxNumber) {
    if (currentNumber % 2 !== 0) {
      console.log(currentNumber);
    }

    currentNumber += 2;
  }
}
```
Not much of a change, but this time we increase currentNumber by 2. How does this affect our algorithm runtime? Well, for an input of n, the number of steps is approximately half as we iterate by 2 each time. This is an algorithm of O(N/2) but as I’ve mentioned earlier, Big O doesn’t concern itself with constants because they aren’t relative to how an algorithm scales as the input changes and it wouldn’t be fun or easy to have to compare an algorithm of O(N/2 + 5 N) against O(N + 5 / 2N). Therefore, the Big O efficiency of both algorithms is O(N). They scale at the same rate as the input grows.

- [Big O Notation in JavaScript by Doable Danny](https://www.doabledanny.com/big-o-notation-in-javascript)
- [Big-O cheat sheet](https://www.bigocheatsheet.com/)
- [Step-by-step Big O Complexity Analysis Guide, using JavaScript](https://www.sahinarslan.tech/posts/step-by-step-big-o-complexity-analysis-guide-using-javascript)