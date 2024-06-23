package lab02;

import java.util.Scanner;

public class A {
    private ListNode head;

    public class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public void insert(int value) {
        ListNode node = new ListNode(value);
        if(head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void display() {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int min(int target) {
        int count = 0, mn_id = 0, mn = Integer.MAX_VALUE;
        ListNode current = head;
        while(current != null) {
            if( Math.abs(current.data - target) <= mn) {
                mn = Math.abs(current.data - target);
                mn_id = count;
            }
            count++;
            current = current.next;
        }
        return mn_id;
    }

    public static void main(String[] args) {
//        File myObj = new File("PPP3.txt");
//        long startTime = System.nanoTime();

        A sll = new A();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            sll.insert(sc.nextInt());
        }
//        sll.display(); // we have reversed list
        int target = sc.nextInt();
        System.out.println(n - sll.min(target) - 1); // since we work with reversed list, n-1-answer

//        long stopTime = System.nanoTime();
//        System.out.println(stopTime - startTime);
    }
}
