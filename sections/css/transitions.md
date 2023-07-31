# Transitions

CSS transitions let you animate a change from an element’s initial state to an end state

The CSS code demonstrates how to create a smooth transition effect on a button when the user hovers over it.

```css
button {
  border: 1px solid black;
  border-radius: 5px;
  padding: 2% 5% 2% 5%;
  background-color: white;
  color: white;
  transition-property: background-color;
  transition-duration: 1s;
  transition-timing-function: ease-out;
  transition-delay: 0.25s;
}

button:hover {
  background-color: black;
  cursor: pointer;
}
```

- The `button` class styles a button element with a black border, rounded corners, and padding.
- The initial background color is set to white, but the color will transition smoothly to black when the user hovers over the button.
- The `transition-property` specifies that only the `background-color` will be transitioned.
- The `transition-duration` sets the duration of the transition to 1 second.
- The `transition-timing-function` defines how the transition's speed changes throughout its duration. In this case, it will ease-out, meaning it starts fast and slows down towards the end.
- The `transition-delay` determines the delay before the transition starts. Here, the color change starts 0.25 seconds after the cursor rests on the button.

A more concise shorthand version of the transition is also provided:

```css
button {
  /* ... other CSS properties ... */
  background-color: white;
  transition: background-color 1s ease-out 0.25s;
}

button:hover {
  background-color: black;
}
```

- The `transition` shorthand property includes the same transition properties as above but in a more compact form.

# Performance
The notes also highlight two considerations for performance:

1. **Stacking Context**: When transitioning certain properties, such as transform, a stacking context is formed. This can impact performance, especially if multiple stacking contexts are present, leading to repaints of all elements within each context. Keeping stacking contexts to a minimum can help maintain smooth transitions.

2. **Limiting Animations to Opacity and Transform**: For the best performance on web pages, it is advised to limit animations to affecting only opacity and transform properties. Even a seemingly simple background-color change, as shown in the example, can be expensive in terms of performance.
