# Side Effects

Are interactions with the __outside world__. Such as: API calls, DOM manipulation, timers, logging, etc.

# Using effects

Everytime the state is update the entier component is re-rendered. When we try to manipulate the state during the render phase it causes unexpected behavior. To avoid this we use the `useEffect` hook.

```jsx
import React, { useState } from "react";

export default function Clock() {
  const [counter, setCounter] = useState(0);

  setInterval(() => {
    setCounter(count => count + 1)
  }, 1000);

  return (
    <p>{counter} seconds have passed.</p>
  );
}
```
You can see the counter going crazy because the function is being called every time the component is re-rendered and the state is being updated faster than the component can render. to fix this we use the `useEffect` hook to move it outside the rendering calculation.

```jsx
import React, { useState, useEffect } from "react";

export default function Clock() {
  const [counter, setCounter] = useState(0);

  useEffect(() => {
    setInterval(() => {
      setCounter(count => count + 1)
    }, 1000);
  }, []);

  return (
    <p>{counter} seconds have passed.</p>
  );
}
```
The `useEffect` hook takes a function as an argument. This function is called after every render. The second argument is an array of dependencies. If the dependencies change, the function is called again, So if you have a state variable and want to have some side-effect occur any time the state changes, you can use this hook and mention the state variable in the dependency array. If the dependencies are an empty array, the function is only called once. in summary:

```jsx
useEffect(() => {
  // This runs after every render
});

useEffect(() => {
  // This runs only on mount (when the component appears)
}, []);

useEffect(() => {
  // This runs on mount *and also* if either a or b have changed since the last render
}, [a, b]);
```

## Clean up function

We still have an issue with the counter updating twice every second though. That can be understood as a behavior caused by the React StrictMode. It is supposed to help us catch bugs, so what is that bug here?

Notice that every time the useEffect hook runs, a new setInterval is used. When the component is unmounted, setInterval is not stopped, it keeps incrementing. This unnecessary behavior can be prevented by simply clearing the interval when the component is unmounted and that is where the third part of our useEffect hook comes in - the cleanup function.

You can return a function from the callback in the useEffect hook, which will be executed each time before the next effect is run, and one final time when the component is unmounted. In this case, let us clean up the interval with a cleanup function.

```jsx
import React, { useEffect, useState } from "react";

export default function Clock() {
  const [counter, setCounter] = useState(0);

  useEffect(() => {
    const key = setInterval(() => {
      setCounter(count => count + 1)
    }, 1000);

    return () => {
      clearInterval(key);
    }
  }, [])

  return (
    <p>{counter} seconds have passed.</p>
  );
}
```

```jsx
useEffect(
  () => {
    // execute side effect
    return () => {
      // cleanup function on unmounting or re-running effect
    }
  },
  // optional dependency array
  [/* 0 or more entries */]
)
```