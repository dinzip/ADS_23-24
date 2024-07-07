package lab07;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static final Map<String, Double> grade = new HashMap<>();

    static {
        grade.put("A+", 4.00);
        grade.put("A", 3.75);
        grade.put("B+", 3.50);
        grade.put("B", 3.00);
        grade.put("C+", 2.50);
        grade.put("C", 2.00);
        grade.put("D+", 1.50);
        grade.put("D", 1.00);
        grade.put("F", 0.00);
    }

    public static class Info {
        String name;
        String surname;
        double mark;

        public Info(String surname, String name, double mark) {
            this.surname = surname;
            this.name = name;
            this.mark = mark;
        }
    }

    public void display(Info[] arr) {
        for(Info el : arr) {
            System.out.print(el.surname + " " + el.name + " ");
            System.out.println(String.format(Locale.US, "%.3f", el.mark));
        }
    }

    public void merge(Info[] arr, Info[] temp, int low, int mid, int high) {
        for(int i = low; i <= high; i++)
            temp[i] = arr[i];

        int i = low, j = mid + 1, k = low;
        while(i <= mid || j <= high) {
            if(j > high)
                arr[k++] = temp[i++];
            else if(i > mid)
                arr[k++] = temp[j++];
            else if(temp[i].mark < temp[j].mark)
                arr[k++] = temp[i++];
            else if(temp[j].mark < temp[i].mark)
                arr[k++] = temp[j++];
            else if(temp[i].surname.compareTo(temp[j].surname) < 0)
                arr[k++] = temp[i++];
            else if(temp[i].surname.compareTo(temp[j].surname) > 0)
                arr[k++] = temp[j++];
            else if(temp[i].name.compareTo(temp[j].name) < 0)
                arr[k++] = temp[i++];
            else
                arr[k++] = temp[j++];
        }
    }


    public void mergeSort(Info[] arr, Info[] temp, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D ms = new D();
        int n = sc.nextInt();

        Info[] arr = new Info[n];
        for(int i = 0; i < n; i++) {
            String surname = sc.next(), name = sc.next();
            int m = sc.nextInt();
            float numerator = 0.0f, denominator = 0.0f;
            for(int j = 0; j < m; j++) {
                String mark = sc.next();
                float credit = (float)sc.nextInt();
                numerator += grade.get(mark) * credit;
                denominator += credit;
            }
            arr[i] = new Info(surname, name, numerator / denominator);
        }
        sc.close();

        ms.mergeSort(arr, new Info[n], 0, n - 1);
        ms.display(arr);
    }
}
