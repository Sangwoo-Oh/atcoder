import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int res = 0;
        for (int i = 1; i <= N; i++) {
            int num = i;
            int cnt = 0;
            while (num >= 1) {
                cnt++;
                num /= 10;
            }
            if (cnt % 2 != 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}
