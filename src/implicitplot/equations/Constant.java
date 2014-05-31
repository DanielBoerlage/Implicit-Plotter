package implicitplot.equations;

public class Constant extends ParseTree {
    
    private final double value;
    
    public Constant(double value) {
        super();
        this.value = value;
    }
    
    @Override
    public double evaluate(double var1, double var2) {
        return value;
    }
}