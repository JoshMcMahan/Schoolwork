import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class MineJButtons extends JButton{


    public boolean aMine;
    public int mineCount = 0;


    public MineJButtons() {



        aMine = randMine();
        addMouseListener(new MouseAdapter() {
            public void mouseClicked (MouseEvent e){
                if(aMine == false) {
                    setText(Integer.toString(mineCount));
                }else{
                    setText("B");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "YOU LOSE!", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public boolean randMine(){
        return Math.random() < 0.25;
    }


}