import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        double s = scanner.nextDouble();
        double t = scanner.nextDouble();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
        }

        int[] perm = new int[n];
        for (int i=0; i<n; i++) perm[i] = i;


        double minTime = Double.MAX_VALUE;
        do {  //順列の計算量　6! = 720
            for (int bit=0; bit<(1<<n); bit++) { //ab, cdどちらからスタートするかのパターン全列挙　2^6 = 64
                int currentX = 0;
                int currentY = 0;
                double time = 0;
                for (int i=0; i<n; i++) {
                    int nextXBegin = 0;
                    int nextYBegin = 0;
                    int nextXEnd = 0;
                    int nextYEnd = 0;
                    if ((bit & (1<<i)) == (1<<i)) { // ab -> cd に移動
                        nextXBegin = a[perm[i]];
                        nextYBegin = b[perm[i]];
                        nextXEnd = c[perm[i]];
                        nextYEnd = d[perm[i]];
                    } else { // cd -> ab に移動
                        nextXBegin = c[perm[i]];
                        nextYBegin = d[perm[i]];
                        nextXEnd = a[perm[i]];
                        nextYEnd = b[perm[i]];
                    }

                    double dis = Math.sqrt((currentX - nextXBegin) * (currentX - nextXBegin) + (currentY - nextYBegin) * (currentY - nextYBegin));
                    time += dis / s;

                    double disWithLaser = Math.sqrt((nextXBegin - nextXEnd) * (nextXBegin - nextXEnd) + (nextYBegin - nextYEnd) * (nextYBegin - nextYEnd));
                    time += disWithLaser / t;

                    currentX = nextXEnd;
                    currentY = nextYEnd;
                }
                minTime = Math.min(minTime, time);
            }
        } while (next_permutation(perm, 0, n));

        System.out.println(minTime);
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
