import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long k = sc.nextLong();
            StringBuilder res = new StringBuilder();

            // Manual Base 9 Conversion
            while (k > 0) {
                long digit = k % 9; // Get remainder
                
                // Map the digit to skip '4'
                if (digit >= 4) {
                    res.append(digit + 1);
                } else {
                    res.append(digit);
                }
                
                k /= 9; // Get quotient
            }

            // Since we collected remainders from smallest to largest place value,
            // we must reverse the string at the end.
            System.out.println(res.reverse().toString());
        }
    }
}