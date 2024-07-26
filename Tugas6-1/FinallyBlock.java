public class FinallyBlock {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Tidak bisa dibagi dengan nol.");
        } finally {
            System.out.println("Operasi selesai. Terjadi suatu kesalahan, coba ulangi lagi.");
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
