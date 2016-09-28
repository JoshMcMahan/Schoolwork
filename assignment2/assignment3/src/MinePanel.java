import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.util.*;


public class MinePanel extends JPanel {
    JPanel panel = new JPanel();
    JButton[][] buttons = new JButton[10][10];
    int[][] counts = new int[10][10];
    Random rand = new Random();
    private String bh = "?";
    private String name = "1";
    private int row = 10;
    private int col = 10;

    public MinePanel() {
        setLayout(new GridLayout(row, col));
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new JButton(bh);

                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ((JButton)e.getSource()).setText(name);
                    }
                });
                add(buttons[i][j]);
            }
        }

    }
}




