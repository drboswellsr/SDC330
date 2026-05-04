/*
 * Purpose: Interface for tracking items
 */

public interface Trackable {

    default void trackItem() {
        System.out.println("Tracking item in inventory...");
    }
}
