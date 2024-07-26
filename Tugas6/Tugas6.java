import java.util.InputMismatchException;
import java.util.Scanner;

public class Tugas6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keluar = false;

        while (!keluar) {
            tampilkanMenu();
            int pilihan = dapatkanPilihan(scanner);

            switch (pilihan) {
                case 1:
                    lakukanPenjumlahan(scanner);
                    break;
                case 2:
                    lakukanPengurangan(scanner);
                    break;
                case 3:
                    lakukanPerkalian(scanner);
                    break;
                case 4:
                    lakukanPembagian(scanner);
                    break;
                case 5:
                    System.out.println("Keluar dari program...");
                    keluar = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }

        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.println("5. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static int dapatkanPilihan(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka.");
            scanner.next(); // Bersihkan input yang tidak valid
            return -1; // Kembalikan pilihan tidak valid
        }
    }

    private static void lakukanPenjumlahan(Scanner scanner) {
        try {
            System.out.print("Masukkan angka pertama: ");
            double angka1 = scanner.nextDouble();
            System.out.print("Masukkan angka kedua: ");
            double angka2 = scanner.nextDouble();
            System.out.println("Hasil: " + (angka1 + angka2));
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka yang valid.");
            scanner.next(); // Bersihkan input yang tidak valid
        }
    }

    private static void lakukanPengurangan(Scanner scanner) {
        try {
            System.out.print("Masukkan angka pertama: ");
            double angka1 = scanner.nextDouble();
            System.out.print("Masukkan angka kedua: ");
            double angka2 = scanner.nextDouble();
            System.out.println("Hasil: " + (angka1 - angka2));
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka yang valid.");
            scanner.next(); // Bersihkan input yang tidak valid
        }
    }

    private static void lakukanPerkalian(Scanner scanner) {
        try {
            System.out.print("Masukkan angka pertama: ");
            double angka1 = scanner.nextDouble();
            System.out.print("Masukkan angka kedua: ");
            double angka2 = scanner.nextDouble();
            System.out.println("Hasil: " + (angka1 * angka2));
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka yang valid.");
            scanner.next(); // Bersihkan input yang tidak valid
        }
    }

    private static void lakukanPembagian(Scanner scanner) {
        try {
            System.out.print("Masukkan angka pertama: ");
            double angka1 = scanner.nextDouble();
            System.out.print("Masukkan angka kedua: ");
            double angka2 = scanner.nextDouble();
            if (angka2 == 0) {
                System.out.println("Error: Pembagian dengan nol tidak diperbolehkan.");
            } else {
                System.out.println("Hasil: " + (angka1 / angka2));
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka yang valid.");
            scanner.next(); // Bersihkan input yang tidak valid
        }
    }
}
