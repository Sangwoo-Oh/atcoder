import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int h1 = scanner.nextInt();
        int w1 = scanner.nextInt();
        int[][] a = new int[h1][w1];
        for (int i=0; i<h1; i++) for (int j=0; j<w1; j++) {
            a[i][j] = scanner.nextInt();
        }
        int h2 = scanner.nextInt();
        int w2 = scanner.nextInt();
        int[][] b = new int[h2][w2];
        for (int i=0; i<h2; i++) for (int j=0; j<w2; j++) {
            b[i][j] = scanner.nextInt();
        }

        for (int bitRow=0; bitRow<1<<h1; bitRow++) {
            for (int bitCol=0; bitCol<1<<w1; bitCol++) {
                boolean ok = true;
                Set<Integer> deleteRows = new HashSet<>();
                Set<Integer> deleteCols = new HashSet<>();

                for (int i=0; i<h1; i++) {
                    if ((bitRow>>i & 1) == 1) deleteRows.add(i);
                }
                for (int i=0; i<w1; i++) {
                    if ((bitCol>>i & 1) == 1) deleteCols.add(i);
                }

                int h3 = h1-deleteRows.size();
                int w3 = w1-deleteCols.size();

                if (h3 != h2 || w3 != w2) {
                    continue;
                }

                int k=0;
                int l=0;
                for (int i = 0; i < h1; i++) {
                    l=0;
                    if (deleteRows.contains(i)) {
                        k++;
                        continue;
                    }
                    for (int j = 0; j < w1; j++) {
                        if (deleteCols.contains(j)) {
                            l++;
                            continue;
                        }
                        if (a[i][j] != b[i-k][j-l]) {
                            ok = false;
                        }
                    }
                }

                if (ok) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}