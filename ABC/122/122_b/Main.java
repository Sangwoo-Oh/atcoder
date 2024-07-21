import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String S = scanner.next();
        int N = S.length();
        Character[] chars = {'A','T','G','C'};

        Arrays.asList(chars);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) { // begin index
            for (int j = i; j <= N; j++) { // end index
                boolean isATGC = true;
                for (int k = i; k < j; k++) {
                    if (!Arrays.asList(chars).contains(S.charAt(k))) {
                        isATGC = false;
                    }
                }
                if (isATGC) {
                    max = Math.max(max, j-i);
                }
            }
        }

        System.out.println(max);
    }
}
