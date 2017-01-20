import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;


public class MineModel {

    MineJButtons[][] buttons = new MineJButtons[10][10];
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("save file","sav");

    public MineModel(MinePanel panel) {

        newGame(panel);

    }
    public void newGame(MinePanel panel){
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
                panel.add(buttons[i][j]);

            }
        }
        setNumbers();

    }
    public void newGame(MineJButtons[][] newBoard, MinePanel panel){
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard.length; j++) {


                newBoard[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            ((MineJButtons) e.getSource()).setText("F");
                        }
                    }
                });
                panel.add(newBoard[i][j]);

            }
        }

    }
    public void saveGame(){

        try {

            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(chooser);
            FileOutputStream gameFile = new FileOutputStream(chooser.getSelectedFile());
            ObjectOutputStream saved = new ObjectOutputStream(gameFile);
            saved.writeObject(buttons);
            saved.close();


        }
        catch (IOException e){
            e.printStackTrace();

        }

    }
    public MineJButtons[][] loadGame(){

        MineJButtons[][] newBoard;
        try {
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(chooser);
            FileInputStream gameFile = new FileInputStream(chooser.getSelectedFile());
            ObjectInputStream loadFile = new ObjectInputStream(gameFile);
            newBoard = (MineJButtons[][]) loadFile.readObject();
            loadFile.close();
            return newBoard;

        }
        catch (IOException | ClassNotFoundException | NullPointerException e){
            e.printStackTrace();
            newBoard = null;
            return newBoard;
        }
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
