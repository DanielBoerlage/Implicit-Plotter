//Open-Sourced
//Author - Philip Xu 2014


package implicitplot.graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client extends JFrame
{
    public final static int HEIGHT = 600;
    public final static int WIDTH = 800;
    GraphPanel panel;
    
    public Client(){
        super();
        panel = new GraphPanel();
        this.setVisible(true);
        this.setBounds(50, 50, WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //test
        for(int i = 10; i > 0; i--){
            for (int j = 15; j > 5; j--){
                Point p = new Point(i *10,j*10);
                panel.addPoint(p);
            }
        }
        
        this.add(panel);
        panel.repaint();
    }
}