import static leetcode.runner.LeetCodeInputResolver.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LeetCodeInputResolverTest {


    @Test
    public void parseIntArrayShouldReturnCorrectValue() {
        final int[] case1 = parseIntArray("[1, 2, 3, 4, 5]"); // 个位数测试
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, case1);
        final int[] case2 = parseIntArray("[3421, 4566, 2134, 99990]"); // 多位数测试
        assertArrayEquals(new int[]{3421, 4566, 2134, 99990}, case2);
        final int[] case3 = parseIntArray("[]"); // 空数组
        assertArrayEquals(new int[0], case3);

    }
}
