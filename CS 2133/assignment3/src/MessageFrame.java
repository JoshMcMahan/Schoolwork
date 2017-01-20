import javax.swing.*;
import java.awt.*;


public class MessageFrame extends JFrame {
    public MessageFrame() {
        setTitle("Message in a bottle. ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width / 4, screenSize.height - 500);
        add(new MessagePanel());
        setVisible(true);

    }
}
