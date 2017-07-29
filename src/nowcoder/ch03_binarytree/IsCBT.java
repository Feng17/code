package nowcoder.ch03_binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否为完全二叉树
 *
 * 思路：层序遍历二叉树，如果当前遍历到的节点有右孩子，但无左孩子则肯定不是完全二叉树，直接返回false；
 * 否则如果当前遍历节点不是左右孩子全有：1.全没有2.只有左孩子，那么之后遍历到的节点必须都为叶子节点，否则返回false；
 * 如果遍历过程中没有返回false则遍历结束后返回true 为完全二叉树。
 */

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
                return false;  //leaf为真，如果之后遍历的节点出现有左或右孩子返回false，不是完全二叉树
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {       //节点的右孩子不存在的话，之后遍历的节点必须都为叶子
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
        //   head.left.left.left = new Node(3);       此时则不为完全二叉树



        System.out.println(isCBT(head));

    }
}