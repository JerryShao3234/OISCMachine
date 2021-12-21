# A Simple OISC CPU

## Introduction:
In this lab I have built an OISC (One-instruction set computer) simulator. An OISC is perhaps the simplest CPU implementation in existence, even more so than RISCs (Reduced-instruction set computers).
A OISC is a type of CPU architecture that executes programs using a single instruction, and if implemented correctly, is theoretically capable of running any program designed for any other CPU. These types of CPUs
are implemented in a Hardware Description Language like Verilog or VHDL. However, for this case,
a high level software language like Java will be chosen to simulate the operation of such a machine.

In this case, the CPU is modelled for
Cryptoleq, which is a language consisting of just one instruction, subleq, known in Assembly as `subl`. 
  
As a reminder, subleq is defined as:

    `subl a, b, c:`  
    `memory[b] = memory[b] - memory[a]`  
    `if (memory[b] <= 0) goto c`
## Design Principle:
Cryptoleq is able to modify specific memory cells
using direct and multiple layers of indirect addressing. The general idea implemented in this design is:

The CPU accesses a memory region defined by the `int` array `memory`, with `N` entries. The program counter, `pc`, is always `memory[0]` and this location of memory holds the next address to process.

At each clock cycle or time step, the CPU uses three memory addresses, `memory[pc]`, `memory[pc + 1]`, and `memory[pc + 2]`. Let `v1`, `v2` and `v3` be the **values** at these three addresses, respectively. The CPU performs the following operation:

1. Compute `memory[v1] - memory[v2]` and use this value to replace `memory[v1]`; and
2. If the new value at `memory[v1]` is less than or equal to 0 then update the value of the program counter to `v3` otherwise increment the value of the program counter by 3.

The CPU stops execution when there is an attempt to read a value outside the bounds of the memory array, and when this happens the value at `memory[1]` is returned as the output of whatever "program" was being executed.

## Implementation:
Let us analyze the implementation in Java. In the `StarCPU` class are two methods: `simulate()` and `addProgram(int a, int b)`.  
The `simulate()` method is quite straightforward as it is just an implementation of the pseudocode mentioned above. Given a "program" (implemented as an int array), the method will simulate the CPU until it stops (i.e. triggered an out of bounds execption).


The `addProgram(int a, int b)` method is also straightforward but time consuming to write, and is almost completely hardcoded for the addition operation.  
The method writes a "program" (again, an int array) to calculate the output of two ints, `a` and `b`.  
Using the operation of the CPU defined above, one can hardcode the contents of the program array such that the program returns the correct sum after the CPU stops by intentionally triggering the exception.  


Of course, this is a simulation done in Java, which is not a Turing-complete model in any sense.  
## References:  
https://www.youtube.com/watch?v=o0e7_U7ZmBM&t=1068s  
https://www.sccs.swarthmore.edu/users/06/adem/engin/e25/finale/  