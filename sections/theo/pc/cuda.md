# Programming on GPGPU: CUDA Parallel Computing

## Central Processing Unit (CPU)

### Common CPU
- Intel Pentium, the i3, i5, i7, i9, etc. family
- AMD Opteron family

### CPU Functionality
- Allows application software to provide:
  - More functionality
  - Better user interface
- Software developers rely on hardware advances to increase speed

## Multiple Processing Unit

### Definition
- The use of two or more central processing units (CPUs) within a single computer system.
- Refers to the ability of a system to support more than one processor or the ability to allocate tasks between them.

### Using Parallel Programs
- Application software benefits from performance improvement with each new generation of microprocessors.
- Multiple threads execution to complete work faster.

## Multi-core vs Many-core

### Multicore CPU
- Began with two-core processors
- Intel Core i
  - 4 processor cores
  - Implements full x86 instruction set
  - Supports hyperthreading

### Many-core GPU
- NVIDIA GeForce GTX 280 GPU - 240 cores
- Nvidia RTX 3060 Ti - 4864 CUDA Cores

### Throughput Ratio
- GPU vs CPU performance gap: 10:

## GPU vs CPU

- GPUs are specialized processors for graphics rendering and parallel data processing.
- CPUs are general-purpose processors optimized for sequential processing and a wide range of tasks.

### GPU Characteristics
- Highly parallel with numerous processing cores.
- Efficient for tasks that can be parallelized.

### CPU Characteristics
- Excels at tasks requiring sequential processing and complex control flow.

## GPU Technology

### GPU Usage
- Use of Graphics Processing Unit to accelerate general-purpose computing.
- Provides unprecedented performance by offloading compute-intensive portions to GPU.
- Parallel core GPUs + Multi cores = Powerful Heterogeneous Computing

## Heterogeneous Computing

## GPU Architecture

- A GPU consists of a large set of _streaming multiprocessors_ (SMs).
- Each SM is essentially a multicore machine, making the GPU a multi-multiprocessor machine.
- Each SM consists of streaming processors (SPs), individual cores that run threads.
- Threads in different SMs cannot synchronize in the barrier sense, allowing for independence and faster hardware operation.
- Algorithmic chunks can be assigned to different SMs for improved performance.


### Compute Unified Device Architecture (CUDA)

- Software platform for parallel computing on Nvidia GPUs
    - introduced in 2006
    - Nvidia’s repositioning of GPUs as versatile compute devices
- C plus a few simple extensions
    - write a program for one thread
    - instantiate for many parallel threads
    - familiar language; simple data-parallel extensions
- CUDA is a scalable parallel programming model
    - runs on any number of processors without recompiling


### Why CUDA?

- Business rationale
    - opportunity for Nvidia to sell more chips
       - extend the demand from graphics into HPC
    - insurance against uncertain future for discrete GPUs
       - both Intel and AMD integrating GPUs onto microprocessors
- Technical rationale
    - hides GPU architecture behind the programming API
       - programmers never write “directly to the metal”
          - insulate programmers from details of GPU hardware
       - enables Nvidia to change GPU architecture completely, transparently
          - preserve investment in CUDA programs
    - simplifies the programming of multithreaded hardware
       - CUDA automatically manages threads




### GPU Memory Types – Performance

### Comparison

- 1st place: Register Memory
- 2nd place: Shared Memory
- 3rd place: Constant Memory
- 4th: Texture Memory
- Tie for last place: Local

###### Memory and Global Memory

```
Reside on the GPU chip
Reside off-chip.
Local, Constant, and
Texture are all cached
```

### Memory Types

- Shared memory
    - all memory available to all threads – data are accessible simultaneously
    - Drawback: bottleneck
- Register memory
    - A register consumes zero clock cycles per instruction
    - Delays can occur due to read after write dependencies and bank conflicts
    - Drawback: memory shortage. Register pressure can severely detract from the performance
       of the application. Register pressure occurs when there are not enough registers available
       for a given task.
- Local memory
    - Not a physical type of memory, but an abstraction of global memory.
    - Hold automatic variables
    - The compiler makes use of local memory when it determines that there is not enough
       register space to hold the variable.
    - Automatic variables that are large structures or arrays are also typically placed in local
       memory.


### Memory Features

```
Memory type Visibility Existence Performance
Register Only visible to the thread created it Lifetime depending on the
thread lifetime
Fastest
Local Only visible to the thread created it Lifetime depending on the
thread lifetime
Slower than the register
Shared Visible to all threads within the
same block
Lifetime depending on the
block lifetime
N/A
Global Visible to all threads within the
same application
Lifetime depending on the
host lifetime
N/A
```
- Constant memory is used for data that will not change over the course of a kernel execution and is read only.
    - Using constant rather than global memory can reduce the required memory bandwidth - when a warp of
       threads read the same location
- Texture memory is another variety of read-only memory on the device.
    - reduce memory traffic and increase performance compared to global memory


### Programming on Heterogeneous Computing

### Environment


### Simple Processing Flow

##### Copy input data from CPU memory to

##### GPU memory

##### Load GPU code and execute it

##### Copy results from GPU memory to CPU

##### memory


#### Step 1 : Copy input data from CPU memory to GPU

#### memory


### Step 2 : Load GPU code and execute it


### Step 3: Copy results from GPU memory to

### CPU memory


### Program example

- without device code
**Program: Example without device code**
/*NVIDIA compiler (nvcc) can be used to compile
programs with no device code*/
int main(void) {
    printf("Hello World!\n");
    return 0;
}
    Parallel Computing | UNITEN 22
       **nvcc**
       **Example**
       nvcc HelloWorld.cu
          Nvidia Compiler
2021


### Program example

- with device code
**Program: Example 1: mykernel**
/*NVIDIA compiler (nvcc) can be used to compile
programs with device code*/
__global__ void mykernel(void) {
    //in this example, this function did nothing.
    Stay calm.
}
int main(void) {
    mykernel<<<1,1>>>();
    printf("Hello World!\n");
    return 0;
}


### Program example – with device code

- __global__
    - Runs on the device
    - Is called from host code
**- nvcc** separates source code into host and device components
    - Device functions (e.g. mykernel()) processed by NVIDIA compiler
    - Host functions (e.g. main()) processed by standard host compiler
       - gcc, cl.exe
          Parallel Computing | UNITEN 24
             **Example**
             __global__ void mykernel(void) {
             }
2021


### Program example – with device code

- Kernel launcher
- Triple angle brackets mark a call from host code to device code
- **return to the parameters (1,1) in a moment
    Parallel Computing | UNITEN 25
**Example**
mykernel<<<1,1>>>();
2021


### Example 2 : Adding 2 integers

**Program: Example 2: add**
/*Program description: Adding two integers and build up to
vector addition*/
__global__ void add(int *a, int *b, int *c) {
*c = *a + *b;
}
int main(void) {
int a, b, c; // host copies of a,b,c
int *d_a,*d_b,*d_c; //device copies of a,b,c
int size = sizeof(int);
//Allocate space for device copies of a, b, c
cudaMalloc((void **)&d_a, size);
cudaMalloc((void **)&d_b, size);
cudaMalloc((void **)&d_c, size);
// Setup input values
a = 2;
b = 7;
**Program: Example 2: add**
// Copy inputs to device
cudaMemcpy(d_a, &a, size, cudaMemcpyHostToDevice);
cudaMemcpy(d_b, &b, size, cudaMemcpyHostToDevice);
// Launch add() kernel on GPU
add<<<1,1>>>(d_a, d_b, d_c);
// Copy result back to host
cudaMemcpy(&c, d_c, size, cudaMemcpyDeviceToHost);
// Cleanup
cudaFree(d_a); cudaFree(d_b); cudaFree(d_c);
return 0;
}


### Memory Management

- Host and device memory are separate entities
    - Device pointers point to GPU memory
       - May be passed to/from host code
       - May not be dereferenced in host code
    - Host pointers point to CPU memory
       - May be passed to/from device code
       - May not be dereferenced in device code
- Simple CUDA API for handling device memory
    - cudaMalloc(), cudaFree(), cudaMemcpy()
    - Similar to the C equivalents malloc(), free(), memcpy()


### Addition on the Device

- Note that we use pointers for the variables
    __global__ void add(int *a, int *b, int *c) {
       *c = *a + *b;
    }
- add() runs on the device, so a, b and c must point to device memory
- We need to allocate memory on the GPU


# NOW ... TO RUN ON

# PARALLEL


### Moving to Parallel

- GPU computing is about massive parallelism
- So how do we run code in parallel on the device?
    add<<< 1, 1 >>>();
    add<<< N, 1 >>>();
- Instead of executing add() once, execute N times in parallel


### Vector Addition on the Device

- With add() running in parallel we can do vector addition
- Terminology: each parallel invocation of add() is referred to as a block
    - The set of blocks is referred to as a grid
    - Each invocation can refer to its block index using blockIdx.x
__global__ void add(int *a, int *b, int *c) {
c[blockIdx.x] = a[blockIdx.x] + b[blockIdx.x];
}
- By using blockIdx.x to index into the array, each block handles a different index


### Vector Addition on the Device

###### __global__ void add(int *a, int *b, int *c) {

###### c[blockIdx.x] = a[blockIdx.x] + b[blockIdx.x];

###### }

- On the device, each block can execute in parallel:
    Parallel Computing | UNITEN 32
**c[0] = a[0] + b[0]; c[1] = a[1] + b[1]; c[2] = a[2] + b[2];**^ **c[3] = a[3] + b[3];**^
Block 0 Block 1 Block 2^ Block 3^
2021


### Vector Addition on the Device: add()

- Returning to our parallelized add() kernel

###### __global__ void add(int *a, int *b, int *c) {

###### c[blockIdx.x] = a[blockIdx.x] + b[blockIdx.x];

###### }

- Let’s take a look at main()...


### Vector Addition on the Device: main()

Parallel Computing | UNITEN 34
**#define N 512
int main(void) {
int *a, *b, *c;** **_// host copies of a, b, c_**
**int *d_a, *d_b, *d_c;** **_// device copies of a, b, c_**
**int size = N * sizeof(int);**
**_// Alloc space for device copies of a, b, c_**
**cudaMalloc((void **)&d_a, size);
cudaMalloc((void **)&d_b, size);
cudaMalloc((void **)&d_c, size);**
**_// Alloc space for host copies of a, b, c and setup input values_**
**a = (int *)malloc(size); random_ints(a, N);
b = (int *)malloc(size); random_ints(b, N);
c = (int *)malloc(size);**
2021


### Vector Addition on the Device: main()

Parallel Computing | UNITEN 35
**_// Copy inputs to device_**
**cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);
cudaMemcpy(d_b, b, size, cudaMemcpyHostToDevice);**
**_// Launch add() kernel on GPU with N blocks_**
**add<<<N,1>>>(d_a, d_b, d_c);**
**_// Copy result back to host_**
**cudaMemcpy(c, d_c, size, cudaMemcpyDeviceToHost);**
**_// Cleanup_**
**free(a); free(b); free(c);
cudaFree(d_a); cudaFree(d_b); cudaFree(d_c);
return 0;
}**
2021


### Review (1 of 2)

- Difference between host and device
    - Host CPU
    - Device GPU
- Using __global__ to declare a function as device code
    - Executes on the device
    - Called from the host
- Passing parameters from host code to a device function


### Review (2 of 2)

- Basic device memory management
    - cudaMalloc()
    - cudaMemcpy()
    - cudaFree()
- Launching parallel kernels
    - Launch N copies of add() with add<<<N,1>>>(...);
    - Use blockIdx.x to access block index


#### INTRODUCING

#### THREADS

```
Heterogeneous
Computing
Blocks
Threads
Indexing
Shared memory
__syncthreads()
Asynchronous operation
Handling errors
Managing devices
CONCEPTS
```

### CUDA Threads

```
Parallel Computing | UNITEN 39
```
- Terminology: a block can be split into parallel threads
- Let’s change add() to use parallel _threads_ instead of parallel _blocks_
- We use **threadIdx.x** instead of **blockIdx.x**
- Need to make one change in **main()** ...
    **__global__ void add(int *a, int *b, int *c) {**
    **c[threadIdx.x] = a[threadIdx.x] + b[threadIdx.x];**
    **}**
2021


### Vector Addition Using Threads: main()

Parallel Computing | UNITEN 40
**#define N 512
int main(void) {
int *a, *b, *c;** **_// host copies of a, b, c_**
**int *d_a, *d_b, *d_c;** **_// device copies of a, b, c_**
**int size = N * sizeof(int);**
**_//_** **Alloc space for device copies of a, b, c
cudaMalloc((void **)&d_a, size);
cudaMalloc((void **)&d_b, size);
cudaMalloc((void **)&d_c, size);**
**_// Alloc space for host copies of a, b, c and setup input values_**
**a = (int *)malloc(size); random_ints(a, N);
b = (int *)malloc(size); random_ints(b, N);
c = (int *)malloc(size);**
2021


### Vector Addition Using Threads: main()

Parallel Computing | UNITEN 41
**_// Copy inputs to device_**
**cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);
cudaMemcpy(d_b, b, size, cudaMemcpyHostToDevice);**
**_// Launch add() kernel on GPU with N threads_**
**add<<<1,N>>>(d_a, d_b, d_c);**
**_// Copy result back to host_**
**cudaMemcpy(c, d_c, size, cudaMemcpyDeviceToHost);**
**_// Cleanup_**
**free(a); free(b); free(c);
cudaFree(d_a); cudaFree(d_b); cudaFree(d_c);
return 0;
}**
2021


#### COMBINING THREADS

#### AND BLOCKS

```
Heterogeneous
Computing
Blocks
Threads
Indexing
Shared memory
__syncthreads()
Asynchronous operation
Handling errors
Managing devices
CONCEPTS
```

### Combining Blocks and Threads

- We’ve seen parallel vector addition using:
    - Many blocks with one thread each
    - One block with many threads
- Let’s adapt vector addition to use both blocks and threads
- Why? We’ll come to that...
- First let’s discuss data indexing...


0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7

### Indexing Arrays with Blocks and Threads

```
Parallel Computing | UNITEN 44
```
- With M represent the number of threads per block a unique index for

###### each thread is given by:

###### int index = threadIdx.x + blockIdx.x * M;

- No longer as simple as using **blockIdx.x** and **threadIdx.x**
    - Consider indexing an array with one element per thread (8 threads/block)
       **threadIdx.x threadIdx.x**^ **threadIdx.x threadIdx.x**^
**blockIdx.x = 0 blockIdx.x = 1 blockIdx.x = 2 blockIdx.x = 3**
2021


### Indexing Arrays: Example

- Which thread will operate on the red element?
    Parallel Computing | UNITEN 45
**int index = threadIdx.x + blockIdx.x * M;
= 5 + 2 * 8;
= 21;**
0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7
**threadIdx.x = 5
blockIdx.x = 2**
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
**M = 8**
2021


### Vector Addition with Blocks and Threads

```
Parallel Computing | UNITEN 46
```
- What changes need to be made in **main()**?
- Use the built-in variable **blockDim.x** for threads per block
    **int index = threadIdx.x + blockIdx.x * blockDim.x;**
- Combined version of add() to use parallel threads _and_
    parallel blocks
       **__global__ void add(int *a, int *b, int *c) {**
       **int index = threadIdx.x + blockIdx.x * blockDim.x;**
       **c[index] = a[index] + b[index];**
       **}**
2021


### Addition with Blocks and Threads: main()

Parallel Computing | UNITEN 47
**#define N (2048*2048)
#define THREADS_PER_BLOCK 512
int main(void) {
int *a, *b, *c;** **_// host copies of a, b, c_**
**int *d_a, *d_b, *d_c;** **_// device copies of a, b, c_**
**int size = N * sizeof(int);**
**_// Alloc space for device copies of a, b, c_**
**cudaMalloc((void **)&d_a, size);
cudaMalloc((void **)&d_b, size);
cudaMalloc((void **)&d_c, size);**
**_// Alloc space for host copies of a, b, c and setup input values_**
**a = (int *)malloc(size); random_ints(a, N);
b = (int *)malloc(size); random_ints(b, N);
c = (int *)malloc(size);**
2021


### Addition with Blocks and Threads: main()

Parallel Computing | UNITEN 48
**_// Copy inputs to device_**
**cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);
cudaMemcpy(d_b, b, size, cudaMemcpyHostToDevice);**
**_// Launch add() kernel on GPU_**
**add<<<N/THREADS_PER_BLOCK,THREADS_PER_BLOCK>>>(d_a, d_b, d_c);**
**_// Copy result back to host_**
**cudaMemcpy(c, d_c, size, cudaMemcpyDeviceToHost);**
**_// Cleanup_**
**free(a); free(b); free(c);
cudaFree(d_a); cudaFree(d_b); cudaFree(d_c);
return 0;
}**
2021


### Handling Arbitrary Vector Sizes

```
Parallel Computing | UNITEN 49
```
- Update the kernel launch:

###### add<<<(N + M-1) / M,M>>>(d_a, d_b, d_c, N);

- Typical problems are not friendly multiples of **blockDim.x**
- Avoid accessing beyond the end of the arrays:
    **__global__ void add(int *a, int *b, int *c, int n) {**
    **int index = threadIdx.x + blockIdx.x * blockDim.x;**
    **if (index < n)**
    **c[index] = a[index] + b[index];**
    **}**
2021


# SAXPY EXAMPLE

Single-Precision A·X Plus Y


### Why Bother with Threads?

- Threads seem unnecessary
    - They add a level of complexity
    - What do we gain?
- Unlike parallel blocks, threads have mechanisms to:
    - Communicate
    - Synchronize


### Sharing Data Between Threads

- Terminology: within a block, threads share data via shared memory
- Extremely fast on-chip memory, user-managed
- Declare using __shared__, allocated per block
- Data is not visible to threads in other blocks


### __syncthreads()

- void __syncthreads();
- Synchronizes all threads within a block
    - Used to prevent RAW / WAR / WAW hazards
- All threads must reach the barrier
    - In conditional code, the condition must be uniform across the block












### Further Readings & References

- [http://www.nvidia.com/content/gtc-2010/pdfs/2131_gtc2010.pdf](http://www.nvidia.com/content/gtc-2010/pdfs/2131_gtc2010.pdf)
- https://www.microway.com/hpc-tech-tips/gpu-memory-types-perfor

###### mance-comparison/


Copyright © Universiti Tenaga Nasional 2021


