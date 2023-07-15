# Setup

**NOTE: If you are initializing your React repositories with `create-react-app`, all the necessary packages should come preinstalled, and the `package.json` file should have the required scripts preconfigured.**

1. Import the necessary packages in your testing file. Make sure to include the following:

```javascript
import React from "react";
import { ... } from "@testing-library/react";
import "@testing-library/jest-dom";
import userEvent from "@testing-library/user-event";
import TestComponent from "path-to-test-component";
```

2. Install the required packages if they are not already included in your project. You can use a package manager like npm or yarn to install them. For example:

```shell
npm install @testing-library/react @testing-library/jest-dom
npm install @testing-library/user-event
```

3. Note that the `@testing-library/react` package provides useful functions like `render`, which we will use later in the tests.

4. Optionally, include the `@testing-library/jest-dom` package. This package provides custom matchers (assertive functions) like `toBeInTheDocument`, which can be helpful in testing. Although Jest already includes many matchers, this package enhances the testing experience. You can find a complete list of matchers on the `jest-dom` GitHub page.

5. Import the `userEvent` API from the `@testing-library/user-event` package. This API allows you to simulate user interactions with the webpage during testing. Alternatively, you could import the `fireEvent` API from `@testing-library/react`. However, it is recommended to use `userEvent` instead of `fireEvent` as it provides a more comprehensive set of user interactions.

6. There is no need to import the `jest` package explicitly since it will be automatically detected by Jest, especially when running test files with the `.test.js` or `.test.jsx` extension.

[The React Testing Library Official Documentation](https://testing-library.com/docs/)

# Queries

Queries are the methods that Testing Library gives you to find elements on the page. There are several types of queries ("get", "find", "query").

Type of Query | 0 Matches | 1 Match | >1 Matches | Retry (Async/Await)
--- | --- | --- | --- | ---
Single Element | | | |
getBy... | Throw error | Return element | Throw error | No
queryBy... | Return null | Return element | Throw error | No
findBy... | Throw error | Return element | Throw error | Yes
Multiple Elements | | | |
getAllBy... | Throw error | Return array | Return array | No
queryAllBy... | Return [] | Return array | Return array | No
findAllBy... | Throw error | Return array | Return array | Yes

[Source](https://testing-library.com/docs/queries/about/#types-of-queries)
[the React Testing Library’s cheatsheet page](https://testing-library.com/docs/dom-testing-library/cheatsheet/)

## Priority

User agents acquire information from the DOM and create a parallel structure called the accessibility tree, made up of accessible objects. An accessible object provides information about its role, states, and properties. An example is an accessible object whose role is `menuitem`, is currently in an `enabled` state, with a `haspopup` property, indicating that it leads to a sub-menu.

The two properties of accessible objects described in this document are its accessible name and accessible description. The name is a short label that provides information about the purpose of the object. An example of an accessible name for a menu item is `New`, signifying that the menu item provides for the creation of new documents, windows, and so on.

Your test should resemble how users interact with your code (component, page, etc.) as much as possible. With this in mind, we recommend this order of priority:

1. Queries Accessible to Everyone Queries that reflect the experience of visual/mouse users as well as those that use assistive technology.
    1. `getByRole`: This can be used to query every element that is exposed in the accessibility tree. With the name option you can filter the returned elements by their accessible name. This should be your top preference for just about everything. There's not much you can't get with this (if you can't, it's possible your UI is inaccessible). Most often, this will be used with the name option like so: getByRole('button', {name: /submit/i}). Check the [list of roles](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Techniques#roles).
    2. `getByLabelText`: This method is really good for form fields. When navigating through a website form, users find elements using label text. This method emulates that behavior, so it should be your top preference.
    3. `getByPlaceholderText`: A placeholder is not a substitute for a label. But if that's all you have, then it's better than alternatives.
    4. `getByText`: Outside of forms, text content is the main way users find elements. This method can be used to find non-interactive elements (like divs, spans, and paragraphs).
    5. `getByDisplayValue`: The current value of a form element can be useful when navigating a page with filled-in values.
2. Semantic Queries HTML5 and ARIA compliant selectors. Note that the user experience of interacting with these attributes varies greatly across browsers and assistive technology.
    1. `getByAltText`: If your element is one which supports alt text (img, area, input, and any custom element), then you can use this to find that element.
    2. `getByTitle`: The title attribute is not consistently read by screenreaders, and is not visible by default for sighted users
3. Test IDs
    1. `getByTestId`: The user cannot see (or hear) these, so this is only recommended for cases where you can't match by role or text or it doesn't make sense (e.g. the text is dynamic).

[Source](https://testing-library.com/docs/queries/about/#priority)

### Example

Here are the step-by-step instructions for rendering the component and writing the test:

1. Create a component file called `App.js` and define the `App` component.

```javascript
// App.js
import React from "react";

const App = () => <h1>Our First Test</h1>;

export default App;
```

2. Create a test file called `App.test.js` for the `App` component.

```javascript
// App.test.js
import React from "react";
import { render, screen } from "@testing-library/react";
import App from "./App";

describe("App component", () => {
  it("renders correct heading", () => {
    render(<App />); //returns an object with several useful methods
    expect(screen.getByRole("heading").textContent).toMatch(/our first test/i);
  });
});
```

3. In the test file, import the necessary packages and functions. Make sure to include `render` and `screen` from `@testing-library/react`.

4. In the test code, use the `render` function to render the `App` component. The `render` function returns an object containing several useful methods for querying and interacting with the rendered component.

5. Use the `expect` function to make an assertion about the rendered output. In this case, we are using the `screen.getByRole` method to query for a heading element and asserting that its text content matches the regex pattern `/our first test/i`.

6. Run the tests by executing `npm test App.test.js` in the terminal. If the test passes, you will see a success message.

7. Note that the `getByRole` method is just one of the query methods provided by React Testing Library. There are other query methods categorized into three types: `getBy`, `queryBy`, and `findBy`. You can learn more about these query methods and their usage in the React Testing Library documentation under the "Queries" section. Pay extra attention to the "Types of Queries" and "Priority" subsections to understand how to select the appropriate query method for your tests.

8. As mentioned in the React Testing Library documentation, `ByRole` methods are recommended for querying, especially when combined with the `name` option. For example, you can improve the specificity of the query by using `getByRole("heading", { name: "Our First Test" })`. Queries performed through `ByRole` ensure that the UI remains accessible to all users, regardless of the mode they use to navigate the webpage (e.g., mouse or assistive technologies).

## Simulating User Events

To test the functionality of a button that changes the heading of the App component, we can simulate user events using React Testing Library and the [userEvent](https://testing-library.com/docs/user-event/intro) library.

### App.js

```jsx
import React, { useState } from "react";

const App = () => {
  const [heading, setHeading] = useState("Magnificent Monkeys");

  const clickHandler = () => {
    setHeading("Radical Rhinos");
  };

  return (
    <>
      <button type="button" onClick={clickHandler}>
        Click Me
      </button>
      <h1>{heading}</h1>
    </>
  );
};

export default App;
```

### App.test.js

```jsx
import React from "react";
import { render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import App from "./App";

describe("App component", () => {
  it("renders magnificent monkeys", () => {
    const { container } = render(<App />);
    expect(container).toMatchSnapshot();
  });

  it("renders radical rhinos after button click", async () => {
    const user = userEvent.setup();

    render(<App />);
    const button = screen.getByRole("button", { name: "Click Me" });

    await user.click(button);

    expect(screen.getByRole("heading").textContent).toMatch(/radical rhinos/i);
  });
});
```

**Note:** If you encounter a test failure related to the `setup` function not being found, it may indicate that you are using an older version of the `@testing-library/user-event` package that does not include the `setup` function. To resolve this issue, you can update the package to the latest version.

Run the following command to update the `@testing-library/user-event` package:

```shell
npm install --save-dev @testing-library/user-event@latest
```

- The first test ensures that the component renders the "Magnificent Monkeys" heading correctly by using snapshots.
- The second test simulates a click event on the button using `userEvent.click`. It then checks if the heading has changed to "Radical Rhinos" by matching the text content with a regex pattern.

It's important to note that React Testing Library unmounts the rendered components after each test. Therefore, we render the component for each test. If you have multiple tests for a component, you can use the `beforeEach` function provided by Jest to set up the common setup code.

In the second test, the callback function is marked as asynchronous because `user.click()` simulates an asynchronous user interaction. Starting from version 14.0.0 of the testing library's user-event APIs, the user-event APIs have been updated to be asynchronous. However, in older versions, the synchronous `userEvent.click()` method was used:
```javascript
it("renders radical rhinos after button click", () => {
  render(<App />);
  const button = screen.getByRole("button", { name: "Click Me" });

  userEvent.click(button);

  expect(screen.getByRole("heading").textContent).toMatch(/radical rhinos/i);
});
```

To ease the transition from version 13 to version 14, the `userEvent.setup()` function is called internally. This setup approach is still supported in React Testing Library.

By simulating user events, we can test the behavior of components and ensure they respond correctly to user interactions.

## Snapshot Testing

Snapshot testing is a testing approach that involves comparing the rendered output of a component with a previously saved snapshot file. The snapshot file is an HTML representation of the component's structure and is automatically generated during the initial test run.

### Snapshot Example

The automatically generated snapshot file for the "magnificent monkeys render" test in `App.test.js` looks like this:

```javascript
// App.test.js.snap

exports[`magnificent monkeys render 1`] = `
<div>
  <button
    type="button"
  >
    Click Me
  </button>
  <h1>
    Magnificent Monkeys
  </h1>
</div>
`;
```

This snapshot represents the HTML structure of the rendered `App` component. In future snapshot assertions, this snapshot will be compared against the actual rendered output of the component. If there are any differences, the test will fail and alert the developer to review and update the snapshot(by pressing `u` in the terminal).

### Benefits of Snapshot Testing

Snapshot tests offer several advantages:

1. **Simplicity**: Snapshot tests are easy to write since they require only a single assertion. Instead of manually asserting each element's existence, a `toMatchSnapshot` assertion compares the rendered output against the snapshot.

2. **Quick Feedback**: Snapshot tests are fast to execute, providing quick feedback about any unintended changes in the component's appearance or structure.

3. **Preventing Unexpected Changes**: Snapshots act as a safety net, preventing unexpected changes from creeping into the codebase. If the component changes even slightly, the test will fail, alerting the developer to review and update the snapshot.

### Limitations and Considerations

However, snapshot tests have some limitations and considerations:

1. **Interpretation of Results**: Passing a snapshot test doesn't guarantee that the component is functionally correct. Snapshot tests primarily focus on detecting changes in the rendered output. Other tests, such as unit tests or integration tests, are better suited for verifying behavior and functionality.

2. **False Positives**: Snapshot tests may produce false positives, leading to passing tests even when a bug exists. Snapshot tests cannot ensure the correctness of the component's logic or behavior.

3. **False Negatives**: Even small changes, such as fixing punctuation or updating HTML tags for semantic purposes, can cause snapshot tests to fail. This may result in a loss of confidence in the test suite, requiring unnecessary updates to the snapshots.
