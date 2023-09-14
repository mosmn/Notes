# What is Node?

The Node.js website declares:

> "As an asynchronous event-driven JavaScript runtime, Node is designed to build scalable network applications."

The important bit to understand right up front is that Node is a **JavaScript runtime**. When JavaScript was first created, it was designed to run in the browser. This means that it was impossible to use JavaScript to write any kind of program that was not a website. Node brings JavaScript out of browser-land. This allows developers to use JavaScript to accomplish pretty much anything that other popular server-side languages such as Ruby, PHP, C#, and Python can do. So, at its most basic level, Node simply allows you to run JavaScript code on a machine such as your local computer or a server without having to go through a web browser.

To facilitate this, Node has some added functionality that is not found in browser-based JavaScript, such as the ability to read and write local files, create HTTP connections, and listen to network requests.

## Event-driven

Back to the definition from Node’s website: Node is an **asynchronous event-driven JavaScript runtime**. In this context, asynchronous means that when you write your code, you do not try to predict the exact sequence in which every line will run. Instead, you write your code as a collection of smaller functions that get called in response to specific events such as a network request (event-driven).

For example, let’s say you are writing a program, and you need it to do the following. It should read some text from a file, print that text to the console, query a database for a list of users, and filter the users based on their age.

Instead of telling your code to do those steps sequentially like so:

1. Read File
2. Print File Contents
3. Query Database
4. Filter Database Query results

You can break up the task like so:

- Read File AND THEN Print File Contents
- Query Database AND THEN Filter Database Query Results.

When you run this program, Node will start at the top and begin reading the file, but since that is an action that takes some time, it will immediately begin running the second step (querying the database) while it’s waiting on the file to finish reading.

While both of these processes are running, Node sits and waits on an event. In this case, it is waiting on the completion of both processes, the reading of a file and the database query. When either of these tasks is finished, Node will fire off an event that will run the next function we’ve defined. So if the read-file process finishes first, it will print the file contents. If the database query finishes first, it will start the filtering process. As the programmer, we don’t know or care which order the two processes are going to be completed. If this code was processed synchronously (rather than asynchronously), we would have to wait for each step in the program before moving on to the next one, which could cause things to slow down considerably. If the file that we needed to read was really long then we might have to wait a few seconds before the database query could begin.

This process is almost exactly like the way that you would use `addEventListener` in front-end JavaScript to wait for a user action such as a mouse-click or keyboard press. The main difference is that the events are going to be things such as network requests and database queries. This functionality is facilitated through the use of **callbacks**.

Let’s look at a quick real-world example:

```javascript
http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  res.end('Hello World!');
}).listen(8080);
```

## Resources

- [Article](https://medium.freecodecamp.org/what-exactly-is-node-js-ae36e97449f5) 
- [Official Node.js Website](https://nodejs.dev/en/learn/introduction-to-nodejs/)
- [Event loop](https://www.youtube.com/watch?v=8aGhZQkoFbQ)