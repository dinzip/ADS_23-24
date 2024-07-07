package lab07;

import java.util.Scanner;

public class A {

    public void display(String[] arr) {
        for(String i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public String[] resize(String[] arr,int capacity) {
        String[] temp = new String[capacity];
        for(int i = 0; i < capacity; i++)
            temp[i] = arr[i];
        return temp;
    }

    public void merge(String[] arr, String[] temp, int low, int mid, int high) {
        for(int i = low; i <= high; i++)
            temp[i] = arr[i];

        int i = low, j = mid + 1, k = low;
        while(i <= mid || j <= high) {
            if(j > high || (i <= mid && temp[i].length() <= temp[j].length()))
                arr[k++] = temp[i++];
            else
                arr[k++] = temp[j++];
        }
    }

    public void mergeSort(String[] arr, String[] temp, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp,mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    public static void main(String[] args) {
        A ms = new A();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String[] arr = new String[55];
            int k = 0;
            String s = sc.nextLine();
            Scanner line = new Scanner(s);
            while(line.hasNext())
                arr[k++] = line.next();
            line.close();
            arr = ms.resize(arr, k);
            ms.mergeSort(arr, new String[k], 0, k - 1);
            ms.display(arr);
        }
        sc.close();
    }
}
