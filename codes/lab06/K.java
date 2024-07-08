package lab06;

import java.util.*;

public class K {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<String> olds = new TreeSet<>();
        HashSet<String> news = new HashSet<>();
        TreeMap<String, String>names = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            String first = sc.next(), second = sc.next();
            if(!news.contains(first))
                olds.add(first);
            news.add(second);
            names.put(first, second);
        }
        sc.close();

        System.out.println(olds.size());
        for(String old : olds) {
            String nw = names.get(old);
            while(names.containsKey(nw) && !nw.equals(old))
                nw = names.get(nw);
            System.out.println(old + " " + nw);
        }
    }
}
