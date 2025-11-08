package examportal;
import javax.swing.*;
import java.awt.*;
public class ResultPage extends JFrame {
    public ResultPage(int score, int total) {
        setTitle("Exam Result");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Your Score: " + score + " / " + total, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 22));
        add(label, BorderLayout.CENTER);
    }
}
