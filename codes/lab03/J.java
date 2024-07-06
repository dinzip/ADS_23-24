package lab03;

import java.util.Scanner;

public class J {

    public static boolean check(int[] arr, int H, int K) {
        int count = 0;
        for(int i : arr) {
            count += i/K;
            if(i%K > 0) count++;
        }
        return count <= H;
    }

    public static int BinarySearchSpeed(int[] arr, int n, int h, int max) {
        int low = 0;
        int high = max;

        int res = high;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(check(arr, h, mid)) {
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
        int h = sc.nextInt();

        int[] arr = new int[n];
        int max = 1;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > max)
                max = arr[i];
        }

        System.out.println(BinarySearchSpeed(arr, n, h, max));
        sc.close();
    }
}
