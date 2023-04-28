package calculator;

public class PlusOperator implements Operator {
    @Override
    public int calculate(Operand operand1, Operand operand2) {
        return operand1.value() + operand2.value();
    }
}