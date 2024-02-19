package Information;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Tool_equipments {
    private int id;
    private String name;
    private String description;
    private int price;

    public Tool_equipments() {
        // Default constructor
    }

    public Tool_equipments(int id, String name, String description, int price) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void insertData() {
        String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
        String user = "root";
        String password = "";

        String sql = "INSERT INTO Tool_equipments (ID, Name, Description, Price) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {

            preparedStatement.setInt(1, this.id);
            preparedStatement.setString(2, this.name);
            preparedStatement.setString(3, this.description);
            preparedStatement.setInt(4, this.price);

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

    // Implement updateData(), deleteData(), and viewData() methods similarly to UserProfile class if needed

public void updateData() {
    String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
    String user = "root";
    String password = "";

    String sql = "UPDATE Tool_equipments SET Name=?, Description=?, Price=? WHERE ID=?";

    try (Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

        preparedStatement.setString(1, this.name);
        preparedStatement.setString(2, this.description);
        preparedStatement.setInt(3, this.price);
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

    String sql = "DELETE FROM Tool_equipments WHERE ID=?";

    try (Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

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

    String sql = "SELECT * FROM Tool_equipments";

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