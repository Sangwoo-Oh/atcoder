import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int[][] t = new int[N][3];
        for (int i = 0; i < N; i++) {
            t[i][0] = scanner.nextInt();
            t[i][1] = scanner.nextInt();
            t[i][2] = scanner.nextInt();
        }

        boolean possible = true;
        int[] prev = {0, 0, 0};
        for (int i = 0; i < N; i++) {
            int x = Math.abs(prev[1] - t[i][1]);
            int y = Math.abs(prev[2] - t[i][2]);
            int move = x + y;
            int time = t[i][0] - prev[0];
            if (move > time) {
                possible = false;
                break;
            } else if (move < time) {
                if ((time - move) % 2 != 0) {
                    possible = false;
                    break;
                }
            }
            prev[0] = t[i][0];
            prev[1] = t[i][1];
            prev[2] = t[i][2];
        }
        System.out.println(possible ? "Yes" : "No");
    }
}
