import java.util.Scanner;
import java.util.Stack;
public class D {
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.next();
            Stack<Character>st = new Stack<Character>();
            for(int i=0; i<s.length(); i++){
                if(!st.empty() && st.peek()==s.charAt(i)) st.pop();
                else st.push(s.charAt(i));
            }
            System.out.println((st.empty()?"YES":"NO"));
        }        
    }
}
