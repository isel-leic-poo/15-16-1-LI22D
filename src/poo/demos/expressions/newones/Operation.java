package poo.demos.expressions.newones;

/**
 * Class whose instances represent binary arithmetic operations.
 */
public class Operation extends Expression {

    private final char operation;
    private final Expression left;
    private final Expression right;

    /**
     * Initiates an instance with the given operation and operands.
     * @param operation The operation sign ('+', '-', '*', '/' or '%')
     * @param left The left operand
     * @param right The right operand
     */
    public Operation(char operation, Expression left, Expression right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    /** {@inheritDoc} */
    @Override
    public int evaluate() {
        switch (operation) {
            case '+': return left.evaluate() + right.evaluate();
            case '-': return left.evaluate() - right.evaluate();
            case '*': return left.evaluate() * right.evaluate();
            case '/': return left.evaluate() / right.evaluate();
            case '%': return left.evaluate() % right.evaluate();
            default: return 0;
        }
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return new StringBuilder()
                .append('(').append(left.toString())
                .append(' ').append(operation).append(' ')
                .append(right.toString()).append(')')
                .toString();
    }
}
