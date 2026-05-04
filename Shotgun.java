/*
 * Name: Darrien Raines-Boswell
 * Purpose: Shotgun class extending Firearm
 */

public class Shotgun extends Firearm {

    public Shotgun(String brand, String model, String caliber) {
        super(brand, model, caliber);
    }

    @Override
    public void firearmType() {
        System.out.println("Type: Shotgun");
    }
}
