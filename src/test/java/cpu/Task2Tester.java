package cpu;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class Task2Tester {

    @ParameterizedTest
    @MethodSource("task2TestProvider")
    public void task2Test(int a, int b) {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () ->
        {
            int[] memory = StarCPU.addProgram(a, b);
            // note: we should have
            // 0 <= memory[i] <= max(a, b, 100)
            // for all i

            assertEquals(a + b, StarCPU.simulate(memory));
        }
        );
    }

    private static Stream<Arguments> task2TestProvider() {
        return Stream.of(
                Arguments.of(3, 6),
                Arguments.of(5, 2),
                Arguments.of(1024, 10),
                Arguments.of(1, 1),
                Arguments.of(2047, 2047)
        );
    }

}
