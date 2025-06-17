/**
 * Zote.java
 */
public class Zote extends Boss implements SpecialBosses {
    private int minionCount;

    /**
     * Constructor untuk membuat boss zote
     * Hornet memiliki nama "Zote", maxHealth sebanyak 500 dan attackPower
     * sebanyak 5
     */
    public Zote(int minionCount) {
        super("Zote", 500, 5);
        this.minionCount = minionCount;
    }

    /**
     * Mengembalikan battlecry hornet
     * Mengembalikan string "You stand no chance!"
     * 
     * @return "You stand no chance!"
     */
    @Override
    public String battleCry() {
        return "You stand no chance!";
    }

    /**
     * Doubles amount of minions
     *
     */
    public void cloneMinion() {
        this.minionCount = this.minionCount * 2;
    }

    /**
     * Ketika melakukan special attack, program akan :
     * 1. Print "BY THE POWER OF ZOTE!"
     * 2. Mengurangi HP knight sebesar attack power dikali dengan minion count
     * 
     * @param knight target
     */
    @Override
    public void specialAttack(Knight knight) {
        System.out.print("BY THE POWER OF ZOTE!\n");
        knight.setHealth(knight.getHealth() - (getAttackPower() * minionCount));
    }

    /**
     * Representasi string dari Zote
     * 
     * @return String yang merepresentasikan Zote
     */
    @Override
    public String toString() {
        return String.format(super.toString() + "[Zote] %d minion", minionCount);
    }
}