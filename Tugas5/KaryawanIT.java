// Implementasi class untuk Departemen IT
class KaryawanIT extends Karyawan implements Departemen {
    public KaryawanIT(String nama, int id, double gaji) {
        super(nama, id, gaji);
    }

    @Override
    public void deskripsiPekerjaan() {
        System.out.println("Saya " + nama + " bekerja di departemen IT dan mengelola infrastruktur teknologi.");
    }

    @Override
    public void tugasDepartemen() {
        System.out.println("Tugas Departemen IT: Memastikan semua sistem IT berjalan dengan lancar.");
    }
}
