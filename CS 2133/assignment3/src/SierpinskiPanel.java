import java.awt.*;
import javax.swing.*;


public class SierpinskiPanel extends JPanel{

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCoord = getWidth();
        int yCoord = getHeight();
        int size = xCoord;

        if (size < yCoord){
            size = yCoord;
         }
        myTriangle(g, 0, 0, size);
        }

    public void myTriangle(Graphics g, int x, int y, int size){
        if (size == 1){
            g.fillRect(x, y, size, size);
        } else {

            int triCenter =  x + (int) (size * .25);
            int triLeft = y + (int) (size * .50);
            int triRight = x + (int) (size * .50);
            int triSize = size / 2;


            myTriangle(g, triCenter, y, triSize);
            myTriangle(g, x, triLeft, triSize);
            myTriangle(g, triRight, triLeft, triSize);

        }
    }
}
