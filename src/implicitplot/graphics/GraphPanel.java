//Open-Sourced
//Author - Philip Xu 2014

package implicitplot.graphics;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphPanel extends JPanel{
    ArrayList<Point> pointsList;
    public GraphPanel(){
        super();
        pointsList = new ArrayList<Point>();
    }

    public void panelSetup(){
        this.setOpaque(true);
        this.setBackground(Color.black);
    }
    
    public void addPoint(Point point){
        this.pointsList.add(point);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        graphBackgroundColorSetup(g2d);
        paintPoints(g2d);
        graphSetup(g2d);
        
        
    }

    public void graphBackgroundColorSetup(Graphics2D g2d){
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,this.getSize().width,this.getSize().height);
    }

    public void graphSetup(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(0,
                    (int)(this.getSize().height/2),
                    (int)(this.getSize().width),
                    (int)(this.getSize().height/2));
        g2d.drawLine((int)(this.getSize().width/2),
                    0,
                    (int)(this.getSize().width)/2,
                    (int)(this.getSize().height));
    }

    public void paintPoints(Graphics2D g2d){
        g2d.setColor(Color.MAGENTA);
        for(int i = 0; i < pointsList.size(); i++){
            g2d.fillOval(pointsList.get(i).getX() + (int)(this.getSize().width/2),
                         pointsList.get(i).getY() + (int)(this.getSize().height/2),
                         5,
                         5);
        }
    }

}