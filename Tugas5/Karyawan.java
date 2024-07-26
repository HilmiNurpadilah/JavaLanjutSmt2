// Abstract class Karyawan
abstract class Karyawan {
    protected String nama;
    protected int id;
    protected double gaji;

    public Karyawan(String nama, int id, double gaji) {
        this.nama = nama;
        this.id = id;
        this.gaji = gaji;
    }

    public String getNama() {
        return nama;
    }

    public int getId() {
        return id;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    // Method abstract
    public abstract void deskripsiPekerjaan();
}
