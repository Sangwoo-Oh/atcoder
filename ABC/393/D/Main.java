import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();

        ArrayList<Integer> p = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '1') p.add(i);
        }
        int k = p.size();
        for (int i=0; i<k; i++) {
            p.set(i, p.get(i)-i);
        }

        int med = p.get(k/2);
        long ans = 0;
        for (int i=0; i<k; i++) {
            ans += Math.abs(med-p.get(i));
        }
        System.out.println(ans);
    }
}
