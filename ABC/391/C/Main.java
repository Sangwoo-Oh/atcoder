import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();

        int[] pToHole = new int[n];
        int[] hToNum = new int[n];
        for (int i=0; i<n; i++) {
            pToHole[i] = i;
            hToNum[i] = 1;
        }
        int mult = 0;
        int q = scanner.nextInt();
        for (int i=0; i<q; i++) {
            int query = scanner.nextInt();

            if (query == 1) {
                int p = scanner.nextInt()-1;
                int h = scanner.nextInt()-1;
                if (hToNum[pToHole[p]]==2) {
                    mult--;
                }
                hToNum[pToHole[p]]--;
                if (hToNum[h]==1) {
                    mult++;
                }
                hToNum[h]++;

                pToHole[p] = h;
            } else {
                System.out.println(mult);
            }
        }
    }
}
