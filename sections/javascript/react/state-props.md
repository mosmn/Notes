# Props

In React, props are used to share values or functionality between components. They are one of the fundamental concepts in React and play a crucial role in building applications.

- Props are used to share values and functionality between components in React.
- Props are passed from parent components to child components.
- Props are accessed using `this.props.propertyName` syntax in class components.
- Props can be passed as attributes in JSX, similar to assigning attributes to HTML elements.
- It is important to pass `props` to the constructor of the child component and call `super(props)` to be able to access `this.props` in the child component.
- Props can be used with both class components and functional components.
- Props can be functions, and they can be attached to events in JSX by assigning them to the appropriate event attribute.
- Event attributes in JSX must be camelCased.
- JavaScript code in JSX must be wrapped in curly braces.
- When passing multiple props to a component, destructuring can be used to simplify the code.
- Destructuring allows accessing props directly by their names instead of using `this.props.propertyName`.
- Binding `this` is necessary when passing methods from one component to another to ensure the correct context is maintained.
- Binding can be done using the `bind()` method in the constructor of the component.
- Destructuring is also applicable in class components when accessing props.

## Code examples

**Example 1:**

```javascript
// MyComponent.js

import React, { Component } from 'react';

class MyComponent extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <h1>{this.props.title}</h1>
      </div>
    );
  }
}

export default MyComponent;
```

```javascript
// App.js

import React, { Component } from 'react';
import MyComponent from './MyComponent';

class App extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <MyComponent title="React" />
      </div>
    );
  }
}

export default App;
```

In this example, there are two components: `MyComponent` and `App`. The `MyComponent` component is imported into `App` and rendered as a child component of `App`. In the JSX where `MyComponent` is implemented, a property called `title` is passed down as a prop. This is similar to assigning attributes to HTML elements. The value of the `title` prop is set to `"React"`. Inside the `MyComponent` component, the `title` prop can be accessed using `this.props.title`.

It's important to note that the `props` parameter is passed to the constructor of the child component (`MyComponent`) using `super(props)`. This ensures that `this.props.title` can be accessed correctly within `MyComponent`. The `super()` method is called with `props` as an argument to invoke the constructor of the parent class (`Component`).

**Example 2:**

```javascript
// MyComponent.js

import React, { Component } from 'react';

class MyComponent extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <h1>{this.props.title}</h1>
        <button onClick={this.props.onButtonClicked}>Click Me!</button>
      </div>
    );
  }
}

export default MyComponent;
```

```javascript
// App.js

import React, { Component } from 'react';
import MyComponent from './MyComponent';

class App extends Component {
  constructor(props) {
    super(props);

    this.onClickBtn = this.onClickBtn.bind(this);
  }

  onClickBtn() {
    console.log('Button has been clicked!');
  }

  render() {
    return (
      <div>
        <MyComponent title="React" onButtonClicked={this.onClickBtn} />
      </div>
    );
  }
}

export default App;
```

In this example, the `MyComponent` component is similar to the previous example, but it includes an additional prop called `onButtonClicked`. The `onButtonClicked` prop is assigned to the `onClick` event of a button element within `MyComponent`. 

In the `App` component, a method called `onClickBtn` is defined. This method will be executed when the button inside `MyComponent` is clicked. The `onClickBtn` method simply logs a message to the console. The `onClickBtn` method is passed to `MyComponent` as a prop with the name `onButtonClicked`.

To ensure that `this` refers to the correct context within the `onClickBtn` method, it needs to be bound to the component instance. This is done in the constructor of the `App` component using `this.onClickBtn = this.onClickBtn.bind(this)

`. By binding the method, we create a new function with `this` bound to the original component, ensuring that the method is always executed in the correct context.

Special Note 1: Instead of using `addEventListener` to add event listeners, React allows us to assign event handlers directly in the JSX. However, the event attributes must be camelCased. A list of supported events can be found [here](https://react.dev/reference/react-dom/components/common).

Special Note 2: The function `this.props.onButtonClicked` is wrapped in curly braces because JSX needs a way to distinguish between JavaScript code and regular HTML elements. Curly braces indicate that JavaScript is being used in the JSX, and the expression inside the braces is evaluated as JavaScript code.

Additionally, a more concise way of accessing props within the `render` method of a class component is by using destructuring. By destructuring `this.props` within the `render` method, the individual props can be accessed directly without using `this.props` repeatedly.

```javascript
// MyComponent.js

import React, { Component } from 'react';

class MyComponent extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    const { title, onButtonClicked } = this.props;

    return (
      <div>
        <h1>{title}</h1>
        <button onClick={onButtonClicked}>Click Me!</button>
      </div>
    );
  }
}

export default MyComponent;
```

In the above code snippet, the `title` and `onButtonClicked` props are destructured from `this.props`. This allows them to be directly accessed within the `render` method without using `this.props.title` or `this.props.onButtonClicked`.

Understanding the purpose and usage of props in React is essential for building components that can share data and functionality. By passing props from parent components to child components, you can create a modular and reusable code structure.