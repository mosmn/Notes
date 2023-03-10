# Introduction to RE

As discussed in [chapter 2](/sections/theo/sep/process.md) system requirements are the description of ehat the system should do and the constraints on system operations.

Requirements engineering (RE) -The process sof finding out, analyzing, documenting and checking these services and constraints.

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

Purpose: to understand the work that stakeholders do and how they might use a new system to help support that work

## Two requirement elicitation techniques

1. Interviewing: talk to people about what they do.
2. Observation or ethnography: watch people doing their job to see what artifacts they use, how they use them, and so on.

## PROCESS ACTIVITIES IN REQUIREMENTS ELICITATION

1. Requirements discovery
    - interacting with stakeholders of the system to discover their requirements
    - Domain requirements are also discovered
2. Requirements classification and organization
    - Unstructured collection of requirements, groups related requirements are organized into coherent clusters.
3. Requirements prioritization and negotiation
    - prioritize requirements and finding resolve requirements conflicts through negotiation
4. Requirements specification
    - Produce early draft of the software requirements documents
    - Document as input into the next round of the spiral

The cycle end when the requirements document has been produced

## SCENARIOS

- A structured form of user story
- Scenarios should include
    - A description of the starting situation
    - A description of the normal flow of events
    - A description of what can go wrong
    - Information about other concurrent activities
    - A description of the state when the scenario finishes

### EXAMPLE OF USER STORIES 1

>Photo sharing in the classroom
>Jack is a primary school teacher in Ullapool (a village in northern Scotland). He has decided that a class project should be focused on the fishing industry in the area, looking at the history, development, and economic impact of fishing. As part of this project, pupils are asked to gather and share reminiscences from relatives, use newspa- per archives, and collect old photographs related to fishing and fishing communities in the area. Pupils use an iLearn wiki to gather together fishing stories and SCRAN (a history resources site) to access newspaper archives and photographs. However, Jack also needs a photo-sharing site because he wants pupils to take and comment on each other's photos and to upload scans of old photographs that they may have in their families.
>Jack sends an email to a primary school teachers' group, which he is a member of, to see if anyone can rec- ommend an appropriate system. Two teachers reply, and both suggest that he use KidsTakePics, a photo-sharing site that allows teachers to check and moderate content. As KidsTakePics is not integrated with the iLearn authentication service, he sets up a teacher and a class account. He uses the iLearn setup service to add KidsTakePics to the services seen by the pupils in his class so that when they log in, they can immediately use the system to upload photos from their mobile devices and class computers.

### EXAMPLE OF SCENARIOS 1

>Uploading photos to KidsTakePics

>Initial assumption: A user or a group of users have one or more digital photographs to be uploaded to the picture-sharing site. These photos are saved on either a tablet or a laptop computer. They have successfully logged on to KidsTakePics.

>Normal: The user chooses to upload photos and is prompted to select the photos to be uploaded on the computer and to select the project name under which the photos will be stored. Users should also be given the option of inputting keywords that should be associated with each uploaded photo. Uploaded photos are named by creating a conjunction of the user name with the filename of the photo on the local computer.

>On completion of the upload, the system automatically sends an email to the project moderator, asking them to check new content, and generates an on-screen message to the user that this checking has been done.

>What can go wrong: No moderator is associated with the selected project. An email is automatically generated to the school administrator asking them to nominate a project moderator. Users should be informed of a possible delay in making their photos visible.

>Photos with the same name have already been uploaded by the same user. The user should be asked if he or she wishes to re-upload the photos with the same name, rename the photos, or cancel the upload. If users choose to re-upload the photos, the originals are overwritten. If they choose to rename the photos, a new name is automatically generated by adding a number to the existing filename.

>Other activities: The moderator may be logged on to the system and may approve photos as they are uploaded.

>System state on completion: User is logged on. The selected photos have been uploaded and assigned a status "awaiting moderation." Photos are visible to the moderator and to the user who uploaded them.


# Requirements specification

The process of writing down the user and system requirements in a requirements document.

## WAYS OF WRITING A SYSTEM REQUIREMENTS SPECIFICATION

User requirements are almost always written in natural language supplemented by appropriate diagrams and tables in the requirements document. 

System requirements may also be written in natural language, but other notations based on forms, graphical, or mathematical system models can also be used.

The user requirements for a system should describe the functional and nonfunctional requirements so that they are understandable by system users who don't have detailed technical knowledge. Ideally, they should specify only the external behavior of the system. The requirements document should not include details of the system architecture or design. Consequently, if you are writing user requirements, you should not use software jargon, structured notations, or formal notations. You should write user require- ments in natural language, with simple tables, forms, and intuitive diagrams.

Notation | Description
---|---
Natural language | The requirements are written using numbered sentences in natural language. Each sentence should express one requirement.
Structured natural language | The requirements are written in natural language on a standard form or template. Each field provides information about an aspect of the requirement.
Design description languages | This approach uses a language like a programming language, but with more abstract features to specify the requirements by defining an operational model of the system. This approach is now rarely used although it can be useful for interface specifications.
Graphical notations | Graphical models, supplemented by text annotations, are used to define the functional requirements for the system; UML use case and sequence diagrams are commonly used.
Mathematical specifications | These notations are based on mathematical concepts such as finite-state machines or sets. Although these unambiguous specifications can reduce the ambiguity in a requirements document, most customers don’t understand a formal specification. They cannot check that it represents what they want and are reluctant to accept it as a system contract

![s](/imgs/notations.png)

Is it sufficient to use a single way of notation when writing the system requirements specifications? Justify your answer.
- No, system requirements are detailed and complex, so it is not sufficient to use a single way of notation when writing the system requirements specifications. a single notation may not be able to fully capture all aspects of the requirements.

## NATURAL LANGUAGE SPECIFICATION

Requirements are written as natural language sentences supplemented by diagrams and tables.

Used for writing requirements because it is expressive, intuitive and universal. This means that the requirements can be understood by users and customers.

### GUIDELINES FOR WRITING REQUIREMENTS

- Invent a standard format and use it for all requirements.
- Use language in a consistent way. Use shall for mandatory requirements, should for desirable requirements.
- Use text highlighting to identify key parts of the requirement.
- Avoid the use of computer jargon.
- Include an explanation (rationale) of why a requirement is necessary

### PROBLEMS WITH NATURAL LANGUAGE

- Lack of clarity
- Requirements confusion
- Requirements amalgamation

## STRUCTURED SPECIFICATIONS

An approach to writing requirements where the freedom of the requirements writer is limited and requirements are written in a standard way. This works well for some types of requirements e.g. requirements for embedded control system but is sometimes too rigid for writing business system requirements.

### FORMAT USED FOR SPECIFYING FUNCTIONAL REQUIREMENTS

- Definition of the function or entity
- Description of inputs and where they come from
- Description of outputs and where they go to
- Information about the information needed for the computation and other entities used
- Description of the action to be taken
- Pre and post conditions (if appropriate)
- The side effects (if any) of the function

### A STRUCTURED SPECIFICATION OF A REQUIREMENT FOR AN INSULIN PUMP 

Format | Description
---|---
Function | Compute insulin dose: Safe sugar level.
Description | Computes the dose of insulin to be delivered when the current measured sugar level is in the safe zone between 3 and 7 units.
Inputs | Current sugar reading (r2), the previous two readings (r0 and r1).
Source | Current sugar reading from sensor. Other readings from memory.
Outputs | CompDose-the dose in insulin to be delivered.
Destination | Main control loop.
Action | CompDose is zero if the sugar level is stable or falling or if the level is increasing but the rate of increase is decreasing. If the level is increasing and the rate of increase is increasing, then CompDose is computed by dividing the difference between the current sugar level and the previous level by 4 and rounding the result. If the result, is rounded to zero then CompDose is set to the minimum dose that can be delivered.
Requires | Two previous readings so that the rate of change of sugar level can be computed.
Precondition | The insulin reservoir contains at least the maximum allowed single dose of insulin.
Postcondition | r0 is replaced by r1 then r1 is replaced by r2.
Side effects | None.

## TABULAR SPECIFICATION

- Used to supplement natural language.
- Particularly useful when you have to define a number of possible alternative courses of action.
- For example, the insulin pump systems bases its computations on the rate of change of blood sugar level and the tabular specification explains how to calculate the insulin requirement for different scenarios.

## USE CASES

- Use cases are a kind of scenario that are included in the UML(unified modeling language).
- Use cases identify the actors in an interaction and which describe the interaction itself.
- A set of use cases should describe all possible interactions with the system.
- High-level graphical model supplemented by more detailed tabular description (see Chapter 5).
- UML sequence diagrams may be used to add detail to use-cases by showing the sequence of event processing in the system.

## THE SOFTWARE REQUIREMENTS DOCUMENT

- The software requirements document is the official statement of what is required of the system developers.
- Should include both a definition of user requirements and a specification of the system requirements.
- It is NOT a design document. As far as possible, it should set of WHAT the system should do rather than HOW it should do it.

### USERS OF A REQUIREMENTS DOCUMENT

User | For
---|---
System customers | Specify the requirements and read them to check that they meet their needs. Customers specify changes to the requirements.
Managers | Use the requirements document to plan a bid for the system and to plan the system development process.
System engineers | Use the requirements to understand what system is to be developed.
System test engineers | Use the requirements to develop validation tests for the system.
System maintenance engineers | Use the requirements to understand the system and the relationships between its parts.

### REQUIREMENTS DOCUMENT VARIABILITY

- Information in requirements document depends on type of system and the approach to development used.
- Systems developed incrementally will, typically, have less detail in the requirements document.
- Requirements documents standards have been designed e.g. IEEE standard. These are mostly applicable to the requirements for large systems engineering projects.

# Requirements validation

- Concerned with demonstrating that the requirements define the system that the customer really wants
- Requirements error costs are high, so validation is very important
    - Fixing a requirements error after delivery may cost up to 100 times the cost of fixing an implementation error. requirements define the system that the customer really wants

REQUIREMENTS CHECKING:

- validity
- consistency
- completeness
- realism
- verifiability

## REQUIREMENTS VALIDATION TECHNIQUES

How can we check that the requirements are valid? There are a number of techniques that can be used to check the requirements:

- Requirements review - systimatic manual analysis of the requirements document
- Prototyping - using an executable model of the system to check the requirements
- Test case generation - developing tests for requirements to check testability

### REQUIREMENTS REVIEWS

- Regular reviews should be held while the requirements definition is being formulated.
- Both client and contractor staff should be involved in reviews.
- Reviews may be formal (with completed documents) or informal. Good communications between developers, customers and users can resolve problems at an early stage.

REVIEW CHECKS:
- Verifiability - is the requirement realistically testable?
- Comprehensibility - is the requirement properly understood?
- Traceability - is the origin of the requirement clearly stated?
- Adaptability - can the requirement be changed without a large impact on other requirements?

# Requirements change

## REASONS FOR CHANGING REQUIREMENTS

- The business and technical environment of the system always changes after installation. 
- The people who pay for a system and the users of that system are rarely the same people. 
- Large systems usually have a diverse user community, with many users having different requirements and priorities that may be conflicting or contradictory.

## REQUIREMENTS MANAGEMENT

Process of managing changing requirements during the requirements engineering process and system development.

New requirements emerge as a system is being developed and after it has gone into use. Therefore, it is required to :
- keep track of individual requirements and maintain links between dependent requirements to assess the impact of requirements changes. 
- establish a formal process for making change proposals and linking these to system requirements. 

EXAMPLE DEPENDENCY OF REQUIREMENTS:
- REQ1 :The system must validate the bank card is a valid card.
- REQ 2:The user should be able to input their PIN which consist of 6 numbers.
- REQ1 must happen first before REQ 2
- REQ1-> REQ2

### Requirements management planning

Requirements management planning is concerned with establishing how a set of evolving requirements will be managed. During the planning stage, you have to decide on a number of issues:
1. Requirements identification: Each requirement must be uniquely identified so that it can be cross-referenced with other requirements and used in traceability assessments.
2. A change management process: This is the set of activities that assess the impact and cost of changes. I discuss this process in more detail in the following section.
3. Traceability policies: These policies define the relationships between each require- ment and between the requirements and the system design that should be recorded. The traceability policy should also define how these records should be maintained.
4. Tool support: Requirements management involves the processing of large amounts of information about the requirements. Tools that may be used range from specialist requirements management systems to shared spreadsheets and simple database systems.

### REQUIREMENTS MANAGEMENT TOOLS

- Requirements storage - The requirements should be maintained in a secure, managed data store that is accessible to everyone involved in the requirements engineering process.
- Change management - Tools can keep track of suggested changes and responses to these suggestions.
- Traceability management - Allows possible relationships between requirements to be discovered.