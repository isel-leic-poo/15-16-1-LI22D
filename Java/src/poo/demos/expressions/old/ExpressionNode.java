package poo.demos.expressions.old;

public class ExpressionNode {

    private static final char NO_OP = '\0';

    private final int value;
    private final char operation;
    private final ExpressionNode left;
    private final ExpressionNode right;

    private ExpressionNode(int value, char operation, ExpressionNode left, ExpressionNode right) {
        this.value = value;
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public ExpressionNode(int value) {
        this(value, NO_OP, null, null);
    }

    public ExpressionNode(char operation, ExpressionNode left, ExpressionNode right) {
        this(0, operation, left, right);
    }

    public int getValue() {
        switch (operation) {
            case '+': return left.getValue() + right.getValue();
            case '-': return left.getValue() - right.getValue();
            case '*': return left.getValue() * right.getValue();
            case '/': return left.getValue() / right.getValue();
            case '%': return left.getValue() % right.getValue();
            default: return value;
        }
    }

    public String toString() {
        final StringBuilder result = new StringBuilder();
        if(operation == NO_OP) {
            result.append(' ').append(value).append(' ');
        }
        else {
            result.append('(').append(left.toString())
                    .append(' ').append(operation).append(' ')
                    .append(right.toString()).append(')');
        }
        return result.toString();
    }
}
