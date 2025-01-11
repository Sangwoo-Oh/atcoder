import java.lang.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ans = new ArrayList<>();
        for (int i=0; i<m; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i+1);
            backtrack(n, m, 0, list, ans);
        }

        System.out.println(ans.size());
        for (List<Integer> seq : ans) {
            int i=0;
            for (Integer s : seq) {
                if (i==n-1) {
                    System.out.print(s);
                    System.out.println();
                } else {
                    System.out.print(s + " ");
                }
                i++;
            }
        }
    }

    public static void backtrack(int n, int max, int ind, List<Integer> list, List<List<Integer>> res) {
        // base case
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        // recursive case
        for (int next=list.get(list.size()-1) + 10; next <= max; next++) {
            if (max - next < 10 * (n-list.size()-1)) {
                break;
            } else {
                list.add(next);
                backtrack(n, max, ind+1, list, res);
                list.remove(list.size()-1);
            }
        }
    }
}
