# Resolution and Refutation Proof

**Proof by Resolution & Refutation**

- Resolution is a simple iterative process or procedure for deducing conclusions.
- When resolution is used to prove inconsistency, it is called refutation (refute=disprove).
- In performing resolution to the set of clauses, the negation of the conclusion is also added.
- At each step, two clauses - called the parent clauses from this new set of clauses are compared (resolved), yielding a new clause called the Resolvent.

**Steps:**

1. Construct the conflict set (premises + negation of the conclusion).
2. Convert the conflict set to a set of expressions in clausal form.
3. Repeatedly apply the resolution rule to try to derive a contradiction.
4. If a contradiction is found, then the argument is valid; if not, the argument is invalid.

# Examples

## Example 1:

**Premises:**
- a -> ~b -> ~c
- b
- c -> ~d -> ~e
- e -> f
- d
- ~f

**Conclusion:**
- a

Step | Formula | Derivation
--- | --- | ---
1 | a -> (~b -> ~c) | Given
2 | b | Given
3 | c -> (~d -> ~e) | Given
4 | e -> f | Given
5 | d | Given
6 | ~f | Given
7 | ~a | Negated conclusion
8 | ~b -> ~c | 1, 7
9 | ~c | 8, 2
10 | ~d -> ~e | 3, 9
11 | ~e | 10, 5
12 | f | 4, 11
13 | ~f | 6, 12 (Direct contradiction)

## Example 2:

**Premises:**
- p -> q
- p -> r
- q -> r

**Conclusion:**
- r

Step | Formula | Derivation
--- | --- | ---
1 | p -> q | Given
2 | p -> r | Given
3 | q -> r | Given
4 | ~r | Negated conclusion
5 | q | 1, 4
6 | r | 3, 5
7 | ~r | 2, 6 (Direct contradiction)

## Example 3 (Syllogism):

- Question:
  - Given the following facts & rules:
    - all cats are animals
    - lily is a cat
    - all animals will die
  - Prove that "lily will die."

**Premises:**
- ∀ X. cat(X) -> animal(X)
- cat(lily)
- ∀ X. animal(Y) -> dies(Y)

Step | Formula | Derivation
--- | --- | ---
1 | ~cat(X) -> animal(X) | Given
2 | cat(lily) | Given
3 | ~animal(Y) -> dies(Y) | Given
4 | ~dies(lily) | Negated conclusion
5 | animal(lily) | 1, 2
6 | dies(lily) | 3, 5
7 | ~dies(lily) | 4, 6 (Direct contradiction)

## Example 4:

**Premises:**
- ~D -> A
- D
- ~A -> E

**Conclusion:**
- E

Step | Formula | Derivation
--- | --- | ---
1 | ~D -> A | Given
2 | D | Given
3 | ~A -> E | Given
4 | ~E | Negated conclusion
5 | A | 1, 2
6 | E | 3, 5
7 | ~E | 4, 6 (Direct contradiction)

# Exercise 1:

1. P
2. ~P -> Q
3. ~P -> ~Q -> R

Prove R is TRUE.

# Exercise 2:

1. r
2. t
3. (r -> s) -> t -> s -> w

Prove w is TRUE.

# Automated Reasoning

- Automated Reasoning is arguably the earliest application area of Artificial Intelligence.
- Throughout the history of AI, automated reasoning has played an important role.
- Its products include a large number of inferencing techniques and strategies.

# What is Reasoning?

- Reasoning is the set of processes that enables us to go beyond the information provided.
- Reasoning is the thought process that follows rules of logic.
- We do reasoning in our day-to-day life while drawing conclusions from our knowledge or from information available to us.
- This is a task that humans are good at.

# Automated Reasoning Components

- Three components make up an automated reasoning system:
  - an unambiguous representation language,
  - sound inference rules,
  - and well-defined search strategies.

# Reasoning Categories

- The reasoning process can be classified into two categories:
  - Monotonic Reasoning
  - Non-monotonic Reasoning

## Monotonic vs. Non-monotonic Reasoning

**Monotonic Reasoning:**
- Static logic
- The truth of the statement doesn't change when new information is added.

**Non-monotonic Reasoning:**
- The truth of a statement can change when new information is added.

# Monotonic Reasoning

- In monotonic reasoning, if we enlarge a set of axioms, we cannot retract any existing assertions or axioms.
- Once an assertion is made, it can be considered as an axiom. Throughout the entire process of reasoning, a derived conclusion cannot be disproved.

# Non-Monotonic Reasoning

- Non-monotonic reasoning allows for the removal of conclusions when newly added assertions form contradictions with the set of axioms.
- In real life, non-monotonic reasoning is more common.

# Reasoning Methods

- There are various reasoning methods used for problem-solving in AI.
- Each method is based on a specific type of logic suitable for that method.
- Here we discuss different reasoning methods and the logic used for developing these methods: Deductive, Inductive, Abductive, and Default.

# Deductive Reasoning

- Deductive reasoning allows us to draw conclusions that must hold given a set of premises (facts).
- Deductive reasoning starts with the assertion of a general rule and proceeds to a guaranteed specific conclusion.
- The logic used for deductive reasoning is deductive logic.

# Inductive Reasoning

- Inductive reasoning begins with specific observations and proceeds to a generalized conclusion based on accumulated evidence.
- It moves from specific to general and makes generalizations based on instances.
- Inductive reasoning may not always produce true conclusions.

# Abductive Reasoning

- Abductive reasoning starts with an incomplete set of observations and proceeds to the likeliest possible explanation for the set.
- It's used for making inferences when information is incomplete.
- Abductive reasoning involves forming hypotheses to explain observations.

# Default Reasoning

- Default reasoning is common in non-monotonic reasoning, where conclusions are drawn based on what is most likely to be true.
- It's concerned with making inferences in cases where information is incomplete.
- By default reasoning, we believe any statement unless it is mentioned as