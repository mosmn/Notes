# Introduction

## Role of Knowledge in Demonstrating Intelligent Behavior

- In demonstrating intelligent behavior, knowledge plays a pivotal role.
- Decision makers rely on knowledge to make informed decisions based on environmental observations.
- Knowledge enables understanding of how to act appropriately in various situations.
- Successful action implies the presence of relevant knowledge.
- The field of AI planning and development seeks to create machines that emulate human behavior, emphasizing the importance of knowledge representation.
- To enable machines to exhibit intelligent behavior, knowledge representation is essential.
- Knowledge representation involves logic as a fundamental technique.
- A knowledge base consists of sentences expressed in a specific knowledge representation language.
- Inference, which entails deriving new sentences from existing ones, is a key aspect of knowledge processing.
- The two primary operations include TELL (adding new sentences) and ASK (querying the knowledge base).

## How to Represent Knowledge in a Machine

1. **Domain**:
   - Focus on a specific domain to represent knowledge.
   - Empower the machine with domain-specific knowledge for intelligent behavior.

2. **Inference Mechanism**:
   - Implement a mechanism to interpret environmental facts using knowledge.
   - This interpretation drives appropriate actions, leading to intelligent behavior.

3. **Syntax and Semantics of a Language**:
   - Define clear syntax (grammar and rules) for the language.
   - Ensure that sentences have meaningful semantics (carry meaning).
   - Clarity in syntax and semantics is vital for effective knowledge representation.

# Logic

- Logic formalizes aspects of language, encompassing syntax, semantics, and deduction.
- It serves as a structured representation of knowledge.
- Logic operates at the symbol level, using symbols such as p, q, and r to represent statements or propositions.
- A statement is a sentence with a truth value, typically denoted as true (T) or false (F).
- Propositional logic deals with statements that can be assigned true or false values.
- Logical operators like AND (∧), OR (∨), NOT (¬), IMPLIES (→), and IF AND ONLY IF (↔) are applied to compound propositions.
- Syntax elements include vocabulary (propositional symbols, logical operators), logical constants (TRUE and FALSE), and grouping using parentheses.
- Syntax and semantics must be well-defined to create meaningful knowledge representations.

# Symbol and Sentences

## Sentences and Well-Formed Formulas (wff)

- Each symbol, which can be a proposition or a constant, is a sentence.
- Sentences are also known as well-formed formulas (wff).
- A well-formed formula (wff) can be:
  - A single symbol (e.g., p, True).
  - A compound proposition formed using logical connectives:
    - (~p) is a sentence.
    - p ∧ q is a sentence.
    - p ∨ q is a sentence.
    - ~p is a sentence.
    - p → q is a sentence.
  - Nothing else is considered a sentence.

## Examples of Well-Formed Formulas (wff)

Examples of complex formulas that include logical connectives. The truth value of a wff is known as its semantics or meaning. Some examples of well-formed formulas include:
- p
- True
- p ∧ q
- (p ∨ q) → r
- (p ∧ q) ∨ r → s
- ~ (p ∨ q)
- ~ (p ∨ q) → r ∧ s

## What Does a wff Mean (Semantics)?

- Interpretation in a world.
- When a sentence is interpreted in a world, meaning is assigned to it, and it evaluates as either TRUE or FALSE.
- Different worlds may have different truths; what is true in one world may not be true in another.

## How Do We Get the Meaning?

- Sentences can be compound propositions.
- Interpret each atomic proposition in the same world.
- Assign truth values to each interpretation.
- Compute the truth values of the compound proposition.

## Example

- p: loves (Ben, Angel) - Ben loves Angel.
- q: knows (Julie, Yus) - Julie knows Yus.
- World: Ben and Angel are friends, and Julie and Yus are known to each other.
- p = T, q = T, ∴ p ∧ q = T, p ∧ (~q) = F

## Tautology

- A compound statement that is always TRUE.
- Example: "She loves me OR she loves me not."
- p = She loves me, or, ~p = She loves me not.

## Truth Table for p ∨ ~p

| p | ~p | p ∨ ~p |
|---|---|-------|
| T | F | T     |
| F | T | T     |

### Example: "Heads I win, tails you lose."

- p: If heads, then I win.
- q: If tails, then you lose.

### Truth Table for (p → q) ∨ (~p → q)

| p | ~p | q | p → q | ~p → q | (p → q) ∨ (~p → q) |
|---|----|---|-------|-------|-------------------|
| T | F  | T | T     | T     | T                 |
| T | F  | F | F     | T     | T                 |
| F | T  | T | T     | T     | T                 |
| F | T  | F | T     | F     | T                 |

## Contradiction

- A compound statement that is always FALSE.
- Example: "She loves me AND she loves me not."
- p = She loves me, and, ~p = She loves me not.

### Truth Table for p ∧ ~p

| p | ~p | p ∧ ~p |
|---|---|-------|
| T | F | F     |
| F | T | F     |

# Arguments, Premises, and Conclusions

## Arguments

- Logic can also be defined as the science of argument evaluation.
- Arguments are groups of statements.
- One statement by itself never constitutes an argument.
- Some of those statements, called the premises, claim to be support or reasons for another in the batch.
- Statements that give evidence are called the premises.
- Statements that receive support from the premises on the opposite end of those arrows are called the conclusion.

## Premises

### Statements about Blocks:

1. The red block is on the green block.
2. The green block is somewhere above the blue block.
3. The green block is not on the blue block.
4. The yellow block is on the green or the blue.
5. The blue block is on some other block.

## Conclusions

1. The red block is on the green block.
2. The green block is on the yellow block.
3. The yellow block is on the blue block.
4. The blue block is on the black block.
5. Main Conclusion: The black block is on the table.


Certainly, here's the organized information without omitting any details:

# Logical Reasoning & Inference Rules

## Syllogism / Deductive Reasoning

- **Syllogism** is a kind of logical argument that applies deductive reasoning to arrive at a conclusion based on two or more propositions or premises that are asserted or assumed to be true. It follows a pattern such as:
  - All men are mortal.
  - Socrates is a man.
  - Therefore, Socrates is mortal.
- Another example:
  - All Hondas are Japanese cars.
  - Some Japanese cars are made in America.
  - Therefore, some Hondas are made in America.
- Syllogism is a method of drawing conclusions based on premises.

## Categorical Propositions

Categorical propositions can be categorized into four types:

- **Universal Affirmative:** All P is Q
  - Universal Affirmative example:
    - P: {a, b, c, d}
    - Q: {a, b, c, d, e, f}
- **Universal Negative:** No P is Q
  - Universal Negative example:
    - P: {a, b, c, d}
    - Q: {e, f, g, h}
- **Particular Affirmative:** Some P are Q (at least 1 P is Q)
  - Particular Affirmative examples:
    - P: {a, b, c, d}
    - Q: {c, d, e, f}
    - P: {a, b}
    - Q: {a, b, c, d}
- **Particular Negative:** Some P are not Q (at least 1 P is not Q)
  - Particular Negative examples:
    - P: {a, b, c, d}
    - Q: {c, d, e, f}
    - P: {a, b, c, d}
    - Q: {a, b}

## Rules of Inference

- **Inference Rules:** These rules tell us how one proposition can follow from others.
- A rule of inference is a pattern of reasoning consisting of one set of sentence schemas, called premises, and a second set of sentence schemas, called conclusions.
- Rules of inference include:
  - P → Q
    - P
    - -------
    - Q
  - wet → slippery
    - wet
    - -------
    - slippery
  - p → (q → r)
    - p
    - -------
    - q → r
  - (p → q) → r
    - p → q
    - -------
    - r
- An instance of a rule of inference is a rule in which all meta-variables have been consistently replaced by expressions.
- Sound Rules of Inference:
  - A rule of inference is sound if and only if the premises in any instance of the rule logically entail the conclusions.
- Examples of sound rules of inference:
  - Modus Tollens (MT)
    - P → Q
    - ¬ Q
    - --------
    - ¬ P
  - Modus Ponens (MP)
    - P → Q
    - P
    - --------
    - Q
- The ways that affirm by affirming and the ways that deny by denying are also illustrated.
- A proof is a sequence of sentences terminating in a conclusion, consisting of premises, instances of axiom schema, and results of applying rules of inference to earlier items in the sequence.

# Some other terms