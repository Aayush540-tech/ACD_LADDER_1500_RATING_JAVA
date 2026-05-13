import java.util.*;

public class Main {
    static long[] cost;
    static long[] memo;
    static List<Integer>[] adj;
    static boolean[] isInfinite;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            cost = new long[n + 1];
            memo = new long[n + 1];
            Arrays.fill(memo, -1);
            isInfinite = new boolean[n + 1];
            adj = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                cost[i] = sc.nextLong();
                adj[i] = new ArrayList<>();
            }

            // Potions available for free
            for (int i = 0; i < k; i++) {
                isInfinite[sc.nextInt()] = true;
            }

            // Recipes
            for (int i = 1; i <= n; i++) {
                int m = sc.nextInt();
                for (int j = 0; j < m; j++) {
                    adj[i].add(sc.nextInt());
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(getMinCost(i) + (i == n ? "" : " "));
            }
            System.out.println();
        }
    }

    static long getMinCost(int v) {
        if (isInfinite[v]) return 0;
        if (memo[v] != -1) return memo[v];
        
        // If no ingredients, must buy it
        if (adj[v].isEmpty()) return memo[v] = cost[v];

        long mixCost = 0;
        for (int ingredient : adj[v]) {
            mixCost += getMinCost(ingredient);
        }

        return memo[v] = Math.min(cost[v], mixCost);
    }
}