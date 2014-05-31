package graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

	public static void run() {

		//Components
		JFrame login = new JFrame("Hi");
		JPanel panel = new JPanel();
        JLabel title = new JLabel("implicit Plotter");
        JLabel about = new JLabel("Created by Philip Xu & Daniel Boerlage 2014");
        JButton start = new JButton("Start");

		//Frame setup

        Dimension screenSize = 
                    Toolkit.getDefaultToolkit().getScreenSize(); //rtn: dimension of client-side monitor
        login.setUndecorated(true);  
		login.add(panel);
		login.setVisible(true);
        login.setBounds((int)(screenSize.getWidth()/2 - 200),  // sets frame to be the center of client screen
                        (int)(screenSize.getHeight()/2 - 100), 
                        440,  // these are dimensions of frame
                        130); //
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adding all the components to panel

        panel.add(title);
        panel.add(about);
        panel.add(start);

        //positioning setup
        
        panel.setLayout(null);  //Freestyle layout
        Insets insets = panel.getInsets(); 
        Dimension titleSize = title.getPreferredSize();
        Dimension aboutSize = about.getPreferredSize();
        title.setBounds(25 + insets.left, 30 + insets.top,titleSize.width, titleSize.height);
        about.setBounds(25 + insets.left, 80 + insets.top,aboutSize.width, aboutSize.height);
        start.setBounds(340,30,70,70);

        

        //Button Listener
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	//int x = Integer.parseInt(width.getText());
            	//int y = Integer.parseInt(height.getText());
                implicitplot.graphics.Client.guiInit();
            }
        });
	}
}