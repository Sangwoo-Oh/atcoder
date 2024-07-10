import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();

        scanner.nextLine();

        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = scanner.nextLine();
        }
        int c = 0;
        for (int i = 0; i < N; i++) {
            if (S[i].equals("Takahashi")){
                c++;
            }
        }
        System.out.println(c);
    }
}
