import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int i=0; i<q; i++) {
            int a = scanner.nextInt();
            if (set.contains(a)) { // aが黒の場合
                set.remove(a);
                if (a == 1) {
                    if (!set.contains(a+1)) {
                        res--;
                    }
                } else if (a == n) {
                    if (!set.contains(a-1)) {
                        res--;
                    }
                } else {
                    int l = a-1;
                    int r = a+1;
                    boolean lExists = set.contains(l);
                    boolean rExists = set.contains(r);
                    if (!lExists && !rExists) {
                        res--;
                    } else if (lExists && rExists) {
                        res++;
                    }
                }
            } else { // aが白の場合
                set.add(a);
                if (a == 1) {
                    if (!set.contains(a+1)) {
                        res++;
                    }
                } else if (a == n) {
                    if (!set.contains(a-1)) {
                        res++;
                    }
                } else {
                    int l = a-1;
                    int r = a+1;
                    boolean lExists = set.contains(l);
                    boolean rExists = set.contains(r);
                    if (!lExists && !rExists) {
                        res++;
                    } else if (lExists && rExists) {
                        res--;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
