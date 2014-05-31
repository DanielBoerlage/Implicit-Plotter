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
            root = new Function("hi");
    }

    void createTree(ParseTree parent) {  // modifies param parent

    }
} 