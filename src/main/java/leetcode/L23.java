package leetcode;

import leetcode.infra.ListNode;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

@AC(time = "7 ms", memory = "43.6 MB", timeRank = "30%", memoryRank = "34%")
@Outline(name = "合并K个升序链表", description = "优先队列, 链表", level = ProblemLevel.HARD)
public class L23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        final PriorityQueue<ListNode> headQue = new PriorityQueue<>((h1, h2) -> h1.val - h2.val);
        Arrays.stream(lists).filter(Objects::nonNull).forEach(headQue::add);
        ListNode head = null, ptr = null;
        for (;;) {
            if (headQue.isEmpty()) break;
            final ListNode node = headQue.poll();
            if (head == null) head = node;
            if (ptr == null) ptr = node;
            else {
                ptr.next = node;
                ptr = ptr.next;
            }
            if (node.next != null) headQue.add(node.next);
        }
        return head;
    }
}
