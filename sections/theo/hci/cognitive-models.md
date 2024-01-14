1. Introduction to Cognitive Models
in HCI
    1.1. Goals & Task Hierarchies
    - Goals vs Tasks
    - Issues for Goal Hierarchies
    1.2. Task Model
    - Introduction to Task
       Analysis
    - Task Decomposition

2. Techniques
    2.1. Goals, Operators, Methods
    and Selection (GOMS)
    - Introduction to GOMS
    - Example of GOMS
    2.2. Hierarchical Task Analysis
    (HTA)
    - Introduction to HTA
    - Example of HTA

# Introduction to Cognitive Models in HCI

Cognitive models represent users of interactive systems

- hierarchical - user’s task and goal structure 
- linguistic – user-system grammar
- physical and device – human motor skills 
- architectural – underlie all of above

Cognitive Models model aspects of user as they interact:
- understanding
- knowledge
- intentions
- processing

Common categorization:
- Competence – represent kinds of behavior expected of user
- Performance – allow analysis of routine behavior in limited applications

Task Analysis:
- A method/set of methods for understanding the tasks users carry out with a product/system
- To analyze the underlying rationale and purpose of what people are doing; what are they trying to achieve, why are they trying to achieve it, and how are they going about it?
- To investigate an existing situation
- Can be used for many different purposes within design and evaluation activities....

Task Analysis in Design Thinking Process:
- important steps in the Design Thinking process that is
    often employed as standard practice in UX design is to
    define the users’ problems.
- What is Design Thinking? Design Thinking is an iterative
    process to understand the user, challenge assumptions,
    and redefine problems in an attempt to identify alternative
    strategies and solutions.
- Task Analysis is a simple exercise that UX designers can
    undertake during the definition of a problem, to identify
    the opportunities to improve user experience

## Goal and Task Hierarchies

Solve goals by solving subgoals
- Mental processing as “divide-and-conquer”

```
produce report
    gather data
        . find book names
            .. do keywords search of names database
                ...further sub-goals
            .. sift through names and abstracts by hand
                ...further sub-goals
        . search sales database
            ..further sub-goals
    layout tables and histograms
        ..further sub-goals
    write description
        ..further sub-goals
```

### Issues for Goal Hierarchies

- Granularity
    - Where do we start?
    - Where do we stop – how far to subdivide?
       - Get down to a routine learned behavior, not problem solving - the unit task
- Conflict
    - More than one way to achieve a goal
- Treatment of error

## Task Analysis

- Key definitions (Norman, 1988):
    - Goal - the state that the human wishes to achieve
    - Task - the activity required in order to bring about the
       state the human wishes to achieve (the goal)

- Task analysis techniques support user-centred design
- Informs us (in detail) as to:
    - how users use existing products
    - how users may interact with future products
- The goals of task analysis vary too, it can be used to:
    - improve current design
    - identify potential problems with new design
    - identify requirements for new design
    - design training materials and manuals
    - develop evaluation plans


### How to Conduct Task Analysis

- According to the UXPA’s Usability Body of Knowledge Site, the process of task
    analysis can be broken down into the following steps:
1. Identify the task to be analyzed: Pick a persona and scenario for your user
    research, and repeat the task analysis process for each one. What is that user’s
    goal and motivation for achieving it?
2. Break this goal (high-level task) down into subtasks: You should have around 4– 8
    subtasks after this process. If you have more, then it means that your identified
    goal is too high-level and possibly too abstract.
3. Draw a layered task diagram of each subtask and ensure it is complete
4. Write the story: A diagram is not enough. Many of the nuances, motivations and
    reasons behind each action are simply lost in the diagram, because all that does is
    to depict the actions and not the reasons behind them. Make sure you
    accompany your diagram with a full narrative that focuses on the whys.
5. Validate your analysis: review the analysis with someone who was not involved in
    the decomposition, but who knows the tasks well enough to check for
    consistency.

# Techniques

- TWO techniques for task models:
    1. Goals, Operators, Methods and Selection (GOMS)
    2. Hierarchical Task Analysis (HTA)
- There are a whole family of GOMS (NGomsl, CPM-
    Goms, KLMs) - most are far from easy to apply and use.
- Whereas HTA is task structure and sequence, GOMS
    represents cognitive structure and sequence.
- Cognitive structure is represented in the concept of
    starting from Goals, not tasks and also from the explicit
    use of selection rules to indicate how methods are
    chosen for the goals.

## Goals, Operators, Methods and Selection (GOMS)

- Goals - what the user wants to achieve
- Operators- basic actions user performs (granularity)
- Methods - decomposition of a goal into sub goals/operators
    - may be more than one way or method to do that
- Selection - means of choosing between competing methods (GOMS attempts to predict)

### GOMS example

```
GOAL: ICONIZE-WINDOW
[select
    GOAL: USE-CLOSE-METHOD
           MOVE-MOUSE-TO-WINDOW-HEADER
           POP-UP-MENU
           CLICK-OVER-CLOSE-OPTION
    GOAL: USE-L7-METHOD
           PRESS-L7-KEY]
```
```
For a particular user Sam:
    Rule 1: Select USE-CLOSE-METHOD unless another rule applies.
    Rule 2: If the application is GAME, select L7-METHOD.
```

### GOMS as A Measure of Performance

- selection rules can be tested for accuracy against user traces
- stacking depth of goal structure can estimate STM requirements
- good for describing how experts perform routine tasks
    - not for comparing across tasks
    - not for predicting training time

## Hierarchical Task Analysis (HTA)

- HTA is a commonly used means of breaking tasks down into a hierarchy of goals, operations (actions) and plans

- It involves breaking a task down into subtasks and then into sub – subtasks

- These are then grouped together as plans that specify how the tasks might be performed in an actual situation

### Procedure for Carrying Out Hierarchical Task Analysis

- The starting point is a user goal, then examined the main tasks
    associated with achieving that goal. Where appropriate, these
    tasks are subdivided into subtasks
- Start with the overall goal (verb-noun pair), e.g. “Use email”,
    “Print a letter”
- Break these down into meaningful subgoals/tasks (asking how
    question)
- Break down subgoalsfurther until reach an appropriate
    stopping point

- Add plans to the analysis - conditional statements, often
    utilisingboolean logic, e.g.
       - DO 1, THEN 2, THEN (IF condition = true) DO 3, ELSE DO 4,
          THEN EXIT
- Represent the goals, subgoals, operations and plans using
    either:
       - graphical views (boxes and arrows)
       - non-graphical methods (e.g. tabulation, outlines,
          textual)

### HTA – Example 1: Make a Cup of Tea

![HTA – Example 1: Make a Cup of Tea](https://web.cs.dal.ca/~jamie/teach/NickGibbins/hta-1.gif)

### HTA – Example 2: Borrow A Book

![HTA – Example 2: Borrow A Book](https://2.bp.blogspot.com/-wNOgA02yLEg/UPZmMNkB-YI/AAAAAAAAAJk/AXpZ4gbUfTk/s1600/HTA_New.PNG)

### HTA – Example 3 - Task analysis to design HTA

![HTA](data:image/png;base64,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)

![HTA](data:image/png;base64,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)
```
To illustrate, Subtask 1.4, “Complete address,” would break
down as follows:
1.Locate the Full Name field.
2.Move the insertion point to the field.
3.Type the full name.
4.Locate the Address Line 1 field.
5.Move the insertion point to the field.
6.Type the address.
7.Optional: Locate the Address Line 2 field.
8.Move the insertion point to the field.
9.Type the address.
10.Locate the Town/City field.
11.Move the insertion point to the field.
12.Type the town or city.
13.Locate the County field.
14.Move the insertion point to the field.
15.Type the county.
16.Locate the Postcode field.
17.Move the insertion point to the field.
18.Type the postal code.
19.Locate the Country field.
20.Move the insertion point to the field.
21.Select the country from the drop-down list.
22.Locate the Phone Number field.
23.Move the insertion point to the field.
24.Type the phone number. 1 - 22
```

### HTA – Textual Representation

- HTA can also be written as a list like this:
0. to clean house
    1. get vacuum cleaner
    2. clean rooms
       - 2.1 clean hall
       - 2.2 clean living rooms
       - 2.3 clean bedrooms etc
    3. empty dust bag
    4. put vacuum cleaner away
    - Plan 0: 
        - do 1,2,4
        - when dust bag full, do 3
    - Plan 2: 
        - do any of 2.1, 2.2, 2.3 in any order depending on which rooms need
    cleaning.

### An Example of HTA For a Microwave Oven

- **What is the overall goal?**
    - “Cook food!”
- **How is this done?**
    - Prepare meal
    - Put meal in oven
    - Select programme
    - Listen for bell to ring
    - Remove meal

- **Selecting a programme - How is this done?**
    - Set to autosensor
    - Set to defrost
    - Set timer to cook
- **What are the rules that influence the order in which**

### Task Analysis – Critical Thinking

- Some requirements that might have ‘emerged’ from carrying out this Task analysis:
    - The need for a distinctive, but not annoying, bell sound 
    - The need for an easily accessible mechanism for opening the door 
    - The need for a highly learnable (guessable) means of selecting a programme

# Summary

- Hierarchical task analysis is a structured, straightforward
    technique that is relatively easy to carry out.
- Hierarchical task analysis supports analysis, design, and
    documentation
- Creating other UX tools such as personas and user
    journeys relies on your having a good understanding of
    the fundamental tasks users need to perform to
    accomplish their goals.
- Constructing a hierarchical task analysis requires that
    you have a good understanding of both a system and its
    users. Thus, hierarchical task analysis provides an
    integrated view of a design space.
- Cognitive models attempt to represent users as they interact with the
    system
- Hierarchical task analysis is a structured, straightforward technique
    that is relatively easy to carry out.
- Hierarchical task analysis supports analysis, design, and
    documentation
- Creating other UX tools such as personas and user journeys relies
    on your having a good understanding of the fundamental tasks users
    need to perform to accomplish their goals.
- Constructing a hierarchical task analysis requires that you have a
    good understanding of both a system and its users. Thus,
    hierarchical task analysis provides an integrated view of a design
    space.