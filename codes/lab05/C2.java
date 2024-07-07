package lab05;

import java.util.Scanner;

public class C2 {
    private Integer[] heap;
    private int n;

    public C2(int capacity) {
        heap = new Integer[capacity+1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i=0; i<Math.min(heap.length, capacity); i++) temp[i] = heap[i];
        heap = temp;
    }

    public void insert(int val) {
        if(n == heap.length - 1) {
            resize(heap.length *  2);
        }
        heap[++n] = val;
        swim(n);
    }

    public void swim(int k) {
        while(k > 1 && heap[k/2] < heap[k]) {
            swap(k, k/2);
            k /= 2;
        }
    }

    public int deleteMax() {
        if(n == 0)
            return 0;
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n+1] = null;

        if(n > 0 && (n == (heap.length - 1)/4)) {
            resize(heap.length/2);
        }
        return max;
    }

    public void sink(int k) {
        while(2 * k <= n) {
            int j = k * 2;
            if(j < n && (heap[j] < heap[j+1])) {
                j++;
            }
            if(heap[k] >= heap[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public int getMax() {
        if(isEmpty())
            return 0;
        else
            return heap[1];
    }

    public void display() {
        System.out.print("DISPLAY: ");
        for(int i = 1; i <= n; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }

    public long solve(int m, int k) {
        long sum = 0L;
        while(k > 0) {
            long mx = deleteMax();
            sum += mx--;
            k--;
            if(mx > 0)
                insert((int)(mx));
        }
        return sum;
    }

    public static void main(String[] args) {
        C2 pq = new C2(4);
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0; i < m; i++)
            pq.insert(sc.nextInt());

        System.out.println(pq.solve(m, k));
        sc.close();
    }
}
