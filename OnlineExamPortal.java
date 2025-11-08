package examportal;
import javax.swing.SwingUtilities;
public class OnlineExamPortal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}
