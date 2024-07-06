package lab03;

import java.util.Scanner;

public class H {

    public static int upperBound(int[] arr, int n, int key) {
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] < key )
                low = mid + 1;
            else
                high = mid - 1;
        }
        if(low >= n-1)
            return n - 1;
        else if(key <= arr[low])
            return low;
        else
            return low + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n + 1];
        arr[0] = sc.nextInt();
        for(int i = 1; i < n; i++)
            arr[i] = arr[i - 1] + sc.nextInt();

        for(int i = 0; i < q; i++)
            System.out.println(upperBound(arr, n, sc.nextInt()) + 1);
        sc.close();
    }
}
