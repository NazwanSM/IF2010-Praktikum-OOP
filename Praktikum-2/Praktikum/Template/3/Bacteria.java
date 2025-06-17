/*
    Nama                    : 
    NIM                     : 
    Hari dan tanggal        : 
    Deskripsi Program       :
*/

/**
 * Bacteria.java
 * 
 * Kelas abstrak yang mengimplementasikan BacteriaBehavior.
 * Menyediakan atribut dasar: nama, currentPopulation,
 * growthRate, dan status resistensi (hasKanR).
 * 
 * Buat konstruktor dan implementasikan getter/setter sesuai deskripsi.
 * 
 */
public abstract class Bacteria implements BacteriaBehaviour {
    private String name;
    private int currentPopulation;
    private double growthRate; 
    private boolean hasKanR; 

    /**
     * Constructor untuk membuat Bacteria.
     * @param name Nama bakteri
     * @param currentPopulation Populasi bakteri saat ini
     * @param growthRate Laju reproduksi (0-1)
     * @param hasKanR true jika resisten terhadap Kanamycin (antibiotik), false jika tidak
     */
    public Bacteria(String name, int currentPopulation, double growthRate, boolean hasKanR) {}


    /**
     * Mendapat nama bakteri
     * 
     * @return nama bakteri
     */
    @Override
    public String getName() {}

    /**
     * Mendapat populasi bakteri saat ini
     * 
     * @return populasi bakteri saat ini
     */
    @Override
    public int getCurrentPopulation() {}

    /**
     * Mendapat laju pertumbuhan bakteri dalam bentuk desimal (double)
     * 
     * @return laju pertumbuhan bakteri
     */
    @Override
    public double getGrowthRate() {}

    /**
     * Mendapat status apakah bakteri memiliki gen resisten kanamycin
     * 
     * @return true jika memiliki gen resisten kanamycin, false jika tidak
     */
    @Override
    public boolean hasKanR() {}

    /**
     * Mengatur populasi bakteri saat ini
     * 
     * @param population populasi bakteri saat ini
     */
    @Override
    public void setCurrentPopulation(int population) {}

    /**
     * Mengatur laju pertumbuhan bakteri
     * 
     * @param growthRate laju pertumbuhan bakteri
     */
    @Override
    public void setGrowthRate(double growthRate) {}

    /**
     * Mengatur status resistensi bakteri terhadap kanamycin
     * 
     * @param hasKanR true jika resisten terhadap kanamycin, false jika tidak
     */
    @Override
    public void setKanR(boolean hasKanR) {}

    /**
     * Mereproduksi bakteri selama beberapa hari dengan efektivitas tertentu.
     * Populasi bakteri akan bertambah sesuai dengan laju pertumbuhan dan efektivitas reproduksi.
     * Contoh: Jika laju pertumbuhan = 0.5, currentPopulation = 100, days = 2, effectiveModifier = 0.8,
     * maka populasi akan bertambah sebanyak 100 + 100 * 2 * 0.5 * 0.8 = 180.
     * 
     * @param days jumlah hari reproduksi
     * @param effectiveModifier efektivitas reproduksi
     */
    @Override
    public void reproduce(int days, double effectiveModifier) {}

    /** 
     * Mengembalikan representasi detail informasi dari bakteri.
     */
    public String toString() {
        return name + " population: " + currentPopulation + " growth rate: " + growthRate + " Kanamycin resistant: " + hasKanR;
    }

}
