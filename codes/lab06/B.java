package lab06;

import java.util.Scanner;

public class B {

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
        for(int i = low; i <= high; i++)
            if(arr[i] <= pivot) {
                swap(arr, i, j);
                j++;
            }

        return j - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void solve(int[] a, int n, int[] b, int m) {
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(a[i] == b[j]) {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
            else if(a[i] < b[j])
                i++;
            else
                j++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        B qs = new B();

        int n = sc.nextInt(), m = sc.nextInt();

        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        sc.close();
        
        qs.quickSort(arr1, 0, n - 1);
        qs.quickSort(arr2, 0, m - 1);

        qs.solve(arr1, n, arr2, m);
    }
}
