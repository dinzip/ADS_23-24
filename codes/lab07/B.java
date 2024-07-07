package lab07;

import java.util.Scanner;

public class B {

    public void display(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public int[] merge(int[] a, int n, int[] b, int m) {
        int[] res = new int[n + m];

        int i = 0, j = 0, k = 0;
        while(i < n || j < m) {
            if(j >= m || (i < n && a[i] <= b[j]))
                res[k++] = a[i++];
            else
                res[k++] = b[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        B ms = new B();

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        sc.close();

        int[] res = ms.merge(arr1, n, arr2, m);

        ms.display(res);
    }
}
