public class Mahasiswa {
    // Atribut
    private String NIM;
    private String prodi;
    private String nama;
    private String alamat;
    private String tempatLahir;
    private String tglLahir;
    private double IPK;

    // Konstruktor default
    public Mahasiswa() {
        this.NIM = "";
        this.prodi = "";
        this.nama = "";
        this.alamat = "";
        this.tempatLahir = "";
        this.tglLahir = "";
        this.IPK = 0.0;
    }

    // Konstruktor dengan parameter NIM dan Nama
    public Mahasiswa(String NIM, String nama) {
        this.NIM = NIM;
        this.nama = nama;
    }

    // Konstruktor dengan parameter NIM, Nama, dan IPK
    public Mahasiswa(String NIM, String nama, double IPK) {
        this.NIM = NIM;
        this.nama = nama;
        this.IPK = IPK;
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

    public double getIPK() {
        return IPK;
    }

    public void setIPK(double IPK) {
        this.IPK = IPK;
    }

    // Metode untuk menampilkan detail Mahasiswa
    public void tampilkanDetail() {
        System.out.println("NIM: " + NIM);
        System.out.println("Program Studi: " + prodi);
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Tempat Lahir: " + tempatLahir);
        System.out.println("Tanggal Lahir: " + tglLahir);
        System.out.println("IPK: " + IPK);
    }

    // Metode main untuk pengujian
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa();
        Mahasiswa mhs2 = new Mahasiswa("123456789", "Budi");
        Mahasiswa mhs3 = new Mahasiswa("987654321", "Siti", 3.75);

        mhs1.tampilkanDetail();
        System.out.println();
        mhs2.tampilkanDetail();
        System.out.println();
        mhs3.tampilkanDetail();
    }
}
