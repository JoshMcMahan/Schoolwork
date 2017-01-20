import javax.swing.*;
import java.awt.*;



public class MinePanel extends JPanel {

    private int row = 10;
    private int col = 10;
    MineModel engine = new MineModel();

    public MinePanel() {
        setLayout(new GridLayout(row, col));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                add(engine.buttons[i][j]);
            }
        }
    }
}

