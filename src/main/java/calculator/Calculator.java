package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double d_number1, d_number2;
        int i_number1;

        // Only enter the application once the user has pressed Enter key on the terminal.
        System.out.println("Press Enter key to start the applicationnn\n");
        scanner.nextLine();

        do {
            System.out.println("Choose the operations from below:");
            System.out.print(
                "1.Factorial\n" +
                "2.Square Root\n" +
                "3.Power\n" +
                "4.Natural Logarithm\n" +
                "5.Exit\n"
            );

            int ch;
            
            ch = scanner.nextInt();
            if(ch==5){
                System.out.println("THANK YOU!!...Exiting");
                scanner.close();
                return;
            }

    
            switch (ch) {
                case 1:
                    // find factorial
                    i_number1 = -1;

                    // Keep executing do-while loop till user enters a non-negative integer
                    while (i_number1 < 0) {
                        try {
                            System.out.print("Enter a number : ");
                            i_number1 = scanner.nextInt();

                            if (i_number1 < 0)
                                System.out.println("Invalid input....Please try again!!");
                            else
                                System.out.println("Factorial of " + i_number1 + " is: " + calculator.factorial(i_number1) + "\n");
                        }
                        // To handle cases where user enters non-numeric input
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input....Please try again!!");
                        }
                        scanner.nextLine(); // Clear the buffer to receive new input
                    }

                    break;

                case 2:
                    // find square root
                    d_number1 = -1;

                    // Keep executing do-while loop till user enters a non-negative number
                    while (d_number1 < 0) {
                        try {
                            System.out.print("Enter a number :  ");
                            d_number1 = scanner.nextDouble();

                            if (d_number1 < 0)
                                System.out.println("Invalid input....Please try again!!");
                            else
                                System.out.println("Square Root of " + d_number1 + " is: " + calculator.squareRoot(d_number1) + "\n");
                        }
                        // To handle cases where user enters non-numeric input
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input....Please try again!!");
                        }
                        scanner.nextLine(); // Clear the buffer to receive new input
                    }

                    break;

                case 3:
                    // find power
                    d_number1 = Double.POSITIVE_INFINITY; d_number2 = Double.POSITIVE_INFINITY;
                    while (d_number1 == Double.POSITIVE_INFINITY) {
                        try {
                            System.out.print("Enter the first number: ");
                            d_number1 = scanner.nextDouble();
                        }
                        // To handle cases where user enters non-numeric input
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input....Please try again!!");
                        }
                        scanner.nextLine(); // Clear the buffer to receive new input
                    }
                    while (d_number2 == Double.POSITIVE_INFINITY) {
                        try {
                            System.out.print("Enter the second number: ");
                            d_number2 = scanner.nextDouble();
                        }
                        // To handle cases where user enters non-numeric input
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input....Please try again!!");
                        }
                        scanner.nextLine(); // Clear the buffer to receive new input
                    }

                    System.out.println(d_number1 + " raised to " + d_number2 + " is: " + calculator.power(d_number1, d_number2));
                    System.out.println("\n");
                    break;

                case 4:
                    // find natural log
                    d_number1 = 0;

                    // Keep executing do-while loop till user enters a positive number
                    while (d_number1 <= 0) {
                        try {
                            System.out.print("Enter a positive number: ");
                            d_number1 = scanner.nextDouble();

                            if (d_number1 <= 0)
                                System.out.println("Invalid input....Please try again!!");
                            else
                                System.out.println("Natural Logarithm of " + d_number1 + " is: " + calculator.naturalLog(d_number1) + "\n");
                        }
                        // To handle cases where user enters non-numeric input
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input....Please try again!!");
                        }
                        scanner.nextLine(); // Clear the buffer to receive new input
                    }

                    break;

                default:
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
            }
        } while (true);
    }

    public int factorial(int number1) {
        logger.info("[Factorial of :]" + number1);

        int result = 1;
        for(int i = 1; i <= number1; i++)
            result *= i;

        logger.info("[Factorial is: ]" + result);
        return result;
    }

    public double squareRoot(double number1) {
        logger.info("[Square Root] " + number1);
        double result = Math.sqrt(number1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }

    public double power(double number1, double number2) {
        logger.info("[POWER - " + number1 + " RAISED TO] " + number2);
        double result = Math.pow(number1,number2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double number1) {
        logger.info("[NATURAL LOG] - " + number1);
        double result = 0;

        try {
            if (number1 < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else
                result = Math.log(number1);
        }
        catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
}
