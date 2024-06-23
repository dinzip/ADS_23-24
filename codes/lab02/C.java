package lab02;

import java.util.Scanner;

public class C {
    private ListNode head;
    private ListNode tail;
    private int length;

    public class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public C() {
        head = null;
        tail = null;
        length = 0;
    }

    public void insertEnd(int val) {
        ListNode node = new ListNode(val);
        if(head == null) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        length++;
    }

    public void displayForward() {
        ListNode current = head;
        while(current != null ){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void displayBackward() {
        ListNode current = tail;
        while(current != null ){
            System.out.print(current.data + " ");
            current = current.previous;
        }
    }

    public void removeSecondElements() {
        ListNode current = head;
        while(current != null && current.next != null) {
            current.next = current.next.next;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        C dll = new C();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            dll.insertEnd(sc.nextInt());
        }
        dll.removeSecondElements();

        dll.displayForward();
    }

}
