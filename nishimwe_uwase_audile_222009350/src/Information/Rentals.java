package Information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Rentals {
    private int id;
    private int start_date;
    private int end_date;
    private int total_cost;
    private int user_id;
    private int tool_id;

    public Rentals() {
        // Default constructor
    }

    public Rentals(int id, int start_date, int end_date, int total_cost, int user_id, int tool_id) {
        super();
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total_cost = total_cost;
        this.user_id = user_id;
        this.tool_id = tool_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart_date() {
        return start_date;
    }

    public void setStart_date(int start_date) {
        this.start_date = start_date;
    }

    public int getEnd_date() {
        return end_date;
    }

    public void setEnd_date(int end_date) {
        this.end_date = end_date;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTool_id() {
        return tool_id;
    }

    public void setTool_id(int tool_id) {
        this.tool_id = tool_id;
    }

    public void insertData() {
        String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
        String user = "root";
        String password = "";

        String sql = "INSERT INTO rentals (id, start_date, end_date, total_cost, user_id, tool_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setInt(1, this.id);
            preparedStatement.setInt(2, this.start_date);
            preparedStatement.setInt(3, this.end_date);
            preparedStatement.setInt(4, this.total_cost);
            preparedStatement.setInt(5, this.user_id);
            preparedStatement.setInt(6, this.tool_id);

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

        String sql = "UPDATE rentals SET start_date=?, end_date=?, total_cost=?, user_id=?, tool_id=? WHERE id=?";

        try (Connection con = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
        	
        	preparedStatement.setInt(1, this.id);
            preparedStatement.setInt(2, this.start_date);
            preparedStatement.setInt(3, this.end_date);
            preparedStatement.setInt(4, this.total_cost);
            preparedStatement.setInt(5, this.user_id);
            preparedStatement.setInt(6, this.tool_id);

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

        String sql = "DELETE FROM Rentals WHERE id=?";

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

        String sql = "SELECT * FROM Rentals";

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
