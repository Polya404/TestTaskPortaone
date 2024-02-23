import java.util.*;

public class MathMethodsImpl implements MathMethods {
    @Override
    public long maxNumber(List<Long> numbers) {
        TreeSet<Long> tree = new TreeSet<>(numbers);
        return tree.last();
    }

    @Override
    public long minNumber(List<Long> numbers) {
        TreeSet<Long> tree = new TreeSet<>(numbers);
        return tree.first();
    }

    @Override
    public double median(List<Long> numbers) {
        Collections.sort(numbers);
        if (numbers.size() % 2 != 0) {
            return numbers.get(numbers.size() / 2);
        }
        int first = Math.toIntExact(numbers.get((numbers.size() / 2) - 1));
        int second = Math.toIntExact(numbers.get(numbers.size() / 2));
        return (double) (first + second) / 2;
    }

    @Override
    public double arithmeticMean(List<Long> numbers) {
        long sum = numbers.stream().mapToLong(a -> a).sum();
        double scale = Math.pow(10, 2);
        return Math.ceil(((double) sum / numbers.size()) * scale) / scale;
    }

    @Override
    public List<Long> maxSubsequence(List<Long> numbers) {
        List<Long> res = new ArrayList<>();
        List<Long> cur = new ArrayList<>();
        int maxLen = 0;
        int len = 1;
        for (int i = 0; i <= numbers.size() - 1; i++) {
            if (i != numbers.size() - 1 && numbers.get(i + 1) > numbers.get(i)) {
                len = updateCurrentLength(len, cur, i, numbers);
            } else {
                if (len > maxLen) {
                    maxLen = updateMaxLength(len, res, cur, i, numbers);
                }
                len = reset(cur);
            }
        }
        return res;
    }

    @Override
    public List<Long> minSubsequence(List<Long> numbers) {
        List<Long> res = new ArrayList<>();
        List<Long> cur = new ArrayList<>();
        int maxLen = 0;
        int len = 1;
        for (int i = 0; i <= numbers.size() - 1; i++) {
            if (i != numbers.size() - 1 && numbers.get(i + 1) < numbers.get(i)) {
                len = updateCurrentLength(len, cur, i, numbers);
            } else {
                if (len > maxLen) {
                    maxLen = updateMaxLength(len, res, cur, i, numbers);
                }
                len = reset(cur);
            }
        }
        return res;
    }

    private int updateCurrentLength(int len, List<Long> cur, int i, List<Long> numbers) {
        len += 1;
        cur.add(numbers.get(i));
        return len;
    }

    private int updateMaxLength(int len, List<Long> res, List<Long> cur, int i, List<Long> numbers) {
        int maxLen;
        maxLen = len;
        res.clear();
        res.addAll(cur);
        res.add(numbers.get(i));
        return maxLen;
    }

    private int reset(List<Long> cur) {
        int len;
        cur.clear();
        len = 1;
        return len;
    }

}
