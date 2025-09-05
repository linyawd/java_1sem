public class B0105 {
    public static void main(String[] args) {
        int N = 0, M = 0;

        if (args.length >= 2) {
            try {
                N = Integer.parseInt(args[0]);
                M = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Помилка: аргументи мають бути цілими числами.");
                return;
            }
        } else {
            System.out.println("Введіть два аргументи: N і M.");
            return;
        }

        for (int i = 0; i < N; i++) {
            int rnd = (int)(Math.random() * M);
            System.out.println(rnd);
        }
    }
}
