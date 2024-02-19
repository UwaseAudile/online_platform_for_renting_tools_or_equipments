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

import Information.Transaction;

public class TransactionForm implements ActionListener {
    JFrame frame;
    JLabel idLabel = new JLabel("ID");
    JLabel nameLabel = new JLabel("Name");
    JLabel dateLabel = new JLabel("Date");
    JLabel amountLabel = new JLabel("Amount");
    JLabel user_idLabel = new JLabel("User ID");
    JLabel tool_idLabel = new JLabel("Tool ID");

    JTextField idField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField dateField = new JTextField();
    JTextField amountField = new JTextField();
    JTextField user_idField = new JTextField();
    JTextField tool_idField = new JTextField();

    JButton insertButton = new JButton("INSERT");
    JButton viewButton = new JButton("VIEW");
    JButton updateButton = new JButton("UPDATE");
    JButton deleteButton = new JButton("DELETE");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    public TransactionForm() {
        createForm();
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Transaction Form");
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
        idLabel.setBounds(10, 10, 130, 30);
        nameLabel.setBounds(10, 50, 130, 30);
        dateLabel.setBounds(10, 90, 130, 30);
        amountLabel.setBounds(10, 130, 130, 30);
        user_idLabel.setBounds(10, 170, 130, 30);
        tool_idLabel.setBounds(10, 210, 130, 30);

        idField.setBounds(200, 10, 210, 30);
        nameField.setBounds(200, 50, 210, 30);
        dateField.setBounds(200, 90, 210, 30);
        amountField.setBounds(200, 130, 210, 30);
        user_idField.setBounds(200, 170, 210, 30);
        tool_idField.setBounds(200, 210, 210, 30);

        insertButton.setBounds(100, 250, 100, 30);
        viewButton.setBounds(210, 250, 100, 30);
        updateButton.setBounds(100, 290, 100, 30);
        deleteButton.setBounds(210, 290, 100, 30);

        table.setBounds(500, 10, 600, 250);

        setFontForAll();

        frame.add(idLabel);
        frame.add(nameLabel);
        frame.add(dateLabel);
        frame.add(amountLabel);
        frame.add(user_idLabel);
        frame.add(tool_idLabel);

        frame.add(idField);
        frame.add(nameField);
        frame.add(dateField);
        frame.add(amountField);
        frame.add(user_idField);
        frame.add(tool_idField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);
    }

    private void setFontForAll() {
        Font font = new Font("Arial", Font.BOLD, 14);
        idLabel.setFont(font);
        nameLabel.setFont(font);
        dateLabel.setFont(font);
        amountLabel.setFont(font);
        user_idLabel.setFont(font);
        tool_idLabel.setFont(font);

        idField.setFont(font);
        nameField.setFont(font);
        dateField.setFont(font);
        amountField.setFont(font);
        user_idField.setFont(font);
        tool_idField.setFont(font);

        Font italicFont = new Font("Arial", Font.ITALIC, 12);
        insertButton.setFont(italicFont);
        viewButton.setFont(italicFont);
        updateButton.setFont(italicFont);
        deleteButton.setFont(italicFont);
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
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishimwe_uwase_audile_opfrtoe", "222009350", "22009350");

                String sql = "INSERT INTO transaction VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setInt(1, Integer.parseInt(idField.getText()));
                stm.setString(2, nameField.getText());
                stm.setString(3, dateField.getText());
                stm.setString(4, amountField.getText());
                stm.setInt(5, Integer.parseInt(user_idField.getText()));
                stm.setInt(6, Integer.parseInt(tool_idField.getText()));
                int rowAffected = stm.executeUpdate();
                if (rowAffected > 0) {
                    JOptionPane.showMessageDialog(insertButton, "Inserted successfully!");
                    System.out.println("Insertion succeeded!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to insert data", "After insert", JOptionPane.ERROR_MESSAGE);
                }

                stm.close();
                con.close();

            } catch (SQLException | NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Please enter valid data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == viewButton) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("DATE");
            model.addColumn("AMOUNT");
            model.addColumn("USER ID");
            model.addColumn("TOOL ID");

            ResultSet resultSet = TransactionForm.ViewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[]{resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // Implement code to view data from the database and update the table
        } else if (e.getSource() == updateButton) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String date = dateField.getText();
                String amount = amountField.getText();
                int user_id = Integer.parseInt(user_idField.getText());
                int tool_id = Integer.parseInt(tool_idField.getText());

                TransactionForm tr = new TransactionForm();
                tr.updateData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid data!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            // Implement code to update data in the database
        } else if (e.getSource() == deleteButton) {
            // Implement code to delete data from the database
        }
    }

    private static ResultSet ViewData() {
        // TODO: Implement code to retrieve data from the database
        return null;
    }

    private void updateData() {
        // TODO: Implement code to update data in the database
    }

    public static void main(String[] args) {
        TransactionForm transactionForm = new TransactionForm();
    }
}
