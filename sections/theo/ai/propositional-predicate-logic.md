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

  Propositional Calculus Semantics
• An interpretation of a set of propositions is the
assignment of a truth value, either T or F, to each
propositional symbol.
• A proposition symbol corresponds to a statement
about the world.
– P may denote the statement “it is raining”
– Q may denote the statement “I live in a brown house.”
• A proposition must be either true or false, given
some state of the world.
• The truth value assignment to propositional
sentences is called an interpretation, an assertion
(declaration/statement) about their truth in some
possible world.
• The symbol true is always assigned T, and the
symbol false is assigned F.
• Formally, an interpretation is a mapping from the
propositional symbols into the set {T, F} for truth
value assignment.
• Each possible mapping of truth values onto
propositions corresponds to a possible world of
interpretation.
• For example, if P denotes the proposition “it is
raining” and Q denotes “I am at work,” then the
set of propositions {P, Q} has four different
functional mappings into the truth values {T, F}.