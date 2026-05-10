import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            int[] dp = new int[n + 1];
            // Base case: dp[n] = 0 (an empty suffix is already beautiful)
            
            for (int i = n - 1; i >= 0; i--) {
                // Choice 1: Delete current element
                int deleteCost = 1 + dp[i + 1];
                
                // Choice 2: Treat as block header
                int keepCost = Integer.MAX_VALUE;
                if (i + a[i] < n) {
                    keepCost = dp[i + a[i] + 1];
                }
                
                dp[i] = Math.min(deleteCost, keepCost);
            }
            System.out.println(dp[0]);
        }
    }
}