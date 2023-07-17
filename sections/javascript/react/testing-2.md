### Mocking in Testing React Components

Mocking is a technique used in testing to replace certain parts of the system with simulated or controlled objects. In React component testing, mocking can be applied to callback handlers and child components.

#### Testing Callback Handlers

Callback handlers are essential in handling user interactions. To test a component with a callback handler, such as `FavoriteInput`, we can mock and test the `onChange` function.

```jsx
import React from "react";
import { render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import FavoriteInput from "./FavoriteInput";

describe("Favorite Input", () => {
  it("calls onChange correct number of times", async () => {
    const onChangeMock = jest.fn();
    const user = userEvent.setup();

    render(<FavoriteInput onChange={onChangeMock} />);
    const input = screen.getByRole("textbox");

    await user.type(input, "Lion");

    expect(onChangeMock).toHaveBeenCalledTimes(4);
  });

  it("calls onChange with correct argument(s) on each input", async () => {
    const onChangeMock = jest.fn();
    const user = userEvent.setup();

    render(<FavoriteInput onChange={onChangeMock} />);
    const input = screen.getByRole("textbox");

    await user.type(input, "Ox");

    expect(onChangeMock).toHaveBeenNthCalledWith(1, "O");
    expect(onChangeMock).toHaveBeenNthCalledWith(2, "Ox");
  });

  it("input has correct values", async () => {
    const onChangeMock = jest.fn();
    const user = userEvent.setup();

    render(<FavoriteInput onChange={onChangeMock} />);
    const input = screen.getByRole("textbox");

    await user.type(input, "Whale");

    expect(input).toHaveValue("Whale");
  });
});
```

In these tests, we use `jest.fn()` to mock the `onChange` handler. The first test verifies the correct number of invocations, while the second test checks the correct arguments passed to the handler. The third test ensures that the input element has the correct value.

#### Mocking Child Components

In larger component trees, testing higher-level components can become complex. To simplify the testing process, we can mock child components that are not the primary focus of the test.

```jsx
jest.mock('./child-component', () => {
  return {
    ChildComponent: () => <div>Mocked Child Component</div>,
  };
});
```

In this example, we mock the `ChildComponent` by providing a replacement implementation. This way, when testing the parent component, the child component is replaced with the mocked version, simplifying the test setup and focusing on the behavior of the parent component.

#### Note on Setup and Code Organization

It is recommended to use `userEvent.setup()` before rendering the component and to avoid calling rendering and `userEvent` functions outside of the test itself. If code repetition occurs in multiple tests, it's advised to create a setup function to streamline each test and improve code readability.

Setting up mocks can be done in a `beforeEach` block if desired, but keeping the setup within each test case helps maintain clarity and prevents leakage issues throughout the test suite. If the test file becomes too long, consider using `beforeEach` for setup, but default to setting up in each test case for easier understanding and maintainability.

# React Testing in the Real World

If you're logged in on this website, you've probably come across the project submissions list under every project. Those components are written in React and tested with the React Testing Library. In this lesson, we'll explore the `submissions-list.jsx` component and its corresponding test file.

## `submissions-list.jsx`

```jsx
import React, { useContext } from 'react';
import {
  object, func, arrayOf, bool,
} from 'prop-types';
import FlipMove from 'react-flip-move';

import Submission from './submission';
import ProjectSubmissionContext from '../ProjectSubmissionContext';

const noop = () => { };

const SubmissionsList = ({
  submissions,
  handleDelete,
  onFlag,
  handleUpdate,
  isDashboardView,
  handleLikeToggle,
  userSubmission,
}) => {
  // ...
};

SubmissionsList.defaultProps = {
  userSubmission: null,
  onFlag: noop,
  isDashboardView: false,
};

SubmissionsList.propTypes = {
  submissions: arrayOf(object).isRequired,
  userSubmission: object,
  handleDelete: func.isRequired,
  onFlag: func,
  handleUpdate: func.isRequired,
  handleLikeToggle: func.isRequired,
  isDashboardView: bool,
};

export default SubmissionsList;
```

The `submissions-list.jsx` file exports a functional component called `SubmissionsList`. It receives several props such as `submissions`, `handleDelete`, `onFlag`, `handleUpdate`, `isDashboardView`, `handleLikeToggle`, and `userSubmission`. It also imports the `Submission` component and the `ProjectSubmissionContext`.

The component renders a list of submissions based on the provided props. It uses the `FlipMove` component for animated transitions. If a `userSubmission` is present, it renders the `Submission` component for the user submission. If there are other `submissions`, it renders them in a sorted manner using the `map` function and the `Submission` component. If there are no submissions, it displays a message saying "No Submissions yet, be the first!"

## `submissions-list.test.jsx`

```jsx
import React from 'react';
import { render, screen } from '@testing-library/react';

import ProjectSubmissionContext from '../../ProjectSubmissionContext';
import SubmissionsList from '../submissions-list';

jest.mock('react-flip-move', () => ({ children }) => <div>{children}</div>);

jest.mock('../submission', () => ({ submission, isDashboardView }) => (
  <>
    <div data-test-id="submission">{submission.id}</div>
    <div data-test-id="dashboard">{isDashboardView.toString()}</div>
  </>
));

// ...

describe('submissions list', () => {
  // ...

  describe('submissions', () => {
    it('renders the submissions array in order of likes', () => {
      // ...
    });

    it('does not render any submissions when array is empty and user submission not provided, and instead renders a no submissions message', () => {
      // ...
    });
  });

  describe('user submission', () => {
    it('renders a user submission when provided', () => {
      // ...
    });

    it('does not render a user submission when not provided', () => {
      // ...
    });

    it('does not render \'no submissions\' message when array is empty but user submission is provided', () => {
      // ...
    })
  });

  describe('context', () => {
    it('renders view more section if allSubmissionsPath is provided in context', () => {
      // ...
    });

    it('does not render view more section if allSubmissionsPath is not provided in context', () => {
      // ...
    });
  });
});
```

The `submissions-list.test.jsx` file contains the test suite for the `SubmissionsList` component. It uses the React Testing Library to render the component and make assertions.

The test file mocks the `react-flip-move` package and the `Submission` component. It sets up the required props and provides a test context using `ProjectSubmissionContext.Provider`.

The test suite includes several test cases that cover different scenarios:

- Rendering the submissions array in order of likes.
- Not rendering any submissions when the array is empty and no user submission is provided.
- Rendering a user submission when provided.
- Not rendering a user submission when not provided.
- Not rendering the "no submissions" message when the array is empty but a user submission is provided.
- Rendering the view more section if `allSubmissionsPath` is provided in the context.
- Not rendering the view more section if `allSubmissionsPath` is not provided in the context.

## Arrange, Act, Assert

In the context of testing, the Arrange-Act-Assert (AAA) pattern, also known as Given-When-Then, is a common approach used to structure test cases. It helps to improve the readability and maintainability of tests. Here's how the AAA pattern is applied:

1. **Arrange**: In this step, you set up the necessary preconditions and create the required objects or data for the test case. This includes initializing variables, mocking dependencies, and configuring the system under test to be in a specific state.

2. **Act**: This step involves performing the action or operation that you want to test. It usually consists of invoking a method or triggering an event on the system under test with the provided inputs or stimuli.

3. **Assert**: The final step is to verify the expected behavior or outcome of the system under test. You make assertions to check whether the actual result matches the expected result. These assertions can include checking the state of objects, verifying returned values, or ensuring that certain side effects or interactions have occurred.

By following the AAA pattern, tests become more structured and easier to understand. Each step has a clear purpose, making it straightforward to identify what is being arranged, what action is being taken, and what is being asserted. This pattern promotes a systematic and consistent approach to writing tests.

More information about the AAA pattern on the [Arrange-Act-Assert](http://wiki.c2.com/?ArrangeActAssert) page on the C2 Wiki.