package nowcoder.ch02_linkedlist;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * 方法一：使用栈结构实现，从左到右遍历链表并依次将节点压入栈中，在遍历完成后从栈顶到栈底的元素顺序
 * 应与原链表中的顺序相反。如果一个链表是回文结构，逆序之后节点的顺序还是一样的。将栈中元素以此弹出
 * 并与原链表中的顺序相比较，如果不是回文结构则顺序对不上。
 */
public class IsPalindrome {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPalindrome(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(" " + isPalindrome(head)); //Linked List: 1 2 3  false
        System.out.println();
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(1);
        printLinkedList(head1);
        System.out.print(" " + isPalindrome(head1)); //Linked List: 1 2 2 1  true
    }

}
