import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();

            long operations = 0;
            long limit = a[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                if (a[i] > limit) {
                    // Calculate number of pieces: ceil(a[i] / limit)
                    long pieces = (a[i] + limit - 1) / limit;
                    
                    // Replacing one element with 'pieces' elements takes 'pieces - 1' ops
                    operations += (pieces - 1);
                    
                    // The new limit for the next element (a[i-1]) 
                    // is the value of the smallest piece
                    limit = a[i] / pieces;
                } else {
                    limit = a[i];
                }
            }
            System.out.println(operations);
        }
    }
}