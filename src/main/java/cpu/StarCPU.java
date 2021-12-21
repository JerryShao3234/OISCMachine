package cpu;

import java.util.ArrayList;
import java.util.Arrays;

public class StarCPU {

    /**
     *
     * @param memory the state of CPU memory, {@code memory.length >= 2} and {@code memory} is modified to represent the state of the CPU after each operation
     * @return the output when execution terminates
     */
    public static int simulate(int[] memory) {

        try {
            while(memory[0] < memory.length) {
                int pc = memory[0];

                if (pc >= memory.length || pc + 1 >= memory.length || pc + 2 >= memory.length) {
                    return memory[1];
                }

                int v1 = memory[pc];
                int v2 = memory[pc + 1];
                int v3 = memory[pc + 2];

                if (v1 >= memory.length || v2 >= memory.length) {
                    return memory[1];
                }

                memory[v1] = memory[v1] - memory[v2];
                if (memory[v1] <= 0) {
                    memory[0] = v3;
                } else {
                    memory[0] += 3;
                }
            }

        }
        catch (Exception e){
            return memory[1];
        }

        return memory[1];

    }

    /**
     * Generate a StarCPU program that returns {@code a + b}
     * @param a {@code a > 0}
     * @param b {@code b > 0}
     * @return a StarCPU program that returns {@code a + b} and such that each entry {@code e} is such that {@code 0 <= val <= max(a/2, b/2, 100)}
     */
    public static int[] addProgram(int a, int b) {
        int[] memory = new int[] {2,0,5,6,7,0,a/2,5,10,11,a/2,5,14,15,b/2,5,18,19,b/2,1,5,2,100};

        if(a%2 == 0 && b%2 == 0){
            memory[1] = 0;
        }
        else if(a%2 != 0 && b%2 != 0){
            memory[1] = 2;
        }
        else {
            memory[1] = 1;
        }
        return memory;
    }
}
