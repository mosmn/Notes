* **REST:** Representational State Transfer, an architectural style for APIs promoting statelessness, cacheability, and layered systems.
* **RESTful API Design:**
    * Use resource-based URIs with HTTP verbs (GET, POST, PUT, DELETE) for CRUD operations.
    * Example:
        * GET /posts - Get all posts
        * GET /posts/:id - Get a specific post
        * POST /posts - Create a new post
        * PUT /posts/:id - Update a post
        * DELETE /posts/:id - Delete a post
* **HTTP Methods/Verbs:** Define actions on resources (GET, POST, PUT, DELETE).
* **Same Origin Policy (SOP):** Security measure restricting requests to the same origin (IP/URL).
* **CORS (Cross-Origin Resource Sharing):** Enables requests from different origins.
    * Use CORS middleware in Express.
    * Configure CORS for specific origins.
    * Understand CORS headers.

**Additional Notes:**

* Consider using nouns instead of verbs in endpoint paths for better clarity.
* REST is a complex topic, but these notes provide a basic understanding for beginners.

**Further Resources:**

* REST API Design Best Practices: [https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/](https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/)
* [This robinwieruch tutorial](https://www.robinwieruch.de/node-express-server-rest-api/) on setting up a REST API in Express.
* Express CORS Middleware: [https://expressjs.com/en/resources/middleware/cors.html](https://expressjs.com/en/resources/middleware/cors.html)
* Simple REST Example: [https://simple.wikipedia.org/wiki/Representational_state_transfer](https://simple.wikipedia.org/wiki/Representational_state_transfer)