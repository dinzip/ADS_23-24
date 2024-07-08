package lab06;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class F {

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
        double mark;

        public Info(String name, double mark) {
            this.name = name;
            this.mark = mark;
        }
    }

    public void display(Info[] arr) {
        for(Info el : arr) {
            System.out.print(el.name + " ");
            System.out.println(String.format(Locale.US, "%.3f", el.mark));
        }
    }

    public void quickSort(Info[] arr, int low, int high) {
        if(low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private int partition(Info[] arr, int low, int high) {
        Info pivot = arr[high];
        int j = low;

        for(int i = low; i <= high; i++) {
            if(isLess(arr[i], pivot)) {
                swap(arr, i, j);
                j++;
            }
        }
        return j - 1;
    }

    private void swap(Info[] arr, int i, int j) {
        Info temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isLess(Info a, Info b) {
        return a.mark < b.mark || (a.mark == b.mark && a.name.compareTo(b.name) <= 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F qs = new F();
        int n = sc.nextInt();

        Info[] arr = new Info[n];
        for(int i = 0; i < n; i++) {
            String last = sc.next(), first = sc.next();
            int m = sc.nextInt();
            float numerator = 0.0f, denominator = 0.0f;
            for(int j = 0; j < m; j++) {
                String mark = sc.next();
                float credit = sc.nextFloat();
                numerator += grade.get(mark) * credit;
                denominator += credit;
            }
            arr[i] = new Info(last + " " + first, numerator / denominator);
        }
        sc.close();

        qs.quickSort(arr, 0, n - 1);
        qs.display(arr);
    }
}
