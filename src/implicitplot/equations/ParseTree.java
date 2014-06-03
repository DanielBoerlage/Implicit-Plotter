// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.equations;

import java.util.ArrayList;

/**
 * @author Daniel Boerlage
 */
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