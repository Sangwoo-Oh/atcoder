import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] p = new int[n]; // iさんが見つめている人
        int[] q = new int[n]; // iさんが何番のゼッケンをきているか
        int[] r = new int[n]; // i番のゼッケンを誰がきてるか

        for (int i=0; i<n; i++) {
            p[i] = scanner.nextInt() - 1;
        }
        for (int i=0; i<n; i++) {
            q[i] = scanner.nextInt() - 1;
            r[q[i]] = i;
        }

        for (int i=0; i<n; i++) {
            System.out.print(q[p[r[i]]]+1 + " ");
        }
    }
}
