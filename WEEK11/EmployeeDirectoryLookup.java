import java.util.Scanner;
import java.util.HashMap;

// Class problem 4: n, n lines of ID and department; then q and q employee IDs.
class EmployeeRecord {
    String employeeId;
    String department;

    EmployeeRecord(String employeeId, String department) {
        this.employeeId = employeeId;
        this.department = department;
    }
}

public class EmployeeDirectoryLookup {
    // Expected O(n) build time and O(n) space for bounded-length IDs.
    // Build once for many queries; rare updates can also update this map.
    public static HashMap<String, String> buildLookup(EmployeeRecord[] records) {
        HashMap<String, String> lookup = new HashMap<>();
        for (EmployeeRecord record : records) {
            lookup.put(record.employeeId, record.department);
        }
        return lookup;
    }

    // Expected O(1) time per query for bounded-length IDs.
    public static String getDepartment(HashMap<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        EmployeeRecord[] records = new EmployeeRecord[n];
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String department = sc.nextLine().trim();
            records[i] = new EmployeeRecord(id, department);
        }
        HashMap<String, String> lookup = buildLookup(records);
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            System.out.println(getDepartment(lookup, sc.next()));
        }
        sc.close();
    }
}
