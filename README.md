## A Strange and Restricted CPU

In this activity, you will simulate the STAR CPU that is somewhat strange and restrictive and can yet perform some computation.

The CPU accesses a memory region defined by the `int` array `memory`, with `N` entries. The program counter, `pc`, is always `memory[0]` and this location of memory holds the next address to process.

At each clock cycle or time step, the CPU uses three memory addresses, `memory[pc]`, `memory[pc + 1]`, and `memory[pc + 2]`. Let `v1`, `v2` and `v3` be the **values** at these three addresses, respectively. In other words, `v1 = memory[pc]`, etc. The CPU performs the following operation:

1. Compute `memory[v1] - memory[v2]` and use this value to replace `memory[v1]`; and
2. If the new value at `memory[v1]` is less than or equal to 0 then update the value of the program counter to `v3` otherwise increment the value of the program counter by 3.

The CPU stops execution when there is an attempt to read a value outside the bounds of the memory array, and when this happens the value at `memory[1]` is returned as the output of whatever "program" was being executed.

> You have been provided skeleton code and a few test cases to help you get started. You should not change the method signatures of any of the methods that you have been asked to implement. For this activity, it will definitely help to take a [quick peek at the tests](src/test/java/cpu/). For this activity, when you are asked to generate a program that means that you have to produce the complete initial memory layout that will be used by the CPU.
>
> Independently, some of you may want to think about whether the StarCPU is a [Turing-complete machine](https://en.wikipedia.org/wiki/Turing_completeness).

### Task 1

Implement the method `StarCPU::simulate` that takes as argument an initial memory state and returns the output of the program stored in the memory.

### Task 2

You will now implement a method (`StarCPU::addProgram`) that takes as argument two positive integers `a` and `b` and **generates** a program that returns `a + b`. For this task, the program that is generated should contain no value in memory that is initially greater than `max(a/2, b/2, 100)` and no value in memory that is initially smaller than `0`.

## Submission Instructions

+ Submit your work to the Github classroom repository that was created for you.
+ **Do not alter the directory/folder structure. You should retain the structure as in this repository.**
+ Do not wait until the last minute to push your work to Github. It is a good idea to push your work at intermediate points as well. _We would recommend that you get your Git and Github workflow set up at the start._
+ You should submit your work to the `main` branch.

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes *unless you are asked to do so*.
+ You can use additional **standard** Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.

## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person for the purpose of completing this activity.
+ You did not aid any other person in the class in completing their activity.
+ You are submitting work from your own GitHub account.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this activity.