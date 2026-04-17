/*
 * Name: Darrien Raines-Boswell
 * Date: April 16, 2026
 * Purpose: Base class for all firearm objects. This class stores shared firearm data,
 * demonstrates composition by containing Attachment objects, and implements the
 * Trackable interface.
 */

import java.util.ArrayList;

public class Firearm implements Trackable {
    private String name;
    private String manufacturer;
    private String caliber;
    private String type;
    private ArrayList<Attachment> attachments;

    public Firearm(String name, String manufacturer, String caliber, String type) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.caliber = caliber;
        this.type = type;
        this.attachments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCaliber() {
        return caliber;
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
