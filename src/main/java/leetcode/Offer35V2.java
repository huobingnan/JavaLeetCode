package leetcode;

import leetcode.infra.Node;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@Outline(name = "剑指 Offer 35. 复杂链表的复制",description = "链表, 原地修改", level = ProblemLevel.MEDIUM)
public class Offer35V2 {

    public Node copyRandomList(Node head) {
        // 拷贝整条链
        Node ptr = head, newHead = null, prev = null, next = null;
        for (;;) {
            if (ptr == null) break;
            next = ptr.next;
            // 拷贝当前结点
            final Node n = new Node(ptr.val);
            // 建立双向链接
            ptr.next = n; n.random = ptr;
            if (newHead == null) newHead = n;
            if (prev != null) prev.next = n;
            prev = n; ptr = next;
        }
        // 整理建立random域
        ptr = newHead; prev = null;
        for (;;) {
            if (ptr == null) break;

            final Node rn = ptr.random.random;
            if (rn != null) ptr.random = rn.next;
            else ptr.random = null;
            ptr = ptr.next;
        }
        prev.next = null;
        return newHead;
    }
}
