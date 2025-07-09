
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Integer[] s = new Integer[n];
            int first = 0;
            int last = 0;
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    first = scanner.nextInt();
                    s[0] = 0;
                } else if (j == n - 1) {
                    last = scanner.nextInt();
                    s[n - 1] = 0;
                } else {
                    s[j] = scanner.nextInt();
                }
            }

            Arrays.sort(s);

            ArrayList<Integer> list = new ArrayList<>();
            list.add(first);
            for (int j = 2; j < n; j++) {
                list.add(s[j]);
            }
            list.add(last);

            if (n == 2) {
                if (list.get(0) * 2 >= list.get(1)) {
                    System.out.println(2);
                } else {
                    System.out.println(-1);
                }
            } else {
                int j = 0;
                int k = 1;
                int skip = 0;
                while (k < n) {
                    // 隣同士で条件を満たさない場合はその時点で終了
                    if (list.get(j) * 2 < list.get(k)) {
                        System.out.println(-1);
                        break;
                    } else {
                        // second この要素が省略可能かどうか
                        if (k == n - 1) { //最後の要素であればこのチェックは省いてよい
                            System.out.println(n - skip);
                            break;
                        } else {
                            if (list.get(j) * 2 >= list.get(k + 1)) {
                                skip++; // 省略可能
                            } else {
                                j = k; // 省略可能なので今の要素が次のjになる
                            }
                        }
                        k++;
                    }
                }
            }

        }
    }
}
