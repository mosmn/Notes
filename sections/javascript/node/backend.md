# What is the Backend?

The backend is all that goes on “behind the scenes” on web servers to make the user experience possible. You can run pretty much any language you want to on your server since it doesn’t rely on your user’s browser understanding what’s going on, As long as it can take in an HTTP request and spit out some HTML, you can probably put it on a server somehow. All the browser cares about is whether you’ve sent it properly formatted HTML, CSS and JavaScript files (and other assets like images).

## Overview of what happens when a client requests and server responds

### Frontend vs Backend

The front-end is the code that is executed on the client side. This code (typically HTML, CSS, and JavaScript) runs in the user’s browser and creates the user interface.

The back-end is the code that runs on the server, that receives requests from the clients, and contains the logic to send the appropriate data back to the client. The back-end also includes the database, which will persistently store all of the data for the application.

### What are the Clients?

Clients are entities that send requests to the back-end. While web browsers are common clients that request HTML and JavaScript code to display websites, clients can take various forms. They might be mobile applications, other server-side applications, or even web-enabled smart appliances.

The back-end encompasses all the technology required to process incoming requests and generate responses for clients. It typically consists of three main components:

1. **The Server:** This is the computer that receives requests.
2. **The App:** It's the application running on the server that listens for requests, retrieves data from databases, and sends responses.
3. **The Database:** Databases are used to organize and persist data.

### What is a Server?

A server is merely a computer that listens for incoming requests. While there are specialized server machines, any network-connected computer can serve as a server. During development, you often use your own computer as a server.

### What are the Core Functions of the App?

The server runs an app that contains logic for responding to requests based on HTTP verbs and URIs. The combination of an HTTP verb and a URI is called a route, and the process of matching requests to routes is called routing. Some handler functions within routes are middleware, code executed between receiving a request and sending a response. Middleware can modify the request, query databases, or process incoming data. It usually passes control to the next middleware function, not sending the response. Eventually, a middleware function ends the request-response cycle by sending an HTTP response to the client.

### What Kinds of Responses Can a Server Send?

A server can send various types of data in responses. For example, it can serve HTML files, send data as JSON, or respond with an HTTP status code. Common status codes like "404 - Not Found" indicate what happened when the server processed the request.

### What is a Web API?

A Web API is a collection of well-defined communication methods between software components. Specifically, a Web API is created by the back-end, defining endpoints and the resources they expose. It's defined by the types of requests it handles through routes and the types of responses clients can expect after hitting those routes. A single Web API can serve multiple front-ends, allowing different HTML pages or mobile apps to view its data.

### Example of the steps involved when a client makes a request to a server:

1. Alice shops on SuperCoolShop.com and clicks on a smartphone cover, triggering a GET request to http://www.SuperCoolShop.com/products/66432. GET indicates a data request, and the URI specifies the product's information.

2. Alice's request travels across the internet to one of SuperCoolShop's servers.

3. The server, listening for requests, receives Alice's request.

4. Event listeners matching the request (HTTP verb: GET, URI: /products/66432) are triggered. This server-side code, called middleware, processes the request.

5. The server processes the request by querying a database for information about the smartphone cover.

6. The database query is executed, and the data is sent back to the server.

7. With data from the database, the server constructs and sends its response back to the client. The response body contains information about the product, while the header indicates HTTP status code 200 for a successful request.

8. The response travels back to Alice's computer.

9. Alice's browser receives the response and uses it to create and display the product details.