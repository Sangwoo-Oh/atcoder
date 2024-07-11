import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        String S = scanner.next();

        //algorithm
        int res = 0;
        HashSet<String> set = new HashSet<>();
        char[] charArr = S.toCharArray();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int p1 = 0;
                    while (p1 < S.length() && Character.getNumericValue(charArr[p1]) != i) {
                        p1++;
                    }
                    int p2 = p1 + 1;
                    while (p2 < S.length() && Character.getNumericValue(charArr[p2]) != j) {
                        p2++;
                    }
                    int p3 = p2 + 1;
                    while (p3 < S.length() && Character.getNumericValue(charArr[p3]) != k) {
                        p3++;
                    }
                    if (p1 < p2 && p2 < p3 && p3 < S.length()) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
