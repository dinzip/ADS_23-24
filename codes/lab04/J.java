package lab04;

import java.util.Scanner;
import java.util.Arrays;

public class J {

    public static void solve(int[] arr, int id, int coef) {
        if(id < 1)
            return;

        System.out.print(arr[id] + " ");
        if(coef < 1)
            return;
        solve(arr, id - coef, coef/2);
        solve(arr, id + coef, coef/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = (1<<n);
        int[] arr = new int[size];
        for(int i = 1; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        solve(arr, (1<<(n-1)), (1<<(n-2)));
    }
}
