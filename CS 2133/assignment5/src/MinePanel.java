import javax.swing.*;
import java.awt.*;



public class MinePanel extends JPanel {

    private int row = 10;
    private int col = 10;
    public MineMenu menu;
    MineModel engine = new MineModel(this);



    public MinePanel(MineFrame frame) {
        MineMenu menu = new MineMenu(this, frame, engine);
        frame.setJMenuBar(menu);
        setLayout(new GridLayout(row, col));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                add(engine.buttons[i][j]);
                setBackground(Color.DARK_GRAY);
            }
        }

    }
}
