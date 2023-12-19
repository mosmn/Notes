## Neuron

A neuron is a fundamental unit of the nervous system, and its structure and function are crucial to understanding neural networks.

- **Cell Body and Dendrites:**
  - A neuron consists of a cell body and many dendrites.
  - Dendrites handle inputs, receiving signals from other neurons.

- **Axon:**
  - A single branch of the neuron is called an axon.
  - The axon holds the output of the neuron.

- **Information Processing:**
  - The neuron serves as an information processor.
  - Dendrites receive signals, the cell body processes information, and the axon stores and transmits output.

- **Synapses:**
  - Neurons are connected by synapses.
  - Synapses are modeled by adjusting weights and represent the points of contact between neurons.

### Neuron (cont.)

- The human brain is estimated to have around 10 billion neurons, each connected to approximately 10,000 other neurons.
- Neurons receive signals through synapses, controlling the effects of the signal on the neuron.
- Synaptic connections play a key role in the behavior of the brain.

### Neuron (cont.)

- Inspired by this hypothesis, some of the earliest AI work aimed to create artificial neural networks.
- Other names for neural networks in the field include connectionism, parallel distributed processing, and neural computation.

#### Artificial Neural Networks (ANN)

- ANN is a computational system inspired by the structure, processing method, and learning ability of a biological brain.
- It simulates a biological neural network.

### ANN (cont.)

- The model consists of artificial neurons (processing elements or parameters), also called nodes.
- The number of neurons depends on the hardware or software implementation.
- Neurons are interconnected, forming a network that operates in parallel, performing multiple tasks simultaneously.

### Historical Notes

Several key milestones mark the development of neural networks:

- **1943:** McCulloch and Pitts proposed the McCulloch-Pitts neuron model.
- **1949:** Hebb introduced the Hebbian learning rule.
- **1958:** Rosenblatt introduced simple single-layer networks called Perceptrons.
- **1969:** Minsky and Papert demonstrated the limitations of single-layer perceptrons.
- **1980s:** Various network types were developed, such as Hopfield networks and Self-Organizing Feature Maps.
- **1986:** Back-propagation learning algorithm for multi-layer perceptrons was rediscovered, revitalizing the field.
- **1990s:** ART-variant networks, Radial Basis Functions, and Support Vector Machines were developed.

#### What’s Special in a Neural Network?

- Neural networks have a computing architecture based on a large number of relatively simple processors operating in parallel and connected to each other by a link system.
- They model and mimic certain processing capabilities of the human brain.

### How does the ANN model the brain?

- ANN consists of interconnected processors (neurons) that imitate biological neurons in the human brain.
- Neurons are connected by weighted links passing signals from one neuron to another.
- The neurons receive signals, compute an activation level, and produce an output signal through connections.

### Mathematical Functions

#### Artificial Neuron

An artificial neuron consists of input signals (xi), weights (wi), activation level (Σwixi), a threshold function (f), network topology, and a learning algorithm.

### Artificial Neuron (cont.)

- Input signals (xi) may come from the environment or the activation of other neurons.
- Weights (wi) describe connection strengths.
- The activation level is determined by the sum of the weighted inputs (Σwixi).
- The threshold function (f) computes the neuron’s final state based on its activation level.

### Artificial Neuron (cont.)

- The topology of the network is the pattern of connections between individual neurons.
- A learning algorithm adjusts weights and thresholds to improve performance.

### ANN Promises

- Successful implementation areas of ANN include vision, surviving node failures, handling noise well, and serving as a tool for modeling brain function.
- It inherently operates in parallel, executing automatic acquisition tasks when historical data are available.

### ANN Unsolved Problems

- Limitations include difficulty modeling high-level cognitive mechanisms like attention, the vast scale of human brains, and evidence suggesting neurons can grow new connections.

#### An example of the use of ANN

### Other Neural Networks Applications

- **Brain Modeling:**
  - Understanding brain function and aiding in the treatment of brain-damaged patients.
- **Real-world Applications:**
  - Financial modeling, time series prediction, computer games, robotics, pattern recognition, and data analysis.

### Hidden Nodes

### Learning Process in Neural Networks

- Neural networks can learn from their environment through an iterative process of adjusting synaptic weights and thresholds.
- Learning types include unsupervised learning (without help) and supervised learning (with external help).

### Learning Types

- **Unsupervised Learning:**
  - Learning with no external help.
  - Example: A taxi agent developing a concept of “good” and “bad” traffic days.
- **Supervised Learning:**
  - Learning with external help, where inputs and outputs come from a teacher.

The detailed structure and functions of neurons and artificial neural networks contribute to their powerful applications and ongoing research in the field of artificial intelligence.

## Learning Types

### Unsupervised Learning

- **Hebbian Learning**
- **Competitive Learning**
- **Kohonen Network (SOM)**

_Unsupervised learning programs adjust themselves to determine the output without specific targets to match._

### Supervised Learning

- **The Perceptron**
- **Multilayer Neural Networks (using backpropagation learning algorithm)**
- **The Hopfield network**
- **Stochastic network**

_In supervised learning, inputs are provided with expected outputs. The learning algorithm adjusts the network to minimize errors._

### McCulloch-Pitts Neuron Model

- The inputs to a McCulloch−Pitts (1943) neuron are binary (1 or 0).
- Demonstrated that systems of these neurons provide a complete computational model.
- Used to build digital circuitry.

#### McCulloch-Pitts Neuron Model (cont.)

- Simplified behavior of the neuron:

```
I1          I2          I3
  \         |         /
    \       |       /
      \     |     /
        \   |   /
          \ | /
           TO
```

- Each input has an associated weight, influencing the behavior of the node (positive or negative).

#### Example 1

- Inputs: I1=1, I2=0, I3=1
- Weights: W1=1, W2=1, W3=-1

```
SUM = (I1 * W1) + (I2 * W2) + (I3 * W3)
    = (1 * 1) + (0 * 1) + (1 * (-1))
    = 0
```

- Output determined by comparing the sum to the threshold (T).

#### Example 1 (cont.)

- Threshold (T) = 1
- Since the computed sum (0) is less than T, the output is 0.

```
T = 1, O = 0
```

#### Example 2

- Inputs: I1=1, I2=0, I3=1
- Weights: W1=1, W2=-1, W3=1

```
SUM = (I1 * W1) + (I2 * W2) + (I3 * W3)
    = (1 * 1) + (0 * (-1)) + (1 * 1)
    = 2
```

- Output determined by comparing the sum (2) to the threshold (T).

#### Example 2 (cont.)

- Threshold (T) = 1
- Since the computed sum (2) is greater than or equal to T, the output is 1.

```
T = 1, O = 1
```

The McCulloch-Pitts Neuron Model provides a foundational understanding of how neurons compute logical functions, forming the basis for building digital circuitry.



#### Perceptron Learning Algorithm

- Frank Rosenblatt (1958, 1962) devised a

learning algorithm for a type of single layer

network called a **perceptron**.

- The perceptron uses a simple form of

supervised learning.

- After attempting to solve a problem instance, a the
    correct result will be given.
- The perceptron then changes its weights in

order to reduce the error.

- Weights are adjusted by the Perceptron learning
    rule.


#### Perceptron (Artificial Neuron)

- A perceptron **models** a neuron
- It receives **n inputs** , sums those inputs, checks

the result and produces an output.

- It is used to classify **linearly separable classes**.
- Often for **binary classification**
    - Consists of:
       - Input signals, xi
       - Weights, wi
       - Activation level, Σwixi
       - A threshold function f
       - A network topology
       - A learning algorithm


##### Linearly Separable

- Linear separable

refers to the fact

that classes of

patterns with-

dimensional vector

can be separated

with a single decision

surface.


#### Perceptron (cont.)

- The perceptron consists of weights, the

summation processor, and an activation

function.

- The inputs and connection weights are typically

real values.

- A perceptron takes a weighted sum of inputs &

outputs:

if Σxiwi ≥ threshold (θ)  Output = 1

if Σxiwi < threshold (θ)  Output = 0


#### The Role of Weights and Bias

- The perceptron can have another input called **bias**.
- It is normal practice to treat the bias as just another

input.

- The bias allows us to shift the transfer function curve

```
horizontally (left/right) along the input axis while
leaving the shape unaltered.
```
- The weights determine the slope.

X 0

W 0


#### Equation of a Straight Line

y = mx + b

y = how far up

x = how far along

m = slope

b = the y intercept


#### Transfer (Activation) Functions

- The transfer function translates the input

signals to output signals.

- It uses a threshold to produce an output.
- Several types of transfer functions are

threshold (unit step), sigmoid, piecewise linear,

Gaussian.


#### Threshold (Unit Step)

- The output is set at one of two levels,

depending on whether the total input is greater

than or less than some threshold value.


#### Sigmoid

- Consists of 2 functions:
    - Logistic (range from 0 an 1)
    - Tangential (range from -1 to +1)


#### The Learning Rate

- We would like to update the weights and bias in

order to get a smaller error.

- The learning rate helps us control how much we

change the weight and bias.


Perceptron Learns by Adjusting Weights


Perceptron Learns by Adjusting Weights (cont.)


#### Adjustment

- After attempting to solve a problem instance,

the correct result is given.

- The perceptron then changes its weights in

order to reduce the error.

- The difference between the desired output and

the actual output values will be calculated.


#### Adjustment (cont.)

- Therefore for each component of the input vector:
    - If the desired output and actual output values are **equal** ,
       **do nothing**.
    - If the actual output value is **−1 and should be 1** ,
       **increment** the **weights**.
    - If the actual output value is **1 and should be −1** ,
       **decrement** the **weights**.
- This procedure has the effect of producing a set of

```
weights which are intended to minimize the
average error over the entire training set.
```
- If there exists a set of weights which give the correct
    output for every member of the training set, the
    perceptron learning procedure will learn it.


##### A Perceptron that learns “AND”

##### and “OR” concepts (cont.)

```
Train network to calculate the appropriate weights and
thresholds in order to classify correctly the different classes
(i.e. form decision boundaries between classes).
```

##### A Perceptron that learns “AND”

##### and “OR” concepts (cont.)

We can now plot the decision boundaries of our logic gates


#### Linearly Inseparable Problem

- However, the Perceptron does not

```
work for nonlinear applications
as proven by Minsky and Papert
(1969).
```
- In perceptron computation,

```
linearly inseparable problems
cannot be solved by single layer
architecture.
```
- Linear inseparable problem refers to
    the fact that classes of patterns with-
    dimensional vector **cannot** be
    separated with a single decision
    surface.
- Example of linearly inseparable in

perceptron problem solving: **XOR**


Perceptron cannot compute XOR function

-
- +

```
+
Graph of XOR function
```
```
No straight
line(s) can be
drawn to
separate the “+”
and “-”. Try it
out, if you don’t
believe.
```
```
Hidden layers
required!!
```


###### Neural Network with Hidden Layer(s)

```
HIDDEN
NODES
```

###### Backpropagation Learning Algorithm

- The neurons in a multilayer

```
network are connected in
layers, with units in layer n
passing their activations only
to neurons in layer n + 1.
```
- Multilayer signal processing

```
means that errors deep in the
network can spread and
evolve in complex,
unanticipated ways through
successive layers.
```
- Thus, the analysis of the source of error at the output layer is

complex.

- Backpropagation provides an algorithm for apportioning blame and

adjusting weights accordingly.


Backpropagation Learning Algorithm (cont.)

- The approach taken by the

```
backpropagation algorithm is
to start at the output layer
and propagate error
backwards through the hidden
layers.
```
- All the information needed to

```
update the weights on a
neuron was local to that
neuron, except for the
amount of error.
```
- For output nodes, this is easily

```
computed as the difference
between the desired and
actual output values.
```

Formula Backpropagation Learning Algorithm


#### Sigmoid Function

- Is a continuous function
- Also called smooth function
- Why is this f(x) needed?
    - It is a mathematical function that produces a

sigmoid curve (i.e. S shape). It is a special case of a

```
logistic function. It is used in neural network to
introduce non linearity in the learning model.
```
1

f(netj) =

1 + e (- wji. xi + j) / T

--- Sigmoid f(x)

Run over all i


###### Multi-layer Perceptron (MLP)

- To build nonlinear classifier based on Perceptrons.
- Structure of MLP is usually found by

**experimentation.**

- Parameters can be found using **backpropagation.**
- Hidden layers are required.
- What are hidden layers?
    - They are layers additional to the input and output layers,
       not connected externally.
- They are located in between the input and output

layers.


Multi-layer Perceptron (MLP) (cont.)

- How to learn?
    - Cannot simply use Perceptron learning rule because

of hidden layer(s)

- There is a function that we are

###### trying to minimize : error

- Need a different activation function:
    - Use **sigmoid function** instead of threshold function


###### Learning in MLP via the

###### ‘Backpropagation’ Learning Algorithm

- All input patterns P are fed one at a time into the

input units

- Actual response of the output units are compared

with the desired output

- Adjustments are made to the weights in response

```
to discrepancies between the desired & actual
outputs
```
- After all input patterns have been given, the whole

```
process is repeated over & over until the actual
response of the output is tolerably close to the
desired response
```

#### Example

A neural network for

training the recognition of

the digits 0 – 9

How many bars (hence input

```
bits) are required to represent
the digits 0 – 9
```
```
Only 7 bars
are required
to represent
all the 10 digits
```

So, the neural network can could be used

for training will look like this:

```
Answer:
```
```
---------
| |
| |
|--------|
| |
| |
---------
```
* labelling from 0 –9 is also required

```
x x x x x x
```
```
x
```
```
x
```
Sum

```
> 0?
```

#### Summary

- Introduction
- Artificial Neural Networks (ANN)
- Learning Process
- McCulloch-Pitts Neuron Model
- Perceptron Learning Algorithm
- Backpropagation Learning Algorithm