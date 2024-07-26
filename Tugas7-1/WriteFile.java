import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    public static void main(String[] args) {
        // Nama file yang akan ditulis
        String fileName = "output.txt";

        // Menggunakan try-with-resources untuk memastikan PrintWriter ditutup setelah digunakan
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Hello, World!");
            writer.println("Ini adalah baris kedua.");
            // Anda bisa menambahkan lebih banyak baris sesuai kebutuhan
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
