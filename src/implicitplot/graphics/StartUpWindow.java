//Author - Philip Xu 2014

package implicitplot.graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartUpWindow {

    static JFrame window;
    static JPanel panel;
    static JLabel title, about;
    static JButton start;

	public static void run() {
        componentsInit();
		frameSetup();
        addComponents();
        setComponentsPositions();

        //Button Listener
        buttonConfig();
	}

    public static void buttonConfig(){
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //int x = Integer.parseInt(width.getText());
                //int y = Integer.parseInt(height.getText());
                runClient();
                window.setVisible(false);
            }
        });
    }

    public static void componentsInit(){
        //initializing the frame
        window = new JFrame("Hi");
        //Components
        
        panel = new JPanel();
        title = new JLabel("Implicit Plotter");
        about = new JLabel("Created by Philip Xu & Daniel Boerlage 2014");
        start = new JButton("Start");
    }

    public static void frameSetup(){
        Dimension screenSize = 
                    Toolkit.getDefaultToolkit().getScreenSize(); //rtn: dimension of client-side monitor
        window.setUndecorated(true);  
        window.add(panel);
        window.setVisible(true);
        window.setBounds((int)(screenSize.getWidth()/2 - 200),  // sets frame to be the center of client screen
                        (int)(screenSize.getHeight()/2 - 100), 
                        440,  // these are dimensions of frame
                        130); //
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("res/images/icon/icon.gif");
        window.setIconImage(icon.getImage());
    }

    public static void addComponents(){
        panel.add(title);
        panel.add(about);
        panel.add(start);
        panel.setBackground(new Color(0,102,204));
        title.setForeground(new Color(255,215,0));
        about.setForeground(new Color(255,215,0));
    }

    public static void setComponentsPositions(){
        panel.setLayout(null);  //Freestyle layout
        Insets insets = panel.getInsets(); 
        Dimension titleSize = title.getPreferredSize();
        Dimension aboutSize = about.getPreferredSize();
        title.setBounds(25 + insets.left, 35 + insets.top,titleSize.width, titleSize.height);
        about.setBounds(25 + insets.left, 80 + insets.top,aboutSize.width, aboutSize.height);
        start.setBounds(340,30,70,70);
    }

    public static void runClient(){
        Client client = new Client();
    }

    
}