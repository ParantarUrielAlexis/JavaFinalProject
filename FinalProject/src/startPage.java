import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startPage extends JFrame {


    private JPanel startPagePanel;
    private JButton startBtn;
    private JLabel line1;

    public startPage(){
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosePage choose = new choosePage();
                setContentPane(choose.choosePagePanel);
                revalidate();
            }
        });
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
