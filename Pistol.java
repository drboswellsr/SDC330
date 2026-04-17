/*
 * Name: Darrien Raines-Boswell
 * Date: April 16, 2026
 * Purpose: Derived class that extends Firearm with pistol-specific data. This file helps
 * demonstrate inheritance and polymorphism.
 */

public class Pistol extends Firearm {
    private String frameSize;
    private int capacity;

    public Pistol(String name, String manufacturer, String caliber, String type,
                  String frameSize, int capacity) {
        super(name, manufacturer, caliber, type);
        this.frameSize = frameSize;
        this.capacity = capacity;
    }

    public String getFrameSize() {
        return frameSize;
    }

    public int getCapacity() {
        return capacity;
    }

    // Polymorphism is demonstrated here by overriding displayDetails()
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Frame Size: " + frameSize);
        System.out.println("Magazine Capacity: " + capacity);
    }
}
