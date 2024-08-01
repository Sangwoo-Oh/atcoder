import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
		long a = scanner.nextLong();
		long b = scanner.nextLong();
        String s = scanner.next();
		long ans = Long.MAX_VALUE;
		for (int i = 0; i <= n-1; i++) {
			int a_cnt = i;
			if (a_cnt > 0) {
				char[] chars = s.toCharArray();
				char x = chars[0];
				for (int j=0; j < n-1; j++) {
					chars[j] = chars[j+1];
				}
				chars[n-1] = x;
				s = new String(chars);
			}
			// rotate
			int b_cnt = 0;
			for (int j = 0; j < n/2; j++) {
				if (s.charAt(j)!=s.charAt(n-j-1)) b_cnt++;
			}
			ans = Math.min(ans, a*a_cnt + b*b_cnt);
		}
		System.out.println(ans);
    }
}
