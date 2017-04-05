/*
	后继节点是一个节点在二叉树中序遍历时的下一个节点就是它的后继
	基本思路：1.如果一个节点有右子树，它的后继节点就是它右子树上最左边的那个节点（左边界上最左的那个节点）
			  2.如果一个节点没有右子树，就一直往上找直到找到一个节点是它父节点的左孩子，那么那个父节点就是我们要找的后继节点
*/
public class DescendantNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;  //提供指向父节点的指针

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getNextNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			return getLeftMost(node.right);
		} else {      //没有右子树的情况
			Node parent = node.parent;
			while (parent != null && parent.left != node) { //如果node一直是它父节点的右孩子则继续循环，直到找到一个节点是它父节点的左孩子，就返回这个父节点 
				node = parent;                      //向上移动节点
				parent = node.parent;
			}
			return parent;
		}
	}

	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {  //找到右子树上最左节点
			node = node.left;
		}
		return node;
	}
	/*  中序遍历二叉树
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
	*/

	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;
		/*
		 遍历结果
		System.out.print("in-order: ");
		inOrderUnRecur(head);
		*/
		Node test = head.left.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getNextNode(test));
	}

}
