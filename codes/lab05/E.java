package lab05;
// Min heap
import java.util.Scanner;

public class E {
    private Long[] heap;
    private int n;
    private long sum;

    public E(int capacity) {
        heap = new Long[capacity];
        n = 0;
        sum = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int capacity) {
        Long[] temp = new Long[capacity];
        for(int i = 0; i < Math.min(heap.length, capacity); i++)
            temp[i] = heap[i];
        heap = temp;
    }

    public void swap(int a, int b) {
        long temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void insert(long val) {
        if(n == heap.length - 1) {
            resize(2 * heap.length);
        }
        n++;
        heap[n] = val;
        swim(n);
    }

    public void swim(int k) {
        while(k > 1 && heap[k/2] > heap[k]) {
            swap(k/2, k);
            k /= 2;
        }
    }

    public long deleteMin() {
        if(isEmpty())
            return 0;
        long min = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n + 1] = null;
        if(n > 0 && (n == (heap.length - 1)/4)) {
            resize(heap.length/2);
        }
        return min;
    }

    public void sink(int k) {
        while(2 * k <= n) {
            int j = 2 * k;
            if(j < n && heap[j+1] < heap[j]) {
                j++;
            }
            if(heap[k] <= heap[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    public void display() {
//        System.out.print("DISPLAY: ");
        for(int i = 1; i <= n; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }

    public long getMin() {
        if(isEmpty())
            return 0;
        else
            return heap[1];
    }

    public void solve(Scanner sc, int q, int k) {
        for(int i = 0; i < q; i++) {
            String s = sc.next();
            if(s.equals("print"))
                System.out.println(sum);
            else {
                long x = sc.nextInt();
                if(n == k && getMin() < x) {
                    sum -= deleteMin();
                    sum += x;
                    insert(x);
                } else if(n < k) {
                    sum += x;
                    insert(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        E pq = new E(4);
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int k = sc.nextInt();

        pq.solve(sc, q, k);

    }
}
