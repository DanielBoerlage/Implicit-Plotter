// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.graphics;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author Philip Xu
 */

public class GraphPanel extends JPanel implements MouseMotionListener {
    ArrayList<Point> pointsList;
    private Dimension size;
    private int pointSize;
    public double mouseX = 0;
    public double mouseY = 0;
    public double xScale = Math.PI / 2;
    public double yScale = 1;
    public double xZoom = 25;
    public double yZoom = 25;

    public GraphPanel(Dimension d) {
        super();
        this.pointSize = 4;
        this.size = d;
        //pointsList = new ArrayList<Point>();
        this.addMouseMotionListener(this);
    }

    public void setPointSize(int size) {
        this.pointSize = size;
    }
    
    /*
    public void addPoint(Point point){//TO-DO: implement xScale and yScale
        this.pointsList.add(point);
    }
    */

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        graphBackgroundColorSetup(g2d);
        graphSetup(g2d);
        if(Client.lineModeOn)
            paintCurve(g2d);
        else
            paintPoints(g2d);
        graphBorderSetup(g2d);
        positionDisplaySetup(g2d);
    }

    public void graphBorderSetup(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(new Color(0, 120, 10));
        g2d.drawRect(
                     1,
                     1,
                     (int)(this.getPreferredSize().width) - 3,
                     (int)(this.getPreferredSize().height) - 3
                    );
    }
    
    public void graphSetup(Graphics2D g2d) {//draws the x,y axis
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

    //draws the ticks on x and y axis, uses xScale and yScale
    public void graphDrawScale(Graphics2D g2d) {
        for(int x = (int)(this.getPreferredSize().width/2);
            x <= (int)(this.getPreferredSize().width); 
            x += (int)(xScale * xZoom))
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
            x -= (int)(xScale * xZoom))
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
            y -= (int)(yScale * yZoom))
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
            y += (int)(yScale * yZoom))
        {
            g2d.drawLine(
                     (int)(this.getPreferredSize().width/2) - 2,
                     y,
                     (int)(this.getPreferredSize().width/2) + 2,
                     y
                    );
        }
    }

    public void graphBackgroundColorSetup(Graphics2D g2d) {//paints the background of a color.
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,this.getPreferredSize().width,this.getPreferredSize().height);
    }

    public void paintPoints(Graphics2D g2d) { // this paints the points
        for(FunctionSubpanel sub : Client.equationPanel.functionList){
            g2d.setColor(sub.graphColor);
            for(int i = 0; i < sub.getPointsList().size(); i++){
                g2d.fillOval(sub.getPointsList().get(i).getX() + (int)(this.getPreferredSize().width/2) - this.pointSize/2,
                             -sub.getPointsList().get(i).getY() + (int)(this.getPreferredSize().height/2) - this.pointSize/2,
                             this.pointSize,
                             this.pointSize);
            }
        }
    }

    public void paintCurve(Graphics2D g2d) { // this paints a line between consecutive points
        for(FunctionSubpanel sub : Client.equationPanel.functionList){
            g2d.setColor(sub.graphColor);
            g2d.setStroke(new BasicStroke(1));
            for(int i = 0; i < sub.getPointsList().size() - 1; i++){
                if(Math.abs(-sub.getPointsList().get(i + 1).getY() - (-sub.getPointsList().get(i).getY())) < 500)
                    g2d.drawLine(sub.getPointsList().get(i).getX() + (int)(this.getPreferredSize().width/2),
                             -sub.getPointsList().get(i).getY() + (int)(this.getPreferredSize().height/2),
                             sub.getPointsList().get(i + 1).getX() + (int)(this.getPreferredSize().width/2),
                             -sub.getPointsList().get(i + 1).getY() + (int)(this.getPreferredSize().height/2));
            }
        }
    }

    public void positionDisplaySetup(Graphics2D g2d) {//this set up the x and y position display
        g2d.setColor(Color.BLACK);
        String posiX = "X: " + mouseX;
        String posiY = "Y: " + mouseY;
        //Font font = new Font("Eras Bold ITC", Font.PLAIN, 20);
        //g2d.setFont(font);
        // ^ those two lines make it look pretty but really really slow, to be fixed.
        g2d.drawString(posiX,10,20);
        g2d.drawString(posiY,10,40);
    }

    public void mouseMoved(MouseEvent e) { // this is called every tick the mouse is moved.
        mouseX = (e.getPoint().x - this.getPreferredSize().width/2) / xZoom ;
        mouseY = ((e.getPoint().y - this.getPreferredSize().height/2) / yZoom) * -1;
        this.repaint();
        //System.out.println(mouseX + ", " + mouseY);
    }

    public void mouseDragged(MouseEvent evt) {
        //Useless
    }

    public Dimension getPreferredSize() {
        return this.size;
    }
}


