package nowcoder.ch02_linkedlist;

/**
 * 向环形链表中插入新节点，使调整后链表依然有序
 *
 * 思路：1.如果链表为空，则插入结点node自己为环形链表，返回node
 *       2.如果链表不为空，另变量pre为头节点，cur为下一个节点，另pre和cur同步移动下去，如果pre的节点值(pre.value)
 *         小于等于node.value并且cur.value大于等于node.value,则将node节点插入到pre和cur之间；返回头节点即可。
 *       3.如果pre和cur移动了环形链表一圈都没有发现能插入的情况，说明node.value要么比链表中每个节点的值都大，要么都比它们小；
 *         这时node需要插入到头节点前；返回时如果node.value比每个节点值都大，则返回原来头节点，否则将node作为新的头节点返回。
 */
public class InsertNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node insertNode(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node; //链表为空，next指针指向自己
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) { //环绕链表一圈
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }
  //打印环形链表
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

    public static void main(String[] args) {
        Node head = null;
        head = insertNode(head, 2);
        printCircularList(head); // 2 -> 2

        head = insertNode(head, 4);
        printCircularList(head); // 2 4 -> 2

        head = insertNode(head, 1);
        printCircularList(head); //1 2 4 -> 1

        head = insertNode(head, 3);
        printCircularList(head); //1 2 3 4 -> 1


    }

}
