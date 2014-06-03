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
	
	public FunctionSubpanel() {
		super();
		pointsList = new ArrayList<Point>();
		test();
	}
	
	public void addPoint(Point point) {//TO-DO: implement xScale and yScale
        this.pointsList.add(point);
    }

    public void test(){
    	for(int i = -1000; i <= 1000; i += 1){//parametric : x = cos(theta) * r, y = sin(theta) * r
            Point p = new Point(
                                (int)(Math.toRadians((double)i) * 25),
                                (int)(Math.sin(Math.toRadians((double)i))  * 50));
            this.addPoint(p);
        }
    }
	
	public ArrayList<Point> getPointsList() {
		return this.pointsList;
	}
}