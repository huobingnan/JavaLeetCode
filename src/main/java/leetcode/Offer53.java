package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@AC(time = "0 ms", memory = "44.7 MB", timeRank = "100%", memoryRank = "10.88%")
@Outline(name = "剑指 Offer 53 - I. 在排序数组中查找数字 I", description = "二分查找", level = ProblemLevel.EASY)
public class Offer53 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length, mid = 0;
        for (;;) {
            if (low >= high) break;
            mid = (low + high) >> 1;
            final int num = nums[mid];
            if (num == target) {
                int count = 1;
                for (int i = mid+1; i < nums.length; i++) {
                    if (nums[i] == target) count++;
                    else break;
                }
                for (int i = mid-1; i >= 0; i--) {
                    if (nums[i] == target) count++;
                    else break;
                }
                return count;
            }
            else if (num > target) high = mid;
            else low = mid+1;
        }
        return 0;
    }
}
