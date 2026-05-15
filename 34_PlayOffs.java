import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        int ones = 0;
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
            else zeros++;
        }

        // min rank: you need to be better than 2^ones - 1 teams
        long minRank = (1L << ones); 
        
        // max rank: you need to have 2^zeros - 1 teams better than you
        long maxRank = (1L << n) - (1L << zeros) + 1;

        StringBuilder sb = new StringBuilder();
        for (long i = minRank; i <= maxRank; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}