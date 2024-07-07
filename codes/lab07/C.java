package lab07;

import java.util.Scanner;

public class C {

    public void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for(int i = low; i <= high; i++)
            temp[i] = arr[i];

        int i = low, j = mid + 1, k = low;
        while(i <= mid || j <= high) {
            if(j > high || (i <= mid && temp[i] <= temp[j]))
                arr[k++] = temp[i++];
            else
                arr[k++] = temp[j++];
        }
    }

    public void mergeSort(int[] arr, int[] temp, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
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
        C ms = new C();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        for(int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        sc.close();

        ms.mergeSort(arr1, new int[n], 0, n - 1);
        ms.mergeSort(arr2, new int[m], 0, m - 1);

        ms.solve(arr1, n, arr2, m);
    }
}
