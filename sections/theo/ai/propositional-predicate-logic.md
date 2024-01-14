# Intro

- Propositional calculus and the predicate calculus are languages.
  - Propositional: P may represent one story
  - Predicate: Individual argument
  - Calculus / Logic: can be used for theorem proving
- Using their words, phrases, and sentences, we can represent and reason about properties and relationships in the world.

## Propositional Calculus vs. Predicate Calculus

- Propositional calculus examples:
  - raining ∨ snowing ⇒ wet
  - p ∨ q ⇒ r
- Predicate calculus examples:
  - loves(tom, Jerry).
  - loves(X, Y).
  - student(x).

## Logic

- Logic is the science of argument evaluation.
- Arguments consist of groups of statements, including premises and a conclusion.
- Premises and conclusions are sentences that claim certain things.
- They can be either true or false.
- Such sentences are called statements.

## Propositional Constants

- T – true
- F – false

## Propositional Variables

- Propositional variables can have values T or F.
- They can be thought of as symbols standing for simple sentences that can be true or false.

## Atomic Propositions

- Atomic propositions cannot be further subdivided.
- They include propositional constants and any propositional variables.
- For example, if A is "She lives in Bangi," A is an atomic proposition.

## Compound Propositions

- Compound propositions are expressions built out of atomic propositions and logical connectives.
- For example, if A is "She lives in Bangi" and B is "She loves Korean food," then A and B is a compound proposition.

## Propositional Calculus Symbols

- The symbols of propositional calculus include:
  - Propositional symbols: P, Q, R, S, …
  - Truth symbols: true, false
  - Connectives: ∧, ∨, ¬, → / ⇒, ⇔ / ≡
- Propositional symbols denote propositions or statements about the world that may be either true or false.

## Sentences in the Propositional Calculus

- Sentences in the propositional calculus are formed from atomic symbols following these rules:
  - Every propositional symbol and truth symbol is a sentence.
  - The negation of a sentence is a sentence.
  - The conjunction (and) of two sentences is a sentence.
  - The disjunction (or) of two sentences is a sentence.
  - The implication of one sentence for another is a sentence.
  - The equivalence of two sentences is a sentence.

## Propositional Calculus Semantics

- **Interpretation of Propositions**: An interpretation of a set of propositions is the assignment of a truth value, either T (true) or F (false), to each propositional symbol.

- **Propositional Symbols Correspond to Statements**: Each proposition symbol corresponds to a statement about the world. For example, P may denote the statement "it is raining," and Q may denote the statement "I live in a brown house."

- **Propositions are Either True or False**: A proposition must be either true or false, depending on the state of the world.

- **Interpretation as Truth Value Assignment**: The truth value assignment to propositional sentences is called an interpretation. It represents an assertion or declaration about the truth of those propositions in a possible world.

- **True and False Symbols**: The symbols "true" always corresponds to T (true), and "false" corresponds to F (false).

- **Formal Definition**: Formally, an interpretation is a mapping from propositional symbols into the set {T, F} for truth value assignment.

- **Mapping to Possible Worlds**: Each possible mapping of truth values onto propositions corresponds to a possible world of interpretation.

- **Example**: If P denotes the proposition "it is raining," and Q denotes "I am at work," then the set of propositions {P, Q} can have four different mappings into the truth values {T, F}. These mappings represent different possible worlds of __interpretation__.


### Truth Value Assignment

- The interpretation or truth value for sentences is determined by the following rules:
  - Negation (¬P): F if P is T, T if P is F.
  - Conjunction (P ∧ Q): T only when both P and Q are T; otherwise, it is F.
  - Disjunction (P ∨ Q): F only when both P and Q are F; otherwise, it is T.
  - Implication (P → Q): F only when P is T and Q is F; otherwise, it is always T.
  - Equivalence (P ↔ Q): T only when P and Q have the same truth assignment for all possible interpretations; otherwise, it is F.

## Compound Sentences

- Compound sentences are expressions composed of statement variables, propositional constants, and logical connectives. They describe relationships between propositions.

- Examples:
  - raining ∨ snowing → wet
  - P ∨ Q
  - (P ∨ ¬Q) ∧ R

| Term | Symbol | Meaning |
| --- | --- | --- |
| Negations | ¬ raining | The argument of a negation is called the target. |
| Conjunctions | raining ∧ snowing | The arguments of a conjunction are called conjuncts. |
| Disjunctions | raining ∨ snowing | The arguments of a disjunction are called disjuncts. |
| Implications | raining → cloudy | The left argument is the antecedent, and the right is the consequent. |
| Reductions | cloudy ← raining | The left argument is the consequent, and the right is the antecedent. |
| Equivalences | raining ↔ cloudy | P ↔ Q is true if P and Q have the same values - both true or both false.

## Rules of Algebraic Manipulation

- Some laws for logic use include:
  - x ∨ y = y ∨ x (Commutativity)
  - x ∧ y = y ∧ x
  - x ∨ (y ∨ z) = (x ∨ y) ∨ z (Associativity)
  - x ∧ (y ∧ z) = (x ∧ y) ∧ z
  - x ∨ (y ∧ z) = (x ∨ y) ∧ (x ∨ z) (Distributivity)
  - x ∧ (y ∨ z) = (x ∧ y) ∨ (x ∧ z)

## Logical Equivalence

- Two sentences are logically equivalent if and only if they logically entail each other. Examples include:
  - ¬(¬p) ≡ p
  - ¬(p ∧ q) ≡ ¬p ∨ ¬q (de Morgan’s law)
  - ¬(p ∨ q) ≡ ¬p ∧ ¬q (de Morgan’s law)
  - (p → q) ≡ ¬p ∨ q

| English | Calculus / Logic | Example |
| --- | --- | --- |
| and, but | AND (Λ) | It is hot and cloudy |
| P: It is hot | Q: It is cloudy | P Λ Q |
| not | NOT (¬) | It is not hot |
| ¬ P |
| or (inclusive) | OR (V) | It is hot or cloudy (or both) |
| P V Q |
| or (exclusive) | P or Q but not both | It is either hot or cloudy (but not both) |
| (P V Q) Λ ¬(P Λ Q) |
| neither… nor | ¬ P Λ ¬ Q | It is neither hot nor cloudy |
| ¬ P Λ ¬ Q |

## Clausal Form
• Propositional resolution works only on expressions in clausal form.
• Fortunately, it is possible to convert any set of propositional calculus sentences into an equivalent set of sentences in clausal form.

### Conversion to Clausal Form
These rules are adapted from Artificial Intelligence, by Elaine Rich and Kevin Knight.
1. Eliminate logical implications (⇒) using the fact that P ⇒ Q is equivalent to ¬P ∨ Q.
   - P ⇒ Q becomes ¬P ∨ Q
   - P ⇐ Q becomes P ∨ ¬Q
   - P ⇔ Q becomes (¬P ∨ Q) ∧ (P ∨ ¬Q)
2. Reduce the scope of each negation to a single term, using the following facts:
   - ¬¬P = P
   - ¬(P ∧ Q) = ¬P ∨ ¬Q
   - ¬(P ∨ Q) = ¬P ∧ ¬Q
   - ¬∀x: P(x) = ∃x: ¬P(x)
   - ¬∃x: P(x) = ∀x: ¬P(x)

# Predicate Calculus/Logic

## Introduction

- In Propositional Calculus, each atomic symbol (P, Q, etc.) denotes a proposition of some complexity.
- In Propositional Calculus, we cannot access the components of an individual assertion, limiting our ability to work with complex statements involving individuals, their properties, and relations.

## The Need for Predicate Calculus

- Consider the following argument:
  1. All birds can fly.
  2. Tweety is a bird.
  3. Therefore, Tweety can fly.
- To make this conclusion, we need to identify individuals like Tweety with their properties and relations (predicates).
- We require a more expressive language, and that's where Predicate Calculus comes in.

## Predicates in Predicate Calculus

- In logic, a predicate has the form:
  - `name_of_predicate(arguments)`
- We use predicates to describe properties and relations in a more detailed way.

## Restructuring Statements with Predicates

- Consider the following statements:
  1. P: Lina is a student.
  2. Q: Lina studies AI.
  3. R: Tina is a student.
  4. S: Lina and Tina are sisters.

- We can rewrite these statements using predicates:
  - `student(Lina)`
  - `studies(Lina, AI)`
  - `student(Tina)`
  - `sisters(Lina, Tina)`

- In these predicate statements, "student," "studies," and "sisters" are the names of relations and properties, i.e., names of predicates.
- The statement `student(Lina)` evaluates to TRUE if Lina is a student and FALSE if she is not.

## Using Variables in Predicate Calculus

- When expressing a property (e.g., being a student) without referring to a specific individual, we use variables:
  - `student(X)`
  - `studies(X, Y)`
  - `sisters(X, Y`

- The expression `student(X)` is not a statement because it doesn't have a predetermined truth value (the truth value depends on the value of X).
- It is called a predicate expression, allowing us to generalize properties and relations to multiple individuals.

## Conditional (→) and Biconditional (⇔) in Predicate Logic

### Conditional (→)

- In predicate logic, the conditional operator (→) represents an implication.
- For two predicates, P(X) and Q(X), P(X) → Q(X) signifies that all elements in the truth set of P(X) are also elements in the truth set of Q(X.
- It can be stated that the truth set of P(X) is a subset of the truth set of Q(X), meaning:
  - All X in the truth set of P(X) belong to the truth set of Q(X).
  
**Example:**

- P(X) = "living in Bangi"
- Q(X) = "living in Selangor"
- P(X) → Q(X) can be written as `living_in_Bangi(X) → living_in_Selangor(X)`.
- This means that all people living in Bangi (the truth set of P(X)) also live in Selangor; they belong to the truth set of Q(X).
- Notably, the truth set of Q(X) is larger than the truth set of P(X) since there are people living in Selangor who do not live in Bangi.

### Biconditional (⇔)

- In predicate logic, the biconditional operator (⇔) represents equivalence.
- For two predicates, P(X) and Q(X), P(X) ⇔ Q(X) indicates that the truth set of P(X) is the same as the truth set of Q(X), meaning they share identical elements.

**Example:**

- P(X) = "being a rectangle with equal sides"
- Q(X) = "being a square"
- In this case, P(X) ⇔ Q(X) can be understood as "a square is a rectangle with equal sides."
- The truth sets of P(X) and Q(X) are the same, which means that a square can be classified as a rectangle with equal sides, as they share identical properties.

## Quantifiers in Predicate Calculus

In Predicate Calculus, there are two ways variables may be used or quantified: Universal quantifiers () and Existential quantifiers (∃).

#### Universal quantifiers ()

- Sentence is true for all constants that can be substituted for the variable under the intended interpretation.
- In English, the quantity "all" can be represented in several ways, such as "for all," "all," "each," or "every."

Example: 
```
∀x P(X) → Q(X)
```
This means, "For all X, if P(X) is true (X is in P), then Q(X) is also true."
- In this example, the first predicate P(X) defines a set of objects (e.g., even numbers), and the second predicate Q(X) states a property for all objects in this set (e.g., integers).

#### Existential quantifiers (∃)

- The expression containing the variable is said to be true for at least one substitution from the domain of definition.
- In English, the existential quantifier can be represented by words like "there is," "we can find," "there is at least one," "for some," "for at least one," or "at least one."

Example: 
```
∃X P(X) Λ Q(X)
```
This means, "There is some X in P with the property Q," i.e., both P(X) is true and Q(X) is true.