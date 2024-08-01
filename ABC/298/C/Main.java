import java.lang.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static char[][] field;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        ArrayList<ArrayList<Integer>> boxes = new ArrayList<>();
        for (int i=0;i<n;i++) boxes.add(new ArrayList<>());

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i=0;i<q;i++) {
            int num = scanner.nextInt();
            if (num==1) {
                int card = scanner.nextInt();
                int boxNum = scanner.nextInt()-1;
                boxes.get(boxNum).add(card);
                if (!map.containsKey(card)) map.put(card, new HashSet<>());
                map.get(card).add(boxNum);
            } else if (num==2) {
                int boxNum = scanner.nextInt()-1;
                List<Integer> cards = boxes.get(boxNum);
                Collections.sort(cards);
                for (Integer x : cards) {
                    System.out.print(x + " ");
                }
                System.out.println();
            } else if (num==3) {
                int card = scanner.nextInt();
                List<Integer> boxes2 = new ArrayList<>(map.get(card));
                Collections.sort(boxes2);
                for (Integer x : boxes2) {
                    System.out.print((x+1) + " ");
                }
                System.out.println();
            }
        }
    }
}
