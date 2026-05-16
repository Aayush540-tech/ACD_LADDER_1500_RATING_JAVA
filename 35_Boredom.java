import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // Find the maximum value in the input to size our arrays correctly
        int MAX = 100005;
        long[] count = new long[MAX];
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            count[num]++;
        }
        
        long[] dp = new long[MAX];
        dp[0] = 0;
        dp[1] = count[1]; // 1 * count[1]
        
        for (int i = 2; i < MAX; i++) {
            // Decision: Skip 'i' OR Take 'i' (which forces skipping 'i-1')
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * count[i]);
        }
        
        System.out.println(dp[MAX - 1]);
    }
}