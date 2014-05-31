package implicitplot.equations;

public class Function extends ParseTree {
    
    public enum Type {NEG, PLUS, MINUS, MULT, DIV};
    private final Type type;
    
    public Function(Type type) {
        super();
        this.type = type;
    }
    
    @Override
    public double evaluate(double var1, double var2) throws IllegalArgumentException {
        int nArgs = children.length;
        switch(type) {
            case NEG:
                if(nArgs == 1)
                    return - children[0].evaluate(var1, var2);
                throw new IllegalArgumentException("The negate operation requires one argument");
            case PLUS:
                if(nArgs >= 2) {
                    double sum = children[0].evaluate(var1, var2);
                    for(int i = 1; i < nArgs; i++)
                        sum += children[i].evaluate(var1, var2);
                    return sum;
                }
                throw new IllegalArgumentException("The plus operation requires two or more arguments");
            case MINUS:
                if(nArgs == 2)
                    return children[0].evaluate(var1, var2) - children[1].evaluate(var1, var2);
                throw new IllegalArgumentException("The minus operation requires two arguments");
            case MULT:
                if(nArgs >= 2) {
                    double product = children[0].evaluate(var1, var2);
                    for(int i = 1; i < nArgs; i++)
                        product *= children[i].evaluate(var1, var2);
                    return product;
                }
                throw new IllegalArgumentException("The multiplication operation requires two or more arguments");
            case DIV:
                if(nArgs == 2)
                    return children[0].evaluate(var1, var2) / children[1].evaluate(var1, var2);
                throw new IllegalArgumentException("The division operation requires two arguments");
        }
        return 0d / 0d;  // NaN
    }
}