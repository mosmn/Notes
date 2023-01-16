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

# Advanced Grid Properties

## Repeat

`repeat()` is a function that can be used to define the number of columns or rows in a grid template. `repeat()` takes two arguments: the number of times to repeat and the size of each column or row.

```css
.container {
  display: grid;
  grid-template-columns: repeat(3, 200px);
  grid-template-rows: repeat(3, 100px);
}
```
is the same as:

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
}
```

## Fractional units

to make tracks dynamic (which in this context means flexible or that they will take up the space that is available to them) we can use fractional units. fractional units are the opposite of static or fixed units like `150px`. The most basic fractional unit is the `fr` unit.

```css
.container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
}
```
in this example each track will take up 1/3 of the available space. if the container is 600px wide, each track will be 200px wide.

```css
.container {
  display: grid;
  grid-template-columns: repeat(3, 1fr) repeat(2, 2fr);
  grid-template-rows: repeat(3, 1fr);
}
```
this is also a way to use repeat and fractional units together. in this example, the first three tracks will be 200px wide, and the last two tracks will be 400px wide.

## Minimum and maximum track sizes: min() and max()

`min()` function will compare the values that are passed to it and always return the smallest value. `max()` function will compare the values that are passed to it and always return the largest value. both functions can take as many arguments as you want. and its kinda silly to use static values for both arguments because that wont make it flexible which is the whole point of using them in the fist place, so we can use a combination of static and dynamic values.

```css
.container {
  display: grid;
  grid-template-columns: repeat(2, min(200px, 50%));
  grid-template-rows: repeat(4, max(100px, 25%));
}
```
`min(200px, 50%)` will compare 200px and 50% of the container width and return the smallest value (since we are using it with `grid-template-columns`, the container width is used). `max(100px, 25%)` will compare 100px and 25% of the container height and return the largest value (since we are using it with `grid-template-rows`, the container height is used).

## Dynamic minimum and maximum sizes: minmax()

### minmax()
`minmax()` function is a combination of `min()` and `max()` functions. but unlike min and max `minmax()` takes two arguments only: the minimum size and the maximum size, and it can only be used with `grid-template-columns`, `grid-template-rows`, `grid-auto-columns`, and `grid-auto-rows`. and it can make sense to use static values for both arguments here.

```css
.container {
    display: grid;
    grid-template-columns: repeat(2, minmax(200px, 300px));
    grid-template-rows: repeat(4, minmax(100px, 200px));
}
```
`minmax(200px, 300px)` will prevent the items from getting smaller than 200px and larger than 300px. `minmax(100px, 200px)` will prevent the items from getting smaller than 100px and larger than 200px.

### clamp()

`clamp(minimum-size, ideal-size, maximum-size)` this function will select the ideal size if it is between the minimum and maximum sizes. if the ideal size is smaller than the minimum size, it will select the minimum size. if the ideal size is larger than the maximum size, it will select the maximum size.

```css
.container {
  display: grid;
  grid-template-columns: repeat(2, clamp(200px, 50%, 300px));
  grid-template-rows: repeat(4, clamp(100px, 25%, 200px));
}
```
`clamp(200px, 50%, 300px)` will select 50% of the container width if it is between 200px and 300px. if the 50% of the container width is smaller than 200px, it will select 200px. if the 50% of the container width is larger than 300px, it will select 300px. and since `clamp()` purpose is to make the grid flexible, we want to use a dynamic value for the ideal size. and typically a static value is used for the minimum and maximum sizes.

## auto-fit and auto-fill
