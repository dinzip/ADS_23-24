package lab02;

import java.io.IOException;
import java.util.Scanner;

public class K {
    Node head;
    Node tail;
    int[] arr;
    Node answer;

    public class Node {
        char val;
        Node next;
        Node prev;

        Node(char val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public K() {
        head = null;
        tail = null;
        arr = new int[27];
        answer = null;
    }

    public void insertEnd(char val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    public void make_answer() {
        arr[(int)(tail.val) - 97]++;
        if(answer == null || head == tail) {
            answer = head;
            return;
        }
        while(arr[(int)(answer.val) - 97] > 1 && answer != tail) {
            answer = answer.next;
        }
    }

    public void display_answer() {
        if(arr[(int)(answer.val) - 97] > 1) {
            System.out.print(-1 + " ");
        } else {
            System.out.print(answer.val + " ");
        }
    }

    public void displayForward() {
        Node current = head;
        while(current != null) {
            System.out.println(current.val + " --> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args)  throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            K sll = new K();
            for(int j = 0; j < n; j++) {
                sll.insertEnd(sc.next().charAt(0));
                sll.make_answer();
                sll.display_answer();
            }
            System.out.println();
        }
    }
}