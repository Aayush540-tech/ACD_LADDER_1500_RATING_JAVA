import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] pos = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pos[sc.nextInt()] = i;
            }

            // The two middle-most values
            int l = (n + 1) / 2;
            int r = (n + 2) / 2;

            // If the middle values are out of order, we must move everything
            if (pos[l] > pos[r]) {
                System.out.println((n + 1) / 2);
                continue;
            }

            // Expand from center: 
            // Can we keep (l-1) and (r+1) without moving them?
            while (l > 1 && r < n) {
                if (pos[l - 1] < pos[l] && pos[r + 1] > pos[r]) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            
            // The number of operations is the number of pairs outside [l, r]
            System.out.println(l - 1);
        }
    }
}