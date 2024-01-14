**Type Checking** is the process of ensuring that code uses the correct data types for variables, function parameters, and return values. In React applications, we achieve this through **PropTypes**.

The official [PropTypes documentation](https://reactjs.org/docs/typechecking-with-proptypes.html)

**PropTypes** is a mechanism for validating the props received by React components. It serves as a valuable tool during development, helping to identify potential type-related errors early in the process, ultimately making bug detection and resolution more straightforward. If you've used a linter in your previous React projects, you might recall instances where it prompted you about missing prop validations.

To begin using PropTypes in your React projects, you'll need to install the PropTypes library using npm. Navigate to your React project directory and run the following command:

```bash
npm install --save prop-types
```

Once installed, you can import the PropTypes package in the component where you wish to validate props.

```javascript
import PropTypes from 'prop-types';
```

### Using PropTypes

Here's a basic example demonstrating how PropTypes are employed in a simple component that renders a `name` prop.

```javascript
import PropTypes from 'prop-types';
import React from 'react';

const RenderName = (props) => {
  return <div>{props.name}</div>;
};

RenderName.propTypes = {
  name: PropTypes.string,
};

export default RenderName;
```

In this instance, the `RenderName` component anticipates receiving a `name` prop of type string. If a prop of an incorrect type is provided, a warning will be issued. If you want to mandate that a prop is always passed, you can use `isRequired` as follows:

```javascript
RenderName.propTypes = {
  name: PropTypes.string.isRequired,
};
```

### Using defaultProps

In addition to PropTypes, you can also specify default props for your components.

```javascript
import React from 'react';
import PropTypes from 'prop-types';

const RenderName = (props) => {
  return <div>{props.name}</div>;
};

RenderName.propTypes = {
  name: PropTypes.string,
};

RenderName.defaultProps = {
  name: 'Zach',
};

export default RenderName;
```

In this example, using the `defaultProps` property, we establish a default value for the `name` prop. This ensures that if the `RenderName` component is called without explicitly passing a `name` prop, it will default to "Zach." When you do provide props explicitly, they will take precedence over the default props.
