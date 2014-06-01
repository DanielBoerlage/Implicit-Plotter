package implicitplot.equations;

public class Variable extends ParseTree {
    
    private final String type;
    
    public Variable(String type) {
        super();
        this.type = type;
    }
    
    @Override
    public double evaluate(double var1, double var2) {
        switch(type.toLowerCase()) {
            case "x": case "theta":
                return var1;

            case "y": case "r": case "radius":
                return var2;

            case "pi":
                return 3.141592653589793;

            case "half_pi": case "halfpi":
                return 1.570796326794896;

            case "quater_pi": case "quarterpi":
                return 0.785398163397448;

            case "e":
                return 2.718281828459045;
                
            case "phi":
                return 1.618033988749894;
        }
        return Double.NaN;
    }
}