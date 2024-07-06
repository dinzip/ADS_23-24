package lab03;

import java.util.Arrays;
import java.util.Scanner;

public class CD {

    public static int upperBound(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > val)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high;
    }

    public static int lowerBound(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] < val)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static int getAnswer(int[] arr, int l, int r) {
        int res = upperBound(arr, r) - lowerBound(arr, l) + 1;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);

        for(int i = 0; i < q; i++) {
            int[] cord = new int[4];
            for(int j = 0; j < 4; j++)
                cord[j] = sc.nextInt();
            if(cord[0] > cord[2]) {
                int tp = cord[0];
                cord[0] = cord[2];
                cord[2] = tp;
                tp = cord[1];
                cord[1] = cord[3];
                cord[3] = tp;
            }
            if(cord[1] >= cord[2]) {
                if(cord[0] <= cord[2])
                    System.out.println(getAnswer(arr, cord[0], Math.max(cord[1], cord[3])));
                else
                    System.out.println(getAnswer(arr, cord[2], Math.max(cord[1], cord[3])));
            } else {
                System.out.println(getAnswer(arr, cord[0], cord[1]) + getAnswer(arr, cord[2], cord[3]));
            }
        }
        sc.close();
    }
}
