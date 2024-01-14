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


# Compute Unified Device Architecture (CUDA)

## Introduction
- CUDA is a software platform for parallel computing on Nvidia GPUs, introduced in 2006.
- It represents Nvidia's effort to position GPUs as versatile compute devices, not just for graphics rendering.

## CUDA Programming Model
- Based on the C programming language with a few simple extensions.
- Programmers write a program for one thread and instantiate it for many parallel threads.
- Provides a familiar language with simple data-parallel extensions.

## Scalability
- CUDA is a scalable parallel programming model.
- It can run on any number of processors without the need for recompiling the code.

## Why CUDA?

### Business Rationale
- Nvidia saw an opportunity to sell more chips by extending demand from graphics into High-Performance Computing (HPC).
- Served as insurance against an uncertain future for discrete GPUs, given Intel and AMD's integration of GPUs onto microprocessors.

### Technical Rationale
- Hides GPU architecture behind the programming API, ensuring programmers never write "directly to the metal."
- This insulation from hardware details allows Nvidia to change GPU architecture completely and transparently, preserving investment in CUDA programs.
- Simplifies the programming of multithreaded hardware, as CUDA automatically manages threads.

## GPU Memory Types – Performance Comparison

1. Register Memory
2. Shared Memory
3. Constant Memory
4. Texture Memory
5. Local Memory

### Memory Types Overview
- Shared Memory: Accessible to all threads simultaneously, but can become a bottleneck.
- Register Memory: Consumes zero clock cycles per instruction but may face delays due to dependencies and conflicts.
- Local Memory: An abstraction of global memory, holding automatic variables when register space is insufficient.

### Memory Features
| Memory Type | Visibility | Existence | Performance |
|-------------|------------|-----------|-------------|
| Register    | Thread     | Thread    | Fastest     |
| Local       | Thread     | Thread    | Slower than register |
| Shared      | Block      | Block     | N/A         |
| Global      | Application | Host      | N/A         |

- Constant Memory: Used for read-only data that won't change during kernel execution, reducing memory bandwidth.
- Texture Memory: Another form of read-only memory, enhancing performance compared to global memory.

## Programming on Heterogeneous Computing Environment

### Simple Processing Flow
1. Copy input data from CPU memory to GPU memory.
2. Load GPU code and execute it.
3. Copy results from GPU memory to CPU memory.

### Program Examples

#### Example without Device Code
```C
int main(void) {
    printf("Hello World!\n");
    return 0;
}
```
Compiled using nvcc: `nvcc HelloWorld.cu`

#### Example with Device Code
```C
__global__ void mykernel(void) {
    // In this example, this function does nothing.
    // Stay calm.
}

int main(void) {
    mykernel<<<1,1>>>();
    printf("Hello World!\n");
    return 0;
}
```

### Example 2: Adding 2 Integers
```C
__global__ void add(int *a, int *b, int *c) {
    *c = *a + *b;
}

int main(void) {
    // Host copies of a, b, c
    int a, b, c;
    
    // Device copies of a, b, c
    int *d_a, *d_b, *d_c;
    
    // Allocate space for device copies of a, b, c
    cudaMalloc((void **)&d_a, size);
    cudaMalloc((void **)&d_b, size);
    cudaMalloc((void **)&d_c, size);
    
    // Setup input values
    a = 2;
    b = 7;

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
```


# Memory Management

## Host and Device Memory

- Host and device memory are separate entities.
  - Device pointers point to GPU memory.
    - May be passed to/from host code.
    - May not be dereferenced in host code.
  - Host pointers point to CPU memory.
    - May be passed to/from device code.
    - May not be dereferenced in device code.

- Simple CUDA API for handling device memory.
  - `cudaMalloc()`, `cudaFree()`, `cudaMemcpy()`.
  - Similar to the C equivalents `malloc()`, `free()`, `memcpy()`.

## Addition on the Device

- Note that we use pointers for the variables.

```C
__global__ void add(int *a, int *b, int *c) {
   *c = *a + *b;
}
```

- `add()` runs on the device, so `a`, `b`, and `c` must point to device memory.
- We need to allocate memory on the GPU:
    
    ```C
    int *d_a, *d_b, *d_c;
    cudaMalloc((void **)&d_a, size);
    cudaMalloc((void **)&d_b, size);
    cudaMalloc((void **)&d_c, size);
    ```


# Moving to Parallel

- GPU computing is about massive parallelism.
- Code can be run in parallel on the device.
  - `add<<< 1, 1 >>>();`
  - `add<<< N, 1 >>>();`
- Instead of executing `add()` once, execute N times in parallel.

## Vector Addition on the Device

- With `add()` running in parallel, we can do vector addition.
- Terminology:
  - Each parallel invocation of `add()` is referred to as a block.
  - The set of blocks is referred to as a grid.
  - Each invocation can refer to its block index using `blockIdx.x`.

```C
__global__ void add(int *a, int *b, int *c) {
   c[blockIdx.x] = a[blockIdx.x] + b[blockIdx.x];
}
```

- By using `blockIdx.x` to index into the array, each block handles a different index.

## Vector Addition on the Device

```C
__global__ void add(int *a, int *b, int *c) {
   c[blockIdx.x] = a[blockIdx.x] + b[blockIdx.x];
}
```

- On the device, each block can execute in parallel:

```
c[0] = a[0] + b[0]; c[1] = a[1] + b[1]; c[2] = a[2] + b[2]; c[3] = a[3] + b[3];
```

## Vector Addition on the Device: add()

- Returning to our parallelized `add()` kernel.

```C
__global__ void add(int *a, int *b, int *c) {
   c[blockIdx.x] = a[blockIdx.x] + b[blockIdx.x];
}
```

- Let’s take a look at `main()`...

## Vector Addition on the Device: main()

```C
#define N 512
int main(void) {
   int *a, *b, *c; // host copies of a, b, c
   int *d_a, *d_b, *d_c; // device copies of a, b, c
   int size = N * sizeof(int);

   // Alloc space for device copies of a, b, c
   cudaMalloc((void **)&d_a, size);
   cudaMalloc((void **)&d_b, size);
   cudaMalloc((void **)&d_c, size);

   // Alloc space for host copies of a, b, c and setup input values
   a = (int *)malloc(size); random_ints(a, N);
   b = (int *)malloc(size); random_ints(b, N);
   c = (int *)malloc(size);
```

## Vector Addition on the Device: main()

```C
   // Copy inputs to device
   cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);
   cudaMemcpy(d_b, b, size, cudaMemcpyHostToDevice);

   // Launch add() kernel on GPU with N blocks
   add<<<N,1>>>(d_a, d_b, d_c);

   // Copy result back to host
   cudaMemcpy(c, d_c, size, cudaMemcpyDeviceToHost);

   // Cleanup
   free(a); free(b); free(c);
   cudaFree(d_a); cudaFree(d_b); cudaFree(d_c);
   return 0;
}
```

## Review (1 of 2)

- Difference between host and device.
  - Host CPU.
  - Device GPU.
- Using `__global__` to declare a function as device code.
  - Executes on the device.
  - Called from the host.
- Passing parameters from host code to a device function.

## Review (2 of 2)

- Basic device memory management.
  - `cudaMalloc()`.
  - `cudaMemcpy()`.
  - `cudaFree()`.
- Launching parallel kernels.
  - Launch N copies of `add()` with `add<<<N,1>>>(...)`.
  - Use `blockIdx.x` to access block index.


# Introducing Threads

## CUDA Threads

- Terminology: a block can be split into parallel threads.
- Change `add()` to use parallel threads instead of parallel blocks.
- Use `threadIdx.x` instead of `blockIdx.x`.

```C
__global__ void add(int *a, int *b, int *c) {
   c[threadIdx.x] = a[threadIdx.x] + b[threadIdx.x];
}
```

### Vector Addition Using Threads: main()

```C
#define N 512
int main(void) {
   int *a, *b, *c; // host copies of a, b, c
   int *d_a, *d_b, *d_c; // device copies of a, b, c
   int size = N * sizeof(int);

   // Alloc space for device copies of a, b, c
   cudaMalloc((void **)&d_a, size);
   cudaMalloc((void **)&d_b, size);
   cudaMalloc((void **)&d_c, size);

   // Alloc space for host copies of a, b, c and setup input values
   a = (int *)malloc(size); random_ints(a, N);
   b = (int *)malloc(size); random_ints(b, N);
   c = (int *)malloc(size);
```

### Vector Addition Using Threads: main()

```C
   // Copy inputs to device
   cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);
   cudaMemcpy(d_b, b, size, cudaMemcpyHostToDevice);

   // Launch add() kernel on GPU with N threads
   add<<<1,N>>>(d_a, d_b, d_c);

   // Copy result back to host
   cudaMemcpy(c, d_c, size, cudaMemcpyDeviceToHost);

   // Cleanup
   free(a); free(b); free(c);
   cudaFree(d_a); cudaFree(d_b); cudaFree(d_c);
   return 0;
}
```

# Combining Threads and Blocks

## Combining Blocks and Threads

- Adapt vector addition to use both blocks and threads.
- Use `blockDim.x` for threads per block.
- Use `blockIdx.x` for the block index.

```C
__global__ void add(int *a, int *b, int *c) {
   int index = threadIdx.x + blockIdx.x * blockDim.x;
   c[index] = a[index] + b[index];
}
```

### Addition with Blocks and Threads: main()

```C
#define N (2048*2048)
#define THREADS_PER_BLOCK 512
int main(void) {
   int *a, *b, *c; // host copies of a, b, c
   int *d_a, *d_b, *d_c; // device copies of a, b, c
   int size = N * sizeof(int);

   // Alloc space for device copies of a, b, c
   cudaMalloc((void **)&d_a, size);
   cudaMalloc((void **)&d_b, size);
   cudaMalloc((void **)&d_c, size);

   // Alloc space for host copies of a, b, c and setup input values
   a = (int *)malloc(size); random_ints(a, N);
   b = (int *)malloc(size); random_ints(b, N);
   c = (int *)malloc(size);
```

### Addition with Blocks and Threads: main()

```C
   // Copy inputs to device
   cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);
   cudaMemcpy(d_b, b, size, cudaMemcpyHostToDevice);

   // Launch add() kernel on GPU
   add<<<(N + THREADS_PER_BLOCK-1)/THREADS_PER_BLOCK, THREADS_PER_BLOCK>>>(d_a, d_b, d_c);

   // Copy result back to host
   cudaMemcpy(c, d_c, size, cudaMemcpyDeviceToHost);

   // Cleanup
   free(a); free(b); free(c);
   cudaFree(d_a); cudaFree(d_b); cudaFree(d_c);
   return 0;
}
```

# Handling Arbitrary Vector Sizes

- Update the kernel launch:

```C
add<<<(N + M-1) / M, M>>>(d_a, d_b, d_c, N);
```

- Avoid accessing beyond the end of the arrays:

```C
__global__ void add(int *a, int *b, int *c, int n) {
   int index = threadIdx.x + blockIdx.x * blockDim.x;
   if (index < n)
      c[index] = a[index] + b[index];
}
```

# SAXPY Example (Single-Precision A·X Plus Y)

## Why Bother with Threads?

- Threads seem unnecessary.
  - They add a level of complexity.
  - What do we gain?
- Unlike parallel blocks, threads have mechanisms to:
  - Communicate.
  - Synchronize.

## Sharing Data Between Threads

- Within a block, threads share data via shared memory.
- Extremely fast on-chip memory, user-managed.
- Declare using `__shared__`, allocated per block.
- Data is not visible to threads in other blocks.

## `__syncthreads()`

- `void __syncthreads();`
- Synchronizes all threads within a block.
  - Used to prevent RAW / WAR / WAW hazards.
- All threads must reach the barrier.
  - In conditional code, the condition must be uniform across the block.

  # Dot Product

## Dot Product Overview

- Unlike vector addition, dot product is a reduction from vectors to a scalar: \(c = a \cdot b\)
- For example, in 4D vectors: \(c = (a_0 \cdot b_0) + (a_1 \cdot b_1) + (a_2 \cdot b_2) + (a_3 \cdot b_3)\)

## Parallel Threads for Pairwise Products

- Parallel threads can easily compute pairwise products.
- Initial dot product CUDA kernel computes pairwise products:

```C
__global__ void dot(int *a, int *b, int *c) {
    // Each thread computes a pairwise product
    int temp = a[threadIdx.x] * b[threadIdx.x];
    // Can’t compute the final sum
    // Each thread’s copy of ‘temp’ is private
}
```

## Sharing Data Between Threads

- Need to share data between threads to compute the final sum.
- Introduce shared memory using `__shared__` CUDA keyword.
- Shared memory is extremely fast, on-chip memory, managed by the user.
- Not visible to threads in other blocks running in parallel.

## Parallel Dot Product

```C
#define N 512
__global__ void dot(int *a, int *b, int *c) {
    // Shared memory for results of multiplication
    __shared__ int temp[N];
    temp[threadIdx.x] = a[threadIdx.x] * b[threadIdx.x];
    // Thread 0 sums the pairwise products
    if (0 == threadIdx.x) {
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += temp[i];
        *c = sum;
    }
}
```

## Synchronization with `__syncthreads()`

- Threads need to wait between sections of `dot()` to prevent data hazards.
- Synchronize threads using `__syncthreads()`.
- Threads wait until all threads have reached the `__syncthreads()`.

```C
__global__ void dot(int *a, int *b, int *c) {
    __shared__ int temp[N];
    temp[threadIdx.x] = a[threadIdx.x] * b[threadIdx.x];
    __syncthreads();
    if (0 == threadIdx.x) {
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += temp[i];
        *c = sum;
    }
}
```

## Multiblock Dot Product

- A single block won't utilize much of the GPU.
- Implement a multiblock version of the dot product.
- Each block computes a sum of its pairwise products.
- Contributes its sum to the final result.

```C
#define N (2048*2048)
#define THREADS_PER_BLOCK 512
__global__ void dot(int *a, int *b, int *c) {
    __shared__ int temp[THREADS_PER_BLOCK];
    int index = threadIdx.x + blockIdx.x * blockDim.x;
    temp[threadIdx.x] = a[index] * b[index];
    __syncthreads();
    if (0 == threadIdx.x) {
        int sum = 0;
        for (int i = 0; i < THREADS_PER_BLOCK; i++)
            sum += temp[i];
        atomicAdd(c, sum);
    }
}
```

## Atomic Operations to Resolve Race Conditions

- Race conditions arise when multiple threads access and modify the same memory.
- Use atomic operations to ensure uninterruptible read-modify-write.
- For example, use `atomicAdd()`:

```C
#define N (2048*2048)
#define THREADS_PER_BLOCK 512
__global__ void dot(int *a, int *b, int *c) {
    __shared__ int temp[THREADS_PER_BLOCK];
    int index = threadIdx.x + blockIdx.x * blockDim.x;
    temp[threadIdx.x] = a[index] * b[index];
    __syncthreads();
    if (0 == threadIdx.x) {
        int sum = 0;
        for (int i = 0; i < THREADS_PER_BLOCK; i++)
            sum += temp[i];
        atomicAdd(c, sum);
    }
}
```

## Main Function for Multiblock Dot Product

```C
#define N (2048*2048)
#define THREADS_PER_BLOCK 512
int main(void) {
    int *a, *b, *c; // host copies of a, b, c
    int *dev_a, *dev_b, *dev_c; // device copies of a, b, c
    int size = N * sizeof(int); // space for N integers
    // allocate device copies of a, b, c
    cudaMalloc((void**)&dev_a, size);
    cudaMalloc((void**)&dev_b, size);
    cudaMalloc((void**)&dev_c, sizeof(int));
    a = (int *)malloc(size);
    b = (int *)malloc(size);
    c = (int *)malloc(sizeof(int));
    random_ints(a, N);
    random_ints(b, N);
    // copy inputs to device
    cudaMemcpy(dev_a, a, size, cudaMemcpyHostToDevice);
    cudaMemcpy(dev_b, b, size, cudaMemcpyHostToDevice);
    // launch dot() kernel
    dot<<<N/THREADS_PER_BLOCK, THREADS_PER_BLOCK>>>(dev_a, dev_b, dev_c);
    // copy device result back to host copy of c
    cudaMemcpy(c, dev_c, sizeof(int) , cudaMemcpyDeviceToHost);
    free(a); free(b); free(c);
    cudaFree(dev_a);
    cudaFree(dev_b);
    cudaFree(dev_c);
    return 0;
}
```

## Review

- **Race conditions:**
  - Behavior depends on the relative timing of multiple event sequences.
  - Can occur when an implied read-modify-write is interruptible.
- **Atomic operations:**
  - CUDA provides read-modify-write operations guaranteed to be atomic.
  - Atomics ensure correct results when multiple threads modify memory.

# References

- [NVIDIA GTC 2010 - CUDA Programming Guide](http://www.nvidia.com/content/gtc-2010/pdfs/2131_gtc2010.pdf)
- [Microway - GPU Memory Types and Performance Comparison](https://www.microway.com/hpc-tech-tips/gpu-memory-types-performance-comparison/)