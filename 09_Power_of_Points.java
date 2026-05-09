import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[][] a = new long[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextLong();
                a[i][1] = i;
            }
            Arrays.sort(a, (o1, o2) -> Long.compare(o1[0], o2[0]));

            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + a[i][0];

            long[] ans = new long[n];
            for (int i = 0; i < n; i++) {
                long val = a[i][0];
                long left = (val * (i + 1)) - prefix[i + 1];
                long right = (prefix[n] - prefix[i]) - (val * (n - i));
                ans[(int) a[i][1]] = left + right + n;
            }

            StringBuilder sb = new StringBuilder();
            for (long x : ans) sb.append(x).append(" ");
            System.out.println(sb.toString().trim());
        }
    }
}