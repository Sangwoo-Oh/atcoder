import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int Y = scanner.nextInt();
        for (int a = 0; a <= N; a++) {
            for (int b = 0; b <= N - a; b++) {
                int c = N - a - b;
                if (10000*a + 5000*b + 1000*c == Y) {
                    System.out.println(a + " " + b + " " + c);
                    return;
                }
            }
        }
        System.out.println("-1 -1 -1");
    }
}
