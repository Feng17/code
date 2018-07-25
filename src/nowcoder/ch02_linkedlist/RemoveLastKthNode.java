package nowcoder.ch02_linkedlist;

/**
 * 删除单链表中倒数第K个节点
 * 思路：从链表头节点开始移动，没经过一个节点K的值就减1。例如链表 1 2 3，K=2，要删除2这个节点，经过的节点为1->2->3，K的变化为1 0 -1。
 * 如果K值等于0，要删除的倒数第K个的节点为头结点，则返回头结点的下一个节点，让其作为新的头结点；如果K的值小于0，就重新从头结点开始遍历，
 * 每经过一个节点K的值就加1，当K的值等于0时移动停止，移动到的节点就是要删除节点的前一个节点，将此节点与要删除节点的下一个节点相连，达到删除目的。
 */
public class RemoveLastKthNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeLastKthNode(Node head, int lastKth) {
        //如果链表为空或者K值小于1直接返回
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        //遍历链表，没经过一个节点使K值减1
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        printLinkedList(head); //Linked List: 1 2 3 4 5
        head = removeLastKthNode(head, 3);
        printLinkedList(head); //Linked List: 1 2 4 5
    }
}