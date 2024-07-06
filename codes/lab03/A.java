package lab03;
import java.util.Scanner;

public class A {

    public void display(int[][] arr, int n, int m) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int row(int[][] arr, int n, int val) {
        int low = 0;
        int high = n - 1;
        if(val >= arr[0][0]) return 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid][0] == val)
                return mid;
            else if(val > arr[mid][0] && val < arr[mid-1][0])
                return mid;

            if(arr[mid][0] > val)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }

    public int column(int[][] arr, int row, int m, int val) {
        int low = 0;
        int high = m - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[row][mid] == val)
                return mid;
            if(arr[row][mid] < val)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        A task = new A();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] queries = new int[t];
        for(int i = 0; i < t; i++)
            queries[i] = sc.nextInt();

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            if(i%2 == 1)
                for(int j = 0; j < m; j++)
                    arr[i][j] = sc.nextInt();
            else
                for(int j = m-1; j >= 0; j--)
                    arr[i][j] = sc.nextInt();
        }

        task.display(arr, n, m);
        for(int i : queries) {
            int row = task.row(arr, n, i);
            int col = task.column(arr, row, m, i);
            if(col != -1 && row % 2 == 0)
                col = m - col - 1;

            if(col == -1)
                System.out.println(-1);
            else
                System.out.println(row + " " + col);
        }
        sc.close();
    }
}
