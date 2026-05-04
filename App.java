/*
 * Name: Darrien Raines-Boswell
 * Date: May 4, 2026
 * Purpose: Week 4 Project - Firearm Inventory Application using SQLite CRUD operations.
 */

import java.sql.*;
import java.util.Scanner;

public class App {

    private static final String DB_URL = "jdbc:sqlite:frontline_inventory.db";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        createTable();

        System.out.println("======================================");
        System.out.println(" Project Week 4 - Database Interaction");
        System.out.println(" Frontline Defense Inventory System");
        System.out.println(" Darrien Raines-Boswell");
        System.out.println("======================================");
        System.out.println("Welcome! Manage firearm inventory using CRUD operations.");

        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Firearm");
            System.out.println("2. View All Firearms");
            System.out.println("3. Update Firearm");
            System.out.println("4. Delete Firearm");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addFirearm(input);
                    break;
                case 2:
                    viewFirearms();
                    break;
                case 3:
                    updateFirearm(input);
                    break;
                case 4:
                    deleteFirearm(input);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
    }

    // CREATE TABLE
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS firearms ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "caliber TEXT NOT NULL, "
                + "accessory TEXT NOT NULL, "
                + "purpose TEXT NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    // CREATE
    public static void addFirearm(Scanner input) {
        System.out.print("Firearm name: ");
        String name = input.nextLine();

        System.out.print("Caliber/Gauge: ");
        String caliber = input.nextLine();

        System.out.print("Accessory: ");
        String accessory = input.nextLine();

        System.out.print("Purpose: ");
        String purpose = input.nextLine();

        String sql = "INSERT INTO firearms(name, caliber, accessory, purpose) VALUES(?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, caliber);
            pstmt.setString(3, accessory);
            pstmt.setString(4, purpose);
            pstmt.executeUpdate();

            System.out.println("✔ Firearm added.");

        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    // READ
    public static void viewFirearms() {
        String sql = "SELECT * FROM firearms";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n===== FIREARM INVENTORY =====");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Caliber: " + rs.getString("caliber"));
                System.out.println("Accessory: " + rs.getString("accessory"));
                System.out.println("Purpose: " + rs.getString("purpose"));
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }

    // UPDATE
    public static void updateFirearm(Scanner input) {
        System.out.print("Enter ID to update: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("New name: ");
        String name = input.nextLine();

        System.out.print("New caliber: ");
        String caliber = input.nextLine();

        System.out.print("New accessory: ");
        String accessory = input.nextLine();

        System.out.print("New purpose: ");
        String purpose = input.nextLine();

        String sql = "UPDATE firearms SET name=?, caliber=?, accessory=?, purpose=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, caliber);
            pstmt.setString(3, accessory);
            pstmt.setString(4, purpose);
            pstmt.setInt(5, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✔ Updated.");
            } else {
                System.out.println("No record found.");
            }

        } catch (SQLException e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }

    // DELETE
    public static void deleteFirearm(Scanner input) {
        System.out.print("Enter ID to delete: ");
        int id = input.nextInt();

        String sql = "DELETE FROM firearms WHERE id=?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✔ Deleted.");
            } else {
                System.out.println("No record found.");
            }

        } catch (SQLException e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
}
