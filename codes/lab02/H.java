package lab02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H {
    public static void main(String[] args)  throws IOException{

        class Node {
            int val;
            Node next;
            Node(int x, Node next){ this.val = x; this.next = next; }
            Node(int x){ this(x, null); }
            Node(Node next){ this(0, next); }
            Node(){ this(0, null); }
        }

        class Solution {

            Node insert(Node head, Node node, int pos){
                if(head == null) {
                    head = node;
                    return head;
                } else if(pos == 0) {
                    node.next = head;
                    head = node;
                    return head;
                }
                Node prev = head;
                int count = 0;
                while(count < pos-1) {
                    prev = prev.next;
                    count++;
                }
                node.next = prev.next;
                prev.next = node;
                return head;
            }
            Node remove (Node head, int pos){
                if(head == null) {
                    return head;
                } else if(pos == 0) {
                    Node need = head.next;
                    head.next = null;
                    return need;
                }
                Node prev = head;
                int count = 0;
                while(count < pos-1) {
                    prev = prev.next;
                    count++;
                }
                prev.next = prev.next.next;
                return head;
            }
            void print(Node head){
                if(head == null) {
                    System.out.println(-1);
                    return ;
                }
                Node current = head;
                while(current != null) {
                    System.out.print(current.val + " ");
                    current = current.next;
                }
                System.out.println();
            }
            Node replace(Node head, int pos1, int pos2){
                if(head == null || pos1 == pos2) {
                    return head;
                } else if(head.next == null) {
                    return head;
                }
                Node need = head;
                if(pos1 == 0) {
                    head = head.next;
                } else {
                    Node prev = head;
                    int count = 0;
                    while(count < pos1-1) {
                        prev = prev.next;
                        count++;
                    }
                    need = prev.next;
                    prev.next = prev.next.next;
                }
                head = insert(head, need, pos2);
                return head;
            }
            Node reverse(Node head) {
                if(head == null) return head;
                if(head.next == null) return head;
                Node current = head.next;
                Node previous = head;

                previous.next = null;

                while(current != null) {
                    Node copy = current.next;
                    current.next = previous;
                    previous = current;
                    current = copy;
                }
                return previous;
            }
            Node cyclic_left(Node head, int x){
                if(x == 0) return head;
                Node node = head;
                int count  = 0;
                while(count < x-1) {
                    node = node.next;
                    count++;
                }
                Node last = node;
                Node st = node.next;
                while(last.next != null) {
                    last = last.next;
                }
                node.next = null;
                last.next = head;
                head = st;
                return head;
            }
            Node cyclic_right(Node head, int x){
                if(x == 0) return head;
                Node node = head;
                int length = 0;
                while(node != null) {
                    node = node.next;
                    length++;
                }
                return cyclic_left(head, length - x);
            }
        }

        Node head = null;
        Solution solution = new Solution();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        while (true){
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken());
            if (x == 0){
                break;
            }else if(x == 1){
                int val = Integer.parseInt(tk.nextToken());
                int pos = Integer.parseInt(tk.nextToken());
                head = solution.insert(head, new Node(val), pos);
            }else if(x == 2){
                int pos = Integer.parseInt(tk.nextToken());
                head = solution.remove(head, pos);
            }else if(x == 3){
                solution.print(head);
            }else if (x == 4){
                int pos1 = Integer.parseInt(tk.nextToken());
                int pos2 = Integer.parseInt(tk.nextToken());
                head = solution.replace(head, pos1, pos2);
            }else if (x == 5){
                head = solution.reverse(head);
            }else if (x == 6){
                int y = Integer.parseInt(tk.nextToken());
                head = solution.cyclic_left(head, y);
            }else if (x == 7){
                int y = Integer.parseInt(tk.nextToken());
                head = solution.cyclic_right(head, y);
            }
        }
    }
}
