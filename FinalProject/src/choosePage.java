import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choosePage extends JFrame {
    private JButton soloBtn;
    private JButton compeBtn;
    public JPanel choosePagePanel;

    public choosePage(){
        compeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TypingTest();
            }
        });
    }
    public static void main(String[] args) {
        choosePage app = new choosePage();
        app.setContentPane(app.choosePagePanel);
        app.setSize(1000, 700);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Typing Game");
    }
}
