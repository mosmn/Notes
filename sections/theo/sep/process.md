Even tho there are many different types of software systems(as introduced in [chap1](/sections/theo/sep/intro.md)), and there is no universal process that can be applied to all of them,
they all must include in some form the four fundamental activities of software engineering: specification, design implementation, validation and evolution.

Its also important to describe what is produced, who is involved and conditions that influence the sequence of activities:

1. Product: outcome of the process activity.
2. Roles: people involved in the process activity.
3. Pre- and post-conditions: conditions that must be satisfied before and after the process activity.

Software processes categories:

Plan-driven processes | Agile processes
--- | ---
All of the process activities are planned in advance | Planning is incremental
Progress is measured against the plan | Easier to change the process to reflect changing customer requirements
Process activities are performed in a fixed sequence | Process activities are performed in a flexible sequence

# Software Process Modules

Its an abstract representation of a process. it presents a descreption of the process from some particular perspective.

## Generic Process Modules

### The waterfall model

Plan-driven model. This approach separates the process into distinct phases, each of which is completed before the next phase begins.

Benefits | Drawbacks | Applicability
--- | --- | ---
Clear and seperate phases | Difficut to change requirements| Well-defined requirements
|    | No feedback from the customer. | Changes are limited during the design process
|    | | Large systems
|    | | Embedded systems
|   | | Critical systems

### Incremental development

This approach interleaves the process activities of specification, design, implementation and validation. The system is developed as a series of versions, with each version adding new functionality to the previous version. Could be plan-driven or agile.

Benefits | Drawbacks | Applicability
--- | --- | ---
Reduce cost of changes | Invisible process, need regular deliveables to measure progress | Clear requirements
Early feedback from the customer | System structure degrade as new increments are added | Product needs to be delivered quickly
Fast software delivery & deployment | | New tech is being used

### Integration and configuration

This approach relies on the availability of reusable components or systems. The system development focuses on configuring these components for use in the new setting and integrating them into a system. Could be plan-driven or agile.

Type of reuseable software:
- Stand-alone application systems – COTS (Commercial Off-The-Shelf)
- Objects collection - .NET, Java Spring framework, React, etc.
- Web service that provides remote invocation - REST API, SOAP, etc.

Benefits | Drawbacks
--- | ---
Reduse costs and risks | System may not meet the customer's requirements
Faster delivery | Lost control on evolution of reused software

# Process Activities

## Specification

Two things are established in this process:
1. What services are required?
2. What are the constraints on the system?

### Requirements engineering

- To produce an agreed requirements document that specifis a system satisfying stakeholder(owner) requirements.

- Presented at two levels of detail:
    1. End-users and customers - high level statements of the requirements. (abstract)
    2. System developers - detailed system specifications.(logical)

- The RE process has 4 main activities:
    1. Feasibility study
        - Can the identified user needs may be satisfied using current software and hardware technologies?
        - Will the proposed system will be cost-effective from a business point of view? 
        - Can the proposed system develop within existing budgetary constraints?
        - Should we develop the proposed system?
    2. Requirements elicitation and analysis - delivering the system requirements through observation of existing systems, discussions with potential users and so on. May involve the develpoment of one or more system models and prototypes to help you understand the system to be specified.
    3. Requirements specification - translating the info gathered during the Requirements Elicitation and Analysis activity into a document that defines a set of requirements. two types: end-user requirements and system requirements.
    4. Requirements validation - checks the requirements for realism, consistency and completeness. erroes in the requirements document discovered and corrected.


## Design and implementation

The process of converting the system specification into an executable system.
- Design, designing a software structure that realizes the specification.
- Implementation, translating the design into an executable program.
These two are closely related and may be interleaved(meaning that they may be performed in parallel).

A general model of the design process:

![design process](/imgs/dprocess.png)



## Validation

The process activity of validating the system. The validation activity is concerned with the following:

## Evolution

The process activity of evolving the system. The evolution activity is concerned with the following:

# Coping with Change

# Process Improvement