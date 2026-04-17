/*
 * Name: Darrien Raines-Boswell
 * Date: April 16, 2026
 * Purpose: Represents an attachment that belongs to a firearm. This class is used to
 * demonstrate composition because a Firearm has Attachment objects.
 */

public class Attachment {
    private String name;
    private String category;

    public Attachment(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return category + ": " + name;
    }
}
