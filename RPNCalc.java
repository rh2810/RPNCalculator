package edu.vccs.mla2911.gui.lab;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

public class RPNCalc {
    Deque<Double> stack = new LinkedList();

    public RPNCalc() {
    }

    public void enterNumber(double num) {
        this.stack.push(num);
    }

    public double add() {
        RPNCalc.Operands ops = this.getOps();
        double result = ops.op2 + ops.op1;
        this.stack.push(result);
        return result;
    }

    public double subtract() {
        RPNCalc.Operands ops = this.getOps();
        double result = ops.op2 - ops.op1;
        this.stack.push(result);
        return result;
    }

    public double multiply() {
        RPNCalc.Operands ops = this.getOps();
        double result = ops.op2 * ops.op1;
        this.stack.push(result);
        return result;
    }

    public double divide() {
        RPNCalc.Operands ops = this.getOps();
        double result = ops.op2 / ops.op1;
        this.stack.push(result);
        return result;
    }

    private RPNCalc.Operands getOps() {
        RPNCalc.Operands ops = new RPNCalc.Operands();
        ops.op1 = this.empty(this.stack) ? 0.0D : (Double)this.stack.pop();
        ops.op2 = this.empty(this.stack) ? 0.0D : (Double)this.stack.pop();
        return ops;
    }

    private boolean empty(Collection stack) {
        Object obj = null;

        try {
            obj = ((LinkedList)stack).get(0);
        } catch (IndexOutOfBoundsException var4) {
            ;
        }

        return obj == null;
    }

    private class Operands {
        double op1;
        double op2;

        private Operands() {
        }
    }
}
