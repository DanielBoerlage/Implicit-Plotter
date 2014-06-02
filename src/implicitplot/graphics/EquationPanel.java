//Author - Philip Xu 2014

package implicitplot.graphics;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class EquationPanel extends JPanel{
	
	public int width, height, x, y;
	private JButton addEquation;

	public EquationPanel(){
		super();
		setGUI();
	}

	public void setGUI(){
		addEquation = new JButton("Add"); 
		this.setLayout(null);
		Dimension buttonSize = addEquation.getPreferredSize();
		addEquation.setBounds((int)(this.getSize().width - buttonSize.width),
							(int)(this.getSize().height - buttonSize.height),
							(int)(buttonSize.width),
							(int)(buttonSize.height));
		this.add(addEquation);

		this.setBackground(Color.BLACK);
	}

}