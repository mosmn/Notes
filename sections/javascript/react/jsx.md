# JSX

### What is JSX?
JSX is a syntax extension for JavaScript that allows you to write HTML-like markup inside a JavaScript file. It's not required for writing React components, but it simplifies and makes the code more concise.

**Example:**
```jsx
const element = <div>This is JSX</div>;
```

### Why do we use JSX?
- JSX allows React to combine rendering logic and content in the same place (a component).
- Provides a more intuitive way to work with UI in code.
- Helps React show more useful error and warning messages.

### Rules of JSX
1. **Return a single root element:** Wrap multiple elements in a parent tag (e.g., `<div>`) or use a React fragment (`<>...</>`).

**Correct:**
```jsx
function App() {
  return (
    <>
      <h1>Example h1</h1>
      <h2>Example h2</h2>
    </>
  );
}
```

2. **Close all tags:** Explicitly close and wrap tags that are not self-closing in HTML.

**Correct:**
```jsx
function App() {
  return (
    <>
      <input />
      <li></li>
    </>
  );
}
```

3. **camelCase Most things:** Use camelCase for attributes, replacing dashes and reserved words like "class."

**Correct:**
```jsx
function App() {
  return (
    <>
      <div className="container">
        <svg>
          <circle cx="25" cy="75" r="20" stroke="green" strokeWidth="2" />
        </svg>
      </div>
    </>
  );
}
```

### Converting HTML to JSX
1. **Add a single root element:** Ensure there's a single root element containing all the elements.

**Correct:**
```jsx
return (
  <div>
    <h1>Test title</h1>
    <ol className="test-list">
      <li>List item 1</li>
      <li>List item 2</li>
      <li>List item 3</li>
    </ol>
    <svg>
      <circle cx="25" cy="75" r="20" stroke="green" strokeWidth="2" />
    </svg>
    <form>
      <input type="text" />
    </form>
  </div>
);
```

2. **Close all tags:** Ensure all tags are properly closed.

**Correct:**
```jsx
return (
  <div>
    <h1>Test title</h1>
    <ol className="test-list">
      <li>List item 1</li>
      <li>List item 2</li>
      <li>List item 3</li>
    </ol>
    <svg>
      <circle cx="25" cy="75" r="20" stroke="green" strokeWidth="2" />
    </svg>
    <form>
      <input type="text" />
    </form>
  </div>
);
```

3. **camelCase attributes:** Use camelCase for attributes.

**Correct:**
```jsx
return (
  <div>
    <h1>Test title</h1>
    <ol className="test-list">
      <li>List item 1</li>
      <li>List item 2</li>
      <li>List item 3</li>
    </ol>
    <svg>
      <circle cx="25" cy="75" r="20" stroke="green" strokeWidth="2" />
    </svg>
    <form>
      <input type="text" />
    </form>
  </div>
);
```