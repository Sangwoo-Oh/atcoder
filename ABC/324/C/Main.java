import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String t = scanner.next();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }

        int i = 0;
        int cnt = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (String ss : s) {
            i++;
            int d = Math.abs(ss.length() - t.length());
            if (d > 1) continue;

            if (judge(ss,t,d)) {
                cnt++;
                ans.add(i);
            }
        }
        System.out.println(cnt);
        if (cnt > 0) {
            for (Integer num : ans) System.out.print(num + " ");
            System.out.println();
        }

    }
    static boolean judge(String s, String t, int d) {
        if (d==0) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) diff += 1;
            }
            if (diff <= 1) return true;
            else return false;
        } else {
            String lstr, sstr;
            if (t.length() <= s.length()) { lstr = s; sstr = t;
            } else { lstr = t; sstr = s; }
            int i = 0;
            int j = 0;
            while (i < lstr.length() && j < sstr.length()) {
                if (lstr.charAt(i) == sstr.charAt(j)) {
                    i++;j++;
                } else i++;
            }
            return j == sstr.length();
        }
    }
}
