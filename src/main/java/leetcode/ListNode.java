package leetcode;

import java.util.StringJoiner;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(" -> ");
        ListNode p = this;
        for (;;) {
            if (p == null) break;
            sj.add(String.valueOf(p.val));
            p = p.next;
        }
        return sj.toString();
    }
}
