# Semantic HTML

- It's essential to use semantic HTML for better web accessibility.
- Semantic HTML provides meaning and context to elements.
- Generic containers like `<div>` and `<span>` may lack semantics and context.
- Choosing appropriate elements enhances the user experience, especially for assistive technologies.

## The Importance of Semantics

- Semantic HTML provides meaning and context for assistive technologies.
- Some elements like `<p>` lack context, while others like `<button>` provide context.
- `<div>` and `<span>` are semantically neutral, not providing context for assistive technologies.
- For interactive elements, it's better to use semantic elements like `<button>`.

Example: Fixing a non-semantic approach for a game UI

```html
<!-- Non-semantic approach -->
<div class='button-container'>
  <div class='rock'>Rock</div>
  <div class='paper'>Paper</div>
  <div class='scissors'>Scissors</div>
</div>

<!-- Semantic approach -->
<div class='button-container'>
  <button class='rock'>Rock</button>
  <button class='paper'>Paper</button>
  <button class='scissors'>Scissors</button>
</div>
```

## Using Semantic HTML Correctly

- Use `<button>` for elements meant to be interactive and clickable.
- For tabular data, use `<table>` along with appropriate related elements.
- Create a relationship between `<input>` and `<label>` for better context and increased clickable area.
- Choose appropriate `type` attributes for input fields (e.g., `type="text"`, `type="email"`, `type="tel"`).
- Use appropriate list elements (`<ol>`, `<ul>`, `<dl>`) and their related items for presenting lists.

Example: Creating a relationship between `<input>` and `<label>`

```html
<!-- Using ID attribute -->
<label for='name'>Name</label>
<input type='text' id='name' />

<!-- Without ID attribute -->
<label>
  Name
  <input type='text' />
</label>
```

## Headings and Landmarks

- Headings are defined by `<h1>` to `<h6>` elements and act as section headings.
- Landmarks are regions of a page defined by seven HTML elements: `<aside>`, `<footer>`, `<form>`, `<header>`, `<main>`, `<nav>`, `<section>`.
- Proper use of headings and landmarks improves navigation and understanding for screen reader users.

If you want to create more accessible and understandable web pages, make sure to use semantic HTML elements and provide proper headings and landmarks. This approach will significantly improve the user experience for all users, including those who rely on assistive technologies.

Look at [How screen readers navigate data tables](https://tink.uk/how-screen-readers-navigate-data-tables/)

[Why headings and landmarks are so important](https://www.youtube.com/watch?v=vAAzdi1xuUY&list=PLNYkxOF6rcICWx0C9LVWWVqvHlYJyqw7g&index=20)