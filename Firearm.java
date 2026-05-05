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
