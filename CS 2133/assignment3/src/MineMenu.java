import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class MineMenu extends JMenuItem {
    MineFrame frame;
    public MineMenu (MineFrame mf){
        super("New Game ");
        frame = mf;
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.repaint();
                System.out.println("A new game has been started!");
            }
        });
    }
}
