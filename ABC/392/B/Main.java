import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<m; i++) {
            int a = scanner.nextInt();
            set.add(a);
        }

        int cnt = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (!set.contains(i)) {
                cnt++;
                res.add(i);
            }
        }
        System.out.println(cnt);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
