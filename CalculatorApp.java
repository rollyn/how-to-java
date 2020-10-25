import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Value: ");
        int firstNum = scanner.nextInt();
        System.out.println("Enter Second Value: ");
        int secondNum = scanner.nextInt();
        System.out.println("Enter Operation (+, -, /, *: ");
        String operator = scanner.next();

        int result = 0;
        switch (operator) {
            case "+":
                result = addOperation(firstNum, secondNum);
                break;
            case "-":
                result = subtractOperation(firstNum, secondNum);
                break;
            case "/":
                result = dvideOperation(firstNum, secondNum);
                break;
            case "*":
                result = multiplyOperation(firstNum, secondNum);
                break;
            default:
                System.out.println("Unknown operation");
        }
        System.out.println("Result is: "+result);
    }

    private static int multiplyOperation(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    private static int dvideOperation(int firstNum, int secondNum) {
        return firstNum / secondNum;
    }

    private static int subtractOperation(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    private static int addOperation(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }


}
