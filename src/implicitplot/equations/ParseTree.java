package implicitplot.equations;

import java.util.ArrayList;

abstract public class ParseTree {
    
    protected ParseTree[] children;
    
    protected ParseTree() {
    }
   
    abstract protected double evaluate();
}