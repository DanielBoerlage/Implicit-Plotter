//Open-Sourced
//Author - Philip Xu 2014
//		 - Daniel Boerlage 2014

package implicitplot;

import implicitplot.equations.*;

public class Main {

	public static void main(String[] args) {
		//implicitplot.graphics.StartUpWindow.run();
		Equation eqn = new Equation("pow(5.4,5)");  // (x+1)*(1+1+1)*(-y)
		System.out.println(eqn.root.evaluate(3, 1/2.0));
	}
}