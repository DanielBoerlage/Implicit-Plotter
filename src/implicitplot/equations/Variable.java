package implicitplot.equations;

public class Variable extends ParseTree {
    
    public enum Type {X, Y, R, THETA};
    private final Type type;
    private double value;
    
    public Variable(ParseTree parent, Type type) {
        super(parent);
        this.type = type;
    }
    
    public Variable(ParseTree parent, Type type, double value) {
        this(parent, type);
        this.value = value;
    }
    
    public void set(double value) {
        this.value = value;
    }
    
    @Override
    public double evaluate() {
        return value;
    }
}