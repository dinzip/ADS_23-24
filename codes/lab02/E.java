package lab02;

import java.util.Scanner;

public class E {
    private ListNode head;
    private ListNode tail;
    private int length;

    public class ListNode {
        private String data;
        private ListNode next;
        private ListNode previous;

        public ListNode(String data) {
            this.data = data;
        }
    }

    public E() {
        head = null;
        tail = null;
        length = 0;
    }

    public void insertEnd(String val) {
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

    public void insertEndwithoutDuplicate(String val) {
        ListNode node = new ListNode(val);
        if(head == null) {
            head = node;
            tail = node;
            length++;
        } else if(!tail.data.equals(node.data)) {
            tail.next = node;
            node.previous = tail;
            tail = node;
            length++;
        }

//        if(tail.data != node.data) {
//            tail = node;
//            length++;
//        }

    }

    public void display(ListNode current) {
        while(current != null ){
            System.out.print(current.data + " ");
            current = current.next;
        }
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
            System.out.println(current.data + " ");
            current = current.previous;
        }
    }


    public static void main(String[] args) {
        E dll = new E();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            dll.insertEndwithoutDuplicate(sc.next());
        }
        System.out.println("All in all: " + dll.length);
        System.out.println("Students:");
        dll.displayBackward();
    }

}

