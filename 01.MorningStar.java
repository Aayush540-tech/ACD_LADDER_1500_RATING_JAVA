import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Using Fast Reader for large input
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Long, Long> xMap = new HashMap<>();
            HashMap<Long, Long> yMap = new HashMap<>();
            HashMap<Long, Long> diffMap = new HashMap<>(); // x - y
            HashMap<Long, Long> sumMap = new HashMap<>();  // x + y
            
            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                
                xMap.put(x, xMap.getOrDefault(x, 0L) + 1);
                yMap.put(y, yMap.getOrDefault(y, 0L) + 1);
                diffMap.put(x - y, diffMap.getOrDefault(x - y, 0L) + 1);
                sumMap.put(x + y, sumMap.getOrDefault(x + y, 0L) + 1);
            }
            
            long totalPairs = 0;
            totalPairs += countPairs(xMap);
            totalPairs += countPairs(yMap);
            totalPairs += countPairs(diffMap);
            totalPairs += countPairs(sumMap);
            
            System.out.println(totalPairs);
        }
    }
    
    private static long countPairs(HashMap<Long, Long> map) {
        long count = 0;
        for (long val : map.values()) {
            count += val * (val - 1);
        }
        return count;
    }
}