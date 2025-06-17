import java.util.concurrent.atomic.AtomicInteger;

public class Hitung {
    static final int NUM_OF_THREAD = 10;

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Menghitung jumlah bilangan prima dari 1 hingga N (inklusif) secara konkuren.
     * @param N Batas atas pencarian.
     * @return Jumlah total bilangan prima.
     * @throws InterruptedException jika thread terganggu saat menunggu.
     */
    public int hitungPrima(int N) throws InterruptedException {
        // Menggunakan AtomicInteger untuk menjamin operasi penambahan yang aman dari race condition.
        AtomicInteger totalPrimes = new AtomicInteger(0);
        Thread[] threads = new Thread[NUM_OF_THREAD];
        int chunkSize = N / NUM_OF_THREAD;

        if (N < 2) {
            return 0;
        }

        // Membuat dan menjalankan 10 thread pekerja.
        for (int i = 0; i < NUM_OF_THREAD; i++) {
            // Menentukan rentang awal dan akhir untuk setiap thread.
            final int start = i * chunkSize + 1;
            // Thread terakhir akan menangani sisa pembagian.
            final int end = (i == NUM_OF_THREAD - 1) ? N : (i + 1) * chunkSize;

            // Membuat tugas (Runnable) untuk setiap thread.
            Runnable task = () -> {
                // Memanggil ThreadTracker.mark() sesuai requirement.
                ThreadTracker.mark();
                
                int localPrimeCount = 0;
                // Menghitung prima hanya pada rentang yang menjadi tugasnya.
                for (int j = start; j <= end; j++) {
                    if (isPrime(j)) {
                        localPrimeCount++;
                    }
                }
                // Menambahkan hasil hitungan lokal ke total keseluruhan secara atomik.
                totalPrimes.addAndGet(localPrimeCount);
            };

            threads[i] = new Thread(task);
            threads[i].start(); // Memulai eksekusi thread.
        }

        // Menunggu semua thread selesai menjalankan tugasnya.
        for (Thread thread : threads) {
            thread.join();
        }

        // Mengembalikan jumlah total bilangan prima yang ditemukan.
        return totalPrimes.get();
    }
}