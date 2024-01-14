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

# Chaining multiple transforms

Chaining multiple transforms is as simple as adding more transform functions with a space between each one.

```html
<div class="red-box"></div>
<div class="blue-box"></div>
```

```css
.red-box,
.blue-box {
  position: absolute;
  width: 100px;
  height: 100px;
}

.red-box {
  background: red;
  transform: rotate(45deg) translate(200%);
}

.blue-box {
  background: blue;
  transform: translate(200%) rotate(45deg);
}
```
We chained rotate and translate function values to both boxes, but in different orders. According to [MDN’s transform docs](https://developer.mozilla.org/en-US/docs/Web/CSS/transform#values): “The transform functions are multiplied in order from left to right, meaning that composite transforms are effectively applied in order from right to left.”

# Three-Dimensional Transforms

The `rotate`, `scale`, and `translate` transform functions aren't limited to just the 2D plane. They work for the 3D plane as well! However, to perceive a 3D effect on some of these function values, `perspective` is required.

From here on, the examples get more complicated, so there will be more links to external resources which do an excellent job describing how each property works. Play around with these properties until you feel comfortable with them, but be careful not to get too sidetracked with them.

#### Perspective

This is the transform function value to set the distance from the user to the z = 0 plane:

```css
.element {
  transform: perspective();
}
```

Essentially, by setting a `perspective` value, we are telling the object to render as if we were viewing it from a specific distance on the z-axis.

Unlike other transform function values, `perspective` must be declared first (leftmost) when there are multiple transform function values. In the upcoming examples for `rotate`, `scale`, and `translate`, we will be able to see how it affects the target element.

For more details on how `perspective` works in regards to 3D transforms, [check out this CSS Tricks article](https://css-tricks.com/how-css-perspective-works/).

#### Rotate

These are the additional transform function values to rotate an element on a 3D plane:

```css
.element {
  transform: rotateX();
  transform: rotateY();
  transform: rotateZ();
  transform: rotate3d();
}
```

Below is a CodePen that shows how the first three values affect the target element.

See the Pen [3D Rotate | CSS Transform](https://codepen.io/TheOdinProjectExamples/pen/PoJwozR) by TheOdinProject (@TheOdinProjectExamples) on CodePen.

To learn about how `rotate3d` works, check out [this great demonstration on MDN](https://developer.mozilla.org/en-US/docs/Web/CSS/transform-function/rotate3d()) and [this one on Quackit](https://www.quackit.com/css/functions/css_rotate3d_function.cfm).

#### Scale

These are the additional transform function values to scale an element on a 3D plane:

```css
.element {
  transform: scaleZ();
  transform: scale3d();
}
```

See MDN's 3D cube in action with `scaleZ` [here](https://developer.mozilla.org/en-US/docs/Web/CSS/transform-function/scaleZ()) and `scale3d` [here](https://developer.mozilla.org/en-US/docs/Web/CSS/transform-function/scale3d()).

#### Translate

These are the additional transform function values to translate an element on a 3D plane:

```css
.element {
  transform: translateZ();
  transform: translate3d();
}
```

`translateZ` doesn't do much without `perspective`. Instead, `perspective` and `translateZ` work together to create the illusion of 3-dimensional distance from the rendered object, as shown in the example below.

See the Pen [TranslateZ | CSS Transform](https://codepen.io/TheOdinProjectExamples/pen/MWEYWpN) by TheOdinProject (@TheOdinProjectExamples) on CodePen.

For a great demonstration on `translate3d`, check out [the MDN cube again](https://developer.mozilla.org/en-US/docs/Web/CSS/transform-function/translate3d())!

#### Matrix

While not strictly a 3D transform function, matrix is mentioned last in this lesson due to how uncommonly used it is. These are the transform function values for it.

```css
.element {
  transform: matrix();
  transform: matrix3d();
}
```

Matrix is a way of combining all transform functions into one. It is seldom used due to its poor readability, and almost never written by hand. Unless you have a very complex transformation to apply, you should use other transform function values instead.

It is enough for you to know *that* these functions exist and generally how they work. However, it is not important for you to feel comfortable building with them. Skim [this article](https://www.quackit.com/css/functions/css_matrix_function.cfm) to get the gist of `matrix`.

### Benefits of Transforms

In order to understand why the `transform` property is great, you have to be aware of CSS triggers. You can learn about it in [The Pixel Pipeline](https://developers.google.com/web/fundamentals/performance/rendering/#the_pixel_pipeline) section from Google's Web Fundamentals.

The key benefit of using `transform` is that it occurs during **composition**. This makes it cheaper to use compared to many other CSS properties. You can see a table of what triggers are executed with each CSS property [here](https://web.archive.org/web/20220727225220/https://csstriggers.com/).

Another benefit of `transform` is that it can be hardware-accelerated via a device's [GPU](https://en.wikipedia.org/wiki/Graphics_processing_unit) (you don't have to understand how a GPU works but it is good to be aware of the term and what it means). This benefit is more prominent when it comes to transitions and animations which you will learn about in the following lessons.

