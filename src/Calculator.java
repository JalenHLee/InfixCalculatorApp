import java.util.Scanner;

public class Calculator {

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return -1;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static String convertToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        BCLinkStack<Character> operatorStack = new BCLinkStack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c);
                while (i + 1 < infixExpression.length() && Character.isDigit(infixExpression.charAt(i + 1))) {
                    postfix.append(infixExpression.charAt(++i));
                }
                postfix.append(' ');
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
                    postfix.append(operatorStack.pop()).append(' ');
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(' ');
        }

        return postfix.toString().trim();
    }

    private static String evaluatePostfix(String postfixExpression) {
        BCLinkStack<Integer> stack = new BCLinkStack<>();
        String[] tokens = postfixExpression.split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) { // Numeric token
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token.charAt(0))) { // Operator token
                int right = stack.pop();
                int left = stack.isEmpty() ? 0 : stack.pop(); // For unary minus handling

                switch (token.charAt(0)) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        if (right == 0) return "undef";
                        stack.push(left / right);
                        break;
                    case '^':
                        int result = 1;
                        for (int i = 0; i < right; i++) result *= left;
                        stack.push(result);
                        break;
                }
            }
        }

        return stack.isEmpty() ? "undef" : stack.pop().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputExpression = scanner.nextLine();
        String postfixExpression = convertToPostfix(inputExpression);
        String result = evaluatePostfix(postfixExpression);
        System.out.println(result);
    }
}
