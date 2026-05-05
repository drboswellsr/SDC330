// Darrien Raines-Boswell
// Abstract parent class for all firearms

public abstract class Firearm {
    private String name;
    private String caliber;

    public Firearm(String name, String caliber) {
        this.name = name;
        this.caliber = caliber;
    }

    public String getName() {
        return name;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public abstract String getFirearmType();

    @Override
    public String toString() {
        return "Type: " + getFirearmType() +
                "\nName: " + name +
                "\nCaliber: " + caliber;
    }
}
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
