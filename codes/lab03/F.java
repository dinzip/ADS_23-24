package lab03;

import java.util.Arrays;
import java.util.Scanner;

public class F {

    public static int upperBound(int[] arr, int n, int k) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] <= k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        int[] pref = new int[n + 1];
        pref[0] = 0;
        for(int i = 0; i < n; i++)
            pref[i + 1] = pref[i] + arr[i];

        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int p = sc.nextInt();
            int id = upperBound(arr, n, p) + 1;
            System.out.println(id + " " + pref[id]);
        }
        sc.close();
    }
}
