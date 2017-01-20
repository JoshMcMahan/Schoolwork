import javax.swing.*;
import java.awt.*;

public class MineFrame extends JFrame {

    public MineFrame() {
        setTitle("Minesweeper ");
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        Toolkit kit = Toolkit.getDefaultToolkit();
        setBounds(50, 50, 500, 500);
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu game = new JMenu("File");
        mb.add(game);
        MineMenu myMenu = (new MineMenu(this));
        game.add(myMenu);
        add(new MinePanel());
        setVisible(true);
    }
}


