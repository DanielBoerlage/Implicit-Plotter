//Author - Philip Xu 2014

package implicitplot.graphics;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GraphPanel extends JPanel implements MouseMotionListener{
    ArrayList<Point> pointsList;
    public int mouseX = 0;
    public int mouseY = 0;
    public int xScale = 1;
    public int yScale = 1;

    public GraphPanel(){
        super();
        pointsList = new ArrayList<Point>();
        this.addMouseMotionListener(this);
    }
    
    public void addPoint(Point point){//TO-DO: implement xScale and yScale
        this.pointsList.add(point);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        graphBackgroundColorSetup(g2d);
        graphSetup(g2d);
        paintPoints(g2d);
        positionDisplaySetup(g2d);
    }

    public void graphSetup(Graphics2D g2d){//draws the x,y axis
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(
                     0,
                     (int)(this.getSize().height/2),
                     (int)(this.getSize().width),
                     (int)(this.getSize().height/2)
                    );
        g2d.drawLine(
                     (int)(this.getSize().width/2),
                     0,
                     (int)(this.getSize().width)/2,
                     (int)(this.getSize().height)
                    );
    }

    public void graphBackgroundColorSetup(Graphics2D g2d){//paints the background of a color.
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,this.getSize().width,this.getSize().height);
    }

    public void paintPoints(Graphics2D g2d){ // this paints the points
        g2d.setColor(Color.MAGENTA);
        for(int i = 0; i < pointsList.size(); i++){
            g2d.fillOval(pointsList.get(i).getX() + (int)(this.getSize().width/2),
                         pointsList.get(i).getY() + (int)(this.getSize().height/2),
                         4,
                         4);
        }
    }

    public void positionDisplaySetup(Graphics2D g2d){//this set up the x and y position display
        g2d.setColor(Color.BLACK);
        String posiX = "X: " + mouseX;
        String posiY = "Y: " + mouseY;
        //Font font = new Font("Eras Bold ITC", Font.PLAIN, 20);
        //g2d.setFont(font);
        // ^ those two lines make it look pretty but really really slow, to be fixed.
        g2d.drawString(posiX,10,20);
        g2d.drawString(posiY,10,40);
    }

    public void mouseMoved(MouseEvent e){ // this is called every tick the mouse is moved.
        mouseX = e.getPoint().x - (int)(this.getSize().width/2);
        mouseY = (e.getPoint().y - (int)(this.getSize().height/2)) * (-1);
        this.repaint();
        //System.out.println(mouseX + ", " + mouseY);
    }

    public void mouseDragged(MouseEvent evt){
        //Useless
    }
}

