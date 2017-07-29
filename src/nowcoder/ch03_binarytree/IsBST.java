package nowcoder.ch03_binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断二叉树是否为搜索二叉树
 *
 * 方法一：看二叉树在中序遍历下节点值是否是递增的，如果不是递增则不是BST。
 * 方法二：层次遍历二叉树，若出队列的结点小于左结点的值，或者是大于右结点的值，则不是BST，否则是BST
*/

public class IsBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
            Stack<Node> stack = new Stack<Node>();
            Node p = null;
            while (!stack.isEmpty() || head != null) {
                if (head != null) {    //将左边界全部压进栈
                    stack.push(head);
                    head = head.left;
                } else {       //最左边界没有值了开始弹出
                    head = stack.pop();
                    if (p != null && head.value < p.value) return false;
                    p = head;  //保存上一次弹出节点
                    head = head.right;  //head向弹出节点的右方向移动
                }
            }
            return true;


    }
    public static boolean isBST2(Node head){
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        while (!queue.isEmpty()){
            head=queue.poll();
            if (head.left!=null){
                if (head.value<head.left.value) return false;
                else queue.offer(head.left);
            }
            if (head.right!=null){
                if (head.value>head.right.value) return false;
                else queue.offer(head.right);
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

        System.out.println(isBST(head));
        System.out.println(isBST2(head));

    }
}