package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.Deque;
import java.util.LinkedList;

@Outline(name = "剑指 Offer 63. 股票的最大利润", description = "动态规划", level = ProblemLevel.MEDIUM)
public class Offer63 {

    // 考虑局部性的最优，并将局部最优缓存，在全局比较
    @AC(time = "1 ms", memory = "41.7 MB", timeRank = "51.61%", memoryRank = "13.34%")
    public int maxProfit(int[] prices) {
        // 边界处理
        if (prices == null || prices.length == 0) return 0;
        int max = prices[0], min = max, ans = 0;
        for (int i = 1; i < prices.length; i++) {
            final int price = prices[i];
            if (price > max) max = price;
            else if (price < min) {
                // 记录当前的结果，与之前缓存的局部最优进行比较
                final int d = max - min;
                if (d > ans) ans = d;
                // 更新当前最值信息，重新计算
                max = price; min = price;
            }
        }
        return Math.max(ans, (max-min));
    }
}
