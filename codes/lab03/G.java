package lab03;

import java.util.Arrays;
import java.util.Scanner;

public class G {

    public static boolean check(int[] arr, int f, int capacity) {
        int count = 0;
        for(int i : arr) {
            count += i/capacity;
            if(i%capacity > 0) count++;
        }
        return count <= f;
    }

    public static int BinarySearchCapacity(int[] arr, int n, int f) {
        int low = 1;
        int high = arr[n - 1];

        int res = high;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(check(arr, f, mid)) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        System.out.println(BinarySearchCapacity(arr, n, f));
        sc.close();
    }
}
