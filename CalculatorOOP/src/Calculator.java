public class Calculator {
    double number1;
    double number2;

    public Calculator(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public double addition() {
        return number1 + number2;
    }

    public double subtraction() {
        return number1 - number2;
    }

    public double multiplication() {
        return number1 * number2;
    }

    public double division() {
        return number1 / number2;
    }
}
