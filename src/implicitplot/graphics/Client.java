// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * @author Philip Xu
 */
public class Client{

    static JFrame frame;
    static GraphPanel graphPanel;
    static EquationPanel equationPanel;
    static MenuPanel menuPanel;
    static Dimension screenSize;
    static boolean lineModeOn = true;

    public static void runClient() { //The client frame runs the frame that hosts the panels
        frame = new JFrame("Implicit Plotter");
        frameSetup();
        panelSetup();
        addPanels();
    }

    public static void frameSetup() { //set up the frame
        frame.setLayout(null); 
        frame.setVisible(true);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon("res/images/icon/icon.gif");
        frame.setIconImage(icon.getImage());
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds( (int)(screenSize.getWidth()/2 - 400),
                        (int)(screenSize.getHeight()/2 - 350), 
                         806, 
                         628 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void panelSetup() { //set up the various panels
        graphPanel = new GraphPanel(new Dimension(500,577));
        equationPanel = new EquationPanel(new Dimension(300,577));
        menuPanel = new MenuPanel(new Dimension(600,23));

        equationPanel.setBounds(0,23,300,577);
        graphPanel.setBounds(300,23,500,577);
        menuPanel.setBounds(0,0,600,23);
    } 

    public static void addPanels() { //add the panels to frame
        frame.add(equationPanel);
        frame.add(graphPanel);
        frame.add(menuPanel);
    }
} 