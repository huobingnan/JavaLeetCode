package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.Arrays;
import java.util.stream.IntStream;

@AC(time = "0 ms", memory = "42.1 MB", timeRank = "100%", memoryRank = "41.37%")
@Outline(name = "剑指 Offer 06. 从尾到头打印链表", description = "链表", level = ProblemLevel.EASY)
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length++; ptr = ptr.next;
        }
        final int[] array = new int[length];
        ptr = head;
        for (int i = 0; i < length; i++) {
            array[i] = ptr.val;
            ptr = ptr.next;
        }
        for (int left = 0, right = length-1; left < right; left+=1, right-=1) {
            final int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        return array;
    }
}
