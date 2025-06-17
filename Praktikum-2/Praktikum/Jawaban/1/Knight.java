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
     * 
     * @param maxSoul     Jumlah soul maksimum
     * @param maxHealth   Jumlah health maksimum
     * @param attackPower Kekuatan serangan dasar Knight
     */
    public Knight(int maxHealth, int attackPower) {
        this.currentSoul = maxSoul;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.attackPower = attackPower;
    }

    /**
     * Mendapatkan jumlah soul knight
     * 
     * @return jumlah soul
     */
    public int getSoul() {
        return currentSoul;
    }

    /**
     * Menambahkan jumlah soul sebanyak 30 poin
     * 
     */
    public void focus() {
        currentSoul += 30;
        if (currentSoul > maxSoul){
            this.currentSoul = maxSoul;
        }
    }

    /**
     * Mendapatkan jumlah health knight
     * 
     * @return jumlah health
     */
    public int getHealth() {
        return currentHealth;
    }

    /**
     * Mengatur health knight
     * 
     * @param health nilai health baru
     */
    public void setHealth(int health) {
        if (health <= 0){
            this.currentHealth = 0;
        }
        else if (health > maxHealth){
            this.currentHealth = maxHealth;
        }
        else {
            this.currentHealth = health;
        }
    }

    /**
     * Menambahkan jumlah health sebanyak 30 poin apabila soul mencukupi
     * Akan mengurangi soul sebanyak 30 dan menambahkan health sebanyak 30
     * mengembalikan true apabila healing berhasil dilakukan
     * mengembalikan false apabila soul tidak mencukupi
     * 
     * @return true atau false, sesuai keadaan
     */
    public boolean heal() {
        if (currentSoul >= 30) {
            currentSoul -= 30;
            if (currentHealth + 30 > maxHealth) {
                this.currentHealth = maxHealth;
            } else {
                this.currentHealth += 30;
            }
            return true;
        } else {
            return false;
        }
    }


    /**
     * Mendapatkan jumlah attack power knight
     * 
     * @return jumlah attack power
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Menyerang boss
     * 
     * @param boss target
     */
    public void attackBoss(Boss boss) {
        boss.setHealth(boss.getHealth() - attackPower);
    }

    /**
     * Fungsi ini menyerang semua boss dalam pantheon
     * 1. print "== ATTACKING PANTHEON =="
     * 2. Menyerang semua boss dalam pantheon
     * 3. print boss tersebut setelah boss tersebut diserang
     * 3. print "== PANTHEON ENDS =="
     * 
     * @param knight target
     */
    public void attackPantheon() {
        System.out.println("== ATTACKING PANTHEON ==");
        Boss[] pantheon = Boss.getPantheon();
        int pantheonSize = Boss.getPantheonSize();
        for (int i = 0; i < pantheonSize; i++) {
            Boss boss = pantheon[i];
            if (boss != null) {
                attackBoss(boss);
                System.out.println(boss);
            }
        }
        System.out.println("== PANTHEON ENDS ==");
    }

    /**
     * Representasi string dari Boss
     * 
     * @return String yang merepresentasikan Boss
     */
    @Override
    public String toString() {
        return String.format("Knight [Soul: %d, Health : %d, Attack : %d]", currentSoul, currentHealth, attackPower);
    }
}