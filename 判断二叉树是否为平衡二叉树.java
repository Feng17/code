/*
平衡二叉树定义：要么是一颗空树要么对于任何一个节点，它们的左右子树高度差的绝对值不能超过1

基本过程：整体过程进行二叉树后序遍历。对于任意一个节点先遍历左子树，遍历过程中进行两个操作1.判断它的左子树是否平衡 2.记录左子树最深到哪一层记为lH。若发现左子树不平衡退出遍历，
          右子树同理最深记为rH，若右子树也是平衡二叉树看lH和rH差的绝对值是否大于1，如果大于1，说明整棵树不是二叉树，不大于1返回lH和rH中较大的那个。
*/

public class IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1]; //设置布尔类型数组res长度为1，功能相当全局boolean变量
		res[0] = true;
		getHeight(head, 1, res); //递归
		return res[0];
	}

	public static int getHeight(Node head, int level, boolean[] res) {    
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, res); //记录节点左子树最深到那一层
		if (!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, res); //记录节点右子树最深到那一层
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.left.left = new Node(5);

		System.out.println(isBalance(head));      //return false

	}

}
