package nowcoder.ch01_stack_queue;

import java.util.LinkedList;

/**
 * 两个队列实现一个栈
 * 思路：入栈操作就将所有元素进入queue1，出栈操作就将queue1中除最后一个元素以外全部进入queue2，将queue1中剩下的元素出队列，之后再把queue2中的全部元素转移回queue1中
 *
 * 如进栈元素为1，2，3，4，先将所有元素进入队列queue1，要实现栈，第一个弹出的元素为4，但队列是从对头出队，
 * 于是先将1，2，3出队列queue1进入queue2，这是4位于queue1的队头，出队列。之后把queue2中的全部元素再转移回queue1中，重复操作
 */
public class TwoQueuesImplStack {

    LinkedList<Integer> queue1 = new LinkedList<Integer>();
    LinkedList<Integer> queue2 = new LinkedList<Integer>();

    public void push(int value) {
        queue1.add(value);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        while (queue1.size() != 1) {
            queue2.add(queue1.poll());
        }
        int result = queue1.poll();
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        TwoQueuesImplStack test = new TwoQueuesImplStack();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);

        System.out.print(test.pop());
        System.out.print(test.pop());
        System.out.print(test.pop());
        System.out.print(test.pop());
        //结果 4231

    }

}
