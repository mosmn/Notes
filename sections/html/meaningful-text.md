# Meaningful Text

Meaningful text is essential for all users, especially those who rely on assistive technologies. It allows users to understand the content without relying on surrounding context.

## Links
When creating links, follow these rules to ensure they have meaningful text:
- The text content of the `<a>` element should indicate where the link redirects to and be concise (around 100 characters).
- Avoid using phrases like "click here" or "this page."
- If a link opens or downloads a file, include text indicating the file type and size.
- If a link automatically opens in a new tab or window (`target="_blank"`), indicate this to the user.

```html
<!-- Example: Descriptive link text -->
<a href='...'>Visit The Odin Project</a>
```

## Forms

When displaying errors in forms, provide meaningful information to users:
- Clearly state what input is invalid.
- When possible, provide instructions on how to fix the error or why it occurred.
- For unique instructions, place them alongside the input. For more global instructions, place them at the top of the form or alongside the input/label.

```html
<!-- Example: Meaningful error message -->
<div class='input-error'>Error: 'JohnSmith@@test.com' is not valid. Example of a valid email: example@yourdomain.com.</div>
```

Instructions in forms can also guide users, such as indicating password requirements or indicating required fields.

## Alternative Text

The `alt` attribute on `img` elements is crucial for providing alternative text for images. Consider the following guidelines:
- Use an empty string (`alt=''`) for purely decorative images or when the image is not important for users.
- Omitting the `alt` attribute may still announce the presence of the image, which can be confusing.
- Choose alternative text that describes the image's function and context.

```html
<!-- Example: Empty alt attribute for decorative image -->
<img src='...' alt='' />

<!-- Example: Meaningful alt attribute -->
<img src='...' alt='Odin' />
```

The choice of alternative text depends on the image's purpose and the surrounding context. Refer to the [WebAIM guide on Alternative Text](https://webaim.org/techniques/alttext) to learn more about effectively adding alternative text for images.

By providing meaningful text in links, forms, and alt attributes, you enhance accessibility and improve the user experience for all users, including those who rely on assistive technologies.