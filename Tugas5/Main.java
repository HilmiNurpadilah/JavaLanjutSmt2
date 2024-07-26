// Main class untuk menguji program
public class Main {
    public static void main(String[] args) {
        Karyawan karyawan1 = new KaryawanIT("Hilmi", 101, 7000000);
        Karyawan karyawan2 = new KaryawanHR("Ajat", 102, 6000000);

        karyawan1.deskripsiPekerjaan();
        ((Departemen) karyawan1).tugasDepartemen();

        karyawan2.deskripsiPekerjaan();
        ((Departemen) karyawan2).tugasDepartemen();
    }
}
