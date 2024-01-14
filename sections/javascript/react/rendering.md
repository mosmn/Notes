# Rendering a List of Elements in JSX

[Official React documentation](https://react.dev/learn/rendering-lists)

```jsx
function App() {
  const animals = ["Lion", "Cow", "Snake", "Lizard"];
  return (
    <div>
      <h1>Animals: </h1>
      <ul>
        {animals.map((animal) => {
          return <li key={animal}>{animal}</li>;
        })}
      </ul>
    </div>
  );
}
```

- We use the `map` function to create an array of `<li>` elements for each animal in the `animals` array.
- The `key` attribute is added to each `<li>` element to help React optimize rendering.

# Rendering a list of components in JSX

```jsx
function ListItem(props) {
  return <li>{props.animal}</li>
}

function List(props) {
  return (
    <ul>
      {props.animals.map((animal) => {
        return <ListItem key={animal} animal={animal} />;
      })}
    </ul>
  );
}

function App() {
  const animals = ["Lion", "Cow", "Snake", "Lizard"];

  return (
    <div>
      <h1>Animals: </h1>
      <List animals={animals} />
    </div>
  );
}
```

- The `<List>` component receives the `animals` array as a prop and uses it to render a list of `<ListItem>` components.
- The `ListItem` component displays a single animal from the props.

# Conditionally rendering UI

```jsx
function List(props) {
  return (
    <ul>
      {props.animals.map((animal) => {
        return animal.startsWith("L") ? <li key={animal}>{animal}</li> : null;
      })}
    </ul>
  );
}

function App() {
  const animals = ["Lion", "Cow", "Snake", "Lizard"];

  return (
    <div>
      <h1>Animals: </h1>
      <List animals={animals} />
    </div>
  );
}
```

- We use the ternary operator to conditionally render an animal in the list if it starts with the letter "L".
- The `startsWith` method is used to check the condition.

```jsx
function List(props) {
  return (
    <ul>
      {props.animals.map((animal) => {
        return animal.startsWith("L") && <li key={animal}>{animal}</li>;
      })}
    </ul>
  );
}

function App() {
  const animals = ["Lion", "Cow", "Snake", "Lizard"];

  return (
    <div>
      <h1>Animals: </h1>
      <List animals={animals} />
    </div>
  );
}
```

- We use the `&&` operator to conditionally render an animal if it starts with the letter "L".
- The `startsWith` method returns a boolean value, which determines whether the `<li>` element is rendered or ignored.

## Falsy values in JSX

- In JSX, values like `null`, `undefined`, and `false` do not render anything.
- Values like `0` or an empty string (`""`) are valid in JSX and will be rendered as expected.

## Other ways to render conditionally

```jsx
function List(props) {
  if (!props.animals) {
    return <div>Loading...</div>;
  }

  if (props.animals.length === 0) {
    return <div>There are no animals in the list!</div>;
  }

  return (
    <ul>
      {props.animals.map((animal) => {
        return <li key={animal}>{animal}</li>;
      })}
    </ul>
  );
}

function App() {
  const animals = [];

  return (
    <div>
      <h1>Animals: </h1>
      <List animals={animals} />
    </div>
  );
}
```

- The `<List>` component handles different scenarios: when `animals` is not provided, when the list is empty, and when the list has items.
- This approach uses `if` statements to conditionally render different elements based on the state of the `animals` prop.

```jsx
function List(props) {
  return (
    <>
      {!props.animals ? (
        <div>Loading...</div>
      ) : props.animals.length > 0 ? (
        <ul>
          {props.animals.map((animal) => {
            return <li key={animal}>{animal}</li>;
          })}
        </ul>
      ) : (
        <div>There are no animals on the list!</div>
      )}
    </>
  );
}

// or
function List(props) {
  return (
    <>
      {!props.animals && <div>Loading...</div>}
      {props.animals && props.animals.length > 0 && (
        <ul>
          {props.animals.map((animal) => {
            return <li key={animal}>{animal}</li>;
          })}
        </ul>
      )}
      {props.animals && props.animals.length === 0 && <div>There are no animals in the list!</div>}
    </>
  );
}

function App() {
  const animals = [];

  return (
    <div>
      <h1>Animals: </h1>
      <List animals={animals} />
    </div>
  );
}
```

- These examples use nested ternaries and multiple `&&` operators for conditional rendering.
- The first example checks if `animals` is `null`, if it's an empty list, or if it has items, and renders the appropriate elements.
- The second example uses separate conditional expressions for each case.