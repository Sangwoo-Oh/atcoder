import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        //algorithm
        int res = 0;

        //initial value
        int min = a * x + b * y;

        int z = 0;
        while (x > 0 || y > 0) {
            z += 2;
            x = x > 0 ? --x: 0;
            y = y > 0 ? --y: 0;
            int sum = a * x + b * y + c * z;
            min = Math.min(min, sum);
        }

        res = min;

        System.out.println(res);
    }
}
