public class PintuCommand implements ICommand {
    private Pintu pintu;
    private int state;

    /**
     * Constructor untuk membuat PintuCommand,
     * Terdapat 3 state untuk pintu:
     * - State 0: pintu tertutup
     * - State 1: pintu terbuka
     * 
     * State awal pintu adalah tertutup
     * 
     * @param pintu      Objek pintu yang digunakan
     */
    public PintuCommand(Pintu pintu) {}
    
    /**
     * Mengeksekusi aktivitas untuk pintu sesuai dengan state
     * - Bila state sekarang = 0, maka pintu akan dibuka
     */
    public void execute() {}

    /**
     * Mengembalikan pintu ke state semula
     * - Bila state sekarang selain 0, maka pintu akan ditutup
     */
    public void undo() {}
}
