import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = st.nextToken();
            int m = st.nextToken();
            int d = st.nextToken();

            int[] s = new int[m + 2];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            // Pad the boundaries
            s[0] = 1; 
            s[m + 1] = n + 1;

            // Step 1: Calculate initial cookies eaten
            int initialCookies = 0;
            
            // If there isn't a seller at bench 1, Petya still eats a cookie there
            if (s[1] != 1) {
                initialCookies++;
            }

            for (int i = 1; i <= m + 1; i++) {
                initialCookies += (s[i] - s[i - 1] - 1) / d;
                if (i <= m) {
                    initialCookies++; // Cookie eaten at the seller's bench
                }
            }

            // Step 2: Test removing each seller locally
            int minCookies = Integer.MAX_VALUE;
            int count = 0;

            for (int i = 1; i <= m; i++) {
                // Skip removing the padding helper if it happened to duplicate bench 1
                if (i == 1 && s[1] == 1) {
                    // Removing a seller at bench 1 when s[1] == 1 means Petya 
                    // STILL eats a cookie at bench 1 due to rule 1.
                    int withI = (s[2] - s[1] - 1) / d + 1;
                    int withoutI = (s[2] - 1 - 1) / d + 1; 
                    int currentTotal = initialCookies - withI + withoutI;
                    
                    if (currentTotal < minCookies) {
                        minCookies = currentTotal;
                        count = 1;
                    } else if (currentTotal == minCookies) {
                        count++;
                    }
                    continue;
                }

                int withI = ((s[i] - s[i - 1] - 1) / d) + ((s[i + 1] - s[i] - 1) / d) + 1;
                int withoutI = (s[i + 1] - s[i - 1] - 1) / d;

                int currentTotal = initialCookies - withI + withoutI;

                if (currentTotal < minCookies) {
                    minCookies = currentTotal;
                    count = 1;
                } else if (currentTotal == minCookies) {
                    count++;
                }
            }

            out.println(minCookies + " " + count);
        }
        out.flush();
    }
}