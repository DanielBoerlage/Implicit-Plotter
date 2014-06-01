package implicitplot.equations;

public class Equation {
    
	public ParseTree root; 
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
                        return;
                    break;
                default:
                    parseBuffer = parseBuffer + parseChar;
                    parseIndex++;
                    break;    
            }
        }
    }

    
} 