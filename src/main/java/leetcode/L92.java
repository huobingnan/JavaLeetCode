package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;
import leetcode.runner.URL;

@URL("https://leetcode.cn/problems/reverse-linked-list-ii/")
@Outline(name = "92. 反转链表 II", description = "链表", level = ProblemLevel.MEDIUM)
public class L92 {

    @AC(time = "0 ms", memory = "39.6 MB", timeRank = "100%", memoryRank = "5.20%")
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ptr = head, prev = null, next = null;
        int i = 1;
        for (; i < left; i++) {
            prev = ptr;
            ptr = ptr.next;
        }

        final ListNode ptr0 = ptr, prev0 = prev;

        for (; i <= right; i++) {
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }

        ptr0.next = ptr;
        if (prev0 == null) {
            return prev;
        } else {
            prev0.next = prev;
            return head;
        }
    }
}
