//Open-Sourced
//Author - Philip Xu 2014


package implicitplot.graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client extends JFrame
{
    GraphPanel graphPanel;
    EquationPanel equationPanel;
    
    public Client(){
        super();
        graphPanel = new GraphPanel();
        equationPanel = new EquationPanel();
        this.setLayout(null);
        this.setVisible(true);
        this.setBounds(50, 50, 600, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        equationPanel.setBounds(0,0,300,600);
        graphPanel.setBounds(300,0,300,600);

        this.add(equationPanel);
        this.add(graphPanel);
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