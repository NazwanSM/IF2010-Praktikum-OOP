/**
 * KapalAdapter.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author [NIM] [Nama]
 */

public class KapalAdapter extends WargaSipil {
    private Kapal kapal;

    public KapalAdapter(Kapal kapal, String namaPemesan) {
        // Implementasi sesuai petunjuk soal
        super(namaPemesan);
        this.kapal = kapal;
        

    }

    public void urusAdministrasi() {
        // Implementasi sesuai petunjuk soal
        kapal.pesanTiket(namaPemesan);
        kapal.pilihKamar(namaPemesan);
    }

    public void cobaKabur() {
        // Implementasi sesuai petunjuk soal
        kapal.berangkatKePelabuhan(namaPemesan);
        kapal.verifikasiTiket(namaPemesan);
    }
    
    public void berhasilKabur() {
        // Implementasi sesuai petunjuk soal
        kapal.naikKapal(namaPemesan);
        kapal.berlayar();
    }

}
