// Darrien Raines-Boswell
// Rifle class

public class Rifle extends Firearm {
    private double barrelLength;
    private String optic;
    private String accessory;

    public Rifle(String name, String caliber, double barrelLength, String optic, String accessory) {
        super(name, caliber);
        this.barrelLength = barrelLength;
        this.optic = optic;
        this.accessory = accessory;
    }

    public double getBarrelLength() {
        return barrelLength;
    }

    public String getOptic() {
        return optic;
    }

    public String getAccessory() {
        return accessory;
    }

    @Override
    public String getFirearmType() {
        return "Rifle";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nBarrel Length: " + barrelLength + " inches" +
                "\nOptic: " + optic +
                "\nAccessory: " + accessory;
    }
}
