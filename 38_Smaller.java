import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int qCases = Integer.parseInt(br.readLine().trim());

        while (qCases-- > 0) {
            int q = Integer.parseInt(br.readLine().trim());

            // Initial states: both strings start as "a"
            long sLen = 1, tLen = 1;
            boolean sHasOther = false, tHasOther = false;

            for (int i = 0; i < q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                String x = st.nextToken();

                // Calculate if the string gets any non-'a' characters
                boolean containsOther = false;
                for (char c : x.toCharArray()) {
                    if (c != 'a') {
                        containsOther = true;
                        break;
                    }
                }

                if (type == 1) { // Modifying string s
                    sLen += k * x.length();
                    if (containsOther) sHasOther = true;
                } else { // Modifying string t
                    tLen += k * x.length();
                    if (containsOther) tHasOther = true;
                }

                // Greedy Check
                if (tHasOther) {
                    out.println("YES");
                } else {
                    if (!sHasOther && sLen < tLen) {
                        out.println("YES");
                    } else {
                        out.println("NO");
                    }
                }
            }
        }
        out.flush();
    }
}