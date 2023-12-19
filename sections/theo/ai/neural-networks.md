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

# Perceptron Learning Algorithm

Frank Rosenblatt (1958, 1962) developed a learning algorithm for a type of single-layer network known as a **perceptron**. The perceptron employs a simple form of supervised learning, adjusting its weights to minimize errors after attempting to solve a problem instance.

## Perceptron (Artificial Neuron)

A perceptron models a neuron, receiving *n inputs*, summing them, and producing an output. It is used for classifying linearly separable classes, often in binary classification scenarios. It consists of input signals (xi), weights (wi), an activation level (Σwixi), a threshold function f, network topology, and a learning algorithm.

### Linearly Separable

Linearly separable indicates that classes of patterns with *n-dimensional vectors* can be separated with a single decision surface.

## Perceptron (cont.)

The perceptron comprises weights, a summation processor, and an activation function. Inputs and connection weights are typically real values. The perceptron produces an output based on the weighted sum of inputs: if Σxiwi ≥ threshold (θ), the output is 1; if Σxiwi < threshold (θ), the output is 0.

## The Role of Weights and Bias

The perceptron may include another input called **bias**, treated as just another input. The bias allows shifting the transfer function curve horizontally along the input axis, while the weights determine the slope.

### Equation of a Straight Line

The equation y = mx + b relates to the perceptron's behavior, with y representing the output, x the input, m the slope (determined by weights), and b the bias.

### Transfer (Activation) Functions

Transfer functions translate input signals to output signals and use a threshold to produce an output. Types include threshold (unit step), sigmoid, piecewise linear, and Gaussian.

### Threshold (Unit Step)

This function sets the output at one of two levels, depending on whether the total input is greater or less than some threshold value.

### Sigmoid

The sigmoid function includes logistic and tangential functions, producing output in the range of 0 to 1 and -1 to +1, respectively.

## The Learning Rate

The learning rate controls how much weights and bias are changed to update the perceptron based on error reduction.

## Perceptron Learns by Adjusting Weights

After attempting to solve a problem instance, the perceptron adjusts its weights to reduce the error. The difference between the desired and actual output values is calculated, and weights are updated to minimize the average error over the entire training set.

## Adjustment

The perceptron adjusts weights based on the difference between desired and actual output values for each component of the input vector. This minimizes the average error over the entire training set, and the perceptron learning procedure learns the correct output for each member of the training set.

### A Perceptron that Learns "AND" and "OR" Concepts

The perceptron can be trained to calculate appropriate weights and thresholds for classifying different classes, forming decision boundaries between classes.

## Linearly Inseparable Problem

The perceptron fails for nonlinear applications, as demonstrated by Minsky and Papert (1969). It cannot solve linearly inseparable problems with a single-layer architecture. An example is the XOR function.

### Neural Network with Hidden Layer(s)

Linearly inseparable problems can be addressed with a neural network that includes hidden layers.

### Backpropagation Learning Algorithm

The backpropagation algorithm starts at the output layer and propagates error backward through hidden layers. It updates weights based on the amount of error, and the process continues until the output is close to the desired response.

## Sigmoid Function

The sigmoid function is continuous, providing non-linearity in the learning model. It is used in neural networks to introduce non-linearity.

### Multi-layer Perceptron (MLP)

To build a nonlinear classifier based on perceptrons, MLP structures are found through experimentation. The backpropagation algorithm adjusts parameters, and hidden layers are essential for complex problem-solving.

### Learning in MLP via the Backpropagation Learning Algorithm

The backpropagation algorithm updates weights by comparing actual and desired outputs. It is an iterative process, and adjustments are made until the network's response is close to the desired response.

## Example

A neural network for training the recognition of digits 0–9 is presented. The input patterns are fed into input units, and adjustments are made to weights based on the discrepancy between desired and actual outputs.

The Perceptron Learning Algorithm and its variations provide a foundation for understanding how artificial neural networks learn from data and adjust their parameters to perform various tasks.