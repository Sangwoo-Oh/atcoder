import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (Character c : line.toCharArray()) {
                if (c == 'R' || c == 'M') {
                    sb.append(c);
                }
            }
            if (sb.toString().equals("RM")) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } catch (IOException e) {}
    }

}
