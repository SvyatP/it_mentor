import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");

        try {
            String input = scanner.nextLine().trim();
            int result = calculate(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println(("Ошибка: " + e.getMessage()));
        } finally {
            scanner.close();
        }
    }

    private static int calculate(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат. Выражение должно иметь два числа и оператор между ними.");
        }

        int a = parseNumber(parts[0]);
        int b = parseNumber(parts[2]);
        String operator = parts[1];

        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new Exception("Деление на ноль.");
                }
                yield a / b;
            }
            default -> throw new Exception("Неверный оператор.");
        };

    }

    public static int parseNumber(String str) throws Exception {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new Exception("Неккоректный ввод числа");
        }

        if (num < 1 || num > 10) {
            throw new Exception("Нужно использовать числа от 1 до 10");
        }
        return num;
    }
}
