// Darrien Raines-Boswell
// Course Project Phase #1
// Frontline Defense Inventory Application

public class App {
    public static void main(String[] args) {

        Inventory inventory = new Inventory("Frontline Defense Inventory");

        Handgun glock19x = new Handgun(
                "Glock 19X",
                "9mm",
                17,
                "Holosun 507Comp Green Dot",
                "TLR-8X Tactical Light"
        );

        Handgun glock26 = new Handgun(
                "Glock 26",
                "9mm",
                15,
                "Standard Sights",
                "Hogue Beavertail Grip with Glock 19 Magazine Extension"
        );

        Rifle db15 = new Rifle(
                "Diamondback DB15",
                "5.56 NATO",
                16.0,
                "West Hunter 1-6x24 Scope",
                "Magpul Foregrip and Bipod"
        );

        Rifle blackout = new Rifle(
                "PSA 300 Blackout",
                ".300 Blackout",
                10.5,
                "Iron Sights",
                "SG-30 Suppressor and Magpul Angled Grip"
        );

        Shotgun citadel = new Shotgun(
                "Citadel AK Shotgun",
                "12 Gauge",
                "Semi-Automatic",
                5,
                "AK-style magazine-fed shotgun"
        );

        inventory.addFirearm(glock19x);
        inventory.addFirearm(glock26);
        inventory.addFirearm(db15);
        inventory.addFirearm(blackout);
        inventory.addFirearm(citadel);

        System.out.println("Darrien Raines-Boswell - Frontline Defense Phase #1");
        System.out.println();

        inventory.displayInventory();
    }
}
