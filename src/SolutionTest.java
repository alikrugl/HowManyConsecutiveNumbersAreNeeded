import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.*;

public class SolutionTest {
    @Test
    public void fixedTests() {
        int[] arr1 = {4, 8, 6};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {};
        int[] arr4 = {1};
        Assert.assertEquals(Solution.consecutive(arr1), 2);
        Assert.assertEquals(Solution.consecutive(arr2), 0);
        Assert.assertEquals(Solution.consecutive(arr3), 0);
        Assert.assertEquals(Solution.consecutive(arr4), 0);
    }

    @Test
    public void randomTests() {
        final List<Integer> values = IntStream.rangeClosed(-50, 1000).boxed().collect(Collectors.toList());
        for (int trial = 1; trial <= 100; trial++) {
            Collections.shuffle(values);
            final int[] arr = values.subList(0, 100).stream().mapToInt(x -> x).toArray();
            Assert.assertEquals(Solution.consecutive(arr), solution(arr));
        }
    }

    private int solution(final int[] arr) {
        if (arr.length == 0) return 0;
        IntSummaryStatistics stats = IntStream.of(arr).summaryStatistics();
        return stats.getMax() - stats.getMin() - arr.length + 1;
    }
}
