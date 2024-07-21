import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        String S = scanner.next();

        int count = 0;
        for (int i = 0; i < S.length();) {
            if (i+3 > S.length()) {
                break;
            }
            if (S.substring(i, i+3).equals("ABC")) {
                count++;
                i += 3;
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}
