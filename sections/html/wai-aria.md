# WAI-ARIA

WAI-ARIA stands for the Web Accessibility Initiative's Accessible Rich Internet Applications specification. Its purpose is to make web content more accessible when native HTML is insufficient. ARIA fills in the gaps left by native HTML and can modify the semantics or context of an element.

**ARIA Limitations:**
- ARIA cannot modify an element's appearance or behavior.
- It cannot add focusability or keyboard event handling to elements.

When using ARIA, additional steps may be required to add missing semantics or functionality.

## The Five Rules of ARIA

1. Always prioritize native HTML elements and attributes over ARIA when possible.
2. Avoid changing native semantics unless necessary.
3. All interactive ARIA controls must be usable with a keyboard.
4. Never use `role='presentation'` or `aria-hidden='true'` on focusable elements.
5. All interactive elements must have an accessible name.

## The Accessibility Tree

The accessibility tree is based on the DOM (Document Object Model) and contains accessibility-related information used by assistive technologies. ARIA works by modifying properties of objects in this accessibility tree.

The two key properties we'll focus on are:
- **Name**: Also known as the "accessible name," this is announced to users by assistive technologies and distinguishes elements from one another. It can be set by native labels, including element text contents, the `<label>` element, or the `alt` attribute.
- **Description**: This complements the accessible name and is announced by assistive technologies.

## ARIA Labels

ARIA labels improve web page content understanding for assistive technology users by overriding native labels or providing additional descriptive text.

### `aria-label`

- Overrides the native label of an element and modifies its name property in the accessibility tree.
- Best used when an element lacks a native label.
- Not effective on some HTML elements like `<div>` or `<span>`.
- Example: `<button type='button' aria-label='Close menu'>X</button>`

### `aria-labelledby`

- Overrides both the native label and the `aria-label` attribute.
- Changes an element's accessible name to a concatenated string of text contents or `alt` attributes of labeling elements (referenced by their IDs).
- Example:
```
<!-- Labelling element -->
<h2 id='label'>Shirts</h2>

<!-- Labelled element -->
<button type='button' id='shop-btn' aria-labelledby='label shop-btn'>Shop Now</button>
```

### `aria-describedby`

- Modifies the description property in the accessibility tree.
- Passes in IDs of other elements as the `aria-describedby` value to provide additional context or requirements.
- Example:
```
<label>Password:
  <input type='password' aria-describedby='password-requirements' />
</label>

<!-- Meaningful text + ARIA! -->
<span id='password-requirements'>Password must be at least 10 characters long.</span>
```

## Hiding Content from the Accessibility Tree

The `aria-hidden` attribute hides certain elements, like decorative images and icons, from the accessibility tree while keeping them visible to sighted users. This can be useful when using icons within other elements.

- Example 1:
```
<button type='button'>
  <span class='material-icons'>add</span>
  Add Book
</button>
```
- Example 2:
```
<button type='button'>
  <span class='material-icons' aria-hidden='true'>add</span>
  Add Book
</button>
```

Be cautious when using `aria-hidden='true'`, as it will also hide all children of that element from the accessibility tree. Additionally, do not use `aria-hidden='true'` on focusable elements to avoid confusing screen reader users who navigate the page via keyboard.