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

# Application architectures