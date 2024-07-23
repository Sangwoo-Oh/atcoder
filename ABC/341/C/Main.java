import java.lang.*;
import java.util.*;

class Pos {
    int i,j;
    public Pos (int i,int j) {
        this.i = i; this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (o==this) return true;
        if (!(o instanceof Pos)) return false;
        Pos other = (Pos)o;
        return this.i == other.i && this.j == other.j;
    }


    @Override
    public int hashCode() {
        return (int) i * j;
    }

    @Override
    public String toString() {
        return "(" + i + "," + j + ")";
    }
}

public class Main {
    private static HashSet<Pos> g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int N = scanner.nextInt();

        String T = scanner.next();

        String[] S = new String[H];


        for (int i = 0; i < H; i++) {
            S[i] = scanner.next();
        }

        int cnt = 0;

        for (int i = 0; i < H; i++) for (int j = 0; j < W; j++) {
            if (S[i].charAt(j) == '#') continue;
            int I = i; int J = j;
            int k = 0;
            for (; k < T.length(); k++) {
                switch (T.charAt(k)) {
                    case 'L' -> J--;
                    case 'R' -> J++;
                    case 'U' -> I--;
                    case 'D' -> I++;
                }
                if (S[I].charAt(J) == '#') break;
            }
            if (k==T.length()) cnt++;
        }

        System.out.println(cnt);
    }

    /* next permutation method */
    static boolean next_permutation(int[] array, int start, int end) {
        if(array == null || start > end || start < 0 || end > array.length) {
            System.out.println("Error: 引数が正しくありません。");
            return false;
        }

        for(int i=end-2; i>=start; i--) {
            if(array[i] < array[i+1]) {
                int j = end - 1;
                while(array[i] >= array[j]) {
                    j--;
                }

			    //swap
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;

                Arrays.sort(array, i+1, end);

                return true;
            }
        }
        return false;
    }
}
