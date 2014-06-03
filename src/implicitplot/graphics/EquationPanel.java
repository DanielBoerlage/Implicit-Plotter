// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.graphics;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

/**
 * @author Philip Xu
 */
public class EquationPanel extends JPanel {
	
	public int width, height, x, y;
	private JButton addEquation;
	private Dimension size;
	ArrayList<FunctionSubpanel> functionList ;

	public EquationPanel(Dimension d) {
		super();
		this.size = d;
		this.functionList = new ArrayList<FunctionSubpanel>();
		guiSetup();
		buttonSetup();
	}

	public ArrayList<FunctionSubpanel> getFunctionList(){
		return this.functionList;
	}

	public void addFunctionSubpanel(FunctionSubpanel subpanel) {
		this.functionList.add(subpanel);
		this.repaint();
	}

	public void buttonSetup() {
		addEquation = new JButton("Add");
		addEquation.setBounds((int)(this.getPreferredSize().width - 100),
							(int)(this.getPreferredSize().height - 60),
							80,
							40);
		this.add(addEquation);
		System.out.println(this.getPreferredSize().width + "  " + this.getPreferredSize().height);
	}

	public void guiSetup() {
		this.setLayout(null);
		this.setBackground(Color.BLUE);
	}

	public Dimension getPreferredSize() {
		return this.size;
	}
}