// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.equations;

/**
 * @author Daniel Boerlage
 */
public class ExplicitFunction extends Eqaution {
	
	public ExplicitFunction(String funcString) {
		super(funcString);
	}

	public double evaluate(double indepVar) {
		return evaluate(indepVar, 0);
	}

	public double derrivative(double indepVar) {
		return derrivative(indepVar, 0);
	}
}