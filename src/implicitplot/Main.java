// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot;

import implicitplot.equations.*;

public class Main {

	public static void main(String[] args) {

		implicitplot.graphics.StartUpWindow.run();

		Equation eqn = new Equation("sin(x)$ could also go  cos(minus(HALF_PI,x))  just for fun");
		double approxPi = eqn.newtonsMethod(2, 0);
		System.out.println("approximation of pi from sin(x) = 0:   " + approxPi);
	}
}