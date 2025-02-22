import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] k = new int[n];
        int[][] a = new int[n][];
        HashMap<Integer, HashMap<Integer, Integer>> occurs = new HashMap<>();

        for (int i=0; i<n; i++) {
            k[i] = scanner.nextInt();
            a[i] = new int[k[i]];
            occurs.put(i, new HashMap<>());
            for (int j=0; j<k[i]; j++) {
                a[i][j] = scanner.nextInt();
                occurs.get(i).put(a[i][j], occurs.get(i).getOrDefault(a[i][j], 0)+1);
            }
            // System.out.println(Arrays.toString(a[i]));
            // for (Map.Entry<Integer, Integer> occur : occurs.get(i).entrySet()) {
            //     System.out.println(occur.getKey() + " " + occur.getValue());
            // }
        }

        Double max = Double.MIN_VALUE;
        // System.out.println(max);
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                // i番目とj番目のサイコロを選ぶ
                double prob = 0;
                for (Map.Entry<Integer, Integer> occur : occurs.get(i).entrySet()) {
                    // System.out.println(i + " " + j + " " + occur.getKey() + " " + occur.getValue());
                    double f = Double.valueOf(occur.getValue()) / Double.valueOf(k[i]);
                    // System.out.println(f);
                    if (occurs.get(j).containsKey(occur.getKey())) {
                        double g = Double.valueOf(occurs.get(j).get(occur.getKey())) / Double.valueOf(k[j]);
                        prob += f*g;
                    } else {
                        continue;
                    }
                }
                // System.out.println(prob);
                max = Math.max(max, prob);
            }
        }

        System.out.println(max);
    }
}
