# Transforms

The transform property takes in one or more CSS transform functions as its values, with those functions taking in their own value, usually an angle or a number.

Almost all elements can have the transform property applied to it, with the exceptions being <col>, <colgroup>, and non-replaced inline elements. “Non-replaced” simply refers to elements whose content is contained within the HTML document (<span>, <b>, and <em>, for example), as opposed to a “replaced” element’s content being contained outside of the document (<a>, <iframe>, and <img>, for example).

# Two-dimensional transforms

## `rotate()`

This is the transform function value to rotate an element on a 2D plane:
```css
.rotate-by-deg {
  transform: rotate(45deg);
}

.rotate-by-rad {
  transform: rotate(-1rad);
}

.rotate-by-turn {
  transform: rotate(0.3turn);
}
```

## `scale()`

These are the transform function values to scale an element on a 2D plane:
```css
.scaleX {
  transform: scaleX(0.25);
}

.scaleY {
  transform: scaleY(1.5);
}

.scaleXY {
  transform: scale(0.25, 1.5);
}

.scale {
  transform: scale(0.5);
}
```

## `skew()`

These are the transform function values to skew an element on a 2D plane:
```css
.skewX {
  transform: skewX(45deg);
}

.skewY {
  transform: skewY(-0.5rad);
}

.skewXY {
  transform: skew(45deg, -0.5rad);
}

.skew {
  /* single value behaves the same as skewX */
  transform: skew(45deg);
}
```

## `translate()`

These are the transform function values to translate an element on a 2D plane:
```css
.translateX {
  transform: translateX(20px);
}

.translateY {
  /* percent values are of the element's width */
  transform: translateY(-33%);
}

.translateXY {
  transform: translate(20px, -33%);
}
```


