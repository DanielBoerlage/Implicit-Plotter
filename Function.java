package equations;

public class Function extends ParseTree {
    
    public enum Type {NEG, PLUS, MINUS, MULT, DIV};
    private final Type type;
    
    public Function(ParseTree parent, Type type) {
        super(parent);
        this.type = type;
    }
    
    @Override
    public double evaluate() throws IllegalArgumentException {
        int nArgs = children.size();
        if(type == Type.NEG) {
            if(nArgs == 1)
                return - children.get(0).evaluate();
            throw new IllegalArgumentException("The negate operation requires one argument");
        }
        if(type == Type.PLUS) {
            if(nArgs >= 2) {
                double sum = children.get(0).evaluate();
                for(int i = 1; i < nArgs; i++)
                    sum += children.get(i).evaluate();
                return sum;
            }
            throw new IllegalArgumentException("The plus operation requires two or more arguments");
        }
        if(type == Type.MINUS) {
            if(nArgs == 2)
                return children.get(0).evaluate() - children.get(1).evaluate();
            throw new IllegalArgumentException("The minus operation requires two arguments");
        }
        if(type == Type.MULT) {
            if(nArgs >= 2) {
                double product = children.get(0).evaluate();
                for(int i = 1; i < nArgs; i++)
                    product *= children.get(i).evaluate();
                return product;
            }
            throw new IllegalArgumentException("The multiplication operation requires two or more arguments");
        }
        if(type == Type.DIV) {
            if(nArgs == 2)
                return children.get(0).evaluate() / children.get(1).evaluate();
            throw new IllegalArgumentException("The division operation requires two arguments");
        }
        return 0.0;
    }
}