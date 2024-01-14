# Keyboard navigation

- Keyboard navigation and accessibility are crucial for users who rely on keyboards or assistive technologies to navigate websites.
- Implementing proper keyboard navigation ensures that all users can access and interact with the content effectively.

## Focusable Elements and Event Handling

- Interactive elements like `<button>`, `<input>`, and `<a>` are focusable by default and have event handling for both mouse and keyboard interactions.
- Use these elements whenever possible, as they provide the necessary context and functionality for keyboard and screen reader users.

```html
<button onclick="nameAlerter('Rock')">Rock</button>
<button onclick="nameAlerter('Paper')">Paper</button>
<button onclick="nameAlerter('Scissors')">Scissors</button>

<script>
function nameAlerter(choice) {
  alert(choice);
}
</script>
```

## Focus Styles

- Focus styles indicate which element has keyboard focus and are crucial for keyboard users to navigate and understand the page structure.
- Do not remove focus styles completely as it can make it difficult for keyboard users to identify focused elements.
- Customize focus styles using CSS to ensure they align with your design while maintaining visibility.

```css
/* Example of custom focus styles */
button:focus {
  outline: 2px solid blue;
  /* Add your desired focus styles here */
}
```

## Tab Order

- The tab order determines the sequence in which elements receive focus when the Tab key is pressed.
- The default tab order follows the order of elements listed in the HTML file.
- Ensure that the tab order matches the visual order of elements to avoid confusion or frustration for keyboard users.

```html
<div tabindex='0'>This is the first element.</div>
<div tabindex='0'>This is the second element.</div>
```

## Hiding Content

- When hiding content until a specific event, it's crucial to ensure it remains hidden from assistive technologies until it's meant to be visible.
- Properly hiding content prevents keyboard users from accessing hidden content prematurely.
- Use the `aria-hidden` attribute to hide content from assistive technologies while still allowing keyboard access.
- Use CSS to visually hide content until it needs to be displayed.

```html
<div id="hidden-content" aria-hidden="true">
  <p>This content is hidden.</p>
</div>

<button onclick="showContent()">Show Content</button>

<script>
function showContent() {
  document.getElementById('hidden-content').removeAttribute('aria-hidden');
}
</script>

<style>
#hidden-content {
  display: none;
}
</style>
```
