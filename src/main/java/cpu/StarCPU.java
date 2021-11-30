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
        // TODO: Implement this method
        return memory[1];
    }

    /**
     * Generate a StarCPU program that returns {@code a + b}
     * @param a {@code a > 0}
     * @param b {@code b > 0}
     * @return a StarCPU program that returns {@code a + b} and such that each entry {@code e} is such that {@code 0 <= val <= max(a/2, b/2, 100)}
     */
    public static int[] addProgram(int a, int b) {
        // TODO: Implement this method
        return null;
    }
}
