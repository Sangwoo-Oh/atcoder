import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 入力の受け取り
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        String[] s = new String[h];
        for (int i = 0; i < h; i++) {
            s[i] = scanner.next();
        }

        // 四隅の初期化
        int colMin = -1;
        int colMax = -1;
        int rowMin = -1;
        int rowMax = -1;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i].charAt(j) == '#') {
                    if (rowMin == -1) {
                        rowMin = i;
                    }
                    if (rowMax == -1) {
                        rowMax = i;
                    }
                    if (colMin == -1) {
                        colMin = j;
                    }
                    if (colMax == -1) {
                        colMax = j;
                    }
                    rowMin = Math.min(rowMin, i);
                    rowMax = Math.max(rowMax, i);
                    colMin = Math.min(colMin, j);
                    colMax = Math.max(colMax, j);
                }
            }
        }
        // System.out.println(rowMin + " " + rowMax + " " + colMin + " " + colMax);

        for (int i = rowMin; i <= rowMax; i++) {
            for (int j = colMin; j <= colMax; j++) {
                if (s[i].charAt(j) == '.') {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}
