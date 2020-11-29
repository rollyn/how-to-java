package com.ethanium;

public class CalculationVisitor extends com.ethanium.CalculatorBaseVisitor<Double> {

    @Override
    public Double visitNumber(com.ethanium.CalculatorParser.NumberContext ctx) {
        return Double.parseDouble(ctx.NUMBER().getText());
    }

    @Override
    public Double visitParentheses(com.ethanium.CalculatorParser.ParenthesesContext ctx) {
        return this.visit(ctx.inner);
    }

    @Override
    public Double visitPower(com.ethanium.CalculatorParser.PowerContext ctx) {
        return Math.pow(this.visit(ctx.left), this.visit(ctx.right));
    }

    @Override
    public Double visitMultiplication(com.ethanium.CalculatorParser.MultiplicationContext ctx) {
        return this.visit(ctx.left) * this.visit(ctx.right);
    }

    @Override
    public Double visitDivision(com.ethanium.CalculatorParser.DivisionContext ctx) {
        return this.visit(ctx.left) / this.visit(ctx.right);
    }

    @Override
    public Double visitAddition(com.ethanium.CalculatorParser.AdditionContext ctx) {
        return this.visit(ctx.left) + this.visit(ctx.right);
    }

    @Override
    public Double visitSubtraction(com.ethanium.CalculatorParser.SubtractionContext ctx) {
        return this.visit(ctx.left) - this.visit(ctx.right);
    }
}