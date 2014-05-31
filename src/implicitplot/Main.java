//Open-Sourced
//Author - Philip Xu 2014
//		 - Daniel Boerlage 2014

package implicitplot;

import implicitplot.equations.*;

public class Main {

	public static void main(String[] args) {
		//graphics.Login.run();
		//eqnTest();
		Equation eqn = new Equation("theta");
	}

	public static void eqnTest() {
		//this example string would be  x^2 - 1   or   minus(mult(x,x),1)
		/*ParseTree tree = new Function(Function.Type.MINUS);
		tree.children = new ParseTree[2];
		tree.children[0] = new Function(Function.Type.MULT);
		tree.children[0].children = new ParseTree[2];
		tree.children[0].children[0] = new Variable(Variable.Type.X);
		tree.children[0].children[1] = new Variable(Variable.Type.X);
		tree.children[1] = new Constant(1d);*/

		//ParseTree tree = new Variable(Variable.Type.X);

		/*ParseTree tree = new Function(Function.Type.MINUS);
		tree.addChild(new Function(Function.Type.MULT));
		tree.addChild(new Constant(1d));
		tree.children[0].addChild(new Variable(Variable.Type.X));
		tree.children[0].addChild(new Variable(Variable.Type.X));*/

		ParseTree tree = new Function(Function.Type.MINUS);
		tree.addChild(new Function(Function.Type.MULT));
		tree.addChild(new Constant(1d));
		tree.children[0].addChild(new Variable(Variable.Type.X));
		tree.children[0].addChild(new Variable(Variable.Type.X));

		long startTime = System.currentTimeMillis();
		double var = 0;
		for(int i = 0; i < 100001; i++)
			var = tree.evaluate(var, 0);
		System.out.println("result: " + var + "  computed in " + (System.currentTimeMillis() - startTime) + " ms");
	}
}