/**
 * PesawatAdapter.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author [NIM] [Nama]
 */

public class PesawatAdapter extends WargaSipil {
    private Pesawat pesawat;

    public PesawatAdapter(Pesawat pesawat, String namaPemesan) {
        // Implementasi sesuai petunjuk soal
        super(namaPemesan);
        this.pesawat = pesawat;

    }

    public void urusAdministrasi() {
        // Implementasi sesuai petunjuk soal
        pesawat.pesanTiket(namaPemesan);

    }


    public void cobaKabur() {
        // Implementasi sesuai petunjuk soal
        pesawat.berangkatKeBandara(namaPemesan);
        pesawat.checkIn(namaPemesan);
    }

    
    public void berhasilKabur() {
        // Implementasi sesuai petunjuk soal
        pesawat.naikPesawat(namaPemesan);
        pesawat.boarding();
    }

}
