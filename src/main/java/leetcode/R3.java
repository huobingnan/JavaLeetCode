package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@AC(time = "10 ms", memory = "48.8 MB", timeRank = "70.15%", memoryRank = "83.01%")
@Outline(name = "面试题 01.03. URL化", description = "字符串", level = ProblemLevel.EASY)
public class R3 {

    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }
}
