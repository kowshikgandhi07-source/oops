package examportal;
package examportal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ExamPage extends JFrame {
    private String[] questions = {
            "1. Which language is used for Android app development?",
            "2. Which company developed Java?",
            "3. What does HTML stand for?",
            "4. Which keyword is used to inherit a class in Java?",
            "5. Which data structure uses FIFO (First In First Out)?"
    };
    private String[][] options = {
            {"Java", "Kotlin", "C++", "Swift"},
            {"Sun Microsystems", "Google", "Apple", "Microsoft"},
            {"Hyper Text Markup Language", "Highlevel Text Machine Language", "Hyper Tool Multi Language", "None"},
            {"super", "this", "extends", "implements"},
            {"Stack", "Queue", "Array", "Tree"}
    };
    private int[] answers = {1, 1, 1, 3, 2}; 
    private int currentQuestion = 0;
    private int score = 0;
    private ButtonGroup group;
    private JRadioButton[] optionButtons;
    private JButton nextButton;
    private JLabel questionLabel; 
    public ExamPage() {
        setTitle("Online Exam Portal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));
        JLabel header = new JLabel("Online Exam", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setOpaque(true);
        header.setBackground(new Color(70, 130, 180));
        header.setForeground(Color.WHITE);
        add(header, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        questionLabel = new JLabel("", JLabel.LEFT);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        centerPanel.add(questionLabel);

        group = new ButtonGroup();
        optionButtons = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 15));
            optionButtons[i].setFocusPainted(false);
            group.add(optionButtons[i]);
            centerPanel.add(optionButt ons[i]);
            optionButtons[i].addActionListener(e -> {
                for (JRadioButton btn : optionButtons) {
                    btn.setBackground(null);
                }
                ((JRadioButton) e.getSource()).setBackground(new Color(173, 216, 230));
            });
        }
        add(centerPanel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.addActionListener(e -> nextQuestion());
        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);
        loadQuestion();
        setVisible(true);
    }
    private void loadQuestion() {
        group.clearSelection();
        for (JRadioButton btn : optionButtons) {
            btn.setBackground(null);
        }
        questionLabel.setText(questions[currentQuestion]);
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(options[currentQuestion][i]);
        }
        if (currentQuestion == questions.length - 1) {
            nextButton.setText("Submit");
        }
    }
    private void nextQuestion() {
        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                selected = i + 1;
                break;
            }
        }
        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "Please select an answer before continuing.");
            return;
        }
        if (selected == answers[currentQuestion]) {
            score++;
        }
        currentQuestion++;
        if (currentQuestion < questions.length) {
            loadQuestion();
        } else {
            showResult();
        }
    }
    private void showResult() {
        JOptionPane.showMessageDialog(this, "Exam Completed!\nYour Score: " + score + " / " + questions.length);
        dispose();
        new ResultPage(score, questions.length).setVisible(true);
    }
}
setVisible(true);
    }
    private void loadQuestion() {
        group.clearSelection();
        for (JRadioButton btn : optionButtons) {
            btn.setBackground(null);
        }
        questionLabel.setText(questions[currentQuestion]);
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(options[currentQuestion][i]);
        }
        if (currentQuestion == questions.length - 1) {
            nextButton.setText("Submit");
        }
    }
    private void nextQuestion() {
        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                selected = i + 1;
                break;
            }
        }

        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "Please select an answer before continuing.");
            return;
        }
if (selected == answers[currentQuestion]) {
            score++;
        }
        currentQuestion++;
        if (currentQuestion < questions.length) {
            loadQuestion();
        } else {
            showResult();
        }
    }
    private void showResult() {
        JOptionPane.showMessageDialog(this, "Exam Completed!\nYour Score: " + score + " / " + questions.length);
        dispose();
        new ResultPage(score, questions.length).setVisible(true);
    }
}
