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

# Arguments, premises & conclusions
# Logical reasoning & inference rules
# Some other terms