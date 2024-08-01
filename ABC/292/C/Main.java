import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long ans = 0;
        for (int i = 1; i < n; i++) {
            long X = i;
            long Y = n-X;

            long x_cnt=0;
            long y_cnt=0;
            // Xを満たす個数
            for(int j=1;j*j<=X;j++){
                if(X%j==0){
                    x_cnt++;
                    if(X!=j*j)x_cnt++;
                }
            }
            // Yを満たす個数
            for(int j=1;j*j<=Y;j++){
                if(Y%j==0){
                    y_cnt++;
                    if(Y!=j*j)y_cnt++;
                }
            }
            ans += x_cnt * y_cnt;
        }
        System.out.println(ans);
    }
}
