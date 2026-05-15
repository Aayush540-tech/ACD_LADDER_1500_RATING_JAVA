import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(); // Total cells
            int m = sc.nextInt(); // Number of colors
            int k = sc.nextInt(); // Distance constraint

            int q = n / k;
            int r = n % k;
            
            boolean possible = true;
            int extraCount = 0;

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                if (a > q + 1) {
                    possible = false;
                }
                if (a == q + 1) {
                    extraCount++;
                }
            }

            if (possible && extraCount <= r) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}