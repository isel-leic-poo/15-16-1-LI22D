package poo.demos.expressions.newones;

/**
 * TODO: Document
 */
public enum ArithmeticOperation {

    SUM('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    REMAINDER('%');

    private char operation;

    ArithmeticOperation(char operation) {
        this.operation = operation;
    }

    public int operate(int a, int b) {
        int result = 0;
        switch (this) {
            case SUM: result = a + b; break;
            case SUBTRACTION: result = a - b; break;
            case MULTIPLICATION: result = a * b; break;
            case DIVISION: result = a / b; break;
            case REMAINDER: result = a % b; break;
        }
        return result;
    }

    public static ArithmeticOperation fromSymbol(char operation) throws InvalidOperationException {
        ArithmeticOperation instance = null;
        switch (operation) {
            case '+': instance = SUM; break;
            case '-': instance = SUBTRACTION; break;
            case '*': instance = MULTIPLICATION; break;
            case '/': instance = DIVISION; break;
            case '%': instance = REMAINDER; break;
            default: throw new InvalidOperationException("Invalid operation '" + operation + "'");
        }
        return instance;
    }


    @Override
    public String toString() {
        return String.valueOf(operation);
    }
}
