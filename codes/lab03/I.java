package lab03;

import java.util.Scanner;

public class I {

    public static boolean BinarySearchElement(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == key)
                return true;
            if(arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println( ( BinarySearchElement(arr, sc.nextInt()) ? "Yes" : "No" ) );
        sc.close();
    }
}
