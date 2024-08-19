import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long n = scanner.nextLong();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n%2);
            n /= 2;
        }
        sb.reverse();
        dfs(0, sb.toString(), "");
    }
    public static void dfs(int index, String bin, String ans) {
        if(bin.equals("")) {
            System.out.println(0);
            return;
        }
        if(index >= bin.length()) {
            System.out.println(Long.parseLong(ans, 2));
            return;
        }
        if(bin.charAt(index)=='1') {
            dfs(index+1, bin, ans+"0");
            dfs(index+1, bin, ans+"1");
        } else {
            dfs(index+1, bin, ans+"0");
        }
    }
}
