/**
 * MonsterTarget.java
 * Interface yang merepresentasikan kemampuan Monster sebagai target serangan.
 * Monster dapat menyerang balik Hunter dan memiliki serangan area untuk party.
 */
public interface MonsterTarget {
    /**
     * Monster menyerang balik Hunter
     * @param hunter Hunter yang akan diserang
     */
    void counterAttack(Hunter hunter);
    
    /**
     * Monster melakukan serangan area pada party Hunter
     * @param hunters Array Hunter yang akan diserang
     */
    void areaAttack(Hunter[] hunters);
}