package lab02;

import java.util.List;
import java.util.Scanner;

public class F {
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

    public F() {
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

    public void insertPosition(int val, int id, int n) {
        ListNode node = new ListNode(val);
        if(id >= n) {
            tail.next = node;
            node.previous = tail;
            tail = node;
            return ;
        } else if(id == 0) {
            node.next = head;
            head.previous = node;
            head = node;
            return ;
        }

        ListNode current = head;
        int count = 0;
        while(count < id - 1) {
            current = current.next;
            count++;
        }
        node.next = current.next;
        current.next.previous = node;
        current.next = node;
        node.previous = current;
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
            System.out.print(current.data + " ");
            current = current.previous;
        }
    }

    public ListNode giveModes() {
        int sz = 1000 + 10, mx_occur = -1, num_mx = 0;
        int[] arr = new int[sz];
        ListNode current = head;
        while(current != null) {
            arr[current.data]++;
            if(arr[current.data] > mx_occur) {
                mx_occur = arr[current.data];
            }
            current = current.next;
        }

        ListNode base = new ListNode(0);
        ListNode res = base;
        for(int i = sz - 1; i >= 1; i--) {
            if(arr[i] == mx_occur) {
                res.next = new ListNode(i);
                res = res.next;
            }
        }

        return base.next;
    }

    public static void main(String[] args) {
        F dll = new F();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            dll.insertEnd(sc.nextInt());
        }
        int value = sc.nextInt();
        int id = sc.nextInt();

        dll.insertPosition(value, id, n);
        dll.displayForward();
    }

}

