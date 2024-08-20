import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();
        int w1 = scanner.nextInt();
        int w2 = scanner.nextInt();
        int w3 = scanner.nextInt();


        long ans = 0;
        // 1st row, 1st column
        for (int a1=1; a1<=h1-2 && a1<=w1-2; a1++) {
            // 1st row, 2nd column
            for (int b1=1; b1<=h1-a1-1 && b1<=w2-2; b1++) {
                int c1 = h1-a1-b1;
                if (c1<1) continue;
                // 2nd row, 1st column
                for (int a2=1; a2<=h2-2 && a2<=w1-a1-1; a2++) {
                    // 2nd row, 2nd column
                    for (int b2=1; b2<=h2-a2-1 && b2<=w2-b1-1; b2++) {
                        int c2 = h2-a2-b2;
                        if (c2<1) continue;
                        // 3rd row
                        int a3 = w1-a1-a2; if (a3<1) continue;
                        int b3 = w2-b1-b2; if (b3<1) continue;
                        int c3 = h3-a3-b3; if (c3<1) continue;

                        if (a1+b1+c1==h1 &&
                            a2+b2+c2==h2 &&
                            a3+b3+c3==h3 &&
                            a1+a2+a3==w1 &&
                            b1+b2+b3==w2 &&
                            c1+c2+c3==w3) {
                            ans++;
                        }

                    }
                }
            }
        }

        System.out.println(ans);
    }
}
