package implicitplot.equations;

public class Equation {
    
	ParseTree root; 
	String parseBuffer, eqnString;
	int parseIndex;

    public Equation(String eqnString) {
        root = new Constant(1d);  // TEMP!!!!!
    	parseBuffer = new String();
    	parseIndex = 0;
    	this.eqnString = eqnString;
    	eqnString = eqnString + "$";  // $ denotes end of string
    	while(eqnString.charAt(parseIndex) != '(' && eqnString.charAt(parseIndex) != '$')
            parseIndex++;
        if(eqnString.charAt(parseIndex) == '(')
            root = new Function(eqnString.substring(0, parseIndex));
        else if(eqnString.charAt(parseIndex) == '$') {
            double value;
            try {
                value = new Double(eqnString.substring(0, parseIndex));
                root = new Constant(value);
            } catch (NumberFormatException e) {
                root = new Variable(eqnString.substring(0, parseIndex));
            }
        System.out.println(root.evaluate(1d,2d));
        }
    }

    void createTree(ParseTree parent) {  // modifies param parent

    }
} 