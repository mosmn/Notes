# Introduction 

System modeling:
- is the process of developing abstract models of a system
- with each model presenting a different view or perspective of that system. 
- System modeling now usually means representing a system using some kind of graphical notation based on diagram types in the Unified Modeling Language (UML).
- helps the analyst to understand the functionality of the system
- used to communicate with customers.

Models are used :
- during the requirements engineering process to help derive the detailed requirements for a system
- during the design process to describe the system to engineers implementing the system
- after implementation to document the system’s structure and operation.

You may develop models of both the existing system and the system to be developed:
- existing system
    - clarify what the existing system does
    - used as a basis for discussing its strengths and weaknesses.
- new system
    - explain the proposed requirements to other system stakeholders.
    - Engineers use to discuss design proposals and to document the system for implementation.

A model is an abstraction of the system being studied rather than an alternative representation of that system, a system model is not a complete representation of system. for example:
- if i create a slides presentation of a book, the slides are not the book, they are a model of the book they are an abstraction of the book.
- if i translate that book into another language, that will be complete representation of the book becasue it will contain all the information in the book.

You may develop different models to represent the system from different perspectives. For example:
1. An external perspective, where you model the context or environment of the system.
2. An interaction perspective, where you model the interactions between a system and its environment, or between the components of a system.
3. A structural perspective, where you model the organization of a system or the structure of the data processed by the system.
4. A behavioral perspective, where you model the dynamic behavior of the system and how it responds to events.

There are three ways in which graphical models are commonly used:
1. As a way to stimulate and focus discussion about an existing or proposed system.
2. As a way of documenting an existing system. 
3. As a detailed system description that can be used to generate a system implementation.

UML diagram types:
1. Activity diagrams, which show the activities involved in a process or in data processing.
2. Use case diagrams, which show the interactions between a system and its environment.
3. Sequence diagrams, which show interactions between actors and the system and between system components.
4. Class diagrams, which show the object classes in the system and the associations between these classes.
5. State diagrams, which show how the system reacts to internal and external events.

# Context models 

used to illustrate the operational context of a system 

At an early stage in the specification of a system, you should decide on the system boundaries

System boundaries:
- what is and is not part of the system being developed.
- what functionality should be included in the system 
- what processing and operations should be carried out in the system’s operational environment.

Social and organisational concerns may affect the decision on where to position system boundaries.

Example : The context of the Mentcare system

![mc](/imgs/cms.png)

What is being shown here? 
- The Mentcare System is consisting of other systems (systems of system)

What is not shown here? 
- the types of relationships between the systems in the environment 
- the details of system that is being specified

Architectural models show the system and its relationship with sother systems.

The lack of context model:
- Only show the other systems in the environment
- Do not how the system being developed is used in that environment.
- UML activity diagrams may be used to define business process models

# Interaction models

# Structural models 

# Behavioral models