/**
 * Boss.java
 */

public abstract class Boss {
    private String name;
    private int currentHealth;
    private int maxHealth;
    private int attackPower;
    private static String difficulty = "Attuned";
    private static Boss[] pantheon;
    private static int pantheonSize;
    private static final int MAX_PANTHEON_SIZE = 4;

    /**
     * Constructor untuk membuat Boss baru
     * Ingat bahwa Boss akan memiliki current health maksimal ketika dibuat
     * Pantheon Size akan mulai dari 0 (kosong)
     * 
     * @param name        Nama Boss
     * @param maxHealth   Health points Boss
     * @param attackPower Kekuatan serangan dasar Boss
     */
    public Boss(String name, int maxHealth, int attackPower) {

    }

    /**
     * Mendapatkan nama Boss
     * 
     * @return nama Boss
     */
    public String getName() {

    }

    /**
     * Mendapatkan health Boss
     * 
     * @return health Boss
     */
    public int getHealth() {

    }

    /**
     * Mengatur health boss
     * HINT : PERHATIKAN BATASAN SOAL!
     * @param health nilai health baru
     */
    public void setHealth(int health) {

    }

    /**
     * Mendapatkan attack power Boss
     * 
     * @return attack power Boss
     */
    public int getAttackPower() {

    }

    /**
     * Mengatur attack power boss
     * 
     * @param health nilai attack power baru
     */
    public void setAttackPower(int attackPower) {

    }

    /**
     * Mendapatkan kesulitan untuk pantheon
     * 
     * @return difficulty pantheon
     */
    public static String getDifficulty() {

    }

    /**
     * Mengatur kesulitan pantheon
     * Pantheon hanya memiliki 3 buah difficulty : "Attuned", "Ascended", dan
     * "Radiant"
     * Apabila difficulty yang diberikan tidak sesuai, maka difficulty tidak akan
     * diatur.
     * 
     * Gunakan method string1.equals(string2) untuk memastikan nilai dua buah string
     * sama
     * 
     * @param difficulty kesulitan pantheon
     */
    public static void setDifficulty(String difficulty) {

    }

    /**
     * Menambahkan Boss ke pantheon
     * 
     * @param boss Boss yang akan ditambahkan
     * @return true jika berhasil ditambahkan, false jika party penuh
     */
    public static boolean addBossToPantheon(Boss boss) {

    }

    /**
     * Mengembalikan pantheon
     * 
     * @return pantheon
     */
    public static Boss[] getPantheon() {

    }

    /**
     * Mengembalikan pantheonSize
     * 
     * @return pantheonSize
     */
    public static int getPantheonSize() {

    }

    /**
     * Fungsi ini menjalankan attack setiap boss dalam pantheon
     * 1. print "== PANTHEON STARTS =="
     * 2. ketika fungsi ini dijalankan, fungsi akan menjalankan special attack untuk
     * setiap pantheon. Tiap difficulty memiliki modifier berbeda :
     * - Apabila difficulty pantheon tersebut "Attuned" maka boss akan menjalankan
     * special attack tanpa modifier apapun
     * - Apabila difficulty pantheon tersebut "Ascended" maka attack power boss akan
     * ditambahkan 20 sebelum menjalankan special attack
     * - Apabila difficulty pantheon tersebut "Radiant" maka attack power boss akan
     * ditambahkan 30 sebelum menjalankan special attack
     * 3. apabila HP knight di atas nol, print "The Knight Survives!"
     * 4. apabila HP knight nol, print "The Knight Dies!"
     * 
     * @param knight target
     */
    public static void playPantheon(Knight knight) {

    }

    /**
     * Representasi string dari Boss
     * 
     * @return String yang merepresentasikan Boss
     */
    @Override
    public String toString() {
        return String.format("%s [Health : %d, Attack : %d]", name, currentHealth, attackPower);
    }
}