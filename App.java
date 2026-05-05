// Darrien Raines-Boswell
// Course Project Phase #2
// Frontline Defense Inventory Application
// Purpose: Phase #2 - Firearm Inventory Application using SQLite CRUD operations.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class App {

    private static final String DB_URL = "jdbc:sqlite:frontline_inventory.db";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        createTable();

        int choice = 0;

        do {
            System.out.println("\nDarrien Raines-Boswell - Course Project Phase #2");
            System.out.println("Frontline Defense Inventory System");
            System.out.println("-----------------------------------");
            System.out.println("1. Add Firearm");
            System.out.println("2. View Firearms");
            System.out.println("3. Update Firearm");
            System.out.println("4. Delete Firearm");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addFirearm(scanner);
                    break;
                case 2:
                    viewFirearms();
                    break;
                case 3:
                    updateFirearm(scanner);
                    break;
                case 4:
                    deleteFirearm(scanner);
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS firearms ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "type TEXT NOT NULL, "
                + "caliber TEXT NOT NULL, "
                + "capacity INTEGER, "
                + "barrel_length REAL, "
                + "optic TEXT, "
                + "accessory TEXT, "
                + "action_type TEXT, "
                + "notes TEXT"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Database ready.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void addFirearm(Scanner scanner) {
        System.out.print("Enter firearm name: ");
        String name = scanner.nextLine();

        System.out.print("Enter firearm type (Pistol/Rifle/Shotgun): ");
        String type = scanner.nextLine();

        System.out.print("Enter caliber: ");
        String caliber = scanner.nextLine();

        System.out.print("Enter magazine capacity: ");
        int capacity = scanner.nextInt();

        System.out.print("Enter barrel length: ");
        double barrelLength = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter optic: ");
        String optic = scanner.nextLine();

        System.out.print("Enter accessory: ");
        String accessory = scanner.nextLine();

        System.out.print("Enter action type: ");
        String actionType = scanner.nextLine();

        System.out.print("Enter notes: ");
        String notes = scanner.nextLine();

        String sql = "INSERT INTO firearms "
                + "(name, type, caliber, capacity, barrel_length, optic, accessory, action_type, notes) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, type);
            pstmt.setString(3, caliber);
            pstmt.setInt(4, capacity);
            pstmt.setDouble(5, barrelLength);
            pstmt.setString(6, optic);
            pstmt.setString(7, accessory);
            pstmt.setString(8, actionType);
            pstmt.setString(9, notes);

            pstmt.executeUpdate();
            System.out.println("Firearm added successfully.");

        } catch (SQLException e) {
            System.out.println("Add error: " + e.getMessage());
        }
    }

    public static void viewFirearms() {
        String sql = "SELECT * FROM firearms;";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nFirearm Inventory");
            System.out.println("-----------------------------------");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("Caliber: " + rs.getString("caliber"));
                System.out.println("Capacity: " + rs.getInt("capacity"));
                System.out.println("Barrel Length: " + rs.getDouble("barrel_length"));
                System.out.println("Optic: " + rs.getString("optic"));
                System.out.println("Accessory: " + rs.getString("accessory"));
                System.out.println("Action Type: " + rs.getString("action_type"));
                System.out.println("Notes: " + rs.getString("notes"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("View error: " + e.getMessage());
        }
    }

    public static void updateFirearm(Scanner scanner) {
        System.out.print("Enter firearm ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new firearm name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new firearm type: ");
        String type = scanner.nextLine();

        System.out.print("Enter new caliber: ");
        String caliber = scanner.nextLine();

        System.out.print("Enter new magazine capacity: ");
        int capacity = scanner.nextInt();

        System.out.print("Enter new barrel length: ");
        double barrelLength = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter new optic: ");
        String optic = scanner.nextLine();

        System.out.print("Enter new accessory: ");
        String accessory = scanner.nextLine();

        System.out.print("Enter new action type: ");
        String actionType = scanner.nextLine();

        System.out.print("Enter new notes: ");
        String notes = scanner.nextLine();

        String sql = "UPDATE firearms SET "
                + "name = ?, "
                + "type = ?, "
                + "caliber = ?, "
                + "capacity = ?, "
                + "barrel_length = ?, "
                + "optic = ?, "
                + "accessory = ?, "
                + "action_type = ?, "
                + "notes = ? "
                + "WHERE id = ?;";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, type);
            pstmt.setString(3, caliber);
            pstmt.setInt(4, capacity);
            pstmt.setDouble(5, barrelLength);
            pstmt.setString(6, optic);
            pstmt.setString(7, accessory);
            pstmt.setString(8, actionType);
            pstmt.setString(9, notes);
            pstmt.setInt(10, id);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Firearm updated successfully.");
            } else {
                System.out.println("No firearm found with that ID.");
            }

        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }

    public static void deleteFirearm(Scanner scanner) {
        System.out.print("Enter firearm ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM firearms WHERE id = ?;";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Firearm deleted successfully.");
            } else {
                System.out.println("No firearm found with that ID.");
            }

        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }
}
