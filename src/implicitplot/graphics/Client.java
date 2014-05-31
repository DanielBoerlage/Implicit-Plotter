package implicitplot.graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client
{
    public final static int HEIGHT = 600;
    public final static int WIDTH = 800;
    static GraphPanel panel;
    
    public static void guiInit(){
        JFrame frame = new JFrame();
        panel = new GraphPanel();
        frame.setVisible(true);
        frame.setBounds(50, 50, WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //test
        for(int i = 10; i > 0; i--){
            for (int j = 15; j > 5; j--){
                Point p = new Point(i *10,j*10);
                panel.addPoint(p);
            }
        }
        
        frame.add(panel);
        panel.repaint();
    }
}