import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.err.println("----- Welcome to Manji's Calculator -----");
        System.out.print("1 - Addition\n" +
                "2 - Subtraction\n" +
                "3 - Multiplication\n" +
                "4 - Division\n" +
                "Which mathematical operation would you like to perform? ");

        String choice = input.next();

        try {

            System.out.print("Please enter the number 1: ");
            double number1 = Double.parseDouble(input.next());

            System.out.print("Please enter the number 2: ");
            double number2 = Double.parseDouble(input.next());

            Calculator calculator = new Calculator(number1, number2);

            switch (choice) {

                case "1":
                    System.out.println(number1 + " + " + number2 + " = " + calculator.addition());
                    break;

                case "2":
                    System.out.println(number1 + " - " + number2 + " = " + calculator.subtraction());
                    break;

                case "3":
                    System.out.println(number1 + " * " + number2 + " = " + calculator.multiplication());
                    break;

                case "4":
                    if (number2 == 0) {
                        System.out.println("Error: Division by zero!");
                        break;
                    }
                    System.out.println(number1 + " / " + number2 + " = " + calculator.division());
                    break;

                default:
                    System.out.println("Please select a valid mathematical operation!");
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter only numbers!");
        }

        input.close();
    }
}