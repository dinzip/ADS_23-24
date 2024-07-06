package lab03;

import java.util.Scanner;

public class B {

    public static boolean can(int[] arr, int n, int k, long need) {
        long sum = arr[0];
        int count = 0;
        for(int i = 1; i < n && count <= k; i++) {
            if(arr[i] > need)
                return false;
            if(sum + arr[i] > need) {
                sum = arr[i];
                count++;
            } else
                sum += arr[i];
        }
        count++; // since last sum isn't equal 0
        return count <= k;
    }

    public static long BinarySearchTheSum(int[] arr, int n, int k, int mxel, long mxsum) {
        long low = (long)(mxel);
        long high = mxsum;

        long res = 0;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(can(arr, n, k, mid)) {
                res = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        long mxsum = 0;
        int mxel = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            mxsum += (long)(arr[i]);
            mxel = Math.max(mxel, arr[i]);
        }

        System.out.println(BinarySearchTheSum(arr, n, k, mxel, mxsum));
        sc.close();
    }
}

/*
For binary search minimum sum can be 1 and the maximum sum can be the sum of all the elements.
To check if mid is the maximum subarray sum possible:
 Maintain a count of sub-arrays, include all possible elements in subarray until their sum is less than mid.
 After this evaluation, if the count is less than or equal to K, then mid is achievable else not.
 (Since if the count is less than K, we can further divide any subarray its sum will never increase mid ).
 */