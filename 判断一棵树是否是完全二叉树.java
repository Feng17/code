
/*����˼�룺��������������������ǰ�������Ľڵ����Һ��ӣ�����������϶�������ȫ��������ֱ�ӷ���false��
���������ǰ�����ڵ㲻�����Һ���ȫ��1.ȫû��2.ֻ������ ��ô֮��������Ľڵ���붼ΪҶ�ӽڵ㣬���򷵻�false��
�������������û�з���false����������󷵻�true Ϊ��ȫ��������
*/        

package nowcoder;

import java.util.LinkedList;
import java.util.Queue;

public class IsCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	
	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;  //leafΪ�棬���֮������Ľڵ����������Һ��ӷ���false��������ȫ������
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {       //�ڵ���Һ��Ӳ����ڵĻ���֮������Ľڵ���붼ΪҶ��
				leaf = true;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
   //   head.left.left.left = new Node(3);       ��ʱ��Ϊ��ȫ������   


	
		System.out.println(isCBT(head));

	}
}