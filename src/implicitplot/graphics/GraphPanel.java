//Open-Sourced
//Author - Philip Xu 2014

package implicitplot.graphics;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphPanel extends JPanel{
    ArrayList<Point> pointsList;
    public GraphPanel(){
        super();
        pointsList = new ArrayList<Point>();
    }
    
    public void addPoint(Point point){
        this.pointsList.add(point);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.MAGENTA);
        for(int i = 0; i < pointsList.size(); i++){
            g2d.fillOval(pointsList.get(i).getX() + 100, pointsList.get(i).getY() + 100, 10, 10);
        }
    }
}