public class Ngabuburit {
    public static int maxSameActivity = 3;

    public ICommand command;
    public int jenuhCounter;

    /**
     * Constructor untuk melakukan Ngabuburit
     * 
     * @param command     Aktivitas yang ingin dilakukan
     */
    public Ngabuburit(ICommand command) {}

    /**
     * Setter untuk mengubah aktivitas yang dilakukan
     * Counter jenuh akan kembali ke 0
     * 
     * @param command     Aktivitas yang ingin dilakukan
     */
    public void changeCommand(ICommand command) {}

    /**
     * Setter untuk mengubah aktivitas yang dilakukan dengan argumen string. 
     * Counter jenuh akan kembali ke 0
     * Pilihan command adalah "laptop", "pintu", atau "rumah"
     * 
     * @param command     Aktivitas yang ingin dilakukan dalam string
     */
    public void changeCommandStr(String command) {}

    /**
     * Method untuk melakukan aktivitas pada command. Jika command sudah dijalankan
     * lebih dari maxSameActivity, maka akan mencetak "Sudah jenuh! Lakukan aktivitas lain"
     * ke layar.
     */
    public void doStuff() {}
}
