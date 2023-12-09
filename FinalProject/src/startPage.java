import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class startPage extends JFrame {
    private JPanel startPagePanel;
    private JButton startBtn;
    private JTextField inputUserName;
    private JLabel nameInput;
    private JSeparator horizontalLine;
    private JSeparator horizontalLine2;

    public startPage() {
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    openTypingTest(enteredUserName);
                }
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

    private void openTypingTest(String userName) {
        // Close the current startPage GUI
        setVisible(false);
        // Open the new TypingTest GUI
        TypingTest typingTest = new TypingTest(userName);
        typingTest.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        revalidate();
        typingTest.setVisible(true);
        typingTest.setTitle("Typing Game");
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
