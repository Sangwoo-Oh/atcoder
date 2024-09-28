import java.lang.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long h = scanner.nextLong();
        long w = scanner.nextLong();
        int n = scanner.nextInt();
        Long[][] points = new Long[n][3];
        for (int i=0; i<n; i++) {
            Long a = scanner.nextLong();
            Long b = scanner.nextLong();
            points[i][0] = (long)i;
            points[i][1] = a;
            points[i][2] = b;   
        }
        // row

        Arrays.sort(points, (a, b) -> a[1].compareTo(b[1]));
        HashMap<Long, Long> map = new HashMap<>();
        long cnt = 1;
        for (int i=0; i<n; i++) {
            if (!map.containsKey(points[i][1])) {
                map.put(points[i][1], cnt);
                cnt++;
            }
        }

        for (int i=0; i<n; i++) {
            points[i][1] = map.get(points[i][1]);
        }

        // col
        Arrays.sort(points, (a, b) -> a[2].compareTo(b[2]));
        map = new HashMap<>();
        cnt = 1;
        for (int i=0; i<n; i++) {
            if (!map.containsKey(points[i][2])) {
                map.put(points[i][2], cnt);
                cnt++;
            }
        }
        for (int i=0; i<n; i++) {
            points[i][2] = map.get(points[i][2]);
        }

        Arrays.sort(points, (a, b) -> a[0].compareTo(b[0]));
        for (int i=0; i<n; i++) {
            System.out.println(points[i][1] + " " + points[i][2]);
        }
    }
}
