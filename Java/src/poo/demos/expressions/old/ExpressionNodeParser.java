package poo.demos.expressions.old;

import poo.demos.expressions.old.ExpressionNode;

public class ExpressionNodeParser {

    private static class Token {
        public String expr;
        public int currIdx;

        public Token(String expr) {
            this.expr = expr;
            currIdx = 0;
        }
    }

    private final String expression;

    private ExpressionNode parseCommand(Token token) {

        while(token.expr.charAt(token.currIdx) == ' ')
            token.currIdx += 1;

        if(Character.isDigit(token.expr.charAt(token.currIdx)))
            return new ExpressionNode(token.expr.charAt(token.currIdx++) - '0');

        char opr = token.expr.charAt(token.currIdx++);
        ExpressionNode left = parseCommand(token);
        ExpressionNode right = parseCommand(token);
        return new ExpressionNode(
                opr,
                left,
                right);
    }

    public ExpressionNodeParser(String expression) {
        this.expression = expression;
    }

    public ExpressionNode parseCommand() {
        return parseCommand(new Token(expression));
    }
}
