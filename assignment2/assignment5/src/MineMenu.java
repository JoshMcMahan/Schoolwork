import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineMenu extends JMenuBar implements ActionListener {

    private JMenu optionMenu;


    MinePanel panel;
    MineFrame frame;
    MineModel game;
    MineJButtons difficulty;

    private JMenuItem noob;
    private JMenuItem semiPro;
    private JMenuItem expert;
    private JMenuItem New;
    private JMenuItem Save;
    private JMenuItem Load;
    private JMenuItem Exit;

    public MineMenu (MinePanel minepanel, MineFrame mineframe, MineModel engine) {
        panel = minepanel;
        frame = mineframe;
        game = engine;
        optionMenu = new JMenu("File");
        New = new JMenu("New Game");

        noob = new JMenuItem("Easy");
        semiPro = new JMenuItem("Medium");
        expert = new JMenuItem("Hard");
        Save = new JMenuItem("Save Game");
        Load = new JMenuItem("Load Game");
        Exit = new JMenuItem("Close Game");

        New.addActionListener(this);
        Save.addActionListener(this);
        Load.addActionListener(this);
        Exit.addActionListener(this);
        noob.addActionListener(this);
        semiPro.addActionListener(this);
        expert.addActionListener(this);

        New.add(noob);
        New.add(semiPro);
        New.add(expert);

        optionMenu.add(New);
        optionMenu.add(Save);
        optionMenu.add(Load);
        optionMenu.add(Exit);

        add(optionMenu);

    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Easy")) {

            try {


                panel.removeAll();
                game.newGame(panel);
                panel.revalidate();
                frame.repaint();
                difficulty.bombprecent = 0.10;
                System.out.println("Difficulty: Easy! ");

            }
            catch (NullPointerException E){

            }
        }
        else if(e.getActionCommand().equals("Medium")){
            try {


                panel.removeAll();
                game.newGame(panel);
                panel.revalidate();
                frame.repaint();
                difficulty.bombprecent = 0.25;
                System.out.println("Difficulty: Medium! ");

            }
            catch (NullPointerException E){

            }

        }
        else if (e.getActionCommand().equals("Hard")){
            try {



                panel.removeAll();
                game.newGame(panel);
                panel.revalidate();
                frame.repaint();
                difficulty.bombprecent = 0.50;
                System.out.println("Difficulty: Hard! ");
            }
            catch (NullPointerException E){

            }

        }
        else if(e.getActionCommand().equals("Save Game")){

            game.saveGame();
            System.out.println("Game had been saved");

        }
        else if(e.getActionCommand().equals("Load Game")){

            panel.removeAll();
            game.newGame(game.loadGame(),panel);
            panel.revalidate();
            frame.repaint();
            System.out.println("Loading game");

        }
        else if(e.getActionCommand().equals("Close Game")){
            System.exit(0);

        }


    }

}
