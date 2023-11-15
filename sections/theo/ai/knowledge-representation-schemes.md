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

- Most Expert Systems (ES) are rule-based
    - i.e. the knowledge-base of the ES consists of a huge
       set of production rules (or just “rules”)
- Facts, rules and inference engines are required
    to execute a rule-based expert system
- Production-rules system captures knowledge in
    simple “if-then” format.


# Production Rules (cont.)

- The human mental process is too complex to be
    represented as an algorithm
- However, most experts are capable of
    expressing their knowledge in the form of rules
    for their problem solving
- e.g.
    - **IF** the traffic **-** light is green **THEN** the action is go
    - **IF** the traffic-light is red **THEN** the action is stop


# Production Rules (cont.)

- A production rule model consists of two parts:
    - **the IF part, called antecedent or premise or**
       **condition, and**
    - **the THEN part, called consequent or conclusion or**
       **action**
- In our earlier example:
- **IF** <the traffic **-** light is green> **THEN** <go>
- **IF** <the traffic-light is red> **THEN <** stop>

```
condition
```
```
action
```

# Production Rules (cont.)

- Multiple conditions are joined by the keywords
    AND (conjunction), OR (disjunction) or a
    combination of both.
- Example:

```
IF <condition- 1 >
AND <condition-2>
:
AND <condition-n>
THEN <action>
```
```
IF <condition-1>
OR <condition-2>
:
OR <condition-n>
THEN <action>
```

# Production Rules (cont.)

- Rule-based ES also use mathematical operators
    to define an object as numerical and assign it
    to the numerical value.

```
IF Age of the student < 21
AND SPM no. of A’s >= 8
THEN Admit the student to BIT
```

# Production Rules (cont.)

- Rules can represent relations,
    recommendations, directives and heuristics as
    follows:
Relations:

IF the fuel tank is empty
THEN the car will not start
Recommendation:
IF you study hard
AND you study smart
AND you never absent
THEN you will get an “A”


# Production Rules (cont.)

```
Strategy:
IF the car is dead
THEN check fuel tank
step 1 is complete
IF step 1 is complete
AND the fuel tank is full
THEN check battery
step 2 is complete
IF step 2 is complete
AND the battery is replaced
THEN check electrical fuel lines
:
:
```
Heuristics:

IF the spill is liquid
AND the spill pH is < 6
AND the smell is vinegar
THEN the spill material is acetic acid

```
Directive:
IF the fuel tank is empty
THEN refuel the car
```

# Production Rules (cont.)

```
Advantages
```
- Simple syntax
- Easy to understand
- Simple interpreter
- Flexible (easy to add
    or modify)

```
Disadvantages
```
- Hard to follow
    hierarchies
- Poor at representing
    structured descriptive
    knowledge
- Ineffective search
    strategy
- Not all knowledge can
    be expressed as rules


# Production System Model

```
Production Rules
```
```
Long term memory
Facts
```
```
Short term memory
```
```
Reasoning
```
```
Conclusion
```
_Question: why are the rules as long term memory?_


### Basic Structure of a Production system

```
Production
Rules
```
```
Knowledge-base (KB)
Facts
```
```
Database (DB)
```
```
User
```
```
Inference Engine
```
```
Explanation Facility
```
```
User Interface
```

# “Firing” of Rules

- When the condition part of a rule is satisfied,
    the rule is said to **fire** and the action part is
    executed.
- The inference engine carries out the reasoning
    whereby the expert system reaches a solution.
    It links the rules given in the KB with the facts
    provided in the DB.
- The explanation facility enables the user to ask
    questions such as “why” & “how”.



## Reasoning Methods in Production

## Rule Systems

- The design of the reference engine.
- There are two reasoning methods often use in
    rule-based ES:

#### Forward

#### chaining

- Data-driven

#### reasoning

#### Backward

#### chaining

- Goal-driven

#### reasoning


# Forward Chaining

- This is the data-driven reasoning.
- The reasoning starts from the known fact or
    data and proceeds forward with the data.
- Each time only the topmost rule is executed.
- When fired, the rule adds a new fact in the
    database.
- Any rule can be executed only once.
- The match-fire cycle stops when no further
    rules can be fired.

```
Powerful
mechanism
```

# Forward Chaining (cont.)

- In the simplest sense, in forward chaining, it is
    to:
       - Collect the **rule** in KB whose condition
          **matches** a **fact** in the DB
       - Do actions indicated by the rule
          - Add facts to the database or delete facts from DB
          - Until the problem is solved or no condition match.


# Forward Chaining (Example)

Given a rule-based Expert System with 4 rules:

- Rule 1: If A and C Then F
- Rule 2: If A and E Then G
- Rule 3: If B Then E
- Rule 4: If G Then D
Question: Prove If A and B true, then D is true.

```
Rule 2: If A and E Then GRule 1: If A and C Then F
Rule 3: If B Then E
Rule 4: If G Then D
```
```
KB
A B
```
```
DB
```

# Forward Chaining (Example)

```
Rule 1: If A and C Then FRule 2: If A and E Then G
Rule 3: If B Then E Rule 4: If G Then D
```
```
A B
```
Start at Rule 1 and go forward/down till a rule “fires'' is found.

```
Rule 1: If A and C Then F Rule 2: If A and E Then G
Rule 3: If B Then ERule 4: If G Then D
```
```
A B E G
```
```
Start at Rule 1 and go forward/down till a rule “fires'' is found.
```
- • New knowledge No other rule fires at the end found →E
- of the first iteration.Goal not found
    - • New knowledge No other rule fires at the end found →G
    - of the first iteration.Goal not found

```
Rule 1: If A and C Then FRule 2: If A and E Then G
Rule 3: If B Then E Rule 4: If G Then D
```
```
A B E G D
```
```
Start at Rule 1 and go forward/down till a rule “fires'' is found.
```
- • Goal found Proved →D

```
Question: Prove If A and B true, then D is true.
```

# Forward Chaining (Exercise)

Question 1
Given a ruleon how your health is influenced by certain foods and other factors. -based Expert System with 9 rules whose purpose is to advise you
The rules are:

_R1: IF you eat beef or eggs THEN high cholesterol
R2: IF you eat fish or poultry and no beef THEN low cholesterol
R3: IF you eat no beef and no fish and no poultry THEN low cholesterol
R4: IF you are Catholic and today is Friday THEN you eat no fish and no beef
R5: IF you are a vegetarian THEN you eat no fish, no beef and no poultry
R6: IF low cholesterol THEN healthy
R7: IF high cholesterol THEN unhealthy
R8: IF you eat veal THEN you eat beef
R9: If you work 6 hours or less today THEN it is Friday_


# Forward Chaining (Exercise)

Question 1 (a):
Run a forward chaining system to determine the
health state of a person who eats veal.

```
Final goal: the person is Unhealthy.
Rules that fired are: R8, R1, R7 & Stopped.
```
- _Note: Conditions of other rules are not satisfied_
    _thus they are not executed in the forward chaining_
    _system to conclude the “unhealthy” decision._


# Forward Chaining (Exercise)

Question 1 (b):
What if you are catholic, eat poultry and work 4 hours today? Advise the
person on his health situation. Justify your answer.
_Final Recommendation: The person is_ **_Healthy.
Rules that fired are: R9, R4, R2, R6 & Stopped._**
_Students are required to give reason for why R9 is first fired?
Why was it chained to R4, etc._

- _Also, students need to mention why other rules are not used._
- _An example is given below:_
    - _R1 is not used because no clue on ‘egg’._
    - _R3 is not fired because the person eats poultry. So the condition is false._
    - _R5 is not used since not told that he is a vegetarian._
    - _R8 is not fired since ‘”eat veal” is unknown._


# Forward Chaining (Exercise)

```
Question 2:
```
- Suppose you have the following rules in your Knowledge base:

```
54
```
Rule 1: IF X is true
AND B is true
AND E is true
THEN Y is true

Rule 2: IF Y is true
AND D is true
THEN Z is true

Rule 3: IF A is true
THEN X is true

Rule 4: IF Y is true
AND C is true
THEN W is true

```
Suppose a used. forward chaining (data-driven) system is
What “goal” would the system return if A, B, C, E are
true?
Explain how the result is obtained (e.g. show the reasoning path).
```
```
Answer:The system will return “W” as the goal.
How? By firing R3, R1, and R4. Other rules all failed.
```

# Forward Chaining (Exercise)

Question 3:
Suppose you have the following rules in your Knowledge base. Given **are true** , apply the **forward chaining** to predict the outcome of this system. **A, H and E**
Explain your answer (i.e. the predicted outcome) in terms of the **rules** being fired. **sequence of**

Rule 1: IF A
THEN B
Rule 2: IF (B AND C AND E)
THEN F
Rule 3: IF (B AND H)
THEN C
Rule 4: IF (F AND C)
THEN K


# Backward Chaining

- Backward chaining is the goal-driven reasoning.
- Best applied when we want to find out the
    **reason** once **something** has **occurred**.
- In this reasoning method, the expert system is
    trying to satisfy a goal (i.e. there is a
    hypothetical solution) and the inference engine
    move attempts to find the evidence to prove it.
- If evidences are found, the goal is proved.
- If not, backtracking is initiated.


# Backward Chaining (cont.)

- Thus the inference engine puts the rule it is
    working with (the rule is said to **stack on** ) and
    sets up a **new goal** (i.e. subgoal), to prove the
    IF-part of this rule.
- Then the knowledge base is searched again for
    rules that can prove the **subgoal**.
- The inference engine repeats the process of
    stacking the rules until no rules are found in
    the knowledge base to prove the current
    subgoal.
       Backtracking
          is done here


# Backward Chaining (cont.)

- In the simplest sense, in backward chaining, to
    prove a goal **G** , it is to check:
       - If **G** is a fact then it is proven & stop.
       - Otherwise, find a rule which can be used to
          conclude **G** , and try to prove each of that
          rule’s conditions.
             - In proving G, try to prove each premise
                (preconditions) of the rule that infers G.
             - G is said to be proven (i.e. it is TRUE) if all the
                premises are true (valid/hold).


# Backward Chaining (Example)

```
Rule 1: If A and C Then FRule 2: If A and E Then G
Rule 3: If B Then E Rule 4: If G Then D
```
```
A B
```
Start with Rule 4, contains D as its conclusion

```
Rule 1: If A and C Then F Rule 2: If A and E Then G
Rule 3: If B Then ERule 4: If G Then D
```
```
A B
```
- New sub-goal is G • New sub-goal is E

```
Rule 1: If A and C Then FRule 2: If A and E Then G
Rule 3: If B Then E Rule 4: If G Then D
```
```
A B E
```
- Sub-Goal found →E

```
Question: Prove If A and B true, then D is true.
```
```
Rule 1: If A and C Then F Rule 2: If A and E Then G
Rule 3: If B Then E
Rule 4: If G Then D
```
```
A B E G
```
- Sub-Goal found →G

```
Rule 1: If A and C Then FRule 2: If A and E Then G
Rule 3: If B Then E Rule 4: If G Then D
```
```
A B E G D
```
- Goal found →D


# Backward Chaining (Example)

Rules:

1. IF wake up at 4:00
    THEN pack at 4:30
2. IF pack at 4: 30
    THEN leave home by 5:00
3. IF leave home at 5:00
    THEN park car by 5:15
4. IF park car at 5:15
    THEN check in by 5:30
5. IF check in by 5:30
    THEN catch 6:00 flight

Procedure: Start with the rule that has the goal in its THEN part: _6:00 flight_ (rule 5). Match that rule’s IF part to a preceding rule’s _catch the_

```
THEN part (rule 4). Proceed in this way to arrive at the satisfying premise (the IF part of rule 1):
Wake up at 4:00. 60
```
```
KNOWN GOAL
```

Backward Chaining (Example)
You are given the 5 rules as follows:

RULE 1:IF A AND C THEN E
RULE 2:IF D AND C THEN F
RULE 3:IF B AND E THEN F
RULE 4:IF B THEN C
RULE 5:IF F THEN G

And, you were told that the
following facts are TRUE.

**A** is true
**B** is also true
**Question:**
How many strategies
the KB supports in order to
reach the goal at G?

```
G
F
OR
```
```
AND AND
```
```
C
```
```
D B B
```
```
E
```
```
AND
```
```
A C B
```
```
R5
```
```
R2 R3
```
```
R4
```
```
R1
```
```
Dead end! R4
```

```
62
```
RULE 1: IF A AND C THEN E

RULE 2: IF D AND C THEN F

RULE 3: IF BAND E THEN F

RULE 4: IF B THEN C (True)

### RULE 5: IF F THEN G Step 1

```
Step 2
```
```
Step 3
```
```
Backtracking is done here
```
```
Step 4
```
```
Step 5
```
```
Step 6
```
```
Given that A , B are true
Q2: Is ‘G’ true?
```

# Backward Chaining (Example)

- Will backtracking be needed?
    - Yes.
    - It was done at Rule 3.
    - Reason:
       - Rule 2 failed, and rule 3 is having the same goal (i.e. the
          ‘F’) as rule 2.
       - In this regard, an alternate way is tried out.


```
Explain how does the backward chaining work
in order to prove ‘G’.
```
- The reasoning started from Rule 5. It’s the first rule being fired because this rule contains the ‘G’ as its conclusion. To prove it we have to first show that ‘F’ is true.
    Since goalthe sub-goal (in this case it’s ‘F’) as rule conclusion. So, rule 2 is chosen.-driven reasoning was requested, the next rule will be one that contains
- To prove ‘F’ in rule 2, we need to check whether both of the conditions in the rule are true. Since ‘D’ is false. This rule execution failed. At this point of reasoning,
    backtracking is done to rule 3.
- Rule 3 is now examined since it may also conclude ‘F’. Backward chaining continued by checking the conditions of the rule. Condition ‘B’ is true, but not sure
    about ‘E’.
- To prove ‘E’, the process is repeated by chaining further to rule 1 (since it has ‘E’ as conclusion). Again, ‘E’ is true only if both ‘A’ & ‘C’ are true. ‘A’ is true, and we
    need to find out whether ‘C’ is also true.
- Rule 4 is fired next. Rule 4 succeeded because ‘B’ is true, and this confirms ‘C’. Since ‘C’ is true, via rule 1 ‘E’ is also true. When ‘E’ is true, ‘F’ is also true (in rule
    3).
- Result propagated back to rule 5 (that needed ‘F’ to be true earlier) to conclude ‘G’.


# Summary

- Formal Logic
- Semantic Networks
- Conceptual Graph
- Frames
- Scripts
- Production Rule
- Reasoning Methods in Production Rule Systems



# Conflict Resolution

- Earlier we saw two rules for crossing the road.
    Let’s add another rule to the knowledge base

```
Rule 1:
```
- **IF** the traffic **-** light is green **THEN** the action is go
**Rule 2:**
- **IF** the traffic-light is red **THEN** the action is stop
**Rule 3:**
- **IF** the traffic-light is red **THEN** the action is go

New rule


# Conflict Resolution (cont.)

- Now, we have 2 rules, rule 2 and rule 3, with
    the same IF-part. Thus both of them can be set
    to fire when the condition part is satisfied.
- These rules represent a conflict set.
- The I. E must determine which rule to fire
    from such a set.
- A method for choosing a rule to fire when more
    than one rule can be fired is called conflict
    resolution.


# How do we deal with it?

- In forward chaining, **both** rules would be fired.
- Rule 2 is fired first as the topmost one, as a
    result, its THEN-part is executed. Value **stop** is
    returned.
- However, Rule 3 is also fired because the
    condition part of this rule matches the fact
    ‘traffic light is red’, which is still in the
    database. As a result the object action takes
    new value **go**.


## Methods Used for Conflict

## Resolution

1) Fire rule with highest priority

- Rule that attached with highest probability
    (confident value)
2) Longest matching strategy
- one that will process and provide more information
3) Data that entered most recently
- most updated piece of information


