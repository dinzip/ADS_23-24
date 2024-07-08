package lab06;

import java.util.Scanner;

public class E {

    public void quickSort(int[][] arr, int col, int low, int high) {
        if(low < high) {
            int p = partition(arr, col, low, high);
            quickSort(arr, col, low, p - 1);
            quickSort(arr, col, p + 1, high);
        }
    }

    private int partition(int[][] arr, int col, int low, int high) {
        int pivot = arr[high][col];
        int j = low;

        for(int i = low; i <= high; i++) {
            if(arr[i][col] >= pivot) {
                swap(arr, col, i, j);
                j++;
            }
        }
        return j - 1;
    }

    private void swap(int[][] arr, int col, int i, int j) {
        int temp = arr[i][col];
        arr[i][col] = arr[j][col];
        arr[j][col] = temp;
    }

    public void display(int[][] arr) {
        for(int[] row : arr) {
            for(int el : row)
                System.out.print(el + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        E qs = new E();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();

        for(int col = 0; col < m; col++)
            qs.quickSort(arr, col, 0, n - 1);

        qs.display(arr);
        sc.close();
    }
}
