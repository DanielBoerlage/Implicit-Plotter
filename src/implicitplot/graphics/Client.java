// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * @author Philip Xu
 */
public class Client extends JFrame {

    GraphPanel graphPanel;
    EquationPanel equationPanel;
    MenuPanel menuPanel;
    Dimension screenSize;

    public Client() { //The client frame runs the frame that hosts the panels
        super("Implicit Plotter");
        frameSetup();
        panelSetup();
        addPanels();
        test(); // making a bunch of points to paint
    }

    public void frameSetup() { //set up the frame
        this.setLayout(null); 
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("res/images/icon/icon.gif");
        this.setIconImage(icon.getImage());
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds( (int)(screenSize.getWidth()/2 - 409),
                        (int)(screenSize.getHeight()/2 - 350), 
                         818, 
                         640 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void panelSetup() { //set up the various panels
        graphPanel = new GraphPanel(new Dimension(500,577));
        equationPanel = new EquationPanel(new Dimension(300,577));
        menuPanel = new MenuPanel(new Dimension(600,23));

        equationPanel.setBounds(0,23,300,577);
        graphPanel.setBounds(300,23,500,577);
        menuPanel.setBounds(0,0,600,23);
    } 

    public void addPanels() { //add the panels to frame
        this.add(equationPanel);
        this.add(graphPanel);
        this.add(menuPanel);
    }

    public void test() {

        //Point p = new Point(0,0);
        //graphPanel.addPoint(p);

        
        for(int i = 0; i <= 360; i += 1) {//parametric : x = cos(theta) * r, y = sin(theta) * r
            Point p = new Point(
                                (int)(Math.cos(Math.toRadians((double)i)) * 50),
                                (int)(Math.sin(Math.toRadians((double)i)) * 50));
            graphPanel.addPoint(p);
        }

        for(int i = -1000; i <= 1000; i += 1) {//parametric : x = cos(theta) * r, y = sin(theta) * r
            Point p = new Point(
                                (int)(Math.toRadians((double)i) * 25),
                                (int)(Math.sin(Math.toRadians((double)i))  * 50));
            graphPanel.addPoint(p);
        }

        /*

        for(int i = -400; i <= 400; i += 1){//y = sin(x)
            Point p = new Point(
                                i,
                                (int)(Math.tan(Math.toRadians((double)i)) * 50));
            graphPanel.addPoint(p);
        }

        for(int i = -400; i <= 400; i += 1){//y = sin(x)
            Point p = new Point(
                                (int)(Math.tan(Math.toRadians((double)i)) * 50),
                                i);
            graphPanel.addPoint(p);
        }

        for(int i = -400; i <= 400; i += 1){//y = sin(x)
            Point p = new Point(
                                -(int)(Math.tan(Math.toRadians((double)i)) * 50),
                                i);
            graphPanel.addPoint(p);
        }

        for(int i = -400; i <= 400; i += 1){//y = sin(x)
            Point p = new Point(
                                i,
                                -(int)(Math.tan(Math.toRadians((double)i)) * 50));
            graphPanel.addPoint(p);
        }
        */

    }
}