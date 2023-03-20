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

Modeling system-to-system interaction highlights the communication problems that may arise.

Modeling component interaction helps to understand if a proposed system structure is likely to deliver the required system performance and dependability.

Two approaches for interaction modelling: Use case diagrams and sequence diagrams

## Use case modeling

- Use cases were developed originally to support requirements elicitation and now incorporated into the UML. 
- Each use case represents a discrete task that involves external interaction with a system. 
- Actors in a use case may be people or other systems. 
- Represented diagramatically to provide an overview of the use case and in a more detailed textual form.

Sample use cases Mentcare system Role ‘Medical Receptionist’:

![mc](/imgs/usecase1.png)

### UML Notation for USE CASE MODELLING

![mc](/imgs/usecaseuml.png)
![mc](/imgs/usecaseuml2.png)

Actor:
- Could be human beings, other system, timers and clocks or hardware device.
- 2 types of actor classification: 
    - Primary Actors: Actors that stimulate the system and the initiator of events.
    - Secondary Actors: Actors that only receive stimuli from the system.
- Actor Designing Consideration: 
    - Who / what will be interested in the system
    - Who / what will want to change the data in the system
    - Who / what will want to interface with the system
    - Who / what will want information from the system

Use Case:
- Use case should ideally begin with a verb.
- Should not be open ended. Register, wrong. Register New User, right.

Generalization:
- Used when you find 2 or more use cases that have commonalities in behavior, structure and purpose.
- A parent use case may be specialized into 1 or more child use cases that represent more specific form of the parent. example:

![mc](/imgs/usecaseg.png)

Include Relationship:
- Used when 2 or more use cases share some common portion in a flow of events.
- The common portion is grouped and extracted to form an inclusion use case to be shared among the use cases related.
- Specifies that the source use case explicitly incorporates the behavior of another use case at a location specified by the source. example:

![mc](/imgs/usecasei.png)

Extend Relationship:
- Extend relationship is used when 2 use cases are similar, but one does a bit more than the other.
- A base case under extend relationship may develop an alternative flow invoking an alternative use case.
- The extension use case adds extra behavior to the base use case.
- Specifies that the target use case extends the behavior of the source. example:

![mc](/imgs/usecasee.png)

### Function transfer data

![mc](/imgs/usecasef.png)

This is specific use case for “transfer data”. It represents a simple overview of an
interaction.

two actors (sticky men):
1. the operator who is transferring the data
2. the patient record system.

arrows indicates that the medical receptionist initiates the transaction and data is transferred to the patient record system.

### Use case Description

ID: | [Unique ID of this use case]
-- | --
Title: | [Enter the goal of the use case - preferably as a short, active verb phrase]
Description: | [Describe the goal and context of this use case. This is usually an expanded version of what you entered in the "Title" field.]
Primary Actor: | [A person or a software/hardware system that interacts with your system to achieve the goal of this use case.]
Preconditions: | [Describe the state the system is in before the first event in this use case.]
Postconditions: | [Describe the state the system is in after all the events in this use case have taken place.]
Main Success Scenario: | [Describe the flow of events from preconditions to postconditions, when nothing goes wrong. This is the meat of the use case.]
Alternatives scenario: | [Describe all the other scenarios for this use case - including exceptions and error cases.]

- the information normally comes from:
    1. Use case diagram
    2. Requirements gathered

Example: Use case LOGIN

ID: | UC001
-- | --
Title: | Login to the system
Description: | A registered user login to the system using username and password that have been created during the user registration process.
Primary Actor: | User
Preconditions: | User have registered to the system
Postconditions: | The system will display a system dashboard
Main Success Scenario: | 1. User will click the login link 2. System display the login page 3. User enter the username and password 4. User click the login button 5. System validates with user database 6. System display the user dashboard
Alternatives scenario: | 3.1 User enter invalid username or password 3.1.1 System display message “ Wrong username or password” 3.1.2 System executes step no 2 3.2 User enter invalid username and password 3.2.1 System display message “ Wrong username and password” 3.2.2 System executes step no 2

## Sequence Diagrams

- part of the UML
- to model the interactions between the actors and the objects within a system.
- shows the sequence of interactions that take place during a particular use case or use case instance.
- The objects and actors involved are listed along the top of the diagram, with a dotted line drawn vertically from these.
- interactions between objects are indicated by annotated arrows. 

### Sequence diagram for View patient information

![mc](/imgs/seq.png)

Use case VIEW PATIENT INFO:

ID: | UC03
-- | --
Title: | View Patient Info
Description: | This use case displays the patient inform for the view of authorized medical receptionist
Primary Actor: | Medical Receptionist
Preconditions: | Medical receptionist must login to the system
Postconditions: | The system displays the patient info
Main Success Scenario: | 1. Medical receptionist clicks the view patient info link 2. The system display the view patient request page 3. Medical receptionist enters the patient ID and click the view button 4. System validates the User ID for the view access 5. System display the patient info
Alternatives scenario: | 4.1 Access for view patient info is fail 4.1 The system display the error message “No Access”

# Structural models 

# Behavioral models