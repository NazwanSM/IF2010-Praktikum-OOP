/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

public class ArraySum {
    // nWorkers menyatakan jumlah maksimum threads yang tersedia
    private int nWorkers;
    // array untuk menampung array masukan
    private Integer[] arr;
    /**
     * Tambahkan atribut kelas yang dibutuhkan
     */ 
    private int[] partialSums;

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    ArraySum(int nWorkers, Integer[] arr) {
        this.nWorkers = nWorkers;
        this.arr = arr;
        this.partialSums = new int[nWorkers];
    }

    /**
     * Implementasi
     * method sum akan membuat sejumlah thread dan memetakan array masukan secara merata ke semua threads yang dapat dibuat
     */
    public int sum() throws InterruptedException {
        if (arr.length == 0) {
            return 0;
        }
        
        int actualWorkers = Math.min(nWorkers, arr.length);
        Thread[] threads = new Thread[actualWorkers];
        
        // Calculate distribution
        int size = arr.length / actualWorkers;
        int extra = arr.length % actualWorkers;
        
        int start = 0;
        for (int i = 0; i < actualWorkers; i++) {
            final int workerIndex = i;
            final int startPos = start;
            int count = size + (i < extra ? 1 : 0);
            final int endPos = start + count;
            
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    partialSums[workerIndex] = partialSum(startPos, endPos);
                }
            });
            threads[i].start();
            
            start = endPos;
        }
        
        for (int i = 0; i < actualWorkers; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        int result = 0;
        for (int i = 0; i < actualWorkers; i++) {
            result += partialSums[i];
        }
        
        return result;
    }


    /**
     * Implementasi
     * method partialSum akan melakukan penjumlahan elemen-elemen array pada index `start` sampai `end-1`
     */
    protected int partialSum(int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}