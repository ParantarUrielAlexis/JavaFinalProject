import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.util.InputMismatchException;

@SuppressWarnings("ALL")
public class startPage extends JFrame {
    JPanel startPagePanel;
    private JButton startBtn;
    private JTextField inputUserName;
    JLabel nameInput;
    JSeparator horizontalLine;
    JSeparator horizontalLine2;

    public startPage() {
        startBtn.addActionListener(e -> {
            String enteredUserName = null;
            boolean valid = true;
            try {
                enteredUserName = inputUserName.getText();
                containsNumericCharacters(enteredUserName);
                if(enteredUserName.isEmpty()){
                    throw new InputMismatchException("Input Username");
                }

            } catch (InputMismatchException ime) {
                JOptionPane.showMessageDialog(startPage.this, ime.getMessage());
                valid = false;
            }
            if (valid) {
                openTypingTest(enteredUserName);
            }
        });
    }

    private void containsNumericCharacters(String input) throws InputMismatchException {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new InputMismatchException("Numeric or alphanumeric characters are not allowed!");
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

    private void playMusic(String filePath) {
        try {
            File audioFile = new File(filePath);

            if(audioFile.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }else{
                System.out.println("Can't find file");
            }

        } catch (Exception e) {
            System.out.println(e);;
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