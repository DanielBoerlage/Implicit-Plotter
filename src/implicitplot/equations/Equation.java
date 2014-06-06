// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.equations;

/**
 * @author Daniel Boerlage
 */
public class Equation {
    
	private ParseTree root; 
	private String parseBuffer, eqnString;
	private int parseIndex;

    public Equation(String eqnString) {
    	parseBuffer = new String();
    	parseIndex = 0;
        eqnString = eqnString + "$";  // $ denotes end of string
    	this.eqnString = eqnString;
        root = new ParseTree();
        createTree(root);
    }

    private void createTree(ParseTree parent) {  // modifies param parent
        for(int counter = 0; counter < 1000; counter++) {  // If user enters mismatching parentheses this counter will prevent an infinite loop
            char parseChar = eqnString.charAt(parseIndex);
            switch(parseChar) {
                case '(':
                    String tempStr = parseBuffer;
                    parseBuffer = "";
                    parseIndex++;
                    createTree(parent.addChild(new Function(tempStr)));
                    break;
                case ',': case ')': case '$':
                    if(parseBuffer.length() > 0) {
                        try {
                            parent.addChild(new Constant(new Double(parseBuffer)));
                        } catch (NumberFormatException e) {
                            parent.addChild(new Variable(parseBuffer));
                        }
                    }
                    parseBuffer = "";
                    parseIndex++;
                    if(parseChar == ')' || parseChar == '$')
                        return; // todo: $ truly aborts recursive root
                    break;
                case ' ':
                    parseIndex++;
                    break;
                default:
                    parseBuffer = parseBuffer + parseChar;
                    parseIndex++;
                    break;    
            }
        }
    }

    public double evaluate(double var1, double var2) {
        return root.evaluate(var1, var2);
    }

    public double[] solveVar2at(double var1) {
        return new double[0];
    }

    public double newtonsMethod(double guess, double var2) {
        double precision = 1e-8, xNew = guess, xOld;
        do {
            xOld = xNew;
            xNew = xOld - root.evaluate(xOld, var2) / derrivative(xOld, var2);
        } while(Math.abs(xOld - xNew) > precision);
        return xNew;
    }

    public double derrivative(double var1, double var2) {
        return (root.evaluate(var1 + 1e-8, var2) - root.evaluate(var1 - 1e-8, var2)) / 2e-8;
    }
} 