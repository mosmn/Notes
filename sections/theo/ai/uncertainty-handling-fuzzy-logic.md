# Introduction

The world is inherently uncertain, with imprecise measures, definitions, and knowledge. This uncertainty extends to our inferences, where we often draw conclusions from poorly formed and uncertain evidence using unsound inference rules. Despite this, successful decision-making is a common occurrence.

In the field of Expert Systems (ES), we frequently face the challenge of deriving correct conclusions from imperfect and uncertain evidence using unsound inference rules. While this may seem daunting, it is not an impossible task, as evidenced by our ability to navigate various aspects of daily life successfully.

One defining characteristic of information available to human experts is its imperfection. Information is often incomplete, inconsistent, or uncertain. However, humans excel at drawing valid conclusions from such imperfect information.

# Uncertainty

Uncertainty, defined as the lack of exact knowledge to reach a perfectly reliable conclusion, arises from the imperfection of information. This imperfection can manifest as inconsistency, incompleteness, uncertainty, or a combination of these factors. Examples include unknown data or imprecise language.

## Methods to Represent Uncertainty in AI

- **Abductive reasoning**
- **Property inheritance**
- **Fuzzy logic**
- **Certainty Factor (CF)**
- **Bayes theorem**
- **Dempster-Shafer theory**

## Evaluation Criteria for Uncertainty Handling Methods

### Expressive Power

- Must often act despite partial and uncertain information.
  - Example: A patient may misremember when a disease started or may not have noticed a symptom crucial to a diagnosis.

### Logical Correctness

- Correctness depends on data and available knowledge.
  - Example: The correctness of a diagnosis depends on various factors, including the conditions that might have caused a false positive and the proper execution of tests.

### Computational Efficiency of Inference

- Take advantage of conditional (rule) independence specified in Knowledge Bases (KB) and find ways to create new facts without explicit calculation of the entire KB.
  - Example: Efficiently utilizing partial and uncertain information without having to calculate the entire knowledge base explicitly.


# Scheme used by ES in Handling Uncertainty

## Fuzzy Logic

- **REVEAL**: Uses Fuzzy Logic.
- **MYCIN**: Utilizes Certainty Factor (CF) to rank hypotheses and prioritize investigations based on symptom relevance.
- **PROSPECTOR**: Applies Bayes Theorem for uncertainty management.

# Fuzzy Logic

## Introduction

- Introduced by Lofti Zadeh in 1965.
- A powerful problem-solving methodology.
- Deals with uncertainty and ambiguous criteria or values.
- Examples of imprecise concepts: "the weather outside is cold," where the definition of 'cold' varies from person to person.

## Characteristics of Fuzzy Logic

- Fuzzy logic describes fuzziness, using sets that calibrate vagueness.
- Fuzzy sets have fuzzy boundaries, representing degrees or scales in various attributes like temperature, height, speed, etc.
- Acceptable as experts rely on common sense in problem-solving.

## History of Fuzzy Logic

- **1965**: Fuzzy Sets (Lofti Zadeh seminar).
- **1966**: Fuzzy Logic (P. Marinos, Bell Labs).
- **1972**: Fuzzy Measure (M. Sugeno, TIT).
- **1974**: Fuzzy Logic Control (E.H. Mamdani).
- **1980**: Control of Cement Kiln (F.L. Smidt, Denmark).
- **1987**: Sendai Subway Train Experiment (Hitachi).
- **1988**: Stock Trading Expert System (Yamaichi).
- **1989**: LIFE (Lab for International Fuzzy Eng).

## Embedding Fuzzy Logic in Control Systems

- Implemented in the subway in Sendai, Japan.
- Fuzzy control system manages the train's acceleration, deceleration, and braking.
- Passengers hardly notice velocity changes.
- Proven superiority over human and conventional controllers.
- Reduced energy consumption by 10%.
- Enthusiastically received in Japan.

## Example: Natural Language and Fuzzy Logic

- Most natural language contains vague and imprecise concepts.
- Examples: "He is quite tall," "The student is intelligent," "Today is a very hot day."
- Difficult to translate into more precise language.
- Fuzzy logic helps design systems capable of human-like reasoning for understanding vague terms.

## Fuzzy Logic Representation

- Fuzzy logic represents vague language naturally.
- Enriches but does not replace crisp sets.
- Allows flexible engineering design.
- Improves model performance (e.g., saves power consumption, increases lifespan).
- Implements in a simple way and often works effectively.

## Fuzzy Rule

- A fuzzy rule is a conditional statement in the form: "If x is A, then y is B."
- x and y are linguistic variables, and A and B are linguistic values determined by fuzzy sets.
- Rules guide decision-making based on fuzzy conditions.

## Fuzzy Decision Making in Various Applications

### Medicine

- Handles imprecision and uncertainty in medical diagnosis.
- Models consider the relative importance of symptoms, varied patterns in different disease stages, relations between diseases, and stages of hypothesis formation.

### Information System

- Benefits information retrieval and database management.
- Allows expression of soft requests for ordering items based on varying degrees of satisfaction.
- Accommodates imprecise, uncertain, or vague information in the database.

## Certainty Factor (CF)

- Used in MYCIN to rank hypotheses.
- CF values range from -1 to 1, representing degrees of certainty:
  - Definitely not (-1.0)
  - Almost certainly not (-0.8)
  - Probably not (-0.6)
  - Maybe not (-0.4)
  - Unknown (-0.2 to +0.2)
  - Maybe (+0.4)
  - Probably (+0.6)
  - Almost certainly (+0.8)
  - Definitely (+1.0).

- Care must be taken when using terms like "may be" as it represents only 40% certainty.

## Relationships between Uncertainty Terms and Certainty Factor (CF)

### Certainty Factor (CF)

- When constructing the rule base, experts assign a CF to each rule, reflecting their confidence in the rule's reliability.
- CF measures the confidence placed in a conclusion based on known evidence.
- The Certainty Factor is calculated as the difference between the Measure of Belief (MB) and the Measure of Disbelief (MD): 
  \[ CF = MB[h,e] - MD[h,e] \]
  - A positive CF means the evidence supports the hypothesis.

### Certainty Factor Computation

\[ CF[H,E] = MB[H,E] – MD[H,E] \]

- **H:** Hypothesis
- **E:** Evidence
- **MB (Measure of Belief):** Computes the belief in the hypothesis.
- **MD (Measure of Disbelief):** Computes the chances of not believing the achievement of the goal.
  
If \( MB > MD \), then the evidence supports the goal.

### More Equations for CF Computation

1. \[ MB(P1 \, \text{AND} \, P2) = \text{MIN} (MB(P1), MB(P2)) \]
2. \[ MB(P1 \, \text{OR} \, P2) = \text{MAX} (MB(P1), MB(P2)) \]
3. \[ MB(\text{NOT} \, P1) = 1 - MB(P1) \]

- Each rule can have a credibility (attenuation) indicating its reliability.
- Credibility is multiplied by the MB for the rule conclusion:
  \[ MB(\text{Conclusion}) = MB(\text{conditions}) \times \text{credibility} \]
- Combining MB for multiple conditions in a rule:
  \[ MB[h:e1,e2] = MB[h:e1] + MB[h:e2] \times (1 - MB[h:e1]) \]

### Advantages of CF

- A simple computational model allowing experts to estimate their confidence in conclusions.
- Permits expressions of belief and disbelief in each hypothesis, accommodating multiple sources of evidence.
- Gathering CF values is easier than in other methods.

### Example

#### Rule Base:
1. IF X drives a Proton AND X reads the Berita Harian THEN X will vote Barisan Nasional
2. IF X loves the Setia song OR X supports Vision 2020 THEN X will vote Barisan Nasional
3. IF X uses unleaded petrol OR X does not support Vision 2020 THEN X will not vote Barisan Nasional

#### MB for Conditions:
- MB(X drives a Myvi car) = 0.9
- MB(X reads the Utusan Malaysia) = 0.7
- MB(X loves the 1Malaysia song) = 0.8
- MB(X supports Vision 2020) = 0.6
- MB(X uses unleaded petrol) = 0.7

#### Credibility of Rules:
- Rule 1: 0.7
- Rule 2: 0.8
- Rule 3: 0.6

#### CF Calculation:
\[ MB[X \text{ votes BN: Rule 1, Rule 2, Rule 3}] = 0.4 \]

### Summary

1. Introduction
2. Fuzzy Logic
3. Certainty Factor (CF)

#### Combining Fuzzy Rules & Truth Values & Resolution Proof

- Steps:
  1. Convert facts and rules to clausal forms.
  2. Negate the goal for resolution & refutation proof.
  3. Check fuzzy rules for Truth Values < 0.5, invert clauses, and compute new TV.
  4. Apply resolution proof to reach NIL (contradiction).
  5. Each resolution combines clauses with the minimum of their TVs.

### Bayes Theorem

- Bayesian approach based on formal probability theory.
- Computes the probability of a hypothesis given evidence.
- Requires reliable statistical data for prior probabilities.
- Criticized for data requirements and assumptions.

### Dempster-Shafer Theory

- Introduced by Arthur Shafer in 1967.
- Mathematical theory of evidence assigning values between 0 and 1 as degrees of support.
- More general than Bayesian method, allowing belief and disbelief to both be zero.
- Belief function measures the likelihood that evidence supports a proposition.


