package cpu;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class Task1Tester {

    @ParameterizedTest
    @MethodSource("task1TestProvider")
    public void task1Test(int[] memory, int output) {
        assertTimeoutPreemptively(Duration.ofSeconds(12), () ->
            {
                assertEquals(output, StarCPU.simulate(memory));
            }
        );
    }

    private static Stream<Arguments> task1TestProvider() {
        return Stream.of(
                Arguments.of(new int[] {42, 5}, 5),
                Arguments.of(new int[] {3, 2, 1, 4, 5, 1, 0, 4, 20, 1, 18}, -3),
                Arguments.of(new int[] {4, 2144, 1, 0, 3, 2, 8, 1000, 1, 3, 0, 1, 3, 0, 4242}, 2146),
                Arguments.of(new int[] {5, 3, 3, 0, 1, 2, 4, 999, 3, 1, 11, 1, 3, 14, 1, 3, 0, 3, 3, 5}, 27),
                Arguments.of(new int[] {5, 4, 2, 0, 1, 2, 4, 999, 3, 1, 11, 1, 3, 14, 1, 3, 0, 1, 3, 0, 3, 3, 5}, 16),
                Arguments.of(new int[] {4, 2, 10, 0, 1, 2, 3, 9, 3, 1, 9, 1, 3, 11, 1, 2, 0, 2, 3, 5}, -18),
                Arguments.of(new int[] {5, 3, 150, 0, 1, 2, 3, 999, 3, 1, 3, 1, 3, 14, 1, 3, 0, 3, 3, 5}, 3)
        );
    }

}
