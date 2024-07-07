package lab06;

import java.util.Scanner;

public class C {

    long min_diff;

    public C() {
        min_diff = Long.MAX_VALUE;
    }

    public void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int j = low;
        for(int i = low; i <= high; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                j++;
            }

            if(i != high && Math.abs((long)(pivot) - (long)(arr[i])) < min_diff)
                min_diff = Math.abs((long)(pivot) - (long)(arr[i]));
        }

        return j - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void solve(int[] arr, int n) {
        for(int i = 0; i < n - 1; i++) {
            if(Math.abs((long)(arr[i + 1]) - (long)(arr[i])) == min_diff)
                System.out.print(arr[i] + " " + arr[i + 1] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C qs = new C();

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();

        qs.quickSort(arr, 0, n - 1);

        qs.solve(arr, n);
    }
}
