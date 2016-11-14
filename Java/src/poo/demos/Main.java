package poo.demos;

import poo.demos.containers.AbstractList;
import poo.demos.containers.DynamicArray;
import poo.demos.containers.SimplyLinkedList;
import poo.demos.expressions.newones.Expression;
import poo.demos.expressions.newones.ExpressionParser;
import poo.demos.expressions.newones.InvalidOperationException;
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
            try {
                ExpressionParser parser = new ExpressionParser(expressionLine);
                final Expression exp = parser.parseCommand();
                System.out.print(exp.toString() + " = ");
                System.out.println(exp.evaluate());
            } catch(InvalidOperationException ioe) {
                System.out.println("You typed an illegal operation (" + ioe.getMessage() + ")");
            }
        }
    }

    public static void main(String[] args) {
        // runOldExpressionParser()
        runNewExpressionParser();

        final AbstractList<String> list = new DynamicArray<>();
//        final AbstractList<String> list = new SimplyLinkedList<>();

        list.add("SLB, O MAIOR");
        final String str = list.get(0);
    }
}
