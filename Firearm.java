/*
 * Name: Darrien Raines-Boswell
 * Purpose: Abstract base class for all firearms
 */

import java.util.ArrayList;

public abstract class Firearm implements Trackable {

    private String brand;
    private String model;
    private String caliber;

    protected ArrayList<Attachment> attachments;

    public Firearm() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.caliber = "Unknown";
        attachments = new ArrayList<>();
    }

    public Firearm(String brand, String model, String caliber) {
        this.brand = brand;
        this.model = model;
        this.caliber = caliber;
        attachments = new ArrayList<>();
    }

    public void addAttachment(Attachment attachment) {
        attachments.add(attachment);
    }

    public void displayInfo() {
        System.out.println("Firearm: " + brand + " " + model);
        System.out.println("Caliber: " + caliber);

        System.out.println("Attachments:");
        for (Attachment a : attachments) {
            System.out.println("- " + a.getName());
        }

        trackItem();
    }

    public abstract void firearmType();

    protected String getModel() {
        return model;
    }
}
    public String getType() {
        return type;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void addAttachment(Attachment attachment) {
        attachments.add(attachment);
    }

    // Interface implementation
    @Override
    public String getTrackingSummary() {
        return manufacturer + " " + name + " | " + caliber + " | Attachments: " + attachments.size();
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Caliber: " + caliber);
        System.out.println("Type: " + type);
        displayAttachments();
    }

    public void displayAttachments() {
        System.out.println("Attachments:");
        if (attachments.isEmpty()) {
            System.out.println(" - None");
        } else {
            for (Attachment attachment : attachments) {
                System.out.println(" - " + attachment);
            }
        }
    }
}
