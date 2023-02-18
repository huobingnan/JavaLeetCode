package leetcode;

import leetcode.infra.ListNode;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.ArrayList;
import java.util.List;


@AC(time = "0 ms", memory = "39.2 MB", timeRank = "100%", memoryRank = "48.43%")
@Outline(name = "24. 两两交换链表中的节点", description = "链表", level = ProblemLevel.MEDIUM)
public class L24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        final List<ListNode> nodes = new ArrayList<>();
        // 1. 断链收集
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            nodes.add(head);
            head.next = null;
            head = temp;
        }
        // 两两交换
        for (int i = 0, len = nodes.size()-1; i < len; i+=2) {
            temp = nodes.get(i);
            nodes.set(i, nodes.get(i+1));
            nodes.set(i+1, temp);
            nodes.get(i).next = nodes.get(i+1);
        }
        // 重新连接
        for (int i = 0, len = nodes.size()-1; i < len; i++) {
            nodes.get(i).next = nodes.get(i+1);
        }
        return nodes.get(0);
    }
}
