import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            d[i] = scanner.nextInt();
        }

        Arrays.sort(d);
        int res = 1;

        for (int i = 1; i < N; i++) {
            if (d[i-1] != d[i]) {
                ++res;
            }
        }

        System.out.println(res);
    }
}
