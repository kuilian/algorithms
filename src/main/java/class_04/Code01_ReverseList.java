package class_04;

import org.w3c.dom.Node;

/**
 * @author Kui Lian
 * @date 2022/7/21 - 10:50
 * @Description:
 */
public class Code01_ReverseList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }

    }

    //单链表反转
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    /**
     * @Date 11:23 2022/7/21
     * @Param [head]
     * @return class_04.Code01_ReverseList.DoubleNode
     * @Description: 反转双链表
    */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        Node node = reverseLinkedList(n1);
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
