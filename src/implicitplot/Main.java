//Open-Sourced
//Author - Philip Xu 2014
//		 - Daniel Boerlage 2014

package implicitplot;

import implicitplot.equations.*;

public class Main {

	public static void main(String[] args) {

		//implicitplot.graphics.StartUpWindow.run();
<<<<<<< HEAD
		Equation eqn = new Equation("pow(5.4,5)");  // (x+1)*(1+1+1)*(-y)
		System.out.println(eqn.root.evaluate(3, 1/2.0));
=======

		Equation eqn = new Equation("sin(x)$ could also go  cos(minus(HALF_PI,x))  just for fun");
		double approxPi = eqn.newtonsMethod(2, 0);
		System.out.println("approximation of pi from sin(x) = 0:   " + approxPi);
>>>>>>> f0f1cf0321ea605cdf9f9e00b2b966bf6a8c16e9
	}
}