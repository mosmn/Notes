# Part 1: OS definition, objectives and functions

Definition is "What it is", Objectives are "What it aims to do", and Functions are "What it does".

## Definition

- Operating system is a software that controlos the execution of application programs, its an interface between the application and hardware(computer system).
- The applicatin programs do not have direct access to the hardware, they must use the OS to access the hardware.

## Objectives

#### Convenience

Makes the computer easier to use by acting as an interface between the user and the computer hardware.

Here how a computer is layered:
```mermaid
graph TD;
    A(End User) -.-> B[Application];
    B --> C[Utilities];
    C --> D[Operating System];
    D --> E[Hardware];
```
Utilities are set of system programs that help i program creation, managing files and controlling io devices.

- OS services:
    - Program development
    - Program execution
    - Access to I/O devices
    - Acounting
    - Error detection and response
    - Controlled Access to files
    - System Access

#### Efficiency

Uses the computer system resources in an efficient manner. like CPU, memory, I/O devices, etc.

OS functions just like any other software, the difference is that:
- Directs the processor in the use of other resources.
- Schedules the timing of programs or processes.

#### Ability to Evolve

Enables development, testing, and use of new software and hardware without disrupting the system. for example, if you connect a keyboard to the computer, the OS should be able to recognize it and use it.

OS evolve overtime because there are always new hardware and software that need to be supported, and New services that need to be added and flaws that need to be fixed. this constant nedd for change sets a certine requirement for the OS implementation.To meet this requirement, operating systems need to be designed in a way that allows for flexibility and adaptability. One approach to achieving this is by __making the operating system modular in its construction.__

When an operating system is modular in its construction, it means that it is __designed to be composed of individual, interchangeable components or "modules" that can be easily added, removed, or replaced without affecting the rest of the system.__ This allows for flexibility and ease of maintenance, as well as the ability to update or upgrade specific parts of the system without having to overhaul the entire system.

For an operating system to be modular, it is important to __have clear defined interfaces between modules.__ The interfaces are the points where different modules interact with each other. These interfaces need to be well-defined and documented, so that developers can understand how to interact with them and how to use them to add new features or functionalities to the system.

__Well-documented__ interfaces are also important for maintainability, as it allows developers to understand how different parts of the system interact with each other and how to troubleshoot issues that may arise. This documentation can also provide instructions and guidelines for developers who want to create new modules or make changes to existing ones.

Overall, a modular design enables the creation of a more robust, adaptable, and scalable system, allowing it to meet the constant need for change in technology and user requirements.

```mermaid
graph TD;
    classDef default fill:#ffffff,stroke:#000000,font-size:20px;
    class A,B,C default;
    A(Operating System) --> B[Definition];
    A --> C[Objectives];
    A --> D[Functions];
    B --> E[Controls execution of application programs];
    B --> F[Interface between application and hardware];
    C --> G[Convenience];
    C --> H[Efficiency];
    C --> I[Ability to Evolve];
    G --> J[Makes computer easier to use];
    G --> K[Acts as interface between user and hardware];
    H --> L[Uses system resources efficiently];
    H --> M[Directs processor in use of resources];
    H --> N[Schedules timing of programs/processes];
    I --> O[Development, testing, and use of new software/hardware];
    I --> P[Modular construction];
    P --> Q[Individual, interchangeable components];
    P --> R[Easy addition/removal/replacement];
    P --> S[Flexibility and adaptability];
    P --> T[Clear defined interfaces between modules];
    P --> U[Well-documented interfaces];

```

# Part 2: Evolution of the OS

## Serial Processing

## Simple Batch Processing

## Multiprogrammed Batch Systems

## Time Sharing Systems

# Part 3: Major achievements

# Part 4: Characteristic of modern OS