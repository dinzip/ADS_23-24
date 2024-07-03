package lab05;

import java.util.Scanner;

public class D {
    private Integer[] heap;
    private int sz;

    public D(int capacity) {
        heap = new Integer[capacity];
        sz = 0;
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    public int size() {
        return sz;
    }

    public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < Math.min(capacity, heap.length); i++)
            temp[i] = heap[i];
        heap = temp;
    }

    public void insert(int data) {
        if(sz == heap.length - 1)
            resize(2 * heap.length);
        sz++;
        heap[sz] = data;
        swim(sz);
    }

    public void swim(int k) {
        while(k > 1 && heap[k/2] > heap[k]) {
            swap(k/2, k);
            k /= 2;
        }
    }

    public int deleteMin() {
        if(isEmpty())
            return 0;
        int min = heap[1];
        swap(1, sz);
        sz--;
        sink(1);
        heap[sz + 1] = null;
        if(sz > 0 && (sz == (heap.length - 1)/4))
            resize(heap.length/2);
        return min;
    }

    public void sink(int k) {
        while(2 * k <= sz) {
            int j = 2 * k;
            if(j < sz && heap[j + 1] < heap[j])
                j++;
            if(heap[k] <= heap[j])
                break;
            swap(k, j);
            k = j;
        }
    }

    public int getMin() {
        if(isEmpty())
            return 0;
        else
            return heap[1];
    }

    public int solve(int m) {
        int cnt = 0;
        while(getMin() < m) {
            if(size() == 1) {
                return -1;
            }
            int a = deleteMin();
            int b = deleteMin();
            insert(a + 2*b);
            cnt++;
        }
        return cnt;
    }

    public void display() {
//        System.out.print("DISPLAY: ");
        for(int i = 1; i <= sz; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D pq = new D(4);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0; i < n; i++)
            pq.insert(sc.nextInt());

        System.out.println(pq.solve(k));
    }

}
