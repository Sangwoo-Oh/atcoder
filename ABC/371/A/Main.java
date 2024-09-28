import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // S_AB, S_AC, S_BC の入力を受け取る
        char S_AB = scanner.next().charAt(0);
        char S_AC = scanner.next().charAt(0);
        char S_BC = scanner.next().charAt(0);
        
        if (S_AB == '<' && S_AC == '<') {
            if (S_BC == '<') {
                System.out.println("B");
            } else {
                System.out.println("C");
            }
        } else if (S_AB == '<' && S_AC == '>') {
            System.out.println("A");
        } else if (S_AB == '>' && S_AC == '<') {
            System.out.println("A");
        } else if (S_AB == '>' && S_AC == '>') {
            // A > B
            // A > C
            if (S_BC == '>') {
                System.out.println("B");
            } else {
                System.out.println("C");
            }
        }
        scanner.close();
    }
}
