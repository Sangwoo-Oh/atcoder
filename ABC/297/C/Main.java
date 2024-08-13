import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        char[][] c = new char[h][w];
        for (int i=0; i<h; i++) {
            String s = scanner.next();
            for (int j=0; j<w; j++) {
                c[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<h; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<w-1; j++) {
                if(c[i][j] == 'T' && c[i][j+1] == 'T') {
                    c[i][j] = 'P';
                    c[i][j+1] = 'C';
                    j++;
                }
            }
            sb.append(c[i]);
            System.out.println(sb.toString());
        }




    }
}
