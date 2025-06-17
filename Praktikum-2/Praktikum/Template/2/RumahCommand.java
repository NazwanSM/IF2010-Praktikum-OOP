public class RumahCommand implements ICommand {
    private Rumah rumah;
    private int state;

    /**
     * Constructor untuk membuat RumahCommand,
     * Terdapat 3 state untuk rumah:
     * - State 0: berada di rumah
     * - State 1: berada di luar rumah dan pergi berlari
     * - State 2: berada di luar rumah dan sedang membeli kolak
     * 
     * 
     * State awal rumah adalah berada di dalam rumah
     * 
     * @param rumah      Objek rumah yang digunakan
     */
    public RumahCommand(Rumah rumah) {}
    
    /**
     * Mengeksekusi aktivitas untuk pintu sesuai dengan state
     * - Bila state sekarang = 0, maka akan pergi keluar rumah
     * - Bila state sekarang = 1, maka akan pergi berlari dan state berubah menjadi membeli kolak (laper)
     * - Bila state sekarang = 2, maka akan membeli kolak dan state berubah menjadi berlari
     * 
     */
    public void execute() {}

    /**
     * Mengembalikan pintu ke state semula
     * - Bila state sekarang selain 0, maka akan kembali masuk ke rumah
     */
    public void undo() {}
}
