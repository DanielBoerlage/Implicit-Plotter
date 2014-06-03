// Copyright (c) 2014 Daniel Boerlage and Philip Xu
// Distributed under the GNU GPL software license, see the accompanying
// file LICENSE or http://www.gnu.org/licenses/gpl-3.0.html

package implicitplot.equations;

/**
 * @author Daniel Boerlage
 */
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