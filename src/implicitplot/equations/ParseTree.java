package implicitplot.equations;

import java.util.ArrayList;

abstract public class ParseTree {
    
    protected ParseTree parent;
    protected ArrayList<ParseTree> children;
    
    protected ParseTree() { // used for root of parse tree
    }
    
    protected ParseTree(ParseTree parent) { // used for any branch of parse tree
        this.parent = parent;
    }
   
    abstract protected double evaluate();
}