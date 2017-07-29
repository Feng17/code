package nowcoder.ch01_stack_queue;

import java.util.Stack;

/**
 * 使用递归来逆序一个栈
 */

public class ReverseStack {

    //getAndRemoveLastElement方法目的将栈底元素返回并移除
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);  //递归调用后 last为栈底元素
            stack.push(result); //将栈底元素之前的元素重新压入
            return last;
        }
    }

    //reverse方法将栈逆序
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }


    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }

}