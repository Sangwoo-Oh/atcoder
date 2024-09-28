import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        
        int[] X = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }

        long[] cumSum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            cumSum[i + 1] = cumSum[i] + P[i];
        }

        int Q = scanner.nextInt();

        for (int i = 0; i < Q; i++) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();

            int leftIndex = lowerBound(X, L);
            int rightIndex = upperBound(X, R) - 1;

            if (leftIndex <= rightIndex && leftIndex < N && rightIndex >= 0) {
                System.out.println(cumSum[rightIndex + 1] - cumSum[leftIndex]);
            } else {
                System.out.println(0);
            }
        }

        scanner.close();
    }

    static int lowerBound(int[] X, int target) {
        int low = 0, high = X.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (X[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upperBound(int[] X, int target) {
        int low = 0, high = X.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (X[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
