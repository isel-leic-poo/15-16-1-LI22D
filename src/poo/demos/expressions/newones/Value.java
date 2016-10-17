package poo.demos.expressions.newones;

/**
 * Class whose instances represent expression values.
 */
public class Value extends Expression {

    /** The value */
    private final int value;

    /**
     * Initiates an instance with the given value.
     * @param value The instance's value
     */
    public Value(int value) {
        this.value = value;
    }

    /** {@inheritDoc} */
    @Override
    public int evaluate() {
        return value;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return new StringBuilder().append(' ').append(value).append(' ').toString();
    }
}
