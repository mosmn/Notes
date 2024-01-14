# Templating Engines

A templating engine is a powerful tool that allows you to create dynamic web pages by inserting variables and incorporating simple logic into your views. This enables you to generate content that responds to user interactions and data changes, which would be challenging with plain HTML. While JavaScript offers several templating languages, two popular choices are Pug (formerly known as Jade) and EJS. Let's explore these concepts in more detail:

## Pug (Jade)

Pug is a templating engine known for its concise and elegant syntax. It offers a unique way of writing templates that may appear dramatically different from regular HTML. If you're comfortable with indentation-based syntax and appreciate brevity, Pug can be a great choice. Here's a brief example of Pug syntax for rendering a variable:

```pug
doctype html
html
  head
    title My Page
  body
    h1 Welcome to #{userName}'s Profile
```

## EJS (Embedded JavaScript)

EJS, or Embedded JavaScript, is another popular templating engine for JavaScript. If you've worked with Ruby on Rails and are familiar with ERB (Embedded Ruby), you'll find EJS quite similar in terms of embedding JavaScript code within your HTML. Here's a quick example of EJS syntax:

```html
<!DOCTYPE html>
<html>
  <head>
    <title>My Page</title>
  </head>
  <body>
    <h1>Welcome to <%= userName %>'s Profile</h1>
  </body>
</html>
```

Ultimately, the choice between Pug and EJS depends on your personal preferences and the requirements of your project. If you enjoy working with HTML and want to keep your templates closely aligned with standard HTML, EJS might be your preference. However, if you're open to exploring a different syntax and appreciate brevity, Pug can be an excellent choice.

# Middleware

Middleware is a critical concept in web application development, especially when working with frameworks like Express.js. It might seem like a complex term, but in essence, middleware is nothing more than a JavaScript function that Express calls between receiving a network request and sending a response. Think of it as a function that sits in the middle of the request-response cycle.

Middleware functions serve various purposes and can be customized to meet your specific needs. Here are some common examples:

1. **Logger Middleware**: This function logs details of the incoming request to the console, providing insights into the request's IP, method, and timestamp. It's valuable for debugging and monitoring requests.

```javascript
const loggerMiddleware = (req, res, next) => {
  console.log("Request IP: " + req.ip);
  console.log("Request Method: " + req.method);
  console.log("Request Date: " + new Date());

  next(); // Don't forget to call next to pass control to the next middleware.
};

app.use(loggerMiddleware);
```

2. **Authentication Middleware**: This middleware checks if the user is logged in or has the necessary permissions to access a particular route or resource. It's vital for securing your application.

3. **Static File Server Middleware**: When a user requests static files like images, CSS, or JavaScript files, this middleware serves those files directly. It enhances performance by delivering static content efficiently.

Middleware functions receive three parameters: `req` (request), `res` (response), and `next`. These parameters are conventionally named but can technically have different names. Here's what they represent:

- `req` (request): An object containing data about the incoming request, including the URL, URL parameters, request body, and more.
- `res` (response): An object representing the response that Express will send back to the client. You use this object to define what the server should respond with, such as HTML, JSON, or other data.
- `next`: A function that tells Express to move on to the next middleware function in the stack. If you forget to call `next()`, your application will hang, and subsequent middleware won't execute.

Middleware functions are executed in the order they are defined using `app.use()`. The order matters because it determines the sequence in which middleware processes requests. Understanding middleware is fundamental when building complex web applications with Express.js, as it allows you to add custom functionality to your routes and manage the request-response flow effectively.