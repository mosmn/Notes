
# HCI in the software process

## The Design Process

### The Software Life Cycle

- Software engineering is the discipline for understanding the software design process, or life cycle

- Designing for usability occurs at all stages of the life cycle, not as a single isolated activity

### Activities in The Life Cycle

### 1. Requirements Specification

- The designer and customer collaborate to capture the expected system functionality.
- Expressions can range from natural language to more precise languages, such as task analysis.

### 2. Architectural Design

- Provides a high-level description of how the system will offer required services.
- Divides the system into major components and establishes their interrelations.
- Addresses both functional and nonfunctional requirements.

### 3. Detailed Design

- Refinement of architectural components and interrelations.
- Identifies modules to be implemented separately.
- The refinement process adheres to nonfunctional requirements.

### 4. Coding and Unit Testing

- Implementation of the detailed design.
- Unit testing ensures individual components function as intended.

### 5. Integration and Testing

- Combines individual components and tests their interactions.
- Ensures the integrated system functions as a whole.

### 6. Operation and Maintenance

- Ongoing activities to support and enhance the software in its operational environment.

#### The Waterfall Model

The Waterfall Model outlines the sequential phases of the software development life cycle:

1. **Requirements Specification**
2. **Architectural Design**
3. **Detailed Design**
4. **Coding and Unit Testing**
5. **Integration and Testing**
6. **Operation and Maintenance**

### Verification & Validation

- **Verification**: Ensuring the product is designed correctly.
- **Validation**: Ensuring the right product is designed.
- **The Formality Gap**: Validation may rely on subjective means of proof to some extent.
- **Management and Contractual Issues**: Addressing design considerations in commercial and legal contexts.

Real-world Requirements and Constraints:

Understanding the gap between formal requirements and real-world constraints is crucial in software engineering. It involves acknowledging the limitations of formal validation methods.

## Interactive Systems

### Life Cycle for Interactive Systems

Interactive systems involve a dynamic and iterative life cycle with a strong emphasis on usability, marked by continuous feedback throughout the development process. This contrasts with the linear sequence of activities found in the waterfall model because of the need to address usability issues at all stages of the life cycle.

### Usability

- Usability is defined as "the extent to which a product can be used by specified users to achieve specified goals with effectiveness, efficiency, and satisfaction in a specified context of use."

#### Importance of Usability

- Usability is crucial as it determines the success or failure of a system.
- It impacts task accuracy, completion, and user satisfaction.
- Poor usability can lead to reduced productivity and increased time and effort.

#### Improving Usability

- Usability improvement strategies include shortening task completion time, reducing mistakes, minimizing learning time, and enhancing user satisfaction with the system.

#### User Types

- Novice Users: Limited knowledge of the task and computer concepts.
- Knowledgeable Intermittent Users: Understand task concepts, have broad computer knowledge, and intermittently use the system.
- Expert Frequent (Power) Users: Thoroughly familiar with both task and interface concepts, likely to use the system often.

#### Domain & Expertise

- Users can be categorized based on their computer experience and domain knowledge.

#### Typical Ways of Measuring Usability

- Jakob Nielsen (2003) defines usability by five quality components:

1. Learnability

- Measures how easy it is for novice users to accomplish basic tasks the first time they encounter the design.

2. Efficiency

- Assesses how quickly users can perform tasks once they have learned the design.

3. Memorability

- Examines how easily users can reestablish proficiency after a period of not using the design.

4. Errors

- Considers the number and severity of errors users make and how easily they can recover.

5. Subjective Satisfaction

- Assesses the subjective satisfaction of users regarding the pleasantness of using the design.


### Learning Curves

- Systems may focus on learnability for novice users or emphasize efficiency for proficient users.
- Some systems support a combination of ease of learning and an "expert mode."

# Usability Engineering

## Introduction to Usability Engineering

Usability engineering is a user-centered design process that emphasizes user and task analysis, as well as the active involvement of users in both the design and testing phases. This approach leads to the development of more usable products compared to those developed without considering user considerations and involvement.

## Usability Engineering Lifecycle

1. **Users, Tasks, Environment Analysis**
2. **Usability Goals, Competitive Analysis**
3. **First Prototype**
4. **Formative Testing**
5. **Parallel Design Sketches**
6. **Participatory Design**
7. **Iterative Design**
8. **Final Released Product**

### Detail Explanation of Usability Engineering

- The process involves testing the old design to identify strengths and weaknesses.
- Competitive analysis of competitors' designs provides valuable insights.
- A field study observes user behavior in their natural habitat.
- Paper prototypes are created and tested, with a focus on low-fidelity designs initially.
- Refinement through multiple iterations leads to a high-fidelity design.
- The design is inspected relative to established usability guidelines.
- Final design implementation is tested again to address subtle usability problems.

## Usability Engineering Lifecycle Steps

### 1. Users Analysis

- Identify user requirements and problems.
- Define the user population, assess their skills, knowledge, and experience.
- Conduct a task analysis to guide interface design.

Example – Step 1

Identify user requirements and problems:
- Typical Profile:
    - 40 % Novice Users
    - 57 % Knowledgeable/Intermittent Users
    - 3 % Expert Users
- Other Important Information:
    - 10 % of user population colour blind
    - 15 % are the elderly

#### Task Analysis HTA (Hierarchical Task Analysis)

Identify user requirements and problems:

- Task analysis allows a designer to identify the goals
and purposes of the intended user group.
- This used to involve further analysis of user
requirements or investigation/observation of
customers
- Used to guide user interface design

### 2. Usability Goals and Competitive Analysis

- Establish usability goals based on metrics like learnability, efficiency, memorability, error rates, and subjective satisfaction.
- Perform competitive analysis by examining similar products and software components.

### 3. Parallel Design

- Explore design alternatives through independent work by designers.

### 4. Participatory Design

- Engage a pool of representative users in discussions about prototypes and designs.

### 5. Prototyping & Testing

- Perform usability evaluation early in the design cycle by building and evaluating prototypes.

### 6. Applying Guidelines

- Utilize general principles and advice about usability characteristics from established guidelines.

## ISO Usability Standard 9241

- Adopts traditional usability categories: effectiveness, efficiency, and satisfaction.

## Iterative Design and Prototyping

- Overcomes problems of incomplete requirements.
- Prototypes simulate or animate features of the intended system.
- Management issues include time, planning, non-functional features, and contracts.

## Techniques for Prototyping

- Storyboards and limited functionality simulations aid in the iterative design process.

## Design Thinking

- Design rationale explains why a computer system is designed a certain way.
- Benefits include communication throughout the life cycle, reuse of design knowledge, and presenting arguments for design trade-offs.

## Psychological Design Rationale

- Supports the task-artifact cycle, making explicit the consequences of design for users.
- Designers identify tasks the system will support, observe users on the system, and make psychological claims explicit.

# Summary

- The software engineering life cycle
    - distinct activities and the consequences for interactive system
       design
- Usability engineering
    - making usability measurements explicit as requirements
- Iterative design and prototyping
    - limited functionality simulations and animations
- Design rationale
    - recording design knowledge
    - process vs. structure


