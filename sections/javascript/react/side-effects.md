# side-effects

## What is a side effect?

A side effect is any application state change that is observable outside the called function other than its return value. Side effects include:
- Modifying any external variable or object property (e.g., a global variable, or a variable in the parent function scope chain)
- Logging to the console
- Writing to the screen
- Writing to a file
- Writing to the network
- Triggering any external process
- Calling any other functions with side-effects
- ...

## What is a pure function?

A pure function is a function that has the following properties:
- Its return value is the same for the same arguments (no variation with local static variables, non-local variables, mutable reference arguments or input streams from I/O devices).
- Its evaluation has no side effects (no mutation of local static variables, non-local variables, mutable reference arguments or I/O streams).
- It does not call impure functions.
- ...

## Why do we need pure functions?

Pure functions have a lot of benefits:
- They are easier to reason about and test.
- They are less prone to bugs.
- They can be run in parallel.
