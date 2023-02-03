package leetcode;

import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Outline(name = "49. 字母异位词分组", description = "模拟", level = ProblemLevel.MEDIUM)
public class L49 {

    public int[] hashEachStr(String[] strs) {
        final int[] res = new int[strs.length];
        final int[] table = new int[26];
        for (int j = 0; j < strs.length; j++) {
            final String str = strs[j];
            Arrays.fill(table, 0);
            for (int i = 0, len = str.length(); i < len; i++) {
                table[str.charAt(i)-'a']++;
            }
            res[j] = Arrays.hashCode(table);
        }
        return res;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        final List<List<String>> result = new ArrayList<>();
        final int[] hash = hashEachStr(strs);
        final int length = strs.length;

        for (int i = 0; i < length; i++) {
            if (strs[i] == null) continue;
            final int hashCode = hash[i];
            final List<String> collector = new ArrayList<>();
            collector.add(strs[i]);

            for (int j = i+1; j < length; j++) {
                if (hash[j] == hashCode) {
                    collector.add(strs[j]);
                    strs[j] = null;
                }
            }

            result.add(collector);
        }
        return result;
    }

    public static void main(String[] args) {
        new L49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
