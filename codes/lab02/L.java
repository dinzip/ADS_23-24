package lab02;

import java.util.Scanner;

public class L {
    Node head;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public L() {
        head = null;
    }

    public void insert(int data) {
        Node node = new Node(data);
        if(head != null) {
            node.next = head;
        }
        head = node;
    }

    public void display() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int findMaxSum() {
        int mx = Integer.MIN_VALUE, curr = 0;
        Node current = head;
        while(current != null) {
            if(curr + current.data > 0) {
                curr += current.data;
                mx = Math.max(curr, mx);
            } else {
                curr = 0;
            }

            mx = Math.max(current.data, mx);
            current = current.next;
        }
        return mx;
    }

    public static void main(String[] args) {
        L sll = new L();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n > 0) {
            n--;
            sll.insert(sc.nextInt());
        } // get reversed list

        System.out.println(sll.findMaxSum());
    }
}
