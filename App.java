/*
 * Name: Darrien Raines-Boswell
 * Date: April 16, 2026
 * Purpose: Main application file for Project Week 2. This program displays a welcome
 * message, demonstrates the use of an interface, demonstrates polymorphism, creates
 * realistic firearm objects, and displays the stored information to the user.
 */

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.println("Project Week 2 - Inheritance, Composition, and User Interactions");
        System.out.println("Student: Darrien Raines-Boswell");
        System.out.println("Application: Frontline Defense Firearm Tracker");
        System.out.println("------------------------------------------------------------");
        System.out.println("Welcome to the Frontline Defense Firearm Tracker.");
        System.out.println("This sample application displays firearms and attachments");
        System.out.println("to demonstrate inheritance, composition, interfaces, and polymorphism.");
        System.out.println();

        Rifle rifle = new Rifle("AR Pistol", "PSA", ".300 Blackout", "Rifle", 10.5, "Maxim CQB Brace");
        rifle.addAttachment(new Attachment("Holosun 510C Green Dot", "Optic"));
        rifle.addAttachment(new Attachment("Daniel Defense SG-30", "Suppressor"));
        rifle.addAttachment(new Attachment("Hand Stop", "Control"));

        Pistol pistol = new Pistol("Glock 19", "Glock", "9mm", "Pistol", "Compact", 15);
        pistol.addAttachment(new Attachment("Streamlight TLR-7A", "Light"));
        pistol.addAttachment(new Attachment("AmeriGlo Night Sights", "Sight"));

        ArrayList<Firearm> firearms = new ArrayList<>();
        firearms.add(rifle);
        firearms.add(pistol);

        System.out.println("FIREARM INVENTORY");
        System.out.println("------------------------------------------------------------");

        for (Firearm firearm : firearms) {
            // Polymorphism is demonstrated here because each object uses its
            // own overridden displayDetails() method.
            firearm.displayDetails();
            System.out.println("Tracking Summary: " + firearm.getTrackingSummary());
            System.out.println("------------------------------------------------------------");
        }

        // The interface is demonstrated because Firearm implements Trackable.
        Trackable trackedItem = rifle;
        System.out.println("INTERFACE DEMONSTRATION");
        System.out.println("Tracked Item Summary: " + trackedItem.getTrackingSummary());
        System.out.println();

        System.out.println("Thank you for using Frontline Defense Firearm Tracker.");
        System.out.println("Defend Your Own.");
    }
}
