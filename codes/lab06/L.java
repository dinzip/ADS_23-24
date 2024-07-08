package lab06;

import java.util.Scanner;

public class L {

    public static class pair {
        int data;
        int id;

        public pair(int data, int id) {
            this.data = data;
            this.id = id;
        }
    }


    public void quickSort(pair[] arr, int low, int high) {
        if(low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private int partition(pair[] arr, int low, int high) {
        int pivot = arr[high].data;
        int j = low;

        for(int i = low; i <= high; i++)
            if(arr[i].data <= pivot) {
                swap(arr, i, j);
                j++;
            }
        return j - 1;
    }

    private void swap(pair[] arr, int i, int j) {
        pair temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void solve(pair[] arr, int n) {
        if(n == 1) {
            System.out.println(arr[0].id);
            return ;
        }

        int lastnum = -1;
        for(int i = 0; i < n - 1; i++) {
            if(arr[i].data != lastnum && arr[i].data != arr[i + 1].data) {
                System.out.println(arr[i].id);
                return ;
            }
            lastnum = arr[i].data;
        }

        if(arr[n - 1].data != arr[n - 2].data)
            System.out.println(arr[n - 1].id);
        else
            System.out.println("ZA WARUDO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L qs = new L();
        int t = sc.nextInt();

        for(int l = 0; l < t; l++) {
            int n = sc.nextInt();
            pair[] arr = new pair[n];
            for(int i = 0; i < n; i++)
                arr[i] = new pair(sc.nextInt(), i + 1);

            qs.quickSort(arr, 0, n - 1);
            qs.solve(arr, n);
        }
        sc.close();
    }
}
