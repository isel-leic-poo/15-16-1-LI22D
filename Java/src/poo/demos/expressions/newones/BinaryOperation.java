package poo.demos.expressions.newones;

import static poo.demos.expressions.newones.ArithmeticOperation.*;

/**
 * Class whose instances represent binary arithmetic operations.
 */
public class BinaryOperation extends Expression {

    private final ArithmeticOperation operation;
    private final Expression left;
    private final Expression right;

    /**
     * Initiates an instance with the given operation and operands.
     * @param operation The operation sign ('+', '-', '*', '/' or '%')
     * @param left The left operand
     * @param right The right operand
     */
    public BinaryOperation(ArithmeticOperation operation, Expression left, Expression right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    /** {@inheritDoc} */
    @Override
    public int evaluate() {
        return operation.operate(left.evaluate(), right.evaluate());
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
