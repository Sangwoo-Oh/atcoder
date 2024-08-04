import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();

        int INF = Integer.MIN_VALUE;
        // 0->P, 1->S, 2->R
        int[][] dp = new int[n+1][3];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], INF);
        for (int i=0; i<3; i++) dp[0][i] = 0;

        for (int i=0; i<n; i++) {
            int x = 0;
            if (s.charAt(i) == 'P') x = 0;
            else if (s.charAt(i) == 'S') x = 1;
            else x = 2;
            for (int j=0; j<3; j++) {
                int val = 0;
                if (x==0 && j==1) val = 1;
                else if (x==1 && j==2) val = 1;
                else if (x==2 && j==0) val = 1;
                for (int k=0; k<3; k++) {
                    if (j==k) continue;
                    if (x==0 && j==2) continue;
                    else if (x==1 && j==0) continue;
                    else if (x==2 && j==1) continue;
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][k]+val);
                }
            }
        }

        int ans = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        System.out.println(ans);
    }


}
