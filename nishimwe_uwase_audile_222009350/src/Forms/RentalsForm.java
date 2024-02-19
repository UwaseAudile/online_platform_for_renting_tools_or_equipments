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

import Information.Rentals;

public class RentalsForm implements ActionListener {
    JFrame frame;
    JLabel idLabel = new JLabel("ID");
    JLabel start_dateLabel = new JLabel("Start Date");
    JLabel end_dateLabel = new JLabel("End Date");
    JLabel total_costLabel = new JLabel("Total Cost");
    JLabel user_idLabel = new JLabel("User ID");
    JLabel tool_idLabel = new JLabel("Tool ID");

    JTextField idField = new JTextField();
    JTextField start_dateField = new JTextField();
    JTextField end_dateField = new JTextField();
    JTextField total_costField = new JTextField();
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

    public RentalsForm() {
        createForm();
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Rentals Form");
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
        start_dateLabel.setBounds(10, 50, 150, 30);
        end_dateLabel.setBounds(10, 90, 150, 30);
        total_costLabel.setBounds(10, 130, 150, 30);
        user_idLabel.setBounds(10, 170, 150, 30);
        tool_idLabel.setBounds(10, 210, 150, 30);

        idField.setBounds(160, 10, 200, 30);
        start_dateField.setBounds(160, 50, 200, 30);
        end_dateField.setBounds(160, 90, 200, 30);
        total_costField.setBounds(160, 130, 200, 30);
        user_idField.setBounds(160, 170, 200, 30);
        tool_idField.setBounds(160, 210, 200, 30);

        insertButton.setBounds(10, 290, 100, 30);
        viewButton.setBounds(100, 290, 100, 30);
        updateButton.setBounds(190, 290, 100, 30);
        deleteButton.setBounds(280, 290, 100, 30);

        table.setBounds(500, 10, 600, 250);

        setFontForAll();

        frame.add(idLabel);
        frame.add(start_dateLabel);
        frame.add(end_dateLabel);
        frame.add(total_costLabel);
        frame.add(user_idLabel);
        frame.add(tool_idLabel);

        frame.add(idField);
        frame.add(start_dateField);
        frame.add(end_dateField);
        frame.add(total_costField);
        frame.add(user_idField);
        frame.add(tool_idField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        idLabel.setFont(font);
        start_dateLabel.setFont(font);
        end_dateLabel.setFont(font);
        total_costLabel.setFont(font);
        user_idLabel.setFont(font);
        tool_idLabel.setFont(font);

        idField.setFont(font);
        start_dateField.setFont(font);
        end_dateField.setFont(font);
        total_costField.setFont(font);
        user_idField.setFont(font);
        tool_idField.setFont(font);

        insertButton.setFont(font);
        viewButton.setFont(font);
        updateButton.setFont(font);
        deleteButton.setFont(font);
        addComponentsForFrame();
    }

    private void addComponentsForFrame() {
        frame.add(idLabel);
        frame.add(start_dateLabel);
        frame.add(end_dateLabel);
        frame.add(total_costLabel);
        frame.add(user_idLabel);
        frame.add(tool_idLabel);

        frame.add(idField);
        frame.add(start_dateField);
        frame.add(end_dateField);
        frame.add(total_costField);
        frame.add(user_idField);
        frame.add(tool_idField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);

        addActionListeners();
    }

    private void addActionListeners() {
        insertButton.addActionListener(this);
        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Rentals rental=new Rentals();
        if (e.getSource() == insertButton) {
            try {
                int id = Integer.parseInt(idField.getText());
                String start_date = start_dateField.getText();
                String end_date = end_dateField.getText();
                String total_cost = total_costField.getText();
                int user_id = Integer.parseInt(user_idField.getText());
                int tool_id = Integer.parseInt(tool_idField.getText());

                
                rental.insertData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == viewButton) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("ID");
            model.addColumn("Start Date");
            model.addColumn("End Date");
            model.addColumn("Total Cost");
            model.addColumn("User ID");
            model.addColumn("Tool ID");





ResultSet resultSet = Rentals.viewData();
if (resultSet != null) {
    try {
        while (resultSet.next()) {
            model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5),
                    resultSet.getInt(6) });
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
} else if (e.getSource() == updateButton) {
try {
    int id = Integer.parseInt(idField.getText());
    String start_date = start_dateField.getText();
    String end_date = end_dateField.getText();
    String total_cost = total_costField.getText();
    int user_id = Integer.parseInt(user_idField.getText());
    int tool_id = Integer.parseInt(tool_idField.getText());

   
    rental.updateData();
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Please enter valid data!", "Error", JOptionPane.ERROR_MESSAGE);
}
} else if (e.getSource() == deleteButton) {
try {
    int id = Integer.parseInt(idField.getText());
    
    rental.setId(id);
    rental.deleteData();
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Please enter a valid ID!", "Error", JOptionPane.ERROR_MESSAGE);
}
}
}

public static void main(String[] args) {
RentalsForm rentalsForm = new RentalsForm();
}
}

   
