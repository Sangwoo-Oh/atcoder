import java.util.Scanner;

public class PrimeFactorization {

    // 素因数分解を行うメソッド
    public static void primeFactorization(double n) {
        // 2で割れるだけ割る
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // 3以上の奇数で割れるだけ割る
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // 残った数が素数の場合、それを出力
        if (n > 2) {
            System.out.print(n);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();

        primeFactorization(number);
        

        scanner.close();
    }
}
