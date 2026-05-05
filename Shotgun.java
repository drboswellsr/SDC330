// Darrien Raines-Boswell
// Shotgun class

public class Shotgun extends Firearm {
    private String actionType;
    private int magazineCapacity;
    private String notes;

    public Shotgun(String name, String caliber, String actionType, int magazineCapacity, String notes) {
        super(name, caliber);
        this.actionType = actionType;
        this.magazineCapacity = magazineCapacity;
        this.notes = notes;
    }

    public String getActionType() {
        return actionType;
    }

    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String getFirearmType() {
        return "Shotgun";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nAction Type: " + actionType +
                "\nMagazine Capacity: " + magazineCapacity +
                "\nNotes: " + notes;
    }
}
