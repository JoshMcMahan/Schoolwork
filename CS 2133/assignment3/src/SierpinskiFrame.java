import javax.swing.*;
import java.awt.*;

public class SierpinskiFrame extends JFrame {
        public SierpinskiFrame() {
            setTitle("Sierpinski's Triangle ");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            setBounds(0, 0, screenSize.width, screenSize.height);
            add(new SierpinskiPanel());
            setVisible(true);
        }
    }

