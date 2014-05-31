package implicitplot.equations;

public class Variable extends ParseTree {
    
    public enum Type {DEFAULT, X, Y, THETA, R};
    private final Type type;
    
    public Variable(Type type) {
        super();
        this.type = type;
    }

    public Variable(String typeString) {
        super();
        switch(typeString.toLowerCase()) {
            case "x":
                type = Type.X;
                break;
            case "y":
                type = Type.Y;
                break;
            case "theta":
                type = Type.THETA;
                break;
            case "r":
                type = Type.R;
                break;
            default:
                type = Type.DEFAULT;
                break;      
        }
    }
    
    @Override
    public double evaluate(double var1, double var2) {
        if(type == Type.X || type == Type.THETA)
            return var1;
        if(type != Type.DEFAULT)
            return var2;
        return Double.NaN;
    }
}