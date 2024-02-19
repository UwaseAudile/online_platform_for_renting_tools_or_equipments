package Information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User {
    private int id;
    private String name;
    private String telephone;
    private String address;
    private String email;

    public User() {
        // Default constructor
    }

    public User(int id, String name, String telephone, String email, String address) {
        super();
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void insertData() {
        String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
        String user = "root";
        String password = "";

        String sql = "INSERT INTO User (ID, Name, Telephone, Email, Address) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {

            preparedStatement.setInt(1, this.id);
            preparedStatement.setString(2, this.name);
            preparedStatement.setString(3, this.telephone);
            preparedStatement.setString(4, this.email);
            preparedStatement.setString(5, this.address);

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

    // Implement updateData(), deleteData(), and viewData() methods similarly to Tool_equipments class if needed

    public void updateData() {
        String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
        String user = "root";
        String password = "";

        String sql = "UPDATE User SET Name=?, Telephone=?, Email=?, Address=? WHERE ID=?";

        try (Connection con = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {

            preparedStatement.setString(1, this.name);
            preparedStatement.setString(2, this.telephone);
            preparedStatement.setString(3, this.email);
            preparedStatement.setString(4, this.address);
            preparedStatement.setInt(5, this.id);

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

        String sql = "DELETE FROM User WHERE ID=?";

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

        String sql = "SELECT * FROM User";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

	public static boolean createUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public static User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
