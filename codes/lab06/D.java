package lab06;

import java.util.Scanner;

public class D {

    public void quickSort(String[] arr, int low, int high) {
        if(low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int j = low;

        for(int i = low; i<= high; i++) {
            if(arr[i].compareTo(pivot) <= 0) {
                swap(arr, i, j);
                j++;
            }
        }
        return j - 1;
    }

    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void display(String[] arr) {
        for(String date : arr)
            System.out.println(date.substring(6, 8) + "-" + date.substring(4, 6) + "-" + date.substring(0, 4));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D qs = new D();
        int n = sc.nextInt();

        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            String date = sc.next();
            String new_date = date.substring(6, 10) + date.substring(3, 5) + date.substring(0, 2);
            arr[i] = new_date; // year + month + day
        }

        qs.quickSort(arr, 0, n - 1);
        qs.display(arr);
        sc.close();
    }
}
