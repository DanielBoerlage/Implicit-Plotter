package implicitplot.equations;

public class Equation {
    
	ParseTree root; 
	String parseBuffer, eqnString;
	int parseIndex;

    public Equation(String eqnString) {
    	parseBuffer = new String();
    	parseIndex = 0;
    	this.eqnString = eqnString;
    	eqnString = eqnString + "$";  // $ denotes end of string
    	
    }

    void createTree(ParseTree parent) {  // modifies param parent

    }
} 