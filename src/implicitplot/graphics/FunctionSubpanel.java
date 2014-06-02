//Author - Philip Xu 2014

package implicitplot.graphics;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class FunctionSubpanel extends JPanel{
	
	ArrayList<Point> pointsList;
	public FunctionSubpanel(){
		super();
		pointsList = new ArrayList<Point>();
	}
	
	public void addPoint(Point point){//TO-DO: implement xScale and yScale
        this.pointsList.add(point);
    }
	
	public ArrayList<Point> getPointsList(){
		return this.pointsList;
	}
}