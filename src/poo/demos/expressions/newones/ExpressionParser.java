package poo.demos.expressions.newones;


public class ExpressionParser {

    private static class Token {
        public String expr;
        public int currIdx;

        public Token(String expr) {
            this.expr = expr;
            currIdx = 0;
        }
    }

    private final String expression;

    private Expression parseCommand(Token token) {

        while(token.expr.charAt(token.currIdx) == ' ')
            token.currIdx += 1;

        if(Character.isDigit(token.expr.charAt(token.currIdx)))
            return new Value(token.expr.charAt(token.currIdx++) - '0');

        char opr = token.expr.charAt(token.currIdx++);
        Expression left = parseCommand(token);
        Expression right = parseCommand(token);
        return new Operation(opr, left, right);
    }

    public ExpressionParser(String expression) {
        this.expression = expression;
    }

    public Expression parseCommand() {
        return parseCommand(new Token(expression));
    }
}
