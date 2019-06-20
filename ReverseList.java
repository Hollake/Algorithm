package arithmetic;

import java.util.Stack;

/**
 * Created by Hollake on 2019\6\20 0020 13:38.
 */
class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }
}
public class ReverseList {
    public static void main(String[] args) {
        Node head1 = ReverseList.nodeInit();
        System.out.println("========原始链表========");
        printLinkedList(head1);
        System.out.println("========Stack反转链表========");
        Node res1 = ReverseList.reverseList1(head1);
        printLinkedList(res1);
        System.out.println("========非递归反转链表========");
        Node head2 = ReverseList.nodeInit();
        Node res2 = ReverseList.reverseList2(head2);
        printLinkedList(res2);
        System.out.println("========递归反转链表========");
        Node head3 = ReverseList.nodeInit();
        Node res3 = ReverseList.reverseList3(head3);
        printLinkedList(res3);

    }

//    使用Stack反转链表
    private static Node reverseList1(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while ( cur != null ) {
            stack.push(new Node(cur.value));
            cur = cur.next;
        }
        cur = stack.pop();
        Node newHead = cur;
        while ( !stack.isEmpty() ) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        return newHead;
    }
//    非递归反转链表
    private static Node reverseList2(Node head) {
        Node pre = null;
        Node next = null;
        while ( head != null ) {
            next = head.next;//next保存head下一个节点
            head.next = pre;//将当前节点next指向前一个节点，实现反转
            pre = head;//将当前节点的前节点后移
            head = next;//将当前节点后移
        }
        return pre;
    }
//    递归反转链表
    private static Node reverseList3(Node head) {
        if(head==null||head.next ==null)
            return head;
        Node next = head.next;
        Node prev = reverseList3(next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
//    初始化链表用例
    private static Node nodeInit() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        return head;
    }
//    打印链表
    private static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
