package lab07;

import java.util.Scanner;

public class E {

    public static class Row {
        private int[] rowi;
        private int sz;
        private long sum;

        public Row(int m) {
            this.sz = m;
            this.rowi = new int[m];
            this.sum = 0;
        }

        public void take(Scanner sc) {
            for(int i = 0; i < sz; i++) {
                rowi[i] = sc.nextInt();
                sum += (long)(rowi[i]);
            }
        }

        public void print() {
            for(int i = 0; i < sz; i++)
                System.out.print(rowi[i] + " ");
            System.out.println();
        }

        public boolean compare(Row b) {
            for(int i = 0; i < sz; i++) {
                if (this.rowi[i] < b.rowi[i])
                    return true;
                else if (this.rowi[i] > b.rowi[i])
                    return false;
            }
            return true;
        }
    }

    public void merge(Row[] arr, Row[] temp, int low, int mid, int high) {
        for(int i = low; i <= high; i++)
            temp[i] = arr[i];

        int i = low, j = mid + 1, k = low;
        while(i <= mid || j <= high) {
            if(j > high)
                arr[k++] = temp[i++];
            else if(i > mid)
                arr[k++] = temp[j++];
            else if(temp[i].sum > temp[j].sum)
                arr[k++] = temp[i++];
            else if(temp[i].sum == temp[j].sum && temp[i].compare(temp[j]))
                arr[k++] = temp[i++];
            else
                arr[k++] = temp[j++];
        }
    }

    public void mergeSort(Row[] arr, Row[] temp, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        E ms = new E();

        int n = sc.nextInt();
        int m = sc.nextInt();

        Row[] arr = new Row[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Row(m);
            arr[i].take(sc);
        }
        sc.close();

        ms.mergeSort(arr, new Row[n], 0, n - 1);
        // Result:
        for(Row row : arr)
            row.print();
    }
}
