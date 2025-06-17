import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GuildAccount {
    private final StringBuilder logBuilder; // untuk mencatat log yang masuk
    private final Lock lock; // lock untuk menghandle concurrency
    private int balance; // saldo kas guild
    

    public GuildAccount(int initialBalance) {
        // - lengkapi konstruktor nya
        // - Catatan: selalu ingat untuk instansiasi semua objek pada atribut kelas ini
        // - untuk lock yang digunakan, gunakan ReentrantLock dari package java.util.concurrent.locks
        this.balance = initialBalance;
        this.logBuilder = new StringBuilder();
        this.lock = new ReentrantLock();
    }

    /**
     * Melakukan deposit sejumlah uang ke kas guild.
     * ... (deskripsi ada di file)
     */
    public void deposit(Adventurer sender, int amount) throws FailedTransactionException {
        lock.lock();
        try {
            if (amount <= 0) {
                log(String.format("%s mencoba men-deposit, tetapi gagal karena jumlahnya tidak valid.", sender.getName()));
                throw new FailedTransactionException("Nilai yang di-depositkan tidak boleh 0 atau negatif");
            }
            
            int oldBalance = this.balance;
            this.balance += amount;
            log(String.format("%s men-depositkan uang sejumlah %d ke kas. Saldo lama: %d, Saldo baru: %d.", sender.getName(), amount, oldBalance, this.balance));
        } finally {
            lock.unlock();
        }
    }

    /**
     * Menarik sejumlah uang dari kas yang digunakan untuk keperluan tertentu
     * ... (deskripsi ada di file)
     */
    public void withdraw(Adventurer withdrawer, int amount, String purpose) throws FailedTransactionException {
        lock.lock();
        try {
            if (amount <= 0) {
                log(String.format("%s mencoba menarik uang dari kas, tetapi gagal karena jumlahnya tidak valid.", withdrawer.getName()));
                throw new FailedTransactionException("Nilai yang ditarik tidak boleh 0 atau negatif");
            }
            
            if (this.balance < amount) {
                log(String.format("%s mencoba menarik uang dari kas, tetapi gagal karena saldonya tidak cukup.", withdrawer.getName()));
                throw new FailedTransactionException("Saldo tidak cukup");
            }

            int oldBalance = this.balance;
            this.balance -= amount;
            log(String.format("%s menarik uang sejumlah %d dari kas untuk %s. Saldo lama: %d, Saldo baru: %d.", withdrawer.getName(), amount, purpose, oldBalance, this.balance));
        } finally {
            lock.unlock();
        }
    }

    /**
     * Memasukkan log ke dalam akun guild.
     * setiap entry baru harus ditandai dengan new line untuk memisahkan line pada log.
     * untuk menambahkan String baru ke dalam string builder, gunakan method append()
     */
    private void log(String entry) {
        this.logBuilder.append(entry).append("\n");
    }

    /**
     * Mengambil nilai saldo pada kas.
     * Pastikan concurrency control dengan menggunakan lock
     */
    public int getBalance() {
        lock.lock();
        try {
            return this.balance;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Melihat log pada kas.
     * Pastikan concurrency control dengan menggunakan lock
     * Gunakan method toString() untuk mendapatkan String dari StringBuilder
     */
    public String getLog() {
        lock.lock();
        try {
            return this.logBuilder.toString();
        } finally {
            lock.unlock();
        }
    }
}