import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keluar = false;

        while (!keluar) {
            tampilkanMenu();
            int pilihan = dapatkanPilihan(scanner);

            try {
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
            } catch (NegativeResultException e) {
                System.out.println(e.getMessage());
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

    private static void lakukanPenjumlahan(Scanner scanner) throws NegativeResultException {
        try {
            double angka1 = dapatkanAngka(scanner, "Masukkan angka pertama: ");
            double angka2 = dapatkanAngka(scanner, "Masukkan angka kedua: ");
            double hasil = angka1 + angka2;
            cekHasilNegatif(hasil);
            System.out.println("Hasil: " + hasil);
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka yang valid.");
            scanner.next(); // Bersihkan input yang tidak valid
        }
    }

    private static void lakukanPengurangan(Scanner scanner) throws NegativeResultException {
        try {
            double angka1 = dapatkanAngka(scanner, "Masukkan angka pertama: ");
            double angka2 = dapatkanAngka(scanner, "Masukkan angka kedua: ");
            double hasil = angka1 - angka2;
            cekHasilNegatif(hasil);
            System.out.println("Hasil: " + hasil);
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka yang valid.");
            scanner.next(); // Bersihkan input yang tidak valid
        }
    }

    private static void lakukanPerkalian(Scanner scanner) throws NegativeResultException {
        try {
            double angka1 = dapatkanAngka(scanner, "Masukkan angka pertama: ");
            double angka2 = dapatkanAngka(scanner, "Masukkan angka kedua: ");
            double hasil = angka1 * angka2;
            cekHasilNegatif(hasil);
            System.out.println("Hasil: " + hasil);
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka yang valid.");
            scanner.next(); // Bersihkan input yang tidak valid
        }
    }

    private static void lakukanPembagian(Scanner scanner) throws NegativeResultException {
        try {
            double angka1 = dapatkanAngka(scanner, "Masukkan angka pertama: ");
            double angka2 = dapatkanAngka(scanner, "Masukkan angka kedua: ");
            if (angka2 == 0) {
                throw new ArithmeticException("Error: Pembagian dengan nol tidak diperbolehkan.");
            }
            double hasil = angka1 / angka2;
            cekHasilNegatif(hasil);
            System.out.println("Hasil: " + hasil);
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka yang valid.");
            scanner.next(); // Bersihkan input yang tidak valid
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double dapatkanAngka(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    private static void cekHasilNegatif(double hasil) throws NegativeResultException {
        if (hasil < 0) {
            throw new NegativeResultException("Hasil bilangan adalah negatif.");
        }
    }
}
