package nowcoder.ch02_linkedlist;

/**
 * 环形单链表的约瑟夫问题 有n个数，每走过m个数就删除一个数
 * 思路：在环形单链表中遍历每个节点，不断让每个数报数，当报数为m时就删除当前报数的节点，之后将剩下的节点重新连成环形链表
 * 继续让每个数报数和删除直到环形链表中只剩一个节点。
 */

public class JosephusProblem {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node josephus(Node head, int m) {
        //如果链表为空或者链表只有一个节点或者m小于1则直接返回
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            ++count;
            if (count == m) {
                last.next = head.next; //删除节点
                count = 0;
            } else {
                last=last.next;
            }
            head = last.next;
        }
        return head;
    }
    public static void printCircularList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head;
        printCircularList(head); //1 2 3 4 5 -> 1
        head = josephus(head, 3);
        printCircularList(head); //4 -> 4
    }

}
