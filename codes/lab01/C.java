import java.util.Scanner;
import java.util.Stack;
public class C {
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            String first = sc.next(), second = sc.next();
            Stack<Character> f = new Stack<Character>(), s = new Stack<Character>();
            for(int i = 0; i < Math.max(first.length(), second.length()); i++){
                if( i < first.length()){
                    if(first.charAt(i) == '#' && !f.empty()) f.pop();
                    else f.push(first.charAt(i));
                }
                if( i < second.length()){
                    if(second.charAt(i) == '#' && !s.empty()) s.pop();
                    else s.push(second.charAt(i));
                }
            }
            // System.out.println(f);
            // System.out.println(s);
            System.out.println((f.equals(s) ? "YES" : "NO"));
        }
    }
}
