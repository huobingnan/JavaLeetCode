package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

@AC(time = "36 ms", memory = "47.8 MB", timeRank = "83.1%", memoryRank = "91.9%")
@Outline(name = "剑指 Offer 09. 用两个栈实现队列", description = "模拟", level = ProblemLevel.EASY)
public class Offer09 {

    class CQueue {
        private final Deque<Integer> appendStack = new ArrayDeque<>();
        private final Deque<Integer> deleteStack = new ArrayDeque<>();

        public CQueue() { }

        public void appendTail(int value) { appendStack.push(value); }

        public int deleteHead() {
            if (deleteStack.isEmpty()) {
                while (!appendStack.isEmpty()) deleteStack.push(appendStack.pop());
            }
            return deleteStack.isEmpty() ? -1 : deleteStack.pop();
        }
    }

}
