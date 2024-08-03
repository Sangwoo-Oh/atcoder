import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* input */
        int n = scanner.nextInt();
		int q = scanner.nextInt();

		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		for (int i=0; i<q; i++) {
			int t = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();

			if (t == 1) {
				if(!map.containsKey(a)) map.put(a, new HashSet<>());
				map.get(a).add(b);
			} else if (t == 2) {
				if(!map.containsKey(a)) map.put(a, new HashSet<>());
				map.get(a).remove(b);
			} else {
				if(map.containsKey(a) && map.containsKey(b)) {
					if (map.get(a).contains(b) && map.get(b).contains(a)) {
						System.out.println("Yes");
						continue;
					}
				}
				System.out.println("No");
			}
		}

    }
}
