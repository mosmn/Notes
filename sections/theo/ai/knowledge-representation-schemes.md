# Outline

- Formal Logic
- Semantic Networks
- Conceptual Graph
- Frames
- Scripts
- Production Rule
- Reasoning Methods in Production Rule Systems


# Introduction

## 1. Knowledge Base Overview

- Knowledge base, as described by Bobrow (1975), is a **mapping** between the **objects and relations** in a **problem domain** and the computational objects and relations of a program.
- Inferences in the knowledge base are assumed to correspond to the **results of actions** or observations in the world.
- The computational objects, relations, and inferences available to programmers are **mediated** by the knowledge representation language.

## 2. Representational Scheme vs. Medium

- Distinguishing between a representational **_scheme_** and the **_medium_** of its implementation is crucial.
- Similar to the distinction between data structures and programming languages.
  - Programming languages serve as the **_medium_** of implementation, while the data structure is the **_scheme_**.
- In AI:
  - The medium of implementation could be Prolog, Lisp, C++, or Java.
  - Representational schemes can be categorized into four types (Mylopoulos and Levesque, 1984).

## 3. Representational Schemes

### a. Logical Schemes

- This class uses expressions in **formal logic** to represent a knowledge base.
- **Inference** and **proof rules** procedures apply this knowledge to problem instances.

### b. Network Schemes

- Network representations capture knowledge as a graph.
- Nodes represent objects or concepts, and arcs represent relations or associations.
- Includes **Semantic network** and **conceptual graph.**

### c. Structured Schemes

- Structured representation languages extend networks by allowing each node to be a complex data structure.
- Consists of named slots with attached values.
- Examples include **Scripts and frames.**

### d. Procedural Schemes

- Procedural schemes represent knowledge as a set of instructions for solving a problem.
- Contrasts with declarative representations provided by logic and semantic networks.
- Example: **Rule production** system.


# Formal Logic

## 1. Logical Representation Scheme

- This class of representations utilizes expressions in formal logic to depict a knowledge base.
- Inference rules and proof procedures are employed to apply this knowledge to specific problem instances.
- Covered in-depth in previous chapters: Chapter 2 (Logic), Chapter 3 (Propositional & Predicate Logic), and Chapter 4 (Automated Reasoning and Theorem Proving).

## 2. Advantages

- **Facts asserted independently of use**: The logical representation allows for the assertion of facts independently of their immediate application.

## 3. Disadvantages

- **Separation of representation and processing**: The representation and processing stages are distinct, which can lead to challenges in system integration and adaptation.

- **Inefficiency with large data sets**: Formal logic can be inefficient when dealing with extensive data sets, impacting performance.

- **Very slow with large knowledge bases**: As the size of the knowledge base grows, the application of formal logic tends to become very slow, affecting responsiveness and practicality.

# Network Representation Schemes

# Semantic Networks

## 1. Overview

- A semantic net is characterized by a binary relation.
- Concepts are represented by nodes, and links between nodes symbolize relationships.
- Drawbacks include challenges in incorporating disjunctive and conjunctive information, such as the color of an apple or the colors of a panda.

## 2. Elements of Semantic Networks

- **Relationships labeled on arcs**:
  - is_a
  - has_a
  - has_part

- **Examples of Concepts (Nodes)**:
  - bird
  - person
  - book
  - famous
  - intelligent

## 3. Example of a Bird's Property in Semantic Network

```
feathers bird
```
```
small bluebird blue
```
```
flies
```
```
is_a
```
```
size
```
```
has_covering has_property
```
```
has_color
```

## 4. Creating a Semantic Network

### Example Description:
- Lab is a room.
- Lab has a door.
- Lab has many computers.
- Printer is in the lab.
- Laser printer is a Printer.

```
LAB
```
```
DOOR
```
```
ROOM
```
```
COMPUTERS
```
```
PRINTERS LASER_PRINTER
```
```
has_a
is_a
has
```
```
is_a
```
```
in
```

## 5. Inheritance in Semantic Networks

- **Inheritance Feature**:
  - Captures and shows inheritance, a powerful feature not found in other schemes.
  - Can be combined with other representation methods.

### Example of Inheritance:

```
Animal
Breathe
Move
Fly
Bird
Wings
Feathers
```
```
Canary Sing
is Yellow
```
```
can
```
```
can
```
```
has
```
```
has
```
```
can
```
```
can
```
- Animal’s properties are inherited by Bird, and Bird’s properties are inherited by a bird species called canary.

### Exception Handling in Inheritance

- Sometimes, inheritance may cause problems.
- Example: Penguin inherits the property "fly," but in practice, it cannot.
- To address this, specific properties must be attached through local nodes to avoid ambiguity and facilitate exception handling.

## 6. Advantages and Disadvantages

### Advantages

- **Easy to follow hierarchy**: The hierarchical structure is easy to understand.
- **Easy to trace association**: Associations between nodes are easily traceable.
- **Flexible**: Can be combined with other representation methods.

### Disadvantages

- **Meaning attached to nodes might be ambiguous**: Ambiguity may arise in the interpretation of node meanings.
- **Exception handling is difficult**: Dealing with exceptions in inheritance can be challenging.
- **Difficult to program**: Implementing semantic networks can be complex.

# Conceptual Graphs

## 1. Introduction

- Developed in 1984, conceptual graphs (networks) provide a solution to the restriction of binary relations.
- These graphs make all links unlabelled, enhancing flexibility in representation.

## 2. Conceptual Nets for "OR"

- A conceptual net can represent "OR," demonstrating a disjunctive net for a red or green apple.

```
Apple
Green
```
```
Red
```
```
Color
```

## 3. Conceptual Nets for "Where do Rivers Flow to?"

- A conceptual net can represent the question "Where do rivers flow to?"

```
River
flow_to
```
```
Sea
Lake
```
```
Marsh
```

## 4. Conceptual Net for "AND"

- A conceptual net can represent "AND," illustrating a conjunctive net for a black and white panda.

```
PANDA
```
```
WHITE
```
```
BLACK
```
```
Color
```
```
Color
```

## 5. Advantages and Potential

### Advantages

- Overcomes the restriction to binary relations.
- All links are unlabelled, offering flexibility in representation.

Conceptual graphs provide a versatile way to represent complex relationships, making them suitable for a variety of scenarios and knowledge domains.

# Structured Representations Schemes

# Frames

## 1. Overview

- The concept behind frames is to store information in meaningful chunks.
- A frame typically consists of several slots, each containing specific information.

## 2. Example Frame

- This frame has **4 slots** related to a book:

```
BOOK
Title : Qualitative Reasoning
Author : Ken D. Forbus
Publisher : Prentice-Hall
Year : 2000
```

## 3. Conversion from Frames to Semantic Nets

```
book
```
```
author
```
Forbus
QPT

```
novel
```
```
book
publisher
```
```
encyclopedia
```
```
editor
```
```
has_a has_a
```
```
is_a is_a
```
```
has_a
```
```
has_a
```
```
is_a
```
```
is_a
```

## 4. Example Frame Descriptions

```
Hotel Room
specialisationof:room
location: the hotel
contains: bed, chair & phone
```
```
HotelPhone
specialisationof:phone
use: calling room service
billing: through room
```
**Hotel Bed**
superclass:bed
size: king
contains: mattress,pillow, etc.

## 5. Analysis of Frames

- Frames describe objects by embedding all the information about that object in "slots."
- Slots are analogous to fields or attributes in programming, providing an advantage.
- A frame is similar to a database record.
- Frames describe typical instances of the concepts they represent.

## 6. Advantages and Disadvantages

### Advantages

- **Expressive power**: Frames offer a high level of expressiveness.
- **Easy to set up slots for new properties and relations**: Adding new information is straightforward.
- **Easy to include default information**: Default values for properties are easily incorporated.

### Disadvantages

- **Difficult to program**: Implementing frames can be challenging.
- **Difficult for inference**: Drawing logical conclusions from frames can be complex.
- **Lack of inexpensive software**: Availability of affordable software tools for implementing frames may be limited.

# Scripts

## 1. Overview

- Scripts are similar to frames but focus on describing a sequence of events rather than just an object.
- Like frames, scripts depict a stereotyped situation.

## 2. Components in Scripts

### Entry-conditions

- Must be true for the script to begin.
- Also known as descriptors.

### Results

- Facts that are true once the script has ended.

### Props

- Objects or things that support a given script.

### Roles

- Actions performed or executed by individual actors.

### Scenes/Episodes

- Breaks a script into a series of "episodes" called scenes.
- Example: entering, ordering, billing, exiting (for a restaurant scenario).
- A scene represents a temporal aspect of the script.

# Production Rules

## 1. Overview

- Most Expert Systems (ES) are rule-based, meaning their knowledge base consists of a set of production rules.
- Facts, rules, and inference engines are essential components for the execution of a rule-based expert system.
- Production rules capture knowledge in a simple "if-then" format.

## 2. Nature of Production Rules

- The human mental process, too complex to be represented as an algorithm, can be expressed in the form of rules for problem-solving.
- Example rules:
  - **IF** the traffic light is green **THEN** the action is go.
  - **IF** the traffic light is red **THEN** the action is stop.

## 3. Structure of a Production Rule

- A production rule consists of two parts:
  - **The IF part (antecedent, premise, or condition)**
  - **The THEN part (consequent, conclusion, or action)**
- Example:
  - **IF** <traffic light is green> **THEN** <go>
  - **IF** <traffic light is red> **THEN** <stop>

## 4. Logical Operators in Production Rules

- Multiple conditions are joined by logical operators like AND (conjunction) or OR (disjunction).
- Example:
  - **IF** <condition-1> **AND** <condition-2> **THEN** <action>
  - **IF** <condition-1> **OR** <condition-2> **THEN** <action>

## 5. Mathematical Operators in Production Rules

- Rules can use mathematical operators to define numerical conditions.
- Example:
  - **IF** Age of the student < 21 **AND** SPM no. of A’s >= 8 **THEN** Admit the student to BIT

## 6. Types of Rules

- Rules can represent relations, recommendations, directives, heuristics, and strategies.

### Examples:

- **Relations:**
  - **IF** the fuel tank is empty **THEN** the car will not start.

- **Recommendation:**
  - **IF** you study hard **AND** you study smart **AND** you never absent **THEN** you will get an “A”

- **Strategy:**
  - **IF** the car is dead **THEN**
    - check fuel tank (step 1 is complete),
    - if step 1 is complete **AND** the fuel tank is full **THEN**
      - check battery (step 2 is complete),
      - if step 2 is complete **AND** the battery is replaced **THEN**
        - check electrical fuel lines, and so on.

- **Heuristics:**
  - **IF** the spill is liquid **AND** the spill pH is < 6 **AND** the smell is vinegar **THEN** the spill material is acetic acid

- **Directive:**
  - **IF** the fuel tank is empty **THEN** refuel the car.

## 7. Advantages and Disadvantages

### Advantages:

- Simple syntax.
- Easy to understand.
- Simple interpreter.
- Flexible (easy to add or modify).

### Disadvantages:

- Hard to follow hierarchies.
- Poor at representing structured descriptive knowledge.
- Ineffective search strategy.
- Not all knowledge can be expressed as rules.

## 8. Production System Model

- **Components:**
  - Production Rules
  - Long-term memory (Knowledge-base, Facts)
  - Short-term memory (Database)
  - Inference Engine
  - Explanation Facility
  - User Interface

## 9. "Firing" of Rules (Imortant)

- When the condition part of a rule is satisfied, the rule is said to fire, and the action part is executed.
- The inference engine carries out reasoning, linking rules in the knowledge base with facts in the database.
- The explanation facility enables users to ask questions like "why" and "how."

# Reasoning Methods in Production

## Rule Systems

The design of the reference engine plays a crucial role in rule-based expert systems. Two reasoning methods are often used in rule-based expert systems:

### Forward Chaining

- **Data-driven reasoning**
- The reasoning starts from known facts or data and proceeds forward with the data.
- Each time, only the topmost rule is executed, adding new facts to the database.
- The match-fire cycle stops when no further rules can be fired.

#### Example of Forward Chaining

Given a rule-based expert system with 4 rules:

1. If A and C Then F
2. If A and E Then G
3. If B Then E
4. If G Then D

Question: Prove If A and B are true, then D is true.

- Start with Rule 1 and proceed forward until a rule "fires."
- A, B, E, G, and D are eventually added to the database, proving the goal D.

### Backward Chaining

- **Goal-driven reasoning**
- Best applied when trying to find out the reason something has occurred.
- The expert system attempts to satisfy a goal and finds evidence to prove it.
- If evidence is found, the goal is proved; otherwise, backtracking is initiated.

#### Example of Backward Chaining

Rules:

1. If A and C Then E
2. If D and C Then F
3. If B and E Then F
4. If B Then C
5. If F Then G

Facts: A is true, B is true

**Goal: Prove G**

- Start with Rule 5, which has G in its THEN part.
- Set a new sub-goal to prove E (the IF part of Rule 2).
- Continue to prove sub-goals until G is proven or backtracking is initiated.

### Exercise: Forward Chaining

**Question 1 (a):**
Run a forward chaining system to determine the health state of a person who eats veal.

**Answer:**
The person is unhealthy. Rules 8, 1, 7 fired.

**Question 1 (b):**
What if you are Catholic, eat poultry, and work 4 hours today? Advise the person on his health situation. Justify your answer.

**Answer:**
The person is healthy. Rules 9, 4, 2, 6 fired.

**Question 2:**
Given rules with conditions and a goal, determine the outcome of the system.

**Answer:**
The system will return "W" as the goal, firing rules 3, 1, 4.

**Question 3:**
Given rules and facts, apply forward chaining to predict the outcome.

**Answer:**
The outcome depends on the specific rules and facts provided.

### Exercise: Backward Chaining

**Question:**
Explain how backward chaining works to prove a goal, using examples.

**Answer:**
- Backward chaining starts with the rule containing the goal.
- It sets up sub-goals to prove the IF part of the rule.
- The knowledge base is searched for rules proving sub-goals.
- The process repeats until the goal is proven or backtracking is initiated.

**Example:**
For the goal G in Rule 5, backward chaining checks rules 4, 2, 3, 1, and backtracks when needed, proving G through the satisfaction of sub-goals.

# Conflict Resolution

## Conflict in Rule Systems

In rule-based systems, conflicts can arise when multiple rules match the current state of the system. Let's consider an example:

```
Rule 1:
IF the traffic-light is green THEN the action is go

Rule 2:
IF the traffic-light is red THEN the action is stop

Rule 3:
IF the traffic-light is red THEN the action is go
```

In this case, both Rule 2 and Rule 3 have the same IF-part, leading to a conflict when the traffic light is red. We need a way to resolve such conflicts and decide which rule to execute.

## Methods for Conflict Resolution

1. **Fire Rule with Highest Priority:**
   - Assign priorities to rules, and the one with the highest priority is selected for execution.

2. **Longest Matching Strategy:**
   - Choose the rule with the longest matching sequence in its IF-part. This strategy provides more specificity.

3. **Most Recently Entered Data:**
   - Select the rule based on the most recently entered or updated data. This approach considers the freshness of information.

## Example of Conflict Resolution

Suppose we have rules:

- Rule 1: IF X is true AND B is true AND E is true THEN Y is true
- Rule 2: IF Y is true AND D is true THEN Z is true
- Rule 3: IF A is true THEN X is true
- Rule 4: IF Y is true AND C is true THEN W is true

Suppose A, B, and E are true. Which rule should the system choose?

- Using the **longest matching strategy**, the system would choose Rule 1 since it has the longest matching sequence.
- If the system uses the **most recently entered data** approach, it would consider the freshness of the data.

## Importance of Conflict Resolution

Conflict resolution is crucial for ensuring the proper functioning of rule-based systems. It helps in making decisions when there are multiple rules that could potentially be applied to a given situation. The choice of conflict resolution method depends on the specific requirements and characteristics of the application.

