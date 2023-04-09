Design and implementation:
- The stage in the software engineering process at which an executable software system is developed.
- Software design and implementation activities are invariably inter-leaved.
    - Software design is a creative activity in which you identify software components and their relationships, based on a customer’s requirements.
    - Implementation is the process of realizing the design as a program.



# Object oriented design using the UML

An object-oriented design process
- Developing a number of different system models
- For small systems, require a lot of effort and may not be cost-effective
- For large systems, it is an important communication mechanism

Object:
- A real-world element in an object–oriented environment that may have a physical or a conceptual existence.
- An object may have
    - a physical existence, like a customer, a car, etc.
    - an intangible conceptual existence, like a project, a process, etc.

Object Oriented Design:
- object-oriented system : interacting objects that maintain their own local state and provide operations on that state
    - state is private and cannot be accessed directly from outside the object.
- Object-oriented design processes : designing object classes and the relationships between these classes.
    - classes define the objects in the system and their interactions.

Process stages:
1. Define - define the context and modes of use of the system
2. Design - design the system architecture
3. Identify - identify the principal system objects
4. Develop - develop design models
5. Specify - specify object behavior

## 1. System context and interactions

Understanding the relationships between the software that is being designed and its external environment

essential for deciding how to provide the required system functionality and how to structure the system to communicate with its environment. 

The system context establish the boundaries of the system on deciding what features are implemented in the system being designed and what features are in other associated systems.

Includes:
- system context model
- use case model
- use case description

## 2. Architectural design

Identify the major components that make up the system  and their interactions
- actor
- interface
    can be through:
    - pages
    - devices
- process
- database

organize the components using an architectural pattern  such as a layered or client-server model.

Weather station example:
- its a client-server architecture
    - because every subsystem is communicating with each other through the communication link.

Includes:
- architectural model
## 3. Object class identification

The difficult part of object-oriented design.

No 'magic formula' for object identification.

It relies on the skill, experience and domain knowledge of system designers.

Object identification is an iterative process. Might have to do it several times to get the right one.

Approaches to object identification:
- Use a grammatical approach based on a natural language description of the system.
- Based on the identification on tangible things in the application domain.
- Use a behavioural approach and identify objects based on what participates in what behaviour.
- Use a scenario-based analysis. The objects, attributes and methods in each scenario are identified

## 4. Design models

Design models show the objects and object classes and relationships between these entities.

There are two kinds of design model:
- Structural models describe the static structure of the system in terms of object classes and relationships.
- Dynamic models describe the dynamic interactions between objects.

Three common UML Models:
1. Subsystem models(structural model, because it shows the object calsses and the interactions between them)
    - show logical groupings of objects into coherent subsystems.
2. Sequence models(dynamic model)
    - show the sequence of object interactions.
3. State machine models(dynamic model)
    - show how individual objects change their state in response to events.

### Subsystem models

- Shows how the design is organised into logically related groups of objects.
- Structural models
- In the UML, these are shown using packages - an encapsulation construct. This is a logical model. The actual organisation of objects in the system may be different.
- e.g. class diagram

### Sequence models

- Show the sequence of object interactions that take place
- Dynamic model
- Combined behavior of a group of objects

### State machine models

- Used to show how objects respond to different service requests and the state transitions triggered by these requests.
- Useful for high-level models of a system or an object’s run-time behavior.
- It is an optional, not all systems need it
- only applicable on certain systems. e.g. Iot systems, embedded systems, real-time systems, etc.

## 5. Interface specification

Object interfaces have to be specified so that the objects and other components can be designed in parallel.

Designers should avoid designing the interface representation but should hide this in the object itself.

Objects may have several interfaces which are viewpoints on the methods provided.

The UML uses class diagrams for interface specification but Java may also be used.

# Implementation issues

The main focus is not on programming, but on implementation issues
- Reuse 
    - Most modern software is constructed by reusing existing components or systems
    - Should use as much as possible of existing code.
- Configuration management
    - During the development process, keep track of different versions of each software component in a configuration management system.
- Host-target development
    - develop it on one computer (the host system) and execute it on a separate computer (the target system).

### Levels of Software Reuse

1. The abstraction level
    - don’t reuse software directly but rather use knowledge of successful abstractions in the design of your software
2. The object level
    - directly reuse objects from a library rather than writing the code yourself. Find appropriate libraries and discover if the objects and methods offer the functionality that you need.
3. The component level
    - Components are collections of objects and object classes that operate together to provide related functions and services
    - adapt and extend the component by adding some code of your own.
4. The system level
    - reuse entire application systems.
    - involves configuration of these systems by adding and modifying code (if you are reusing a software product line) or by using the system’s own configuration interface

### Cost related with reuse

The costs of the time spent in looking for software to reuse and assessing whether it meets your needs

The costs of buying the reusable software

The costs of adapting and configuring the reusable software components or systems to reflect the requirements of the system that you are developing.

The costs of integrating reusable software elements with each other (if you are using software from different sources) and with the new code that you have developed.

### Configuration Management

process of managing a changing software system.

to support the system integration process so that all developers can :
- access the project code and documents in a controlled way
- find out what changes have been made
- Compile and link components to create a system

#### Fundamental configuration management activities

1. Version management
    - to keep track of the different versions of software components. 
    - include facilities to coordinate development by several programmers. 
    - stop one developer from overwriting code that has been submitted to the system by someone else.
2. System integration
    - to help developers define what versions of components are used to create each version of a system. 
    - This description is then used to build a system automatically by compiling and linking the required components.
3. Problem tracking
    - to allow users to report bugs and other problems, 
    - to allow all developers to see who is working on these problems and when they are fixed.
4. Release management
    - new versions of a software system are released to customers.
    - concerned with planning the functionality of new releases and organizing the software for distribution

### Host-target development

Software is developed on one computer (the host) but runs on a separate machine (the target).

Development platform (host):
- Hardware
- installed operating system
- other supporting software such as a database management system
- An interactive development environment.

#### Simulators

- used when developing embedded systems
- Allows simulation of hardware devices, such as sensors, and the events in the environment in which the system will be deployed.
- speed up the development process for embedded systems as each developer can have his or her own execution platform with no need to download the software to the target hardware.
- expensive to develop and so are usually available only for the most popular hardware architectures.

### Tools to support software engineering processes

- An integrated compiler and syntax-directed editing system 
    - allows to create, edit, and compile code.
- A language debugging system.
- Graphical editing tools
    - tools to edit UML models.
- Testing tools
    - automatically run a set of tests on a new version of a program.
- Tools to support refactoring and program visualization.
- Configuration management tools
    - To manage source code versions
    - to integrate and build systems.

### Integrated Development Environment (IDE)

- set of software tools that supports different aspects of software development within some common framework and user interface.
- support development in a specific programming language (eg Java)
- may be developed specially or may be an instantiation of a general-purpose IDE, with specific language-support tools.
- framework for hosting software tools that provides
    - data management facilities for the software being developed
    - integration mechanisms that allow tools to work together.

### Consideration issues in choosing development platform

- The hardware and software requirements of a component
- The availability requirements of the system
- Component communications

# Open source development 