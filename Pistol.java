// Darrien Raines-Boswell
// Pistol class

public class Pistol extends Firearm {
    private int magazineCapacity;
    private String optic;
    private String accessory;

    public Pistol(String name, String caliber, int magazineCapacity, String optic, String accessory) {
        super(name, caliber);
        this.magazineCapacity = magazineCapacity;
        this.optic = optic;
        this.accessory = accessory;
    }

    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    public String getOptic() {
        return optic;
    }

    public String getAccessory() {
        return accessory;
    }

    @Override
    public String getFirearmType() {
        return "Pistol";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nMagazine Capacity: " + magazineCapacity +
                "\nOptic: " + optic +
                "\nAccessory: " + accessory;
    }
}
