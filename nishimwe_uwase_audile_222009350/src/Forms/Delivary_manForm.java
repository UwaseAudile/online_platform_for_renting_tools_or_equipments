package Forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Delivary_manForm implements ActionListener {
    JFrame frame;
    JLabel idLabel = new JLabel("ID");
    JLabel nameLabel = new JLabel("Name");
    JLabel telephoneLabel = new JLabel("Telephone");
    JLabel emailLabel = new JLabel("Email");

    JTextField idField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField telephoneField = new JTextField();
    JTextField emailField = new JTextField();

    JButton insertButton = new JButton("INSERT");
    JButton viewButton = new JButton("VIEW");
    JButton updateButton = new JButton("UPDATE");
    JButton deleteButton = new JButton("DELETE");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    public Delivary_manForm() {
        createForm();
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Delivery Man Form");
        frame.setBounds(0, 0, screenWidth / 2, screenHeight / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setLayout(null);
        frame.setResizable(true);
        frame.setVisible(true);

        setLocationAndSize();
        addActionListeners();
    }

    private void setLocationAndSize() {
        idLabel.setBounds(10, 10, 150, 30);
        nameLabel.setBounds(10, 50, 150, 30);
        telephoneLabel.setBounds(10, 90, 150, 30);
        emailLabel.setBounds(10, 130, 150, 30);

        idField.setBounds(160, 10, 200, 30);
        nameField.setBounds(160, 50, 200, 30);
        telephoneField.setBounds(160, 90, 200, 30);
        emailField.setBounds(160, 130, 200, 30);

        insertButton.setBounds(10, 170, 100, 30);
        viewButton.setBounds(120, 170, 100, 30);
        updateButton.setBounds(10, 210, 100, 30);
        deleteButton.setBounds(120, 210, 100, 30);

        table.setBounds(500, 10, 600, 250);

        setFontForAll();

        frame.add(idLabel);
        frame.add(nameLabel);
        frame.add(telephoneLabel);
        frame.add(emailLabel);

        frame.add(idField);
        frame.add(nameField);
        frame.add(telephoneField);
        frame.add(emailField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        idLabel.setFont(font);
        nameLabel.setFont(font);
        telephoneLabel.setFont(font);
        emailLabel.setFont(font);

        idField.setFont(font);
        nameField.setFont(font);
        telephoneField.setFont(font);
        emailField.setFont(font);

        insertButton.setFont(font);
        viewButton.setFont(font);
        updateButton.setFont(font);
        deleteButton.setFont(font);
    }

    private void addActionListeners() {
        insertButton.addActionListener(this);
        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertButton) {
            performInsertAction();
        } else if (e.getSource() == viewButton) {
            performViewAction();
        } else if (e.getSource() == updateButton) {
            performUpdateAction();
        } else if (e.getSource() == deleteButton) {
            performDeleteAction();
        }
    }

    private void performInsertAction() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishimwe_uwase_audile_opfrtoe", "root", "");
            String sql = "INSERT INTO Delivary_man VALUES(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(idField.getText()));
            stm.setString(2, nameField.getText());
            stm.setString(3, telephoneField.getText());
            stm.setString(4, emailField.getText());
            int rowAffected = stm.executeUpdate();
            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(insertButton, "Inserted successfully!");
                System.out.print("Insertion succeed!");
            } else {
                JOptionPane.showMessageDialog(null, "Fail to insert data", "After insert", JOptionPane.ERROR_MESSAGE);
            }
            stm.executeUpdate();
            con.close();
            stm.close();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void performViewAction() {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Telephone");
        model.addColumn("Email");

        ResultSet resultSet = viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[]{
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    });
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void performUpdateAction() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishimwe_uwase_audile_opfrtoe", "root", "");
            String sql = "UPDATE Delivary_man SET Name=?, Telephone=?, Email=? WHERE ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, nameField.getText());
            preparedStatement.setString(2, telephoneField.getText());
            preparedStatement.setString(3, emailField.getText());
            preparedStatement.setInt(4, Integer.parseInt(idField.getText()));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(updateButton, "Data updated successfully!");
                System.out.println("Data updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update data", "After update", JOptionPane.ERROR_MESSAGE);
                System.out.println("Failed to update data.");
            }

            preparedStatement.executeUpdate();
            con.close();
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void performDeleteAction() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishimwe_uwase_audile_opfrtoe", "root", "");
            String sql = "DELETE FROM Delivary_man WHERE ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(idField.getText()));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(deleteButton, "Data deleted successfully!");
                System.out.println("Data deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete data", "After delete", JOptionPane.ERROR_MESSAGE);
                System.out.println("Failed to delete data.");
            }

            preparedStatement.executeUpdate();
            con.close();
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static ResultSet viewData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishimwe_uwase_audile_opfrtoe", "222009350", "222009350");
            String sql = "SELECT * FROM Delivary_man";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Delivary_manForm DMF = new Delivary_manForm();
    }
}
