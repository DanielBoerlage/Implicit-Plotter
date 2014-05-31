package implicitplot.equations;

import java.util.ArrayList;

abstract public class ParseTree {
    
    public ParseTree[] children;
    
    protected ParseTree() {
    	children = new ParseTree[0];
    }

    public void addChild(ParseTree parseTree) {
    	ParseTree[] newChildren = new ParseTree[children.length + 1];
    	for(int i = 0; i < children.length; i++)
    		newChildren[i] = children[i];
    	newChildren[newChildren.length - 1] = parseTree;
    	children = new ParseTree[newChildren.length];
    	for(int i = 0; i < children.length; i++)
    		children[i] = newChildren[i];
    }

    abstract public double evaluate(double var1, double var2);
}