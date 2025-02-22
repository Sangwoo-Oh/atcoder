import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        
        String d = scanner.next();
        HashMap<String, String> map = new HashMap<>();
        //N, E, W, S, NE, NW, SE, SW
        map.put("N", "S");
        map.put("E", "W");
        map.put("W", "E");
        map.put("S", "N");
        map.put("NE", "SW");
        map.put("NW", "SE");
        map.put("SE", "NW");
        map.put("SW", "NE");
        System.out.println(map.get(d));
    }
}
