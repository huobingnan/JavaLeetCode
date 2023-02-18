package leetcode;

import leetcode.infra.ListNode;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@AC(time = "0 ms", memory = "41.2 MB", timeRank = "100%", memoryRank = "19.42%")
@Outline(name = "剑指 Offer 24. 反转链表", description = "链表", level = ProblemLevel.EASY)
public class Offer24 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, ptr = head, next = null;
        for (;;) {
            if (ptr == null) break;
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        return prev;
    }
}
