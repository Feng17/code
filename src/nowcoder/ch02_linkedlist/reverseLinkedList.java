package nowcoder.ch02_linkedlist;

/**
 * 反转单链表
 * 思路：使用遍历反转法，从头节点开始遍历，依次让当前节点的next指针指向前一个节点，在反转当前结点指针指向前，先把当前结点下一节点用tmp临时保存，为之后的的循环遍历使用。
 */
public class reverseLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reverse(Node head) {
        Node pre = null;
        while (head != null) {  // 当前结点为null时，说明位于尾结点
            Node tmp = head.next; //临时结点，保存当前结点的下一结点
            head.next = pre; //更改当前节点的指针指向上一结点pre，实现反转

            pre = head;
            head = tmp;
        }
        return pre; //返回反转后链表的新的头节点
    }


    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head); //Linked List: 1 2 3
        head = reverse(head);
        printLinkedList(head); //Linked List: 3 2 1


    }

}



