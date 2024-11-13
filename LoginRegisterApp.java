import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginRegisterApp {
    private static HashMap<String, String> registeredUsers = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login and Register Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new CardLayout());

        // Login Panel
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel loginEmailLabel = new JLabel("Email:");
        JTextField loginEmailField = new JTextField(15);
        JLabel loginPasswordLabel = new JLabel("Password:");
        JPasswordField loginPasswordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JButton switchToRegisterButton = new JButton("Register");

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(loginEmailLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(loginEmailField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(loginPasswordLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(loginPasswordField, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(loginButton, gbc);
        gbc.gridy = 3;
        loginPanel.add(switchToRegisterButton, gbc);

        // Register Panel
        JPanel registerPanel = new JPanel(new GridBagLayout());
        JLabel registerNameLabel = new JLabel("Full Name:");
        JTextField registerNameField = new JTextField(15);
        JLabel registerEmailLabel = new JLabel("Email:");
        JTextField registerEmailField = new JTextField(15);
        JLabel registerPasswordLabel = new JLabel("Password:");
        JPasswordField registerPasswordField = new JPasswordField(15);
        JButton registerButton = new JButton("Register");
        JButton switchToLoginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(registerNameLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(registerNameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        registerPanel.add(registerEmailLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(registerEmailField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(registerPasswordLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(registerPasswordField, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        registerPanel.add(registerButton, gbc);
        gbc.gridy = 4;
        registerPanel.add(switchToLoginButton, gbc);

        // Switch between panels
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        switchToRegisterButton.addActionListener(e -> cardLayout.show(frame.getContentPane(), "Register"));
        switchToLoginButton.addActionListener(e -> cardLayout.show(frame.getContentPane(), "Login"));

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = loginEmailField.getText().trim();
                String password = new String(loginPasswordField.getPassword()).trim();
                if (!email.isEmpty() && !password.isEmpty()) {
                    if (registeredUsers.containsKey(email) && registeredUsers.get(email).equals(password)) {
                        JOptionPane.showMessageDialog(frame, "Login successful!\nWelcome, " + email + "!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = registerNameField.getText().trim();
                String email = registerEmailField.getText().trim();
                String password = new String(registerPasswordField.getPassword()).trim();
                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    if (!registeredUsers.containsKey(email)) {
                        registeredUsers.put(email, password);
                        JOptionPane.showMessageDialog(frame, "Registration successful!\nName: " + name + ", Email: " + email);
                        cardLayout.show(frame.getContentPane(), "Login");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Email already registered.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(loginPanel, "Login");
        frame.add(registerPanel, "Register");
        frame.setVisible(true);
    }
}
