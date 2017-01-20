import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class RobotPanel extends JPanel {

    private static JPanel display = new JPanel();
    private static JButton takeOff = new JButton("Take off");
    private static JButton land = new JButton("Land ");
    private static JButton forward = new JButton("Forwards ");
    private static JButton backward = new JButton("Backwards ");
    private static JButton left = new JButton("Left ");
    private static JButton right = new JButton("Right ");
    private static JButton rotateL = new JButton("Rotate Left ");
    private static JButton rotateR = new JButton("Rotate Right ");
    private static JButton stop = new JButton("Stop ");
    private static JButton ascend = new JButton("Ascend ");
    private static JButton descend = new JButton("Descend ");

    GridLayout layout = new GridLayout(3, 3);

    public RobotPanel() {
        RobotModel flyRobot = new RobotModel();
        final PrintWriter outputRW = flyRobot.getRS();

        takeOff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                takeoffM(outputRW);
            }
        });
        land.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                landM(outputRW);
            }
        });

        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopM(outputRW);
            }
        });

        left.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftM(outputRW);
            }
        });

        right.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightM(outputRW);
            }
        });

        forward.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                forwardM(outputRW);
            }
        });

        backward.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backwardM(outputRW);
            }
        });

        rotateL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rotateLM(outputRW);
            }
        });

        rotateR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rotateRM(outputRW);
            }
        });
        ascend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ascendM(outputRW);
            }
        });

        descend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                descendM(outputRW);
            }
        });



        display.setLayout(layout);
        display.add(left);
        display.add(forward);
        display.add(right);
        display.add(ascend);
        display.add(rotateL);
        display.add(takeOff);
        display.add(rotateR);
        display.add(descend);
        display.add(land);
        display.add(backward);
        display.add(stop);
        add(display);


    }

    //JSON string that lets the drone take off
    private static void takeoffM(PrintWriter output) {
        String takeoff_msg = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
        output.write(takeoff_msg);
        output.flush();

    }
    //JSON string to land the drone
    private static void landM(PrintWriter output){
        String land_msg = "{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}";
        output.write(land_msg);
        output.flush();
    }

    private static void stopM(PrintWriter output){
        double linearX = 0;
        double linearY = 0;
        double linearZ = 0;
        int angularZ = 0;

        output.write(simpleJSON(linearX, linearY, linearZ, angularZ));
        output.flush();
    }

    private static void leftM(PrintWriter output){
        double linearX = 0;
        double linearY = .25;
        double linearZ = 0;
        int angularZ = 0;

        output.write(simpleJSON(linearX, linearY, linearZ, angularZ));
        output.flush();
    }

    private static void rightM(PrintWriter output) {
        double linearX = 0;
        double linearY = -.25;
        double linearZ = 0;
        int angularZ = 0;

        output.write(simpleJSON(linearX, linearY, linearZ, angularZ));
        output.flush();
    }

    private static void forwardM(PrintWriter output) {
        double linearX = .25;
        double linearY = 0;
        double linearZ = 0;
        int angularZ = 0;

        output.write(simpleJSON(linearX, linearY, linearZ, angularZ));
        output.flush();
    }
    private static void backwardM(PrintWriter output) {
        double linearX = -.25;
        double linearY = 0;
        double linearZ = 0;
        int angularZ = 0;

        output.write(simpleJSON(linearX, linearY, linearZ, angularZ));
        output.flush();
    }
    private static void rotateLM(PrintWriter output) {
        double linearX = 0;
        double linearY = 0;
        double linearZ = 0;
        int angularZ = 1;

        output.write(simpleJSON(linearX, linearY, linearZ, angularZ));
        output.flush();
    }
    private static void rotateRM(PrintWriter output) {
        double linearX = 0;
        double linearY = 0;
        double linearZ = 0;
        int angularZ = -1;

        output.write(simpleJSON(linearX, linearY, linearZ, angularZ));
        output.flush();
    }
    private static void ascendM(PrintWriter output) {
        double linearX = 0;
        double linearY = 0;
        double linearZ = .25;
        int angularZ = 0;

        output.write(simpleJSON(linearX, linearY, linearZ, angularZ));
        output.flush();
    }

    private static void descendM(PrintWriter output) {
        double linearX = 0;
        double linearY = 0;
        double linearZ = -.25;
        int angularZ = 0;

        output.write(simpleJSON(linearX, linearY, linearZ, angularZ));
        output.flush();
    }
    //Takes the JSON string for various movements and places variables from the methods in the string
    private static String simpleJSON(double linearX, double linearY, double linearZ, int angularZ){
        return "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" + linearX + ",\"y\":"+
                linearY +",\"z\":" + linearZ + "},\"angular\":{\"x\":0,\"y\":0,\"z\":"+ angularZ +"}}}";


    }

}
