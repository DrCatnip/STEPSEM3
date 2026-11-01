import java.util.Scanner;
import java.util.HashSet;

// Class problem 3: n followed by n transaction IDs; IDs are case-sensitive.
public class TransactionDuplicateCheck {
    // Expected O(n) hash operations and O(n) extra space (for bounded ID lengths).
    // A nested-loop check uses O(1) extra space but O(n^2) time.
    // The set trades memory for speed on large transaction batches.
    public static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] transactionIds = new String[n];
        for (int i = 0; i < n; i++) {
            transactionIds[i] = sc.next();
        }
        System.out.println(hasDuplicate(transactionIds));
        sc.close();
    }
}
