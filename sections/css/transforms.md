# Transforms

The transform property takes in one or more CSS transform functions as its values, with those functions taking in their own value, usually an angle or a number.

Almost all elements can have the transform property applied to it, with the exceptions being <col>, <colgroup>, and non-replaced inline elements. “Non-replaced” simply refers to elements whose content is contained within the HTML document (<span>, <b>, and <em>, for example), as opposed to a “replaced” element’s content being contained outside of the document (<a>, <iframe>, and <img>, for example).

# Two-dimensional transforms

## `rotate()`

This is the transform function value to rotate an element on a 2D plane:
```css
.element {
  transform: rotate();
}
```