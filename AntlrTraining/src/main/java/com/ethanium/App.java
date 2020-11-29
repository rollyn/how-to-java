package com.ethanium;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class App {

    public static void main(String[] args) throws Exception {
//        String input = "12*(5-2)";
        String input = "(1+2)*(5-4)/2+(5+(4-3))";

        CharStream lineStream = CharStreams.fromString(input);

        Lexer lexer = new com.ethanium.CalculatorLexer(lineStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        com.ethanium.CalculatorParser parser = new com.ethanium.CalculatorParser(tokens);
        ParseTree tree = parser.start();

        // using listener
        CalculationListener calculator = new CalculationListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(calculator, tree);
        Double result = calculator.getResult();
        System.out.println(result);

        // using visitor
        CalculationVisitor visitor = new CalculationVisitor();
        Double result1 = visitor.visit(tree);

        System.out.println(result1);

    }
}
