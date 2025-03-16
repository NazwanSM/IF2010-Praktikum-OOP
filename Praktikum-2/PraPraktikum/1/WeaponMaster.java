/**
 * WeaponMaster.java
 * Interface yang merepresentasikan kemampuan Hunter yang menguasai senjata.
 * Setiap WeaponMaster dapat melakukan serangan khusus dan menajamkan senjatanya.
 */
public interface WeaponMaster {
    /**
     * Melakukan serangan khusus pada monster
     * @param monster Monster yang akan diserang
     */
    void specialAttack(Monster monster);
    
    /**
     * Menajamkan senjata untuk meningkatkan attack power
     */
    void sharpenWeapon();
}