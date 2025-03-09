/**
 * Toko.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author [NIM] [Nama]
 */


public class Toko {
    // Deklarasi atribut
    private CimolBojot[] cimolBojotArray;
    private int kas;
    private static final int MAX_CIMOL = 3;
    private int cimolCount;

    public Toko(int initialKas) {
        this.kas = initialKas;
        this.cimolBojotArray = new CimolBojot[MAX_CIMOL];
        this.cimolCount = 0;
    }

    public int getKas() {
        return kas;
    }

    public void addCimolBojot(CimolBojot cimolBojot) {
        if (cimolCount < MAX_CIMOL) {
            cimolBojotArray[cimolCount] = cimolBojot;
            cimolCount++;
        }
    }

    public int findCimolBojotIndexByName(String namaMenu) {
        for (int i = 0; i < cimolCount; i++) {
            if (cimolBojotArray[i].getNamaMenu().equals(namaMenu)) {
                return i;
            }
        }
        return -1;
    }

    public String sellCimolBojot(String namaMenu, int quantity) {
        int cimolIndex = findCimolBojotIndexByName(namaMenu);
        if (cimolIndex == -1) {
            return "Kita ga jual itu kaka";
        }

        CimolBojot cimolBojot = cimolBojotArray[cimolIndex];
        if (!cimolBojot.isHaveEnoughStok(quantity)) {
            return "Waduh stoknya ga cukup";
        }

        int totalHarga = cimolBojot.getHarga() * quantity;
        kas += totalHarga;
        cimolBojot.reduceStok(quantity);
        return "Berhasil menjual cimol " + cimolBojot.getNamaMenu() + " sebanyak " + quantity + "\nSekarang sisa: " + cimolBojot.getStok();

    }
}