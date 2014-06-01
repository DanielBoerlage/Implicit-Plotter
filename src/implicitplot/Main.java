//Open-Sourced
//Author - Philip Xu 2014
//		 - Daniel Boerlage 2014

package implicitplot;

import implicitplot.equations.*;

public class Main {

	public static void main(String[] args) {

		//implicitplot.graphics.StartUpWindow.run();

		Equation eqn = new Equation("sin(x)$ could also go  cos(minus(HALF_PI,x))  just for fun");
		double approxPi = eqn.newtonsMethod(2, 0);
		System.out.println("approximation of pi from sin(x) = 0:   " + approxPi);
	}
}