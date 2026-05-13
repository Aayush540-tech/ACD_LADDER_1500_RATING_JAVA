import java.util.*;

public class Main {
    // Helper class to keep track of original index after sorting
    static class Item {
        int freq, id;
        Item(int f, int i) { freq = f; id = i; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            
            Item[] items = new Item[n];
            for (int i = 0; i < n; i++) {
                items[i] = new Item(sc.nextInt(), i + 1);
            }

            // Sort by frequency descending (High frequency items first)
            Arrays.sort(items, (a, b) -> b.freq - a.freq);

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            for (Item item : items) {
                // Calculate time cost for the next available slot in each list
                long timeWithS1 = (long)(list1.size() + 1) * s1;
                long timeWithS2 = (long)(list2.size() + 1) * s2;

                if (timeWithS1 < timeWithS2) {
                    list1.add(item.id);
                } else {
                    list2.add(item.id);
                }
            }

            // Print List 1
            printList(list1);
            // Print List 2
            printList(list2);
        }
    }

    static void printList(List<Integer> list) {
        System.out.print(list.size());
        for (int x : list) System.out.print(" " + x);
        System.out.println();
    }
}