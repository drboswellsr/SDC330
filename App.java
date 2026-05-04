/*
 * Name: Darrien Raines-Boswell
 * Date: May 4, 2026
 * Purpose: Main application file - Week 3
 */

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Week 3 Project - Firearm Inventory");
        System.out.println("Darrien Raines-Boswell");
        System.out.println("=================================\n");

        // Attachments
        Attachment tlr8x = new Attachment("TLR-8X Tactical Light");
        Attachment comp = new Attachment("Strike Industries Compensator");
        Attachment hogueGrip = new Attachment("Hogue Beavertail Grip");

        Attachment surefire = new Attachment("SureFire Tactical Light");
        Attachment holosun507 = new Attachment("Holosun 507Comp Green Dot");

        Attachment extMag = new Attachment("Extended Glock 19 Mag (15rd)");

        Attachment scope = new Attachment("WestHunter 1-6x24 Scope");
        Attachment foregrip = new Attachment("Magpul Foregrip");
        Attachment bipod = new Attachment("Magpul Bipod");
        Attachment frt = new Attachment("FRT Trigger");

        Attachment suppressor = new Attachment("SG30 Suppressor");
        Attachment angledGrip = new Attachment("Magpul Angled Grip");
        Attachment brace = new Attachment("Maxim CQB Brace");
        Attachment holo510 = new Attachment("Holosun 510C + 3x Magnifier");

        Attachment romeo5 = new Attachment("Sig Sauer Romeo 5");

        // Pistols
        Pistol glock19x = new Pistol("Glock", "19X", "9mm");
        glock19x.addAttachment(tlr8x);
        glock19x.addAttachment(comp);
        glock19x.addAttachment(hogueGrip);

        Pistol canik = new Pistol("Canik", "TTI Combat", "9mm");
        canik.addAttachment(surefire);
        canik.addAttachment(holosun507);

        Pistol glock26 = new Pistol("Glock", "26", "9mm");
        glock26.addAttachment(hogueGrip);
        glock26.addAttachment(extMag);

        // Rifles
        Rifle db15 = new Rifle("Diamondback", "DB15", "5.56");
        db15.addAttachment(scope);
        db15.addAttachment(foregrip);
        db15.addAttachment(bipod);
        db15.addAttachment(frt);

        Rifle blackout = new Rifle("AR Platform", "10.5 300BLK", ".300 Blackout");
        blackout.addAttachment(suppressor);
        blackout.addAttachment(angledGrip);
        blackout.addAttachment(brace);
        blackout.addAttachment(holo510);

        // Shotgun
        Shotgun rss1 = new Shotgun("Citadel", "RSS-1", "12 Gauge");
        rss1.addAttachment(romeo5);

        // Store all firearms
        ArrayList<Firearm> inventory = new ArrayList<>();
        inventory.add(glock19x);
        inventory.add(canik);
        inventory.add(glock26);
        inventory.add(db15);
        inventory.add(blackout);
        inventory.add(rss1);

        // Display
        for (Firearm gun : inventory) {
            gun.displayInfo();
            System.out.println();
        }
    }
}
