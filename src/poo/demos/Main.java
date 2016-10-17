package poo.demos;

import poo.demos.expressions.newones.Expression;
import poo.demos.expressions.newones.ExpressionParser;
import poo.demos.expressions.old.ExpressionNode;
import poo.demos.expressions.old.ExpressionNodeParser;

import java.util.Scanner;

public class Main {

    private static void runOldExpressionParser() {
        final Scanner kbd = new Scanner(System.in);
        String expressionLine = "";
        while(!(expressionLine = kbd.nextLine()).isEmpty()) {
            ExpressionNodeParser parser = new ExpressionNodeParser(expressionLine);
            final ExpressionNode exp = parser.parseCommand();
            System.out.print(exp.toString() + " = ");
            System.out.println(exp.getValue());
        }
    }

    private static void runNewExpressionParser() {
        final Scanner kbd = new Scanner(System.in);
        String expressionLine = "";
        while(!(expressionLine = kbd.nextLine()).isEmpty()) {
            ExpressionParser parser = new ExpressionParser(expressionLine);
            final Expression exp = parser.parseCommand();
            System.out.print(exp.toString() + " = ");
            System.out.println(exp.evaluate());
        }
    }

    public static void main(String[] args) {
        // runOldExpressionParser()
        runNewExpressionParser();
    }
}
