import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();

            StringBuilder res = new StringBuilder();
            HashSet<Character> seen = new HashSet<>();
            
            for (char c : s.toCharArray()) {
                if (c < 'a' + k) {
                    seen.add(c);
                    if (seen.size() == k) {
                        res.append(c); // This char finished a stage
                        seen.clear();
                    }
                }
            }

            if (res.length() >= n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
                // Find a character not in the current incomplete set
                char missing = 'a';
                for (int i = 0; i < k; i++) {
                    if (!seen.contains((char)('a' + i))) {
                        missing = (char)('a' + i);
                        break;
                    }
                }
                // Fill the rest of the string with the missing char
                while (res.length() < n) {
                    res.append(missing);
                }
                System.out.println(res.toString());
            }
        }
    }
}