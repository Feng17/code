import java.util.Stack;

public class BinaryTraversal {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	//用递归进行遍历
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}
	
	//先序遍历的顺序是先中再左再右
    //思路：在栈里先注册头节点弹出后，按右子树先注册左子树后注册的顺序 即压进顺序先中再右再左。按照栈的特性 后压进的先处理
	public static void preOrderUnRecur(Node head) {    
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();      
				System.out.print(head.value + " ");  //弹出就打印
				// 先压右孩子，再压左孩子  压进顺序顺序先右后左那弹出顺序就先左后右
				if (head.right != null) {  
					stack.push(head.right);     
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	
//中序遍历的顺序是先左再中再右
//面对任何一棵树，先把它的左边界（一直left）依次压进栈，然后开始弹出，看弹出的节点是否有右子树
//若有右子树，重复之前将左边界一直压栈的操作
	public static void inOrderUnRecur(Node head) {
		System.out.print("in-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {    //将左边界全部压进栈
					stack.push(head);
					head = head.left;
				} else {       //最左边界没有值了开始弹出
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;  //head向弹出节点的右方向移动
				}
			}
		}
		System.out.println();
	}
	
//后序遍历的顺序是先左再右再中，按先序遍历的先中再左再右的思路，我们很容易实现先中再右再左
//此时我们用两个栈，这时弹出时不打印，将弹出的节点放到另一个栈中，这样另一个栈弹出时就实现了先左再右再中的顺序
	public static void posOrderUnRecur1(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);  //与先序遍历比 将弹出就打印改为弹出放到S2栈中
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}
	
//第二种方法仅用一个栈实现后序遍历 使用2个变量 c代表当前栈顶元素，h代表上一个打印的节点
	public static void posOrderUnRecur2(Node h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive 递归遍历
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

		// unrecursive  非递归遍历
		System.out.println("============unrecursive=============");
		System.out.print("pre-order: ");
		preOrderUnRecur(head);
		System.out.print("in-order: ");
		inOrderUnRecur(head);
		System.out.print("pos-order: ");
		posOrderUnRecur1(head);
		posOrderUnRecur2(head);

	}

}
