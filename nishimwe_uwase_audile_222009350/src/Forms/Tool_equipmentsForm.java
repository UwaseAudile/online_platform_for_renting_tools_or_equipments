package Forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Information.Tool_equipments;

public class Tool_equipmentsForm implements ActionListener {
    JFrame frame;
    JLabel idLabel = new JLabel("ID");
    JLabel nameLabel = new JLabel("Name");
    JLabel descriptionLabel = new JLabel("Description");
    JLabel priceLabel = new JLabel("Price");

    JTextField idField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField descriptionField = new JTextField();
    JTextField priceField = new JTextField();

    JButton insertButton = new JButton("INSERT");
    JButton viewButton = new JButton("VIEW");
    JButton updateButton = new JButton("UPDATE");
    JButton deleteButton = new JButton("DELETE");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    public Tool_equipmentsForm() {
        createForm();
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Tool Equipments Form");
        frame.setBounds(0, 0, screenWidth / 2, screenHeight / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setResizable(true);
        frame.setVisible(true);

        setLocationAndSize();
        addActionListeners();
    }

    private void setLocationAndSize() {
        idLabel.setBounds(10, 10, 130, 30);
        nameLabel.setBounds(10, 50, 130, 30);
        descriptionLabel.setBounds(10, 90, 130, 30);
        priceLabel.setBounds(10, 130, 130, 30);

        idField.setBounds(200, 10, 210, 30);
        nameField.setBounds(200, 50, 210, 30);
        descriptionField.setBounds(200, 90, 210, 30);
        priceField.setBounds(200, 130, 210, 30);

        insertButton.setBounds(100, 170, 100, 30);
        viewButton.setBounds(210, 170, 100, 30);
        updateButton.setBounds(100, 210, 100, 30);
        deleteButton.setBounds(210, 210, 100, 30);

        table.setBounds(500, 10, 600, 250);

        setFontForAll();

        frame.add(idLabel);
        frame.add(nameLabel);
        frame.add(descriptionLabel);
        frame.add(priceLabel);

        frame.add(idField);
        frame.add(nameField);
        frame.add(descriptionField);
        frame.add(priceField);

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
        descriptionLabel.setFont(font);
        priceLabel.setFont(font);

        idField.setFont(font);
        nameField.setFont(font);
        descriptionField.setFont(font);
        priceField.setFont(font);

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
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String description = descriptionField.getText();
                int price = Integer.parseInt(priceField.getText());

                Tool_equipments toolEquipments = new Tool_equipments(id, name, description, price);
                toolEquipments.insertData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid data!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == viewButton) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Description");
            model.addColumn("Price");

            ResultSet resultSet = Tool_equipments.viewData();
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
        } else if (e.getSource() == updateButton) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String description = descriptionField.getText();
                int price = Integer.parseInt(priceField.getText());

                Tool_equipments toolEquipments = new Tool_equipments(id, name, description, price);
                toolEquipments.updateData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid data!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == deleteButton) {
            try {
                int id = Integer.parseInt(idField.getText());
                Tool_equipments toolEquipments = new Tool_equipments();
                toolEquipments.setId(id);
                toolEquipments.deleteData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Tool_equipmentsForm tool_equipmentsForm = new Tool_equipmentsForm();
    }
}
