package implicitplot.equations;

import java.util.Iterator;

public class Function extends ParseTree {
    
    private final String type;
    
    public Function(String type) {
        super();
        this.type = type;
    }
    
    @Override
    public double evaluate(double var1, double var2) {
        switch(type.toLowerCase()) {
            case "neg": case "negative":
                return - children[0].evaluate(var1, var2);

            case "plus": case "sum":
                double sum = 0d;
                for(ParseTree p : children)
                    sum += p.evaluate(var1, var2);
                return sum;

            case "minus": case "subtract":
                return children[0].evaluate(var1, var2) - children[1].evaluate(var1, var2);

            case "mult": case "multiply":
                double product = 1d;
                for(ParseTree p : children)
                    product *= p.evaluate(var1, var2);
                return product;

            case "div": case "divide":
                return children[0].evaluate(var1, var2) / children[1].evaluate(var1, var2);

            case "mod": case "modulus": case "modulo":
                return children[0].evaluate(var1, var2) % children[1].evaluate(var1, var2);

            case "pow": case "power":
                return Math.pow(children[0].evaluate(var1, var2), children[1].evaluate(var1, var2));

            case "abs": case "absolute":
                return Math.abs(children[0].evaluate(var1, var2));

            case "sqrt": case "squareroot":
                return Math.sqrt(children[0].evaluate(var1, var2));

            case "exp": case "exponential":
                return Math.exp(children[0].evaluate(var1, var2));

            case "log": case "ln": case "logarithm":
                return Math.log(children[0].evaluate(var1, var2));

            case "log2":
                return Math.log(children[0].evaluate(var1, var2)) / 0.69314718056;  // natural logartim of 2

            case "log10":
                return Math.log10(children[0].evaluate(var1, var2));

            case "sin": case "sine":
                return Math.sin(children[0].evaluate(var1, var2));

            case "cos": case "cosine":
                return Math.cos(children[0].evaluate(var1, var2));

            case "tan": case "tangent":
                return Math.tan(children[0].evaluate(var1, var2));

            case "asin": case "arcsin":
                return Math.asin(children[0].evaluate(var1, var2));

            case "acos": case "arccos":
                return Math.acos(children[0].evaluate(var1, var2));

            case "atan": case "arctan":
                return Math.atan(children[0].evaluate(var1, var2));

            case "atan2":
                return Math.atan2(children[0].evaluate(var1, var2), children[1].evaluate(var1, var2));

            case "sinh":
                return Math.sinh(children[0].evaluate(var1, var2));

            case "cosh":
                return Math.cosh(children[0].evaluate(var1, var2));

            case "tanh":
                return Math.tanh(children[0].evaluate(var1, var2));

            case "cbrt": case "cuberoot":
                return Math.cbrt(children[0].evaluate(var1, var2));

            case "ceil": case "ceiling":
                return Math.ceil(children[0].evaluate(var1, var2));

            case "floor": case "entier": case "int": case "integer":
                return Math.floor(children[0].evaluate(var1, var2));

            case "expm1":
                return Math.expm1(children[0].evaluate(var1, var2));

            case "hypot":
                return Math.hypot(children[0].evaluate(var1, var2), children[1].evaluate(var1, var2));

            case "max": case "maximum":
                double max = Double.NEGATIVE_INFINITY;
                for(ParseTree p : children) 
                    max = Math.max(max, p.evaluate(var1, var2));
                return max;

            case "min": case "minimum":
                double min = Double.POSITIVE_INFINITY;
                for(ParseTree p : children)
                    min = Math.min(min, p.evaluate(var1, var2));
                return min;

            case "random":
                return Math.random();

            case "round":
                return Math.rint(children[0].evaluate(var1, var2));

            case "sign": case "singum":
                return Math.signum(children[0].evaluate(var1, var2));

            case "sq": case "square":
                return Math.pow(children[0].evaluate(var1, var2), 2);

            case "deg": case "degrees": case "todegrees":
                return Math.toDegrees(children[0].evaluate(var1, var2));

            case "rad": case "radians": case "toradians":
                return Math.toRadians(children[0].evaluate(var1, var2));

            case "rect": case "between":
                double x = children[0].evaluate(var1, var2);
                if(x > children[1].evaluate(var1, var2) && x < children[2].evaluate(var1, var2))
                    return 1d;
                return 0d;  // change to undef later?

            case "mag": case "magnitude":
                sum = 0d;
                for(ParseTree p : children)
                    sum += Math.pow(p.evaluate(var1, var2), 2);
                return Math.sqrt(sum);

            case "avg": case "average":
                sum = 0d;
                for(ParseTree p : children)
                    sum += p.evaluate(var1, var2);
                return sum / children.length;


        }
        return Double.NaN;
    }
}