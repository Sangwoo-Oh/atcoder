import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        List<Map<Integer, Long>> memo = new ArrayList<>();
        for (int i=n; i>=1; i--) {
            memo.add(new HashMap<>());
        }

        long ans = 0;
        for (int i=1; i<=m; i++) ans += dfs(k-i, m, n-1, memo);
        ans %= 998244353;
        System.out.println(ans);
    }

    public static long dfs(int k, int m, int n, List<Map<Integer, Long>> memo) {
        if (n==0) {
            if (k>=0) return 1;
            else return 0;
        }

        long ans = 0;
        if (memo.get(n).containsKey(k)) {
            ans = memo.get(n).get(k);
        } else {
            for (int i=1; i<=m; i++) {
                ans += dfs(k-i, m, n-1, memo);
            }
            memo.get(n).put(k, ans);
        }
        return ans % 998244353;
    }
}
