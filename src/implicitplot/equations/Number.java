package implicitplot.equations;

public class Number extends ParseTree {
    
    private final double value;
    
    public Number(double value) {
        super();
        this.value = value;
    }
    
    @Override
    public double evaluate(double var1, double var2) {
        return value;
    }
}