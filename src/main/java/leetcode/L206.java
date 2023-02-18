package leetcode;

import leetcode.infra.ListNode;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;
import leetcode.runner.URL;

@URL("https://leetcode.cn/problems/reverse-linked-list/")
@Outline(name = "206. 反转链表", description = "链表, 递归", level = ProblemLevel.EASY)
public class L206 {

    // 使用三指针的方式完成反转链表
    @AC(time = "0 ms", memory = "41.5 MB", timeRank = "100%", memoryRank = "24.51%")
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

    // 使用递归的方式完成反转链表
    @AC(time = "0 ms", memory = "41.5 MB", timeRank = "100%", memoryRank = "30.04%")
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        final ListNode last = reverseListRecursion(head.next); // 找到尾结点
        // 递归函数返回
        head.next.next = head; // 设置反转
        head.next = null;
        return last; // 每次都返回在递归基处找到的尾结点
    }


    // 使用双指针的方式完成反转链表
    @AC(time = "0 ms", memory = "41.3 MB", timeRank = "100%", memoryRank = "47.24%")
    public ListNode reverseListViaDualPtr(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head, ptr = prev.next;
        for (;;) {
            if (ptr == null) break;
            head.next = ptr.next;
            ptr.next = prev;

            prev = ptr;
            ptr = head.next;
        }
        return prev;
    }
}
