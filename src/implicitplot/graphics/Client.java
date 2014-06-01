//Open-Sourced
//Author - Philip Xu 2014


package implicitplot.graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Client extends JFrame
{
    GraphPanel graphPanel;
    EquationPanel equationPanel;
    MenuPanel menuPanel;

    public Client(){

        //init JFrame
        super("Implicit Plotter");
        Dimension screenSize = 
                    Toolkit.getDefaultToolkit().getScreenSize(); //rtn: dimension of client-side monitor
        
        this.setLayout(null);
        this.setVisible(true);
        this.setBounds( (int)(screenSize.getWidth()/2 - 400),
                        (int)(screenSize.getHeight()/2 - 325), 
                         800, 
                         600 );

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Creating the panels
        graphPanel = new GraphPanel();
        equationPanel = new EquationPanel();
        menuPanel = new MenuPanel();


        equationPanel.setBounds(0,23,300,577);
        graphPanel.setBounds(300,23,500,577);
        menuPanel.setBounds(0,0,600,23);

        this.add(equationPanel);
        this.add(graphPanel);
        this.add(menuPanel);
        test(); // making a bunch of points to paint
    }

    public void test(){
        for(int i = 0; i < 20; i++){
            for (int j = 0; j <= i; j++){
                Point p = new Point(i *10,j*10);
                graphPanel.addPoint(p);
            }
        }
    }
}