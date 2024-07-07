package lab06;

import java.util.Scanner;

public class A {

    public void quickSort(char[] arr, int low, int high) {
        if(low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public int partition(char[] arr, int low, int high) {
        char pivot = arr[high];
        boolean firstVowel = isVowel(pivot);

        int i = low, j = low;
        while(i <= high) {
            boolean secondVowel = isVowel(arr[i]);
            if (!firstVowel && secondVowel) { // since vowel < consonant
                swap(arr, i, j);
                j++;
            } else if (firstVowel && secondVowel && (int)(arr[i]) <= (int)(pivot)) {
                swap(arr, i, j);
                j++;
            } else if (!firstVowel && !secondVowel && (int)(arr[i]) <= (int)(pivot)) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        return j - 1;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public void display(char[] arr) {
        for(char c : arr)
            System.out.print(c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A qs = new A();

        int n = sc.nextInt();
        String s = sc.next();
        char[] arr = s.toCharArray();

        qs.quickSort(arr, 0, n - 1);
        qs.display(arr);
        sc.close();
    }
}
