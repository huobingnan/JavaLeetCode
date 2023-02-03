package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@AC(time = "0 ms", memory = "39.5 MB", timeRank = "100%", memoryRank = "44.04%")
@Outline(name = "剑指 Offer 05. 替换空格", description = "字符串", level = ProblemLevel.EASY)
public class Offer05 {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
