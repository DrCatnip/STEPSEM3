import java.util.*;
public class WarehouseInventoryBalancer {
    public void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        for (int quantity : sectionA) {
            totalA += quantity;
        }

        for(int quantity : sectionB) {
            totalB += quantity;
        }

        String Status;
        if (totalA == totalB) {
            Status = "Balanced";
        } else {
            Status = "Unbalanced";
        }
        int highestQuantity = sectionA[0];
        String HighestSection = "section A";
        int highestIndex = 0;
        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                HighestSection = "section A";
                highestIndex = i;
            }
        }

        for(int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                HighestSection = "section B";
                highestIndex = i;
            }
        }

        System.out.println("\n warehouse Inventory Analysis:");
        System.out.println("Total quantity in section A: " + totalA);
        System.out.println("Total quantity in section B: " + totalB);
        System.out.println("Inventory Status: " + Status);

        System.out.println("Highest quantity is: " + highestQuantity + " in " + HighestSection + ", item " + (highestIndex + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        int[] sectionA = new int[n];
        int[] sectionB = new int[n];
        System.out.println("\nEnter quantities for section A:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionA[i] = sc.nextInt();
        }
        System.out.println("\nEnter quantities for section B:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionB[i] = sc.nextInt();
        }
        WarehouseInventoryBalancer obj = new WarehouseInventoryBalancer();
        obj.analyzeInventory(sectionA, sectionB);
    }
}