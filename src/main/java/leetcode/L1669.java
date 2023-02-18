package leetcode;

import leetcode.infra.ListNode;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@AC(time = "1 ms", memory = "44.6 MB", timeRank = "100%", memoryRank = "82%")
@Outline(name = "合并两个链表", description = "链表", level = ProblemLevel.MEDIUM)
public class L1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int cur = 0;
        ListNode ptr = list1;
        for (;;) {
            if (cur == b+1) break;
            if (cur == a-1) {
                final ListNode next = ptr.next;
                ptr.next = list2;
                ptr = next; cur++;
                continue;
            }
            ptr = ptr.next; cur++;
        }
        for (;;) {
            if (list2 == null || list2.next == null) break;
            list2 = list2.next;
        }
        list2.next = ptr;
        return list1;
    }
}
