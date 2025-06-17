/*
    Nama                    : 
    NIM                     : 
    Hari dan tanggal        : 
    Deskripsi Program       :
*/

/**
 * PetriDishManager.java
 * 
 * Kelas untuk mengelola koloni bakteri dan simulasi inkubasi.
 */
public class PetriDishManager {
    private String cultureCondition;
    private boolean kanamycinPresence;
    private BacteriaBehaviour[] colony;
    private int colonySize;
    private static final int MAX_COLONY_SIZE = 4;

    /**
     * Konstruktor untuk inisialisasi petri dish dengan kondisi awal.
     */
    public PetriDishManager(String cultureCondition, boolean kanamycinPresence) {}

    /**
     * Set kondisi kultur.
     * @param condition "Rich", "Limited", atau "Toxic"
     */
    public void setCultureCondition(String condition) {}

    /**
     * Mendapat kondisi kultur.
     * @return kondisi kultur
     */
    public String getCultureCondition() {}

    /**
     * Set kehadiran Kanamycin.
     * @param present true jika Kanamycin ada, false jika tidak
     */
    public void setKanamycinPresence(boolean present) {}

    /**
     * Mendapat kehadiran Kanamycin.
     * @return true jika Kanamycin ada pada medium, false jika tidak
     */
    public boolean isKanamycinPresent() {}

    /**
     * Menambahkan bakteri ke koloni.
     * @param b bakteri yang akan ditambahkan
     * @return true jika berhasil, false jika koloni sudah penuh
     */
    public boolean addBacteria(BacteriaBehaviour b) {}

    /**
     * Mendapatkan array koloni.
     * @return array koloni
     */
    public BacteriaBehaviour[] getColony() {
    }

    /**
     * Mendapatkan ukuran koloni.
     * @return ukuran koloni
     */
    public int getColonySize() {}

    /**
     * Simulasi inkubasi selama 'days' hari.
     * effectiveModifier:
     *   - "Rich"    : 1.0
     *   - "Limited" : 0.8
     *   - "Toxic"   : 0.6
     * Jika kanamicyinPresent true dan bakteri tidak resisten (hasKanR == false), maka 
     * effectiveModifier dikalikan 0.7.
     * Hint: Gunakan method reproduce() dari interface BacteriaBehavior.
     * @param days jumlah hari inkubasi
     */
    public void incubate(int days) {}

    /**
     * Mendapatkan representasi detail informasi dari Cawan Petri.
     */
    public String toString() {
        String result = "Culture condition: " + cultureCondition + "\n";
        result += "Kanamycin presence: " + kanamycinPresence + "\n";
        result += "Colony size: " + colonySize + "\n";
        for (int i = 0; i < colonySize; i++) {
            result += colony[i].toString() + "\n";
        }
        return result;
    }

}
