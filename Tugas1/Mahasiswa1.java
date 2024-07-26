public class Mahasiswa1 {
    // Atribut
    private String NIM;
    private String prodi;
    private String nama;
    private String alamat;
    private String tempatLahir;
    private String tglLahir;

    // Konstruktor
    public Mahasiswa1(String NIM, String prodi, String nama, String alamat, String tempatLahir, String tglLahir) {
        this.NIM = NIM;
        this.prodi = prodi;
        this.nama = nama;
        this.alamat = alamat;
        this.tempatLahir = tempatLahir;
        this.tglLahir = tglLahir;
    }

    // Getter dan Setter
    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    // Metode untuk menampilkan detail Mahasiswa
    public void tampilkanDetail() {
        System.out.println("NIM: " + NIM);
        System.out.println("Program Studi: " + prodi);
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Tempat Lahir: " + tempatLahir);
        System.out.println("Tanggal Lahir: " + tglLahir);
    }

    // Metode main untuk pengujian
    public static void main(String[] args) {
        Mahasiswa1 mahasiswa = new Mahasiswa1("301230004", "Informatika", "Hilmi", "Jl. Pasirguna", "Bandung", "28-03-2005");
        mahasiswa.tampilkanDetail();
    }
}
