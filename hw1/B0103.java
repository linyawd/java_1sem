public class B0103 {
    public static void main(String[] args) {
        try {
            int product = 1;
            for (String arg : args) {
                product *= Integer.parseInt(arg);
            }
            System.out.println("Добуток: " + product);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: аргументи мають бути цілими числами.");
        }
    }
}
