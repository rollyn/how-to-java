package com.ethanium;

import java.util.Stack;

public class CalculationListener extends com.ethanium.CalculatorBaseListener {

    private Stack<Double> stack = new Stack<>();

    @Override
    public void exitNumber(com.ethanium.CalculatorParser.NumberContext ctx) {
        Double number = Double.parseDouble(ctx.NUMBER().getText());
        this.stack.push(number);
    }

    @Override
    public void exitPower(com.ethanium.CalculatorParser.PowerContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(Math.pow(left, right));
    }

    @Override
    public void exitMultiplication(com.ethanium.CalculatorParser.MultiplicationContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left * right);
    }

    @Override
    public void exitDivision(com.ethanium.CalculatorParser.DivisionContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left / right);
    }

    @Override
    public void exitAddition(com.ethanium.CalculatorParser.AdditionContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left + right);
    }

    @Override
    public void exitSubtraction(com.ethanium.CalculatorParser.SubtractionContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left - right);
    }

    /**
     * The last value on the stack is the result of all
     * applied calculations.
     *
     * @return Double
     */
    public Double getResult() {
        return this.stack.pop();
    }
}