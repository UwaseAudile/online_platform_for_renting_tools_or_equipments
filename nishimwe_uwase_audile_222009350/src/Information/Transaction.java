package Information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Transaction {
    private int id;
    private String name;
    private int transactionDate;
    private int amount;
    private int user_id;
    private int tool_id;

    public Transaction() {}

    public Transaction(int id, String name, int transactionDate, int amount, int user_id, int tool_id) {
        super();
        this.id = id;
        this.name = name;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.user_id = user_id;
        this.tool_id = tool_id;
    }

    // Getters and Setters
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

    public int getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(int transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int userId) {
        this.user_id = user_id;
    }

    public int getTool_id() {
        return tool_id;
    }

    public void setTool_id(int toolId) {
        this.tool_id = tool_id;
    }

    public void insertData() {
        String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
        String user = "root";
        String password = "";

        String sql = "INSERT INTO transactions (ID, Name, TransactionDate, Amount, UserID, ToolID) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setInt(1, this.id);
            preparedStatement.setString(2, this.name);
            preparedStatement.setInt(3, this.transactionDate);
            preparedStatement.setInt(4, this.amount);
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

    // Implement updateData(), deleteData(), and viewData() methods if needed

public void updateData() {
    String host = "jdbc:mysql://localhost/nishimwe_uwase_audile_opfrtoe";
    String user = "root";
    String password = "";

    String sql = "UPDATE transactions SET Name=?, TransactionDate=?, Amount=?, UserID=?, ToolID=? WHERE ID=?";

    try (Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql)) {

        preparedStatement.setString(1, this.name);
        preparedStatement.setInt(2, this.transactionDate);
        preparedStatement.setInt(3, this.amount);
        preparedStatement.setInt(4, this.user_id);
        preparedStatement.setInt(5, this.tool_id);
        preparedStatement.setInt(6, this.id);

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

    String sql = "DELETE FROM transactions WHERE ID=?";

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

    String sql = "SELECT * FROM transactions";

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