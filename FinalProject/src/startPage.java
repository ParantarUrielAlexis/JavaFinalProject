import javax.swing.*;
import java.util.InputMismatchException;

public class startPage extends JFrame {
    private JPanel startPagePanel;
    private JButton startBtn;
    private JTextField inputUserName;
    private JLabel nameInput;
    private JSeparator horizontalLine;
    private JSeparator horizontalLine2;

    public startPage() {
        startBtn.addActionListener(e -> {
            String enteredUserName = null;
            boolean valid = true;
            try {
                enteredUserName = inputUserName.getText();
                containsNumericCharacters(enteredUserName);
            } catch (InputMismatchException ime) {
                JOptionPane.showMessageDialog(startPage.this, ime.getMessage());
                valid = false;
            }
            if (valid) {
                new TypingTest(enteredUserName);
            }
        });
    }

    private void containsNumericCharacters(String input) throws InputMismatchException {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new InputMismatchException("Numeric characters are not allowed!");
            }
        }
    }

    public static void main(String[] args) {
        startPage app = new startPage();
        app.setContentPane(app.startPagePanel);
        app.setSize(1000, 700);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Typing Game");
    }
}

