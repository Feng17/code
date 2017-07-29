package nowcoder.ch03_binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历 递归和非递归实现
 */
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
    //思路：在栈里先压进头节点，弹出打印后按右子树先压入(不为空时)再将左子树后压入(不为空)的顺序，不断重复此步骤直到栈为空
    public static void preOrderUnRecur(Node head) {
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

    //后序遍历的顺序是先左再右再中，按先序遍历的先中再左再右的思路，实现先中再右再左
    //使用两个栈，这时弹出时不打印，将弹出的节点放到另一个栈中，这样另一个栈弹出时就实现了先左再右再中的顺序
    public static void posOrderUnRecur1(Node head) {
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



    //层序遍历 每一层都是从左到右的遍历，借助队列实现
    public static void sequence(Node head){
        if (head != null) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                System.out.print(head.value + " ");
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);


        //递归遍历
        System.out.println("=============递归遍历=============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println(); //4 2 1 3 6 5 7

        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println(); //1 2 3 4 5 6 7

        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println(); //1 3 2 5 7 6 4

        // 非递归遍历
        System.out.println("============非递归遍历============");
        System.out.print("pre-order: ");
        preOrderUnRecur(head);

        System.out.print("in-order: ");
        inOrderUnRecur(head);

        System.out.print("pos-order: ");
        posOrderUnRecur1(head);

        System.out.print("sequence-order: ");
        sequence(head);


    }

}
