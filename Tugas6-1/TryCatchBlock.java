public class TryCatchBlock {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Tidak bisa dibagi dengan nol.");
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
