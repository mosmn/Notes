# Resolution and Refutation Proof

## Proof by Resolution & Refutation

- Resolution is a simple **iterative process** or
    procedure for **deducing conclusions**.
- When resolution resolution is used to prove
    inconsistency, it is called **refutation**
    **(refute=disprove)**.
- In performing resolution to the set of clauses, the
    **negation** of the conclusion is also added.
- At each step, **two clauses** - called the **parent**
    **clauses** from this new set of clauses are **compared**
    (resolved), yielding a new clause called the
    **Resolvent**.

## Proof by Resolution & Refutation

- The two clauses to be resolved are chosen in
    such a way that they contain a **common literal**
    appearing as **positive in one** and as **negative in**
    **the other**.
- The resolvent is obtained by combining the two
    clauses by an **_or_** **(**  **)** connective after removing
    the common literal from the parent clauses.


# Steps:

1. Construct the conflict set
    (premises + negation of
    the conclusion).
2. Convert the conflict set to
    a set of expressions in
    **clausal form**.
3. Repeatedly applying the
    **resolution rule** to try to
    derive a contradiction.
4. If a **contradiction** is
    found, then the argument
    is valid; if not, the
    argument is invalid.


# Example

 Premises:
a   b   c
b
c   d   e
e  f
d
 f
 Conclusion:
a

```
Step Formula Derivation
1 a b  c Given
2 b Given
3 c  d e Given
4 e f Given
5 d Given
6 f Given
```
(^7) a Negated conclusion
8 b c 1, 7
9 c 8, 2
10 d e 3, 9
11 e 10, 5
12 f 4, 11
13. 6, 12 (Direct
contradiction)


# Example

 Premises:
p  q
p  r
q  r
 Conclusion:
r

```
8
```
```
Step Formula Derivation
1 p q Given
2  p r Given
3  q r Given
4  r Negated conclusion
5 q r 1, 2
6 q 5, 4
7 r 3, 6
8. 4, 7 (Direct
contradiction)
```
```
Step Formula Derivation
```
(^1) p q Given
2 p r Given
3 q r Given
4  r Negated conclusion
5 q r 1, 2
(^6) p 2, 4
7 q 3, 4
8 r 5, 7
9. 4, 8 (Direct contradiction)


# Example

- Question:
    - Given the following facts &
       rules:
          - all cats are animals
          - lily is a cat
          - all animals will die
    - Prove that “lily will die”

```
all cats are animals
lily is a cat
all animals will die
```
```
(1)  X. cat(X)  animal(X)
(2) cat(lily)
(3)  X. animal(Y)  dies(Y)
```

# Example

Convert (1), (2) & (3) into clausal forms:

Since we can reach a contradicting situation in the proof steps
Therefore, “lily will die” is true (i.e. the given goal is true) 10

```
(1)  X. cat(X)  animal(X)
(2) cat(lily)
(3)  X. animal(Y)  dies(Y)
Step Formula Derivation
1 cat(X)  animal(X) Given
2 cat(lily) Given
3 animal(Y) 
dies(Y)
```
```
Given
```
```
4 dies(lily) Negated conclusion
5 animal(lily) 1, 2
6 dies(lily) 3, 5
7. 4, 6 (Direct contradiction)
```

# Example

 Premises:
 D A
D
A  E
Conclusion:
E

**Step Formula Derivation**
1 D A Given
2 D Given
3 A  E Given
4 E Negated conclusion
5 A 1, 2
6 E 3, 5
7. 4, 6 (Direct contradiction)


# Exercise

#### 1. P

#### 2.  P  Q

#### 3.  P   Q  R

```
Prove R is TRUE.
```

# Exercise

1. r
2. t
3. r  s
4. t  s  w

```
Prove w is TRUE.
```


# Automated Reasoning

- Automated Reasoning is arguably the earliest
    application area of Artificial Intelligence.
- Throughout the history of AI, automated
    reasoning has played an important role.
- Its products include a large number of
    inferencing techniques and strategies.


# What is Reasoning?

- Reasoning is the set of processes that enables
    us to go beyond the information provided
- Reasoning is the thought process that follows
    rules of logic.
- We do reasoning in our day-to-day life while
    drawing conclusions from our knowledge or
    from information available to us.
- This is a task that humans are good at.


## Automated Reasoning Components

- Three components make up an automated
    reasoning system:
       - an unambiguous representation language,
       - sound inference rules,
       - and well defined search strategies.


# Reasoning Categories

- We are able to make approximate predictions
    of reasoning so we should be able to build
    models of reasoning process so that we will be
    able to solve a problem almost in the same way
    as a person does.
- Reasoning is used extensively for problem
    solving in AI.
- The reasoning process can be classified into two
    categories:
       - Monotonic Reasoning
       - Non-monotonic Reasoning


```
Monotonic
VS Non-monotonic Reasoning
```
```
Monotonic Reasoning
```
- Monotonic reasoning
    is static
- In other words the
    truth of the
    statement doesn’t
    change when any
    new information is
    added

```
Non-monotonic
Reasoning
```
- The truth of a
    statement can
    change when a new
    information is added


# Monotonic Reasoning

- In monotonic reasoning if we enlarge at set of
    axioms we cannot retract any existing assertions or
    axioms.
- Once an assertion is made, that can be considered
    as an axiom, i.e. during the process of reasoning, if
    we derive a conclusion, this conclusion **can not be**
    **disproved** throughout the entire process of
    reasoning.
- This **monotonicity property** is **not compatible** to
    our natural ways of thinking.
       _Even though the newer conclusion may be more valid..
Because there is no mechanisms for ‘KB updating’ use..._


# Non-Monotonic Reasoning

- The traditional logic is monotonic, i.e. if we are
    able to draw a conclusion from the set of
    axioms already available, then we will be able
    to draw the same conclusion **after adding some**
    **more** axioms to this set of axioms.
- Using the set of newly added axioms we may be
    able to draw **further conclusions**.
- In real life we frequently deal with non-
    monotonic reasoning.


# Non-Monotonic Reasoning

 In non-monotonic reasoning, an already derived
conclusion may be removed, if necessary, in
case of a newly added assertion forms a
contradiction with the set of axioms.

 We tend to remove a rule (or axiom) from our
memory, whenever we come across a rule that
is contradictory to some rule in the memory.


# Reasoning Methods

 There are various reasoning methods used for
problem solving in AI.

 Each method is based on a specific type of logic
suitable for that method.

 Here we discuss different reasoning methods
and the logic used for developing these
methods.
 **Deductive, Inductive, Abductive and Default**


# Deductive Reasoning

- Deductive reasoning allows us to draw
    conclusions that must hold given a set of
    premises (facts).
- Deductive reasoning starts with the assertion of
    a general rule and proceeds from there to a
    **guaranteed specific conclusion**.
- By deductive reasoning, we make inferences
    about an object based on the information
    available about a class or category to which the
    object belongs.
- The logic used to do deductive reasoning is
    deductive logic. 24


# Deductive Reasoning

###  Example:

### Suppose you are given information that all

### cats have tails

```
 then you may conclude that ‘sweetie” - your
friend’s cat also has a tail even without
seeing sweetie.
```

# Inductive Reasoning

 Inductive reasoning is exactly opposite to that of
deductive reasoning as far as the way of making
inferences is concerned.

 Inductive reasoning begins with observations that
are specific and limited in scope, and proceeds to a
generalized conclusion that is likely, but not
certain, in light of accumulated evidence.

 Inductive reasoning makes generalisation based on
the results available for instances.

 Inductive reasoning moves from the specific to the
general.


# Inductive Reasoning

- Much scientific research is carried out by the
    inductive method: gathering evidence, seeking
    patterns, and forming a hypothesis or theory to
    explain what is seen.
- As a result, conclusions need not be true given
    premises
       - Category-based induction
       - Mental models
- In other words, when we do inductive reasoning, if
    we have information for a few objects then we
    conclude that this information is true for any
    object belonging to a class in which these objects
    belong.


# Inductive Reasoning

- Suppose you arrived in Bangi town that’s new to
    you and on the first day you found a new friend
    who is a vegetarian. This friend introduced you
    to another friend who is also a vegetarian. Next
    day when you went to your work place, you
    were told that your boss is a vegetarian.
- From these, can you conclude that “all people
    in Bangi are vegetarians”? Surely NOT! But
    inductive reasoning will say “YES”.
       - i.e. all people in Bangi are vegetarian


# Induction & Plausible Reasoning

- I have seen 1000 black Perdana.
- I have never seen a Perdana that is not black.
- Therefore, every Perdana is black.
- This conclusion sounds ok... but (still) it is not
    always right


# Abductive Reasoning

- Abductive reasoning typically begins with an
    incomplete set of observations and proceeds to the
    likeliest possible explanation for the set.
- A medical diagnosis is an application of abductive
    reasoning: given this set of symptoms, what is the
    diagnosis that would best explain most of them?
- The method of drawing conclusions using abductive
    reasoning is somewhat similar to the inverse
    process of applying a rule.
- It is about when Q is true, P will be true
    - ...which is missing from the earlier inference rules


# Abductive Reasoning

 Example: Suppose we have the rule

```
 X measles(X)  spots(X)
```
 This axiom says that having measles implies
having spots. While doing abductive reasoning,
if we notice spots, we may conclude measles.

 This conclusion is not valid as per the rules of
logic. However this can be considered as a good
guess when no other information is available. A
measure of certainty can be attached to this
guess to decide the acceptability of the guess.


### Default Reasoning [Raymond Reiter 1980]

- This is a very common form of non-monotonic
    reasoning, where we want to draw conclusions
    based on what is most likely to be true.
- Default reasoning is concerned with making
    inferences in cases where the information at
    hand is incomplete.
- In other words, default reasoning is normally
    done based on the absence of information.


## Default Reasoning

- By default reasoning, we believe any statement
    or axiom unless it is mentioned that the
    statement is false.
       - For example: If Ali is a Professor of Computer
          Science and there is no proof that Ali does not
          possess a PhD then you may believe that Ali has a
          PhD
- Conclusions drawn from these type of rules are
    called defaults.

