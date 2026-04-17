/*
 * Name: Darrien Raines-Boswell
 * Date: April 16, 2026
 * Purpose: Derived class that extends Firearm with rifle-specific data. This file helps
 * demonstrate inheritance and polymorphism.
 */

public class Rifle extends Firearm {
    private double barrelLength;
    private String stockType;

    public Rifle(String name, String manufacturer, String caliber, String type,
                 double barrelLength, String stockType) {
        super(name, manufacturer, caliber, type);
        this.barrelLength = barrelLength;
        this.stockType = stockType;
    }

    public double getBarrelLength() {
        return barrelLength;
    }

    public String getStockType() {
        return stockType;
    }

    // Polymorphism is demonstrated here by overriding displayDetails()
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Barrel Length: " + barrelLength + " inches");
        System.out.println("Stock Type: " + stockType);
    }
}
