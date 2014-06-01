//Open-Sourced
//Author - Philip Xu 2014


package implicitplot.graphics;
import javax.swing.*;
import java.awt.*;

public class Client extends JFrame
{
    GraphPanel graphPanel;
    EquationPanel equationPanel;
    MenuPanel menuPanel;
    Dimension screenSize;

    public Client(){ //The client frame runs the frame that hosts the panels
        super("Implicit Plotter");
        frameSetup();
        panelSetup();
        addPanel();
        test(); // making a bunch of points to paint
    }

    public void frameSetup(){ //set up the frame
        this.setLayout(null); 
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("implicitplot/icon.gif");
        this.setIconImage(icon.getImage());
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds( (int)(screenSize.getWidth()/2 - 409),
                        (int)(screenSize.getHeight()/2 - 350), 
                         818, 
                         640 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void panelSetup(){ //set up the various panels
        graphPanel = new GraphPanel();
        equationPanel = new EquationPanel();
        menuPanel = new MenuPanel();

        equationPanel.setBounds(0,23,300,577);
        graphPanel.setBounds(300,23,500,577);
        menuPanel.setBounds(0,0,600,23);
    } 

    public void addPanel(){ //add the panels to frame
        this.add(equationPanel);
        this.add(graphPanel);
        this.add(menuPanel);
    }

    public void test(){
        for(int i = 0; i <= 360; i += 1){
            Point p = new Point(
                                (int)(Math.cos(Math.toRadians((double)i)) * 100),
                                (int)(Math.sin(Math.toRadians((double)i)) * 100));
            graphPanel.addPoint(p);
        }

        for(int i = -500; i <= 500; i += 1){
            Point p = new Point(
                                i,
                                (int)(Math.sin(Math.toRadians((double)i)) * 100));
            graphPanel.addPoint(p);
        }
    }
}