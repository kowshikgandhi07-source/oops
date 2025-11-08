package examportal;
package examportal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginPage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    public LoginPage() {
        setTitle("Online Exam Portal - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
         JLabel title = new JLabel("Online Exam Portal", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);
        JButton loginButton = new JButton("Login");
        panel.add(loginButton);
        JButton registerButton = new JButton("Register");
        panel.add(registerButton);
        add(panel, BorderLayout.CENTER);
        loginButton.addActionListener(e -> checkLogin());
        registerButton.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "Registration Page Coming Soon!")
        );
    }
    private void checkLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
   ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                dispose();
                new ExamPage().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        }
    }
}
