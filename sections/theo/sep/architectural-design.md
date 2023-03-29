Software architecture falls under Design & Implementation

4 Designs are produced during the design phase of the software development life cycle. They are:
1. program design
2. data design
3. interface design
4. architectural design

# Architectural design decisions

the influence factors to decide which design to choose when implementing a system.

how a software system should be organized and designed the overall structure of that system.

the critical link between design and requirements engineering, as it identifies the main structural components in a system and the relationships between them.

The output : an architectural model that describes how the system is organized as a set of communicating components.

### Example architecture of a packing robot control system

![a](/imgs/swa1.png)
the coneyor is like a walikg escorator, its used to move the boxes from one place to another in a manufacturing plant or something similar.

## Level of architectural abstraction

1. Architectural in the small
- the architecture of individual programs.(like in programing, when you create a function inside the main program these functions are refered to as individual programs)
- each individual program have their own architectue
- the way that an individual program is decomposed into components.
2. Architectural in the large
- the architecture of complex enterprise systems that include other systems, programs, and program components.
- May involve distribution of components internally or externally of the system
- the architecture of the entire system including the individual programs that make up the system.

## Advantages of software architecture

1. Stakeholder communication - Architecture may be used as a focus of discussion by system stakeholders.
2. System analysis - Means that analysis of whether the system can meet its non-functional requirements is possible.(we do not show functional requirements in the architecture only non-functional requirements, because the functional requirements are shown in the use case diagram)
3. Large-scale reuse - The architecture may be reusable across a range of systems. Product-line architectures may be developed.

## Use of architectural models

As a way of facilitating discussion about the system design by using high-level architectural view
- used to communicate with system stakeholders and project planning
- easy for stakeholders to relate and understand an abstract view of the system
- able to discuss the system as a whole without being confused by detail.

As a way of documenting an architecture that has been designed
- to produce a complete system model that shows the different components in a system, their interfaces and their connections.

## Architectural design decisions

a creative process so the process differs depending on the type of system being developed.

However, a number of common decisions span all design processes, and these decisions affect the non-functional characteristics of the system.

![a](/imgs/swa2.png)

## Architecture and system characteristics

What is the relationship between architecture and (non functional)system characteristics? before you decide on the architecture to be used, you must look at these characteristics first:
- Preformance 
    - Localise critical operations and minimise communications.(for a critical function you must enable the function to be conducted on the client side instead of the server side)
    - Use Performance large rather than fine-grain components.(fine-grain means small components)
    - reduces the number of component communications, as most of the interactions between related system features take place within a component.(in other words, in programming, you are trying to minimize the number of parameters that you pass to a function, because the more parameters you pass to a function, the more slower your system will be)
- Security 
    - Use a layered architecture with critical assets in the inner layers.
    - The most critical assets protected in the innermost layers and a high level of security validation applied to these layers.
- Safety 
    - Localise safety-critical features in a small number of sub- Safety systems.
    - This reduces the costs and problems of safety validation and may make it possible to provide related protection systems that can safely shut down the system in the event of failure.
- Availability 
    - Include redundant components and mechanisms for fault tolerance components so that it is possible to replace and update components without stopping the system.(lets say you want to update your software on a particulat function, only that function should be unavalible at that moment, the rest of the system should be running)
- Maintainability 
    - Use fine-grain, replaceable components. Maintainability

# Architectural views

Two issues:
- What views or perspectives are useful when designing and documenting a system’s architecture?
- What notations should be used for describing architectural models?

Each architectural model only shows one view or perspective of the system.

1. Logical view - the key abstractions in the system as objects or object classes.
2. Process view - how, at runtime, the system is composed of interacting processes.
3. Development view - how the software is decomposed for development.
4. Physical view - shows the system hardware and how software components are distributed across the processors in the system.

this model is called __The 4+1 view model of software architecture__ because the views can be linked through the common use case or senarios, meaning how we view the system is different depending on the senarios. e.g lets say for Brighten we have the view for adminstrator, student, lecturer, etc. so , each has a different architecture.

# Architectural patterns

Representing, sharing and reusing knowledge

Stylized description of good design practice, which has been tried and tested in different environments.

Include information about when they are and when the are not useful.

May be represented using tabular and graphical descriptions.

## The Model-View-Controller (MVC) pattern

earliest pattern proposed for software architecture.

Simple example:
Every car consist of three main parts.
- View= User interface : ( Gear lever, panels, steering wheel, brake, etc.) 
- Controller= Mechanism ( Engine) 
- Model=Storage ( Petrol or Diseal tank)

### Tabular view

Name | MVC (Model-View-Controller)
---|---
Description | Separates presentation and interaction from the system data. The system is structured into three logical components that interact with each other. The Model component manages the system data and associated operations on that data. The View component defines and manages how the data is presented to the user. The Controller component manages user interaction (e.g., key presses, mouse clicks, etc.) and passes these interactions to the View and the Model. See Figure 6.3.
Example | Figure 6.4 shows the architecture of a web-based application system organized using the MVC pattern.
When used | Used when there are multiple ways to view and interact with data. Also used when the future requirements for interaction and presentation of data are unknown.
Advantages | Allows the data to change independently of its representation and vice versa. Supports presentation of the same data in different ways with changes made in one representation shown in all of them.
Disadvantages | Can involve additional code and code complexity when the data model and interactions are simple.

### Conceptual View

![a](/imgs/swa3.png)

### Run-time View

![a](/imgs/swa4.png)
so basically:
- the Controller is the Code(back-end)
- the View is the User Interface(front-end)
- the Model is the Database
and every system MUST have all three of them.

## Layered architecture pattern

Used to model the interfacing of subsystems.

Organises the system into a set of layers (or abstract machines) each of which provide a set of services.

Supports the incremental development of sub-systems in different layers. When a layer interface changes, only the adjacent layer is affected.

### Tabular view

Name | Layered architecture
---|---
Description | Organizes the system into layers with related functionality associated with each layer. A layer provides services to the layer above it so the lowest-level layers represent core services that are likely to be used throughout the system. See slides 21
Example | A layered model of a system for sharing copyright documents held in different libraries, as shown in slides 23
When used | when building new facilities on top of existing systems. when the development is spread across several teams with each team responsibilityfor a layer of functionality. when there is a requirement for multi-level security.
Advantages | Allows replacement of entire layers so long as the interface is maintained. Redundant facilities (e.g., authentication) can be provided in each layer to increase the dependability of the system.
Disadvantages | In practice, providing a clean separation between layers is often difficult and a high-level layer may have to interact directly with lower-level layers rather than through the layer immediately below it. Performance can be a problem because of multiple levels of interpretation of a service request as it is processed at each layer.

### A generic layered architecture 

![a](/imgs/swa6.png)

- Ever layer can only communicate with the layer above and below it. it cannot jump/skip a layer.

The architecture of the iLearn system:

![a](/imgs/swa5.png)

## The Repository pattern


Sub-systems must exchange data.

Two ways:
- Shared data is held in a central database or repository and may be accessed by all sub-systems;
- Each sub-system maintains its own database and passes data explicitly to other sub-systems.

When large amounts of data are to be shared, the repository model of sharing is most commonly used a this is an efficient data sharing mechanism.

### Tabular view

Name | Repository
---|---
Description | All data in a system is managed in a central repository that is accessible to all system components. Components do not interact directly, only through the repository.
Example | Slide 27 is an example of an IDE where the components use a repository of system design information. Each software tool generates information which is then available for use by other tools.
When used | You should use this pattern when you have a system in which large volumes of information are generated that has to be stored for a long time. You may also use it in data-driven systems where the inclusion of data in the repository triggers an action or tool.
Advantages | Components can be independent—they do not need to know of the existence of other components. Changes made by one component can be propagated to all components. All data can be managed consistently (e.g., backups done at the same time) as it is all in one place.
Disadvantages | The repository is a single point of failure so problems in the repository affect the whole system. May be inefficiencies in organizing all communication through the repository. Distributing the repository across several computers may be difficult.

### A repository architecture for an IDE

![a](/imgs/swa7.png)

## The Client-server pattern

Distributed system model which shows how data and processing is distributed across a range of components.
- can be implemented on a single computer.

Set of stand-alone servers which provide specific services such as printing, data management, etc.

Set of clients which call on these services.

Network which allows clients to access servers.

### Tabular view

Name | Client-server
---|---
Description | In a client–server architecture, the functionality of the system is organized into services, with each service delivered from a separate server. Clients are users of these services and access servers to make use of them.
Example | Slide 30 is an example of a film and video/DVD library organized as a client–server system.
When used | Used when data in a shared database has to be accessed from a range of locations. Because servers can be replicated, may also be used when the load on a system is variable.
Advantages | The principal advantage of this model is that servers can be distributed across a network. General functionality (e.g., a printing service) can be available to all clients and does not need to be implemented by all services.
Disadvantages | Each service is a single point of failure so susceptible to denial of service attacks or server failure. Performance may be unpredictable because it depends on the network as well as the system. May be management problemsif servers are owned by different organizations.

### A client-server architecture for a film library

![a](/imgs/swa8.png)

## The pipe and filter pattern

Functional transformations process their inputs to produce outputs.

May be referred to as a pipe and filter model Variants of this approach are very common. When transformations are sequential, this is a batch sequential model which is extensively used in data processing systems.

Not really suitable for interactive systems.

### Tabular view

Name | Pipe and filter
---|---
Description | The processing of the data in a system is organized so that each processing component (filter) is discrete and carries out one type of data transformation. The data flows (as in a pipe) from one component to another for processing.
Example | Slide 33 is an example of a pipe and filter system used for processing invoices.
When used | Commonly used in data processing applications (both batch- and transaction-based) where inputs are processed in separate stages to generate related outputs.
Advantages | Easy to understand and supports transformation reuse. Workflow style matches the structure of many business processes. Evolution by adding transformations is straightforward. Can be implemented as either a sequential or concurrent system.
Disadvantages | The format for data transfer has tso be agreed upon between communicating transformations. Each transformation must parse its input and unparse its output to the agreed form. This increases system overhead and may mean that it is impossible to reuse functional transformations that use incompatible data structures.

### An example of the pipe and filter architecture used in a payments system

![a](/imgs/swa9.png)

# Application architectures