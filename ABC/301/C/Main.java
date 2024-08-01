import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        String s = scanner.next();
        String t = scanner.next();

        int[] s_cnt = new int[26];
        int s_at = 0;
        int[] t_cnt = new int[26];
        int t_at = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)!='@') {
                s_cnt[(int)(s.charAt(i) - 'a')]++;
            } else {
                s_at++;
            }
            if (t.charAt(i)!='@') {
                t_cnt[(int)(t.charAt(i) - 'a')]++;
            } else {
                t_at++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (s_cnt[i]==t_cnt[i])continue;
            char c = (char)(i+'a');
            if (c != 'a' && c != 't' && c != 'c' && c != 'o' && c != 'd' && c != 'e' && c != 'r') {
                System.out.println("No");
                return;
            } else {
                if (s_cnt[i]<t_cnt[i]) {
                    s_at -= t_cnt[i]-s_cnt[i];
                    if (s_at < 0) {
                        System.out.println("No");
                        return;
                    }
                }
                if (s_cnt[i]>t_cnt[i]) {
                    t_at -= s_cnt[i]-t_cnt[i];
                    if (t_at < 0) {
                        System.out.println("No");
                        return;
                    }
                }
            }
        }
        System.out.println("Yes");
    }
}
