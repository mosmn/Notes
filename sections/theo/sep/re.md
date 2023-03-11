# Introduction to RE

As discussed in [chapter 2](/sections/theo/sep/process.md) system requirements are the description of ehat the system should do and the constraints on system operations.

Requirements engineering (RE) -The process sof finding out, analyzing, documenting and schecking these services and constraints.

WHAT IS A REQUIREMENT?
- Definition : a high-level, abstract statement that a system should provide or a constraint on a system.
- Requirements may serve a dual function:
    - May be the basis for a bid for a contract - therefore must be open to interpretation;
    - May be the basis for the contract itself - therefore must be defined in detail;
    - Both these statements may be called requirements.

## TYPES OF REQUIREMENT

1. User requirements: Statements in natural language plus diagrams of the services the system provides and its operational constraints. Written for customers. High-level abstract requirements
2. System requirements: A structured document setting out detailed descriptions of the system’s functions, services and operational constraints. Defines what should be implemented. May be part of a contract between client and contractor. Detailed system descriptions

### Example

User requirementss definition
> 1. The Mentcare system shall generate monthly management reports showing the cost of drugs prescribed by each clinic during that month. 

System requirements specification
> 1.1 On the last working day of each month, a summary of the drugs prescribed, their cost and the prescribing clinics shall be generated.
> 1.2 The system shall generate the report for printing after 17.30 on the last working day of the month.
> 1.3 A report shall be created for each clinic and shall list the individual drug names, the total number of prescriptions, the number of doses prescribed and the total cost of the prescribed drugs.
> 1.4 If drugs are available in different dose units (e.g. 10mg, 20mg, etc) separate reports shall be created for each dose unit.
> 1.5 Access to drug cost reports shall be restricted to authorized users as listed on a management access control list.

### READERS OF DIFFERENT TYPES OF REQUIREMENTS SPECIFICATION 

User requirements:
- Client managers 
- System end-users 
- Client engineers 
- Contractor managers 
- System architects

System requirements:
- System end-users 
- Client engineers 
- System architects 
- Software developers

The readers of the user requirements are not usually concerned with how the system will be implemented and may be managers who are not interested in the detailed facilities of the system. 

The readers of the system requirements need to know more precisely what the system will do because they are concerned with how it will support the business processes or because they are involved in the system implementation.

System stakeholders - anyone who:
- affected by the system in some way
- has a legitimate interest in the system

Stakeholder types:
- End users
- System managers
- System owners
- External stakeholders

# Functional and nonfunctional requirements

Functional requirements | Non-functional requirements
--- | ---
Statements of services the system should provide, how the system should react to particular inputs and how the system should behave in particular situations. | Constraints on the services or functions offered by the system such as timing constraints, constraints on the development process, standards, etc.

## Functional requirements

- Describe functionality or system services.
- Depend on the type of software, expected users and the type of system where the software is used.
- Functional user requirements may be high-level statements of what the system should do.
- Functional system requirements should describe the system services in detail.

### MENTCARE SYSTEM: FUNCTIONAL REQUIREMENTS

- REQ1: A user shall be able to search the appointments lists for all clinics.
- REQ2: The system shall generate each day, for each clinic, a list of patients who are expected to attend appointments that day.
- REQ3: Each staff member using the system shall be uniquely identified by his or her 8-digit employee number.

### REQUIREMENTS IMPRECISION

- Problems arise when functional requirements are not precisely stated.
- Ambiguous requirements may be interpreted in different ways by developers and users.
- Consider the term ‘search’ in REQ1
    - User intention – search for a patient name across all appointments in all clinics;
    - Developer interpretation – search for a patient name in an individual clinic. User chooses clinic then search.

### REQUIREMENTS COMPLETENESS AND CONSISTENCY

- In principle, requirements should be both complete and consistent.
    - Complete: They should include descriptions of all facilities required.
    - Consistent: There should be no conflicts or contradictions in the descriptions of the system facilities.
- In practice, because of system and environmental complexity, it is impossible to produce a complete and consistent requirements document.

### HOW TO WRITE GOOD FUNCTIONAL REQUIREMENTS

Must include these 3:
1. Role
2. Verb
3. Condition

For example:

- A user shall be able to search the appointments lists for all clinics.
    - Role: A user
    - Verb: Shall be able to search
    - Condition: The appointments lists for all clinics

- The system shall generate each day, for each clinic, a list of patients who are expected to attend appointments that day.
    - Role: The system
    - Verb: Shall generate
    - Condition: Each day, for each clinic, a list of patients who are expected to attend appointments that day.

- Each staff member using the system shall be uniquely identified by his or her 8-digit employee number.
    - Role: Each staff member using the system
    - Verb: Shall be uniquely identified
    - Condition: By his or her 8-digit employee number.
    
## Non-functional requirements

- These define system properties and constraints e.g.reliability, response time and storage requirements.
- Constraints are I/O device capability, system representations, etc.
- Process requirements may also be specified mandating a particular IDE, programming language or development method.
- Non-functional requirements may be more critical than functional requirements. If these are not met, the system may be useless.

### NON-FUNCTIONAL REQUIREMENTS IMPLEMENTATION

- Non-functional requirements may affect the overall architecture of a system rather than the individual components.
    - For example, to ensure that performance requirements are met, you may have to organize the system to minimize communications between components.
- A single non-functional requirement, such as a security requirement, may generate a number of related functional requirements that define system services that are required.
    - It may also generate requirements that restrict existing requirements.

### RELATIONSHIP BETWEEN FUNC AND NON FUNC

Normally func reqs is derived based on the features of system

For non func reqs it were derived or a whole system without focusing on any particular features, But in some situation non func reqs are derived based on the features

Example:
- Features – F1 :Upload picture
- Func reqs – FR1.1 –User shall be able to upload their picture for their profile
- Non Func reqs – NFR1.1- The picture format must be in JPG
- NFR1.2 - The picture size must not exceed than 100MB

### NON-FUNCTIONAL CLASSIFICATIONS

Product requirements | Organisational requirements | External requirements
--- | --- | ---
Requirements which specify that the delivered product must behave in a particular way. | Requirements which are a consequence of organisational policies and procedures. | Requirements which arise from factors which are external to the system and its development process.
e.g. execution speed, reliability, etc. | e.g. process standards used, implementation requirements, etc. | e.g. interoperability requirements, legislative requirements, etc.

EXAMPLES OF NONFUNCTIONAL REQUIREMENTS IN THE MENTCARE SYSTEM:

Product requirement:
- The Mentcare system shall be available to all clinics during normal working hours (Mon–Fri, 0830–17.30).
- Downtime within normal working hours shall not exceed five seconds in any one day.
Organizational requirement:
- Users of the Mentcare system shall authenticate themselves using their health authority identity card.
External requirement:
- The system shall implement patient privacy provisions as set out in HStan-03-2006-priv. 

## GOALS VS REQUIREMENTS

- Non-functional requirements may be very difficult to state precisely and imprecise requirements may be difficult to verify.
- Goal: A general intention of the user such as ease of use.
- Verifiable non-functional requirement: A statement using some measure that can be objectively tested.
- Goals are helpful to developers as they convey the intentions of the system users.

### EXAMPLE OF USABILITY REQUIREMENTS

Goal:
- The system should be easy to use by medical staff and should be organized in such a way that user errors are minimized.

Testable non-functional requirement:
- Medical staff shall be able to use all the system functions after four hours of training. After this training, the average number of errors made by experienced users shall not exceed two per hour of system use.

### METRICS FOR SPECIFYING NONFUNCTIONAL REQUIREMENTS

Property | Measure
--- | ---
Speed | Processed transactions/second. User/event response time. Screen refresh time.
Size | Mbytes. Number of ROM chips.
Ease of use | Training time. Number of help frames.
Reliability | Mean time to failure. Probability of unavailability. Rate of failure occurrence. Availability.
Robustness | Time to restart after failure. Percentage of events causing failure. Probability of data corruption on failure.
Portability | Percentage of target dependent statements. Number of target systems.

# Requirements engineering (RE) processes

A SPIRAL VIEW OF THE REQUIREMENTS ENGINEERING PROCESS:
![s](/imgs/spire.png)

# Requirements elicitation

# Requirements specification

# Requirements validation

# Requirements change