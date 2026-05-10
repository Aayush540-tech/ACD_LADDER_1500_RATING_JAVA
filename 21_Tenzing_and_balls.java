import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = sc.nextInt();

            long[] dp = new long[n + 1];
            long[] best = new long[n + 1];
            Arrays.fill(best, (long)-1e18);

            for (int i = 1; i <= n; i++) {
                int color = a[i];
                
                // Max if we don't remove this ball
                dp[i] = dp[i - 1];
                
                // Max if we remove a segment ending here
                dp[i] = Math.max(dp[i], i + 1 + best[color]);
                
                // Update the "best" j-1 we've seen for this color
                best[color] = Math.max(best[color], dp[i - 1] - i);
            }
            System.out.println(dp[n]);
        }
    }
}