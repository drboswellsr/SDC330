/*
 * Purpose: Rifle class extending Firearm
 */

public class Rifle extends Firearm {

    public Rifle(String brand, String model, String caliber) {
        super(brand, model, caliber);
    }

    @Override
    public void firearmType() {
        System.out.println("Type: Rifle");
    }
}
