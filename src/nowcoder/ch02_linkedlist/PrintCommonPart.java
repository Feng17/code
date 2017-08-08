package nowcoder.ch02_linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有两个升序链表，且链表中均无重复元素,给定两个链表的头指针headA和headB,返回一个数组，元素为两个链表的公共部分
 * {2 3 5 6},{1 2 5 7 8} 返回[2,5]
 *
 * 从两个链表的头开始进行判断
 * 1.如果当前headA的值小于headB,则headA往后移动。
 * 2.如果headB的值小于headA,则headB往后移动。
 * 3.如果headA的值与headB的值相等，就打印这个值，然后headA与headB都向后移动。
 *   如果headA与headB有任何一个移动到null，整个过程停止。
 */
public class PrintCommonPart {

    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }


    public static int[] findCommonPart(Node headA, Node headB) {
        if (headA == null||headB == null){
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        while (headA != null&& headB != null){
            if (headA.value < headB.value){
                headA = headA.next;
            }else if (headA.value > headB.value){
                headB = headB.next;
            }else{
                list.add(headA.value);
                headA = headA.next;
                headB = headB.next;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0;i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;


    }

    public static void printLinkedList(Node node) { //打印链表结构
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);  //Linked List: 2 3 5 6
        printLinkedList(node2);  //Linked List: 1 2 5 7 8
        System.out.println("Common Part:"+Arrays.toString(findCommonPart(node1,node2))); //Common Part: [2 5]

    }

}
