import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        // LinkedList<LinkedList<Long>> groups = new LinkedList<>();
        dfs(a, 0);
        HashSet<Long> set = new HashSet<>();
        for (long num : list) {
            set.add(num);
        }
        System.out.println(set.size());
    }
    public static LinkedList<LinkedList<Long>> groups = new LinkedList<>();
    public static ArrayList<Long> list = new ArrayList<>();
    public static void dfs(long[] a, int i) {
        if (i == a.length) {
            long xor = 0;
            for (LinkedList<Long> group : groups) {
                long sum = 0;
                for (long num : group) {
                    sum += num;
                }
                xor ^= sum;
            }
            list.add(xor);
            return;
        }

        // put into existing groups
        for (int j = 0; j < groups.size(); j++) {
            groups.get(j).addLast(a[i]);
            dfs(a, i+1);
            groups.get(j).removeLast();
        }

        // put into new group
        LinkedList<Long> newGroup = new LinkedList<>();
        newGroup.addLast(a[i]);
        groups.addLast(newGroup);
        dfs(a, i+1);
        groups.removeLast();
    }
}
