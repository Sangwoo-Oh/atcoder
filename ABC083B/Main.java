import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int num = i;
            int digitSum = 0;
            while (num >= 1) {
                digitSum += num % 10;
                num = num / 10;
            }
            if (digitSum >= A && digitSum <= B) sum += i;
        }
        System.out.println(sum);
    }
}
