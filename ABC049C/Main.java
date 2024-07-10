import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String S = scanner.nextLine();
        String[] divide = {"dream", "dreamer", "erase", "eraser"};

        StringBuilder sb = new StringBuilder(S);
        S = sb.reverse().toString();

        for (int i = 0; i < 4; i++) {
            sb = new StringBuilder(divide[i]);
            divide[i] = sb.reverse().toString();
        }

        boolean can = true;
        for (int i = 0; i < S.length();) {
            boolean dividable = false;
            for (int j = 0; j < 4; j++) {
                if (i + divide[j].length() <= S.length() && divide[j].equals(S.substring(i, i + divide[j].length()))) {
                    dividable = true;
                    i += divide[j].length();
                }
            }
            if (!dividable) {
                can = false;
                break;
            }
        }
        System.out.println(can ? "YES" : "NO");
    }
}
