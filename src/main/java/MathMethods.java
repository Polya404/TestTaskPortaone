import java.util.List;

public interface MathMethods {
    long maxNumber(List<Long> numbers);
    long minNumber(List<Long> numbers);
    double median(List<Long> numbers);
    double arithmeticMean(List<Long> numbers);
    List<Long> maxSubsequence(List<Long> numbers);
    List<Long> minSubsequence(List<Long> numbers);
}
