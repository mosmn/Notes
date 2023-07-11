# Lifecycle Methods

A component's lifecycle refers to the sequence of stages it goes through in the DOM. React provides several lifecycle methods that allow you to perform certain tasks at specific points during a component's life. The commonly used lifecycle methods are:

## componentDidMount

The `componentDidMount` method is called when a component is mounted, meaning it is inserted into the DOM tree. It is a good place to perform tasks such as connecting to web APIs, setting timers, or adding event listeners.

```jsx
class ExampleComponent extends React.Component {
  componentDidMount() {
    // Perform tasks after the component is mounted
  }

  render() {
    // Component's rendering logic
  }
}
```

## render

The `render` method is a required method in React class components. It contains the logic that determines what the component should display on the screen. Conditional rendering can be done by returning null if nothing should be shown.

```jsx
class ExampleComponent extends React.Component {
  render() {
    // Component's rendering logic
    return (
      // JSX code representing the component's UI
    );
  }
}
```

## componentDidUpdate

The `componentDidUpdate` method is called when a component updates, except for the initial render. It is useful for performing actions after a component has been updated, such as manipulating the DOM or sending network requests based on certain conditions.

```jsx
class ExampleComponent extends React.Component {
  componentDidUpdate(prevProps, prevState) {
    // Perform tasks after the component updates
    // Compare previous props and state with current props and state
    // to determine if specific actions need to be taken
  }

  render() {
    // Component's rendering logic
  }
}
```

## componentWillUnmount

The `componentWillUnmount` method is called when a component is about to be unmounted, meaning it is being removed from the DOM tree. It is typically used to clean up any resources or subscriptions created in the `componentDidMount` method.

```jsx
class ExampleComponent extends React.Component {
  componentWillUnmount() {
    // Clean up tasks before the component is unmounted
  }

  render() {
    // Component's rendering logic
  }
}
```

Note: In the latest version of React, the `componentWillUnmount` method has been deprecated. It is recommended to use other methods like `useEffect` or `cleanup functions` for performing cleanup tasks.

![Lifecycle Methods](https://i0.wp.com/programmingwithmosh.com/wp-content/uploads/2018/10/Screen-Shot-2018-10-31-at-1.44.28-PM.png?ssl=1)

---

The following code example demonstrates how these lifecycle methods can be used in a class component:

```jsx
class ChatRoom extends React.Component {
  state = {
    serverUrl: 'https://localhost:1234'
  };

  componentDidMount() {
    this.setupConnection();
  }

  componentDidUpdate(prevProps, prevState) {
    if (
      this.props.roomId !== prevProps.roomId ||
      this.state.serverUrl !== prevState.serverUrl
    ) {
      this.destroyConnection();
      this.setupConnection();
    }
  }

  componentWillUnmount() {
    this.destroyConnection();
  }

  setupConnection() {
    // Perform tasks to set up the connection
  }

  destroyConnection() {
    // Perform tasks to clean up the connection
  }

  render() {
    // Component's rendering logic
    return (
      // JSX code representing the component's UI
    );
  }
}
```

In the above example, the `componentDidMount` method is used to set up the connection, `componentDidUpdate` method is used to handle updates to `roomId` or `serverUrl`, and `componentWillUnmount` method is used to clean up the connection before the component is unmounted.

Note: The example provided uses class components, but with the introduction of React Hooks, functional components with `useEffect` can be used as an alternative to lifecycle methods.

---

These lifecycle methods allow you to control the behavior of your components at different stages of their life. By utilizing these methods effectively, you can perform actions based on specific events and ensure proper cleanup when components are unmounted.