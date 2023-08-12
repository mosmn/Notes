# Rendering a List of Elements in JSX

[Official React documentation](https://react.dev/learn/rendering-lists)

Let's say we want to create a component that lists multiple animals:

```jsx
function App() {
  return (
    <div>
      <h1>Animals: </h1>
      <ul>
        <li>Lion</li>
        <li>Cow</li>
        <li>Snake</li>
        <li>Lizard</li>
      </ul>
    </div>
  );
}
```

But what if we want to render more than just four animals? It can be tedious and long, especially when dealing with a dynamic list. We can use expressions inside JSX using curly braces to render a dynamic list:

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

We define an array called `animals`, and inside our JSX, we use `map` to return a new array of `li` elements, adding `animal` as its text.

# Rendering a List of Components in JSX

We can use `props` to pass arguments to components. Here's a simple implementation:

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

We moved the `<ul>` element to a different component called `<List />`. This component accepts a `props` object containing the animals we defined as a property. We also created a separate component for the `<li>` element called `<ListItem />`, which accepts `props` and uses `props.animal` to render the text.

# Conditionally Rendering UI

We can make decisions within our component, like rendering animals that start with the letter "L." We'll use conditional expressions.

## Using the Ternary Operator

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

We use the `startsWith` method to check if the animal starts with the letter "L." If true, we return the `<li>` element; otherwise, we return `null`.

## Using the && Operator

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

We leverage the `startsWith` result with the `&&` operator. If the condition is true, it returns the second operand (the `<li>` element), and if the condition is false, it's ignored.

## Falsy Values in JSX

In JSX, values like `null`, `undefined`, and `false` do not render anything. However, values like `0` or an empty string render normally, so be aware of this behavior.

# Other Ways to Render Conditionally

We can use `if`, `if/else`, and `switch` to conditionally render something based on different conditions.

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

We use the `if` statements as guards to immediately return an element based on the conditions. One checks if the `animals` property exists, and the other checks if the list's length is greater than 0. If the list is empty, it returns a message.

If you remove the `animals` property when using the `List` component, the first `if` statement executes and returns "Loading..."—useful when fetching data from an API to indicate loading.

You can also achieve this with ternary and `&&` operators:

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