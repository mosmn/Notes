An important basic concept in testing is __isolation__. You should only test one method at a time, and your tests for one function should not depend upon an external function behaving correctly - especially if that function is being tested elsewhere. This is because if the external function is broken, it will cause the tests for the function you are testing to fail, even if the function you are testing is working correctly.

# Pure Functions

Tightly coupled code is hard to test! Imagine trying to write tests for a function like this:
```js
function guessingGame() {
  const magicNumber = 22;
  const guess = prompt('guess a number between 1 and 100!');
  if (guess > magicNumber) {
    alert('YOUR GUESS IS TOO BIG');
  } else if (guess < magicNumber) {
    alert('YOUR GUESS IS TOO SMALL');
  } else if (guess == magicNumber) {
    alert('YOU DID IT! 🎉');
  }
}
```
Making this testable requires us to split up all the different things that are happening. First, we do not need to test the functions prompt and alert because they are built in to the browser. They are external to our program and whoever wrote them has already tested them. What we do need to test is the number logic, which is much easier if we untangle it from the other functions:
```js
function evaluateGuess(magicNumber, guess) {
  if (guess > magicNumber) {
    return 'YOUR GUESS IS TOO BIG';
  } else if (guess < magicNumber) {
    return 'YOUR GUESS IS TOO SMALL';
  } else if (guess == magicNumber) {
    return 'YOU DID IT! 🎉';
  }
}

function guessingGame() {
  const magicNumber = 22;
  const guess = prompt('guess a number between 1 and 100!');
  const message = evaluateGuess(magicNumber, guess);
  alert(message);
}

guessingGame();
```
In this example, the only thing we really need to test is the evaluateGuess function, which is much easier to test because it has a clear input and output and doesn’t call any external functions. This implementation is much nicer as well because it’s much easier to extend. If we wanted to switch out the prompt and alerts for methods that manipulate the DOM we can do that more simply now and if we want to make our game more advanced by letting the user make multiple guesses, that is also easier.

If we had written this program with TDD it is very likely that it would have looked more like the second example to begin with. __Test driven development encourages better program architecture because it encourages you to write Pure Functions.__

## What Is A Pure Function?

1. The function always returns the same result if the same arguments are passed in. It does not depend on any state, or data, change during a program’s execution. It must only depend on its input arguments.
2. The function does not produce any observable side effects such as network requests, input and output devices, or data mutation.

That’s all there is to a pure function. If it passes the above 2 requirements it’s pure.

## What Are Observable Side Effects?

An observable side effect is any interaction with the outside world from within a function. That could be anything from changing a variable that exists outside the function, to calling another method from within a function.

__Note__: If a pure function calls a pure function this isn’t a side effect and the calling function is still pure.

Side effects include, but are not limited to:
- Making a HTTP request
- Mutating data
- Printing to a screen or console
- DOM Query/Manipulation
- Math.random()
- Getting the current time
Side effects themselves are not bad and are often required. Except, for a function to be declared pure it must not contain any. Not all functions need to be, or should be, pure.

## Pure Function Example In JavaScript

For demonstration purposes here is an example of a pure function that calculates the price of a product including tax (UK tax is 20%):
```js
function priceAfterTax(productPrice) {
 return (productPrice * 0.20) + productPrice;
}
```
It passes both 1, and 2, of the requirements for a function to be declared pure. It doesn’t depend on any external input, it doesn’t mutate any data and it doesn’t have any side effects.

__If you run this function with the same input 100,000,000 times it will always produce the same result__.

## Impure Function In JavaScript

```js
var tax = 20;
function calculateTax(productPrice) {
 return (productPrice * (tax/100)) + productPrice; 
}
```
A pure function can not depend on outside variables. It fails one of the requirements thus this function is impure.

## Why Are Pure Functions Important In JavaScript?

Pure functions are used heavily in Functional Programming. And, libraries such as ReactJS and Redux require the use of pure functions.

But, pure functions can also be used in regular JavaScript that doesn’t depend on a single programming paradigm. You can mix pure and impure functions and that’s perfectly fine.

Not all functions need to be , or should be, pure. For example, an event handler for a button press that manipulates the DOM is not a good candidate for a pure function. But, the event handler can call other pure functions which will reduce the number of impure functions in your application.

### Testability And Refactoring

Another reason to use pure functions where possible is testing and refactoring.

__One of the major benefits of using pure functions is they are immediately testable. They will always produce the same result if you pass in the same arguments.__

# Mocking

There are two solutions to the ‘tightly coupled code’ problem. The first, and best option is to simply remove those dependencies from your code as we did above, but that is simply not always possible.

The second option is mocking - writing “fake” versions of a function that always behaves exactly how you want. For example, if you’re testing a function that gets information from a DOM input, you really don’t want to have to set up a webpage and dynamically insert something into the input just to run your tests. With a mock function, you could just create a fake version of the input-grabbing function that always returns a specific value and use THAT in your test.

A few simple mocks here and there are OK. Some of your app will inevitably involve side-effects (reading from or writing to the network or filesystem, for instance). When you do have a genuine need for mocks, keep them simple. Little more than basic stubs are ideal.

The more you break your problems down into simple, [pure functions](#pure-functions), the easier it will be to test your code without mocks.

- [Mocking is a Code Smell](https://medium.com/javascript-scene/mocking-is-a-code-smell-944a70c90a6a)

# TAP

TAP is the [Test Anything Protocol](https://en.wikipedia.org/wiki/Test_Anything_Protocol#History) that has been around since 1987. Almost every important automated testing tool supports TAP output. There are TAP processors that produce colored console reports, processors that make pretty, styled HTML, processors that can branch on results and trigger various hooks, and on and on…

You could think of Tape as a pure CLI tool that takes unit tests as input and produces TAP as output. Using standard Unix tools available on every Node platform, you can integrate tape with literally any tooling that can read from stdin and understand TAP output.

Jest TAP output:
![Jest TAP output](https://www.lambdatest.com/resources/images/resolve-this-issue.png)

[Setup and Teardown](https://jestjs.io/docs/setup-teardown)

[Handling mock functions](https://jestjs.io/docs/mock-functions)

[Magic tricks of testing](https://www.youtube.com/watch?v=URSWYvyc42M)