import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MessagePanel extends JPanel{
    public MessagePanel(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Toolkit kit = Toolkit.getDefaultToolkit();
        g.drawString("Message in a bottle", 150, 250);

        g.drawLine(175, 35, 175, 105); //draws the left side of the bottle opening
        g.drawLine(235, 34, 235, 105); //draws the right side of bottle opening
        g.drawOval(175, 25, 59, 15); //draws oval for the opening of the bottle
        g.drawLine(128,122, 128, 410); //draws the left side of the bottle
        g.drawLine(282, 120, 282, 410); //draws right side of the bottle
        g.drawOval(128, 400, 155, 25); //draws the bottom oval of the bottle
        g.drawArc(113, 105, 125, 100, 90, 50); //draws the left arc for rounded side of the bottle
        g.drawArc(177, 105, 125, 100, 45, 50); //draws the right arc for the rounded side of bottle

    }



}
