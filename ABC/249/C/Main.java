import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) s[i] = scanner.next();

        int max = 0;
        for (int bit=0; bit < (1 << n); bit++) {
            List<String> list = new ArrayList<>();
            for (int i=0; i<n; i++) {
                if ((bit>>i & 1) == 1) list.add(s[i]);
            }

            int[] alphabet = new int[26];
            for (String str : list) {
                for (char c : str.toCharArray()) alphabet[c - 'a']++;
            }
            int cnt = 0;
            for (int i=0; i<26; i++) {
                if (alphabet[i] == k) cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
