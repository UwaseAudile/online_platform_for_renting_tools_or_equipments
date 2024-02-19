package Information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Location {
    private int id;
    private String name;
    private int user_id;
    private int delivery_man_id;

    public Location() {
        // Default constructor
    }

    public Location(int id, String name, int user_id, int delivery_man_id) {
        super();
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        this.delivery_man_id = delivery_man_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDelivery_man_id() {
        return delivery_man_id;
    }

    public void setDelivery_man_id(int delivery_man_id) {
        this.delivery_man_id = delivery_man_id;
    }

    public void insertData() {
        String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
        String user = "root";
        String password = "";

        String sql = "INSERT INTO Location (id, name, user_id, delivery_man_id) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setInt(1, this.id);
            preparedStatement.setString(2, this.name);
            preparedStatement.setInt(3, this.user_id);
            preparedStatement.setInt(4, this.delivery_man_id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
        String user = "root";
        String password = "";

        String sql = "UPDATE Location SET name=?, user_id=?, delivery_man_id=? WHERE id=?";

        try (Connection con = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, this.name);
            preparedStatement.setInt(2, this.user_id);
            preparedStatement.setInt(3, this.delivery_man_id);
            preparedStatement.setInt(4, this.id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
                JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to update data.");
                JOptionPane.showMessageDialog(null, "Failed to update data!", "After update",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData() {
        String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
        String user = "root";
        String password = "";

        String sql = "DELETE FROM Location WHERE id=?";

        try (Connection con = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setInt(1, this.id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to delete data.");
                JOptionPane.showMessageDialog(null, "Failed to delete data!", "After delete",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
        String user = "222009350";
        String password = "222009350";

        String sql = "SELECT * FROM Location";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
