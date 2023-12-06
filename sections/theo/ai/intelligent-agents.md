# Intelligent Agent

## Introduction to Agents

An agent, as defined in this chapter, refers to anything capable of perceiving its environment through sensors and acting upon it through actuators. This chapter explores the concept of agents, their classifications, and specifically delves into intelligent agents.

#### Example of Agents

Agents can range from humans with sensory organs and body parts as actuators to robots equipped with cameras and motors. Even a thermostat, sensing room temperature, can be considered an agent.

#### Diagram of Agent

![Agent Diagram](https://miro.medium.com/v2/resize:fit:704/1*a81je9FfLJxfmw20GhRbuw.png)  
*Figure 1: Representation of an Agent*

#### Sensors and Effect

Agents perceive their environment through sensors, generating a percept sequence. These percepts influence the agent's actions through effectors, creating action sequences.

### Agents Classification

Agents can be classified based on their structure. A simple agent program, or agent function, maps percept sequences to possible actions.

### Intelligent Agents

Intelligent agents exhibit fundamental functionalities such as sensing, understanding, reasoning, and learning. They must be rational, autonomous, and capable of perceiving and acting.

### Rational Agents: Components and Decision-Making

Rational agents, defined as entities always striving to do the right thing, employ a set of components and decision-making criteria to maximize their performance measure. The key components include:

1. **Performance Measure:** This serves as the objective criterion for evaluating the success of an agent's behavior. For example, in the context of a vacuum-cleaner agent, the performance measure could encompass parameters such as the amount of dirt cleaned, time taken, electricity consumed, and noise generated.

2. **Percept Sequence:** Agents rely on their perceptual inputs, or percept sequences, to make informed decisions. These sequences provide a historical context and influence the agent's understanding of the environment.

3. **Prior Knowledge:** An agent's prior knowledge of the environment is crucial. This knowledge, combined with percept sequences, guides decision-making by providing context and allowing the agent to learn from past experiences.

4. **Actions:** The available actions an agent can perform constitute a critical component. Rational agents select actions based on a thorough evaluation of the percept sequence, prior knowledge, and the potential impact on the performance measure.

#### Decision-Making Process

The decision-making process of a rational agent involves striving to "do the right thing." This implies selecting actions that maximize the agent's chances of success, as defined by the performance measure. The right action, in this context, is one that aligns with the agent's goals and objectives.

#### Designing Performance Measures

A crucial aspect of rational agents is the design of performance measures. It is recommended to design these measures based on the actual desired outcomes in the environment rather than preconceived notions of how the agent should behave. For instance, in the case of a vacuum-cleaner agent, the performance measure should align with the goal of having a clean floor rather than merely focusing on the amount of dirt cleaned.

rational agents are characterized by their continuous efforts to make decisions that lead to optimal outcomes. By considering performance measures, percept sequences, prior knowledge, and available actions, these agents aim to consistently "do the right thing" and achieve success in their defined tasks.

### Designing agents

In the design of intelligent agents, a systematic approach is crucial to ensure their effectiveness in various task environments. The PEAS framework, encompassing Performance measure, Environment, Actuators, and Sensors, provides a structured method for specifying these components.

#### PEAS Framework Components

1. **Performance Measure:**
   - The criteria used to evaluate the success of the agent's actions.
   - Specifies the desired outcomes or goals the agent aims to achieve.
   - Example: For an automated taxi driver, the performance measure includes a safe, fast, legal, and comfortable trip while maximizing profits.

2. **Environment:**
   - Defines the external context in which the agent operates.
   - Identifies the elements, entities, or conditions that the agent interacts with.
   - Examples:
      - Automated Taxi Driver: Roads, other traffic, pedestrians, and customers.
      - Medical Diagnosis System: Patient, hospital, and staff.
      - Satellite Image Analysis System: Downlink from orbiting satellite.
      - Part-Picking Robot: Conveyor belt with parts and bins.

3. **Actuators:**
   - The mechanisms or tools through which the agent can affect the environment.
   - Represents the physical or virtual actions the agent can perform.
   - Examples:
      - Automated Taxi Driver: Steering wheel, accelerator, brake, signal, horn.
      - Medical Diagnosis System: Screen display for questions, tests, diagnoses, treatments, referrals.
      - Satellite Image Analysis System: Display for categorization of scenes.
      - Part-Picking Robot: Jointed arm and hand.

4. **Sensors:**
   - Instruments or devices that allow the agent to perceive and gather information about the environment.
   - Input sources that provide data for decision-making.
   - Examples:
      - Automated Taxi Driver: Cameras, sonar, speedometer, GPS, odometer, engine sensors, keyboard.
      - Medical Diagnosis System: Keyboard for entry of symptoms, findings, and patient's answers.
      - Satellite Image Analysis System: Color pixel arrays.
      - Part-Picking Robot: Camera, joint angle sensors.

#### Examples of PEAS for Various Systems

1. **Automated Taxi Driver:**
   - Performance Measure: Safe, fast, legal, comfortable trip, maximize profits.
   - Environment: Roads, other traffic, pedestrians, customers.
   - Actuators: Steering wheel, accelerator, brake, signal, horn.
   - Sensors: Cameras, sonar, speedometer, GPS, odometer, engine sensors, keyboard.

2. **Medical Diagnosis System:**
   - Performance Measure: Healthy patient, minimize costs, lawsuits.
   - Environment: Patient, hospital, staff.
   - Actuators: Screen display for questions, tests, diagnoses, treatments, referrals.
   - Sensors: Keyboard for entry of symptoms, findings, and patient's answers.

3. **Satellite Image Analysis System:**
   - Performance Measure: Correct image categorization.
   - Environment: Downlink from orbiting satellite.
   - Actuators: Display for categorization of scenes.
   - Sensors: Color pixel arrays.

4. **Part-Picking Robot:**
   - Performance Measure: Percentage of parts in correct bins.
   - Environment: Conveyor belt with parts, bins.
   - Actuators: Jointed arm and hand.
   - Sensors: Camera, joint angle sensors.

### Classes of Intelligent Agents

Intelligent agents are categorized into five classes based on perceived intelligence and capability:

1. **Simple Reflex Agents:**
   - *Decision-Making Principle:* These agents make decisions based solely on the current percept, without considering the history of percepts.
   - *Example:* A thermostat that turns on the air conditioner when the current temperature exceeds a set threshold. The decision is solely based on the current temperature, and the agent ignores any previous temperature readings.

2. **Model-based Reflex Agents:**
   - *Decision-Making Principle:* These agents can work in partially observable environments, considering not only the current percept but also maintaining an internal model or representation of the world to track situations.
   - *Example:* An automated chess player that not only considers the current state of the chessboard but also maintains a model of potential future moves and their consequences. This allows it to make decisions based on a more comprehensive understanding of the game.

3. **Goal-based Agents:**
   - *Decision-Making Principle:* These agents make decisions by considering their goals and objectives, taking into account the desired states rather than focusing solely on the current percept.
   - *Example:* An autonomous delivery drone with the goal of delivering packages to specific locations. The agent considers its goal (delivery) and plans its actions based on achieving that goal, considering factors like the destination and available routes.

4. **Utility-based Agents:**
   - *Decision-Making Principle:* These agents introduce the concept of utility, where actions are evaluated not just in terms of achieving goals but based on a measure of "goodness" or "usefulness" (utility) at a given state.
   - *Example:* A robot vacuum cleaner that not only aims to clean the maximum amount of dirt (goal) but also considers factors like energy consumption, noise levels, and cleaning efficiency. The agent chooses actions that maximize the overall utility.

5. **Learning Agents:**
   - *Decision-Making Principle:* These agents are capable of learning from past experiences, adapting their behavior over time based on the feedback and outcomes of previous actions.
   - *Example:* An adaptive recommendation system that learns user preferences over time. As users interact with the system, it refines its recommendations based on the users' feedback and historical usage patterns, continuously improving its decision-making capabilities.

### Applications of Intelligent Agents

Intelligent agents find applications as automated online assistants, offering personalized customer service based on individual needs. Their integration into smartphones is anticipated for future developments.