## Components

Applications built with React are made up of reusable components. Components serve as the "building blocks" of your application or project. Dividing your application into separate components is a recommended practice when using React. Each component represents a specific part of your UI or functionality. Let's look at an example of how a simple homepage could be divided into components:

**Simple Homepage**

![Simple Homepage](https://cdn.statically.io/gh/TheOdinProject/curriculum/284f0cdc998be7e4751e29e8458323ad5d320303/javascript/react-js/react-introduction/imgs/00.png)

For instance, the components for a simple website could be structured as follows:

1. **App**: Represents the main application and acts as the parent component that contains all other components. It encompasses the entire page.
2. **Navbar**: Represents the navigation bar component.
3. **MainArticle**: Renders the main content of the page.
4. **NewsletterForm**: A component that displays a simple form allowing users to input their email to receive a weekly newsletter.

In React, each component is defined in an ES6 (ECMAScript 2015) module. Components are typically written in separate files and then imported into the parent component. For example:

```jsx
import ExampleComponent from "./components/ExampleComponent"
```

In the above code, we import the `ExampleComponent` from the `./components/ExampleComponent` file. The parent component, in this case, would be `App.js`.

When structuring components, it may take some time to determine the best organization, especially when dealing with concepts like state and props. However, dividing your application into components helps maintain code organization and facilitates tracking the relationships between components.

Here's an example of a basic component written in React:

```jsx
import React, { Component } from 'react'

class App extends Component {
    constructor() {
        super()
    }

    // JavaScript functions can be written here

    render() {
        return (
            <div className="App">
                Hello World!
            </div>
        )
    }
}

export default App
```

Let's break down the code step by step:

1. **Import statement**: Imports the `React` object and `Component` class from the React library. This allows us to create a class component. The use of curly brackets indicates the specific elements being imported.
2. **Class component declaration**: We declare the `App` class component by extending the `Component` class from React. This step provides the necessary methods and properties for a React component.
3. **Constructor**: The `constructor` function initializes the component. In this example, it is empty, but it becomes essential when dealing with concepts like inheritance and state.
4. **Render function**: The `render` function is a required method in React class components. It returns JSX (JavaScript XML), which resembles HTML but is actually transpiled into JavaScript. JSX allows combining JavaScript and HTML-like syntax.
5. **Export**: To reuse the `App` component in other files, we export it as the default export using `export default App`. This allows other modules to import and use the component.

Additionally, the example explains the differences between functional and class components:

- Functional components are defined as functions and do not require importing and extending the `Component` class.
- They don't have a constructor and render function. Instead, the `return` statement is placed directly in the function body.
- Functional components are more modern and often preferred for simpler components.
