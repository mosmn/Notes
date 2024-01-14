# Lifecycle Methods

A component's lifecycle refers to the sequence of stages it goes through in the DOM. React provides several lifecycle methods that allow you to perform certain tasks at specific points during a component's life. The commonly used lifecycle methods are:

## componentDidMount

The `componentDidMount` method is called when a component is mounted, meaning it is inserted into the DOM tree. It is a good place to perform tasks such as connecting to web APIs, setting timers, or adding event listeners. [See more](https://react.dev/reference/react/Component#componentdidmount)

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

The `componentDidUpdate` method is called when a component updates, except for the initial render. It is useful for performing actions after a component has been updated, such as manipulating the DOM or sending network requests based on certain conditions. [See more](https://react.dev/reference/react/Component#componentdidupdate)

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
`prevProps` and `prevState` are built-in objects provided by React. They are parameters passed to the `componentDidUpdate` method and contain the previous props and state values of the component.

`nextProps` and `nextState` are also built-in objects provided by React. They are parameters passed to the `shouldComponentUpdate` method and contain the next props and state values of the component.

## componentWillUnmount

The `componentWillUnmount` method is called when a component is about to be unmounted, meaning it is being removed from the DOM tree. It is typically used to clean up any resources or subscriptions created in the `componentDidMount` method.[See more](https://react.dev/reference/react/Component#componentwillunmount)

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

# Example

Code from this [video](https://www.youtube.com/watch?v=m_mtV4YaI8c).

```jsx
import './App.css';
import React, { Component } from 'react';

const ErrorComponent = () => <div>{props.ignore}</div>;

class Counter extends Component {
  constructor(props) {
    console.log('Constructor');
    super(props);

    this.state = {
      count: 0,
      seed: 0,
    };

    this.increment = () => this.setState({ count: this.state.count + 1 });
    this.decrement = () => this.setState({ count: this.state.count - 1 });
  }

  // Executed during mounting and updating phases
  static getDerivedStateFromProps(props, state) {
    if (props.seed && state.seed !== props.seed) {
      console.log('Get Derived State From Props');
      console.log('-------------------');
      // Returns an object to update the state based on the props
      return {
        seed: props.seed,
        count: props.seed,
      };
    }
    console.log('Get Derived State From Props - DO NOT UPDATE STATE');
    console.log('-------------------');
    return null;
  }

  // Executed after the component output has been rendered to the DOM
  componentDidMount() {
    console.log('Component Did Mount');
    console.log('-------------------');
  }

  // Executed before rendering when new props or state are received
  shouldComponentUpdate(nextProps) {
    if (nextProps.ignoreProp && this.props.ignoreProp !== nextProps.ignoreProp) {
      console.log('Should Component Update - DO NOT RENDER');
      console.log('-------------------');
      return false; // Prevents re-rendering of the component
    }
    console.log('Should Component Update - RENDER');
    console.log('-------------------');
    return true; // Allows re-rendering of the component
  }

  // Executed right before the changes from Virtual DOM are to be reflected in the DOM
  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log('Get Snapshot Before Update');
    console.log('-------------------');
    return null;
  }

  // Renders the component's UI
  render() {
    console.log('Render');

    if (this.props.showErrorComponent && this.state.error) {
      return <div>We have encountered an error! {this.state.error.message}</div>;
    }

    return (
      <div>
        <button onClick={this.increment}>+</button>
        <button onClick={this.decrement}>-</button>
        <div className="counter">Counter: {this.state.count}</div>
        {this.props.showErrorComponent ? <ErrorComponent /> : null}
      </div>
    );
  }

  // Executed after the component's updates are flushed to the DOM
  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log('Component Did Update');
    console.log('-------------------');
  }

  // Executed immediately before a component is unmounted and destroyed
  componentWillUnmount() {
    console.log('Component Will Unmount');
    console.log('-------------------');
  }

  // Catches and handles errors that occur within child components
  componentDidCatch(error, info) {
    console.log('Component Did Catch');
    console.log('-------------------');

    this.setState({ error, info });
  }
}

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      mount: true,
      ignoreProp: 0,
      seed: 40,
      showErrorComponent: false,
    };

    this.mountCounter = () => this.setState({ mount: true });
    this.unmountCounter = () => this.setState({ mount: false });
    this.ignoreProp = () => this.setState({ ignoreProp: Math.random() });
    this.seedGenerator = () => this.setState({ seed: Number.parseInt(Math.random() * 100) });
    this.toggleError = () => this.setState({ showErrorComponent: !this.state.showErrorComponent });
  }

  render() {
    return (
      <div className="App">
        <h1>React Practice</h1>
        <button onClick={this.mountCounter} disabled={this.state.mount}>
          Mount Counter
        </button>
        <button onClick={this.unmountCounter} disabled={!this.state.mount}>
          Unmount Counter
        </button>
        <button onClick={this.ignoreProp}>Ignore Prop</button>
        <button onClick={this.seedGenerator}>Generate Seed</button>
        <button onClick={this.toggleError}>Toggle Error</button>
        {this.state.mount ? (
          <Counter
            ignoreProp={this.state.ignoreProp}
            seed={this.state.seed}
            showErrorComponent={this.state.showErrorComponent}
          />
        ) : null}
      </div>
    );
  }
}

export default App;
```
