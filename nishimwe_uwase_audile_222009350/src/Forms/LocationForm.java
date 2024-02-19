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
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Information.Location;
import Information.Tool_equipments;

public class LocationForm implements ActionListener {
    JFrame frame;
    JLabel idLabel = new JLabel("ID");
    JLabel nameLabel = new JLabel("Name");
    JLabel user_idLabel = new JLabel("User ID");
    JLabel delivery_man_idLabel = new JLabel("Delivery Man ID");

    JTextField idField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField user_idField = new JTextField();
    JTextField delivery_man_idField = new JTextField();

    JButton insertButton = new JButton("INSERT");
    JButton viewButton = new JButton("VIEW");
    JButton updateButton = new JButton("UPDATE");
    JButton deleteButton = new JButton("DELETE");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    public LocationForm() {
        createForm();
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Location Form");
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
        user_idLabel.setBounds(10, 90, 150, 30);
        delivery_man_idLabel.setBounds(10, 130, 150, 30);

        idField.setBounds(160, 10, 200, 30);
        nameField.setBounds(160, 50, 200, 30);
        user_idField.setBounds(160, 90, 200, 30);
        delivery_man_idField.setBounds(160, 130, 200, 30);

        insertButton.setBounds(10, 170, 100, 30);
        viewButton.setBounds(100, 170, 100, 30);
        updateButton.setBounds(190, 170, 100, 30);
        deleteButton.setBounds(280, 170, 100, 30);

        table.setBounds(500, 10, 600, 250);

        setFontForAll();

        frame.add(idLabel);
        frame.add(nameLabel);
        frame.add(user_idLabel);
        frame.add(delivery_man_idLabel);

        frame.add(idField);
        frame.add(nameField);
        frame.add(user_idField);
        frame.add(delivery_man_idField);

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
        user_idLabel.setFont(font);
        delivery_man_idLabel.setFont(font);

        idField.setFont(font);
        nameField.setFont(font);
        user_idField.setFont(font);
        delivery_man_idField.setFont(font);

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
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/nishimwe_uwase_audile_opfrtoe", "222009350", "222009350");
                String sql = "INSERT INTO location VALUES(?,?,?,?)";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setInt(1, Integer.parseInt(idField.getText()));
                stm.setString(2, nameField.getText());
                stm.setInt(3, Integer.parseInt(user_idField.getText()));
                stm.setInt(4, Integer.parseInt(delivery_man_idField.getText()));

                int rowAffected = stm.executeUpdate();
                if (rowAffected > 0) {
                    JOptionPane.showMessageDialog(insertButton, "Inserted successfully!");
                    System.out.println("Insertion succeed!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to insert data", "After insert",
                            JOptionPane.ERROR_MESSAGE);
                }
                con.close();
                stm.close();

            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == viewButton) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("USER ID ");
            model.addColumn("DELIVARY MAN ID");

            ResultSet resultSet = Location.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getInt(4) });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // Add code for viewing data from the location table
        } else if (e.getSource() == updateButton) {
        	 try {
                 int id = Integer.parseInt(idField.getText());
                 String name = nameField.getText();
                 String user_id = user_idField.getText();
                 int delivery_man_id = Integer.parseInt(delivery_man_idField.getText());

                 Location location = new Location();
                 location.updateData();
             } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(null, "Please enter valid data!", "Error",
                         JOptionPane.ERROR_MESSAGE);
             }
            // Add code for updating data in the location table
        } else if (e.getSource() == deleteButton) {
        	try {
                int id = Integer.parseInt(idField.getText());
                Location location = new Location();
                location.setId(id);
                location.deleteData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            // Add code for deleting data from the location table
        }
    }

    public static void main(String[] args) {
        LocationForm locationForm = new LocationForm();
    }
}
