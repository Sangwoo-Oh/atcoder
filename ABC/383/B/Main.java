import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int d = scanner.nextInt();
        char[][] s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = scanner.next().toCharArray();
        }

        int res = 0;
        for (int i=0; i<h; i++) for (int j=0; j<w; j++) {
            for (int k=0; k<h; k++) for (int l=0; l<w; l++) {
                if (i == k && j == l) continue;
                if (s[i][j] == '#' || s[k][l] == '#') continue;

                int sum = 0;
                for (int I=0; I<h; I++) {
                    for (int J=0; J<w; J++) {
                        int manhattan1 = Math.abs(I - i) + Math.abs(J - j);
                        int manhattan2 = Math.abs(I - k) + Math.abs(J - l);
                        if (d >= manhattan1 || d >= manhattan2) {  
                            if (s[I][J] == '.') sum++;
                        }
                    }
                }
                res = Math.max(res, sum);
            }
        }
        System.out.println(res);
    }
}
