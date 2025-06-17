/**
 * Knight.java
 */

public class Knight {
    private int currentSoul;
    private final int maxSoul = 100;
    private int currentHealth;
    private int maxHealth;
    private int attackPower;

    /**
     * Constructor untuk membuat Knight baru
     * Ingat bahwa Knight akan memiliki current health maksimal ketika dibuat
     * Ingat bahwa Knight akan memiliki current soul maksimal ketika dibuat
     * 
     * @param maxHealth   Jumlah health maksimum
     * @param attackPower Kekuatan serangan dasar Knight
     */
    public Knight(int maxHealth, int attackPower) {

    }

    /**
     * Mendapatkan jumlah soul knight
     * 
     * @return jumlah soul
     */
    public int getSoul() {

    }

    /**
     * Menambahkan jumlah soul sebanyak 30 poin
     * HINT : PERHATIKAN BATASAN SOAL, ADA MAX SOUL!
     */
    public void focus() {

    }

    /**
     * Mendapatkan jumlah health knight
     * 
     * @return jumlah health
     */
    public int getHealth() {

    }

    /**
     * Mengatur health knight
     * HINT : PERHATIKAN BATASAN SOAL!
     * @param health nilai health baru
     */
    public void setHealth(int health) {

    }

    /**
     * Menambahkan jumlah health sebanyak 30 poin apabila soul mencukupi
     * Akan mengurangi soul sebanyak 30 dan menambahkan health sebanyak 30
     * mengembalikan true apabila healing berhasil dilakukan
     * mengembalikan false apabila soul tidak mencukupi
     * HINT : PERHATIKAN BATASAN SOAL!
     * @return true atau false, sesuai keadaan
     */
    public boolean heal() {

    }

    /**
     * Mendapatkan jumlah attack power knight
     * 
     * @return jumlah attack power
     */
    public int getAttackPower() {

    }

    /**
     * Menyerang boss
     * Mengurangi HP boss dengan attack power knight
     * 
     * @param boss target
     */
    public void attackBoss(Boss boss) {

    }

    /**
     * Fungsi ini menyerang semua boss dalam pantheon
     * 1. print "== ATTACKING PANTHEON =="
     * 2. Menyerang semua boss dalam pantheon
     * 3. print boss tersebut setelah boss tersebut diserang
     * (gunakan representasi string boss)
     * 3. print "== PANTHEON ENDS =="
     * 
     */
    public void attackPantheon() {

    }

    /**
     * Representasi string dari Knight
     * 
     * @return String yang merepresentasikan Knight
     */
    @Override
    public String toString() {
        return String.format("Knight [Soul: %d, Health : %d, Attack : %d]", currentSoul, currentHealth, attackPower);
    }
}