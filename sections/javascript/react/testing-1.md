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

