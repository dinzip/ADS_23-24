package lab05;

import java.util.Scanner;

public class B {
    private Integer[] heap;
    private int n;

    public B(int capacity) {
        heap = new Integer[capacity];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < Math.min(capacity, heap.length); i++)
            temp[i] = heap[i];
        heap = temp;
    }

    public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void insert(int data) {
        if(n == heap.length - 1)
            resize(2 * heap.length);
        n++;
        heap[n] = data;
        swim(n);
    }

    public void swim(int k) {
        while(k > 1 && heap[k/2] <  heap[k]) {
            swap(k/2, k);
            k /= 2;
        }
    }

    public int deleteMax() {
        if(isEmpty())
            return 0;
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n + 1] = null;

        if(n > 1 && (n == (heap.length - 1)/2))
            resize(heap.length/2);

        return max;
    }

    public void sink(int k) {
        while(2 * k <= n) {
            int j = 2 * k;
            if(j < n && heap[j] < heap[j + 1])
                j++;
            if(heap[k] >= heap[j])
                break;
            swap(k, j);
            k = j;
        }
    }

    public void display() {
//        System.out.print("DISPLAY: ");
        for(int i = 1; i <= n; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        B pq = new B(4);
        int m = sc.nextInt();
        for(int i = 0; i < m; i++)
            pq.insert(sc.nextInt());

        while(!pq.isEmpty() && pq.n > 1) {
            int y = pq.deleteMax();
            int x = pq.deleteMax();
            if(y == x)
                continue;
            else
                pq.insert(y-x);
        }
        if(pq.isEmpty())
            System.out.println(0);
        else
            System.out.println(pq.deleteMax());
    }
}
