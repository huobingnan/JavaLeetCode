package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.IdentityHashMap;
import java.util.Map;

@AC(time = "0 ms", memory = "41.4 MB", timeRank = "100%", memoryRank = "8.38%")
@Outline(name = "剑指 Offer 35. 复杂链表的复制",description = "链表, 打表", level = ProblemLevel.MEDIUM)
public class Offer35 {
    public Node copyRandomList(Node head) {
        final Map<Node, Node> oldToNew = new IdentityHashMap<>();
        Node prev = null, ptr = head;
        // 设置next域
        for (;;) {
            if (ptr == null) break;
            final Node n = new Node(ptr.val);
            oldToNew.put(ptr, n);
            if (prev != null) prev.next = n;
            prev = n;
            ptr = ptr.next;
        }
        ptr = head;
        // 设置random域
        for (;;) {
            if (ptr == null) break;
            oldToNew.get(ptr).random = oldToNew.get(ptr.random);
            ptr = ptr.next;
        }
        return oldToNew.get(head);
    }
}
