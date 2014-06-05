// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.graphics;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import implicitplot.equations.ExplicitFunction;
import javax.swing.border.Border;

/**
 * @author Philip Xu
 */
public class FunctionSubpanel extends JPanel {

	ArrayList<Point> pointsList;
	Color graphColor;
	String function;
	ExplicitFunction func;
	private Dimension size;
	JLabel functionLabel, yEqualsLabel;
	JTextField functionTextField;


	public FunctionSubpanel(String msg) { //input function string
		super(); //creates jpanel
		functionSetup(msg); //sets up the function object, to be ready for evaluation
		createAndShowGUI(msg); //creates and show the gui
	}

	public FunctionSubpanel(Color color,String msg) { //input color and function string
		super();
		functionSetup(msg);
		createAndShowGUI(color,msg);
	}

	public void createAndShowGUI(String msg){
		this.setBackground(Color.WHITE);
		this.graphColor = Color.RED;
		this.size = new Dimension(280, 80); //sets the size
		this.setLayout(null); // frees up the layout
		labelSetup(); //
	}
	
	public void createAndShowGUI(Color color,String msg){
		this.setBackground(Color.WHITE);
		this.graphColor = color;
		this.size = new Dimension(280, 80);
		this.setLayout(null);
		labelSetup();
	}

	public void functionSetup(String msg){
		func = new ExplicitFunction(msg); //creates a new function object with input string
		this.function = msg; //sets the string
		pointsList = new ArrayList<Point>(); //initiate the arraylist
		evaluateAndGenerate(); //evaluate to fill up the array of points
	}

	public void evaluateAndGenerate(){ //evaluate a normal y = f(x) function, fills up a arraylist of points
		for(int i = -1000; i <= 1000; i += 1){
            Point p = new Point((int)(((double)i / Client.graphPanel.xZoom) * Client.graphPanel.xZoom), 
                                (int)(func.evaluate((double)i / Client.graphPanel.yZoom)* Client.graphPanel.xZoom));
            this.addPoint(p);
        }
	}

	public void labelSetup(){ //sets up the labels and the functions of the labels
		//sets up yEqualsLabel, which is just "y ="
		yEqualsLabel = new JLabel(" y =  "); 
		yEqualsLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		yEqualsLabel.setBounds(5,
								this.size.height/2 - yEqualsLabel.getPreferredSize().height - 5,
								yEqualsLabel.getPreferredSize().width,
								yEqualsLabel.getPreferredSize().height);



		//sets up functionLabel, it displays the function string
		functionLabel = new JLabel(function);
		functionLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		functionLabel.setBounds(5 + yEqualsLabel.getPreferredSize().width,
								this.size.height/2 - functionLabel.getPreferredSize().height - 30,
								this.getPreferredSize().width - yEqualsLabel.getPreferredSize().width - 5,
								this.getPreferredSize().height);


		//when funtionlabel is clicked, the labels turns into a textfield, allowing for change
		functionLabel.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				//belows sets up the textfield
				functionTextField = new JTextField(function);
				functionTextField.setFont(new Font("SansSerif", Font.BOLD, 24));
				functionTextField.setBounds(59,
											size.height/2 - functionTextField.getPreferredSize().height - 3,
											216,
											functionTextField.getPreferredSize().height);
				Border border = BorderFactory.createLineBorder(Color.RED, 1);
    			functionTextField.setBorder(border);
    			functionTextField.setEditable(true);

    			//below setss up the focuslistener, called when the textfield loses focus.
    			functionTextField.addFocusListener(new FocusListener(){
    				public void focusGained(FocusEvent e) {}
            		public void focusLost(FocusEvent e)
           			{
           				functionSetup(functionTextField.getText());
           				Client.graphPanel.repaint();
           				functionTextField.setVisible(false);
           				functionLabel.setText(function);
           				functionLabel.setVisible(true);
           			}
    			});

    			//below sets up actionlistener, when enter is pressed, this is called,
    			//does the same thing as focusListener.
    			functionTextField.addActionListener(new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
        				functionSetup(functionTextField.getText());
           				Client.graphPanel.repaint();
           				functionTextField.setVisible(false);
           				functionLabel.setText(function);
           				functionLabel.setVisible(true);
    				}
				});

    			
				functionLabel.setVisible(false);
				add(functionTextField);
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}
			});




		this.add(functionLabel);
		this.add(yEqualsLabel);
	}


	public void setDimension(Dimension d){
		this.size = d;
	}
	 
	public void addPoint(Point point) {
        this.pointsList.add(point);
    }
	
	public ArrayList<Point> getPointsList() {
		return this.pointsList;
	}

	public Dimension getPreferredSize() {
		return this.size;
	}
}