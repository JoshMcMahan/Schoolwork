import javax.swing.*;
import java.awt.*;

public class MineFrame extends JFrame {

    public MineFrame() {
        setTitle("Minesweeper ");
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        Toolkit kit = Toolkit.getDefaultToolkit();
        setBounds(50, 50, 500, 500);
        MinePanel minepanel = new MinePanel(this);
        add(minepanel);
        setVisible(true);
    }
}