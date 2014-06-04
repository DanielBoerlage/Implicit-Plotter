// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.graphics;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import implicitplot.equations.ExplicitFunction;

/**
 * @author Philip Xu
 */
public class FunctionSubpanel extends JPanel {

	ArrayList<Point> pointsList;
	Color graphColor;
	String function;
	ExplicitFunction func;
	private Dimension size;


	public FunctionSubpanel(String msg) {
		super();
		func = new ExplicitFunction(msg);
		this.function = " Y =  " + msg;
		this.size = new Dimension(280, 60);
		this.graphColor = Color.BLACK;
		pointsList = new ArrayList<Point>();
		evaluateAndGenerate();
	}

	public FunctionSubpanel(Color color,String msg) {
		super();
		func = new ExplicitFunction(msg);
		this.function = " Y =  " + msg;
		this.size = new Dimension(280, 60);
		this.graphColor = color;
		pointsList = new ArrayList<Point>();
		evaluateAndGenerate();
	}

	public void evaluateAndGenerate(){

		for(int i = -1000; i <= 1000; i += 1){//parametric : x = cos(theta) * r, y = sin(theta) * r
            Point p = new Point((int)(((double)i / 25) * 25),
                                (int)(func.evaluate((double)i / 25)* 25));
            this.addPoint(p);
        }
	}

	//(int)(Math.toRadians((double)i) * 25),

	public void setDimension(Dimension d){
		this.size = d;
	}
	 
	public void addPoint(Point point) {//TO-DO: implement xScale and yScale
        this.pointsList.add(point);
    }
	
	public ArrayList<Point> getPointsList() {
		return this.pointsList;
	}

	public Dimension getPreferredSize() {
		return this.size;
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0,0,this.getPreferredSize().width,this.getPreferredSize().height);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("SansSerif", Font.BOLD, 24));
		g2d.drawString(function,10,this.size.height/2 + 10);
	}
}