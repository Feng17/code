/*

基本思路：利用底层空闲指针回到上面去
额外空间复杂度O(1)

中序遍历：

对于每一个节点都是一样的调整过程（步骤一和步骤二）每一个节点操作后的最终宿命就是向右移动 移动前打印节点 
此外本题中我们指的前驱节点（左子树上最右的节点）指它在所在子树中的前驱节点 

步骤一：如果传进来一个节点，把它左边界上的每一个节点对应的前驱节点的右指针指向每一个节点      
        即找到一个节点（例如1）的前驱节点，将前驱节点右指针指向自己（指向1）
		
步骤二：当一个节点没有先驱节点时开始向右移动（按照右指针移动），若移动后的节点发现前驱节点已经指向自己就把它前驱节点的指针
        调回来（重回指向空）调过之后向右移动

*/
public class Problem_05_MorrisTraversal {

	public static class Node {
		public int value;
		Node left;
		Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static void morrisIn(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				//找左子树上最右节点
				while (cur2.right != null && cur2.right != cur1) { 
					cur2 = cur2.right;
				}
				//步骤一处理方式
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;//左边界上向左移动
					continue;
				} else {  //即cur2.right==cur1
					cur2.right = null; //调回来
				}
			}
			System.out.print(cur1.value + " ");
			cur1 = cur1.right; //节点向右移动
		}
		System.out.println();
	}

	public static void morrisPre(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left; //cur2为cur1左子树的头节点
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					System.out.print(cur1.value + " "); //第一次遇到cur1打印
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			} else {
				System.out.print(cur1.value + " "); //左子树没有头节点就打印
			}
			cur1 = cur1.right;
		}
		System.out.println();
	}

	public static void morrisPos(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
					printEdge(cur1.left);
				}
			}
			cur1 = cur1.right;
		}
		printEdge(head);
		System.out.println();
	}

	public static void printEdge(Node head) {
		Node tail = reverseEdge(head);
		Node cur = tail;
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		reverseEdge(tail);
	}

	public static Node reverseEdge(Node from) {
		Node pre = null;
		Node next = null;
		while (from != null) {
			next = from.right;
			from.right = pre;
			pre = from;
			from = next;
		}
		return pre;
	}


	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		head.right.right = new Node(7);
		morrisIn(head);
		morrisPre(head);
		morrisPos(head);

	}

}
