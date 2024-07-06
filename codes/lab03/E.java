package lab03;

import java.util.Scanner;
public class E {

    public static boolean check(int[] arr, int n, int k, int len) {
        int count = 0;
        for(int i : arr)
            if(len >= i)
                count++;
        return count >= k;
    }

    public static int BinarySearchLength(int[] arr, int n, int k, int min, int max) {
        int low = min;
        int high = max;

        int res = high;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(check(arr, n, k, mid)) {
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
        int k = sc.nextInt();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] arr = new int[n]; // we save max(x2, y2) since square for (x1,y1,x2,y2) should end in point (max(x2, y2), max(x2, y2)).
        for(int i = 0; i < n; i++) {
            int[] cd = new int[4];
            for(int j = 0; j < 4; j++)
                cd[j] = sc.nextInt();
            arr[i] = Math.max(cd[2], cd[3]);
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.println(BinarySearchLength(arr, n, k, min, max));
        sc.close();
    }
}
