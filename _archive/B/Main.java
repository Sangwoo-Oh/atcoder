import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String line = br.readLine();
            String[] token = line.split(" ");
            String s = token[0];
            String t = token[1];

            boolean result = false;
            for (int w = 1; w < s.length(); w++) {
                for (int c = 0; c < w; c++) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = c; i<s.length(); i += w) {
                        sb.append(s.charAt(i));
                    }
                    if (sb.toString().equals(t)) {
                        result = true;
                        break;
                    }
                }
            }

            if (result) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }


        } catch (IOException e) {}
    }

}
