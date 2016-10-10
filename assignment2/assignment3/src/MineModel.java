import javax.swing.*;
import java.awt.event.*;


public class MineModel {

    MineJButtons[][] buttons = new MineJButtons[10][10];

    public MineModel() {


        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new MineJButtons();
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            ((MineJButtons) e.getSource()).setText("F");
                        }
                    }
                });
            }
        }
        setNumbers();

    }

    public void setNumbers() {
        int rc = 10;

        for (int x = 0; x < rc; x++) {
            for (int y = 0; y < rc; y++) {
                if (x > 0 && y > 0) {
                    if (buttons[x - 1][y - 1].aMine)
                        buttons[x][y].mineCount++;
                }
                if (y > 0) {
                    if (buttons[x][y - 1].aMine)
                        buttons[x][y].mineCount++;
                }
                if (x < rc - 1 && y > 0) {
                    if (buttons[x + 1][y - 1].aMine)
                        buttons[x][y].mineCount++;
                }

                if (x > 0) {
                    if (buttons[x - 1][y].aMine)
                        buttons[x][y].mineCount++;
                }
                if (x < rc - 1) {
                    if (buttons[x + 1][y].aMine)
                        buttons[x][y].mineCount++;
                }

                if (x > 0 && y < rc - 1) {
                    if (buttons[x - 1][y + 1].aMine)
                        buttons[x][y].mineCount++;
                }
                if (y < rc - 1) {
                    if (buttons[x][y + 1].aMine)
                        buttons[x][y].mineCount++;

                    if (x < rc - 1 && y < rc - 1) {
                        if (buttons[x + 1][y + 1].aMine)
                            buttons[x][y].mineCount++;

                    }
                }
            }
        }
    }
}
