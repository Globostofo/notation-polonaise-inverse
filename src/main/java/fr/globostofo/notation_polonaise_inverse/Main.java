package fr.globostofo.notation_polonaise_inverse;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static void manageInput(String input, Stack<Double> stack) {
        try {
            stack.push(Double.parseDouble(input));
        } catch (NumberFormatException e) {
            double v1 = stack.pop(), v2 = stack.pop();
            switch (input.charAt(0)) {
                case '+' -> stack.push(v1 + v2);
                case '-' -> stack.push(v2 - v1);
                case '*' -> stack.push(v1 * v2);
                case '/' -> stack.push(v2 / v1);
                default -> throw new ArithmeticException("Invalid input");
            }
        }
    }

    public static double calculNPI() {
        Scanner in = new Scanner(System.in);
        Stack<Double> stack = new Stack<>();
        String input = in.nextLine();

        do {
            manageInput(input, stack);
            input = in.nextLine();
        } while (input.length() != 0);

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculNPI());
    }

}
