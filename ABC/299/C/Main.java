import java.lang.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static char[][] field;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String s = scanner.next();


        int max = 0;

        for (int i = 0; i < n; i++) {
            int continuous_cnt = 0;
            while(i<n && s.charAt(i)=='o') {
                continuous_cnt++;
                i++;
            }
            max = Math.max(max, continuous_cnt);
        }
        if(max==0) System.out.println(-1);
        else System.out.println(max);
    }
}
