
import javax.swing.*;
import java.awt.*;

public class WebFrame extends JFrame {
    public WebFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820,690);
        add(new WebPanel(this));
        setVisible(true);

    }
}

