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

Here are the additional notes based on the provided instructions:

# Refrences

1. **Using CSS Transitions**:
   - Read the MDN article for [using CSS transitions](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Transitions/Using_CSS_transitions) to learn about CSS transitions and animations.
   - Pay special attention to the [Defining transitions](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Transitions/Using_CSS_transitions#defining_transitions) section of the article, which provides detailed explanations and examples of how to define transitions in CSS.
   - Code along with the examples to get hands-on experience and become familiar with the syntax used in CSS transitions.

2. **Understanding the Stacking Context**:
   - To gain a deeper understanding of the stacking context in CSS, read the MDN article about [the stacking context](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Positioning/Understanding_z_index/The_stacking_context).
   - The stacking context is an important concept to grasp, especially when dealing with transitions that may create stacking contexts and affect the performance of rendering elements on the page.

3. **Creating Performant CSS Animations**:
   - Improve your knowledge of creating efficient CSS animations by reading [this article](https://web.dev/animations-guide/).
   - The article offers useful tips and best practices for optimizing animations to achieve smooth and performant results on web pages.
   - Additionally, explore [CSS Triggers](https://web.archive.org/web/20220727225220/https://csstriggers.com/) to understand how animatable CSS properties can impact other elements. Compare properties like `background-color` and `transform` to see their differences in performance.

4. **Debugging Repaint Issues with CSS Transitions**:
   - Learn how to identify and troubleshoot repaint issues related to CSS transitions by referring to the article from [Dzhavat Ushev](https://dzhavat.github.io/2021/02/18/debugging-layout-repaint-issues-triggered-by-css-transition.html).
   - Understanding how to catch and debug repaint issues can help you optimize your transitions and ensure smooth rendering on your web pages.

