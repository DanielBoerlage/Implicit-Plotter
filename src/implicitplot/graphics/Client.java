package implicitplot.graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client  // todo: move program entry point to Main class
{
    public static int HEIGHT;
    public static int WIDTH;
    static GraphPanel panel;
    
    public static void guiInit(int w, int h){
        WIDTH = w;
        HEIGHT = h;
        JFrame frame = new JFrame();
        panel = new GraphPanel();
        frame.setVisible(true);
        frame.setBounds(100, 100, WIDTH, HEIGHT);
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