package menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Forms.Tool_equipmentsForm;

public class Customer_menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem toolEquipmentsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;

    public Customer_menu(String username) {
        this.loggedInUser = username;
        setTitle("Customer Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        homeMenu = new JMenu("Home");

        // Create menu items
        toolEquipmentsItem = new JMenuItem("Tool Equipments");
        toolEquipmentsItem.addActionListener(this);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        homeMenu.add(toolEquipmentsItem);
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
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\user1\\Desktop\\photos\\Online-shopping.jpeg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("Welcome " + loggedInUser + " to Online Platform For Renting Tools or Equipments");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Plain", Font.BOLD, 32));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toolEquipmentsItem) {
            JOptionPane.showMessageDialog(this, "Opening Tool Equipments Form...");
            new Tool_equipmentsForm();
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Customer_menu(""));
    }

	public void login() {
		// TODO Auto-generated method stub
		
	}

	public void setPassword(String passwordString) {
		// TODO Auto-generated method stub
		
	}

	public void setEmail(String text) {
		// TODO Auto-generated method stub
		
	}

	public boolean adminlogin() {
		// TODO Auto-generated method stub
		return false;
	}
}

