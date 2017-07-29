package nowcoder.ch01_stack_queue;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * 思路：一个栈作为压入栈，压入数据只往这个栈压入，一个栈作为弹出栈，弹出只从这个栈弹出
 *注意：1.压入栈往弹出栈压入数据，压栈时必须一次性将数据全部压入
 *      2.若弹出栈不为空，则不能往其中压入数据
 */


public class TwoStacksImplQueue {

    Stack<Integer> stackPush = new Stack<Integer>();
    Stack<Integer> stackPop= new Stack<Integer>();


    public void add(int d) {
        stackPush.push(d);
    }

    public int poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.isEmpty()) { //弹出栈为空时压入
            while (!stackPush.isEmpty()) { //将数据全部压入
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }




    public static void main(String[] args) {
        TwoStacksImplQueue test = new TwoStacksImplQueue();
        test.add(1);
        test.add(2);
        test.add(3);

        System.out.print(test.poll());
        System.out.print(test.poll());
        System.out.print(test.poll());
    }

}
