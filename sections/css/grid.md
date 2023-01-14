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

To define grid tracks, you need to use the grid-template-columns and grid-template-rows properties.

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
}
```

this will create a grid with 3 columns and 3 rows. each column will be 200px wide, and each row will be 100px high.

## Explain the difference between an implicit and explicit grid

An implicit grid is a grid that is created automatically by the browser. An explicit grid is a grid that is created by the developer.

## Set gaps between grid cells

To set gaps between grid cells, you need to use the grid-gap property.

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
  grid-gap: 10px;
}
```

### Explain the difference between grid-gap and grid-row-gap/grid-column-gap

grid-gap is a shorthand property for grid-row-gap and grid-column-gap. grid-row-gap sets the gap between rows, and grid-column-gap sets the gap between columns.

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
  grid-gap: 10px;
}
```

is the same as:

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
  grid-row-gap: 10px;
  grid-column-gap: 10px;
}
```

we can also set the gap between rows and columns separately:

```css
.container {
  display: grid;
  grid-template-columns: 200px 200px 200px;
  grid-template-rows: 100px 100px 100px;
  grid-row-gap: 10px;
  grid-column-gap: 20px;
}
```
