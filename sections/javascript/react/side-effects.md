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