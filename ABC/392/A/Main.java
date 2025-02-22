import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int[] a = new int[3];
        for (int i=0; i<3; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                for (int k=0; k<3; k++) {
                    if (i==j || j==k || i==k) {
                        continue;
                    }

                    if (a[i] * a[j] == a[k]) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }
}
