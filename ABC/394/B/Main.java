import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        for (int i=0; i<n; i++) {
            String s = scanner.next();
            set.add(s);
        }
        String ans = "";
        for (String s : set) {
            ans += s;
        }
        System.out.println(ans);

    }
}
