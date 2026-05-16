import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n + 1];
            List<Integer> nonZeroIdx = new ArrayList<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] != 0) {
                    nonZeroIdx.add(i);
                }
            }
            
            // If total count of non-zero elements is odd, sum 0 is impossible
            if (nonZeroIdx.size() % 2 != 0) {
                out.println("-1");
                continue;
            }
            
            List<int[]> segments = new ArrayList<>();
            int lastProcessed = 0;
            
            for (int k = 0; k < nonZeroIdx.size(); k += 2) {
                int i = nonZeroIdx.get(k);
                int j = nonZeroIdx.get(k + 1);
                
                // Clear out the independent zeros leading up to the current pair
                for (int m = lastProcessed + 1; m < i; m++) {
                    segments.add(new int[]{m, m});
                }
                
                if (a[i] == a[j]) {
                    if ((j - i) % 2 != 0) {
                        segments.add(new int[]{i, j});
                    } else {
                        segments.add(new int[]{i, i});
                        for (int m = i + 1; m < j - 1; m++) {
                            segments.add(new int[]{m, m});
                        }
                        segments.add(new int[]{j - 1, j});
                    }
                } else {
                    if ((j - i) % 2 != 0) {
                        segments.add(new int[]{i, j - 1});
                        segments.add(new int[]{j, j});
                    } else {
                        segments.add(new int[]{i, j});
                    }
                }
                lastProcessed = j;
            }
            
            // Clear out any trailing zeros at the end of the array
            for (int m = lastProcessed + 1; m <= n; m++) {
                segments.add(new int[]{m, m});
            }
            
            out.println(segments.size());
            for (int[] seg : segments) {
                out.println(seg[0] + " " + seg[1]);
            }
        }
        out.flush();
    }
}