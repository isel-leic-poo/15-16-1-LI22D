package poo.demos;

import java.util.Scanner;

public class Main {

    private static class Token {
        public String expr;
        public int currIdx;

        public Token(String expr) {
            this.expr = expr;
            currIdx = 0;
        }
    }

    private static final ExpressionNode parseCommand(Token token) {

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

    public static void main(String[] args) {
        final Scanner kbd = new Scanner(System.in);
        String expressionLine = "";
        while(!(expressionLine = kbd.nextLine()).isEmpty()) {
            final ExpressionNode exp = parseCommand(new Token(expressionLine));
            System.out.print(exp.toString() + " = ");
            System.out.println(exp.getValue());
        }
    }
}
