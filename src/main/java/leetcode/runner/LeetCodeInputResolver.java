package leetcode.runner;

import java.util.List;
import java.util.Optional;

// 处理LeetCode算法问题的输入
public class LeetCodeInputResolver {
    private LeetCodeInputResolver() {}

    // 将输入解析为指定元素类型的一维列表
    public static <T> List<T> parseListDim1(String content, Class<T> elementType) {
        return null;
    }

    private static int[] parseIntArray(String content, char delimiter) {
        final int contentLength = Optional.ofNullable(content)
                .map(String::length)
                .orElse(0);

        int arrayLength = 0;
        for (int i = 0; i < contentLength; i++) {
            if (content.charAt(i) == delimiter) arrayLength++;
        }

        if (content == null || "[]".equals(content)) return new int[0];
        else arrayLength++;

        final int[] array = new int[arrayLength];
        int ans = 0, cursor = 0;
        for (int i = 0; i < contentLength; i++) {
            final char ch = content.charAt(i);
            if (Character.isDigit(ch)) {
                ans *= 10;
                ans += (ch - '0');
            }
            if (ch == delimiter) {
                array[cursor++] = ans;
                ans = 0;
            }
        }
        array[cursor] = ans;

        return array;
    }

    public static int[] parseIntArray(String content) { return parseIntArray(content, ','); }
}
