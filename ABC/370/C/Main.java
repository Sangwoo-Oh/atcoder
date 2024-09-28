import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String S = scanner.next();
        String T = scanner.next();
        
        List<String> X = new ArrayList<>();


        int n = S.length();
        while (!S.equals(T)) {
            PriorityQueue<String> pq = new PriorityQueue<>();
            for (int i=0; i<n; i++) {
                if (S.charAt(i) == T.charAt(i)) { continue; }
                StringBuilder sb = new StringBuilder(S);
                sb.setCharAt(i, T.charAt(i));
                pq.add(sb.toString());
            }
            S = pq.poll();
            X.add(S);
        }

        System.out.println(X.size());
        for (String x : X) {
            System.out.println(x);
        }
    }
}
