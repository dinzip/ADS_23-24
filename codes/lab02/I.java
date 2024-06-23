package lab02;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class I {

    private ListNode head;
    private ListNode tail;

    public class ListNode {
        private String data;
        private ListNode next;
        private ListNode previous;

        public ListNode(String data) {
            this.data = data;
        }
    }

    public I() {
        this.head = null;
        this.tail = null;
    }

    public void displayForward() {
        if(head == null) return ;
        ListNode temp = head;
        while( temp != null ) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add_front(String value) {
        ListNode newNode = new ListNode(value);
        if(head == null) {
            tail = newNode;
        }
        else {
            head.previous = newNode;
        }

        newNode.next = head;
        head = newNode;
    }

    public void add_back(String value) {
        ListNode newNode = new ListNode(value);
        if(head == null){
            head = newNode;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    public String erase_front() {
        ListNode temp = head;
        if(head == tail){
            tail = null;
        }
        else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        return temp.data;
    }

    public String erase_back() {
        ListNode temp = tail;
        if(head == tail) {
            head = null;
        }
        else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        return temp.data;
    }

    public String front() {
        return head.data;
    }

    public String back() {
        return tail.data;
    }

    public void clear() {
        if(head == null) {
            return ;
        }
        ListNode curr = head.next;
        ListNode prev = head;

        while(curr != null) {
            curr.previous = null;
            prev.next = null;
            prev = curr;
            curr = curr.next;
        }
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        I dll = new I();
        Scanner sc = new Scanner(System.in);
        StringBuilder query = new StringBuilder("");
        while(true) {
            query.replace(0, query.length(), sc.next());
            if(query.toString().equals("exit")) {
                System.out.println("goodbye");
                break;
            } else if(query.toString().equals("add_front")) {
                dll.add_front(sc.next());
                System.out.println("ok");
            } else if(query.toString().equals("add_back")) {
                dll.add_back(sc.next());
                System.out.println("ok");
            } else if(query.toString().equals("erase_front")) {
                if(dll.head == null) {
                    System.out.println("error");
                } else {
                    System.out.println(dll.erase_front());
                }
            } else if(query.toString().equals("erase_back")) {
                if(dll.tail == null) {
                    System.out.println("error");
                } else {
                    System.out.println(dll.erase_back());
                }
            } else if(query.toString().equals("front")) {
                if(dll.head == null) {
                    System.out.println("error");
                } else {
                    System.out.println(dll.front());
                }
            } else if(query.toString().equals("back")) {
                if(dll.tail == null) {
                    System.out.println("error");
                } else {
                    System.out.println(dll.back());
                }
            } else if(query.toString().equals("clear")) {
                dll.clear();
                System.out.println("ok");
            }
//            dll.displayForward();
        }

    }
}
