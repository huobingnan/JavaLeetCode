package leetcode;

import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;
import leetcode.runner.SeeAlso;

@SeeAlso("https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/")
@Outline(name = "剑指 Offer 11. 旋转数组的最小数字", description = "二分查找", level = ProblemLevel.EASY)
public class Offer11 {
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length;
        for (;;) {
            if (low >= high) break;
            final int mid = (low + high) >> 1;
            if (numbers[mid] >= numbers[0]) low = mid+1;
            else if (numbers[mid] <= numbers[0]) high = mid-1;
        }
        return numbers[low];
    }

}
