package implicitplot.equations;

public class Number extends ParseTree {
    
    private final double value;
    
    public Number(ParseTree parent, double value) {
        super(parent);
        this.value = value;
    }
    
    @Override
    public double evaluate() {
        return value;
    }
}