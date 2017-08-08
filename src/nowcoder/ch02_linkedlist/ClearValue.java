package nowcoder.ch02_linkedlist;

/**
 * 给定一个单链表。链表中每个节点保存一个整数，给定头节点head再给定一个值num，把所有等于num的节点删掉
 *
 *  从链表头开始找到第一个值不为num的节点，作为新的头节点；新建cur，pre节点指向新的头节点，然后移动cur继续向后遍历
 *  如果cur节点的值等于num，就将cur节点删除方式是将cur节点前最近一个不等于num的pre节点连接到cur的下一个节点。即pre.next=cur.next;
 *  如果遍历过程中cur节点值不为num就令pre=cur更新最近一个值不等于num节点。
 */

public class ClearValue {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public static Node removeNode(Node head,int num){
        while (head != null){   //找到第一个值不为num的节点，将其作为新的头节点
            if (head.value !=num){
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;
        while(cur!=null){
            if (cur.value == num){ //如果遍历的节点的值等于num，将cur节点删除
                pre.next = cur.next;
            }else{
                pre = cur; //否则pre节点向前移动
            }
            cur = cur.next; //向后遍历
        }
        return head;

    }


    public static void printLinkedList(Node head) { //打印链表结构
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1); //1 1 3 3 1 2 1
        head = removeNode(head, 1);
        printLinkedList(head); //3 3 2

    }


}
