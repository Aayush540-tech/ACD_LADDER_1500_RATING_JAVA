import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            
            int totalA = 0;
            List<Integer> blocks = new ArrayList<>();
            int currentBlock = 0;
            
            boolean canEatAll = (s.charAt(0) == 'B' || s.charAt(n - 1) == 'B');
            
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A') {
                    totalA++;
                    currentBlock++;
                } else {
                    // It's a B
                    if (i > 0 && s.charAt(i - 1) == 'B') canEatAll = true;
                    if (currentBlock > 0) {
                        blocks.add(currentBlock);
                        currentBlock = 0;
                    } else if (i > 0 && s.charAt(i-1) == 'B') {
                        // This handles the case of empty A-blocks between BB
                        blocks.add(0);
                    }
                }
            }
            if (currentBlock > 0) blocks.add(currentBlock);
            
            if (canEatAll || blocks.isEmpty()) {
                System.out.println(totalA);
            } else {
                int minBlock = Collections.min(blocks);
                System.out.println(totalA - minBlock);
            }
        }
    }
}