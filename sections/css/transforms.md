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

### Three-Dimensional Transforms

The `rotate`, `scale`, and `translate` transform functions can be used not only on the 2D plane but also on the 3D plane. To create a convincing 3D effect, the `perspective` property is required.

#### Perspective

To set the distance from the user to the z = 0 plane, use the `perspective` transform function:

```css
.element {
  transform: perspective();
}
```

By setting a `perspective` value, the object is rendered as if it is being viewed from a specific distance on the z-axis. Unlike other transform function values, `perspective` must be declared first (leftmost) when there are multiple transform function values. You can find more details about how `perspective` works in regards to 3D transforms in [this CSS Tricks article.](https://css-tricks.com/how-css-perspective-works/).

#### Rotate

For rotating an element on a 3D plane, there are additional transform function values available:

```css
.element {
  transform: rotateX();
  transform: rotateY();
  transform: rotateZ();
  transform: rotate3d();
}
```

You can experiment with the first three values (rotateX, rotateY, and rotateZ) in the following CodePen example:

<p class="codepen" data-height="300" data-theme-id="dark" data-default-tab="css,result" data-slug-hash="PoJwozR" data-editable="true" data-user="TheOdinProjectExamples" style="height: 300px; box-sizing: border-box; display: flex; align-items: center; justify-content: center; border: 2px solid; margin: 1em 0; padding: 1em;">
  <span>See the Pen <a href="https://codepen.io/TheOdinProjectExamples/pen/PoJwozR">
  3D Rotate | CSS Transform</a> by TheOdinProject (<a href="https://codepen.io/TheOdinProjectExamples">@TheOdinProjectExamples</a>)
  on <a href="https://codepen.io">CodePen</a>.</span>
</p>
<script async src="https://cpwebassets.codepen.io/assets/embed/ei.js"></script>


You can also learn about how `rotate3d` works in the [MDN demonstration](https://developer.mozilla.org/en-US/docs/Web/CSS/transform-function/rotate3d()) and this one on [Quackit](https://www.quackit.com/css/functions/css_rotate3d_function.cfm).

#### Scale

For scaling an element on a 3D plane, the following additional transform function values are available:

```css
.element {
  transform: scaleZ();
  transform: scale3d();
}
```

You can see MDN's 3D cube in action with `scaleZ` [here](https://developer.mozilla.org/en-US/docs/Web/CSS/transform-function/scaleZ()) and `scale3d` [here](https://developer.mozilla.org/en-US/docs/Web/CSS/transform-function/scale3d()).

#### Translate

To translate an element on a 3D plane, you can use these additional transform function values:

```css
.element {
  transform: translateZ();
  transform: translate3d();
}
```

The `translateZ` function doesn't do much without `perspective`. Together, `perspective` and `translateZ` create the illusion of 3-dimensional distance from the rendered object, as shown in the example below:


<p class="codepen" data-height="300" data-theme-id="dark" data-default-tab="css,result" data-slug-hash="MWEYWpN" data-editable="true" data-user="TheOdinProjectExamples" style="height: 300px; box-sizing: border-box; display: flex; align-items: center; justify-content: center; border: 2px solid; margin: 1em 0; padding: 1em;">
  <span>See the Pen <a href="https://codepen.io/TheOdinProjectExamples/pen/MWEYWpN">
  TranslateZ | CSS Transform</a> by TheOdinProject (<a href="https://codepen.io/TheOdinProjectExamples">@TheOdinProjectExamples</a>)
  on <a href="https://codepen.io">CodePen</a>.</span>
</p>
<script async src="https://cpwebassets.codepen.io/assets/embed/ei.js"></script>


For a great demonstration of `translate3d`, you can check out the [MDN cube](https://developer.mozilla.org/en-US/docs/Web/CSS/transform-function/translate3d()) again.

#### Matrix

The `matrix` transform function, while not strictly a 3D transform, can combine all transform functions into one:

```css
.element {
  transform: matrix();
  transform: matrix3d();
}
```

However, `matrix` is rarely used due to its poor readability and complexity. It is not typically written by hand, and in most cases, other transform function values are preferred. You can get a gist of how `matrix` works in [this article](https://www.quackit.com/css/functions/css_matrix_function.cfm).

### Benefits of Transforms

The `transform` property is advantageous due to its impact on CSS triggers and hardware acceleration via the device's GPU. It occurs during **composition**, making it cheaper to use compared to many other CSS properties. You can learn more about CSS triggers in [The Pixel Pipeline](https://developers.google.com/web/fundamentals/performance/rendering/#the_pixel_pipeline) section from Google's Web Fundamentals.

Additionally, `transform` can be hardware-accelerated through a device's [GPU](https://en.wikipedia.org/wiki/Graphics_processing_unit), which enhances performance, especially for transitions and animations. You can check a table of which triggers are executed with each CSS property [here](https://web.archive.org/web/20220727225220/https://csstriggers.com/).

