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


• The interpretation or truth value for sentences
is determined by:
13
The truth assignment of negation,
￢ P, where P is any propositional
symbol, is F if the assignment to P is T, and T if the assignment to P is F.
The truth assignment of conjunction, , is T only when both conjuncts
have truth value T; otherwise it is F.
The truth assignment of disjunction, , is F only when both disjuncts have
truth value F; otherwise it is T.
The truth assignment of implication, , is F only when the premise or
symbol before the implication is T and the truth value of the consequent
or symbol after the implication is F; otherwise it is always T.
The truth assignment of equivalence, =, is T only when both expressions
have the same truth assignment for all possible interpretations;
otherwise it is F.

• The truth assignments of compound
propositions are often described by truth
tables.
• A truth table lists all possible truth value
assignments to the atomic propositions of an
expression and gives the truth value of the
expression for each assignment.
• Thus, a truth table enumerates all possible
worlds of interpretation that may be given to
an expression.