import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int q = scanner.nextInt();

        LinkedList<Long> head_queue = new LinkedList<>();
        LinkedList<Long> length_queue = new LinkedList<>();
        ArrayList<Long> order = new ArrayList<>();
        /* proccess */
        long sum = 0;
        int m = 0;
        for (int i=0; i<q; i++) {
            // System.out.println(head_queue);
            // System.out.println(length_queue);
            int query = scanner.nextInt();
            if (query == 1) {
                long l = scanner.nextLong();
                if (head_queue.isEmpty()) {
                    head_queue.add(sum);
                    length_queue.add(l);
                    order.add(sum);
                } else {
                    long prev_head = head_queue.peekLast();
                    long prev_length = length_queue.peekLast();
                    head_queue.add(prev_head + prev_length);
                    length_queue.add(l);
                    order.add(prev_head + prev_length);
                }
            } else if (query == 2) {
                long left = head_queue.poll();
                long length = length_queue.poll();
                sum += length;
                m++;
            } else if (query == 3) {
                int k = scanner.nextInt();
                System.out.println(order.get(k+m-1) - sum);
            }
        }
    }
}
