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
        parseBuffer = eqnString.substring(0, parseIndex);
        if(eqnString.charAt(parseIndex) == '(')
            root = new Function(parseBuffer);
        else if(eqnString.charAt(parseIndex) == '$')
            root = constantOrVariable();
        parseIndex++;
    }

    private ParseTree constantOrVariable() {
        try {
            return new Constant(new Double(parseBuffer));
        } catch (NumberFormatException e) {
            return new Variable(parseBuffer);
        }
    }

    void createTree(ParseTree parent) {  // modifies param parent
        while(true) {  // todo : avoid infinite loop
            switch(eqnString.charAt(parseIndex)) {
                case '(':
                    // stuff
                    break;
                case ')':
                    parent.addChild(constantOrVariable());
                    parseBuffer = "";
                    parseIndex++;
                    return;
                case ',':
                    // stuff
                    break;
                case '$':
                    //if ()
                    break;
                default:
                    parseBuffer = parseBuffer + eqnString.charAt(parseIndex);
                    parseIndex++;
                    break;    
            }
        }
    }
} 