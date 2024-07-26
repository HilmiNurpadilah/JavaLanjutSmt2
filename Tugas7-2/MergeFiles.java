import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeFiles {

    public static void main(String[] args) {
        // Daftar file yang akan digabungkan
        String[] inputFiles = {"input1.txt", "input2.txt", "input3.txt"};
        // Nama file output
        String outputFile = "combined_output.txt";

        // Menggunakan try-with-resources untuk memastikan PrintWriter ditutup setelah digunakan
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            for (String inputFile : inputFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                    String line;
                    // Membaca setiap baris dari file input dan menulisnya ke file output
                    while ((line = reader.readLine()) != null) {
                        writer.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Error membaca file: " + inputFile);
                    e.printStackTrace();
                }
            }
            System.out.println("Gabungan file selesai.");
        } catch (IOException e) {
            System.out.println("Error menulis ke file output.");
            e.printStackTrace();
        }
    }
}
