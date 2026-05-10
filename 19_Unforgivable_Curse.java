import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            String target = sc.next();

            if (solve(n, k, s, target)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean solve(int n, int k, String s, String t) {
        // Step 1: Check if they are anagrams
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int c : counts) if (c != 0) return false;

        // Step 2: Check indices that cannot move
        for (int i = 0; i < n; i++) {
            // If we can't jump k steps left AND can't jump k steps right
            if (i < k && i + k >= n) {
                if (s.charAt(i) != t.charAt(i)) return false;
            }
        }
        return true;
    }
}