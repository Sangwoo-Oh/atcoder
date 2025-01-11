import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] t = new int[n];
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
            l[i] = scanner.nextInt();
        }


        for (int k=1; k<=d;k++) {
            int max = 0;
            for (int i=0; i<n; i++) {
                int w = t[i] * (l[i] + k);
                max = Math.max(max, w);
            }
            System.out.println(max);
        }

    }
}
