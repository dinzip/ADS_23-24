package lab05;

import java.util.Scanner;

public class C {
    private Integer[] heap;
    private int n;

    public C(int capacity) {
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
        if(m == 1) {
            long a = getMax();
            sum += a * (a + 1) / 2 - ((a - k) * (a - k + 1) / 2);
            return sum;
        }
        long a = deleteMax();
        long b = deleteMax();
        if((a - b) >= k) {
            sum += a * (a + 1) / 2 - ((a - k) * (a - k + 1) / 2);
            return sum;
        } else {
            sum += a * (a + 1) / 2 - (b * (b + 1) / 2);
            k -= (a - b);
        }
        long coef = 1;
        while(k > 0) {
            coef++;
            a = b;
            b = deleteMax();
            if(coef * (a - b) <= k) {
                sum += coef * (a * (a + 1) / 2 - (b * (b + 1) / 2));
                k -= coef * (a - b);
            } else { // remaining part:
                long nd = k / coef; // need coef for equal distribution
                sum += coef * (a * (a + 1) / 2 - ((a - nd) * (a - nd + 1) / 2));
                k %= coef;
                sum += k * (a - nd);
                break;
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        C pq = new C(4);
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int k = sc.nextInt();
        pq.insert(0);
        for(int i = 0; i < m; i++)
            pq.insert(sc.nextInt());

        System.out.println(pq.solve(m, k));
    }
}

/*
a b c d
such that a > b > c > d

a-b tickets, give: sum1 = a*(a+1)/2 - b*(b+1)/2

a-b + 2*(b-c) tickets, give: sum2 = sum1 + 2 * (b*(b+1/2) - c*(c+1)/2)
a-b + 2*(b-c) + 3*(c-d) tickets, give: sum3 = sum2 + 3 * (c*(c+1/2) - d*(d+1)/2)

 */