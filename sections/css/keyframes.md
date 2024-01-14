# Animations vs. Transitions
- Animations and transitions both allow you to change an element's style configuration over time.
- Animations offer more capabilities and flexibility compared to transitions.
- Transitions were designed to animate an element from one state to another and are not explicitly intended for looping. Animations, on the other hand, were designed to enable looping.
- Transitions require triggers like pseudo-classes (:hover, :focus) or class changes with JavaScript to start the animation. Animations don't need triggers and will start running immediately once defined.
- Animations are more flexible and versatile compared to transitions. While transitions move an element in a straight line from point A to point B, animations provide greater control and variation.
- Both animations and transitions have their use cases. For simple changes in element states, transitions may suffice, but for more complex and looping animations, animations are better suited.

# Animation Properties
- Animation properties are used to configure animations in CSS.
- Animation properties are defined on the element that will be animated.
- The configuration stage involves specifying animation properties, which is only the first half of defining an animation.
- Animation properties include:
  - `animation-duration`: Specifies how long it takes for one animation cycle to complete.
  - `animation-name`: Specifies the custom name of the animation (e.g., "change-color") that will be defined in the @keyframes rule.
  - `animation-iteration-count`: Determines how many times the animation will run. "infinite" can be used for continuous looping.
  - `animation-direction`: Controls if the animation alternates direction on completion of one cycle or resets to the start point and repeats.

# Keyframes
- The second half of defining an animation involves using the @keyframes at-rule to define the animation behavior.
- `@keyframes` references the custom name of the animation defined in `animation-name`.
- Keyframes use percentage values to indicate the times for animation changes, where `from` and `to` are aliases for 0% and 100%, respectively.
- Additional keyframes can be defined using percentage values (e.g., 50%) to create more complex animations.
- Each keyframe specifies the CSS properties and values that should be applied at that point during the animation cycle.
- The `@keyframes` at-rule defines one animation cycle, and the animation will cycle through each keyframe in order.

# Shorthand Notation
- CSS provides a shorthand notation for animation properties.
- Example of shorthand notation:
  ```css
  #ball {
    /* ... other CSS properties ... */
    background-color: red;
    animation: 2s change-color infinite alternate;
  }
  ```
- Additional keyframes can be defined in percentages within the `@keyframes` rule to control multiple property changes during the animation.
