package implicitplot.graphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


public class NewFunctionFrame extends JFrame{

	JPanel panel;
	JTextField newFunctionField;
	JButton cancel, done;
	JLabel label;
	Font font1 = new Font("SansSerif", Font.BOLD, 18);
    int functionMode = 1; // 1 -- y = f(x)
                          // 2 -- x = f(t)
                          //      y = g(t)
                          // 3 -- r = f(theta)       

    //constructor
	public NewFunctionFrame(){
		super("Add Function");
		frameSetup();
		panelSetup();
		buttonSetup();
		newFunctionFieldSetup();
	}

    //sets up the frame
	public void frameSetup() { //set up the frame
        this.setLayout(null);  //frees up the layout
        this.setVisible(true);
        this.setResizable(false);
        ImageIcon icon = new ImageIcon("res/images/icon/icon.gif");
        this.setIconImage(icon.getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds( (int)(screenSize.getWidth()/2 - 200),
                        (int)(screenSize.getHeight()/2 - 100), 
                         400, 
                         150 );
    }

    public void panelSetup() { //set up the various panels
    	panel = new JPanel();
    	panel.setLayout(null);
    	panel.setBounds(0,0,400,150);
    	panel.setBackground(Color.WHITE);
    	this.add(panel);
    } 

    //sets up the textfield where function is inputted. 
    public void newFunctionFieldSetup(){
    	newFunctionField = new JTextField();
    	newFunctionField.setFont(font1);
    	newFunctionField.setBounds(75, 20, 300, 30);
    	Border border = BorderFactory.createLineBorder(Color.RED, 2);
    	newFunctionField.setBorder(border);
    	panel.add(newFunctionField);
        labelSetup();
    }

    //sets up the "Y = " label
    public void labelSetup(){
    	label = new JLabel("Y = ");
    	label.setFont(font1);
    	label.setBounds(25,22,label.getPreferredSize().width,label.getPreferredSize().height);
    	panel.add(label);  
    }

    //sets up the buttons
    public void buttonSetup(){
    	cancel = new JButton("Cancel");
    	done = new JButton("Done");

    	cancel.setBounds(210, 75, 80, 30);
    	done.setBounds(295, 75, 80, 30);

        panel.add(cancel);
        panel.add(done);

    	cancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                closeWindow();
            }
        });      

        done.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                newFunctionSubpanel();
                closeWindow();
            }
        });
    }

    //called to create a newFunctionSubpanel
    public void newFunctionSubpanel(){
        FunctionSubpanel sp1 = new FunctionSubpanel(newFunctionField.getText());
        Client.equationPanel.addFunctionSubpanel(sp1);
    }

    //shuts off this window.
    public void closeWindow(){
    	this.dispose();
    }

}