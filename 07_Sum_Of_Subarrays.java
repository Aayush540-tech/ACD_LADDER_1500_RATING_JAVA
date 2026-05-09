import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int m = 0;
            while ((m + 1) * (m + 2) / 2 <= k) {
                m++;
            }
            
            int[] arr = new int[n];
            // Fill default negative
            Arrays.fill(arr, -1000);
            
            // Fill full positive segments
            for (int i = 0; i < m; i++) {
                arr[i] = 2;
            }
            
            int rem = k - (m * (m + 1) / 2);
            if (rem > 0) {
                // The "bridge" element
                arr[m] = -2 * (m - rem + 1) + 1;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(i == n - 1 ? "" : " ");
            }
            System.out.println(sb.toString());
        }
    }
}