package implicitplot.equations;

import java.util.ArrayList;

public class ParseTree {
    
    public ParseTree[] children;
    
    public ParseTree() {
    	children = new ParseTree[0];
    }

    public ParseTree addChild(ParseTree parseTree) {
    	ParseTree[] newChildren = new ParseTree[children.length + 1];
    	for(int i = 0; i < children.length; i++)
    		newChildren[i] = children[i];
    	newChildren[newChildren.length - 1] = parseTree;
    	children = new ParseTree[newChildren.length];
    	for(int i = 0; i < children.length; i++)
    		children[i] = newChildren[i];
        return parseTree;
    }

    public double evaluate(double var1, double var2) {
        if(children.length < 1)
            return Double.NaN;
        return children[0].evaluate(var1, var2);
    }
}