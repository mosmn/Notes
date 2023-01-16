# Grid vs Flex

Grid and Flex are two different ways to layout your website. Grid is a two-dimensional layout system, while Flex is a one-dimensional layout system. Grid is more powerful than Flex, but Flex is easier to use. Grid is a newer technology than Flex, and it is not supported by all browsers. Flex is supported by all browsers.

### When to use Grid

When working with a two-dimensional layout, use Grid. Meaning when you need to layout your website in rows and columns.

### When to use Flex

When working with a one-dimensional layout, use Flex. Meaning when you need to layout your website in rows or columns.

# Creating a Grid

## Making a Grid Container

To create a grid, you need to make a grid container. To make a grid container, you need to set the display property to grid.

```css
.container {
  display: grid;
}
```

## Define grid tracks

To define grid tracks, you need to use the `grid-template-columns` and `grid-template-rows `properties.

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
}
```

Or, we can use the `grid-template` property to define both columns and rows at the same time.

```css
.container {
  display: grid;
  grid-template: 100px 100px 100px / 200px 200px 200px;
}
```

this will create a grid with 3 columns and 3 rows. each column will be 200px wide, and each row will be 100px high.

## Explain the difference between an implicit and explicit grid

An implicit grid is a grid that is created automatically by the browser. An explicit grid is a grid that is created by the developer.

### Implicit Grid

The implicit grid is created automatically by the browser(even if we did not explicitly define it in the grid template). The number of columns and rows in the implicit grid depends on the number of grid items in the grid container.

```html
<div class="container">
  <div>Item 1</div>
  <div>Item 2</div>
  <div>Item 3</div>
  <div>Item 4</div>
  <div>Item 5</div>
</div>
```

```css
.container {
  display: grid;
  grid-template-columns: 50px 50px;
  grid-template-rows: 50px 50px;
}
```

In the example above, we have 5 grid items, but we only defined 2 columns and 2 rows in the grid template. The browser will create the implicit grid automatically. The implicit grid will have 2 columns and 3 rows. The first 2 columns will be 50px wide, and the first 2 rows will be 50px high. The third row(the implicit row) will not have the same height as the other rows, but we can set the height of the implicit row using the `grid-auto-rows` property.

```css
.container {
  display: grid;
  grid-template-columns: 50px 50px;
  grid-template-rows: 50px 50px;
  grid-auto-rows: 50px;
}
```
By default, CSS Grid will add additional content with implicit rows. This means the extra elements would keep being added further down the grid in a vertical fashion. It would be much less common to want extra content added horizontally along the grid, but that can be set using the `grid-auto-flow: column` property and those implicit track sizes can be defined with the `grid-auto-columns` property.

## Set gaps between grid cells

To set gaps between grid cells, you need to use the `gap` property.

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
  gap: 10px;
}
```

### Explain the difference between gap and row-gap/column-gap

`gap` is a shorthand property for `row-gap` and `column-gap`. `row-gap` sets the gap between rows, and `column-gap` sets the gap between columns.

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
  gap: 10px;
}
```

is the same as:

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
  row-gap: 10px;
  column-gap: 10px;
}
```

we can also set the gap between rows and columns separately:

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
  row-gap: 10px;
  column-gap: 20px;
}
```
## Dev tools

### Display grid overlay

1. Open the dev tools
2. Go to Layout
3. Under grid overlays, select the grid container that you want to display the grid overlay for

as you can see in the image below, the grid overlay is displayed on top of the grid container.

![gridoverlay](/imgs/gridoverlay.png)

reference [Chrome DevTools](https://developer.chrome.com/docs/devtools/css/grid/) for more information.
# Positioning Grid Elements

## Positioning

### grid vs inline-grid

The `display` property can have two values: `grid` and `inline-grid`. The `grid` value creates a block-level grid container, while the `inline-grid` value creates an inline-level grid container. when we use `display:grid`, the grid container will stretch to the full width of its parent container. when we use `display:inline-grid`, the grid container will only take up the space that it needs, it does not stretch to take up space the way a block-level box would.

### To make a grid item take up more than one cell

`grid-column-start` and `grid-column-end` properties can be used to make a grid item take up more than one cell, horizontally.

```css
.item-1 {
  grid-column-start: 1;
  grid-column-end: 3;
}
```

`grid-row-start` and `grid-row-end` properties can be used to make a grid item take up more than one cell, vertically.

```css
.item-1 {
  grid-row-start: 1;
  grid-row-end: 3;
}
```

Alternatively, we can use the `grid-column` and `grid-row` properties to make a grid item take up more than one cell, horizontally and vertically.

```css
.item-1 {
  grid-column: 1 / 3;
  grid-row: 1 / 3;
}
```

## Grid area

`grid-area` is a shorthand property for `grid-row-start`, `grid-column-start`, `grid-row-end`, and `grid-column-end` all together. `grid-area: row-start / column-start / row-end / column-end;`

```css
.item-1 {
  grid-area: 1 / 1 / 3 / 3;
}
```

`grid-area` can also be used to name a grid area. and then we can use the `grid-template-areas` property to define the grid template.

```css
.item-1 {
  grid-area: header;
}
```

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
  grid-template-areas:
    "header header header"
    "main main sidebar"
    "footer footer footer";
}
```
the flow of the grid template areas is from left to right, top to bottom. so the first row is `header header header`, the second row is `main main sidebar`, and the third row is `footer footer footer`.

For more Properties, see [CSS Tricks](https://css-tricks.com/snippets/css/complete-guide-grid/#aa-css-grid-properties)



