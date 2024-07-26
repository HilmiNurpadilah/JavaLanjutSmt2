import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBarangApp extends JFrame {
    // Kelas Barang sebagai inner class
    static class Barang {
        String kodebarang;
        String kategori;
        String jenis;
        String merk;
        String warna;
        String ukuran;
        String harga;
        String thnProduksi;
        String tglKadaluarsa;

        public Barang(String kodebarang, String kategori, String jenis, String merk, String warna,
                      String ukuran, String harga, String thnProduksi, String tglKadaluarsa) {
            this.kodebarang = kodebarang;
            this.kategori = kategori;
            this.jenis = jenis;
            this.merk = merk;
            this.warna = warna;
            this.ukuran = ukuran;
            this.harga = harga;
            this.thnProduksi = thnProduksi;
            this.tglKadaluarsa = tglKadaluarsa;
        }

        @Override
        public String toString() {
            return kodebarang + "," + kategori + "," + jenis + "," + merk + "," + warna + "," + ukuran + "," +
                   harga + "," + thnProduksi + "," + tglKadaluarsa;
        }
    }

    // Variabel untuk GUI
    private List<Barang> dataBarangList;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField kodebarangField, kategoriField, jenisField, merkField, warnaField, ukuranField, hargaField, thnProduksiField, tglKadaluarsaField;
    private JButton addButton, updateButton, deleteButton, saveButton, viewButton;

    public DataBarangApp() {
        dataBarangList = new ArrayList<>();

        setTitle("Data Barang");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeUI();
        loadFromCSV();

        // Simpan data saat aplikasi ditutup
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveToCSV();
                e.getWindow().dispose();
            }
        });
    }

    private void initializeUI() {
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        add(inputPanel, BorderLayout.NORTH);

        inputPanel.add(new JLabel("Kode Barang:"));
        kodebarangField = new JTextField();
        inputPanel.add(kodebarangField);

        inputPanel.add(new JLabel("Kategori:"));
        kategoriField = new JTextField();
        inputPanel.add(kategoriField);

        inputPanel.add(new JLabel("Jenis:"));
        jenisField = new JTextField();
        inputPanel.add(jenisField);

        inputPanel.add(new JLabel("Merk:"));
        merkField = new JTextField();
        inputPanel.add(merkField);

        inputPanel.add(new JLabel("Warna:"));
        warnaField = new JTextField();
        inputPanel.add(warnaField);

        inputPanel.add(new JLabel("Ukuran:"));
        ukuranField = new JTextField();
        inputPanel.add(ukuranField);

        inputPanel.add(new JLabel("Harga:"));
        hargaField = new JTextField();
        inputPanel.add(hargaField);

        inputPanel.add(new JLabel("Tahun Produksi:"));
        thnProduksiField = new JTextField();
        inputPanel.add(thnProduksiField);

        inputPanel.add(new JLabel("Tanggal Kadaluarsa:"));
        tglKadaluarsaField = new JTextField();
        inputPanel.add(tglKadaluarsaField);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.CENTER);

        addButton = new JButton("Tambah Barang");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBarang();
            }
        });
        buttonPanel.add(addButton);

        updateButton = new JButton("Update Barang");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBarang();
            }
        });
        buttonPanel.add(updateButton);

        deleteButton = new JButton("Hapus Barang");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBarang();
            }
        });
        buttonPanel.add(deleteButton);

        saveButton = new JButton("Simpan ke CSV");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToCSV();
            }
        });
        buttonPanel.add(saveButton);

        viewButton = new JButton("Lihat Data");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewData();
            }
        });
        buttonPanel.add(viewButton);

        tableModel = new DefaultTableModel(new String[]{"Kode Barang", "Kategori", "Jenis", "Merk", "Warna", "Ukuran", "Harga", "Tahun Produksi", "Tanggal Kadaluarsa"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.SOUTH);

        // Tambahkan MouseListener untuk tabel
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Barang barang = dataBarangList.get(selectedRow);
                    kodebarangField.setText(barang.kodebarang);
                    kategoriField.setText(barang.kategori);
                    jenisField.setText(barang.jenis);
                    merkField.setText(barang.merk);
                    warnaField.setText(barang.warna);
                    ukuranField.setText(barang.ukuran);
                    hargaField.setText(barang.harga);
                    thnProduksiField.setText(barang.thnProduksi);
                    tglKadaluarsaField.setText(barang.tglKadaluarsa);
                }
            }
        });
    }

    private void addBarang() {
        String kodebarang = kodebarangField.getText();
        String kategori = kategoriField.getText();
        String jenis = jenisField.getText();
        String merk = merkField.getText();
        String warna = warnaField.getText();
        String ukuran = ukuranField.getText();
        String harga = hargaField.getText();
        String thnProduksi = thnProduksiField.getText();
        String tglKadaluarsa = tglKadaluarsaField.getText();
    
        if (kodebarang.isEmpty() || kategori.isEmpty() || jenis.isEmpty() || merk.isEmpty() || warna.isEmpty() ||
            ukuran.isEmpty() || harga.isEmpty() || thnProduksi.isEmpty() || tglKadaluarsa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lengkapi semua kolom yang kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        Barang barang = new Barang(kodebarang, kategori, jenis, merk, warna, ukuran, harga, thnProduksi, tglKadaluarsa);
        dataBarangList.add(barang);
        tableModel.addRow(new Object[]{kodebarang, kategori, jenis, merk, warna, ukuran, harga, thnProduksi, tglKadaluarsa});
    
        clearInputFields();
    }
    
    private void updateBarang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Pilih barang yang ingin diupdate", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        String kodebarang = kodebarangField.getText();
        String kategori = kategoriField.getText();
        String jenis = jenisField.getText();
        String merk = merkField.getText();
        String warna = warnaField.getText();
        String ukuran = ukuranField.getText();
        String harga = hargaField.getText();
        String thnProduksi = thnProduksiField.getText();
        String tglKadaluarsa = tglKadaluarsaField.getText();
    
        if (kodebarang.isEmpty() || kategori.isEmpty() || jenis.isEmpty() || merk.isEmpty() || warna.isEmpty() ||
            ukuran.isEmpty() || harga.isEmpty() || thnProduksi.isEmpty() || tglKadaluarsa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lengkapi semua kolom yang kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        Barang barang = dataBarangList.get(selectedRow);
        barang.kodebarang = kodebarang;
        barang.kategori = kategori;
        barang.jenis = jenis;
        barang.merk = merk;
        barang.warna = warna;
        barang.ukuran = ukuran;
        barang.harga = harga;
        barang.thnProduksi = thnProduksi;
        barang.tglKadaluarsa = tglKadaluarsa;
    
        tableModel.setValueAt(kodebarang, selectedRow, 0);
        tableModel.setValueAt(kategori, selectedRow, 1);
        tableModel.setValueAt(jenis, selectedRow, 2);
        tableModel.setValueAt(merk, selectedRow, 3);
        tableModel.setValueAt(warna, selectedRow, 4);
        tableModel.setValueAt(ukuran, selectedRow, 5);
        tableModel.setValueAt(harga, selectedRow, 6);
        tableModel.setValueAt(thnProduksi, selectedRow, 7);
        tableModel.setValueAt(tglKadaluarsa, selectedRow, 8);
    
        clearInputFields();
    }    

    private void deleteBarang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            dataBarangList.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih barang yang ingin dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void saveToCSV() {
        try (FileWriter writer = new FileWriter("data_barang.csv")) {
            writer.write("Kode Barang,Kategori,Jenis,Merk,Warna,Ukuran,Harga,Tahun Produksi,Tanggal Kadaluarsa\n");
            for (Barang barang : dataBarangList) {
                writer.write(barang.toString() + "\n");
            }
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke data_barang.csv");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file: " + e.getMessage());
        }
    }

    private void loadFromCSV() {
        File file = new File("data_barang.csv");
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 9) {
                    Barang barang = new Barang(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
                    dataBarangList.add(barang);
                    tableModel.addRow(new Object[]{barang.kodebarang, barang.kategori, barang.jenis, barang.merk, barang.warna, barang.ukuran, barang.harga, barang.thnProduksi, barang.tglKadaluarsa});
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }

    private void viewData() {
        tableModel.setRowCount(0);
        for (Barang barang : dataBarangList) {
            tableModel.addRow(new Object[]{barang.kodebarang, barang.kategori, barang.jenis, barang.merk, barang.warna, barang.ukuran, barang.harga, barang.thnProduksi, barang.tglKadaluarsa});
        }
    }

    private void clearInputFields() {
        kodebarangField.setText("");
        kategoriField.setText("");
        jenisField.setText("");
        merkField.setText("");
        warnaField.setText("");
        ukuranField.setText("");
        hargaField.setText("");
        thnProduksiField.setText("");
        tglKadaluarsaField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataBarangApp().setVisible(true));
    }
}
