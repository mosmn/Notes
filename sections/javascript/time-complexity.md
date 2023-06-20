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
- O(1) - Constant Complexity
- O(log N) - Logarithmic Complexity
- O(N) - Linear Complexity
- O(N log N) - N x log N Complexity
- O(n²) - Quadratic Complexity
- O(n³) - Cubic Complexity
- O(2ⁿ) - Exponential Complexity
- O(N!) - Factorial Complexity