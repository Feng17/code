package nowcoder.ch01_stack_queue;

import java.util.Stack;

/**
 * 定义栈的数据结构，在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * 思路：使用两个栈，一个栈stackData保存当前栈中元素，另一个栈stackMin用于保存每一步最小值。
 *      假设当前数据为node，先压入到stackData中再判断stackMin是否为空，
 *      如果为空，node也压入stackMin中，如果不为空，比较stackMin与node哪个更小。
 *      如果node更小或相等，则node也压入stackMin中，如果node大于stackMin栈顶元素，则什么也不做即stackMin不压入内容
 */

public class ReturnStackMin {

    private Stack<Integer> stackData= new Stack<Integer>();
    private Stack<Integer> stackMin= new Stack<Integer>();


    public void push(int node) {
        stackData.push(node);
        if (stackMin.isEmpty()) {
            stackMin.push(node);
        } else if (node <=stackMin.peek()) {
            stackMin.push(node);
        }
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return stackMin.peek();
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return stackData.pop();
    }

    public static void main(String[] args) {
        ReturnStackMin stack = new ReturnStackMin();
        stack.push(7);
        stack.push(8);
        stack.push(4);
        stack.push(9);
        stack.push(5);
        System.out.println(stack.getMin());//4

        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
    }
}
