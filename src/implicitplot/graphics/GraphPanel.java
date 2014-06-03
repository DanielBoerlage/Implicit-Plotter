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
    private Dimension size;
    private int pointSize;
    public int mouseX = 0;
    public int mouseY = 0;
    public double xScale = 3.14 / 2;
    public double yScale = 3.14 / 2;
    public double xZoom = 25;
    public double yZoom = 25;

    public GraphPanel(Dimension d){
        super();
        this.pointSize = 4;
        this.size = d;
        pointsList = new ArrayList<Point>();
        this.addMouseMotionListener(this);
    }

    public void setPointSize(int size){
        this.pointSize = size;
    }
    
    public void addPoint(Point point){//TO-DO: implement xScale and yScale
        this.pointsList.add(point);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        graphBackgroundColorSetup(g2d);
        graphSetup(g2d);
        paintPoints(g2d);
        graphBorderSetup(g2d);
        positionDisplaySetup(g2d);
    }

    public void graphBorderSetup(Graphics2D g2d){
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(new Color(0, 120, 10));
        g2d.drawRect(
                     1,
                     1,
                     (int)(this.getPreferredSize().width) - 3,
                     (int)(this.getPreferredSize().height) - 3
                    );
    }
    
    public void graphSetup(Graphics2D g2d){//draws the x,y axis
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(
                     0,
                     (int)(this.getPreferredSize().height/2),
                     (int)(this.getPreferredSize().width),
                     (int)(this.getPreferredSize().height/2)
                    );
        g2d.drawLine(
                     (int)(this.getPreferredSize().width/2),
                     0,
                     (int)(this.getPreferredSize().width/2),
                     (int)(this.getPreferredSize().height)
                    );
        graphDrawScale(g2d);
        
    }

    public void graphDrawScale(Graphics2D g2d){
        for(int x = (int)(this.getPreferredSize().width/2);
            x <= (int)(this.getPreferredSize().width); 
            x += (int)(xScale * 25))
        {
            g2d.drawLine(
                     x,
                     (int)(this.getPreferredSize().height/2) - 2,
                     x,
                     (int)(this.getPreferredSize().height/2) + 2
                    );
        }

        for(int x = (int)(this.getPreferredSize().width/2);
            x >= -(int)(this.getPreferredSize().width); 
            x -= (int)(xScale * 25))
        {
            g2d.drawLine(
                     x,
                     (int)(this.getPreferredSize().height/2) - 2,
                     x,
                     (int)(this.getPreferredSize().height/2) + 2
                    );
        }

        for(int y = (int)(this.getPreferredSize().height/2);
            y >= -(int)(this.getPreferredSize().height); 
            y -= (int)(yScale * 25))
        {
            g2d.drawLine(
                     (int)(this.getPreferredSize().width/2) - 2,
                     y,
                     (int)(this.getPreferredSize().width/2) + 2,
                     y
                    );
        }

        for(int y = (int)(this.getPreferredSize().height/2);
            y <= (int)(this.getPreferredSize().height); 
            y += (int)(yScale * 25))
        {
            g2d.drawLine(
                     (int)(this.getPreferredSize().width/2) - 2,
                     y,
                     (int)(this.getPreferredSize().width/2) + 2,
                     y
                    );
        }
    }

    public void graphBackgroundColorSetup(Graphics2D g2d){//paints the background of a color.
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,this.getPreferredSize().width,this.getPreferredSize().height);
    }

    public void paintPoints(Graphics2D g2d){ // this paints the points
        g2d.setColor(Color.MAGENTA);
        for(int i = 0; i < pointsList.size(); i++){
            g2d.fillOval(pointsList.get(i).getX() + (int)(this.getPreferredSize().width/2) - this.pointSize/2,
                         pointsList.get(i).getY() + (int)(this.getPreferredSize().height/2) - this.pointSize/2,
                         this.pointSize,
                         this.pointSize);
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
        mouseX = e.getPoint().x - (int)(this.getPreferredSize().width/2);
        mouseY = (e.getPoint().y - (int)(this.getPreferredSize().height/2)) * (-1);
        this.repaint();
        //System.out.println(mouseX + ", " + mouseY);
    }

    public void mouseDragged(MouseEvent evt){
        //Useless
    }

    public Dimension getPreferredSize(){
        return this.size;
    }
}


