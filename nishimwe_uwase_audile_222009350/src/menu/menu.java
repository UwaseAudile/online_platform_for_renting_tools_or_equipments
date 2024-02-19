package menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Forms.*;
import Admin.Admin;

public class menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem userItem;
    private JMenuItem deliveryManItem;
    private JMenuItem locationItem;
    private JMenuItem rentalsItem;
    private JMenuItem toolEquipmentsItem;
    private JMenuItem transactionItem;
    private JMenuItem logoutItem;
    private String adminPassword = "admin123"; // Change this to a secure method in a real application

    public menu(String username) {
        setTitle("Admin Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        homeMenu = new JMenu("Home");

        // Create menu items
        userItem = new JMenuItem("User");
        userItem.addActionListener(this);
        deliveryManItem = new JMenuItem("Delivery Man");
        deliveryManItem.addActionListener(this);
        locationItem = new JMenuItem("Location");
        locationItem.addActionListener(this);
        rentalsItem = new JMenuItem("Rentals");
        rentalsItem.addActionListener(this);
        toolEquipmentsItem = new JMenuItem("Tool Equipments");
        toolEquipmentsItem.addActionListener(this);
        transactionItem = new JMenuItem("Transaction");
        transactionItem.addActionListener(this);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        homeMenu.add(userItem);
        homeMenu.add(deliveryManItem);
        homeMenu.add(locationItem);
        homeMenu.add(rentalsItem);
        homeMenu.add(toolEquipmentsItem);
        homeMenu.add(transactionItem);
        homeMenu.addSeparator();
        homeMenu.add(logoutItem);

        // Add home menu to menu bar
        menuBar.add(homeMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\user1\\Desktop\\photos\\oniline.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("Welcome Admin " + username + " to the Admin Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Plain", Font.BOLD, 32));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userItem) {
            JOptionPane.showMessageDialog(this, "Opening User Form...");
            new UserForm();
        } else if (e.getSource() == deliveryManItem) {
            JOptionPane.showMessageDialog(this, "Opening Delivery Man Form...");
            new Delivary_manForm();
        } else if (e.getSource() == locationItem) {
            JOptionPane.showMessageDialog(this, "Opening Location Form...");
            new LocationForm();
        } else if (e.getSource() == rentalsItem) {
            JOptionPane.showMessageDialog(this, "Opening Rentals Form...");
            new RentalsForm();
        } else if (e.getSource() == toolEquipmentsItem) {
            JOptionPane.showMessageDialog(this, "Opening Tool Equipments Form...");
            new Tool_equipmentsForm();
        } else if (e.getSource() == transactionItem) {
            JOptionPane.showMessageDialog(this, "Opening Transaction Form...");
            new TransactionForm();
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        String adminPassword = JOptionPane.showInputDialog(null, "Enter Admin Password:");
        if (adminPassword != null && adminPassword.equals("admin123")) {
            String username = JOptionPane.showInputDialog(null, "Enter Admin Username:");
            if (username != null) {
                SwingUtilities.invokeLater(() -> new menu(username));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Admin Password. Exiting...");
        }
    }

	public void setEmail(String text) {
		// TODO Auto-generated method stub
		
	}

	public void setPassword(String passwordString) {
		// TODO Auto-generated method stub
		
	}

	public void login() {
		// TODO Auto-generated method stub
		
	}
	}

