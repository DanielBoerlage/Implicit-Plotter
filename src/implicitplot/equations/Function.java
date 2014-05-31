package implicitplot.equations;

import java.util.Iterator;

public class Function extends ParseTree {
    
    public enum Type {
        DEFAULT, NEG, PLUS, MINUS, MULT, DIV
    };
    private final Type type;
    
    public Function(Type type) {
        super();
        this.type = type;
    }

    public Function(String typeString) {
        super();
        switch(typeString.toLowerCase()) {
            case "neg": case "negate": case "negative":
                type = Type.NEG;
                break;
            case "plus": case "sum":
                type = Type.PLUS;
                break;
            case "minus": case "subtract":
                type = Type.MINUS;
                break;
            case "mult": case "multiply":
                type = Type.MULT;
                break;
            case "div": case "divide":
                type = Type.DIV;
                break;
            default:
                type = Type.DEFAULT;
                break;
        }
    }
    
    @Override
    public double evaluate(double var1, double var2) {
        switch(type) {
            case NEG:
                return - children[0].evaluate(var1, var2);

            case PLUS:
                double sum = children[0].evaluate(var1, var2);
                for(int i = 1; i < children.length; i++)
                    sum += children[i].evaluate(var1, var2);
                return sum;

            case MINUS:
                return children[0].evaluate(var1, var2) - children[1].evaluate(var1, var2);

            case MULT:
                double product = children[0].evaluate(var1, var2);
                for(int i = 1; i < children.length; i++)
                    product *= children[i].evaluate(var1, var2);
                return product;

            case DIV:
                return children[0].evaluate(var1, var2) / children[1].evaluate(var1, var2);
        }
        return Double.NaN;
    }
}