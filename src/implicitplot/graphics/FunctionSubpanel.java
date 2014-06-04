// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.graphics;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author Philip Xu
 */
public class FunctionSubpanel extends JPanel {

	ArrayList<Point> pointsList;
	Color graphColor;
	String function;
	private Dimension size;


	public FunctionSubpanel(String msg) {
		super();
		this.function = " Y =  " + msg;
		this.size = new Dimension(280, 60);
		this.graphColor = Color.BLACK;
		pointsList = new ArrayList<Point>();
	}

	public FunctionSubpanel(Color color,String msg) {
		super();
		this.function = " Y =  " + msg;
		this.size = new Dimension(280, 60);
		this.graphColor = color;
		pointsList = new ArrayList<Point>();
	}

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