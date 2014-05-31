package implicitplot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

	public static void main(String[] args) {

		//Components
		JFrame login = new JFrame();
		JPanel panel = new JPanel();
		JLabel w = new JLabel("Enter Width Here:");
		JLabel h = new JLabel("Enter Height Here:");
		JTextField width = new JTextField(6);
		JTextField height = new JTextField(6);
		JButton start = new JButton("Start");

		//Frame setup
		login.add(panel);
		login.setVisible(true);
        login.setBounds(100, 100, 365, 170);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.setTitle("Implicit Plotter");

        //Panel and component positioning code.
        panel.setLayout(null);
        Insets insets = panel.getInsets();
        Dimension size1 = width.getPreferredSize();
        Dimension size2 = w.getPreferredSize();
        Dimension size3 = h.getPreferredSize();
        panel.add(w);
        panel.add(width);
        panel.add(h);
        panel.add(height);
        panel.add(start);
        width.setBounds(150 + insets.left, 30 + insets.top,size1.width, size1.height);
        height.setBounds(150 + insets.left, 80 + insets.top,size1.width, size1.height);
        w.setBounds(25 + insets.left, 30 + insets.top,size2.width, size2.height);
        h.setBounds(25 + insets.left, 80 + insets.top,size3.width, size3.height);
        start.setBounds(250,30,70,70);

        //Button Listener
        start.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	int x = Integer.parseInt(width.getText());
            	int y = Integer.parseInt(height.getText());
                implicitplot.graphics.Client.guiInit(x,y);
            }
        });
	}
}