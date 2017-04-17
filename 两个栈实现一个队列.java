/*
两个栈实现一个队列  一个栈作为压入栈一个栈作为弹出栈
 注意：1.压栈时需一次性将数据全部压入
       2.若弹出栈不为空，则不能压入数据
*/

public class TwoStacksImplementQueue {

	public static class TwoStacksQueue {
		public Stack<Integer> stackPush;
		public Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void add(int d) {
			stackPush.push(d);
		}

		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		
	}

	public static void main(String[] args) {
		TwoStacksQueue test = new TwoStacksQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		
		System.out.println(test.poll());
		
		System.out.println(test.poll());
		
		System.out.println(test.poll());
	}

}
