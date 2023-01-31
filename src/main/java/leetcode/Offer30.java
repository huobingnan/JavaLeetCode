package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.ArrayDeque;
import java.util.Deque;

@AC(time = "13 ms", memory = "43.7 MB", timeRank = "64.36%", memoryRank = "31.35%")
@Outline(name = "剑指 Offer 30. 包含min函数的栈", description = "模拟", level = ProblemLevel.EASY)
public class Offer30 {
    class MinStack {
        private final Deque<Integer> minStack = new ArrayDeque<>();
        private final Deque<Integer> stack = new ArrayDeque<>();

        /** initialize your data structure here. */
        public MinStack() { }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) minStack.push(x);
            else if (minStack.peek() >= x) minStack.push(x);
        }

        public void pop() {
            final int val = stack.pop();
            if (val == minStack.peek()) minStack.pop();
        }

        public int top() { return stack.peek(); }

        public int min() { return minStack.peek(); }
    }

}
