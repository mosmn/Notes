# React Hooks

React Hooks allow you to use different React features from your components. You can either use the built-in Hooks or combine them to build your own. This document provides an overview of the commonly used built-in Hooks in React.

[Official React Hooks Documentation](https://react.dev/reference/react)

## State Hooks

State Hooks allow components to manage and update state information. There are two commonly used state Hooks:

### `useState`

The `useState` Hook is used to declare a state variable and a function to update that variable.

```jsx
import React, { useState } from "react";

const App = () => {
  const [count, setCount] = useState(0);

  const incrementCount = () => {
    setCount(count + 1);
  };

  return (
    <div>
      <div>{count}</div>
      <button onClick={incrementCount}>Increment</button>
    </div>
  );
};

export default App;
```

In the example above, we use the `useState` Hook to declare a state variable `count` initialized with the value `0`. We also get a function `setCount` to update the `count` value. Clicking the "Increment" button calls `incrementCount`, which updates the `count` value and triggers a re-render.

## Effect Hooks

Effect Hooks allow components to perform side effects, such as fetching data, subscribing to events, or manipulating the DOM. The commonly used effect Hook is:

### `useEffect`

The `useEffect` Hook is used to connect a component to an external system and manage side effects.

```jsx
import React, { useState, useEffect } from "react";

const App = () => {
  const [color, setColor] = useState("black");

  useEffect(() => {
    const changeColorOnClick = () => {
      setColor((prevColor) => (prevColor === "black" ? "red" : "black"));
    };

    document.addEventListener("click", changeColorOnClick);

    return () => {
      document.removeEventListener("click", changeColorOnClick);
    };
  }, [color]);

  return (
    <div>
      <div
        id="myDiv"
        style={{
          color: "white",
          width: "100px",
          height: "100px",
          position: "absolute",
          left: "50%",
          top: "50%",
          backgroundColor: color,
        }}
      >
        This div can change color. Click on me!
      </div>
    </div>
  );
};

export default App;
```

In the example above, we use the `useEffect` Hook to change the color of a `<div>` element on each click. The effect is triggered when the component mounts, and whenever the `color` state value changes. The effect adds an event listener for clicks and updates the `color` state based on the current color value.

You have three different options for the dependency array:

Leave it empty. If you leave it empty the useEffect hook would look something like this:
```jsx
useEffect(() => {
  // Do something
}, []);
```
This option is equal to a componentDidMount lifecycle method, meaning the hook runs one time when the component mounts (is inserted in the DOM tree)

Add a dependency to the array. Like we did it in our example code.
```jsx
useEffect(() => {
  // Do something
}, [color]);
```
This way, the useEffect hook will re-run anytime the dependency (color) changes. This is similar to a componentDidUpdate method, with the only difference that it only runs when a certain condition has changed.

Leave out the dependency array.
```jsx
useEffect(() => {
  // Do something
});
```
You can also completely leave out the dependency array. This way, the useEffect hook runs anytime the component is updated, AND right after the initial render. This is the difference compared to the componentDidUpdate lifecycle method, because it also runs after the initial render. This way it would be equal to a componentDidMount and componentDidUpdate method combined.

The return statement we are adding to our useEffect is actually equal to a componentWillUnmount method.
```jsx
return () => {
  document.removeEventListener("click", changeColorOnClick);
};
```
If you write a return statement like the above in a useEffect, it will do the same as a componentWillUnmount method. As you can see, there is a lot to the useEffect hook. You can also create your own custom hooks if desired. However, with the above mentioned hooks useState and useEffect you will be fine in most of your smaller projects.

## Ref Hooks

Ref Hooks allow components to store and access mutable values or references to DOM elements. The commonly used ref Hook is:

### `useRef`

The `useRef` Hook is used to declare a ref that can hold any mutable value.

```jsx
import React, { useRef } from "react";

const Form = () => {
  const inputRef = useRef(null);

  const focusInput = () => {
    inputRef.current.focus();
  };

  return (
    <div>
      <input ref={inputRef} type="text" />
      <button onClick={focusInput}>Focus Input</button>
    </div>
  );
};

export default Form;
```

In the example above, we use the `useRef` Hook to create a ref called `inputRef`. We attach this ref to an `<input>` element using the `ref` attribute. Clicking the "Focus Input" button calls `focusInput`, which focuses the input field using the `inputRef`.

## Custom Hooks

You can also create your own custom Hooks as reusable building blocks. Here are a few examples:

### Custom Hook: `useWindowSize`

```jsx
import React, { useEffect, useState } from "react";

const useWindowSize = () => {
  const [windowSize, setWindowSize] = useState({
    width: window.innerWidth,
    height: window.innerHeight,
  });

  useEffect(() => {
    const handleResize = () => {
      setWindowSize({
        width: window.innerWidth,
        height: window.innerHeight,
      });
    };

    window.addEventListener("resize", handleResize);

    return () => {
      window.removeEventListener("resize", handleResize);
    };
  }, []);

  return windowSize;
};

export default useWindowSize;
```

The `useWindowSize` custom Hook allows components to access the current window size.

```jsx
import React from "react";
import useWindowSize from "./useWindowSize";

const App = () => {
  const windowSize = useWindowSize();

  return (
    <div>
      <div>Window Width: {windowSize.width}px</div>
      <div>Window Height: {windowSize.height}px</div>
    </div>
  );
};

export default App;
```

In the example above, we import and use the `useWindowSize` custom Hook to get the window size. The `windowSize` object returned by the Hook contains the current width and height of the window.

These are some of the commonly used built-in Hooks in React. They provide powerful capabilities for managing state, performing side effects, and accessing and manipulating DOM elements.