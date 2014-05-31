package implicitplot.equations;

public class Variable extends ParseTree {
    
    public enum Type {X, Y, THETA, R};
    private final Type type;
    
    public Variable(Type type) {
        super();
        this.type = type;
    }
    
    @Override
    public double evaluate(double var1, double var2) {
        if(type == Type.X || type == Type.THETA)
            return var1;
        return var2;
    }
}