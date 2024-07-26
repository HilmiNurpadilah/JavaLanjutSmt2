// Implementasi class untuk Departemen HR
class KaryawanHR extends Karyawan implements Departemen {
    public KaryawanHR(String nama, int id, double gaji) {
        super(nama, id, gaji);
    }

    @Override
    public void deskripsiPekerjaan() {
        System.out.println("Saya " + nama + " bekerja di departemen HR dan mengelola sumber daya manusia.");
    }

    @Override
    public void tugasDepartemen() {
        System.out.println("Tugas Departemen HR: Mengelola rekrutmen, pelatihan, dan kesejahteraan karyawan.");
    }
}
