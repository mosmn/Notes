# Responsive Images

## The Basics
- Aspect ratio: Relationship between width and height of an image.
- Problem: Shrinking width without manipulating height can cause image distortion on smaller screens.
- Solution: Avoid defining both width and height. Use flexible width and set height to auto to retain aspect ratio.

# Background-size, Background-position, and Object-fit

- [background-size](https://developer.mozilla.org/en-US/docs/Web/CSS/background-size) and [background-position](https://developer.mozilla.org/en-US/docs/Web/CSS/background-position): Work on elements with background images, not on normal img tags.
- [background-position](https://developer.mozilla.org/en-US/docs/Web/CSS/background-position): center centers the image in its container, even if the container is too small.
- [background-size](https://developer.mozilla.org/en-US/docs/Web/CSS/background-size): cover resizes the image to completely fill its container while cropping as little as possible.
- [object-fit](https://developer.mozilla.org/en-US/docs/Web/CSS/object-fit): 
    - Works on img tags.
    - fill stretches the image to fit the dimensions.
    - can also use cover or contain to adjust how the image fits the specified dimensions.

## Demo

### Background-size and Background-position
Here's a demo you can play with:

```html
<!-- HTML -->
<div class="background-image-demo"></div>
```

```css
/* CSS */
.background-image-demo {
  background-image: url('your-image-url.jpg');
  background-size: cover;
  background-position: center;
  width: 300px;
  height: 200px;
}
```

### Object-fit
Here's a demo of object-fit on an image:

```html
<!-- HTML -->
<img src="your-image-url.jpg" class="object-fit-demo" alt="Demo Image">
```

```css
/* CSS */
.object-fit-demo {
  width: 300px;
  height: 200px;
  object-fit: cover;
}
```

## Even More Control
- Different images for different screen sizes can be used for precise control.
- Use the <picture> tag for flexibility in displaying images at various resolutions.
- <picture> tag allows presenting cropped versions of images for smaller screens. 
- Docs [MDN](https://developer.mozilla.org/en-US/docs/Learn/HTML/Multimedia_and_embedding/Responsive_images#art_direction)
- Also [A Guide to the Responsive Images Syntax in HTML](https://css-tricks.com/a-guide-to-the-responsive-images-syntax-in-html/)

