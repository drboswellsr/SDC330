/*
 * Purpose: Pistol class extending Firearm
 */

public class Pistol extends Firearm {

    public Pistol(String brand, String model, String caliber) {
        super(brand, model, caliber);
    }

    @Override
    public void firearmType() {
        System.out.println("Type: Pistol");
    }
}
