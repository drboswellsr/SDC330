// Darrien Raines-Boswell
// Inventory class using composition

import java.util.ArrayList;

public class Inventory {
    private String inventoryName;
    private ArrayList<Firearm> firearms;

    public Inventory(String inventoryName) {
        this.inventoryName = inventoryName;
        firearms = new ArrayList<>();
    }

    public void addFirearm(Firearm firearm) {
        firearms.add(firearm);
    }

    public void displayInventory() {
        System.out.println("Inventory Name: " + inventoryName);
        System.out.println("Total Firearms: " + firearms.size());
        System.out.println("--------------------------------");

        for (Firearm firearm : firearms) {
            System.out.println(firearm);
            System.out.println("--------------------------------");
        }
    }
}
