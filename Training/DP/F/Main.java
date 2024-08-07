import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String s = scanner.next();
        String t = scanner.next();

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (s.charAt(i) == t.charAt(j)) dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + 1);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j+1]);
            }
        }

        String res = "";
        int i = n;
        int j = m;
        while (i > 0 && j>0) {
            if (dp[i][j] == dp[i-1][j]) i--;
            else if (dp[i][j] == dp[i][j-1]) j--;
            else {
                res = s.charAt(i-1) + res;
                i--;
                j--;
            }
        }
        System.out.println(res);
    }
}
