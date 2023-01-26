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

mindmap
  root((OS Definition, Objectives and Functions))
    root -->|Definition| def((Definition))
    root -->|Objectives| obj((Objectives))
    root -->|Functions| func((Functions))
    def -->|OS is a software that controlos the execution of application programs, its an interface between the application and hardware(computer system).| def1((OS is a software that controlos the execution of application programs, its an interface between the application and hardware(computer system).))
    def -->|The applicatin programs do not have direct access to the hardware, they must use the OS to access the hardware.| def2((The applicatin programs do not have direct access to the hardware, they must use the OS to access the hardware.))
    obj -->|Convenience| obj1((Convenience))
    obj -->|Efficiency| obj2((Efficiency))
    obj -->|Ability to Evolve| obj3((Ability to Evolve))
    obj1 -->|Makes the computer easier to use by acting as an interface between the user and the computer hardware.| obj11((Makes the computer easier to use by acting as an interface between the user and the computer hardware.))
    obj1 -->|Here how a computer is layered:| obj12((Here how a computer is layered:))
    obj1 -->|Utilities are set of system programs that help i program creation, managing files and controlling io devices.| obj13((Utilities are set of system programs that help i program creation, managing files and controlling io devices.))
    obj1 -->|OS services:| obj14((OS services:))
    obj1 -->|Program development| obj15((Program development))
    obj1 -->|Program execution| obj16((Program execution))
    obj1 -->|Access to I/O devices| obj17((Access to I/O devices))
    obj1 -->|Acounting| obj18((Acounting))
    obj1 -->|Error detection and response| obj19((Error detection and response))
    obj1 -->|Controlled Access to files| obj110((Controlled Access to files))
    obj1 -->|System Access| obj111((System Access))
    obj2 -->|Uses the computer system resources in an efficient manner. like CPU, memory, I/O devices, etc.| obj21((Uses the computer system resources in an efficient manner. like CPU, memory, I/O devices, etc.))
    obj2 -->|OS functions just like any other software, the difference is that:| obj22((OS functions just like any other software, the difference is that:))
    obj2 -->|Directs the processor in the use of other resources.| obj23((Directs the processor in the use of other resources.))
    obj2 -->|Schedules the timing of programs or processes.| obj24((Schedules the timing of programs or processes.))
    obj3 -->|Enables development, testing, and use of new software and hardware without disrupting the system. for example, if you connect a keyboard to the computer, the OS should be able to recognize it and use it.| obj31((Enables development, testing, and use of new software and hardware without disrupting the system. for example, if you connect a keyboard to the computer, the OS should be able to recognize it and use it.))
    obj3 -->|OS evolve overtime because there are always new hardware and software that need to be supported, and New services that need to be added and flaws that need to be fixed. this constant nedd for change sets a certine requirement for the OS implementation.To meet this requirement, operating systems need to be designed in a way that allows for flexibility and adaptability. One approach to achieving this is by making the operating system modular in its construction.| obj32((OS evolve overtime because there are always new hardware and software that need to be supported, and New services that need to be added and flaws that need to be fixed. this constant nedd for change sets a certine requirement for the OS implementation.To meet this requirement, operating systems need to be designed in a way that allows for flexibility and adaptability. One approach to achieving this is by making the operating system modular in its construction.))
    obj3 -->|When an operating system is modular in its construction, it means that it is designed to be composed of individual, interchangeable components or "modules" that can be easily added, removed, or replaced without affecting the rest of the system. This allows for flexibility and ease of maintenance, as well as the ability to update or upgrade specific parts of the system without having to overhaul the entire system.| obj33((When an operating system is modular in its construction, it means that it is designed to be composed of individual, interchangeable components or "modules" that can be easily added, removed, or replaced without affecting the rest of the system. This allows for flexibility and ease of maintenance, as well as the ability to update or upgrade specific parts of the system without having to overhaul the entire system.))
    obj3 -->|For an operating system to be modular, it is important to have clear defined interfaces between modules. The interfaces are the points where different modules interact with each other. These interfaces need to be well-defined and documented, so that developers can understand how to interact with them and how to use them to add new features or functionalities to the system.| obj34((For an operating system to be modular, it is important to have clear defined interfaces between modules. The interfaces are the points where different modules interact with each other. These interfaces need to be well-defined and documented, so that developers can understand how to interact with them and how to use them to add new features or functionalities to the system.))
    obj3 -->|Well-documented interfaces are also important for maintainability, as it allows developers to understand how different parts of the system interact with each other and how to troubleshoot issues that may arise. This documentation can also provide instructions and guidelines for developers who want to create new modules or make changes to existing ones.| obj35((Well-documented interfaces are also important for maintainability, as it allows developers to understand how different parts of the system interact with each other and how to troubleshoot issues that may arise. This documentation can also provide instructions and guidelines for developers who want to create new modules or make changes to existing ones.))
    obj3 -->|Overall, a modular design enables the creation of a more robust, adaptable, and scalable system, allowing it to meet the constant need for change in technology and user requirements.| obj36((Overall, a modular design enables the creation of a more robust, adaptable, and scalable system, allowing it to meet the constant need for change in technology and user requirements.))


# Part 2: Evolution of the OS

## Serial Processing

## Simple Batch Processing

## Multiprogrammed Batch Systems

## Time Sharing Systems

# Part 3: Major achievements

# Part 4: Characteristic of modern OS