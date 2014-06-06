package implicitplot.graphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


public class NewFunctionFrame extends JFrame{

	JPanel panel;
	JTextField newFunctionField, newParametricXField, newParametricYField, newPolarField;
	JButton cancel, done;
	JLabel label, label2;
    String[] modes = { "Function", "Parametric", "Polar"};
    JComboBox modesList;
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
        //newParametricFieldSetup();

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

    public void newParametricFieldSetup(){
        newParametricXField = new JTextField();
        newParametricXField.setFont(font1);
        newParametricXField.setBounds(75, 10, 300, 25);
        Border border = BorderFactory.createLineBorder(Color.GREEN, 2);
        newParametricXField.setBorder(border);
        panel.add(newParametricXField);

        newParametricYField = new JTextField();
        newParametricYField.setFont(font1);
        newParametricYField.setBounds(75, 40, 300, 25);
        newParametricYField.setBorder(border);
        panel.add(newParametricYField);
        parametricLabelSetup();
    }

    //sets up the "Y = " label
    public void labelSetup(){
    	label = new JLabel("Y  =");
    	label.setFont(font1);
    	label.setBounds(25,22,label.getPreferredSize().width,label.getPreferredSize().height);
    	panel.add(label);  
    }

    public void parametricLabelSetup(){
        label = new JLabel("X  =");
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        label.setBounds(25,12,label.getPreferredSize().width,label.getPreferredSize().height);

        label2 = new JLabel("Y  =");
        label2.setFont(new Font("SansSerif", Font.BOLD, 16));
        label2.setBounds(25,42,label.getPreferredSize().width,label.getPreferredSize().height);

        panel.add(label); 
        panel.add(label2);
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