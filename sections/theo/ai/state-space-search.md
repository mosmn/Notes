
# Outline

- State Search Representation
- Search Methods


## Introduction

- We cannot address individual objects in propositional logic. therefore, we use predicate calculus. e.g. sky is blue, we cannot address sky and blue in propositional logic.
- Chapter 3 introduced **predicate calculus** as an example of an AI representation language.
    - we could now adderess:
        - objects
        -  properties of objects
        -  relations between objects
- Well-formed predicate calculus **expressions**
    provide a means of describing objects and
    relations in a problem domain.
- **Inference rules** such as modus ponens allow us
    to infer new knowledge from these
    descriptions.
- These inferences define a **space** that is
    **searched** to **find** a **problem solution**.

- Solution to a problem is always a **fixed**
    **sequence** of actions.
- The intelligent agent can **formulate** a **goal** and
    aim at satisfying it.
       - Goals help organize behavior by limiting the
          objectives.
- To reach a goal state, intelligent agent needs to
    decide what sorts of **actions and states** it
    should consider (e.g.: move, turn).

- The process of looking for a **sequence of**
    **action** s that reaches the **goal** is called **search**.
- A search algorithm takes a problem as input and
    returns a **solution** in the form of an action
    sequence.

- After **formulating a goal** and a problem to
    solve, the agent calls a **search procedure** to
    solve it.
- It then uses the **solution** to guide its actions,
    doing whatever the solution recommends as the
    next thing to do—typically, the first action of
    the sequence—and then removing that step
    from the sequence.



# State Search Representation

- State space representation of a problem
    consists of:
       - an initial state
        - This is the starting point of the problem. It represents the situation or condition at the beginning of the problem-solving process. It's where we begin our exploration.
       - a set of possible actions (operators)
        - These are the actions or operations that can be applied to a state to transform it into another state. Actions are the means by which we move through the problem space.
       - goal state
        - The goal state represents the desired outcome or the solution to the problem. It's the state we are trying to reach through a series of actions.
- State space forms a directed network or graph
    that can be represented as **nodes of a tree**.
- The searching of a goal node is by **traversing**
    the tree’s nodes using some well-established
    **algorithms**.

### Example 1: Navigating a Maze

- **Initial State**: You start at the entrance of a maze.
- **Possible Actions**: You have options to move up, down, left, or right within the maze.
- **Goal State**: The goal is to reach the exit of the maze.

In this example, the state space representation would include all the possible positions you can be in within the maze. The actions are moving in different directions, and the goal state is reaching the exit.

- A **state space** also can be considered as
    consisting of a **collection of points/nodes** , each
    point/node corresponding to a state of a
    problem.
- There will be as many **number of points/nodes**
    in the state space as the **number of different**
    **possible states** of the problem.
- Thus, a state space is the **collection** of **all**
    **possible states** , a **problem** can have.

## State Space

- State space forms a directed network or graph that can be represented as nodes of a tree.
  - The nodes are states.
  - The links between nodes are actions.

### Path

- Any sequence of actions that leads from a state to another state and finally reaches the goal node.

### Path Cost

- Function that assigns a numeric cost to each path.
- The objective is to find the shortest path.

### Goal Test

- Determines whether a given state is a goal state.
- Typically, there is only one goal in the state space problem.

### Classical Search Domains

- Examples of classical search domains:
  - 8-Puzzle
  - Water Jug
  - Blocks World
  - Traveling Salesman
  - Maze
  - Chess
  - Tower of Hanoi
  - And more.

### Example: 8-Puzzle

- Eight tiles can be moved around in nine spaces.
- Initial State: The location of each of the 8-puzzle in one of the nine squares.
- Path cost: Each step costs 1 point; total path cost equals the number of steps taken.
- Goal test: State matches the goal configuration (given board pattern).
- Operators: blank moves Left, Right, Up, and Down.

### Example: Traveling Salesman

- In the traveling salesman problem, a salesperson has to visit several cities and return home.
- The goal is to find the shortest path to travel, visiting each city exactly once, and then returning to the starting city.

Example: Search of the traveling salesperson problem, with each arc marked with the total weight of all paths from the start node to its endpoint.

## Search Trees

- A tree is a graph that:
  - Is connected but becomes disconnected on removing any branch.
  - Has precisely one path between any two nodes.

### Questions to Consider:

- Does our search method actually find a solution?
- Is it a good solution?
  - Path Cost
  - Search Cost (Time and Memory)
- Does it find the optimal solution?
  - But what is optimal?

### Evaluating a Search

We'll evaluate all the search methods using four criteria:

1. **Completeness**
   - Is the strategy guaranteed to find a solution if one exists?
2. **Time Complexity**
   - How long does it take to find a solution?
3. **Space Complexity**
   - How much memory does it take to perform the search?
4. **Optimality**
   - Does the strategy find the optimal solution when there are several solutions?

# Search Methods

- **Complete**
  - All possible solutions are checked.
  - Optimal.
  - Uninformed Algorithms (Blind Search).
- **Partial**
  - Check only some alternatives.
  - Best among alternatives.
  - Informed Algorithms (Heuristics Search).
- **Comparisons stop when all checked.**
- **Comparisons stop when solution is good enough.**
- **Good Enough**
  - Generate improved solutions.
  - Optimal.
- **Stop when no improvement is possible.**

## Types of Search Methods

- Uninformed Algorithms (Blind Search)
- Informed Algorithms (Heuristics Search)
- Optimization

Blind Search:
- **Depth-first**
- **Breadth-first**
- **Bi-directional**
- **Iterative deepening**
- **Depth-limited**
- **Uniform cost**

Heuristic Search:
- **Hill-climbing**
- **Best-first**
- **Generate & test**
- **Induction**
- **Greedy search**

Optimal Search:
- **A* search**

## Search Methods at the First Glance

- **Depth-first**
  - Explores search tree branch by branch.
- **Breadth-first**
  - Examines search tree row by row.
- **Hill-climbing**
  - Depth-first but examines the most promising child node first.
- **Best-first**
  - Expands the most promising partial path discovered so far.
- **A***
  - Combination of Best-first and Branch and bound algorithm.

## Blind Search Methods

- The entire search tree is examined in an orderly manner.
- Can be classified as exhaustive (complete) or partial.
- Sometimes called uninformed search as it has no knowledge about its domain.
- Can only distinguish between a goal state and a non-goal state.
- Two well-known partial methods are:
  - **Depth-first**
  - **Breadth-first**

### Depth-First Search (DFS)

- Begins at the root node and works downward to successively deeper levels.
- Continues until a solution is found or backtracking is forced by reaching a dead end.
- Algorithm:
  - Delete FIRSTNODE from start of STACK.
  - Take children of FIRSTNODE.
  - Add to the front of STACK.
  - Put result in NEWQUEUE.

### Breadth-First Search (BFS)

- Examines all nodes in a search tree, starting with the root node.
- Nodes in each level are examined completely before moving to the next level.
- Algorithm:
  - Take children of FIRSTNODE.
  - Delete FIRSTNODE from start of QUEUE.
  - Append the list of children to the end of QUEUE.
  - Put result in NEWQUEUE.

### DFS vs BFS

**DFS**
- Advantage: More efficient in search state, less memory size.
- Disadvantage: Unable to ensure the closest path, can get stuck in the wrong path.

**BFS**
- Advantage: Ensures the closest path from initial state to goal state, requires more memory.
- Disadvantage: Requires big memory size.

Depending on the data and the goal, either DFS or BFS could be advantageous. DFS may be more efficient in certain scenarios, while BFS ensures the closest path.

## Heuristics Search

- A heuristic is a rule for choosing a branch in a state space search that will most likely lead to a problem solution.
- Heuristics search is designed to reduce the amount of search for a solution based on a rule-of-thumb principle.
- It aims to prune non-promising or inferior nodes, speeding up the search process to obtain a good enough solution.
- Heuristics are used when:
  - There is no exact solution to a problem (e.g., medical diagnosis).
  - There is an exact solution, but computation is prohibitively expensive (e.g., chess).
- Heuristics are fallible and problem-dependent, with multiple alternatives for the same problem.

#### Benefits of Heuristics

- Inherent flexibility.
- Suitable when an optimal/best solution is too costly to generate, providing a good enough answer.
- Simpler for decision-makers (especially managers) to understand.

### Hill-Climbing Search

- Combines depth-first search with a method for ordering alternatives based on the probability of success at each decision point.
- Aims to reach a goal by choosing nodes predicted to be nearest to the goal.
- Quality measurements turn depth-first search into hill-climbing.
- Algorithm:
  - Delete FIRSTNODE from the start of QUEUE.
  - Take children of FIRSTNODE.
  - Order children with the most promising first.
  - Place them at the front of QUEUE.
  - Put the result in NEWQUEUE.

#### Problems with Hill-Climbing

1. Foothill Problem
- Going up to the top of a hill and not advancing further.
- Misses the overall maximum.

2. Plateau Problem
- Issues with multidimensional problem space where there is no hill to climb (flat).
- Gradient equals zero, not informative.

3. Ridges (Points)
- Steep slopes with the search direction not towards the way up (but sideways).

#### Solution to Hill-Climbing

1. **Random Restart Hill-Climbing:**
   - Randomly generates initial states.

2. **Simulated Annealing (Strengthening):**
   - Allows for bad moves as well.
   - The probability of such a move decreases exponentially with its badness.


### Best-First Search

- Best-First Search is a combination of depth-first and breadth-first searches.
- It employs a heuristic evaluation function, making it more flexible than hill-climbing.
- An evaluation function assigns a score to each candidate node.
  - The next move is made by selecting the node with the best value.
- Best-First Search expands the best partial path, which could lead to a "shortsighted" situation.
- It allows switching between paths, gaining the benefits of both depth-first and breadth-first approaches.
  - At each step, the most promising node is chosen, and if one of the chosen nodes generates less promising nodes, another node at the same level can be selected.
- Best-First Search has been used in applications such as games and web crawlers.
- In a web crawler, each web page is treated as a node, and hyperlinks on the page are treated as unvisited successor nodes in the search space.
- The crawler uses an evaluation function that assigns priority to links based on how closely the contents of their parent page resemble the search query.

#### Best-First Search Algorithm:

1. Delete FIRSTNODE from the start of QUEUE.
2. Take children of FIRSTNODE.
3. Append children to QUEUE.
4. Order the result with the most promising first.
5. Put the ordered result in NEWQUEUE.


## Optimal Search

Optimal search aims to produce the best possible answer based on some optimization function. Mathematical functions are utilized for improvements and optimization. One effective method for finding optimal paths with less work is the **branch-and-bound** algorithm.

### Branch and Bound Algorithm

- The algorithm keeps track of all partial paths contending for further consideration.
- The shortest one is extended, creating new partial paths.
- The process repeats until the goal is reached along some path.
- The key is to extend all partial paths until they are as long or longer than the complete path.
- The termination condition is when the shortest partial path is longer than the shortest complete path.

### A* Search

- A* algorithms are admissible, meaning they always produce an optimal solution.
- A* search is a branch-and-bound algorithm combined with an estimate of remaining cost and dynamic programming principles.
- The algorithm uses a heuristic function that satisfies \(h(n) \leq h^*(n)\) for all \(n\) in the state space, making it admissible.

### A* Search Algorithm:

1. Delete FIRSTNODE from the start of QUEUE.
2. Append children of FIRSTNODE.
3. Order the resulting list according to \(cost\text{-}so\text{-}far + \text{underestimate of remaining cost}\).
4. Put the result in NEWQUEUE.

The A* search algorithm continues this process until the goal is found, ensuring an optimal solution.

#### Example

Consider the following example:

- Start (S) with $$ f = g + h = 0 + 7 = 7 $$
- S-A: $$ f = (0 + 1) + 6 = 7 $$
- S-B: $$ f = (0 + 4) + 2 = 6 $$
- S-A-B: $$ f = (1 + 2) + 2 = 5 $$
- S-B-C: $$ f = (4 + 2) + 1 = 7 $$
- S-A-C: $$ f = (1 + 5) + 1 = 7 $$
- S-A-G: $$ f = (1 + 12) + 0 = 13 $$
- S-A-B-C: $$ f = (3 + 2) + 1 = 6 $$
- S-A-B-C-G: $$ f = (5 + 3) + 0 = 8 $$
- S-A-C-G: $$ f = (6 + 3) + 0 = 9 $$
- S-B-C-G: $$ f = (6 + 2) + 0 = 8 $$
- S-A-B-C-G is the optimal solution.

The state with the least \(f(n)\) value is chosen at each step, ensuring optimality.

# Summary

## State Search Representation
- **State space**: A directed network or graph representing possible states in a problem.
- **Nodes**: Represent states in the state space.
- **Actions**: Links between nodes, representing possible transitions between states.
- **Path**: A sequence of actions leading from one state to another.
- **Path cost**: A numeric cost assigned to each path.
- **Goal test**: Determines whether a given state is a goal state.

## Search Methods Properties

| Algorithm       | Complete | Space      | Time       | Optimal    |
| --------------- | -------- | ---------- | ---------- | ---------- |
| Breadth-first   | Yes      | Exponential | Exponential | Yes        |
| Depth-first     | No       | Linear     | Exponential | No         |
| A*              | Yes      | Exponential | Exponential | Yes        |
| Greedy          | No       | Linear     | Exponential | No         |

## Bi-directional Search
- Searches both forward and backward in the same state space simultaneously.
- Stops when the two searches meet in the middle.

## Iterative Deepening
- Tries all possible depth limits and picks the best one.
- Optimal, complete, and uses modest memory.

## Depth-Limited Search
- Similar to DFS but imposes a maximum depth limit on a given path.
- May not be complete or optimal depending on the chosen limit.

## Greedy Search
- Utilizes a heuristic function \(h(n)\) to estimate the path cost left to the goal.
- Aims to minimize the estimated cost to reach the goal.
- Resembles DFS but may not be complete or optimal.
- Can be more efficient with a good heuristic function.
