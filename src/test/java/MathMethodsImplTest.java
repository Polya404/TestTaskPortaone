import org.junit.jupiter.api.*;

import java.util.*;

class MathMethodsImplTest {
    private final String TEST_FILE_NAME = "test.txt";
    private final String FILE_NAME = "numbers.txt";
    private final MathMethodsImpl mathMethods = new MathMethodsImpl();
    private final List<Long> testNumbers = Utils.readFromFile(TEST_FILE_NAME);
    private final List<Long> numbers = Utils.readFromFile(FILE_NAME);
    private long startTime;

    @BeforeEach
    void setUp() {
        startTime = System.nanoTime();
    }

    @AfterEach
    void afterEach() {
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("Execution time: " + duration + " milliseconds");
    }

    @Test
    void maxNumber() {
        Long[] array = new Long[]{1L, 4L, 6L, 8L, 11L};
        Assertions.assertEquals(11, mathMethods.maxNumber(Arrays.asList(array)));
        Assertions.assertEquals(Collections.max(testNumbers), mathMethods.maxNumber(testNumbers));
        Assertions.assertEquals(Collections.max(numbers), mathMethods.maxNumber(numbers));
    }

    @Test
    void minNumber() {
        Long[] array = new Long[]{1L, 4L, 6L, 8L, 11L, -29L};
        Assertions.assertEquals(-29, mathMethods.minNumber(Arrays.asList(array)));
        Assertions.assertEquals(Collections.min(testNumbers), mathMethods.minNumber(testNumbers));
        Assertions.assertEquals(Collections.min(numbers), mathMethods.minNumber(numbers));
    }

    @Test
    void median() {
        Long[] evenArray = new Long[]{1L, 4L, 6L, 8L};
        Long[] oddArray = new Long[]{-11L, 42L, 56L, 67L, 81L};
        Assertions.assertEquals(5, mathMethods.median(Arrays.asList(evenArray)));
        Assertions.assertEquals(56, mathMethods.median(Arrays.asList(oddArray)));
        Assertions.assertEquals(0, mathMethods.median(testNumbers));
        Assertions.assertEquals(25216, mathMethods.median(numbers));
    }

    @Test
    void arithmeticMean() {
        Long[] array = new Long[]{1L, 4L, 6L, 8L, 11L};
        Assertions.assertEquals(6, mathMethods.arithmeticMean(Arrays.asList(array)));
        Assertions.assertEquals(8.77, mathMethods.arithmeticMean(testNumbers));
        Assertions.assertEquals(7364.42, mathMethods.arithmeticMean(numbers));
    }

    @Test
    void maxSubsequence() {
        Long[] array = new Long[]{1L, 4L, -5L, 4L, 6L, 8L, 11L};
        Long[] expected = new Long[]{-5L, 4L, 6L, 8L, 11L};
        Assertions.assertEquals(Arrays.asList(expected), mathMethods.maxSubsequence(Arrays.asList(array)));
        Assertions.assertEquals(Arrays.asList(-5L, 0L, 3L, 5L, 67L, 69L, 90L), mathMethods.maxSubsequence(testNumbers));
        Assertions.assertEquals(Arrays.asList(-48190694L, -47725447L, -43038241L, -20190291L, -17190728L, -6172572L, 8475960L, 25205909L, 48332507L, 48676185L), mathMethods.maxSubsequence(numbers));
    }

    @Test
    void minSubsequence() {
        Long[] array = new Long[]{1L, 4L, -5L, 4L, 6L, -1L, -4L, -8L, -11L, 11L};
        Long[] expected = new Long[]{6L, -1L, -4L, -8L, -11L};
        Assertions.assertEquals(Arrays.asList(expected), mathMethods.minSubsequence(Arrays.asList(array)));
        Assertions.assertEquals(Arrays.asList(90L, -3L, -5L, -7L, -9L, -12L, -13L), mathMethods.minSubsequence(testNumbers));
        Assertions.assertEquals(Arrays.asList(47689379L, 42381213L, 30043880L, 12102356L, -4774057L, -5157723L, -11217378L, -23005285L, -23016933L, -39209115L, -49148762L), mathMethods.minSubsequence(numbers));
    }
}