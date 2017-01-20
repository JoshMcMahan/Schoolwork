import javax.swing.*;
import java.awt.*;

public class RobotFrame extends JFrame{
    public RobotFrame(){

        setTitle("Robot Control Pad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        add(new RobotPanel());
        setVisible(true);


    }
}
