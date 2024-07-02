package lab02;

// Doubly Linked List

import java.util.List;
import java.util.Scanner;

public class B {
    private ListNode head;
    private ListNode tail;
    private int length;

    public class ListNode {
        private String data;
        private ListNode next;
        private ListNode previous;

        public ListNode (String data) {
            this.data = data;
        }
    }

    public B() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void displayForward() {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public void insertEnd(String val) {
        ListNode node = new ListNode(val);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        length++;
    }

    public void shift(int k) {
        while(k > 0) {
            tail.next = head;
            tail = head;
            head = head.next;
            k--;
        }
        tail.next = null;
    }

    public static void main(String[] args) {
        B dll = new B();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            dll.insertEnd(str);
        }
        dll.shift(k);
        dll.displayForward();
        sc.close();
    }
}
