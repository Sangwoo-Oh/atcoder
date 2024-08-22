import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        HashSet<String> set = new HashSet<>();
        int max = -1;
        int maxInd = -1;
        for (int i=0; i<n; i++) {
            String s = scanner.next();
            int t = scanner.nextInt();
            if(set.contains(s)) continue;
            set.add(s);
            if(max < t) {
                max = t;
                maxInd = i;
            }
        }
        System.out.println(maxInd+1);
    }
}
