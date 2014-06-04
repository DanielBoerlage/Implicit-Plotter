// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.graphics;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Philip Xu
 */
public class EquationPanel extends JPanel {
	
	public int width, height, x, y;
	private int numOfFunctionSubpanels; // used to determine y position of each subpanel
	private JButton addEquation;
	private Dimension size;
	ArrayList<FunctionSubpanel> functionList ;

	public EquationPanel(Dimension d) { //Default constructor
		super(); // create panel
		this.size = d; //set the size to input
		numOfFunctionSubpanels = 0; //set to 9
		this.functionList = new ArrayList<FunctionSubpanel>(); //Arraylist of FunctionSubpanels
		guiSetup(); //sets up gui
		buttonSetup(); //sets up the buttons
	}

	public ArrayList<FunctionSubpanel> getFunctionList(){ //returns functionList
		return this.functionList;
	}

	public void addFunctionSubpanel(FunctionSubpanel subpanel) { //add subpanel to this panel
		this.functionList.add(subpanel);
		subpanel.setBounds(10, 
						   10 + ((subpanel.getPreferredSize().height+10) * numOfFunctionSubpanels),
						   subpanel.getPreferredSize().width,
						   subpanel.getPreferredSize().height
						   );
		this.add(subpanel);
		numOfFunctionSubpanels ++;
		this.repaint();
	}

	public void buttonSetup() { //sets up the button
		addEquation = new JButton("Add");
		addEquation.setBounds((int)(this.getPreferredSize().width - 100),
							(int)(this.getPreferredSize().height - 60),
							80,
							40);
		this.add(addEquation); 
		addEquation.addActionListener(new ActionListener() { 
 			//called when button is pressed
            public void actionPerformed(ActionEvent e)
            {
                NewFunctionFrame addFunctionFrame = new NewFunctionFrame(); //opens a new NewFuntionFrame
            }
        });
	}

	public void guiSetup() {
		this.setLayout(null); // frees up the gui
		this.setBackground(new Color(0,255,255)); //color here
	}

	public Dimension getPreferredSize() { // this.size
		return this.size;
	}
}