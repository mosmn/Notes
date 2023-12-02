# Table of Contents

- [Programming](#programming-notes)
    - [Git](#git)
    - [HTML](#html)
    - [CSS](#css)
    - [JavaScript](#javascript)
        - [React JS](#react-js)
        - [Node JS](#node-js)
    - [C++](#c)
    - [Java](#java)
    - [Python](#python)

- [Database](#database)
    - [SQL](#sql)
    - [MongoDB](#mongodb)

- [Cloud](#cloud)
    - [AWS](#aws)

- [Theoretical](#theoretical)
    - [Operating Systems Concepts](#operating-systems-concepts)
    - [Software Engineering Principles](#software-engineering-principles)
    - [Data Communication and Networking](#data-communication-and-networking)
    - [Database Fundamentals](#database-fundamentals)
    - [Parallel computing](#parallel-computing)
    - [Human Computer Interaction](#human-computer-interaction)
    - [Artificial Intelligence](#artificial-intelligence)

- [Sources](#sources)

# Programming Notes
### Git

- [Commands](sections/git/gitcommand.md)
- [Clone a repository](sections/git/gitclone.md)
- [Branch](sections/git/branch.md)
- [Merge conflicts](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/about-merge-conflicts)
- [Deploying a subfolder](sections/git/subfolder.md)
- [Change history](sections/git/changehistory.md)
- [Open source contributions](sections/git/contributions.md)
- [Think like a git](https://think-like-a-git.net/)
- [Deploy React app into Github Pages](https://medium.com/@isharamalaviarachchi/how-to-deploy-your-react-app-into-github-pages-b2c96292b18e)

### HTML

- [Linking a file](sections/html/linking.md)
- [Forms](https://developer.mozilla.org/en-US/docs/Learn/Forms)
- Accessibility
    - [Introduction](sections/html/accessibility/intro.md)
    - [The Web Content Accessibility Guidelines (WCAG)](sections/html/accessibility/wcag.md)
    - [Semantic HTML](sections/html/accessibility/semantic.md)
    - [Accessible Colors](sections/css/accessible-colors.md)
    - [Keyboard Navigation](sections/css/keyboard-navigation.md)
    - [Meaningful Text](sections/css/meaningful-text.md)
    - [WAI-ARIA](sections/css/wai-aria.md)
    - [Accessibility Auditing](sections/css/accessibility-auditing.md)

### CSS

- [Flexbox](sections/css/flexbox.md)
- [Grid](sections/css/grid.md)
- [Positioning](sections/css/positioning.md)
- [Pseudo-classes](sections/css/pseudo-classes.md)
- [Pseudo-elements](sections/css/pseudo-elements.md)
- [Selectors](sections/css/selectors.md)
- Animations
    - [Transforms](sections/css/transforms.md)
    - [Transitions](sections/css/transitions.md)
    - [Keyframes](sections/css/keyframes.md)
- Responsive Design
    - [Introduction](sections/css/responsive-design.md)
    - [Natural Responsiveness](sections/css/natural-responsiveness.md)
    - [Responsive Images](sections/css/responsive-images.md)
    - [Media Queries](sections/css/media-queries.md)


### JavaScript

- Basics
    - [Refresher on the fundamentals](https://learnxinyminutes.com/docs/javascript/)
    - [Array Methods](https://javascript.info/array-methods)

- Linting
    - [Eslint Setup](sections/javascript/eslint.md)
    - [Prettier Setup](sections/javascript/prettier.md)

- Organizing JavaScript Code
    - [Objects And Object Constructors](sections/javascript/object-dp.md)
    - [Factory Functions And The Module Pattern](sections/javascript/factory.md)
    - [Classes](sections/javascript/classes.md)
    - [ES6 Modules](sections/javascript/es6-modules.md)
    - [OOP Principles](sections/javascript/OOP-Principles.md)

- JavaScript in the Real World
    - [Dynamic User Interface Interactions](sections/javascript/dynamic-ui.md)
    - [Form Validation](sections/javascript/form-validation.md)

- Asynchronous JavaScript and APIs
    - [JSON](sections/javascript/json.md)
    - [Asynchronous Code](sections/javascript/async.md)
    - [Working With APIs](sections/javascript/api.md)
    - [Async and Await](sections/javascript/async-await.md)

- Testing JavaScript
    - [Testing Basics](sections/javascript/testing-basics.md)
    - [Isolation](sections/javascript/isolation.md)

- Data Structures & Algorithms
    - [Intro](sections/javascript/intro.md)
    - [Recursive Methods](sections/javascript/recursive-methods.md)
    - [Time Complexity](sections/javascript/time-complexity.md)
    - [Space Complexity](sections/javascript/space-complexity.md)
    - Common Data Structures and Algorithms
        - [Linked Lists](sections/javascript/linked-lists.md)
        - [Stacks & Queues](sections/javascript/stacks-queues.md)
        - [Binary Search Trees](sections/javascript/binary-search-trees.md)


#### React JS
- [Setting Up A React Environment](sections/javascript/react/setup.md)
- [Introduction](sections/javascript/react/intro.md)
- [JSX](sections/javascript/react/jsx.md)
- [Rendering Techniques](sections/javascript/react/rendering.md)
- [Keys](sections/javascript/react/keys.md)
- [State and Props](sections/javascript/react/state-props.md)
- [Handling Input](sections/javascript/react/handling-input.md)
- [Lifecycle Methods](sections/javascript/react/lifecycle.md)
- [Hooks](sections/javascript/react/hooks.md)
- [How To Deal With Side Effects](sections/javascript/react/side-effects.md)
- [Typechecking With PropTypes](sections/javascript/react/prop-types.md)
- [Router](sections/javascript/react/router.md)
- [Fetching Data](sections/javascript/react/fetching-data.md)
- [Context API](sections/javascript/react/context-api.md)
- [Testing 1](sections/javascript/react/testing-1.md)
- [Testing 2](sections/javascript/react/testing-2.md)
- [Server Components](https://github.com/reactjs/rfcs/blob/main/text/0188-server-components.md)
- [Patterns and architecture](https://www.patterns.dev/)

#### Node JS
- Intro
    - [Backend?](sections/javascript/node/backend.md)
    - [What is NodeJS?](sections/javascript/node/what-is-nodejs.md)
    - [Server-side](https://developer.mozilla.org/en-US/docs/Learn/Server-side/First_steps/Introduction)
    - [Client-Server model. what happens when a server receives a request?](https://developer.mozilla.org/en-US/docs/Learn/Server-side/First_steps/Client-Server_overview)
    - [Basic modules and functions](sections/javascript/node/basic-modules.md)
    - [Debugging](sections/javascript/node/debugging.md)
- Express & Mongoose
    - [Introduction to Express](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Express_Nodejs/Introduction#rendering_data_views)
    - [Setting up a Node development environment](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Express_Nodejs/development_environment#using_npm)
    - [Express 101](sections/javascript/node/express-101.md)
    - [Using Middleware](https://expressjs.com/en/guide/using-middleware.html)
    - [Express 102: CRUD and MVC](sections/javascript/node/express-102.md)
    - [Mongoose primer](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Express_Nodejs/mongoose#mongoose_primer)
    - [Deploying](sections/javascript/node/deploying.md)
    - [Express 103: Routes and Controllers](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Express_Nodejs/routes)
    - [Express 104: View Templates](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Express_Nodejs/Displaying_data)
    - [Express 105: Forms and Deployment](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Express_Nodejs/forms)
- Authentication
    - [PassportJS](sections/javascript/node/passportjs.md)

### C++

- [Basics](sections/cpp/basics.md)
- [Advanced Functions](sections/cpp/functions.md)
- [Multidimensional Arrays](sections/cpp/multiarray.md)
- [Pointers](sections/cpp/pointers.md)
- [Structures](sections/cpp/struc.md)
- [Objects and Classes](sections/cpp/objects-classes.md)
- [Inheritance](sections/cpp/inheritance.md)
- [File stream input and output](sections/cpp/file-stream.md)
- [GUI](sections/cpp/gui.md)
- [Standard Template Library](sections/cpp/stl.md)
- Data Structures & Algorithms
    - [Abstract Data Type and STL](sections/cpp/dsa/adt.md)
    - [Complexity Analysis​](sections/cpp/dsa/complexity-analysis.md)
    - [Linked List](sections/cpp/dsa/linked-list.md)
    - [Stack](sections/cpp/dsa/stacks.md)
    - [Queue](sections/cpp/dsa/queue.md)
    - [Tree](sections/cpp/dsa/tree.md)
    - [Graph](sections/cpp/dsa/graph.md)
    - [Sorting](sections/cpp/dsa/sorting.md)
    - [Searching](sections/cpp/dsa/searching.md)


### Java

- [Introduction to OOP](sections/java/intro.md)
- [Basics](sections/java/basics.md)
- [Numerical Data](sections/java/numerical-data.md)
- [Defining Your Own Classes](sections/java/defining-classes.md)
- [Selection and Repetition](sections/java/selection-repetition.md)
- [Method Overloading and More on Classes](sections/java/method-overloading.md)
- [Exception Handling and Assertions](sections/java/exception-handling.md)
- [Programmer-Defined Exception Classes and Assertions](sections/java/programmer-defined-exceptions.md)
- [Characters and Strings](sections/java/characters-strings.md)
- [Arrays](sections/java/arrays.md)
- [Inheritance and Polymorphism](sections/java/inheritance-polymorphism.md)
- [File Input Output](sections/java/file-io.md)
- [OOP in Real World Applications](sections/java/oop-real-world.md)

### Python

- [Basics](sections/python/basics.md)

[Back to Table of Contents](#table-of-contents) ⬆

# Database

- [SQL vs NoSQL](https://circleci.com/blog/sql-vs-nosql-databases/)

### SQL

- [Retrieving Data Using SQL the SQL SELECT statement](sections/db/sql/select.md)
- [Restricting and Sorting Data](sections/db/sql/sorting.md)
- [Single-Row Functions](sections/db/sql/singlerf.md)
- [Group Functions](sections/db/sql/group-functions.md)
- [Displaying Data from Multiple Tables Using Joins](sections/db/sql/joins.md)
- [Using Subqueries to Solve Queries](sections/db/sql/subqueries.md)
- [Manipulating Data](sections/db/sql/manipulating.md)
- [DDL statements](sections/db/sql/ddl.md)

### MongoDB

- [Introduction](sections/db/mongodb/intro.md)
- [MongoDB and the Document Model](sections/db/mongodb/document-model.md)
- [Connecting to a MongoDB Database](sections/db/mongodb/connecting.md)
- [CRUD Operations: Insert and Find Documents](sections/db/mongodb/inser-find.md)
- [CRUD Operations: Replace and Delete Documents](sections/db/mongodb/replace-delete.md)
- [CRUD Operations: Modifying Query Results](sections/db/mongodb/modifying-query.md)
- [CRUD Operations in Node.js](sections/db/mongodb/crud-nodejs.md)
- [Aggregation](sections/db/mongodb/aggregation.md)
- [Aggregation in Node.js](sections/db/mongodb/aggregation-nodejs.md)
- [Indexes](sections/db/mongodb/indexes.md)
- [Atlas Search](sections/db/mongodb/atlas-search.md)
- [Data Modeling](sections/db/mongodb/data-modeling.md)
- [Transactions](sections/db/mongodb/transactions.md)

[Back to Table of Contents](#table-of-contents) ⬆

# Cloud

### AWS

- [Certification](sections/cloud/cert.md)

[Back to Table of Contents](#table-of-contents) ⬆

# Theoretical

### Operating Systems Concepts

- [Overview](sections/theo/os/overview.md)
- [Process Description and Control](sections/theo/os/processdc.md)
- [Concurrency - Mutual Exclusion](sections/theo/os/mutex.md)
- [Concurrency-Deadlock and Starvation](sections/theo/os/deadlock.md)
- [Uniprocessor Scheduling](sections/theo/os/scheduling.md)
- [Memory Management](sections/theo/os/memory.md)
- [Virtual Memory](sections/theo/os/virtual-memory.md)
- [I/O Management & Disk Scheduling](sections/theo/os/io.md)
- [File Management](sections/theo/os/file.md)

### Software Engineering Principles

- [Introduction](sections/theo/sep/intro.md)
- [Software Processes](sections/theo/sep/process.md)
- [Agile Software Development](sections/theo/sep/agile.md)
- [Requirements engineering](sections/theo/sep/re.md)
- [System modelling](sections/theo/sep/system-modeling.md)
- [Architectural design](sections/theo/sep/architectural-design.md)
- [Design and implementation](sections/theo/sep/design-implementation.md)
- [Software testing](sections/theo/sep/testing.md)

### Data Communication and Networking

- Modules 1 - 3: Basic Network Connectivity and Communications
    - [Module 1: Networking Today](sections/theo/networking/module1.md)
    - [Module 2: Basic Switch and End Device Configuration](sections/theo/networking/module2.md)
    - [Module 3: Protocols and Models](sections/theo/networking/module3.md)
- Modules 4 - 7: Ethernet Concepts
    - [Module 4: Physical Layer](sections/theo/networking/module4.md)
    - [Module 5: Number Systems](sections/theo/networking/module5.md)
    - [Module 6: Data Link Layer](sections/theo/networking/module6.md)
    - [Module 7: Ethernet Switching](sections/theo/networking/module7.md)
- Modules 8 - 10: Communicating Between Networks
    - [Module 8: Network Layer](sections/theo/networking/module8.md)
    - [Module 9: Address Resolution](sections/theo/networking/module9.md)
    - [Module 10: Basic Router Configuration](sections/theo/networking/module10.md)
- Modules 11 - 13: IP Addressing
    - [Module 11: IPv4 Addressing](sections/theo/networking/module11.md)
    - [Module 12: IPv6 Addressing](sections/theo/networking/module12.md)
    - [Module 13: ICMP](sections/theo/networking/module13.md)
- Modules 14 - 15: Network Application Communications
    - [Module 14: Transport Layer](sections/theo/networking/module14.md)
    - [Module 15: Application Layer](sections/theo/networking/module15.md)
- Modules 16 - 17: Building and Securing a Small Network
    - [Module 16: Building a Small Network](sections/theo/networking/module16.md)
    - [Module 17: Securing a Small Network](sections/theo/networking/module17.md)
    
### Database Fundamentals

- [Introduction](sections/theo/dbf/introduction.md)
- [Environment](sections/theo/dbf/environoment.md)
- [SQL](sections/theo/dbf/sql.md)
- [Relational model concept](sections/theo/dbf/relational-model-concept.md)
- [Data modeling](sections/theo/dbf/data-modeling.md)
- [Database design](sections/theo/dbf/database-design.md)
- [Normalization](sections/theo/dbf/normalization.md)

### Parallel computing

- [Introduction](sections/theo/pc/intro.md)
- [Parallel Computing Architecture](sections/theo/pc/parallel-computing-architecture.md)
- [Principles of Parallel Algorithm Design](sections/theo/pc/principles-of-parallel-algorithm-design.md)
- [Pthreads](sections/theo/pc/pthreads.md)
- [OpenMP](sections/theo/pc/openmp.md)
- [MPI](sections/theo/pc/mpi.md)
- [CUDA](sections/theo/pc/cuda.md)

### Human Computer Interaction

- [Introduction](sections/theo/hci/intro.md)
- [Interrelationships](sections/theo/hci/interrelationships.md)
- [Interaction Design Basics](sections/theo/hci/interaction-design-basics.md)
- [Cognitive Models](sections/theo/hci/cognitive-models.md)
- [HCI in the Software Process](sections/theo/hci/hci-in-the-software-process.md)
- [Design Rules](sections/theo/hci/design-rules.md)
- [Evaluation Techniques](sections/theo/hci/evaluation-techniques.md)
- [Universal Design (UD) ](sections/theo/hci/universal-design.md)
- [User Support](sections/theo/hci/user-support.md)
- [Emerging Technologies in HCI](sections/theo/hci/emerging-technologies.md)

### Artificial Intelligence

- [Introduction](sections/theo/ai/intro.md)
- [Logic](sections/theo/ai/logic.md)
- [Propositional & Predicate Logic](sections/theo/ai/propositional-predicate-logic.md)
- [Automated Reasoning and Theorem Proving](sections/theo/ai/automated-reasoning-and-theorem-proving.md)
- [State Space Search](sections/theo/ai/state-space-search.md)
- [Knowledge Representation Schemes](sections/theo/ai/knowledge-representation-schemes.md)
- [Expert Systems](sections/theo/ai/expert-systems.md)
- [Uncertainty Handling: Fuzzy Logic](sections/theo/ai/uncertainty-handling-fuzzy-logic.md)

[Back to Table of Contents](#table-of-contents) ⬆

# Sources

- [CCNA](https://www.netacad.com/courses/networking/ccna-v7-introduction-networks)
- [The Odin Project](https://www.theodinproject.com/)
- [MDN](https://developer.mozilla.org/en-US/)
- Books
    - [Database Systems: Design, Implementation, and Management](https://www.amazon.com/Database-Systems-Design-Implementation-Management/dp/1337627903)
    - [Operating System Concepts](https://www.amazon.com/Operating-System-Concepts-Abraham-Silberschatz/dp/1118063333)
    - [Software Engineering: A Practitioner's Approach](https://www.amazon.com/Software-Engineering-Practitioners-Roger-Pressman/dp/0078022126)
    - [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
    - [C++ Data Structures and Algorithm Design Principles](https://www.amazon.com/Data-Structures-Algorithm-Design-Principles/dp/1683920848)
    - [Cracking the Coding Interview](https://www.amazon.com/Cracking-Coding-Interview-Programming-Questions/dp/0984782850)

