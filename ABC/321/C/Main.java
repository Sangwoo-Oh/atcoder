import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int k = scanner.nextInt();

        ArrayList<Long> nums = new ArrayList<>();
        for (int bit = 2; bit < (1 << 10); bit++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 9; i >= 0; i--) {
                if (((bit >> i) & 1) == 1) {
                    sb.append(i);
                }
            }
            nums.add(Long.valueOf(sb.toString()));
        }
        Collections.sort(nums);
        System.out.println(nums.get(k-1));
    }
}
