package nowcoder.ch01_stack_queue;


import java.util.Stack;

/**
 * 编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），最多只能使用一个额外的栈存放临时数据。
 * <p>
 * 思路：要排序的栈记为stack，，在构建一个辅助栈，在stack上执行pop操作，弹出元素记为cur
 * 如果cur小于等于help栈顶元素，则将cur压入help，如果cur大于help栈顶元素，就将help中的元素一一弹出，
 * 直到cur的值小于等于help的栈顶元素，在将cur压入help。
 * 循环上面操作，直到stack中元素全部压入help中，最后将help中的元素一次性压入stack中，stack中元素就实现了升序。
 */

public class TwoStacksSort {

    public static void sortStackByADSC(Stack<Integer> stack) {
        //构建辅助栈
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (  !help.isEmpty()&& cur>help.peek() ){
                stack.push(help.pop());
            }
            //cur小于等于help栈顶元素就压入
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        sortStackByADSC(stack);
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());  //输出 54321
    }


}
